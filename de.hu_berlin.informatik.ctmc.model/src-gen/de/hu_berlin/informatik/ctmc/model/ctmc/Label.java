/**
 */
package de.hu_berlin.informatik.ctmc.model.ctmc;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.Label#getText <em>Text</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.Label#getState <em>State</em>}</li>
 * </ul>
 *
 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getLabel()
 * @model
 * @generated
 */
public interface Label extends EObject {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getLabel_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Label#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' container reference.
	 * @see #setState(State)
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage#getLabel_State()
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.State#getLabels
	 * @model opposite="labels" transient="false"
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Label#getState <em>State</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' container reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

} // Label
