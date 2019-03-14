package de.hu_berlin.informatik.transformer;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.informatik.ctmc.model.ctmc.CTMC;

public class testTranslationCTMC {

	public static void main(String[] args) {
		
		//URI of dft model
		String tmp1 ="File://home/rob/runtime-EclipseApplication/Models/5. Add event/AddEvent.ctmc";
		URI testDFT1_URI = URI.createURI(tmp1);	
		
		//path for the translated model
		String path ="/home/rob/Storm/CTMCs";
		
		//loading the dft
		CTMC ctmc1;
		ModelManager dftManger1 = new ModelManager(testDFT1_URI, "ctmc");
		ctmc1 = dftManger1.loadCTMC();
		System.out.println("loaded first dft: " + ctmc1.getName());
		
		//preparing the model
		Transformer trans = new Transformer();		
		System.out.println(ctmc1.getName() + " is prepared for translation");
		
		//translation
		System.out.println("translating...");
		trans.translateCTMCtoExplicit(ctmc1, path);;
		
		System.out.println("translation finished.");
	}

}
