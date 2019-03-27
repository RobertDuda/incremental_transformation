/**
 */
package de.hu_berlin.informatik.ctmc.model.ctmc;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getProbability <em>Probability</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getDuration <em>Duration</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getFrom <em>From</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getTo <em>To</em>}</li>
 * </ul>
 *
 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject {
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
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getTransition_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probability</em>' attribute.
	 * @see #setProbability(float)
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getTransition_Probability()
	 * @model
	 * @generated
	 */
	float getProbability();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(float value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(float)
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getTransition_Duration()
	 * @model
	 * @generated
	 */
	float getDuration();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(float value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' container reference.
	 * @see #setFrom(State)
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getTransition_From()
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.State#getOut
	 * @model opposite="out" required="true" transient="false"
	 * @generated
	 */
	State getFrom();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getFrom <em>From</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' container reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(State value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(State)
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getTransition_To()
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.State#getIn
	 * @model opposite="in" required="true"
	 * @generated
	 */
	State getTo();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(State value);

} // Transition
