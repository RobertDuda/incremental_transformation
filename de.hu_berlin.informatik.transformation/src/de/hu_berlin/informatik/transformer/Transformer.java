 package de.hu_berlin.informatik.transformer;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.informatik.ctmc.model.ctmc.CTMC;
import de.hu_berlin.informatik.ctmc.model.ctmc.CtmcFactory;
import de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage;
import de.hu_berlin.informatik.ctmc.model.ctmc.Label;
import de.hu_berlin.informatik.ctmc.model.ctmc.State;
import de.hu_berlin.informatik.ctmc.model.ctmc.Transition;
import de.hu_berlin.informatik.dynamicFaultTree.*;

/**
 * @author Robert Duda
 * The Transformation class prepares the fault tree by extracting information from its structure and filling lists for manipulation.
 * It creates a truth table according to the basic events, applies the logic of the gates and dependencies on the truth table. The table represents the states in the new CTMC.
 * Then it creates a list of transitions by comparing the states, looking for differences, and applying priority gate and dependency rules.
 * The last step is to construct a new CTMC, fill it with the information of the lists and save it.
 */
public class Transformer {
	
	//dft information
	private String dftName;
	
	//saves the tree elements for manipulation
	private LinkedList<Gate> gateList;
	private LinkedList<Event> eventList;
	private LinkedList<Dependency> dependencyList;
	private LinkedList<Sequence> seqList;
	private LinkedList<FunctionalDependency> fDepList;
	
	//queues for the transformation
	private Queue<Gate> gateQueue;
	private Queue<Event> eventQueue;
	private Queue<Dependency> dependencyQueue;
	
	//saving data for the transformation
	private LinkedList<int[]> stateList;
	private LinkedList<int[]> transitionList;
	private LinkedList<boolean[]> failSafeList;
	private LinkedList<boolean[]> seqFailList;
	private LinkedList<int[]> fDepTransition;
	
	//for merging states
	LinkedList<Integer> endStates;
	
	//data for the incremental transformation
	//old dft data
	private String oldDftName;
		
	//saves the tree elements for manipulation
	private LinkedList<Gate> oldGateList;
	private LinkedList<Event> oldEventList;
	private LinkedList<Dependency> oldDependencyList;
	private LinkedList<Sequence> oldSeqList;
	private LinkedList<FunctionalDependency> oldFDepList;
		
	//queues for the transformation
	private Queue<Gate> oldGateQueue;
	private Queue<Event> oldEventQueue;
	private Queue<Dependency> oldDependencyQueue;
	
	//Lists for the incremental transformation
	private LinkedList<int[]> oldStateList;
	private LinkedList<Difference> differenceList;
	private LinkedList<int[]> oldTransitionList;
	private LinkedList<int[]> oldFdepTransitionList;

	
	
	public Transformer() {
		
		gateList = new LinkedList<>();
		eventList = new LinkedList<>();
		dependencyList = new LinkedList<>();
		seqList = new LinkedList<>();
		fDepList = new LinkedList<>();
		
		gateQueue = new LinkedList<>();
		eventQueue = new LinkedList<>();
		dependencyQueue = new LinkedList<>();
		
		stateList = new LinkedList<int[]>();
		transitionList = new LinkedList<int[]>();
		failSafeList = new LinkedList<boolean[]>();
		seqFailList = new LinkedList<boolean[]>();	
		fDepTransition = new LinkedList<int[]>();
		
		endStates = new LinkedList<Integer>();
		
		//TODO not always needed, move to method
		oldGateList = new LinkedList<>();
		oldEventList = new LinkedList<>();
		oldDependencyList = new LinkedList<>();
		oldSeqList = new LinkedList<>();
		oldFDepList = new LinkedList<>();
		
		oldGateQueue = new LinkedList<>();
		oldEventQueue = new LinkedList<>();
		oldDependencyQueue = new LinkedList<>();
		
		oldStateList = new LinkedList<int[]>();	
		differenceList = new LinkedList<Difference>();
		oldTransitionList = new LinkedList<int[]>();
		oldFdepTransitionList = new LinkedList<int[]>();
		
	}
	
	//gatters
	public LinkedList<Gate> getGateList() {
		return gateList;
	}

	public LinkedList<Event> getEventList() {
		return eventList;
	}

	public LinkedList<Dependency> getDependencyList() {
		return dependencyList;
	}
	
	public LinkedList<Sequence> getSeqList() {
		return seqList;
	}
	
	public LinkedList<FunctionalDependency> getFunctionalDependencyList(){
		return fDepList;
	}
	
	public LinkedList<int[]> getFepTransition(){
		return fDepTransition;
	}
	
	public void setFdepTransitionList(LinkedList<int[]> fdepList) {
		fDepTransition = fdepList;
	}
	
	public Queue<Gate> getGateQueue() {
		return gateQueue;
	}

	public Queue<Event> getEventQueue() {
		return eventQueue;
	}

	public Queue<Dependency> getDependencyQueue() {
		return dependencyQueue;
	}
	
	public LinkedList<int[]> getStateList() {
		return stateList;
	}
	
	public LinkedList<int[]> getTransitionList() {
		return transitionList;
	}
	
	/**
	 * @param oldTransitionList the oldTransitionList to set
	 */
	public void setTransitionList(LinkedList<int[]> transList) {
		transitionList = transList;
	}
	
	//getters for the old dft
	//getters
	public LinkedList<Gate> getOldGateList() {
		return oldGateList;
	}

	public LinkedList<Event> getOldEventList() {
		return oldEventList;
	}

	public LinkedList<Dependency> getOldDependencyList() {
		return oldDependencyList;
	}
		
	public LinkedList<Sequence> getOldSeqList() {
		return oldSeqList;
	}
		
	public LinkedList<FunctionalDependency> getOldFunctionalDependencyList(){
		return oldFDepList;
	}
		
	public Queue<Gate> getOldGateQueue() {
		return oldGateQueue;
	}

	public Queue<Event> getOldEventQueue() {
		return oldEventQueue;
	}

	public Queue<Dependency> getOldDependencyQueue() {
		return oldDependencyQueue;
	}
	
	public LinkedList<int[]> getOldStateList() {
		return oldStateList;
	}

	public void setStateList(LinkedList<int[]> stateList) {
		this.stateList = stateList;
	}
	
	public void setOldStateList(LinkedList<int[]> oldStateList) {
		this.oldStateList = oldStateList;
	}

	/**
	 * @return the differenceList
	 */
	public LinkedList<Difference> getDifferenceList() {
		return differenceList;
	}

	/**
	 * @param differenceList the differenceList to set
	 */
	public void setDifferenceList(LinkedList<Difference> differenceList) {
		this.differenceList = differenceList;
	}

	/**
	 * @return the oldTransitionList
	 */
	public LinkedList<int[]> getOldTransitionList() {
		return oldTransitionList;
	}

	/**
	 * @param oldTransitionList the oldTransitionList to set
	 */
	public void setOldTransitionList(LinkedList<int[]> oldTransitionList) {
		this.oldTransitionList = oldTransitionList;
	}
	
	/**
	 * @return the oldFdepTransitionList
	 */
	public LinkedList<int[]> getOldFdepTransitionList() {
		return oldFdepTransitionList;
	}

	/**
	 * @param oldTransitionList the oldTransitionList to set
	 */
	public void setOldFdepTransitionList(LinkedList<int[]> oldFdepTransitionList) {
		this.oldFdepTransitionList = oldFdepTransitionList;
	}
	
	//getters and setters end

	/**
	 * @param dft
	 * Takes a dft, usually provided by the ModelManager class and fills lists with its information for the next step.
	 * 
	 */
	public void preparation(DFT dft) {
		
		dftName = dft.getName();
		
		gateQueue.add(dft.getTopLevelEvent().getGate());
		
		//filling the lists
		while(!gateQueue.isEmpty()) {
			
			Gate tmp = gateQueue.peek();
			
			if(!tmp.getChildGate().isEmpty()) {
				for(int i = 0; i < tmp.getChildGate().size(); i++) {
					//fill in the queue for the state expansion
					gateQueue.add(tmp.getChildGate().get(i));
				}
			}
			
			if (!tmp.getChildEvent().isEmpty()) {
				for(int j = 0; j < tmp.getChildEvent().size(); j++) {
					eventQueue.add(tmp.getChildEvent().get(j));
					//eventList.add(tmp.getChildEvent().get(j));
				}
			}
			
			
			gateList.add(gateQueue.poll());
		}
		
		while(!eventQueue.isEmpty()) {
			
			Event tmpE = eventQueue.peek();
			
			//TODO remove if test dependency fix works
			/*if(tmpE.getDependency() != null && !dependencyList.contains(tmpE.getDependency())) {
				dependencyList.add(tmpE.getDependency());
			}
			*/
			
			/*
			 * test dependency fix
			 */
			if (tmpE.getDependency() != null) {
				for (int i = 0; i < tmpE.getDependency().size(); i++) {
					if (!dependencyList.contains(tmpE.getDependency().get(i))) {
						dependencyList.add(tmpE.getDependency().get(i));
					}
				}
			}
			
			//eventList.add(eventQueue.poll());
			
			/*
			 * test duplicate events
			 */
			//compare the values of two events, if they are identical, they are the same
			boolean identical = false;
			for(int i = 0; i < eventList.size(); i++) {
				if (eventList.get(i).getName().equals(tmpE.getName())) {
					System.out.println("same names: " + eventList.get(i).getName() + ", " + tmpE.getName());
					identical = true;
				}
			}
			//add event to list, skip duplicates
			if (identical == false) {
				eventList.add(eventQueue.poll());
			}else {
				eventQueue.poll();
			}
		}
		
		for(int d = 0; d < dependencyList.size(); d++) {
			if(dependencyList.get(d).eClass().getName() == "Sequence") {
				Sequence tmpSeq = (Sequence) dependencyList.get(d);
				seqList.add(tmpSeq);
			}else {
				FunctionalDependency tmpFDep = (FunctionalDependency) dependencyList.get(d);
				fDepList.add(tmpFDep);
			}
		}
		
	}//end prep
	
	/**
	 * @param dft
	 * Takes a dft, usually provided by the ModelManager class and fills lists with its information for the next step.
	 * 
	 */
	public void preparationOldDft(DFT oldDft) {
		
		oldDftName = oldDft.getName();
		
		oldGateQueue.add(oldDft.getTopLevelEvent().getGate());
		
		//filling the lists
		while(!oldGateQueue.isEmpty()) {
			
			Gate tmp = oldGateQueue.peek();
			
			if(!tmp.getChildGate().isEmpty()) {
				for(int i = 0; i < tmp.getChildGate().size(); i++) {
					//fill in the queue for the state expansion
					oldGateQueue.add(tmp.getChildGate().get(i));
				}
			}
			
			if (!tmp.getChildEvent().isEmpty()) {
				for(int j = 0; j < tmp.getChildEvent().size(); j++) {
					oldEventQueue.add(tmp.getChildEvent().get(j));
					//eventList.add(tmp.getChildEvent().get(j));
				}
			}
			
			
			oldGateList.add(oldGateQueue.poll());
		}
		
		while(!oldEventQueue.isEmpty()) {
			
			Event tmpE = oldEventQueue.peek();
			
			//TODO remove if dependency fix works
			/*if(tmpE.getDependency() != null && !oldDependencyList.contains(tmpE.getDependency())) {
				oldDependencyList.add(tmpE.getDependency());
			}
			*/
			
			/*
			 * test dependency fix
			 */
			if (tmpE.getDependency() != null) {
				for (int i = 0; i < tmpE.getDependency().size(); i++) {
					if (!oldDependencyList.contains(tmpE.getDependency().get(i))) {
						oldDependencyList.add(tmpE.getDependency().get(i));
					}
				}
			}
			
			//eventList.add(eventQueue.poll());
			
			/*
			 * test duplicate events
			 */
			//compare the values of two events, if they are identical, they are the same
			boolean identical = false;
			for(int i = 0; i < oldEventList.size(); i++) {
				if (oldEventList.get(i).getName().equals(tmpE.getName())) {
					System.out.println("same names: " + oldEventList.get(i).getName() + ", " + tmpE.getName());
					identical = true;
				}
			}
			//add event to list, skip duplicates
			if (identical == false) {
				oldEventList.add(oldEventQueue.poll());
			}else {
				oldEventQueue.poll();
			}
		}
		
		for(int d = 0; d < oldDependencyList.size(); d++) {
			if(oldDependencyList.get(d).eClass().getName() == "Sequence") {
				Sequence tmpSeq = (Sequence) oldDependencyList.get(d);
				oldSeqList.add(tmpSeq);
			}else {
				FunctionalDependency tmpFDep = (FunctionalDependency) oldDependencyList.get(d);
				oldFDepList.add(tmpFDep);
			}
		}
		
	}//end prep
	
