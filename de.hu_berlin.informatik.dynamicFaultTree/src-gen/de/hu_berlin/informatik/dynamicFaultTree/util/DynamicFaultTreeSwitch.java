/**
 */
package de.hu_berlin.informatik.dynamicFaultTree.util;

import de.hu_berlin.informatik.dynamicFaultTree.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage
 * @generated
 */
public class DynamicFaultTreeSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DynamicFaultTreePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicFaultTreeSwitch() {
		if (modelPackage == null) {
			modelPackage = DynamicFaultTreePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case DynamicFaultTreePackage.DFT: {
			DFT dft = (DFT) theEObject;
			T result = caseDFT(dft);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DynamicFaultTreePackage.ELEMENT: {
			Element element = (Element) theEObject;
			T result = caseElement(element);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DynamicFaultTreePackage.TOP_LEVEL_EVENT: {
			TopLevelEvent topLevelEvent = (TopLevelEvent) theEObject;
			T result = caseTopLevelEvent(topLevelEvent);
			if (result == null)
				result = caseElement(topLevelEvent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DynamicFaultTreePackage.GATE: {
			Gate gate = (Gate) theEObject;
			T result = caseGate(gate);
			if (result == null)
				result = caseElement(gate);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DynamicFaultTreePackage.EVENT: {
			Event event = (Event) theEObject;
			T result = caseEvent(event);
			if (result == null)
				result = caseElement(event);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DynamicFaultTreePackage.DEPENDENCY: {
			Dependency dependency = (Dependency) theEObject;
			T result = caseDependency(dependency);
			if (result == null)
				result = caseElement(dependency);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DynamicFaultTreePackage.SEQUENCE: {
			Sequence sequence = (Sequence) theEObject;
			T result = caseSequence(sequence);
			if (result == null)
				result = caseDependency(sequence);
			if (result == null)
				result = caseElement(sequence);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DynamicFaultTreePackage.FUNCTIONAL_DEPENDENCY: {
			FunctionalDependency functionalDependency = (FunctionalDependency) theEObject;
			T result = caseFunctionalDependency(functionalDependency);
			if (result == null)
				result = caseDependency(functionalDependency);
			if (result == null)
				result = caseElement(functionalDependency);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DynamicFaultTreePackage.AND: {
			AND and = (AND) theEObject;
			T result = caseAND(and);
			if (result == null)
				result = caseGate(and);
			if (result == null)
				result = caseElement(and);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DynamicFaultTreePackage.PAND: {
			PAND pand = (PAND) theEObject;
			T result = casePAND(pand);
			if (result == null)
				result = caseGate(pand);
			if (result == null)
				result = caseElement(pand);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DynamicFaultTreePackage.OR: {
			OR or = (OR) theEObject;
			T result = caseOR(or);
			if (result == null)
				result = caseGate(or);
			if (result == null)
				result = caseElement(or);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DynamicFaultTreePackage.POR: {
			POR por = (POR) theEObject;
			T result = casePOR(por);
			if (result == null)
				result = caseGate(por);
			if (result == null)
				result = caseElement(por);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DynamicFaultTreePackage.XOR: {
			XOR xor = (XOR) theEObject;
			T result = caseXOR(xor);
			if (result == null)
				result = caseGate(xor);
			if (result == null)
				result = caseElement(xor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DynamicFaultTreePackage.SPARE: {
			Spare spare = (Spare) theEObject;
			T result = caseSpare(spare);
			if (result == null)
				result = caseGate(spare);
			if (result == null)
				result = caseElement(spare);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DFT</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DFT</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDFT(DFT object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Top Level Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Top Level Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopLevelEvent(TopLevelEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGate(Gate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependency(Dependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequence(Sequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Functional Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Functional Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionalDependency(FunctionalDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>AND</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>AND</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAND(AND object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PAND</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PAND</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePAND(PAND object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OR</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OR</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOR(OR object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>POR</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>POR</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePOR(POR object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XOR</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XOR</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXOR(XOR object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Spare</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Spare</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpare(Spare object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DynamicFaultTreeSwitch
