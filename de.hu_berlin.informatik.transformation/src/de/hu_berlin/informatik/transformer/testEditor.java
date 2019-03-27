package de.hu_berlin.informatik.transformer;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.informatik.dynamicFaultTree.*;

public class testEditor {

	public static void main(String[] args) {
		
		String uri = "/home/rob/runtime-EclipseApplication/Generated Models/Editor.dynamicfaulttree";
		
		DynamicFaultTreePackage.eINSTANCE.eClass();
		DynamicFaultTreeFactory factory = DynamicFaultTreeFactory.eINSTANCE;
		DFT dft = factory.createDFT();
		dft.setName("Editor");
		
		TopLevelEvent tle = factory.createTopLevelEvent();
		tle.setName("tle");
		tle.setElementID(0);
		dft.setTopLevelEvent(tle);
		
		OR or = factory.createOR();
		or.setName("or");
		or.setElementID(1);
		or.setToplevelevent(tle);
		tle.setGate(or);
		
		Event ev1 = factory.createEvent();
		ev1.setName("ev1");
		ev1.setProbability(0.1f);
		ev1.setElementID(2);
		ev1.setSequencePosition(0);
		ev1.setParentGate(or);
		or.getChildEvent().add(ev1);
		
		Event ev2 = factory.createEvent();
		ev2.setName("ev2");
		ev2.setProbability(0.2f);
		ev2.setElementID(3);
		ev2.setSequencePosition(1);
		ev2.setParentGate(or);
		or.getChildEvent().add(ev2);
		
		//TESTING 
		
		/*//TLE
		AND and = factory.createAND();
	    and.setName(or.getName());
	    and.setElementID(or.getElementID());
	    and.getChildEvent().addAll(or.getChildEvent());
	    tle.setGate(and);
	    and.setToplevelevent(tle);
		*/
		
		//child gate
		AND and = factory.createAND();
		and.setElementID(3);
		and.setName("and");
		and.setSequencePosition(2);
		or.getChildGate().add(and);
		and.setParentGate(or);
		
		Event ev3 = factory.createEvent();
		ev3.setName("ev3");
		ev3.setProbability(0.3f);
		ev3.setElementID(4);
		ev3.setSequencePosition(0);
		ev3.setParentGate(and);
		and.getChildEvent().add(ev3);
		
		Event ev4 = factory.createEvent();
		ev4.setName("ev4");
		ev4.setProbability(0.4f);
		ev4.setElementID(5);
		ev4.setSequencePosition(1);
		ev4.setParentGate(and);
		and.getChildEvent().add(ev4);
		
		Spare spare = factory.createSpare();
		spare.setName("spare");
		spare.setElementID(10);
		and.getChildGate().add(spare);
		spare.setParentGate(and);
		
		//changing child gate
		PAND pand = factory.createPAND();
		pand.setName(and.getName());
		pand.setElementID(and.getElementID());
		pand.setSequencePosition(and.getSequencePosition());
		pand.getChildEvent().addAll(and.getChildEvent());
		pand.getChildGate().addAll(and.getChildGate());
		or.getChildGate().set(or.getChildGate().indexOf(and), pand);
		pand.setParentGate(or);
		
		//TESTING END

		//save
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
}
