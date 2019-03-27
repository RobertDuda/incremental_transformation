/**
 */
package de.hu_berlin.informatik.ctmc.model.ctmc;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getExitRate <em>Exit Rate</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getLabels <em>Labels</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getOut <em>Out</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getIn <em>In</em>}</li>
 * </ul>
 *
 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
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
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getState_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Exit Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Rate</em>' attribute.
	 * @see #setExitRate(float)
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getState_ExitRate()
	 * @model
	 * @generated
	 */
	float getExitRate();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getExitRate <em>Exit Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit Rate</em>' attribute.
	 * @see #getExitRate()
	 * @generated
	 */
	void setExitRate(float value);

	/**
	 * Returns the value of the '<em><b>Labels</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.informatik.ctmc.model.ctmc.Label}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Label#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Labels</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Labels</em>' containment reference list.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getState_Labels()
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.Label#getState
	 * @model opposite="state" containment="true"
	 * @generated
	 */
	EList<Label> getLabels();

	/**
	 * Returns the value of the '<em><b>Out</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out</em>' containment reference list.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getState_Out()
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getFrom
	 * @model opposite="from" containment="true"
	 * @generated
	 */
	EList<Transition> getOut();

	/**
	 * Returns the value of the '<em><b>In</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' reference list.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getState_In()
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getTo
	 * @model opposite="to"
	 * @generated
	 */
	EList<Transition> getIn();

} // State
