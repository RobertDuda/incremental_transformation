/**
 */
package de.hu_berlin.informatik.dynamicFaultTree.util;

import de.hu_berlin.informatik.dynamicFaultTree.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage
 * @generated
 */
public class DynamicFaultTreeAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DynamicFaultTreePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicFaultTreeAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DynamicFaultTreePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicFaultTreeSwitch<Adapter> modelSwitch = new DynamicFaultTreeSwitch<Adapter>() {
		@Override
		public Adapter caseDFT(DFT object) {
			return createDFTAdapter();
		}

		@Override
		public Adapter caseElement(Element object) {
			return createElementAdapter();
		}

		@Override
		public Adapter caseTopLevelEvent(TopLevelEvent object) {
			return createTopLevelEventAdapter();
		}

		@Override
		public Adapter caseGate(Gate object) {
			return createGateAdapter();
		}

		@Override
		public Adapter caseEvent(Event object) {
			return createEventAdapter();
		}

		@Override
		public Adapter caseDependency(Dependency object) {
			return createDependencyAdapter();
		}

		@Override
		public Adapter caseSequence(Sequence object) {
			return createSequenceAdapter();
		}

		@Override
		public Adapter caseFunctionalDependency(FunctionalDependency object) {
			return createFunctionalDependencyAdapter();
		}

		@Override
		public Adapter caseAND(AND object) {
			return createANDAdapter();
		}

		@Override
		public Adapter casePAND(PAND object) {
			return createPANDAdapter();
		}

		@Override
		public Adapter caseOR(OR object) {
			return createORAdapter();
		}

		@Override
		public Adapter casePOR(POR object) {
			return createPORAdapter();
		}

		@Override
		public Adapter caseXOR(XOR object) {
			return createXORAdapter();
		}

		@Override
		public Adapter caseSpare(Spare object) {
			return createSpareAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.DFT <em>DFT</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DFT
	 * @generated
	 */
	public Adapter createDFTAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.TopLevelEvent <em>Top Level Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.TopLevelEvent
	 * @generated
	 */
	public Adapter createTopLevelEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.Gate <em>Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Gate
	 * @generated
	 */
	public Adapter createGateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Dependency
	 * @generated
	 */
	public Adapter createDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Sequence
	 * @generated
	 */
	public Adapter createSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.FunctionalDependency <em>Functional Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.FunctionalDependency
	 * @generated
	 */
	public Adapter createFunctionalDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.AND <em>AND</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.AND
	 * @generated
	 */
	public Adapter createANDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.PAND <em>PAND</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.PAND
	 * @generated
	 */
	public Adapter createPANDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.OR <em>OR</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.OR
	 * @generated
	 */
	public Adapter createORAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.POR <em>POR</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.POR
	 * @generated
	 */
	public Adapter createPORAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.XOR <em>XOR</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.XOR
	 * @generated
	 */
	public Adapter createXORAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.informatik.dynamicFaultTree.Spare <em>Spare</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Spare
	 * @generated
	 */
	public Adapter createSpareAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DynamicFaultTreeAdapterFactory
