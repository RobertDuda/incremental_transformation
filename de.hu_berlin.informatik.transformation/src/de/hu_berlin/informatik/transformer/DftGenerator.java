package de.hu_berlin.informatik.transformer;

import java.io.IOException;
import java.util.Collections;
//import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.informatik.dynamicFaultTree.*;

public class DftGenerator {
	
	//private ResourceSet resourceSet;
	//private Resource resource;
	private DFT dft;
	private DynamicFaultTreeFactory factory;
	
	private LinkedList<Gate> gateList;
	private LinkedList<Spare> spareGateList;
	private LinkedList<Event> eventList;
	private LinkedList<Dependency> dependencyList;
	private int gateName = 0;
	private int eventName = 0;
	private int dependencyName = 0;
	
	private int events;
	private int elementIdCounter = 0;
	private Random random;
	
	private int editNr = 0;
	
	public DftGenerator() {
		random = new Random();
		gateList = new LinkedList<Gate>();
		spareGateList = new LinkedList<Spare>();
		eventList = new LinkedList<Event>();
		dependencyList = new LinkedList<Dependency>();
	}
	
	public int getElementIdCounter() {
		int tmp = elementIdCounter;
		elementIdCounter++;
		return tmp;
	}
	
	public int getRandomGateType() {
		return random.nextInt(4)+1;
	}
	
	public String getGateName() {
		String tmp = "" + gateName;
		gateName++;
		//return "Gate " + tmp;
		return "" + tmp;
	}
	
	public String getEventName() {
		String tmp = "" + eventName;
		eventName++;
		//return "Event " + tmp;
		return "" + tmp;
	}
	
	public String getDependencyName() {
		String tmp = "" + dependencyName;
		dependencyName++;
		return "" + tmp;
	}
	
	public float getRandomEventProbability() {
		return random.nextFloat();
	}
	
	public int getSequencePosition(Gate gate) {
		int seqPos = gate.getChildEvent().size() + gate.getChildGate().size();
		return seqPos - 1;
	}
	
