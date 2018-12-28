package de.hu_berlin.informatik.transformer;


import java.beans.FeatureDescriptor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.annotation.Repeatable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
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
	
	//ctmc information
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
	//getters end
	
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
			
			if(tmpE.getDependency() != null && !dependencyList.contains(tmpE.getDependency())) {
				dependencyList.add(tmpE.getDependency());
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
	
	public void saveTransformationData(String folderPath, String folderName) {
		
		//make  a new folder for the data
		File tmpFolder = new File(folderPath);
		File folder = new File(tmpFolder, folderName);
		//System.out.println(folder.getAbsolutePath());
		if (!folder.exists()) {
            folder.mkdir();
        }
		
		//save the events by name(to do: make IDs)
		//1. create the file if none exists
		System.out.println(folder.getAbsolutePath());
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
		}
		
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
				stateWriter.println(Arrays.toString(stateList.get(i)));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stateWriter.close();
		}
		
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
		
		//failsafe?
		//check later
		
	}
	
}//end transformer