	//used after preparation, creates the state space for the ctmc + relations between the states
	/**
	 * This method creates a truth table according to the basic events in the DFT. The truth table represents the state space of the CTMC.
	 * First it creates the state space and saves it in the state list.
	 * Then it calls the checkGates(int[] state) method to apply the logic of the gates and the sequence dependencies.
	 * @see checkGates(int[] state)
	 * Then states are checked for fail safety. Fail safety is documented in separate lists.
	 * The last step is creating the transitions by comparing the states for differences and checking for fail safety.
	 * Transitions from fail safe states to non fail safe states is not allowed.
	 * Merging of states is currently not implemented. Its functionality is commented out for later use.
	 */
	public void transformation() { //boolean merging
		//creating all possible states(no merging/checking yet)
		for(int i = 0; i < Math.pow(2, eventList.size()); i++) {
			//creating the truth table entry
			String tmpString = Integer.toBinaryString(i);
			//adding leading zeroes if too short
			while(tmpString.length() < eventList.size()) {
				tmpString = "0" + tmpString;
			}
			//adding 0 for the gates
			for(int j = 0; j < gateList.size(); j++) {
				tmpString = tmpString + "0";
			}
			//adding the truth table entry as a state into stateList
			int[] newState = new int[eventList.size() + gateList.size()];
			for(int k = 0; k < tmpString.length(); k++) {
				newState[k] = Character.getNumericValue(tmpString.charAt(k));
			}
			//checking the gate logic and apply it to the new states
			//then add the state to the state list
			stateList.add(checkGates(newState));
		}
		
		//testOut
		System.out.println("states:");
		for(int j = 0; j < stateList.size(); j++) {
			System.out.print("list entry nr " + j +": ");
			for(int k = 0; k < stateList.get(j).length; k++) {
				System.out.print(+ stateList.get(j)[k]);
			}
			System.out.println("");
		}
		
		//fail safe check
		//setup for fs check
		for(int i = 0; i < stateList.size(); i++) {
			boolean[] stateFS = new boolean[gateList.size()];
			failSafeList.add(stateFS);
		}
		// same for seq
		if (!seqList.isEmpty()) {
			for(int i = 0; i < stateList.size(); i++) {
				boolean[] stateSeq = new boolean[seqList.size()];
				seqFailList.add(stateSeq);
			}
		}
		
		//if a gate becomes fail safe, we can not transition from it to a non fail safe state, first state is always good to go
		for(int h = 1; h < stateList.size(); h++) {
			for(int i = 0; i < gateList.size(); i++) {
				String gateType = gateList.get(i).eClass().getName();
			    switch(gateType) {
			    case("PAND"):
			    	//create a priority list
				    LinkedList<Element> prioListPAND = new LinkedList<>();
			        for(int j = 0; j <gateList.get(i).getChildEvent().size(); j++) {
			        	prioListPAND.add(gateList.get(i).getChildEvent().get(j));
			        }
			        for(int j = 0; j <gateList.get(i).getChildGate().size(); j++) {
			    	    prioListPAND.add(gateList.get(i).getChildGate().get(j));
			        }
			        for(int j = 0; j < prioListPAND.size(); j++) {
			    	    prioListPAND.set(prioListPAND.get(j).getSequencePosition(), prioListPAND.get(j));
			        }
			        //check for fail safety
			        //case 1: if we have a leading 0, we can't transition to a non-fs state(state with leading 1), unless every value is 0
			        //e.g. PAND(0010)
			        int firstIndexPAND = 0;
			        if (prioListPAND.getFirst().eClass().getName() == "Event") {
						//firstIndexPAND = eventList.indexOf(prioListPAND.getFirst());
			        	//duplicate test
			    		for(int ind = 0; ind < eventList.size(); ind++) {
			    			if (eventList.get(ind).getName().equals(prioListPAND.getFirst().getName())) {
								firstIndexPAND = ind;
							}
			    		}
			    		//duplicate test end
					}else {
						firstIndexPAND = gateList.indexOf(prioListPAND.getFirst());
					}
			        
			        if (stateList.get(h)[firstIndexPAND] == 0) {
						//check if the rest is 0
			        	for(int j = 1; j < prioListPAND.size(); j++) {
			        		if (prioListPAND.get(j).eClass().getName() == "Event") {
								for(int k = 0; k < eventList.size(); k++) {
									if (eventList.get(k).getName().equals(prioListPAND.get(j).getName())) {
										if (stateList.get(h)[k] == 1) {
											failSafeList.get(h)[i] = true;
										}
									}
								}
							}else {
								if (stateList.get(h)[gateList.indexOf(prioListPAND.get(j))] == 1) {
									failSafeList.get(h)[i] = true;
								}
							}
			        	}
					}else {
						//case 2: after leading 1s we have 0s and than another 1
			            //the 0s in between can't become 1s
			            int series = 0;
			            for(int j = 0; j < prioListPAND.size(); j++) {
			            	int index = 0;
						    if(prioListPAND.get(j).eClass().getName() == "Event") {
							    //index = eventList.indexOf(prioListPAND.get(j));
						    	//duplicate test
						    	for(int inde = 0; inde < eventList.size(); inde++) {
						    		if (eventList.get(inde).getName().equals(prioListPAND.get(j).getName())) {
										index = inde;
									}
						    	}
						    	//duplicate test end
						    }else {
							    index = gateList.indexOf(prioListPAND.get(j)) + eventList.size();
						    }
						    if (stateList.get(h)[index] == 1) {
							    if (series == j) {
								    series++;
							    }else {
							    	failSafeList.get(h)[i] = true;
							    	break;
							    }
						    }
						 }			            
					}
			        
				    break;
				case("POR"):
					//create a priority list of its children
					LinkedList<Element> prioListPOR = new LinkedList<>();
				    for(int j = 0; j < gateList.get(i).getChildEvent().size(); j++) {
				    	prioListPOR.add(gateList.get(i).getChildEvent().get(j));
				    }
				    for(int j = 0; j < gateList.get(i).getChildGate().size(); j++) {
				    	prioListPOR.add(gateList.get(i).getChildGate().get(j));
				    }
				    //sort the list
				    for(int j = 0; j < prioListPOR.size(); j++) {
				    	prioListPOR.set(prioListPOR.get(j).getSequencePosition(), prioListPOR.get(j));
				    }
				    //case 1: check if we have a leading zero -> fs, unless every value is 0
				    //get the index
				    int firstIndexPOR = 0;
				    if(prioListPOR.getFirst().eClass().getName() == "Event") {
				    	eventList.indexOf(prioListPOR.getFirst());
				    }else {
				    	gateList.indexOf(prioListPOR.getFirst());
				    }
				    //check if its zero
				    if (stateList.get(h)[firstIndexPOR] == 0) {
				    	//check if the rest is 0
			        	for(int j = 1; j < prioListPOR.size(); j++) {
			        		if (prioListPOR.get(j).eClass().getName() == "Event") {
								for(int k = 0; k < eventList.size(); k++) {
									if (eventList.get(k).getName().equals(prioListPOR.get(j).getName())) {
										if (stateList.get(h)[k] == 1) {
											failSafeList.get(h)[i] = true;
										}
									}
								}
							}else {
								if (stateList.get(h)[gateList.indexOf(prioListPOR.get(j))] == 1) {
									failSafeList.get(h)[i] = true;
								}
							}
			        	}
					}else {
						//case 2: check if we have a fail after a series -> fs
					    int seriesPOR = 0;
					    for(int j = 0; j < prioListPOR.size(); j++) {
			            	int index;
						    if(prioListPOR.get(j).eClass().getName() == "Event") {
							    //index = eventList.indexOf(prioListPOR.get(j));
						    	//duplicate test
						    	index = 0;
						    	for(int dex = 0; dex < eventList.size(); dex ++) {
						    		if (eventList.get(dex).getName().equals(prioListPOR.get(j).getName())) {
										index = dex;
									}
						    	}
						    	//duplicate test end
						    }else {
							    index = gateList.indexOf(prioListPOR.get(j)) + eventList.size();
						    }
						    if (stateList.get(h)[index] == 1) {
							    if (seriesPOR == j) {
								    seriesPOR++;
							    }else {
							    	failSafeList.get(h)[i] = true;
							    	break;
							    }
						    }
						 }
					}
				    				    
					break;
			    case("XOR"):
			    	//check if more than one child has failed -> fs
			    	int failedChildren = 0;
			    	for(int j = 0; j < gateList.get(i).getChildGate().size(); j++) {
			    		int index = gateList.indexOf(gateList.get(i).getChildGate().get(j)) + eventList.size();
			    		if(stateList.get(h)[index] == 1) {
			    			failedChildren++;
			    		}
			    	}
			        for(int j = 0; j < gateList.get(i).getChildEvent().size(); j++) {
			        	//int index = eventList.indexOf(gateList.get(i).getChildEvent().get(j));
			        	//duplicate test
			        	int index = 0;
			        	for(int idex = 0; idex < eventList.size(); idex++) {
			        		if (eventList.get(idex).getName().equals(gateList.get(i).getChildEvent().get(j).getName())) {
								index = idex;
							}
			        	}
			        	//duplicate test end
			        	if(stateList.get(h)[index] == 1) {
			        		failedChildren++;
			        	}
			        }
			        if (failedChildren > 1) {
						failSafeList.get(h)[i] = true;
					}
				    break;
			    }
			}
			//check for sequences, if a sequence is violated -> fs, saved in seqFailList
			if (!seqList.isEmpty()) {
				int count = 0;
				for(int i = 0; i < seqList.size(); i++) {
					for(int j = 0; j < seqList.get(i).getEvents().size(); j++) {
						//int index = eventList.indexOf(seqList.get(i).getEvents().get(j));
						//duplicate test
						int index = 0;
						for(int k = 0; k < eventList.size(); k++) {
							if (eventList.get(k).getName().equals(seqList.get(i).getEvents().get(j).getName())) {
								index = k;
							}
						}
						//duplicat test end
						if (stateList.get(h)[index] == 1) {
							if (count == j) {
								count++;
							}else {
								seqFailList.get(h)[i] = true;
							}
						}
					}
				}
			}
		}
		//testOut
		System.out.println("failSafeList:");
		for(int i = 0; i < failSafeList.size(); i++) {
			for(int j = 0; j < failSafeList.getFirst().length; j++) {
				System.out.print(failSafeList.get(i)[j] + " ");
			}
			System.out.println(i);
		}
		System.out.println("seqFailList");
		for(int i = 0; i < seqFailList.size(); i++) {
			for(int j = 0; j < seqFailList.getFirst().length; j++) {
				System.out.print(seqFailList.get(i)[j] + " ");
			}
			System.out.println(i);
		}
		
		//creating the transition list
		//gates are checkt for fail safey, can't transition from fail safe to non fail safe, same for sequences
		int i = 0;
		int j = 0;
		while(i < stateList.size()) {
			j = i+1;
			while(j < stateList.size()) {
				int difference = 0;
				for(int k = 0; k < eventList.size(); k++) {
					int compareEvents = stateList.get(i)[k] - stateList.get(j)[k];
					if (compareEvents < 0 || compareEvents > 0) {
						difference++;
					}
				}
				boolean transPossible = true;
				if (difference == 1) {
					for(int k = 0; k < gateList.size(); k++) {
						if(failSafeList.get(i)[k] == true && failSafeList.get(j)[k] == false) {
							transPossible = false;
						}
					}
					if(!seqList.isEmpty()) {
						for(int k = 0; k < seqList.size() ; k++) {
							if (seqFailList.get(i)[k] == true && seqFailList.get(j)[k] == false) {
								transPossible = false;
							}
						}
					}
					if(transPossible == true) {
						for(int k = 0; k < eventList.size(); k++) {
							int compareEvents = stateList.get(i)[k] - stateList.get(j)[k];
						    if(compareEvents < 0){
						    	int[] transition = new int[3];
							    transition[0] = i;
							    transition[1] = j;
							    transition[2] = k;
							    if(!transitionList.contains(transition)) {
							    	transitionList.add(transition);
							    }
						    }
					    }
					}
					
				}
				j++;
			}
			i++;
		}
		//testOut
		System.out.println("transitions: ");
		for(int l = 0; l < transitionList.size(); l++) {
			System.out.print("transition nr " + l + ": ");
			for(int m = 0; m < transitionList.getFirst().length; m++) {
				System.out.print(transitionList.get(l)[m]+", ");
			}
			System.out.println("");
		}
		
		//transitions triggered by functional dependencies
		if(!fDepList.isEmpty()) {
			for (int k = 0; k < fDepList.size(); k++) {
				int trigger = eventList.indexOf(fDepList.get(k).getEvents().get(0));
                //check all states for the trigger, skip the first one
				for(int l = 1; l < stateList.size(); l++) {
					boolean triggered = false;
					//check if the trigger event was triggered by a transition in this state
					//for(int m = 0; m < eventList.size(); m++) {
						if (stateList.get(l)[trigger] == 1) {
							//check if there is a direct transition to the state, otherwise ignore
							for(int n = 0; n < transitionList.size(); n++) {
								//check if target state is the current state l(the letter)
								if (transitionList.get(n)[1] == l) {
									//check if the trigger failed
									if (transitionList.get(n)[2] == trigger) {
										triggered = true;
									}
								}
							}
						}
						//if it was triggered by a transition -> continue in the if
						if (triggered == true) {
							//search for states to transition to
							for(int m = l+1; m < stateList.size(); m++) {
								int difference = 0;
								//compare every event
								for(int n = 0; n < eventList.size(); n++) {
									int compareEvents = stateList.get(l)[n] - stateList.get(m)[n];
									if (compareEvents < 0 || compareEvents > 0) {
										difference++;
									}
								}
								//check for seqeuences and fail safety
								boolean fsOrSeq = false;
								//check for sequences
								if (!seqList.isEmpty()) {
									for(int x = 0; x < seqFailList.get(l).length; x++) {
									    if (seqFailList.get(l)[x] == true) {
										    if (seqFailList.get(m)[x] == false) {
											    fsOrSeq = true;
										    }
									    }
								    }
								}
								//check for fail safety
								if (fsOrSeq == false) {
									for(int y = 0; y < failSafeList.get(l).length; y++) {
										if (failSafeList.get(l)[y] == true) {
											if (failSafeList.get(m)[y] == false) {
												fsOrSeq = true;
											}
										}
									}
								}
								//System.out.println(fsOrSeq);
								
								//if the differece is only 1 and if it is at an event in the eventlist of the fdep
								//add a transition between the states into fDepTransition
								if (difference == 1 && fsOrSeq == false) {
									for(int n = 1; n < fDepList.get(k).getEvents().size(); n++) {
										int dependentEvent = eventList.indexOf(fDepList.get(k).getEvents().get(n));
										if (stateList.get(l)[dependentEvent] == 0) {
											if (stateList.get(m)[dependentEvent] == 1) {
												int[] transition = new int[4];
												transition[0] = l;
												transition[1] = m;
												transition[2] = dependentEvent;
												transition[3] = k;
												fDepTransition.add(transition);
											}
										}
									}
								}
							}
						}
					//}
				}
			}
		}
		//testOut
		if (!fDepTransition.isEmpty()) {
			System.out.println("functionally dependent transitions:");
		}
		for(int k = 0; k < fDepTransition.size(); k++) {
			System.out.print("transition nr " + k +": ");
			for(int l = 0; l < fDepTransition.getFirst().length; l ++) {
				System.out.print(fDepTransition.get(k)[l] +", ");
			}
			System.out.println("");
		}
		
		//merging end states; states where the top level event failed
		//all states get merged into the first one in the list
		//option must be enabled
		/*if (merging == true) {

			int firstGate = eventList.size();
			for(int k = 0; k < stateList.size(); k++) {
				if (stateList.get(k)[firstGate] == 1) {
					endStates.add(k);			
				}
			}
			for(int k = 0; k < transitionList.size(); k++) {
				for(int l = 0; l < endStates.size(); l++) {
					if (endStates.get(l) == transitionList.get(k)[0]) {
						transitionList.get(k)[0] = endStates.getFirst();
					}
					if (endStates.get(l) == transitionList.get(k)[1]) {
						transitionList.get(k)[1] = endStates.getFirst();
					}
				}
			}
			for(int k = 0; k < fDepTransition.size(); k++) {
				for(int l = 0; l < endStates.size(); l++) {
					if (endStates.get(l) == fDepTransition.get(k)[0]) {
						fDepTransition.get(k)[0] = endStates.getFirst();
					}
					if (endStates.get(l) == fDepTransition.get(k)[1]) {
						fDepTransition.get(k)[1] = endStates.getFirst();
					}
				}
			}
			for(int k = 0; k < endStates.size(); k++) {
				System.out.println(endStates.get(k));
			}
		}*/

	}//end transformation
	
	
	/**
	 * @param state
	 * @return state
	 * This method applies the logic of the gates and sequences to the state.
	 * First it checks for sequences, because they affect the gate logic.
	 * Then it checks if the gates failed in this state by comparing its children, which are events and other gates.
	 * 
	 */
	public int[] checkGates(int[] state) {
		//checking for sequences
		boolean[] seqFailed = new boolean[seqList.size()];
		int seqSeries = 0;
		for(int a = 0; a < seqList.size(); a++) {
			for(int b = 0; b < seqList.get(a).getEvents().size(); b++) {
				//int eventIndex = eventList.indexOf(seqList.get(a).getEvents().get(b));
				//test duplicate
				int eventIndex = 0;
				for(int c = 0; c < eventList.size(); c++) {
					if (eventList.get(c).getName().equals(seqList.get(a).getEvents().get(b).getName())) {
						eventIndex = c;
					}
				}
				//test duplicate end
				if (seqFailed[a] == false) {
					if (state[eventIndex] == 1) {
						if (seqSeries == b) {
							seqSeries++;
						}else {
							seqFailed[a] = true;
						}
					}else {
						if(seqSeries == 0) {
							seqFailed[a] = true;
						}
					}
				}
			}
		}
		
		//checking the gates, from bottom to top(to only check once)
		for(int i = state.length-1; i > eventList.size()-1; i--) {
			//getting the type of the gate
			Gate checkGate = gateList.get(i - eventList.size());
			String checkGateType = gateList.get(i - eventList.size()).eClass().getName();
			
			//checking if the sequences are maintained, the result is saved in seqMaintained
			
			
			//checking what type of gate it is and apply its logic
			switch(checkGateType) {
			case("AND"):
			    //checking all child gate and event entries
			    //if any child is 0(has not failed) the AND gate doesn't fail -->failed = false
			    //and the AND gate in the state/newstate is 0
			    int andFailed = 0;
			    if(!checkGate.getChildEvent().isEmpty()) {
			    	for(int j = 0; j < checkGate.getChildEvent().size() ; j++) {
				    	//int eventIndex = eventList.indexOf(checkGate.getChildEvent().get(j));
			    		//duplicate test
			    		int eventIndex = 0;
			    		String eventName = checkGate.getChildEvent().get(j).getName();
			    		for(int eIndex = 0; eIndex < eventList.size(); eIndex++) {
			    			if (eventList.get(eIndex).getName().equals(eventName)) {
								eventIndex = eIndex;
							}
			    		}
			    		
				    	if(state[eventIndex] == 1) {
				    		//check if we have to consider a sequence
				    		if (seqList.isEmpty()) {
								andFailed++;
							}else {
								for(int k = 0; k < seqList.size(); k++) {
									/*if (seqList.get(k).getEvents().contains(eventList.get(eventIndex))) {
										if(seqFailed[k] == false) {
											andFailed++;
										}
									}else {
										andFailed++;
									}*/
									//duplicate test
									if (seqList.get(k).getEvents().contains(checkGate.getChildEvent().get(j))) {
										if (seqFailed[k] == false) {
											andFailed++;
										}
									}else {
										andFailed++;
									}
									//duplicate test end
								}
							}
				    	}
				    }
			    }
			    if(!checkGate.getChildGate().isEmpty()) {
				    	for(int j = 0; j < checkGate.getChildGate().size(); j++) {
					    	int gateIndex = gateList.indexOf(checkGate.getChildGate().get(j)) + eventList.size();
					    	if(state[gateIndex] == 1) {
					    		andFailed++;
					    	}
					    } 	
			    }
			    //check if the AND in state becomes 1 or stays 0
			    if(andFailed == (checkGate.getChildEvent().size() + checkGate.getChildGate().size())) {
			    	state[i] = 1;
			    }
			break;//AND end
			case("PAND"):
			    //creating a list of all children to sort by sequence
				LinkedList<Element> childSequence = new LinkedList<Element>();
			    if(!checkGate.getChildEvent().isEmpty()) {
			    	for(int j = 0; j < checkGate.getChildEvent().size(); j++) {
			    		childSequence.add(checkGate.getChildEvent().get(j));
			    	}
			    }
			    if(!checkGate.getChildGate().isEmpty()) {
			    	for(int j = 0; j < checkGate.getChildGate().size(); j++) {
			    		childSequence.add(checkGate.getChildGate().get(j));
			    	}
			    }
			    
			    //check the user put a sequence in, if not, give a warning
			    boolean noSeq = false;
			    for(int j = 0; j < childSequence.size(); j++) {
			    	for(int k = 0; k < childSequence.size(); k++) {
			    		if (childSequence.get(j).getSequencePosition() == childSequence.get(k).getSequencePosition()) {
							if (childSequence.get(j) != childSequence.get(k)) {
								noSeq = true;
							}
						}
			    	}
			    }
			    if (noSeq == true) {
					JOptionPane.showMessageDialog(null, "Wrong sequence in priority gate " + checkGate.getName() + ". \nPlease fix the sequence positions(starting with 0).", "Warning!", JOptionPane.WARNING_MESSAGE);
					System.exit(1);
				}
			    
			    //sorting the list by the sequencePosition attribute
			    for(int j = 0; j < childSequence.size(); j++) {
			    	childSequence.set(childSequence.get(j).getSequencePosition(), childSequence.get(j));
			    }
			    //
			    int sequenceCheck = 0;
			    for(int j = 0; j < childSequence.size(); j++) {
			    	if(childSequence.get(j).eClass().getName() == "Event") {
			    		//int childIndex = eventList.indexOf(childSequence.get(j));
			    		//duplicate test
			    		String eventName = checkGate.getChildEvent().get(j).getName();
			    		int childIndex = 0;
			    		for(int eIndex = 0; eIndex < eventList.size(); eIndex++) {
			    			if (eventList.get(eIndex).getName().equals(eventName)) {
								childIndex = eIndex;
							}
			    		}
			    		//duplicate test end
			    		if((state[childIndex] == 1) && (sequenceCheck == j)) {
			    			//check if there is a sequence to consider
			    			if (seqList.isEmpty()) {
								sequenceCheck++;
							}else {
								for(int k = 0; k < seqList.size(); k++) {
									/*if (seqList.get(k).getEvents().contains(eventList.get(childIndex))) {
										if(seqFailed[k] == false) {
											sequenceCheck++;
										}
									}else {
										sequenceCheck++;
									}*/
									//duplicate test
									if (seqList.get(k).getEvents().contains(checkGate.getChildEvent().get(j))) {
										if (seqFailed[k] == false) {
											sequenceCheck++;
										}
									} else {
										sequenceCheck++;
									}
									//duplicate test end
								}
							}
			    		}
			    	}else {
			    		int childIndex = gateList.indexOf(childSequence.get(j)) + eventList.size();
			    		if(state[childIndex] == 1 && sequenceCheck == j) {
			    			sequenceCheck++;
			    		}
			    	}
			    	
		        }
			    //check if PAND failes or not
			    if(sequenceCheck == childSequence.size()) {
			    	state[i] = 1;
			    }
			break;//PAND end
			case("OR"):
				//System.out.println(i + " is an OR");
			    boolean orFailed = false;
			    //check the child events
			    if(!checkGate.getChildEvent().isEmpty()) {
			    	for(int j = 0; j < checkGate.getChildEvent().size(); j++) {
			    		//int eventIndex = eventList.indexOf(checkGate.getChildEvent().get(j));
			    		//duplicate test
			    		String eventName = checkGate.getChildEvent().get(j).getName();
			    		int eventIndex = 0;
			    		for(int eIndex = 0; eIndex < eventList.size(); eIndex++) {
			    			if (eventList.get(eIndex).getName().equals(eventName)) {
								eventIndex = eIndex;
							}
			    		}
			    		//duplicate test end
				    	if(state[eventIndex] == 1) {
				    		//check if there is a sequence
				    		if (seqList.isEmpty()) {
				    			orFailed = true;
					    		break;
							}else {
								for(int k = 0; k < seqList.size(); k++) {
									//if (seqList.get(k).getEvents().contains(eventList.get(eventIndex))) {
									//duplicate test if
									if(seqList.get(k).getEvents().contains(checkGate.getChildEvent().get(j))) {
										if(seqFailed[k] == false) {
											orFailed = true;
											break;
										}
									}else {
										orFailed = true;
										break;
									}
								}
							}
				    	}
			    	}
			    }
			    //check the child gates
			    if(!checkGate.getChildGate().isEmpty()) {
			    	for(int j = 0; j < checkGate.getChildGate().size(); j++) {
			    		int gateIndex = gateList.indexOf(checkGate.getChildGate().get(j)) + eventList.size();
				    	if(state[gateIndex] == 1) {
				    		orFailed = true;
				    		break;
				    	}
			    	}
			    }
			    //check if OR becomes 1 or stays 0
			    if(orFailed == true) {
			    	state[i] = 1;
			    }
			break;//OR end
			case("XOR"):
				int xORCheck = 0;
				if(!checkGate.getChildEvent().isEmpty()) {
					for(int j = 0; j < checkGate.getChildEvent().size(); j++) {
						//int eventIndex = eventList.indexOf(checkGate.getChildEvent().get(j));
						//duplicate test
			    		String eventName = checkGate.getChildEvent().get(j).getName();
			    		int eventIndex = 0;
			    		for(int eIndex = 0; eIndex < eventList.size(); eIndex++) {
			    			if (eventList.get(eIndex).getName().equals(eventName)) {
								eventIndex = eIndex;
							}
			    		}
			    		//duplicate test end
						if(state[eventIndex] == 1) {
							//check if there is a sequence
				    		if (seqList.isEmpty()) {
				    			xORCheck++;
					    		//break;
							}else {
								for(int k = 0; k < seqList.size(); k++) {
									//if (seqList.get(k).getEvents().contains(eventList.get(eventIndex))) {
									//duplicate test if
									if(seqList.get(k).getEvents().contains(checkGate.getChildEvent().get(j))) {
										if(seqFailed[k] == false) {
											xORCheck++;
											//break;
										}
									}else {
										xORCheck++;
										//break;
									}
								}
							}
						}
					}
				}
				if(!checkGate.getChildGate().isEmpty()) {
					for(int j = 0; j < checkGate.getChildGate().size(); j++) {
						int gateIndex = gateList.indexOf(checkGate.getChildGate().get(j)) + eventList.size();
						if(state[gateIndex] == 1) {
							xORCheck++;
						}
					}
				}
				//check if XOR fails
				if(xORCheck == 1) {
					state[i] = 1;
				}
			break;//XOR end
			case("POR"):
				LinkedList<Element> childSequencePOR = new LinkedList<Element>();
		        if(!checkGate.getChildEvent().isEmpty()) {
		    	   for(int j = 0; j < checkGate.getChildEvent().size(); j++) {
		    		   childSequencePOR.add(checkGate.getChildEvent().get(j));
		    	   }
		        }
		        if(!checkGate.getChildGate().isEmpty()) {
		    	   for(int j = 0; j < checkGate.getChildGate().size(); j++) {
		    		   childSequencePOR.add(checkGate.getChildGate().get(j));
		    		   }
		    	}
		        
		        //check the user put a sequence in, if not, give a warning
			    boolean noSeqPOR = false;
			    for(int j = 0; j < childSequencePOR.size(); j++) {
			    	for(int k = 0; k < childSequencePOR.size(); k++) {
			    		if (childSequencePOR.get(j).getSequencePosition() == childSequencePOR.get(k).getSequencePosition()) {
							if (childSequencePOR.get(j) != childSequencePOR.get(k)) {
								noSeqPOR = true;
							}
						}
			    	}
			    }
			    if (noSeqPOR == true) {
					JOptionPane.showMessageDialog(null, "Wrong sequence in priority gate " + checkGate.getName() + ". \nPlease fix the sequence positions(starting with 0).", "Warning!", JOptionPane.WARNING_MESSAGE);
					System.exit(1);
			    }
		        
		        //sorting the list by the sequencePosition attribute
		        for(int j = 0; j < childSequencePOR.size(); j++) {
		        	childSequencePOR.set(childSequencePOR.get(j).getSequencePosition(), childSequencePOR.get(j));
		        }
		        //
		        boolean failSafe = false;
		        int series = 0;
		        for(int j = 0 ; j < childSequencePOR.size(); j++) {
		        	if(childSequencePOR.get(j).eClass().getName() == "Event") {
		        		//int childIndex = eventList.indexOf(childSequencePOR.get(j));
		        		//duplicate test
			    		String eventName = checkGate.getChildEvent().get(j).getName();
			    		int childIndex = 0;
			    		for(int eIndex = 0; eIndex < eventList.size(); eIndex++) {
			    			if (eventList.get(eIndex).getName().equals(eventName)) {
								childIndex = eIndex;
							}
			    		}
			    		//duplicate test end
		        		if(failSafe == false) {
		        			if(state[childIndex] == 1) {
		        				//check if we have a sequence dependency
		        				if(seqList.isEmpty()) {
		        					if(series  == j) {
			        					series++;
			        				}else {
			        					failSafe = true;
			        				}
		        				}else {
		        					for(int k = 0; k < seqList.size(); k++) {
										//if (seqList.get(k).getEvents().contains(eventList.get(childIndex))) {
		        						//duplicate test if
		        						if(seqList.get(k).getEvents().contains(checkGate.getChildEvent().get(j))) {
											if(seqFailed[k] == false) {
												if(series  == j) {
						        					series++;
						        				}else {
						        					failSafe = true;
						        				}
											}
										}else {
											if(series  == j) {
					        					series++;
					        				}else {
					        					failSafe = true;
					        				}
										}
									}
		        				}
		        			}else {
		        				if(series == 0) {
		        					failSafe = true;
		        				}
		        			}
		        		}
		        			
		        	}else {
		        		int childIndex = gateList.indexOf(childSequencePOR.get(j)) + eventList.size();
		        		if(failSafe == false) {
		        			if(state[childIndex] == 1) {
		        				if(series  == j) {
		        					series++;
		        				}else {
		        					failSafe = true;
		        				}
		        			}else {
		        				if(series == 0) {
		        					failSafe = true;
		        				}
		        			}
		        		}
		        	}
		        }
		        //check if POR failed
		        if(failSafe == false) {
		        	state[i] = 1;
		        }
		        
			break;//POR END
			case("Spare"):
				int failedChildren = 0;
			    int failedSpares = 0;
			    Spare tmpSpare = (Spare) checkGate;
			    if(!checkGate.getChildEvent().isEmpty()) {
			    	for(int j = 0; j < checkGate.getChildEvent().size(); j++) {
			    		//int eventIndex = eventList.indexOf(checkGate.getChildEvent().get(j));
			    		//duplicate test
			    		String eventName = checkGate.getChildEvent().get(j).getName();
			    		int eventIndex = 0;
			    		for(int eIndex = 0; eIndex < eventList.size(); eIndex++) {
			    			if (eventList.get(eIndex).getName().equals(eventName)) {
								eventIndex = eIndex;
							}
			    		}
			    		//duplicate test end
			    		if((state[eventIndex] == 1) && !tmpSpare.getSpares().contains(checkGate.getChildEvent().get(j))) {
			    			if (seqList.isEmpty()) {
			    				failedChildren++;
							}else {
								for(int k = 0; k < seqList.size(); k++) {
									//if (seqList.get(k).getEvents().contains(eventList.get(eventIndex))) {
									//duplicate test if
									if(seqList.get(k).getEvents().contains(checkGate.getChildEvent().get(j))) {
										if(seqFailed[k] == false) {
											failedChildren++;
										}
									}else {
										failedChildren++;
									}
								}
							}
			    		}
			    		if((state[eventIndex] == 1) && tmpSpare.getSpares().contains(checkGate.getChildEvent().get(j))) {
			    			if (seqList.isEmpty()) {
			    				failedSpares++;
							}else {
								for(int k = 0; k < seqList.size(); k++) {
									//if (seqList.get(k).getEvents().contains(eventList.get(eventIndex))) {
									//duplicate test if
									if(seqList.get(k).getEvents().contains(checkGate.getChildEvent().get(j))) {
										if(seqFailed[k] == false) {
											failedSpares++;
										}
									}else {
										failedSpares++;
									}
								}
							}
			    		}
			    	}
			    }
			    if(!checkGate.getChildGate().isEmpty()) {
			    	for(int j = 0; j < checkGate.getChildGate().size(); j++) {
			    		int gateIndex = gateList.indexOf(checkGate.getChildGate().get(j)) + eventList.size();
			    		//if(state[gateIndex] == 1 && !tmpSpare.getSpares().contains(checkGate.getChildGate().get(j))) {
			    		if(state[gateIndex] == 1) {
			    			failedChildren++;
			    		}
			    		//if((state[gateIndex] == 1) && tmpSpare.getSpares().contains(checkGate.getChildGate().get(j))) {
			    			//failedSpares++;
			    		//}
			    	}
			    }
			    int functioningSpares = tmpSpare.getSpares().size() - failedSpares;
			    //System.out.println(failedChildren +", "+failedSpares+", "+functioningSpares);
			    if(failedChildren > functioningSpares) {
			    	state[i] = 1;
			    }
		    break;
			}
			
		}
		
		return state;
	}//end checkState
	
