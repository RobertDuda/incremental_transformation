package de.hu_berlin.informatik.transformer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.informatik.ctmc.model.ctmc.CTMC;
import de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage;
import de.hu_berlin.informatik.dynamicFaultTree.DFT;
import de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage;

/**
 * @author Robert Duda
 *This class helps to load models of dynamic fault trees and CTMCs and manages the necessary resources and resource sets.
 *It provides methods to handle the loading process and returns the models.
 */
public class ModelManager {

	private URI modelURI;
	private ResourceSet resourceSet;
	private Resource resource;
	private CtmcPackage ctmcPackage = null;
	private DynamicFaultTreePackage dftPackage = null;
	private String modelType;
	private CTMC ctmc = null;
	private DFT dft = null;
	
	public ModelManager() {
		// TODO Auto-generated constructor stub
	}
	
	public ModelManager(URI uri, String type) {
		modelURI = uri;
		resourceSet = new ResourceSetImpl();
		modelType = type;
		if (type == "ctmc") {
			ctmcPackage = CtmcPackage.eINSTANCE;
		}
		else if (type == "dynamicfaulttree") {
			dftPackage = DynamicFaultTreePackage.eINSTANCE;
		}
	}
	
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public Resource getResource() {
		return resource;
	}

	public CTMC loadCTMC() {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(modelType, new XMIResourceFactoryImpl());
		resource = resourceSet.getResource(modelURI, true);
		ctmc = (CTMC) resource.getContents().get(0);
		return ctmc;
	}
	
	public DFT loadDFT() {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(modelType, new XMIResourceFactoryImpl());
		resource = resourceSet.getResource(modelURI, true);
		dft = (DFT) resource.getContents().get(0);
		return dft;
	}

}
