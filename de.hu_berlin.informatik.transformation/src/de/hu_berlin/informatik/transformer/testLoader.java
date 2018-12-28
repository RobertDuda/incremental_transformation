package de.hu_berlin.informatik.transformer;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.logging.Handler;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl.AbsoluteCrossBundleAware;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.hu_berlin.informatik.ctmc.model.ctmc.CTMC;
import de.hu_berlin.informatik.ctmc.model.ctmc.CtmcFactory;
import de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage;
import de.hu_berlin.informatik.ctmc.model.ctmc.State;
import de.hu_berlin.informatik.dynamicFaultTree.DFT;

public class testLoader {

	public static void main(String[] args) {
		
		String tmp ="File:///C:/Users/Rob X220/runtime-EclipseApplication/de.hu_berlin.informatik.UpdateDFTs/Huge.dynamicfaulttree";
		URI testDFT_URI = URI.createURI(tmp);
		String uri = "/C:/Users/Rob%20X220/runtime-EclipseApplication/de.hu_berlin.informatik.UpdateCTMCs/Huge.ctmc";
		
		
		DFT dft;
		ModelManager dftManger = new ModelManager(testDFT_URI, "dynamicfaulttree");
		dft = dftManger.loadDFT();
		System.out.println("loaded dft: " + dft.getName());
		
		//test the transformation
		Transformer dftToCdmc = new Transformer();
		dftToCdmc.preparation(dft);
		System.out.println("dft is prepared for transformation");
		
		//checking the lists...
		System.out.println("gate list... ");
		for(int i = 0; i < dftToCdmc.getGateList().size(); i++) {
			System.out.println(dftToCdmc.getGateList().get(i).getName());
		}
		System.out.println("event list... ");
		for(int j = 0; j < dftToCdmc.getEventList().size(); j++) {
			System.out.println(dftToCdmc.getEventList().get(j).getName());
		}
		System.out.println("dependency list... ");
		for(int k = 0; k < dftToCdmc.getDependencyList().size(); k++) {
			System.out.println(dftToCdmc.getDependencyList().get(k).getName());
		}
		System.out.println("seq list... ");
		for(int l = 0; l < dftToCdmc.getSeqList().size(); l++) {
			System.out.println(dftToCdmc.getSeqList().get(l).getName());
		}
		System.out.println("fdep list... ");
		for(int m = 0; m < dftToCdmc.getFunctionalDependencyList().size(); m++) {
			System.out.println(dftToCdmc.getFunctionalDependencyList().get(m).getName());
		}
		
		//test duplicate
		
		
		//dftToCdmc.transformation(true); merging, probably shelved
		dftToCdmc.transformation();
		
		//String uri = "/C:/Users/Rob%20X220/runtime-EclipseApplication/de.hu_berlin.informatik.UpdateCTMCs/and3.ctmc";
		
		dftToCdmc.buildCTMC(uri);
		
		System.out.println("transformed like a boss!");
		//transformation test end
		
		
		//testing preserving data for incremental transformation/update
		String folderPath = "C:/Users/Rob X220/runtime-EclipseApplication/de.hu_berlin.informatik.UpdateDFTs/Example/";
		/*File currentFolder = new File(folder);
		File workingFolder = new File(currentFolder, "DATA2");
		System.out.println(workingFolder.getAbsolutePath());
		if (!workingFolder.exists()) {
            workingFolder.mkdir();
        }*/
		String folderName = dft.getName() + " Data";
		dftToCdmc.saveTransformationData(folderPath, folderName);
		System.out.println("made a new folder at " + folderPath+folderName);
		
		//end of test
		System.out.println("ok!spaghetti better than mod pizza?");
		

	}

}
