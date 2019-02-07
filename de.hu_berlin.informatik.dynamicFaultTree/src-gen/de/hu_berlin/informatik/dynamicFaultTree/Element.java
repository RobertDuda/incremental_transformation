/**
 */
package de.hu_berlin.informatik.dynamicFaultTree;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Element#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Element#getProbability <em>Probability</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Element#getSequencePosition <em>Sequence Position</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Element#getElementID <em>Element ID</em>}</li>
 * </ul>
 *
 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
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
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.dynamicFaultTree.Element#getName <em>Name</em>}' attribute.
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
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getElement_Probability()
	 * @model
	 * @generated
	 */
	float getProbability();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.dynamicFaultTree.Element#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(float value);

	/**
	 * Returns the value of the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Position</em>' attribute.
	 * @see #setSequencePosition(int)
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getElement_SequencePosition()
	 * @model
	 * @generated
	 */
	int getSequencePosition();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.dynamicFaultTree.Element#getSequencePosition <em>Sequence Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Position</em>' attribute.
	 * @see #getSequencePosition()
	 * @generated
	 */
	void setSequencePosition(int value);

	/**
	 * Returns the value of the '<em><b>Element ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element ID</em>' attribute.
	 * @see #setElementID(int)
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getElement_ElementID()
	 * @model
	 * @generated
	 */
	int getElementID();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.dynamicFaultTree.Element#getElementID <em>Element ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element ID</em>' attribute.
	 * @see #getElementID()
	 * @generated
	 */
	void setElementID(int value);

} // Element
