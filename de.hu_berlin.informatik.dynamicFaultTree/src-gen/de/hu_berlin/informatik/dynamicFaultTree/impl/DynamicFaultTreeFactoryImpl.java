/**
 */
package de.hu_berlin.informatik.dynamicFaultTree.impl;

import de.hu_berlin.informatik.dynamicFaultTree.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DynamicFaultTreeFactoryImpl extends EFactoryImpl implements DynamicFaultTreeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DynamicFaultTreeFactory init() {
		try {
			DynamicFaultTreeFactory theDynamicFaultTreeFactory = (DynamicFaultTreeFactory) EPackage.Registry.INSTANCE
					.getEFactory(DynamicFaultTreePackage.eNS_URI);
			if (theDynamicFaultTreeFactory != null) {
				return theDynamicFaultTreeFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DynamicFaultTreeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicFaultTreeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case DynamicFaultTreePackage.DFT:
			return createDFT();
		case DynamicFaultTreePackage.TOP_LEVEL_EVENT:
			return createTopLevelEvent();
		case DynamicFaultTreePackage.EVENT:
			return createEvent();
		case DynamicFaultTreePackage.SEQUENCE:
			return createSequence();
		case DynamicFaultTreePackage.FUNCTIONAL_DEPENDENCY:
			return createFunctionalDependency();
		case DynamicFaultTreePackage.AND:
			return createAND();
		case DynamicFaultTreePackage.PAND:
			return createPAND();
		case DynamicFaultTreePackage.OR:
			return createOR();
		case DynamicFaultTreePackage.POR:
			return createPOR();
		case DynamicFaultTreePackage.XOR:
			return createXOR();
		case DynamicFaultTreePackage.SPARE:
			return createSpare();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DFT createDFT() {
		DFTImpl dft = new DFTImpl();
		return dft;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TopLevelEvent createTopLevelEvent() {
		TopLevelEventImpl topLevelEvent = new TopLevelEventImpl();
		return topLevelEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Event createEvent() {
		EventImpl event = new EventImpl();
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sequence createSequence() {
		SequenceImpl sequence = new SequenceImpl();
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionalDependency createFunctionalDependency() {
		FunctionalDependencyImpl functionalDependency = new FunctionalDependencyImpl();
		return functionalDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AND createAND() {
		ANDImpl and = new ANDImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PAND createPAND() {
		PANDImpl pand = new PANDImpl();
		return pand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OR createOR() {
		ORImpl or = new ORImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public POR createPOR() {
		PORImpl por = new PORImpl();
		return por;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XOR createXOR() {
		XORImpl xor = new XORImpl();
		return xor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Spare createSpare() {
		SpareImpl spare = new SpareImpl();
		return spare;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DynamicFaultTreePackage getDynamicFaultTreePackage() {
		return (DynamicFaultTreePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DynamicFaultTreePackage getPackage() {
		return DynamicFaultTreePackage.eINSTANCE;
	}

} //DynamicFaultTreeFactoryImpl
