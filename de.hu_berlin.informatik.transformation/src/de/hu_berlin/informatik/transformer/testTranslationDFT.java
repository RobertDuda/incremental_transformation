package de.hu_berlin.informatik.transformer;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.informatik.dynamicFaultTree.DFT;

public class testTranslationDFT {

	public static void main(String[] args) {
		
		//URI of dft model
		String tmp1 ="File://home/rob/runtime-EclipseApplication/Generated Models/Test3.dynamicfaulttree";
		URI testDFT1_URI = URI.createURI(tmp1);	
		
		//path for the translated model
		String path ="/home/rob/Storm/DFTs";
		
		//loading the dft
		DFT dft1;
		ModelManager dftManger1 = new ModelManager(testDFT1_URI, "dynamicfaulttree");
		dft1 = dftManger1.loadDFT();
		System.out.println("loaded first dft: " + dft1.getName());
		
		//preparing the model
		Transformer trans = new Transformer();		
		trans.preparation(dft1);
		System.out.println(dft1.getName() + " is prepared for translation");
		
		//translation
		System.out.println("translating..");
		trans.translateDFTtoGalileo(path);
		
		System.out.println("translation finished.");
	}

}
