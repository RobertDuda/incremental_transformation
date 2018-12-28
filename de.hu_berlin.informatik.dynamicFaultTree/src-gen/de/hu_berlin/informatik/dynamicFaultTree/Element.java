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
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Element#isFailed <em>Failed</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Element#getSequencePosition <em>Sequence Position</em>}</li>
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
	 * Returns the value of the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failed</em>' attribute.
	 * @see #setFailed(boolean)
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getElement_Failed()
	 * @model
	 * @generated
	 */
	boolean isFailed();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.dynamicFaultTree.Element#isFailed <em>Failed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failed</em>' attribute.
	 * @see #isFailed()
	 * @generated
	 */
	void setFailed(boolean value);

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

} // Element
