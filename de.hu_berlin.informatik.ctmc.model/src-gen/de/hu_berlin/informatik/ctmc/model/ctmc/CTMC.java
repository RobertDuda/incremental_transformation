/**
 */
package de.hu_berlin.informatik.ctmc.model.ctmc;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CTMC</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.CTMC#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.CTMC#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getCTMC()
 * @model
 * @generated
 */
public interface CTMC extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getCTMC_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.CTMC#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.informatik.ctmc.model.ctmc.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getCTMC_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

} // CTMC