	public void generateDFT(String dftLocation, String dftName, int nrOfEvents, int eventToGateRatio, int nrOfDependencies) {
		System.out.println("starting generation...");
		
		String uri = dftLocation + dftName + ".dynamicfaulttree";
		
		events = nrOfEvents;
		
		System.out.println("creating dft...");
		//dft factory
		DynamicFaultTreePackage.eINSTANCE.eClass();
		factory = DynamicFaultTreeFactory.eINSTANCE;
		dft = factory.createDFT();
		
		//set name
		dft.setName(dftName);
		
		//create top level event
		System.out.println("creating tle...");
		TopLevelEvent tle = factory.createTopLevelEvent();
		dft.setTopLevelEvent(tle);
		tle.setElementID(getElementIdCounter());
		tle.setName("Top Level Event");
		
		//creating the first gate and setting it for the tle
		System.out.println("creating first gate...");
		//Gate tmp = null;
		switch (getRandomGateType()) {
		case 1:
			AND and = factory.createAND();
			and.setElementID(getElementIdCounter());
			and.setName(getGateName());
			gateList.add(and);
			and.setToplevelevent(tle);
			tle.setGate(and);
			//tmp =  and;
			break;
		case 2:
			OR or = factory.createOR();
			or.setElementID(getElementIdCounter());
			or.setName(getGateName());
			gateList.add(or);
			or.setToplevelevent(tle);
			tle.setGate(or);
			//tmp = or;
			break;
		case 3:
			PAND pand = factory.createPAND();
			pand.setElementID(getElementIdCounter());
			pand.setName(getGateName());
			gateList.add(pand);
			pand.setToplevelevent(tle);
			tle.setGate(pand);
			break;
		case 4:
			Spare spare = factory.createSpare();
			spare.setElementID(getElementIdCounter());
			spare.setName(getGateName());
			gateList.add(spare);
			spareGateList.add(spare);
			spare.setToplevelevent(tle);
			tle.setGate(spare);
			//tmp = spare;
			break;
		}
		//gateName++;
		
		//main loop
		System.out.println("starting main loop...");
		//int i = 0;
		ListIterator<Gate> gateListIterator = gateList.listIterator();
		main: while (events != 0) {
			if (gateListIterator.hasNext()) {
				Gate tmpGate = gateListIterator.next();
				//int sequencePosition = 0;
				while (random.nextBoolean()) {
					if (tmpGate.getChildEvent().size() < 1) { //TODO remove this case
						System.out.println("first event");
						
						Event newEvent = createEvent();
						
						newEvent.setParentGate(tmpGate);
						tmpGate.getChildEvent().add(newEvent);
						
						newEvent.setSequencePosition(getSequencePosition(tmpGate));
						//sequencePosition++;
						
						eventList.add(newEvent);
						//eventName++;
						
						events--;
					}else if (events < 2) {
						System.out.println("last events");
						//create two events and break 
						//TODO check if this is a good reasin to stop
						Event newEvent1 = createEvent();
						
						newEvent1.setParentGate(tmpGate);
						tmpGate.getChildEvent().add(newEvent1);
						if (tmpGate.eClass().getName().compareTo("Spare") == 0) {
							int index = spareGateList.indexOf(tmpGate);
							spareGateList.get(index).getSpares().add(newEvent1);
						}
						
						newEvent1.setSequencePosition(getSequencePosition(tmpGate));
						eventList.add(newEvent1);
						//eventName++;
						
						/*-----------------------------*/
						
						Event newEvent2 = createEvent();
						
						newEvent2.setParentGate(tmpGate);
						tmpGate.getChildEvent().add(newEvent2);
						if (tmpGate.eClass().getName().compareTo("Spare") == 0) {
							int index = spareGateList.indexOf(tmpGate);
							spareGateList.get(index).getSpares().add(newEvent2);
						}
						
						newEvent2.setSequencePosition(getSequencePosition(tmpGate));
						eventList.add(newEvent2);
						//eventName++;
						
						break main;
					}else {
						System.out.println("case gate");
						int ratio = random.nextInt(eventToGateRatio) + 1;
						if (ratio == 1 && (tmpGate.eClass().getName().compareTo("Spare") != 0)) {
							System.out.println("case gate");
							Gate newGate = createGate();
							
							tmpGate.getChildGate().add(newGate);
							//newGate.setParentGate(tmpGate);
							
							newGate.setSequencePosition(getSequencePosition(tmpGate));
							//sequencePosition++;
							
							//gateList.add(newGate);
							gateListIterator.add(newGate);
							gateListIterator.previous();
							//gateListIterator.previous();
							//gateName++;
							
						    /*//add an events (later add another one/or gate, because one makes little sense...)
							Event newEvent = createEvent();
							
							newEvent.setParentGate(newGate);
							newGate.getChildEvent().add(newEvent);
							/*if (newGate.eClass().getName().compareTo("Spare") == 0) {
								int index = spareGateList.indexOf(newGate);
								spareGateList.get(index).getSpares().add(newEvent);
							}
							
							newEvent.setSequencePosition(getSequencePosition(newGate));
							eventList.add(newEvent);
							
							events--;*/
							
						}else {
							//event
							System.out.println("case event");
							Event newEvent = createEvent();
							
							newEvent.setParentGate(tmpGate);
							tmpGate.getChildEvent().add(newEvent);
							if (tmpGate.eClass().getName().compareTo("Spare") == 0) {
								int index = spareGateList.indexOf(tmpGate);
								spareGateList.get(index).getSpares().add(newEvent);
							}
							
							newEvent.setSequencePosition(getSequencePosition(tmpGate));
							//sequencePosition++;
							
							eventList.add(newEvent);
							//eventName++;
							
							events--;
						}
					}					
				}
			}else {
				gateListIterator = gateList.listIterator();
			}
			//events--;
		}
		
		//clean up
		for (int i = 0; i < gateList.size(); i++) {
			System.out.println("cleaning up");
			/*if (gateList.get(i).getChildEvent().isEmpty()) {
				gateList.remove(i);
			}*/
			if (gateList.get(i).getChildEvent().size() + gateList.get(i).getChildGate().size() < 2) {
				//add another event, one event/gate makes no sense
				Event newEvent1 = createEvent();
				
				newEvent1.setParentGate(gateList.get(i));
				gateList.get(i).getChildEvent().add(newEvent1);
				if (gateList.get(i).eClass().getName().compareTo("Spare") == 0) {
					if (gateList.get(i).getChildEvent().size() != 1) {
						int index = spareGateList.indexOf(gateList.get(i));
						spareGateList.get(index).getSpares().add(newEvent1);
					}else {
						System.out.println("not a spare");
					}
				}
				
				newEvent1.setSequencePosition(getSequencePosition(gateList.get(i)));
				eventList.add(newEvent1);
				
				//add another one if there is still only one child
				if (gateList.get(i).getChildEvent().size() + gateList.get(i).getChildGate().size() == 1) {
					//add another event, one event/gate makes no sense
					Event newEvent2 = createEvent();
					
					newEvent2.setParentGate(gateList.get(i));
					gateList.get(i).getChildEvent().add(newEvent2);
					if (gateList.get(i).eClass().getName().compareTo("Spare") == 0) {
						int index = spareGateList.indexOf(gateList.get(i));
						spareGateList.get(index).getSpares().add(newEvent2);
					}
					
					newEvent2.setSequencePosition(getSequencePosition(gateList.get(i)));
					eventList.add(newEvent2);
				}
			}
		}
		
		//adding dependencies
		if (nrOfDependencies != 0) {
			System.out.println("creating dependencies...");
		}
		for (int i = 0; i < nrOfDependencies; i++) {
			dft.getDependencies().add(createDependency());
		}
		
		//safe the model
		System.out.println("saving the model...");
		Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
		registry.getExtensionToFactoryMap().put("dynamicfaulttree", new XMIResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		//resourceSet.getPackageRegistry().put(DynamicFaultTreePackage.eNS_URI, DynamicFaultTreePackage.eINSTANCE);
		//resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().put("dynamicfaulttree", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createURI(uri));
		
		//add the ctmc as content to the resource
		System.out.println(dft);
		resource.getContents().add(dft);
		
		//try to save it
		try {
			//resource.save(Collections.EMPTY_MAP );;
			dft.eResource().save(null);
			System.out.println("success!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}		
		System.out.println("end");
	}
	
	public Gate createGate() {
		switch (getRandomGateType()) {
		case 1:
			AND and = factory.createAND();
			and.setElementID(getElementIdCounter());
			and.setName(getGateName());
			
			return and;
		case 2:
			OR or = factory.createOR();
			or.setElementID(getElementIdCounter());
			or.setName(getGateName());
			
			return or;
		case 3:
			PAND pand = factory.createPAND();
			pand.setElementID(getElementIdCounter());
			pand.setName(getGateName());
			
			return pand;
		case 4:
			Spare spare = factory.createSpare();
			spare.setElementID(getElementIdCounter());
			spare.setName(getGateName());
			
			spareGateList.add(spare);
			
			return spare;
		}
		
		return null;
	}
	
	public Event createEvent() {
		Event event = factory.createEvent();
		event.setElementID(getElementIdCounter());
		event.setName(getEventName());
		event.setProbability(getRandomEventProbability());
		
		//eventList.add(event);
		return event;
	}
	
	public Dependency createDependency() {
		switch (random.nextInt(2) + 1) {
		case 1: //sequence
			Sequence sequence = factory.createSequence();
			sequence.setElementID(getElementIdCounter());
			sequence.setName(getDependencyName());
			dependencyList.add(sequence);
			
			int i = 0;
			//adding random events
			while (true) {
				int randomEvent = random.nextInt(eventList.size());
				if (!sequence.getEvents().contains(eventList.get(randomEvent))) {
					sequence.getEvents().add(eventList.get(randomEvent));
				}
				
				if (i > 1) {
					if (random.nextBoolean() || i == sequence.getEvents().size()) {
						break;
					}
				}
				i++;
			}
			
			return sequence;
		case 2: //functional dependency
			FunctionalDependency functionalDependency = factory.createFunctionalDependency();
			
			functionalDependency.setElementID(getElementIdCounter());
			functionalDependency.setName(getDependencyName());
			dependencyList.add(functionalDependency);
			
			int j = 0;
			//adding random events
			while (true) {
				int randomEvent = random.nextInt(eventList.size());
				if (!functionalDependency.getEvents().contains(eventList.get(randomEvent))) {
					functionalDependency.getEvents().add(eventList.get(randomEvent));
				}
				
				if (j > 1) {
					if (random.nextBoolean() || j == functionalDependency.getEvents().size()) {
						break;
					}
				}
				j++;
			}
			
			return functionalDependency;
		}
		
		return null;
	}
	
	public void outputListsToConsole() {
		System.out.println("DFT: " + dft.getName());
		
		System.out.println("TLE: " + dft.getTopLevelEvent().getName());
		
		System.out.println("gate list... ");
		for(int i = 0; i < gateList.size(); i++) {
			System.out.println(gateList.get(i).getName());
		}
		System.out.println("event list... ");
		for(int j = 0; j < eventList.size(); j++) {
			System.out.println(eventList.get(j).getName());
		}
		System.out.println("dependency list... ");
		for(int k = 0; k < dependencyList.size(); k++) {
			System.out.println(dependencyList.get(k).getName());
		}
	}
	
	public void editRandomly(int nrOfChanges, int nrOfDependencies, String uri) {
		
		for (int i = 0; i < nrOfChanges; i++) {
			//make a change to a gate, event or dependency
			int value = random.nextInt(10) + 1;
			if (value > 0 && value < 5) { //gate
				System.out.println("case gate");
				int randomGate = random.nextInt(gateList.size());
				int randomChange = random.nextInt(7) + 1;
				switch (randomChange) {
				case 1: //add event
					Event newEvent = createEvent();
					
					newEvent.setParentGate(gateList.get(randomGate));
					gateList.get(randomGate).getChildEvent().add(newEvent);
					if (gateList.get(randomGate).eClass().getName().compareTo("Spare") == 0) {
						int index = spareGateList.indexOf(gateList.get(randomGate));
						spareGateList.get(index).getSpares().add(newEvent);
					}
					
					newEvent.setSequencePosition(getSequencePosition(gateList.get(randomGate)));
					System.out.println("added new event " + newEvent.getName() + " to gate " + gateList.get(randomGate).getName());
					
					break;
				case 2: // add gate
					if (gateList.get(randomGate).eClass().getName().compareTo("Spare") == 0) {
						System.out.println("can't add a gate since gate " + gateList.get(randomGate).getName() + " is a Spare gate");
						break;
					}
					Gate newGate = createGate();
					
					gateList.get(randomGate).getChildGate().add(newGate);
					gateList.add(newGate);
					//newGate.setParentGate(tmpGate);
					
					newGate.setSequencePosition(getSequencePosition(gateList.get(randomGate)));
					System.out.println("added new gate " + newGate.getName() + " to gate " + gateList.get(randomGate).getName());
					
					break;
				case 3: // remove event
					int removeEvent = random.nextInt(gateList.get(randomGate).getChildEvent().size());
					System.out.println("removed event " + gateList.get(randomGate).getChildEvent().get(removeEvent).getName() 
							+ " from gate " + gateList.get(randomGate).getName());
					
					int sequence = gateList.get(randomGate).getChildEvent().get(removeEvent).getSequencePosition();
					int removeEventIndex = eventList.indexOf(gateList.get(randomGate).getChildEvent().get(removeEvent));
					eventList.remove(removeEventIndex);
					gateList.get(randomGate).getChildEvent().remove(removeEvent);
					
					
					//check for spares
					if (gateList.get(randomGate).eClass().getName().compareTo("Spare") == 0) {
						if (removeEvent == 0) {
							int spareGateIndex = spareGateList.indexOf(gateList.get(randomGate));
							spareGateList.get(spareGateIndex).getSpares().remove(0);
							System.out.println(gateList.get(randomGate).getName() + " was a Spare gate and " 
							+ gateList.get(randomGate).getChildEvent().get(0).getName() + " is not a spare anymore");
						}
					}
					//update sequence
					for (int j = 0; j < gateList.get(randomGate).getChildEvent().size(); j++) {
						if (gateList.get(randomGate).getChildEvent().get(j).getSequencePosition() > sequence) {
							gateList.get(randomGate).getChildEvent().get(j).setSequencePosition(gateList.get(randomGate).getChildEvent().get(j).getSequencePosition() -1);
						}
					}
					for (int j = 0; j < gateList.get(randomGate).getChildGate().size(); j++) {
						if (gateList.get(randomGate).getChildGate().get(j).getSequencePosition() > sequence) {
							gateList.get(randomGate).getChildGate().get(j).setSequencePosition(gateList.get(randomGate).getChildGate().get(j).getSequencePosition() -1);
						}
					}
					System.out.println("updated sequence positions");
					
					break;
				case 4: //remove gate
					if (gateList.get(randomGate).getToplevelevent() != null) {
						System.out.println("top level event gate, not removing");
						break;
					}
					if (gateList.get(randomGate).getChildGate().isEmpty()) {
						System.out.println("child gate list is empty, nothing to remove");
					}else {
						int removeGate = random.nextInt(gateList.get(randomGate).getChildGate().size());
						System.out.println("removed gate " + gateList.get(randomGate).getChildGate().get(removeGate).getName() + " and all it's children from gate"
								+ gateList.get(randomGate).getName());
						
						int sequencePos = gateList.get(randomGate).getChildGate().get(removeGate).getSequencePosition();
						gateList.get(randomGate).getChildGate().remove(removeGate);
						
						//update sequence
						for (int j = 0; j < gateList.get(randomGate).getChildEvent().size(); j++) {
							if (gateList.get(randomGate).getChildEvent().get(j).getSequencePosition() > sequencePos) {
								gateList.get(randomGate).getChildEvent().get(j).setSequencePosition(gateList.get(randomGate).getChildEvent().get(j).getSequencePosition() -1);
							}
						}
						for (int j = 0; j < gateList.get(randomGate).getChildGate().size(); j++) {
							if (gateList.get(randomGate).getChildGate().get(j).getSequencePosition() > sequencePos) {
								gateList.get(randomGate).getChildGate().get(j).setSequencePosition(gateList.get(randomGate).getChildGate().get(j).getSequencePosition() -1);
							}
						}
						System.out.println("updated sequence positions");
						
						//TODO remove all references
						removeChildrenFromLists(gateList.get(removeGate));
					}
					
					break;
				case 5: //change name
					String oldName = gateList.get(randomGate).getName();
					gateList.get(randomGate).setName(getGateName());
					System.out.println("changed gate name from " + oldName +" to " + gateList.get(randomGate).getName());
					break;
				case 6: //swap sequence position
					if (gateList.indexOf(gateList.get(randomGate)) != 0) {
						int gateSeqPos = gateList.get(randomGate).getSequencePosition();
						int randomSeqPos =random.nextInt(gateList.get(randomGate).getParentGate().getChildEvent().size() 
								+ gateList.get(randomGate).getParentGate().getChildGate().size());
						
						//check if an event has the random sequence position
						boolean foundSeq = false;
						for (int j = 0; j < gateList.get(randomGate).getParentGate().getChildEvent().size(); j++) {
							if (gateList.get(randomGate).getParentGate().getChildEvent().get(j).getSequencePosition() == randomSeqPos) {
								int tmp = gateSeqPos;
								gateList.get(randomGate).setSequencePosition(randomSeqPos);
								gateList.get(randomGate).getParentGate().getChildEvent().get(j).setSequencePosition(tmp);
								
								System.out.println("swapped sequence positions of gate " + gateList.get(randomGate).getName() 
										+ " and event " + gateList.get(randomGate).getParentGate().getChildEvent().get(j).getName());
								
								foundSeq = true;
								break;
							}
						}
						if (foundSeq == false) {
							for (int j = 0; j < gateList.get(randomGate).getParentGate().getChildGate().size(); j++) {
								if (gateList.get(randomGate).getParentGate().getChildGate().get(j).getSequencePosition() == randomSeqPos) {
									int tmp = gateSeqPos;
									gateList.get(randomGate).setSequencePosition(randomSeqPos);
									gateList.get(randomGate).getParentGate().getChildGate().get(j).setSequencePosition(tmp);
									
									System.out.println("swapped sequence positions of gate " + gateList.get(randomGate).getName() 
											+ " and gate" + gateList.get(randomGate).getParentGate().getChildGate().get(j).getName());
									
									break;
								}
							}
						}
					}else {
						System.out.println("no sequence for gate " + gateList.get(randomGate).getName() + "(TLE)");
					}
					
					break;
				case 7: //change type
					switch (getRandomGateType()) {
					case 1: //and
						if (gateList.get(randomGate).eClass().getName().compareTo("AND") != 0) {
							AND and = factory.createAND();
							and.setElementID(gateList.get(randomGate).getElementID());
							and.setName(gateList.get(randomGate).getName());
							and.setSequencePosition(gateList.get(randomGate).getSequencePosition());
							
							and.getChildEvent().addAll(gateList.get(randomGate).getChildEvent());
							and.getChildGate().addAll(gateList.get(randomGate).getChildGate());
							
							//parent gate
							Gate parent = gateList.get(randomGate).getParentGate();
							if (parent != null) {
								parent.getChildGate().set(
										parent.getChildGate().indexOf(gateList.get(randomGate)), and);
								and.setParentGate(parent);
							}
							/*parent.getChildGate().set(
									gateList.get(randomGate).getParentGate().getChildGate().indexOf(gateList.get(randomGate)), and);
							and.setParentGate(parent);*/
							
							//TLE
							TopLevelEvent tle = gateList.get(randomGate).getToplevelevent();
							and.setToplevelevent(tle);
							if (tle != null) {
								tle.setGate(and);
							}
							//tle.setGate(and);
							
							//gateList
							gateList.set(randomGate, and);
							
							System.out.println("changed gate type of " + gateList.get(randomGate) + "to AND");
						}else {
							System.out.println(gateList.get(randomGate).getName() + " is already an AND gate");
						}
						
						break;
					case 2: //or
						if (gateList.get(randomGate).eClass().getName().compareTo("OR") != 0) {
							OR or = factory.createOR();
							or.setElementID(gateList.get(randomGate).getElementID());
							or.setName(gateList.get(randomGate).getName());
							or.setSequencePosition(gateList.get(randomGate).getSequencePosition());
							
							or.getChildEvent().addAll(gateList.get(randomGate).getChildEvent());
							or.getChildGate().addAll(gateList.get(randomGate).getChildGate());
							
							//parent gate
							Gate parent = gateList.get(randomGate).getParentGate();
							if (parent != null) {
								parent.getChildGate().set(
										parent.getChildGate().indexOf(gateList.get(randomGate)), or);
								or.setParentGate(parent);
							}
							
							//TLE
							TopLevelEvent tle = gateList.get(randomGate).getToplevelevent();
							or.setToplevelevent(tle);
							if (tle != null) {
								tle.setGate(or);
							}
							//tle.setGate(or);
							
							//gateList
							gateList.set(randomGate, or);
							
							System.out.println("changed gate type of " + gateList.get(randomGate) + "to OR");
						}else {
							System.out.println(gateList.get(randomGate).getName() + " is already an OR gate");
						}
						
						break;
					case 3: //pand
						if (gateList.get(randomGate).eClass().getName().compareTo("PAND") != 0) {
							PAND pand = factory.createPAND();
							pand.setElementID(gateList.get(randomGate).getElementID());
							pand.setName(gateList.get(randomGate).getName());
							pand.setSequencePosition(gateList.get(randomGate).getSequencePosition());
							
							pand.getChildEvent().addAll(gateList.get(randomGate).getChildEvent());
							pand.getChildGate().addAll(gateList.get(randomGate).getChildGate());
							
							//parent gate
							Gate parent = gateList.get(randomGate).getParentGate();
							if (parent != null) {
								parent.getChildGate().set(
										parent.getChildGate().indexOf(gateList.get(randomGate)), pand);
								pand.setParentGate(parent);
							}
							/*parent.getChildGate().set(
									gateList.get(randomGate).getParentGate().getChildGate().indexOf(gateList.get(randomGate)), pand);
							pand.setParentGate(parent);*/
							
							//TLE
							TopLevelEvent tle = gateList.get(randomGate).getToplevelevent();
							pand.setToplevelevent(tle);
							if (tle != null) {
								tle.setGate(pand);
							}
							//tle.setGate(pand);
							
							//gateList
							gateList.set(randomGate, pand);
							
							System.out.println("changed gate type of " + gateList.get(randomGate) + "to PAND");
						}else {
							System.out.println(gateList.get(randomGate).getName() + " is already an PAND gate");
						}
						
						break;
					case 4: //spare
						if (gateList.get(randomGate).eClass().getName().compareTo("Spare") != 0) {
							Spare spare = factory.createSpare();
							spare.setElementID(gateList.get(randomGate).getElementID());
							spare.setName(gateList.get(randomGate).getName());
							spare.setSequencePosition(gateList.get(randomGate).getSequencePosition());
							
							spare.getChildEvent().addAll(gateList.get(randomGate).getChildEvent());
							//spare.getChildGate().addAll(gateList.get(randomGate).getChildGate());
							for (int j = 0; j < gateList.get(randomGate).getChildGate().size(); j++) {
								removeChildrenFromLists(gateList.get(randomGate).getChildGate().get(j));
							}
							System.out.println("removed child gates from " + gateList.get(randomGate).getName());
							//set spares
							if (spare.getChildEvent().size() > 1) {
								spare.getSpares().addAll(spare.getChildEvent());
								//remove the first gate from the list
								spare.getSpares().remove(0);
							}
							
							//parent gate
							Gate parent = gateList.get(randomGate).getParentGate();
							if (parent != null) {
								parent.getChildGate().set(
										parent.getChildGate().indexOf(gateList.get(randomGate)), spare);
								spare.setParentGate(parent);
							}
							/*parent.getChildGate().set(
									gateList.get(randomGate).getParentGate().getChildGate().indexOf(gateList.get(randomGate)), spare);
							spare.setParentGate(parent);*/
							
							//TLE
							TopLevelEvent tle = gateList.get(randomGate).getToplevelevent();
							spare.setToplevelevent(tle);
							if (tle != null) {
								tle.setGate(spare);
							}
							//tle.setGate(spare);
							
							//gateList
							gateList.set(randomGate, spare);
							
							System.out.println("changed gate type of " + gateList.get(randomGate).getName() + "to Spare");
						}else {
							System.out.println(gateList.get(randomGate).getName() + " is already an Spare gate");
						}
						
						break;
					}
					
					break;
				}
				
			}else if (value == 5) { //dependency
				System.out.println("case dependency");
				int randomDependency = random.nextInt(dependencyList.size());
				int randomEvent1 = random.nextInt(dependencyList.get(randomDependency).getEvents().size());
				int randomEvent2 = random.nextInt(dependencyList.get(randomDependency).getEvents().size());
				if (randomEvent1 == randomEvent2) {
					System.out.println("random events are the same events, nothing to change");
					break;
				}
				
				//Collections.swap(dependencyList.get(randomDependency).getEvents(), randomEvent1, randomEvent2);
				ECollections.move(dependencyList.get(randomDependency).getEvents(), randomEvent1, randomEvent2);
				
				System.out.println("swaped event " + dependencyList.get(randomDependency).getEvents().get(randomEvent2).getName()
						+ " with event " + dependencyList.get(randomDependency).getEvents().get(randomEvent2).getName() 
						+ " in dependency " + dependencyList.get(randomDependency).getName());
			}else { //event
				System.out.println("case event");
				int randomEvent = random.nextInt(eventList.size());
				int randomChange = random.nextInt(3) + 1;
				switch (randomChange) {
				case 1: //change name
					String oldName = eventList.get(randomEvent).getName();
					eventList.get(randomEvent).setName(getEventName());
					System.out.println("changed event name from " + oldName +" to " + eventList.get(randomEvent).getName());
					
					break;
				case 2: //swap sequence position
					/*if (!eventList.get(randomEvent).getDependency().isEmpty()) {
						int randomDependency = random.nextInt(eventList.get(randomEvent).getDependency().size());
						int indexOfEvent = dependencyList.get(randomDependency).getEvents().indexOf(eventList.get(randomEvent));
						int indexOfOtherEvent = random.nextInt(dependencyList.get(randomDependency).getEvents().size());
						Collections.swap(dependencyList.get(randomDependency).getEvents(), indexOfEvent, indexOfOtherEvent);
						System.out.println("swaped event " + eventList.get(randomEvent).getName()
								+ " with " + dependencyList.get(randomDependency).getEvents().get(indexOfOtherEvent).getName() 
								+ " in dependency " + eventList.get(randomEvent).getDependency().get(randomDependency).getName());
					}else {
						System.out.println("event " + eventList.get(randomEvent).getName() + " has no dependency");
					}*/
					int eventSeqPos = eventList.get(randomEvent).getSequencePosition();
					int randomSeqPos =random.nextInt(eventList.get(randomEvent).getParentGate().getChildEvent().size() 
							+ eventList.get(randomEvent).getParentGate().getChildGate().size());
					
					//check if an event has the random sequence position
					boolean foundSeq = false;
					for (int j = 0; j < eventList.get(randomEvent).getParentGate().getChildEvent().size(); j++) {
						if (eventList.get(randomEvent).getParentGate().getChildEvent().get(j).getSequencePosition() == randomSeqPos) {
							int tmp = eventSeqPos;
							eventList.get(randomEvent).setSequencePosition(randomSeqPos);
							eventList.get(randomEvent).getParentGate().getChildEvent().get(j).setSequencePosition(tmp);
							
							System.out.println("swapped sequence positions of event " + eventList.get(randomEvent).getName() 
									+ " and event " + eventList.get(randomEvent).getParentGate().getChildEvent().get(j).getName());
							
							foundSeq = true;
							break;
						}
					}
					if (foundSeq == false) {
						for (int j = 0; j < eventList.get(randomEvent).getParentGate().getChildGate().size(); j++) {
							if (eventList.get(randomEvent).getParentGate().getChildGate().get(j).getSequencePosition() == randomSeqPos) {
								int tmp = eventSeqPos;
								eventList.get(randomEvent).setSequencePosition(randomSeqPos);
								eventList.get(randomEvent).getParentGate().getChildGate().get(j).setSequencePosition(tmp);
								
								System.out.println("swapped sequence positions of event" + eventList.get(randomEvent).getName() 
										+ " and gate " + eventList.get(randomEvent).getParentGate().getChildGate().get(j).getName());
								
								break;
							}
						}
					}
					
					
					break;
				case 3: //change probability
					float oldProbability = eventList.get(randomEvent).getProbability();
					eventList.get(randomEvent).setProbability(random.nextFloat());
					System.out.println("changed event "  + eventList.get(randomEvent).getName() 
					+ "s probability from " + oldProbability +" to " + eventList.get(randomEvent).getProbability());
					
					break;
				}
			}
			
		}
		
		//clean up
		for (int i = 0; i < gateList.size(); i++) {
			System.out.println("cleaning up");
			/*if (gateList.get(i).getChildEvent().isEmpty()) {
				gateList.remove(i);
			}*/
			if (gateList.get(i).getChildEvent().size() + gateList.get(i).getChildGate().size() < 2) {
				//add another event, one event/gate makes no sense
				Event newEvent1 = createEvent();
				
				newEvent1.setParentGate(gateList.get(i));
				gateList.get(i).getChildEvent().add(newEvent1);
				if (gateList.get(i).eClass().getName().compareTo("Spare") == 0) {
					if (gateList.get(i).getChildEvent().size() != 1) {
						int index = spareGateList.indexOf(gateList.get(i));
						spareGateList.get(index).getSpares().add(newEvent1); //TODO
					}else {
						System.out.println("not a spare");
					}
				}
				
				newEvent1.setSequencePosition(getSequencePosition(gateList.get(i)));
				eventList.add(newEvent1);
				
				//add another one if there is still only one child
				if (gateList.get(i).getChildEvent().size() + gateList.get(i).getChildGate().size() == 1) {
					//add another event, one event/gate makes no sense
					Event newEvent2 = createEvent();
					
					newEvent2.setParentGate(gateList.get(i));
					gateList.get(i).getChildEvent().add(newEvent2);
					if (gateList.get(i).eClass().getName().compareTo("Spare") == 0) {
						int index = spareGateList.indexOf(gateList.get(i));
						spareGateList.get(index).getSpares().add(newEvent2);
					}
					
					newEvent2.setSequencePosition(getSequencePosition(gateList.get(i)));
					eventList.add(newEvent2);
				}
			}
		}
		
		//adding dependencies
		if (nrOfDependencies != 0) {
			System.out.println("creating dependencies...");
		}
		for (int i = 0; i < nrOfDependencies; i++) {
			dft.getDependencies().add(createDependency());
		}
		
		//safe the model
		System.out.println("saving the model...");
		Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
		registry.getExtensionToFactoryMap().put("dynamicfaulttree", new XMIResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI(uri));
				
		//add the ctmc as content to the resource
		//System.out.println(dft);
		resource.getContents().add(dft);
		
		//try to save it
		try {
			//resource.save(Collections.EMPTY_MAP );;
			dft.eResource().save(null);
			System.out.println("success!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}		
		System.out.println("end");
		
		editNr++;
	}
	
	public void removeChildrenFromLists(Gate gate) {
		for (int i = 0; i < gate.getChildEvent().size(); i++) {
			//remove references from dependencies
			if (!gate.getChildEvent().get(i).getDependency().isEmpty()) {
				for (int j = 0; j < gate.getChildEvent().get(i).getDependency().size(); j++) {
					gate.getChildEvent().get(i).getDependency().get(j).getEvents().remove(gate.getChildEvent().get(i));
					gate.getChildEvent().get(i).getDependency().remove(j);
				}
			}
			eventList.remove(gate.getChildEvent().get(i));
		}
		for (int i = 0; i < gate.getChildGate().size(); i++) {
			removeChildrenFromLists(gate.getChildGate().get(i));
		}
		gateList.remove(gate);
	}
}
