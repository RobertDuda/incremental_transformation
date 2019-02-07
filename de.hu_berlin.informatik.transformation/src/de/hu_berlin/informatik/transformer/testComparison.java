package de.hu_berlin.informatik.transformer;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.informatik.ctmc.model.ctmc.CTMC;
import de.hu_berlin.informatik.dynamicFaultTree.DFT;
import de.hu_berlin.informatik.dynamicFaultTree.Event;

public class testComparison {

	public static void main(String[] args) {
		 
		//URIs of models
		//dft 1 
		String tmp1 ="File:/home/rob/runtime-EclipseApplication/TestModels/2.Label update/LabelTest.dynamicfaulttree";
		URI testDFT1_URI = URI.createURI(tmp1);
		//dft 2
		//String tmp2 ="File:/home/rob/runtime-EclipseApplication/TestModels/Test.dynamicfaulttree";
		String tmp2 ="File:/home/rob/runtime-EclipseApplication/TestModels/2.Label update/Label Data/LabelOld.dynamicfaulttree";
		URI testDFT2_URI = URI.createURI(tmp2);
		
		//ctmc 1
		String tmp3 ="File:/home/rob/runtime-EclipseApplication/TestModels/2.Label update/LabelTest.ctmc";
		URI testCTMC_URI = URI.createURI(tmp3);
		
		
		//loading the models
		//dft 1
		DFT dft1;
		ModelManager dftManger1 = new ModelManager(testDFT1_URI, "dynamicfaulttree");
		dft1 = dftManger1.loadDFT();
		System.out.println("loaded first dft: " + dft1.getName());
		//dft 2
		DFT dft2;
		ModelManager dftManger2 = new ModelManager(testDFT2_URI, "dynamicfaulttree");
		dft2 = dftManger2.loadDFT();
		System.out.println("loaded second dft: " + dft2.getName());
		//ctmc 1
		CTMC ctmc1;
		ModelManager ctmcManager1 = new ModelManager(testCTMC_URI, "ctmc");
		ctmc1 = ctmcManager1.loadCTMC();
		System.out.println("loaded first ctmc: " + ctmc1.getName());
		
		//preparing the models
		Transformer trans = new Transformer();		
		//model 1
		trans.preparation(dft1);
		System.out.println(dft1.getName() + " is prepared for comparison:");
		
		//checking the lists...
		System.out.println("gate list... ");
		for(int i = 0; i < trans.getGateList().size(); i++) {
			System.out.println(trans.getGateList().get(i).getName());
		}
		System.out.println("event list... ");
		for(int j = 0; j < trans.getEventList().size(); j++) {
			System.out.println(trans.getEventList().get(j).getName());
		}
		System.out.println("dependency list... ");
		for(int k = 0; k < trans.getDependencyList().size(); k++) {
			System.out.println(trans.getDependencyList().get(k).getName());
		}
		System.out.println("seq list... ");
		for(int l = 0; l < trans.getSeqList().size(); l++) {
			System.out.println(trans.getSeqList().get(l).getName());
		}
		System.out.println("fdep list... ");
		for(int m = 0; m < trans.getFunctionalDependencyList().size(); m++) {
			System.out.println(trans.getFunctionalDependencyList().get(m).getName());
		}
		
		//model 2
		trans.preparationOldDft(dft2);
		System.out.println(dft2.getName() + " is prepared for comparison:");
		
		//checking the lists...
		System.out.println("gate list... ");
		for(int i = 0; i < trans.getOldGateList().size(); i++) {
			System.out.println(trans.getOldGateList().get(i).getName());
		}
		System.out.println("event list... ");
		for(int j = 0; j < trans.getOldEventList().size(); j++) {
			System.out.println(trans.getOldEventList().get(j).getName());
		}
		System.out.println("dependency list... ");
		for(int k = 0; k < trans.getOldDependencyList().size(); k++) {
			System.out.println(trans.getOldDependencyList().get(k).getName());
		}
		System.out.println("seq list... ");
		for(int l = 0; l < trans.getOldSeqList().size(); l++) {
			System.out.println(trans.getOldSeqList().get(l).getName());
		}
		System.out.println("fdep list... ");
		for(int m = 0; m < trans.getOldFunctionalDependencyList().size(); m++) {
			System.out.println(trans.getOldFunctionalDependencyList().get(m).getName());
		}
		
		//ctmc 1
		System.out.println("loaded ctmc " + ctmc1.getName());
		System.out.println("states...");
		for (int i = 0; i < ctmc1.getStates().size(); i++) {
			System.out.println(ctmc1.getStates().get(i).getName());
			if (!ctmc1.getStates().get(i).getOut().isEmpty()) {
				for (int j = 0; j < ctmc1.getStates().get(i).getOut().size(); j++) {
					System.out.println("has transition " + ctmc1.getStates().get(i).getOut().get(j).getName() 
							+ " to " + ctmc1.getStates().get(i).getOut().get(j).getTo().getName() + " with " 
							+ ctmc1.getStates().get(i).getOut().get(j).getProbability() + "%");
				}
			}
			if (!ctmc1.getStates().get(i).getLabels().isEmpty()) {
				for (int j = 0; j < ctmc1.getStates().get(i).getLabels().size(); j++) {
					System.out.println("has label " + ctmc1.getStates().get(i).getLabels().get(j).getText());
				}
			}
		}
		
		
		//testing start
		System.out.println("\nstarting tests...");
		
		//comparison
		System.out.println("starting comparison...");
		
		trans.compareDfts(dft1, dft2);
		//trans.compareGates(dft1.getTopLevelEvent().getGate(), dft2.getTopLevelEvent().getGate());
		//trans.compareEvents(trans.getEventList().getFirst(), trans.getOldEventList().getFirst());
		//trans.compareDependencies(dft1.getDependencies().get(0), dft1.getDependencies().get(0));
		
		System.out.println("");
		//difference list
		for (int i = 0; i < trans.getDifferenceList().size(); i++) {
			System.out.println("Difference " + i + ": " + trans.getDifferenceList().get(i));
			System.out.println("Priority: " + trans.getDifferenceList().get(i).getPriority());
			System.out.println("Type: " + trans.getDifferenceList().get(i).getType());
			if (trans.getDifferenceList().get(i).getRefNew() != null) {
				System.out.println("New reference: " + trans.getDifferenceList().get(i).getRefNew().getName() + ", " + trans.getDifferenceList().get(i).getRefNew().getElementID());
			}else {
				System.out.println("New reference doesn't exist");
			}
			if (trans.getDifferenceList().get(i).getRefOld() != null) {
				System.out.println("Old reference: " + trans.getDifferenceList().get(i).getRefOld().getName() + ", " + trans.getDifferenceList().get(i).getRefOld().getElementID());
			}else {
				System.out.println("Old reference doesn't exist");
			}
			System.out.println("Difference nr.: " + trans.getDifferenceList().get(i).getDifference() + "\n");
		}		
		
		//comparison end
		System.out.println("comparison end\n");
		
		//load old states
		/*String oldStates = "/home/rob/runtime-EclipseApplication/TestModels/1.Label update/Label Data/States.txt";
		System.out.println("loading states of " + ctmc1.getName() + "...");
		trans.loadOldStates(oldStates);
		for (int i = 0; i < trans.getOldStateList().size(); i++) {
			for (int j = 0; j < trans.getOldStateList().get(i).length; j++) {
				System.out.print(trans.getOldStateList().get(i)[j]);
			}
			System.out.println("");
		}
		*/
		//load old states end
		
		//incremental transformation
		System.out.println("starting incremental transformation...");
		trans.incrementalTransformation(ctmc1);
		
		//transition list
		/*for (int i = 0; i < trans.getOldTransitionList().size(); i++) {
			System.out.println(trans.getOldTransitionList().get(i));
		}*/
		
		//output to check changes
		for (int i = 0; i < ctmc1.getStates().size(); i++) {
			System.out.println(ctmc1.getStates().get(i).getName());
			if (!ctmc1.getStates().get(i).getOut().isEmpty()) {
				for (int j = 0; j < ctmc1.getStates().get(i).getOut().size(); j++) {
					System.out.println("has transition " + ctmc1.getStates().get(i).getOut().get(j).getName() 
							+ " to " + ctmc1.getStates().get(i).getOut().get(j).getTo().getName() + " with " 
							+ ctmc1.getStates().get(i).getOut().get(j).getProbability() + "%");
				}
			}
			if (!ctmc1.getStates().get(i).getLabels().isEmpty()) {
				for (int j = 0; j < ctmc1.getStates().get(i).getLabels().size(); j++) {
					System.out.println("has label " + ctmc1.getStates().get(i).getLabels().get(j).getText());
				}
			}
		}
		
		//test end
		System.out.println("test end");
	}

}