	/**
	 * @param ctmcUri
	 * This method creates a new CTMC at the ctmcUri location.
	 * First it creates a new blank ctmc.
	 * Then it creates the states from the stateList.
	 * Then it creates transitions from the transitions list.
	 * Then it creates transitions from the list caused by functional dependencies.
	 * After that the method makes labes for the starting state and the states, where the top level event fails.
	 * At last it prepares a resource set, which contains the ctmc data and tries to save it.
	 */
	public void buildCTMC(String ctmcUri) {
		//preperation to create the ctmc
		CtmcPackage.eINSTANCE.eClass();
		CtmcFactory factory = CtmcFactory.eINSTANCE;
		CTMC ctmc = factory.createCTMC();
		
		ctmc.setName(dftName);
		
		//creating the states
		for(int i = 0; i < stateList.size(); i++) {
			State state = factory.createState();
			String name = Integer.toString(i);
			state.setName(name);
			state.setExitRate(0.0f);
			ctmc.getStates().add(state);
		}
		
		//create the regular transitions
		for(int i = 0; i < transitionList.size(); i++) {
			Transition transition = factory.createTransition();
			//String name = "from" + Integer.toString(transitionList.get(i)[0]) + "to" + Integer.toString(transitionList.get(i)[1]);
			String name = eventList.get(transitionList.get(i)[2]).getName();
			transition.setName(name);
			transition.setDuration(1.0f);
			float probability = eventList.get(transitionList.get(i)[2]).getProbability();
			transition.setProbability(probability);
			//set references in states and the transition
			//from
			transition.setFrom(ctmc.getStates().get(transitionList.get(i)[0]));
			ctmc.getStates().get(transitionList.get(i)[0]).getOut().add(transition);
			//to
			transition.setTo(ctmc.getStates().get(transitionList.get(i)[1]));
			ctmc.getStates().get(transitionList.get(i)[1]).getIn().add(transition);
		}
		
		//create functionally dependent transitions
		for(int i = 0; i < fDepTransition.size(); i++) {
			Transition transition = factory.createTransition();
			String name = eventList.get(fDepTransition.get(i)[2]).getName();
			transition.setName(name);
			transition.setDuration(1.0f);
			float probability = fDepList.get(fDepTransition.get(i)[3]).getProbability();
			transition.setProbability(probability);
			//set references in states and transition
			//from
			transition.setFrom(ctmc.getStates().get(fDepTransition.get(i)[0]));
			ctmc.getStates().get(fDepTransition.get(i)[0]).getOut().add(transition);
			//to
			transition.setTo(ctmc.getStates().get(fDepTransition.get(i)[1]));
			ctmc.getStates().get(fDepTransition.get(i)[1]).getIn().add(transition);
		}
		
		//creating labels for the start and states where the tle fails
		//first state
		Label start = factory.createLabel();
		start.setText("Start");
		start.setState(ctmc.getStates().get(0));
		ctmc.getStates().get(0).getLabels().add(start);
		//tle failures
		for(int i = 0; i < stateList.size(); i++) {
			if (stateList.get(i)[eventList.size()] == 1) {
				Label tleFail = factory.createLabel();
				tleFail.setText("System failed");
				tleFail.setState(ctmc.getStates().get(i));
				ctmc.getStates().get(i).getLabels().add(tleFail);
			}
		}
		
		//prepare a resourceset and a recource for the ctmc to save it
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		reg.getExtensionToFactoryMap().put("ctmc", new XMIResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI(ctmcUri));
		
		//add the ctmc as content to the resource
		r.getContents().add(ctmc);
		
		//try to save it
		try {
			r.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveTransformationData(String folderPath, String folderName, DFT dft) {
		
		//make  a new folder for the data
		File tmpFolder = new File(folderPath);
		File folder = new File(tmpFolder, folderName);
		//System.out.println(folder.getAbsolutePath());
		if (!folder.exists()) {
            folder.mkdir();
        }
		
		
		//save the events by name
		//1. create the file if none exists
		/*System.out.println(folder.getAbsolutePath());
		File events = new File(folder.getAbsolutePath(), "Events.txt");
		if (!events.getParentFile().mkdirs()) {
			events.getParentFile().mkdirs();
		}
		try {
			events.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2. write the events
		PrintWriter eventWriter = null;
		try {
			eventWriter = new PrintWriter(events.getAbsolutePath());
			for(int i = 0; i < eventList.size(); i++) {
				eventWriter.println(eventList.get(i).getName());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			eventWriter.close();
		}
		
		//save gates + gate types
		//1. create the file if it doesn't exist
		File gates = new File(folder.getAbsolutePath(), "Gates.txt");
		if (!events.getParentFile().mkdirs()) {
			events.getParentFile().mkdirs();
		}
		try {
			events.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2. write the gate data
		PrintWriter gateWriter = null;
		try {
			gateWriter = new PrintWriter(gates.getAbsolutePath());
			for(int i = 0; i < gateList.size(); i++) {
				gateWriter.println(gateList.get(i).getName() + ", " + gateList.get(i).eClass().getName());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			gateWriter.close();
		}*/
		
		//save states
		//1. create the file 
		File states = new File(folder.getAbsoluteFile(), "States.txt");
		if (!states.getParentFile().mkdirs()) {
			states.getParentFile().mkdirs();
		}
		try {
			states.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2. write state data
		PrintWriter stateWriter = null;
		try {
			stateWriter = new PrintWriter(states.getAbsolutePath());
			for(int i = 0; i < stateList.size(); i++) {
				stateWriter.println(i + ". " +  Arrays.toString(stateList.get(i)));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stateWriter.close();
		}
		/*
		//save transitions
		//1. create file
		File transitions = new File(folder.getAbsoluteFile(), "Transitions.txt");
		if (!transitions.getParentFile().mkdirs()) {
			transitions.getParentFile().mkdirs();
		}
		try {
			transitions.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2. save transition data
		PrintWriter transitionWriter = null;
		try {
			transitionWriter = new PrintWriter(transitions.getAbsolutePath());
			for(int i = 0; i < transitionList.size(); i++) {
				transitionWriter.println(Arrays.toString(transitionList.get(i)));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			transitionWriter.close();
		}
		*/
		/*
		//save functionally dependent transitions
				//2. save transition data
		if (!fDepTransition.isEmpty()) {
			//1. create file
		    File fDepTransitions = new File(folder.getAbsoluteFile(), "FDepTransitions.txt");
    		if (!fDepTransitions.getParentFile().mkdirs()) {
	    		fDepTransitions.getParentFile().mkdirs();
		    }
		    try {
		    	fDepTransitions.createNewFile();
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
		    PrintWriter fDepTransitionsWriter = null;
			try {
			    fDepTransitionsWriter = new PrintWriter(fDepTransitions.getAbsolutePath());
			    for(int i = 0; i < fDepTransition.size(); i++) {
			     fDepTransitionsWriter.println(Arrays.toString(fDepTransition.get(i)));
			    }
		    } catch (FileNotFoundException e) {
			     e.printStackTrace();
		    } finally {
		    	fDepTransitionsWriter.close();
		    }
		}
		*/

		//save the model for the incremental transformation
		//prepare the dft copy
		DynamicFaultTreePackage.eINSTANCE.eClass();
		DynamicFaultTreeFactory factory = DynamicFaultTreeFactory.eINSTANCE;
		DFT saveDft = factory.createDFT();
		
		saveDft = dft;
		String saveDftUri = folderPath + folderName + "/" + saveDft.getName() + "Old" + ".dynamicfaulttree";
		System.out.println(saveDftUri);
		
		//prepare a resourceset and a recource for the dft to save it
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		reg.getExtensionToFactoryMap().put("dynamicfaulttree", new XMIResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI(saveDftUri));
				
		//add the dft as content to the resource
		r.getContents().add(saveDft);
			
		//try to save it
		try {
			r.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//TODO remove sysout, cases...
	public void compareDfts(DFT dft, DFT oldDFT) {
		
		//comparing the names
		if (dftName.compareTo(oldDftName) != 0) {
			System.out.println("DFT names are different: " + dftName + " vs " + oldDftName);
			//different dfts...
			Difference diff = new Difference();
			diff.setPriority(1);
			diff.setRefNew(null);
			diff.setRefOld(null);
			diff.setType("CTMC name");
			diff.setDifference(15); //dfts
			//sort into list
			int i;
			for(i = 0; i < differenceList.size(); i++) {
				if (differenceList.get(i).getPriority() > diff.getPriority()) {
					differenceList.add(i, diff);
					break;
				}
			}
			if (i == differenceList.size()) {
				differenceList.addLast(diff);
			}
			System.out.println("Created: " + diff);
		}
		else {
			System.out.println("DFT names are the same: " + dftName);
		}
		
		/*
		//this changes nothing
		//compare TLEs
		//names
		if (dft.getTopLevelEvent().getName().compareTo(oldDFT.getTopLevelEvent().getName()) != 0) {
			System.out.println("TLE names are different: " + dft.getTopLevelEvent().getName() + " vs " + oldDFT.getTopLevelEvent().getName());
			//TLE names
			Difference diff = new Difference();
			diff.setPriority(3);
			diff.setRefNew(dft.getTopLevelEvent());
			diff.setRefOld(oldDFT.getTopLevelEvent());
			diff.setType("TLE names");
			diff.setDifference(1); //name
			//sort into list
			int i;
			for(i = 0; i < differenceList.size(); i++) {
				if (differenceList.get(i).getPriority() > diff.getPriority()) {
					differenceList.add(i, diff);
					break;
				}
			}
			if (i == differenceList.size()) {
				differenceList.addLast(diff);
			}
			System.out.println("Created: " + diff);
		}else {
			System.out.println("TLE names are the same: " + dft.getTopLevelEvent().getName() );
		}
		//IDs
		if (dft.getTopLevelEvent().getElementID() != oldDFT.getTopLevelEvent().getElementID()) {
			System.out.println("TLE IDs are different: " + dft.getTopLevelEvent().getElementID() + " vs " + oldDFT.getTopLevelEvent().getElementID());
			//TODO different tle...
		}else {
			System.out.println("TLE IDs are the same: " + oldDFT.getTopLevelEvent().getElementID());
		}*/
		
		//compare gates
		boolean checkedGates[] = new boolean[oldGateList.size()]; //mark if gates were found or not
		boolean foundGates[] = new boolean[gateList.size()]; //mark if it's a new or old gate
		
		for(int i = 0; i < gateList.size(); i++) {
			for(int j = 0; j < oldGateList.size(); j++) {
				if (gateList.get(i).getElementID() == oldGateList.get(j).getElementID()) {
					checkedGates[j] = true;
					foundGates[i] = true;
					System.out.println("Comparing gates " + gateList.get(i).getName() + " and " +oldGateList.get(i).getName() + "...");
					compareGates(gateList.get(i), oldGateList.get(j));
				}
			}
			if (foundGates[i] == false) {
				System.out.println("New gate: " + gateList.get(i).getName() + ", " + gateList.get(i).getElementID());
				//new gate
				Difference diff = new Difference();
				diff.setPriority(5);
				diff.setRefNew(gateList.get(i));
				diff.setRefOld(null);
				diff.setType("add gate");
				diff.setDifference(16); //new gate
				//sort into list
				int k;
				for(k = 0; k < differenceList.size(); k++) {
					if (differenceList.get(k).getPriority() > diff.getPriority()) {
						differenceList.add(k, diff);
						break;
					}
				}
				if (k == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}
		}
		for (int i = 0; i < oldGateList.size(); i++) {
			if (checkedGates[i] == false) {
				System.out.println("Removed gate: " + oldGateList.get(i).getElementID() + ", " + oldGateList.get(i).getName());
				//remove gate
				Difference diff = new Difference();
				diff.setPriority(4);
				diff.setRefNew(null);
				diff.setRefOld(oldGateList.get(i));
				diff.setType("remove gate");
				diff.setDifference(17); //removed gate
				//sort into list
				int k;
				for(k = 0; k < differenceList.size(); k++) {
					if (differenceList.get(k).getPriority() > diff.getPriority()) {
						differenceList.add(k, diff);
						break;
					}
				}
				if (k == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}
		}
		
		//compare events
		boolean checkedEvents[] = new boolean[oldEventList.size()]; //mark if events were found or not
		boolean foundEvents[] = new boolean[eventList.size()]; //mark if it's a new or old event
		
		for(int i = 0; i < eventList.size(); i++) {
			//System.out.println(eventList.get(i));
			for(int j = 0; j < oldEventList.size(); j++) {
				//System.out.println(oldEventList.get(j));
				if (eventList.get(i).getElementID() == oldEventList.get(j).getElementID()) {
					//System.out.println(eventList.get(i).getName());
					//System.out.println(oldEventList.get(j).getName());
					checkedEvents[j] = true;
					foundEvents[i] = true;
					System.out.println("Comparing events " + eventList.get(i).getName() + " and " + oldEventList.get(j).getName() + "...");
					compareEvents(eventList.get(i), oldEventList.get(j));
				}
			}
			if (foundEvents[i] == false) {
				System.out.println("New event: " + eventList.get(i).getName() + ", " + eventList.get(i).getElementID());
				//add event
				Difference diff = new Difference();
				diff.setPriority(3);
				diff.setRefNew(eventList.get(i));
				diff.setRefOld(null);
				diff.setType("add event");
				diff.setDifference(18); //add event
				//sort into list
				int k;
				for(k = 0; k < differenceList.size(); k++) {
					if (differenceList.get(k).getPriority() > diff.getPriority()) {
						differenceList.add(k, diff);
						break;
					}
				}
				if (k == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}
		}
		for (int i = 0; i < oldEventList.size(); i++) {
			if (checkedEvents[i] == false) {
				System.out.println("Removed event: " + oldEventList.get(i).getElementID() + ", " + oldEventList.get(i).getName());
				//remove event
				Difference diff = new Difference();
				diff.setPriority(2);
				diff.setRefNew(null);
				diff.setRefOld(oldEventList.get(i));
				diff.setType("remove event");
				diff.setDifference(19); //remove event
				//sort into list
				int k;
				for(k = 0; k < differenceList.size(); k++) {
					if (differenceList.get(k).getPriority() > diff.getPriority()) {
						differenceList.add(k, diff);
						break;
					}
				}
				if (k == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}
		}
		
		//compare dependiencies
		boolean checkedDependencies[] = new boolean[oldDependencyList.size()]; //mark if events were found or not
		boolean foundDependencies[] = new boolean[dependencyList.size()]; //mark if it's a new or old event
		
		for(int i = 0; i < dependencyList.size(); i++) {
			for(int j = 0; j < oldDependencyList.size(); j++) {
				if (dependencyList.get(i).getElementID() == oldDependencyList.get(j).getElementID()) {
					checkedDependencies[j] = true;
					foundDependencies[i] = true;
					System.out.println("Comparing dependencies " + dependencyList.get(i).getName() + " and " + oldDependencyList.get(i).getName() + "...");
					compareDependencies(dependencyList.get(i), oldDependencyList.get(j));
				}
			}
			if (foundDependencies[i] == false) {
				System.out.println("New dependency: " + dependencyList.get(i).getName() + ", " + dependencyList.get(i).getElementID());
				//add dep
				Difference diff = new Difference();
				diff.setPriority(4);
				diff.setRefNew(dependencyList.get(i));
				diff.setRefOld(null);
				diff.setType("add dependency");
				diff.setDifference(22); //add dep
				//sort into list
				int k;
				for(k = 0; k < differenceList.size(); k++) {
					if (differenceList.get(k).getPriority() > diff.getPriority()) {
						differenceList.add(k, diff);
						break;
					}
				}
				if (k == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}
		}
		for (int i = 0; i < oldDependencyList.size(); i++) {
			if (checkedDependencies[i] == false) {
				System.out.println("Removed dependency: " + oldDependencyList.get(i).getElementID() + ", " + oldDependencyList.get(i).getName());
				//remove dep
				Difference diff = new Difference();
				diff.setPriority(4);
				diff.setRefNew(null);
				diff.setRefOld(oldDependencyList.get(i));
				diff.setType("remove dependency");
				diff.setDifference(23); //rem dep
				//sort into list
				int k;
				for(k = 0; k < differenceList.size(); k++) {
					if (differenceList.get(k).getPriority() > diff.getPriority()) {
						differenceList.add(k, diff);
						break;
					}
				}
				if (k == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}
		}
		
	}
	//TODO remove sysout, cases...
	public void compareGates(Gate gate1, Gate gate2) {
		
		//comapre IDs
		if (gate1.getElementID() != gate2.getElementID()) {
			System.out.println("Gate IDs are different: " + gate1.getElementID() + " vs " + gate2.getElementID());
			//TODO remove
		}else {
			System.out.println("Gate IDs are the same: " + gate1.getElementID());
		}
		//names
		if (gate1.getName().compareTo(gate2.getName()) != 0) {
			System.out.println("Gate names are different: " + gate1.getName() + " vs " + gate2.getName());
			//update labels
			Difference diff = new Difference();
			diff.setPriority(1);
			diff.setRefNew(gate1);
			diff.setRefOld(gate2);
			diff.setType("update labels");
			diff.setDifference(1); //name
			//sort into list
			int i;
			for(i = 0; i < differenceList.size(); i++) {
				if (differenceList.get(i).getPriority() > diff.getPriority()) {
					differenceList.add(i, diff);
					break;
				}
			}
			if (i == differenceList.size()) {
				differenceList.addLast(diff);
			}
			System.out.println("Created: " + diff);
		}else {
			System.out.println("Gate names are the same: " + gate1.getName());
		}
		//gate type
		if (gate1.getClass().getName().compareTo(gate2.getClass().getName()) != 0) {
			System.out.println("Gate types are different: " + gate1.eClass().getName() +" vs " + gate2.eClass().getName());
			//update gate logic
			Difference diff = new Difference();
			diff.setPriority(6);
			diff.setRefNew(gate1);
			diff.setRefOld(gate2);
			diff.setType("update gate logic");
			diff.setDifference(12); //gate type
			//sort into list
			int i;
			for(i = 0; i < differenceList.size(); i++) {
				if (differenceList.get(i).getPriority() > diff.getPriority()) {
					differenceList.add(i, diff);
					break;
				}
			}
			if (i == differenceList.size()) {
				differenceList.addLast(diff);
			}
			System.out.println("Created: " + diff);
		}else {
			System.out.println("Gate types are the same: " + gate2.eClass().getName());
		}
		//sequence position
		if (gate1.getSequencePosition() != gate2.getSequencePosition()) {
			System.out.println("Gate sequence positions are different: " + gate1.getSequencePosition() + " vs " + gate2.getSequencePosition());
			//update gate logic
			Difference diff = new Difference();
			diff.setPriority(6);
			diff.setRefNew(gate1);
			diff.setRefOld(gate2);
			diff.setType("update gate logic");
			diff.setDifference(3); //name
			//sort into list
			int i;
			for(i = 0; i < differenceList.size(); i++) {
				if (differenceList.get(i).getPriority() > diff.getPriority()) {
					differenceList.add(i, diff);
					break;
				}
			}
			if (i == differenceList.size()) {
				differenceList.addLast(diff);
			}
			System.out.println("Created: " + diff);
		}else {
			System.out.println("Gate sequence positions are the same: " + gate1.getSequencePosition());
		}		
		//parent gate/TLE
		if (gate1.getToplevelevent() != null) { //parent is TLE
			if (gate1.getToplevelevent().getElementID() != gate2.getToplevelevent().getElementID()) {
				System.out.println("Parents are different: (" + gate1.getToplevelevent().getName() + ", " + gate1.getToplevelevent().getElementID() + ") vs (" +gate2.getToplevelevent().getName() + ", " + gate2.getToplevelevent().getName() + ")");
				//TODO this case makes no sense
			}else {
				System.out.println("Parents are the same: (" + gate1.getToplevelevent().getName() + ", " + gate1.getToplevelevent().getElementID() + ") and (" + gate2.getToplevelevent().getName() + ", " + gate2.getToplevelevent().getElementID() + ")");
			}
		}else {  //parent is gate
			if (gate1.getParentGate().getElementID() != gate2.getParentGate().getElementID()) {
				System.out.println("Parents are different: " + gate1.getParentGate().getName() + ", " + gate1.getParentGate().getElementID() + " vs " + gate2.getParentGate().getName() + ", " + gate2.getParentGate().getElementID());
				//update gate logic
				Difference diff = new Difference();
				diff.setPriority(6);
				diff.setRefNew(gate1);
				diff.setRefOld(gate2);
				diff.setType("update gate logic");
				diff.setDifference(5); //parent gate
				//sort into list
				int i;
				for(i = 0; i < differenceList.size(); i++) {
					if (differenceList.get(i).getPriority() > diff.getPriority()) {
						differenceList.add(i, diff);
						break;
					}
				}
				if (i == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}else {
				System.out.println("Parents are the same: " + gate1.getParentGate().getName() + ", " + gate1.getParentGate().getElementID() + " and " + gate2.getParentGate().getName() + ", " + gate2.getParentGate().getElementID());
			}
		}
		
		//children
		//gates
		boolean checkedGates[] = new boolean[gate2.getChildGate().size()]; //mark gates to not check twice
		boolean foundGate[] = new boolean[gate1.getChildGate().size()]; //mark if gate was found, not found -> new child gate

		for(int i = 0; i < gate1.getChildGate().size(); i++) {
			for(int j = 0; j < gate2.getChildGate().size(); j++) {
				if (gate1.getChildGate().get(i).getElementID() == gate2.getChildGate().get(j).getElementID()) {
					checkedGates[j] = true;
					foundGate[i] = true;
					System.out.println("Same child gate: " + gate1.getChildGate().get(i).getName());
				}
			}
			if (foundGate[i] == false) {
				System.out.println("New child gate: " + gate1.getChildGate().get(i).getName());
				//update gate logic
				Difference diff = new Difference();
				diff.setPriority(6);
				diff.setRefNew(gate1);
				diff.setRefOld(gate2);
				diff.setType("update gate logic");
				diff.setDifference(8); //child gate
				//sort into list
				int k;
				for(k = 0; k < differenceList.size(); k++) {
					if (differenceList.get(k).getPriority() > diff.getPriority()) {
						differenceList.add(k, diff);
						break;
					}
				}
				if (k == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}
		}
		//check for removed gates
		for(int i = 0; i < gate2.getChildGate().size(); i++) {
			if (checkedGates[i] == false) {
				System.out.println("Removed child gate: " + gate2.getChildGate().get(i).getName());
				//update gate logic
				Difference diff = new Difference();
				diff.setPriority(6);
				diff.setRefNew(gate1);
				diff.setRefOld(gate2);
				diff.setType("update gate logic");
				diff.setDifference(8); //child gate
				//sort into list
				int k;
				for(k = 0; k < differenceList.size(); k++) {
					if (differenceList.get(k).getPriority() > diff.getPriority()) {
						differenceList.add(k, diff);
						break;
					}
				}
				if (k == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}
		}
		
		//events
		boolean checkedEvents[] = new boolean[gate2.getChildEvent().size()]; //mark events to not check twice
		boolean foundEvent[] = new boolean[gate1.getChildEvent().size()]; //mark if event was found, not found -> new child gate
		
		for(int i = 0; i < gate1.getChildEvent().size(); i++) {
			for(int j = 0; j < gate2.getChildEvent().size(); j++) {
				if (gate1.getChildEvent().get(i).getElementID() == gate2.getChildEvent().get(j).getElementID()) {
					checkedEvents[j] = true;
					foundEvent[i] = true;
					System.out.println("Same child Event: " + gate1.getChildEvent().get(i).getName());
				}
			}
			if (foundEvent[i] == false) {
				System.out.println("New child event: " + gate1.getChildEvent().get(i).getName());
				//update gate logic
				Difference diff = new Difference();
				diff.setPriority(6);
				diff.setRefNew(gate1);
				diff.setRefOld(gate2);
				diff.setType("update gate logic");
				diff.setDifference(8); //child gate
				//sort into list
				int k;
				for(k = 0; k < differenceList.size(); k++) {
					if (differenceList.get(k).getPriority() > diff.getPriority()) {
						differenceList.add(k, diff);
						break;
					}
				}
				if (k == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}
		}
		//check for removed events
		for(int i = 0; i < gate2.getChildEvent().size(); i++) {
			if (checkedEvents[i] == false) {
				System.out.println("Removed child event: " + gate2.getChildEvent().get(i).getName());
				//update gate logic
				Difference diff = new Difference();
				diff.setPriority(6);
				diff.setRefNew(gate1);
				diff.setRefOld(gate2);
				diff.setType("update gate logic");
				diff.setDifference(2); //name
				//sort into list
				int k;
				for(k = 0; k < differenceList.size(); k++) {
					if (differenceList.get(k).getPriority() > diff.getPriority()) {
						differenceList.add(k, diff);
						break;
					}
				}
				if (k == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}
		}
		
		//compare spares, check for new spares or if child gates became spares...
		//spares
		Spare tmp1 = null;
		Spare tmp2 = null;
		
		if (gate1.eClass().getName().compareTo("Spare") == 0) {
			tmp1 = (Spare) gate1;
			
			if (gate2.eClass().getName().compareTo("Spare") == 0) {
				tmp2 = (Spare) gate2;
				
				System.out.println(tmp1.getName() + " and " + tmp2.getName() + " are both Spare gates, checking spares...");
				boolean checkedSpares[] = new boolean[tmp2.getSpares().size()]; //mark Spares to not check twice
				boolean foundSpares[] = new boolean[tmp1.getSpares().size()]; //mark if a spare was found, not found -> new spare
				
				for(int i = 0; i < tmp1.getSpares().size(); i++) {
					for(int j = 0; j < tmp2.getSpares().size(); j++) {
						if (tmp1.getSpares().get(i).getElementID() == tmp2.getSpares().get(j).getElementID()) {
							checkedSpares[j] = true;
							foundSpares[i] = true;
							System.out.println("Same spare: " + tmp1.getSpares().get(i).getName());
						}
					}
					if (foundSpares[i] == false) {
						System.out.println("New spare: " + tmp1.getSpares().get(i).getName());
						//update gate logic
						Difference diff = new Difference();
						diff.setPriority(6);
						diff.setRefNew(gate1);
						diff.setRefOld(gate2);
						diff.setType("update gate logic");
						diff.setDifference(13); //spare
						//sort into list
						int k;
						for(k = 0; k < differenceList.size(); k++) {
							if (differenceList.get(k).getPriority() > diff.getPriority()) {
								differenceList.add(k, diff);
								break;
							}
						}
						if (k == differenceList.size()) {
							differenceList.addLast(diff);
						}
						System.out.println("Created: " + diff);
					}
				}
				//check for removed events
				for(int i = 0; i < tmp2.getSpares().size(); i++) {
					if (checkedSpares[i] == false) {
						System.out.println("Removed spare: " + tmp2.getSpares().get(i).getName());
						//update gate logic
						Difference diff = new Difference();
						diff.setPriority(6);
						diff.setRefNew(gate1);
						diff.setRefOld(gate2);
						diff.setType("update gate logic");
						diff.setDifference(13); //spare
						//sort into list
						int k;
						for(k = 0; k < differenceList.size(); k++) {
							if (differenceList.get(k).getPriority() > diff.getPriority()) {
								differenceList.add(k, diff);
								break;
							}
						}
						if (k == differenceList.size()) {
							differenceList.addLast(diff);
						}
						System.out.println("Created: " + diff);
					}
				}
			}else {
				System.out.println(tmp1.getName() + " is now a Spare gate");
				//same as gate type, redundant?
				//update gate logic
				Difference diff = new Difference();
				diff.setPriority(6);
				diff.setRefNew(gate1);
				diff.setRefOld(gate2);
				diff.setType("update gate logic");
				diff.setDifference(14); //spare
				//sort into list
				int i;
				for(i = 0; i < differenceList.size(); i++) {
					if (differenceList.get(i).getPriority() > diff.getPriority()) {
						differenceList.add(i, diff);
						break;
					}
				}
				if (i == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}			
		}else {
			if (gate2.eClass().getName().compareTo("Spare") == 0) {
				System.out.println(gate1.getName() + " is no longer a Spare gate");
				//update gate logic
				Difference diff = new Difference();
				diff.setPriority(6);
				diff.setRefNew(gate1);
				diff.setRefOld(gate2);
				diff.setType("update gate logic");
				diff.setDifference(14); //gate type spare
				//sort into list
				int i;
				for(i = 0; i < differenceList.size(); i++) {
					if (differenceList.get(i).getPriority() > diff.getPriority()) {
						differenceList.add(i, diff);
						break;
					}
				}
				if (i == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}
		}
		
		
	}
	//TODO remove sysouts
	public void compareEvents(Event event1, Event event2) {
		
		//TODO remove id check later
		//compare IDs
		if (event1.getElementID() != event2.getElementID()) {
			System.out.println("Event IDs are different: " + event1.getElementID() + " vs " + event2.getElementID());
			//TODO
		}else {
			System.out.println("Event IDs are the same: " + event1.getElementID());
		}
		//compare names
		if (event1.getName().compareTo(event2.getName()) != 0) {
			System.out.println("Event names are different: " + event1.getName() + " vs " + event2.getName());
			System.out.println("Adding to difference list...");
			
			//update transition labels
			Difference diff = new Difference();
			diff.setPriority(1);
			diff.setRefNew(event1);
			diff.setRefOld(event2);
			diff.setType("update name");
			diff.setDifference(1); //name
			//sort into list
			int i;
			for(i = 0; i < differenceList.size(); i++) {
				if (differenceList.get(i).getPriority() > diff.getPriority()) {
					differenceList.add(i, diff);
					break;
				}
			}
			if (i == differenceList.size()) {
				differenceList.addLast(diff);
			}
			System.out.println("Created: " + diff);
		}else {
			System.out.println("Event names are the same: " + event1.getName());
		}
		//seqence position
		if (event1.getSequencePosition() != event2.getSequencePosition()) {
			System.out.println("Event sequence positions are different: " + event1.getSequencePosition() + " vs " + event2.getSequencePosition());
			System.out.println("Adding to difference list...");
			
			//update gate logic
			Difference diff = new Difference();
			diff.setPriority(6);
			diff.setRefNew(event1);
			diff.setRefOld(event2);
			diff.setType("update gate logic");
			diff.setDifference(3); //sequence position
			//sort into list
			int i;
			for(i = 0; i < differenceList.size(); i++) {
				if (differenceList.get(i).getPriority() > diff.getPriority()) {
					differenceList.add(i, diff);
					break;
				}
			}
			if (i == differenceList.size()) {
				differenceList.addLast(diff);
			}
			System.out.println("Created: " + diff);
		}else {
			System.out.println("Event sequence positions are the same: " + event1.getSequencePosition());
		}
		//probability
		if (event1.getProbability() != event2.getProbability()) {
			System.out.println("Event probabilities are different: " + event1.getProbability() + " vs " + event2.getProbability());
			System.out.println("Adding to difference list...");
			
			//update transition labels
			Difference diff = new Difference();
			diff.setPriority(1);
			diff.setRefNew(event1);
			diff.setRefOld(event2);
			diff.setType("update probability");
			diff.setDifference(2); //probability
			//sort into list
			int i;
			for(i = 0; i < differenceList.size(); i++) {
				if (differenceList.get(i).getPriority() > diff.getPriority()) {
					differenceList.add(i, diff);
					break;
				}
			}
			if (i == differenceList.size()) {
				differenceList.addLast(diff);
			}
			System.out.println("Created: " + diff);
		}else {
			System.out.println("Event probabilities are the same: " + event1.getProbability());
		}
		//parent gate
		if (event1.getParentGate().getElementID() != event2.getParentGate().getElementID()) {
			System.out.println("Event parent gates are different: " + event1.getParentGate().getElementID() + " vs " + event2.getParentGate().getElementID());
			System.out.println("Adding to difference list...");
			
			//update gate logic
			Difference diff = new Difference();
			diff.setPriority(6);
			diff.setRefNew(event1);
			diff.setRefOld(event2);
			diff.setType("update gate logic");
			diff.setDifference(5); //parent gate
			//sort into list
			int i;
			for(i = 0; i < differenceList.size(); i++) {
				if (differenceList.get(i).getPriority() > diff.getPriority()) {
					differenceList.add(i, diff);break;
				}
			}
			if (i == differenceList.size()) {
				differenceList.addLast(diff);
			}
			System.out.println("Created: " + diff);
		}else {
			System.out.println("Event parents are the same: " + event1.getParentGate().getElementID());
		}
		//dependency
		//TODO remove if dependency fix works
		/*
		if (event1.getDependency() != null) {
			if (event2.getDependency() != null) {
				if (event1.getDependency().getElementID() != event2.getDependency().getElementID()) {
					System.out.println("Event dependencies are different: " + event1.getDependency().getElementID() + " vs " + event2.getDependency().getElementID());
					//check combinations of dependency types, 1. seq, seq, 2. seq, dep. 3. dep, seq, 4. dep, dep
					String type1 = event1.getDependency().eClass().getName();
					String type2 = event2.getDependency().eClass().getName();
					Difference diff = new Difference();
					int i;
					switch (type1+type2) {
					case "SequenceSequence": //update gate logic
						//update gate logic
						diff.setPriority(3);
						diff.setRefNew(event1);
						diff.setRefOld(event2);
						diff.setType("update gate logic");
						diff.setDifference(6); //dependency
						//sort into list
						for(i = 0; i < differenceList.size(); i++) {
							if (differenceList.get(i).getPriority() > diff.getPriority()) {
								differenceList.add(i, diff);
								break;
							}
						}
						if (i == differenceList.size()) {
							differenceList.addLast(diff);
						}
						System.out.println("Created: " + diff);
						break;

					case "SequenceFunctionalDependency": //remove trans + update g logic
						//update gate logic
						diff.setPriority(3);
						diff.setRefNew(event1);
						diff.setRefOld(event2);
						diff.setType("update gate logic");
						diff.setDifference(6); //dependency
						//sort into list
						for(i = 0; i < differenceList.size(); i++) {
							if (differenceList.get(i).getPriority() > diff.getPriority()) {
								differenceList.add(i, diff);
								break;
							}
						}
						if (i == differenceList.size()) {
							differenceList.addLast(diff);
						}
						System.out.println("Created: " + diff);
						//remove trans
						diff.setPriority(3);
						diff.setRefNew(event1);
						diff.setRefOld(event2);
						diff.setType("remove transitions");
						diff.setDifference(6); //dependency
						//sort into list
						for(i = 0; i < differenceList.size(); i++) {
							if (differenceList.get(i).getPriority() > diff.getPriority()) {
								differenceList.add(i, diff);
								break;
							}
						}
						if (i == differenceList.size()) {
							differenceList.addLast(diff);
						}
						System.out.println("Created: " + diff);
						break;
						
					case "FunctionalDependencySequence": //add trans + update g logic
						//add trans
						diff.setPriority(3);
						diff.setRefNew(event1);
						diff.setRefOld(event2);
						diff.setType("add transitions");
						diff.setDifference(6); //dependency
						//sort into list
						for(i = 0; i < differenceList.size(); i++) {
							if (differenceList.get(i).getPriority() > diff.getPriority()) {
								differenceList.add(i, diff);
								break;
							}
						}
						if (i == differenceList.size()) {
							differenceList.addLast(diff);
						}
						System.out.println("Created: " + diff);
						//update gate logic
						diff.setPriority(3);
						diff.setRefNew(event1);
						diff.setRefOld(event2);
						diff.setType("update gate logic");
						diff.setDifference(6); //dependency
						//sort into list
						for(i = 0; i < differenceList.size(); i++) {
							if (differenceList.get(i).getPriority() > diff.getPriority()) {
								differenceList.add(i, diff);
								break;
							}
						}
						if (i == differenceList.size()) {
							differenceList.addLast(diff);
						}
						System.out.println("Created: " + diff);
						break;
					
					case "FunctionalDependencyFunctionalDependency": //remove + add transitions
						//add transitions
						diff.setPriority(3);
						diff.setRefNew(event1);
						diff.setRefOld(event2);
						diff.setType("add transitions");
						diff.setDifference(6); //dependency
						//sort into list
						for(i = 0; i < differenceList.size(); i++) {
							if (differenceList.get(i).getPriority() > diff.getPriority()) {
								differenceList.add(i, diff);
							}
						}
						if (i == differenceList.size()) {
							differenceList.addLast(diff);
						}
						System.out.println("Created: " + diff);
						//remove transitions
						diff.setPriority(3);
						diff.setRefNew(event1);
						diff.setRefOld(event2);
						diff.setType("remove transitions");
						diff.setDifference(6); //dependency
						//sort into list
						for(i = 0; i < differenceList.size(); i++) {
							if (differenceList.get(i).getPriority() > diff.getPriority()) {
								differenceList.add(i, diff);
							}
						}
						if (i == differenceList.size()) {
							differenceList.addLast(diff);
						}
						System.out.println("Created: " + diff);
						break;	
					}
				}else {
					System.out.println("Event dependiencies are the same: " + event1.getDependency().getElementID());
				}
			}
			else { //added dependency
				if (event1.getDependency().eClass().getName() == "Sequence") {
					//update gate logic
					Difference diff = new Difference();
					diff.setPriority(3);
					diff.setRefNew(event1);
					diff.setRefOld(event2);
					diff.setType("update gate logic");
					diff.setDifference(6); //dependency
					//sort into list
					int i;
					for(i = 0; i < differenceList.size(); i++) {
						if (differenceList.get(i).getPriority() > diff.getPriority()) {
							differenceList.add(i, diff);
							break;
						}
					}
					if (i == differenceList.size()) {
						differenceList.addLast(diff);
					}
					System.out.println("Created: " + diff);
				}else { //functional dependency
					//add transitions
					Difference diff = new Difference();
					diff.setPriority(3);
					diff.setRefNew(event1);
					diff.setRefOld(event2);
					diff.setType("add transitions");
					diff.setDifference(6); //dependency
					//sort into list
					int i;
					for(i = 0; i < differenceList.size(); i++) {
						if (differenceList.get(i).getPriority() > diff.getPriority()) {
							differenceList.add(i, diff);
							break;
						}
					}
					if (i == differenceList.size()) {
						differenceList.addLast(diff);
					}
					System.out.println("Created: " + diff);
				}
			}
		}else {//removed dependency
			if (event2.getDependency() != null) { //removed dependency
				if (event2.getDependency().eClass().getName() == "Sequence") {
					//update gate logic
					Difference diff = new Difference();
					diff.setPriority(3);
					diff.setRefNew(event1);
					diff.setRefOld(event2);
					diff.setType("update gate logic");
					diff.setDifference(6); //dependency
					//sort into list
					int i;
					for(i = 0; i < differenceList.size(); i++) {
						if (differenceList.get(i).getPriority() > diff.getPriority()) {
							differenceList.add(i, diff);
							break;
						}
					}
					if (i == differenceList.size()) {
						differenceList.addLast(diff);
					}
					System.out.println("Created: " + diff);
				}else { //functional dependency
					//remove transitions
					Difference diff = new Difference();
					diff.setPriority(3);
					diff.setRefNew(event1);
					diff.setRefOld(event2);
					diff.setType("remove transitions");
					diff.setDifference(6); //dependency
					//sort into list
					int i;
					for(i = 0; i < differenceList.size(); i++) {
						if (differenceList.get(i).getPriority() > diff.getPriority()) {
							differenceList.add(i, diff);
							break;
						}
					}
					if (i == differenceList.size()) {
						differenceList.addLast(diff);
					}
					System.out.println("Created: " + diff);
				}
			}
		}
		*/
		
		/*
		 * dependency fix
		 */
		if (event1.getDependency() != null) {
			if (event2.getDependency() != null) {
				//check if the have the same events
				boolean checkedDep[] = new boolean[event2.getDependency().size()]; //mark dep to not check twice
				boolean foundDep[] = new boolean[event1.getDependency().size()]; //mark if dep was found, not found -> new dep

				for (int i = 0; i < event1.getDependency().size(); i++) {
					for (int j = 0; j < event2.getDependency().size(); j++) {
						if (event1.getDependency().get(i).getElementID() == event2.getDependency().get(j).getElementID()) {
							checkedDep[i] = true;
							foundDep[i] = true;
							System.out.println("Same Dependency: " + event1.getDependency().get(i).getName());
						}
					}
					//check for new dependencies
					if (foundDep[i] == false) { 
						System.out.println("New Dependency: " + event1.getDependency().get(i).getName());
						//TODO check what type and add dep.
					}
					
				}
				//check for removed dependencies
				for(int i = 0; i < event2.getDependency().size(); i++) {
					if (checkedDep[i] == false) {
						System.out.println("Removed Dependency: " + event2.getDependency().get(i).getName());
						//update gate logic
						//TODO diff
					}
				}
				
				
			}else {//added dependency check
				//TODO add diff
				System.out.println("added dependencies to " + event1.getName());
			}
		}else {//removed dependency check
			if (event2.getDependency() != null) {
				//TODO add diff
				System.out.println("removed dependencies from " + event1.getName());
			}
		}
		
	}
	
	public void compareDependencies(Dependency dep1, Dependency dep2) {
		
		//id
		if (dep1.getElementID() != dep2.getElementID()) {
			System.out.println("Dependency IDs are different: " + dep1.getElementID() + " vs " + dep2.getElementID());
			//TODO
		}else {
			System.out.println("Dependency IDs are the same: " + dep1.getElementID());
		}
		//name
		if (dep1.getName().compareTo(dep2.getName()) != 0) {
			System.out.println("Dependency names are different: " + dep1.getElementID() + " vs " + dep2.getElementID());
			//TODO relevant???
			Difference diff = new Difference();
			diff.setPriority(6);
			diff.setRefNew(dep1);
			diff.setRefOld(dep2);
			diff.setType("update label");
			diff.setDifference(1); //name
			//sort into list
			int k;
			for(k = 0; k < differenceList.size(); k++) {
				if (differenceList.get(k).getPriority() > diff.getPriority()) {
					differenceList.add(k, diff);
					break;
				}
			}
			if (k == differenceList.size()) {
				differenceList.addLast(diff);
			}
			System.out.println("Created: " + diff);
		}else {
			System.out.println("Dependency names are the same: " + dep1.getName());
		}
		//events
		boolean checkedEvents[] = new boolean[dep2.getEvents().size()];
		boolean foundEvent[] = new boolean[dep1.getEvents().size()];
		
		for(int i = 0; i < dep1.getEvents().size(); i++) {
			for(int j = 0; j < dep2.getEvents().size(); j++) {
				if (dep1.getEvents().get(i).getElementID() == dep2.getEvents().get(j).getElementID()) {
					checkedEvents[j] = true;
					foundEvent[i] = true;
					System.out.println("Same Event: " + dep1.getEvents().get(i).getName());
				}
			}
			if (foundEvent[i] == false) {
				System.out.println("New event: " + dep1.getEvents().get(i).getName());
				//update gate logic
				Difference diff = new Difference();
				diff.setPriority(6);
				diff.setRefNew(dep1);
				diff.setRefOld(dep2);
				diff.setType("update gate logic");
				diff.setDifference(20); //new event
				//sort into list
				int k;
				for(k = 0; k < differenceList.size(); k++) {
					if (differenceList.get(k).getPriority() > diff.getPriority()) {
						differenceList.add(k, diff);
						break;
					}
				}
				if (k == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}
		}
		//check for removed events
		for(int i = 0; i < dep2.getEvents().size(); i++) {
			if (checkedEvents[i] == false) {
				System.out.println("Removed event: " + dep2.getEvents().get(i).getName());
				//update gate logic
				Difference diff = new Difference();
				diff.setPriority(6);
				diff.setRefNew(dep1);
				diff.setRefOld(dep2);
				diff.setType("update gate logic");
				diff.setDifference(21); //removed event
				//sort into list
				int k;
				for(k = 0; k < differenceList.size(); k++) {
					if (differenceList.get(k).getPriority() > diff.getPriority()) {
						differenceList.add(k, diff);
						break;
					}
				}
				if (k == differenceList.size()) {
					differenceList.addLast(diff);
				}
				System.out.println("Created: " + diff);
			}
		}
		
		//if dep1 is a fdep, check for probability chnages
		if (dep1.eClass().getName() == "FunctionalDependency") {
			FunctionalDependency tmp1 = (FunctionalDependency) dep1;
			FunctionalDependency tmp2 = (FunctionalDependency) dep2;
			
			//check probabilities
			if (tmp1.getProbability() != tmp2.getProbability()) {
				System.out.println("changed probability: " + tmp1.getProbability() + " vs " + tmp2.getProbability());
				//update labels
				Difference diff = new Difference();
				diff.setPriority(1);
				diff.setRefNew(dep1);
				diff.setRefOld(dep2);
				diff.setType("update gate logic");
				diff.setDifference(24); //fdep changed probability
				//sort into list
				int k;
				for(k = 0; k < differenceList.size(); k++) {
					if (differenceList.get(k).getPriority() > diff.getPriority()) {
						differenceList.add(k, diff);
						break;
					}
				}
				if (k == differenceList.size()) {
					differenceList.addLast(diff);
				}
			}else {
				System.out.println("same probabilites: " + tmp1.getProbability());
			}
			
		}
		
	}
	
	public void loadStatesAndTransitions(String filePath) {
		
        String line = null;
        String stateFilePath = filePath + "States.txt";
        String transitionsFilePath = filePath + "Transitions.txt";
        String fdepTransitionsFilePath = filePath + "FDepTransitions.txt";

        //states
        try {
            FileReader stateReader = new FileReader(stateFilePath);
            BufferedReader bufferedStateReader = new BufferedReader(stateReader);
            //int[] state = new int[oldEventList.size() + oldGateList.size()];

            while((line = bufferedStateReader.readLine()) != null) {
            	int[] state = new int[oldEventList.size() + oldGateList.size()];
            	//System.out.println(line);
            	//trim for easier access
                line = line.substring(4, line.length()-1);
                //split the values to convert into integers
                String[] tmp = line.split(", ");
                for (int i = 0; i < tmp.length; i++) {
					int tmp2 = Integer.parseInt(tmp[i]);
					//System.out.print(tmp2);
					state[i] = tmp2;
					//System.out.print(state[i]);
				}
                //System.out.println("");
                getOldStateList().add(state);
            }   
            
            bufferedStateReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("unable to open file " + stateFilePath);                
        }
        catch(IOException ex) {
            System.out.println("error reading file " + stateFilePath);                  
        }
        
        /*
        //transitions
        try {
            FileReader transitionsReader = new FileReader(transitionsFilePath);
            BufferedReader bufferedTransReader = new BufferedReader(transitionsReader);
            //int[] state = new int[oldEventList.size() + oldGateList.size()];

            while((line = bufferedTransReader.readLine()) != null) {
            	int[] transition = new int[3];
            	//System.out.println(line);
            	//trim for easier access
                line = line.substring(1, line.length()-1);
                //split the values to convert into integers
                String[] tmp = line.split(", ");
                for (int i = 0; i < tmp.length; i++) {
					int tmp2 = Integer.parseInt(tmp[i]);
					//System.out.print(tmp2);
					transition[i] = tmp2;
					//System.out.print(state[i]);
				}
                //System.out.println("");
                getOldTransitionList().add(transition);
            }   
            
            bufferedTransReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("unable to open file " + transitionsFilePath);                
        }
        catch(IOException ex) {
            System.out.println("error reading file " + transitionsFilePath);                  
        }
        */
        /*
        //fdep transitions
        try {
            FileReader fdepTransitionsReader = new FileReader(fdepTransitionsFilePath);
            BufferedReader bufferedFdepTransReader = new BufferedReader(fdepTransitionsReader);

            while((line = bufferedFdepTransReader.readLine()) != null) {
            	int[] fdepTransition = new int[3];
            	//System.out.println(line);
            	//trim for easier access
                line = line.substring(1, line.length()-1);
                //split the values to convert into integers
                String[] tmp = line.split(", ");
                for (int i = 0; i < tmp.length; i++) {
					int tmp2 = Integer.parseInt(tmp[i]);
					//System.out.print(tmp2);
					fdepTransition[i] = tmp2;
					//System.out.print(state[i]);
				}
                //System.out.println("");
                getOldTransitionList().add(fdepTransition);
            }   
            
            bufferedFdepTransReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("unable to open file " + fdepTransitionsFilePath);                
        }
        catch(IOException ex) {
            System.out.println("error reading file " + fdepTransitionsFilePath);                  
        }
        */
	}
	
	public void incrementalTransformation(CTMC ctmc, String newCtmcPath) {
				
		//DFT name changed
		if (differenceList.getFirst().getDifference() == 15) {//changing the dft name is always the fist diff
			ctmc.setName(dftName);
			System.out.println("set new ctmc name: " + ctmc.getName());
			differenceList.removeFirst();
		}
		
		//TLE changes
		//nothing to do
		
		//number of priority one differences
		int prioOne;
		for (prioOne = 0; prioOne < differenceList.size(); prioOne++) {
			if (differenceList.get(prioOne).getPriority() != 1) {
				break;
			}
		}
		//System.out.println("nr of priority 1 differences: " + prioOne);
		
		
		//1. label update
		System.out.println("starting label updates...");
		
		for (int i = 0; i < prioOne; i++) {
			System.out.println(i);
			//check every state
			states: for (int j = 0; j < ctmc.getStates().size(); j++) {
				//check every transition
				for (int k = 0; k < ctmc.getStates().get(j).getOut().size(); k++) {
					//check the difference
					switch (differenceList.get(i).getDifference()) {
					case 1: //change label name
						//check name with old ref name
						if (differenceList.get(i).getRefOld().getName().compareTo(ctmc.getStates().get(j).getOut().get(k).getName()) == 0) {
							//change name to new ref name
							ctmc.getStates().get(j).getOut().get(k).setName(differenceList.get(i).getRefNew().getName());
							System.out.println("set new name: " + ctmc.getStates().get(j).getOut().get(k).getName());
						}
						break;
					case 2: //change probability
						//check name of trans with olf ref, then check probabilities
						if (differenceList.get(i).getRefNew().getName().compareTo(ctmc.getStates().get(j).getOut().get(k).getName()) == 0 &&
						    differenceList.get(i).getRefOld().getProbability() == ctmc.getStates().get(j).getOut().get(k).getProbability()) {
							//set new probability
							ctmc.getStates().get(j).getOut().get(k).setProbability(differenceList.get(i).getRefNew().getProbability());
							System.out.println("set new probability : " + ctmc.getStates().get(j).getOut().get(k).getProbability());
							continue states;
						}
						break;
					case 24: //change probability because of a functional dependability
						//TODO maybe seperate it from the other cases
						FunctionalDependency tmp1 = (FunctionalDependency) differenceList.get(i).getRefNew();
						//check if its relevant for this transition
						boolean relevant = false;
						boolean relevant1 = false;//check if on fdep event list
						boolean relevant2 = false;//check if trans in contains the trigger
						for (int l = 1; l < tmp1.getEvents().size(); l++) {
							if (tmp1.getEvents().get(l).getName().compareTo(ctmc.getStates().get(j).getOut().get(k).getName()) == 0) {
								relevant1 = true;
								break;
							}
						}
						for (int l = 0; l < ctmc.getStates().get(j).getIn().size(); l++) {
							if (ctmc.getStates().get(j).getIn().get(l).getName().compareTo(tmp1.getEvents().get(0).getName()) == 0) {
								relevant2 = true;
								break;
							}
						}
						if (relevant1 == true && relevant2 == true) {
							relevant = true;
							System.out.println("this case is relevant");
						}
						if (relevant) {
							System.out.println(ctmc.getStates().get(j).getOut().get(k).getProbability());
							System.out.println(differenceList.get(i).getRefOld().getProbability());
							if (ctmc.getStates().get(j).getOut().get(k).getProbability() == differenceList.get(i).getRefOld().getProbability()) {
								//System.out.println("relevant");
								ctmc.getStates().get(j).getOut().get(k).setProbability(tmp1.getProbability());
								//push it to the end of the list, so we know the last transitions are fdep transitions
								ctmc.getStates().get(j).getOut().move(ctmc.getStates().get(j).getOut().size()-1, ctmc.getStates().get(j).getOut().get(k));
								System.out.println("set new probability " + ctmc.getStates().get(j).getOut().get(k).getProbability() + " for " + ctmc.getStates().get(j).getOut().get(k).getName());
								continue states;
							}
						}
						
						break;
					}
				}
			}
		}
		
		//remove priority 1 differences, since their changes are now applied
		while (differenceList.getFirst().getPriority() == 1) {
			differenceList.removeFirst();
		}
		//label update end
		
		//TODO do this in testFile
		//set the statesList for the addition and removal of events
		setStateList(oldStateList);
		//setTransitionList(oldTransitionList);
		//System.out.println(transitionList);
		//setFdepTransitionList(oldFdepTransitionList);
				
		if (differenceList.getFirst().getPriority() == 2) {
		    //removing states for every removed event
			System.out.println("removing states and entries for removed events...");
		    for (int i = 0; i < differenceList.size(); i++) {
			    if (differenceList.get(i).getPriority() == 2) {
		    		//copy of statelist, cannot iterate over the list while modifying it
			    	//LinkedList<int[]> stateListCopy = stateList;
				
		    		//index of the event in the state
			    	int eventIndex = oldEventList.indexOf(differenceList.get(i).getRefOld());
			    	
			    	//remove the event from the list for the next event removal
			    	getOldEventList().remove(differenceList.get(i).getRefOld());
				
		    		//System.out.println(oldEventList);
				
		    		//state index to remove from ctmc
			    	//int stateIndex = 0;
	    			//System.out.println(eventIndex);
		    		//new state size
			    	int stateSize = stateList.getFirst().length-1;
				
		    		Iterator<int[]> stateIterator = stateList.iterator();
		    		//int realStateIndex = 0; //state index in respect of removed elements ,increment, unless we remove a state(+1-1=0)
		    		int stateIndex = 0; //current state index
		    		//remove states where the event is 1
		    		while(stateIterator.hasNext()){
			    		//if event = 1, remove from state list and ctmc
		    			//System.out.println("r"+realStateIndex);
		    			//System.out.println(stateIndex);
		    			
		    			int[] stateIteratorNext = stateIterator.next();
		    			
			    		if (stateIteratorNext[eventIndex] == 1) {
			    			//System.out.println("eI = 1");
			    			//System.out.println("removing state...");
			    			
			    			/*
			    			//removing the transitions from the tranition and fdep transition lists
			    			//transition list
			    			Iterator<int[]> transitionIterator = transitionList.iterator(); 
			    			while (transitionIterator.hasNext()) {
			    				int[] transitionIteratorNext = transitionIterator.next();
			    				if (transitionIteratorNext[0] == stateIndex) {
									transitionIterator.remove();
								}else if (transitionIteratorNext[1] == stateIndex) {
									transitionIterator.remove();
								}
							}
			    			
			    			for (int j = 0; j < transitionList.size(); j++) {
								if (transitionList.get(j)[0] > stateIndex) {
									transitionList.get(j)[0]--;
								}
								if (transitionList.get(j)[1] > stateIndex) {
									transitionList.get(j)[1]--;
								}
							}*/
			    			
			    			//remove the state from its list
			    			stateIterator.remove();
			    			
			    			
				    		//remove transitions and state from ctmc
				    		for (int j = 0; j < stateIndex; j++) { //realStateIndex
				    			/*for (int k = 0; k < ctmc.getStates().get(j).getOut().size(); k++) {
					    	    		if (ctmc.getStates().get(j).getOut().get(k).getName().compareTo(differenceList.get(i).getRefOld().getName()) == 0) {
						    			System.out.println("remove this!");
							    		ctmc.getStates().get(j).getOut().remove(k); 
			    					}
				    			}*/
	    						Iterator<Transition> outIterator = ctmc.getStates().get(j).getOut().iterator();
	    						while (outIterator.hasNext()) {
	    							if (outIterator.next().getName().compareTo(differenceList.get(i).getRefOld().getName()) == 0) {
		    							//System.out.println("remove this");
			    						outIterator.remove();
				    				}
		    					}
		    				}
			    			ctmc.getStates().remove(stateIndex); //realStateIndex
			    		}else {
				    		//realStateIndex++;
				    		stateIndex++;
					    }
			    		//stateIndex++;
	    			}
		    		//remove the entry from states where event = 0
			    	for (int j = 0; j < stateList.size(); j++) {
	    				//System.out.println("ei = 0");
		   			
		    			int[] state = new int[stateSize];
			    		System.arraycopy(stateList.get(j), 0, state, 0, eventIndex);
				    	System.arraycopy(stateList.get(j), eventIndex+1, state, eventIndex, stateList.get(j).length-1-eventIndex-oldGateList.size());
	    				stateList.set(j, state);
		    		}
			    }else {
				    break;
	    		}
		    }
		
	    	while (differenceList.getFirst().getPriority() == 2) {
		    	differenceList.remove();
    		}
	    }
		
		//adding new events to states
		if (differenceList.getFirst().getPriority() == 3) {
			System.out.println("adding events and states...");
			for (int i = 0; i < differenceList.size(); i++) {
	    	//System.out.println(i);
	    	if (differenceList.get(i).getPriority() == 3) {	    		
	    		//put the event to the front of the event list
	    		//this will make it easier to create new states later
	    		eventList.remove(differenceList.get(i).getRefNew());
	    		eventList.addFirst((Event) differenceList.get(i).getRefNew());
	    		//modify existing states
	    		//System.out.println(copyLenght);
				addEvent(ctmc);
				//copyLenght++;
				
				
			}else {
				break;
			}
	    
	    }
	    
	        while (differenceList.getFirst().getPriority() == 3) {
			    differenceList.remove();
		    }
		}
		
		//TODO remove later
		//set new state names
		for (int j = 0; j < ctmc.getStates().size(); j++) {
			ctmc.getStates().get(j).setName(Integer.toString(j) + "_" + ctmc.getStates().get(j).getName());
		}
		
		//prepare a factory to create transitions/labels for the ctmc
		CtmcPackage.eINSTANCE.eClass();
		CtmcFactory factory = CtmcFactory.eINSTANCE;
			    
	    //remove gates
		if (differenceList.getFirst().getPriority() == 4) {
			for (int i = 0; i < differenceList.size(); i++) {
			if (differenceList.get(i).getPriority() == 4) {
				System.out.println("removing gates...");
				int stateSize = stateList.getFirst().length;
				for (int j = 0; j < stateList.size(); j++) {
					int[] state = new int[stateSize-1];
					System.arraycopy(stateList.get(j), 0, state, 0, stateSize-1);
					stateList.set(j, state);
				}
			}else {
				break;
			}
		}
	    
	        while (differenceList.getFirst().getPriority() == 4) {
			    differenceList.remove();
		    }
		}
	    
	    
	    //add gates
		if (differenceList.getFirst().getPriority() == 5) {
			for (int i = 0; i < differenceList.size(); i++) {
			if (differenceList.get(i).getPriority() == 5) {
				System.out.println("adding gates...");
				int stateSize = stateList.getFirst().length;
				for (int j = 0; j < stateList.size(); j++) {
					int[] state = new int[stateSize+1];
					System.arraycopy(stateList.get(j), 0, state, 0, stateSize);
					stateList.set(j, state);
				}
			}else {
				break;
			}
		}
	    
	        while (differenceList.getFirst().getPriority() == 5) {
			    differenceList.remove();
		    }
		}
		
		int topLevelGateIndex = eventList.size();
		//check gate logic and add/remove labels
		System.out.println("checking gate logic and adding/removing labels...");
	    if (differenceList.getFirst().getPriority() == 6) {
	    	
	    	checkGates(stateList.getFirst());
			
	    	for (int i = 1; i < stateList.size(); i++) {
				checkGates(stateList.get(i));
				
				for (int j = 0; j < stateList.get(i).length; j++) {
					System.out.print(stateList.get(i)[j]);
				}
				System.out.println();
				//remove/add labels
				if (stateList.get(i)[topLevelGateIndex] == 0) {
					if (!ctmc.getStates().get(i).getLabels().isEmpty()) {
						ctmc.getStates().get(i).getLabels().clear();
					}
				}else {
					if (ctmc.getStates().get(i).getLabels().isEmpty()) {
						Label end = factory.createLabel();
						end.setState(ctmc.getStates().get(i));
						end.setText("System failed");
						ctmc.getStates().get(i).getLabels().add(end);
					}
				}
			}
		}
		
	    //transitions
	    
	    //fill out the transition and fdep trans lists with data from the ctmc
	    for (int i = 0; i < ctmc.getStates().size(); i++) {
			for (int j = 0; j < ctmc.getStates().get(i).getOut().size(); j++) {
				int[] trans = new int[3];
				
				//index of the current state
				trans[0] = i;
				
				//index of the target state
				trans[1] = ctmc.getStates().indexOf(ctmc.getStates().get(i).getOut().get(j).getTo());
				
				//look up index of the event
				for (int k = 0; k < eventList.size(); k++) {
					if (eventList.get(k).getName().compareTo(ctmc.getStates().get(i).getOut().get(j).getName()) == 0) {
						trans[2] = k;
						break;
					}
				}
				//TODO TEST IT FOR FDEP
				//add the transition to it's respective list
				if (transitionList.contains(trans)) {
					int[] fDepTrans = new int[4];
					fDepTrans[0] = trans[0];
					fDepTrans[1] = trans[1];
					fDepTrans[2] = trans[2];
					//check which fdep it triggered
					for (int k = 0; k < ctmc.getStates().get(trans[0]).getIn().size(); k++) {
						for (int k2 = 0; k2 < fDepList.size(); k2++) {
							if (ctmc.getStates().get(trans[0]).getIn().get(k).getName().compareTo(fDepList.get(k2).getEvents().get(0).getName()) == 0) {
								fDepTrans[3] = k2;
								if (!fDepTransition.contains(fDepTrans)) {
									fDepTransition.add(fDepTrans);
								}
							}
						}
					}
					
				}else {
					transitionList.add(trans);
				}
			}
		}
	    
	    //fill the lists and ctmc with the new transitions
	    
		//fail safe check
		//setup for fs check
		for(int i = 0; i < stateList.size(); i++) {
			boolean[] stateFS = new boolean[gateList.size()];
			failSafeList.add(stateFS);
		}
		// same for seq
		if (!seqList.isEmpty()) {
			for(int i = 0; i < stateList.size(); i++) {
				boolean[] stateSeq = new boolean[seqList.size()];
				seqFailList.add(stateSeq);
			}
		}
		
		//if a gate becomes fail safe, we can not transition from it to a non fail safe state, first state is always good to go
		for(int h = 1; h < stateList.size(); h++) {
			for(int i = 0; i < gateList.size(); i++) {
				String gateType = gateList.get(i).eClass().getName();
			    switch(gateType) {
			    case("PAND"):
			    	//create a priority list
				    LinkedList<Element> prioListPAND = new LinkedList<>();
			        for(int j = 0; j <gateList.get(i).getChildEvent().size(); j++) {
			        	prioListPAND.add(gateList.get(i).getChildEvent().get(j));
			        }
			        for(int j = 0; j <gateList.get(i).getChildGate().size(); j++) {
			    	    prioListPAND.add(gateList.get(i).getChildGate().get(j));
			        }
			        for(int j = 0; j < prioListPAND.size(); j++) {
			    	    prioListPAND.set(prioListPAND.get(j).getSequencePosition(), prioListPAND.get(j));
			        }
			        //check for fail safety
			        //case 1: if we have a leading 0, we can't transition to a non-fs state(state with leading 1), unless every value is 0
			        //e.g. PAND(0010)
			        int firstIndexPAND = 0;
			        if (prioListPAND.getFirst().eClass().getName() == "Event") {
						//firstIndexPAND = eventList.indexOf(prioListPAND.getFirst());
			        	//duplicate test
			    		for(int ind = 0; ind < eventList.size(); ind++) {
			    			if (eventList.get(ind).getName().equals(prioListPAND.getFirst().getName())) {
								firstIndexPAND = ind;
							}
			    		}
			    		//duplicate test end
					}else {
						firstIndexPAND = gateList.indexOf(prioListPAND.getFirst());
					}
			        
			        if (stateList.get(h)[firstIndexPAND] == 0) {
						//check if the rest is 0
			        	for(int j = 1; j < prioListPAND.size(); j++) {
			        		if (prioListPAND.get(j).eClass().getName() == "Event") {
								for(int k = 0; k < eventList.size(); k++) {
									if (eventList.get(k).getName().equals(prioListPAND.get(j).getName())) {
										if (stateList.get(h)[k] == 1) {
											failSafeList.get(h)[i] = true;
										}
									}
								}
							}else {
								if (stateList.get(h)[gateList.indexOf(prioListPAND.get(j))] == 1) {
									failSafeList.get(h)[i] = true;
								}
							}
			        	}
					}else {
						//case 2: after leading 1s we have 0s and than another 1
			            //the 0s in between can't become 1s
			            int series = 0;
			            for(int j = 0; j < prioListPAND.size(); j++) {
			            	int index = 0;
						    if(prioListPAND.get(j).eClass().getName() == "Event") {
							    //index = eventList.indexOf(prioListPAND.get(j));
						    	//duplicate test
						    	for(int inde = 0; inde < eventList.size(); inde++) {
						    		if (eventList.get(inde).getName().equals(prioListPAND.get(j).getName())) {
										index = inde;
									}
						    	}
						    	//duplicate test end
						    }else {
							    index = gateList.indexOf(prioListPAND.get(j)) + eventList.size();
						    }
						    if (stateList.get(h)[index] == 1) {
							    if (series == j) {
								    series++;
							    }else {
							    	failSafeList.get(h)[i] = true;
							    	break;
							    }
						    }
						 }			            
					}
			        
				    break;
				case("POR"):
					//create a priority list of its children
					LinkedList<Element> prioListPOR = new LinkedList<>();
				    for(int j = 0; j < gateList.get(i).getChildEvent().size(); j++) {
				    	prioListPOR.add(gateList.get(i).getChildEvent().get(j));
				    }
				    for(int j = 0; j < gateList.get(i).getChildGate().size(); j++) {
				    	prioListPOR.add(gateList.get(i).getChildGate().get(j));
				    }
				    //sort the list
				    for(int j = 0; j < prioListPOR.size(); j++) {
				    	prioListPOR.set(prioListPOR.get(j).getSequencePosition(), prioListPOR.get(j));
				    }
				    //case 1: check if we have a leading zero -> fs, unless every value is 0
				    //get the index
				    int firstIndexPOR = 0;
				    if(prioListPOR.getFirst().eClass().getName() == "Event") {
				    	eventList.indexOf(prioListPOR.getFirst());
				    }else {
				    	gateList.indexOf(prioListPOR.getFirst());
				    }
				    //check if its zero
				    if (stateList.get(h)[firstIndexPOR] == 0) {
				    	//check if the rest is 0
			        	for(int j = 1; j < prioListPOR.size(); j++) {
			        		if (prioListPOR.get(j).eClass().getName() == "Event") {
								for(int k = 0; k < eventList.size(); k++) {
									if (eventList.get(k).getName().equals(prioListPOR.get(j).getName())) {
										if (stateList.get(h)[k] == 1) {
											failSafeList.get(h)[i] = true;
										}
									}
								}
							}else {
								if (stateList.get(h)[gateList.indexOf(prioListPOR.get(j))] == 1) {
									failSafeList.get(h)[i] = true;
								}
							}
			        	}
					}else {
						//case 2: check if we have a fail after a series -> fs
					    int seriesPOR = 0;
					    for(int j = 0; j < prioListPOR.size(); j++) {
			            	int index;
						    if(prioListPOR.get(j).eClass().getName() == "Event") {
							    //index = eventList.indexOf(prioListPOR.get(j));
						    	//duplicate test
						    	index = 0;
						    	for(int dex = 0; dex < eventList.size(); dex ++) {
						    		if (eventList.get(dex).getName().equals(prioListPOR.get(j).getName())) {
										index = dex;
									}
						    	}
						    	//duplicate test end
						    }else {
							    index = gateList.indexOf(prioListPOR.get(j)) + eventList.size();
						    }
						    if (stateList.get(h)[index] == 1) {
							    if (seriesPOR == j) {
								    seriesPOR++;
							    }else {
							    	failSafeList.get(h)[i] = true;
							    	break;
							    }
						    }
						 }
					}
				    				    
					break;
			    case("XOR"):
			    	//check if more than one child has failed -> fs
			    	int failedChildren = 0;
			    	for(int j = 0; j < gateList.get(i).getChildGate().size(); j++) {
			    		int index = gateList.indexOf(gateList.get(i).getChildGate().get(j)) + eventList.size();
			    		if(stateList.get(h)[index] == 1) {
			    			failedChildren++;
			    		}
			    	}
			        for(int j = 0; j < gateList.get(i).getChildEvent().size(); j++) {
			        	//int index = eventList.indexOf(gateList.get(i).getChildEvent().get(j));
			        	//duplicate test
			        	int index = 0;
			        	for(int idex = 0; idex < eventList.size(); idex++) {
			        		if (eventList.get(idex).getName().equals(gateList.get(i).getChildEvent().get(j).getName())) {
								index = idex;
							}
			        	}
			        	//duplicate test end
			        	if(stateList.get(h)[index] == 1) {
			        		failedChildren++;
			        	}
			        }
			        if (failedChildren > 1) {
						failSafeList.get(h)[i] = true;
					}
				    break;
			    }
			}
			//check for sequences, if a sequence is violated -> fs, saved in seqFailList
			if (!seqList.isEmpty()) {
				int count = 0;
				for(int i = 0; i < seqList.size(); i++) {
					for(int j = 0; j < seqList.get(i).getEvents().size(); j++) {
						//int index = eventList.indexOf(seqList.get(i).getEvents().get(j));
						//duplicate test
						int index = 0;
						for(int k = 0; k < eventList.size(); k++) {
							if (eventList.get(k).getName().equals(seqList.get(i).getEvents().get(j).getName())) {
								index = k;
							}
						}
						//duplicat test end
						if (stateList.get(h)[index] == 1) {
							if (count == j) {
								count++;
							}else {
								seqFailList.get(h)[i] = true;
							}
						}
					}
				}
			}
		}
		//testOut
		System.out.println("failSafeList:");
		for(int i = 0; i < failSafeList.size(); i++) {
			for(int j = 0; j < failSafeList.getFirst().length; j++) {
				System.out.print(failSafeList.get(i)[j] + " ");
			}
			System.out.println(i);
		}
		System.out.println("seqFailList");
		for(int i = 0; i < seqFailList.size(); i++) {
			for(int j = 0; j < seqFailList.getFirst().length; j++) {
				System.out.print(seqFailList.get(i)[j] + " ");
			}
			System.out.println(i);
		}
		
		//TODO TEST IT
		//check if the existing transitions are correct
		//transition list
		//make an iterator to be able to remove transitions while iterating
		Iterator<int[]> transitionIterator = transitionList.iterator();
		while (transitionIterator.hasNext()) {
			int[] trans = transitionIterator.next();
			//transition through the failsafe lists and check if we go fro fs to non fs
			for (int i = 0; i < gateList.size(); i++) {
				if (failSafeList.get(trans[0])[i] == true && failSafeList.get(trans[1])[i] == false) {
					transitionIterator.remove();
					//remove from ctmc
					Iterator<Transition> ctmcTransIterator = ctmc.getStates().get(trans[0]).getOut().iterator();
					while (ctmcTransIterator.hasNext()) {
						Transition ctmcTrans = ctmcTransIterator.next();
						if (ctmcTrans.getName().compareTo(eventList.get(trans[2]).getName()) == 0) {
							if (ctmcTrans.getProbability() == eventList.get(trans[2]).getProbability()) {
								ctmcTransIterator.remove();
								break;
							}
						}
					}
				}else if (!seqFailList.isEmpty() && seqFailList.get(trans[0])[i] == true && seqFailList.get(trans[1])[i] == false) {
					transitionIterator.remove();
					//remove from ctmc
					Iterator<Transition> ctmcTransIterator = ctmc.getStates().get(trans[0]).getOut().iterator();
					while (ctmcTransIterator.hasNext()) {
						Transition ctmcTrans = ctmcTransIterator.next();
						if (ctmcTrans.getName().compareTo(eventList.get(trans[2]).getName()) == 0) {
							if (ctmcTrans.getProbability() == eventList.get(trans[2]).getProbability()) {
								ctmcTransIterator.remove();
								break;
							}
						}
					}
				}
			}
		}
		//fdep transitions
		Iterator<int[]> fDepTransitionIterator = fDepTransition.iterator();
		while (fDepTransitionIterator.hasNext()) {
			int[] trans = fDepTransitionIterator.next();
			//transition through the failsafe lists and check if we go fro fs to non fs
			for (int i = 0; i < gateList.size(); i++) {
				if (failSafeList.get(trans[0])[i] == true && failSafeList.get(trans[1])[i] == false) {
					fDepTransitionIterator.remove();
					//remove from ctmc
					Iterator<Transition> ctmcTransIterator = ctmc.getStates().get(trans[0]).getOut().iterator();
					while (ctmcTransIterator.hasNext()) {
						Transition ctmcTrans = ctmcTransIterator.next();
						if (ctmcTrans.getName().compareTo(eventList.get(trans[2]).getName()) == 0) {
							if (ctmcTrans.getProbability() == fDepList.get(trans[3]).getProbability()) {
								ctmcTransIterator.remove();
								break;
							}
						}
					}
				}else if (!seqFailList.isEmpty() && seqFailList.get(trans[0])[i] == true && seqFailList.get(trans[1])[i] == false) {
					fDepTransitionIterator.remove();
					//remove from ctmc
					Iterator<Transition> ctmcTransIterator = ctmc.getStates().get(trans[0]).getOut().iterator();
					while (ctmcTransIterator.hasNext()) {
						Transition ctmcTrans = ctmcTransIterator.next();
						if (ctmcTrans.getName().compareTo(eventList.get(trans[2]).getName()) == 0) {
							if (ctmcTrans.getProbability() == fDepList.get(trans[3]).getProbability()) {
								ctmcTransIterator.remove();
								break;
							}
						}
					}
				}
			}
		}
		
		/*//prepare a factory to create transitions for the ctmc
		CtmcPackage.eINSTANCE.eClass();
		CtmcFactory factory = CtmcFactory.eINSTANCE;
		*/
		//filling the transition list
		//gates are checkt for fail safey, can't transition from fail safe to non fail safe, same for sequences
		int i = 0;
		int j = 0;
		while(i < stateList.size()) {
			j = i+1;
			while(j < stateList.size()) {
				int difference = 0;
				for(int k = 0; k < eventList.size(); k++) {
					int compareEvents = stateList.get(i)[k] - stateList.get(j)[k];
					if (compareEvents < 0 || compareEvents > 0) {
						difference++;
					}
				}
				boolean transPossible = true;
				if (difference == 1) {
					for(int k = 0; k < gateList.size(); k++) {
						if(failSafeList.get(i)[k] == true && failSafeList.get(j)[k] == false) {
							transPossible = false;
						}
					}
					if(!seqList.isEmpty()) {
						for(int k = 0; k < seqList.size() ; k++) {
							if (seqFailList.get(i)[k] == true && seqFailList.get(j)[k] == false) {
								transPossible = false;
							}
						}
					}
					if(transPossible == true) {
						for(int k = 0; k < eventList.size(); k++) {
							int compareEvents = stateList.get(i)[k] - stateList.get(j)[k];
						    if(compareEvents < 0){
						    	int[] transition = new int[3];
							    transition[0] = i;
							    transition[1] = j;
							    transition[2] = k;
							    boolean add = true;
							    for (int l = 0; l < transitionList.size(); l++) {
									if (transitionList.get(l)[0] == transition[0]) {
										if (transitionList.get(l)[1] == transition[1]) {
											if (transitionList.get(l)[2] == transition[2]) {
												add = false;
											}
										}
									}
								}
							    if (add == true) {
									transitionList.add(transition);
									
									//add transition to ctmc
									Transition trans = factory.createTransition();
									trans.setName(eventList.get(transition[2]).getName());
									trans.setProbability(eventList.get(transition[2]).getProbability());
									trans.setDuration(1.0f);
									//set out for from state
									trans.setFrom(ctmc.getStates().get(transition[0]));
									ctmc.getStates().get(transition[0]).getOut().add(trans);
									//set in for to state
									trans.setTo(ctmc.getStates().get(transition[1]));
									ctmc.getStates().get(transition[1]).getIn().add(trans);
								}
							    /*if(!transitionList.contains(transition)) { //TODO contains not working???
							    	transitionList.add(transition);
							    }else {
									System.out.println("exists");
								}*/
						    }
					    }
					}
					
				}
				j++;
			}
			i++;
		}
		//testOut
		System.out.println("transitions: ");
		for(int l = 0; l < transitionList.size(); l++) {
			System.out.print("transition nr " + l + ": ");
			for(int m = 0; m < transitionList.getFirst().length; m++) {
				System.out.print(transitionList.get(l)[m]+", ");
			}
			System.out.println("");
		}
		
		//TODO TEST
		//transitions triggered by functional dependencies
		if(!fDepList.isEmpty()) {
			for (int k = 0; k < fDepList.size(); k++) {
				int trigger = eventList.indexOf(fDepList.get(k).getEvents().get(0));
                //check all states for the trigger, skip the first one
				for(int l = 1; l < stateList.size(); l++) {
					boolean triggered = false;
					//check if the trigger event was triggered by a transition in this state
					//for(int m = 0; m < eventList.size(); m++) {
						if (stateList.get(l)[trigger] == 1) {
							//check if there is a direct transition to the state, otherwise ignore
							for(int n = 0; n < transitionList.size(); n++) {
								//check if target state is the current state l(the letter)
								if (transitionList.get(n)[1] == l) {
									//check if the trigger failed
									if (transitionList.get(n)[2] == trigger) {
										triggered = true;
									}
								}
							}
						}
						//if it was triggered by a transition -> continue in the if
						if (triggered == true) {
							//search for states to transition to
							for(int m = l+1; m < stateList.size(); m++) {
								int difference = 0;
								//compare every event
								for(int n = 0; n < eventList.size(); n++) {
									int compareEvents = stateList.get(l)[n] - stateList.get(m)[n];
									if (compareEvents < 0 || compareEvents > 0) {
										difference++;
									}
								}
								//check for seqeuences and fail safety
								boolean fsOrSeq = false;
								//check for sequences
								if (!seqList.isEmpty()) {
									for(int x = 0; x < seqFailList.get(l).length; x++) {
									    if (seqFailList.get(l)[x] == true) {
										    if (seqFailList.get(m)[x] == false) {
											    fsOrSeq = true;
										    }
									    }
								    }
								}
								//check for fail safety
								if (fsOrSeq == false) {
									for(int y = 0; y < failSafeList.get(l).length; y++) {
										if (failSafeList.get(l)[y] == true) {
											if (failSafeList.get(m)[y] == false) {
												fsOrSeq = true;
											}
										}
									}
								}
								//System.out.println(fsOrSeq);
								
								//if the differece is only 1 and if it is at an event in the eventlist of the fdep
								//add a transition between the states into fDepTransition
								if (difference == 1 && fsOrSeq == false) {
									for(int n = 1; n < fDepList.get(k).getEvents().size(); n++) {
										int dependentEvent = eventList.indexOf(fDepList.get(k).getEvents().get(n));
										if (stateList.get(l)[dependentEvent] == 0) {
											if (stateList.get(m)[dependentEvent] == 1) {
												int[] transition = new int[4];
												transition[0] = l;
												transition[1] = m;
												transition[2] = dependentEvent;
												transition[3] = eventList.indexOf(fDepList.get(k).getEvents().get(0));
												//check if it already exists
												boolean add = true;
												for (int o = 0; o < fDepTransition.size(); o++) {
													if (fDepTransition.get(o)[0] == transition[0]) {
														if (fDepTransition.get(o)[1] == transition[1]) {
															if (fDepTransition.get(o)[2] == transition[2]) {
																if (fDepTransition.get(0)[3] == transition[3]) {
																	add = false;
																}
															}
														}
													}
												}
												if (add == true) {
													fDepTransition.add(transition);
													
													//add to ctmc
													//add transition to ctmc
													Transition trans = factory.createTransition();
													trans.setName(eventList.get(transition[2]).getName());
													trans.setProbability(fDepList.get(k).getProbability());
													trans.setDuration(1.0f);
													//set out for from state
													trans.setFrom(ctmc.getStates().get(transition[0]));
													ctmc.getStates().get(transition[0]).getOut().add(trans);
													//set in for to state
													trans.setTo(ctmc.getStates().get(transition[1]));
													ctmc.getStates().get(transition[1]).getIn().add(trans);
												}
												/*if (!fDepTransition.contains(transition)) {
													fDepTransition.add(transition);
												}*/
											}
										}
									}
								}
							}
						}
					//}
				}
			}
		}
		//testOut
		if (!fDepTransition.isEmpty()) {
			System.out.println("functionally dependent transitions:");
		}
		for(int k = 0; k < fDepTransition.size(); k++) {
			System.out.print("transition nr " + k +": ");
			for(int l = 0; l < fDepTransition.getFirst().length; l ++) {
				System.out.print(fDepTransition.get(k)[l] +", ");
			}
			System.out.println("");
		}
		
		//TODO SET LABELS
		
	  	//TODO save changes to ctmc, TEST
		//prepare a resourceset and a recource for the dft to save it
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		reg.getExtensionToFactoryMap().put("ctmc", new XMIResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI(newCtmcPath));
						
		//add the dft as content to the resource
		r.getContents().add(ctmc);
			
		//try to save it
		try {
			r.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addEvent(CTMC ctmc) {
		
		int copyLenght = oldEventList.size()+1;
		int stateListSize = stateList.size();
		int stateSize = stateList.getFirst().length + 1;
		//System.out.println(copyLenght + ", " +stateListSize + ", " + stateSize);
	
		for (int j = 0; j < stateListSize; j++) {
			//System.out.println(j);
    		int[] state = new int[stateSize]; // size of state +1 for new event
    		//System.out.println(stateList.get(j) + " " + state + " " + copyLenght);
			System.arraycopy(stateList.get(j), 0, state, 1, copyLenght); //copy event values to new state
			state[0] = 0; //TODO check if default 0
			//stateList.add(state);
			stateList.set(j, state);
			
		}
		//copy exisiting states for new event with value 1
		for (int j = 0; j < stateListSize; j++) {
			//System.out.println(j);
    		int[] state = new int[stateSize]; // size of state +1 for new event
    		System.arraycopy(stateList.get(j), 1, state, 1, copyLenght); //copy event values to new state
			state[0] = 1;
			stateList.add(state);
			
			//create the state in the ctmc
			CtmcFactory factory = CtmcFactory.eINSTANCE;
			State ctmcState = factory.createState();
			//TODO change this and remove the other name setting part
			ctmcState.setName("n");
			ctmcState.setExitRate(0.0f);
			ctmc.getStates().add(ctmcState);
		}
		//System.out.println(eventList);
		//System.out.println(gateList);
	}
	
	public void translateDFTtoGalileo(String filePath) {
		
		File targetDFT = new File(filePath, dftName+".dft");
		
		//creating the file
		try {
			targetDFT.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//translate
		PrintWriter dftWriter = null;
		try {
			dftWriter = new PrintWriter(targetDFT.getAbsolutePath());
			
			//top level gate
			dftWriter.println("toplevel \"Top_Level_Event_" + gateList.getFirst().getName() + "\";");
			
			//gates
			for (int i = 0; i < gateList.size(); i++) {
				if (i == 0) {
					dftWriter.print("\"Top_Level_Event_" + gateList.get(i).getName() + "\" ");
				}else {
					dftWriter.print("\"Gate_" + gateList.get(i).getName() + "\" ");
				}
				//dftWriter.print("\"Gate_" + gateList.get(i).getName() + "\" ");
				String type = gateList.get(i).eClass().getName();
				//System.out.println(type);
				switch (type) {
				case "AND":
					//dftWriter.print("\"AND_" + gateList.get(i).getName() + "\" ");
					dftWriter.print("and");
					break;
				case "OR":
					//dftWriter.print("\"OR_" + gateList.get(i).getName() + "\" ");
					dftWriter.print("or");
					break;
				case "PAND":
					//dftWriter.print("\"PAND_" + gateList.get(i).getName() + "\" ");
					dftWriter.print("pand");
					break;
				case "Spare":
					//dftWriter.print("\"Spare_" + gateList.get(i).getName() + "\" ");
					dftWriter.print("hsp");
					break;
				}

				//child gates and events
				LinkedList<Element> childList = new LinkedList<Element>();
				for (int j = 0; j < gateList.get(i).getChildEvent().size(); j++) {
					childList.add(gateList.get(i).getChildEvent().get(j));
				}
				for (int j = 0; j < gateList.get(i).getChildGate().size(); j++) {
					childList.add(gateList.get(i).getChildGate().get(j));
				}
				//sort the child list
				for (int j = 0; j < childList.size(); j++) {
					Collections.swap(childList, childList.indexOf(childList.get(j)), childList.get(j).getSequencePosition());
				}
				//write to file
				for (int j = 0; j < childList.size(); j++) {
					if (childList.get(j).eClass().getName() == "Event") {
						dftWriter.print(" \"Event_" + childList.get(j).getName() + "\"");
					}else {
						dftWriter.print(" \"Gate_" + childList.get(j).getName() + "\"");	
					}
				}
				dftWriter.println(";");
				
				/*//spares for spare gates
				if (type.compareTo("Spare") == 0) {
					Spare tmp =  (Spare) gateList.get(i);
					for (int j = 0; j < tmp.getSpares().size(); j++) {
						dftWriter.print("\"" + tmp.getSpares().get(j).getName() + "\"");
					}
				}
				//new line
				dftWriter.println(";");*/
			}
			
			//TODO test
			for (int i = 0; i < seqList.size(); i++) {
				dftWriter.print("\"Dep_" + seqList.get(i).getName() + "\"" + " seq");
				for (int j = 0; j < seqList.get(i).getEvents().size(); j++) {
					dftWriter.print(" \"Event_" + seqList.get(i).getEvents().get(j).getName() + "\"");
				}
				dftWriter.println(";");
			}
			//TODO dep
			for (int i = 0; i < fDepList.size(); i++) {
				dftWriter.print("\"Dep_" + fDepList.get(i).getName() + "\"" + " fdep");
				for (int j = 0; j < fDepList.get(i).getEvents().size(); j++) {
					dftWriter.print(" \"Event_" + fDepList.get(i).getEvents().get(j).getName() + "\"");
				}
				dftWriter.println(";");
			}
			
			//events
			for (int i = 0; i < eventList.size(); i++) {
				dftWriter.println("\"Event_" + eventList.get(i).getName() + "\" lambda=" + eventList.get(i).getProbability() + " dorm=1.0;");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			dftWriter.close();
		}
	}
	
	public void translateCTMCtoExplicit(CTMC ctmc, String filePath) {
		
		File traFile = new File(filePath, ctmc.getName() + ".tra");
		File labFile = new File(filePath, ctmc.getName() + ".lab");
		
		//creating the files
		//.tra
		try {
			traFile.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//.lab
		try {
			labFile.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//translate
		PrintWriter traWriter = null;
		PrintWriter labWriter = null;
		try {
			traWriter = new PrintWriter(traFile.getAbsolutePath());
			labWriter = new PrintWriter(labFile.getAbsolutePath());
			
			traWriter.println("ctmc");
			
			labWriter.println("#DECLARATION");
			labWriter.println("init done");
			labWriter.println("#END");
			labWriter.println("0 init");
			
			//first state
			for (int i = 0; i < ctmc.getStates().get(0).getOut().size(); i++) {
				String line = "0 " + ctmc.getStates().indexOf(ctmc.getStates().get(0).getOut().get(i).getTo()) + " " + ctmc.getStates().get(0).getOut().get(i).getProbability();
				traWriter.println(line);
				//labWriter.println("0 init");
			}
			
			for (int i = 1; i < ctmc.getStates().size(); i++) {
				
				if (!ctmc.getStates().get(i).getLabels().isEmpty()) {
					labWriter.println(i + " done");
				}
				if (ctmc.getStates().get(i).getOut().isEmpty()) {
					traWriter.println(i + " " + i + " " + 1);
				}
				for (int j = 0; j < ctmc.getStates().get(i).getOut().size(); j++) {
					String line = i + " " + ctmc.getStates().indexOf(ctmc.getStates().get(i).getOut().get(j).getTo()) + " " + ctmc.getStates().get(0).getOut().get(j).getProbability();
					traWriter.println(line);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			labWriter.close();
			traWriter.close();
		}
	}
	
}//end transformer
