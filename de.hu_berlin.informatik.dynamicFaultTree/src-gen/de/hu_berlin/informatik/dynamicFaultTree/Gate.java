/**
 */
package de.hu_berlin.informatik.dynamicFaultTree;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getToplevelevent <em>Toplevelevent</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getChildGate <em>Child Gate</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getParentGate <em>Parent Gate</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getChildEvent <em>Child Event</em>}</li>
 * </ul>
 *
 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getGate()
 * @model abstract="true"
 * @generated
 */
public interface Gate extends Element {
	/**
	 * Returns the value of the '<em><b>Toplevelevent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.dynamicFaultTree.TopLevelEvent#getGate <em>Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Toplevelevent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Toplevelevent</em>' container reference.
	 * @see #setToplevelevent(TopLevelEvent)
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getGate_Toplevelevent()
	 * @see de.hu_berlin.informatik.dynamicFaultTree.TopLevelEvent#getGate
	 * @model opposite="gate" transient="false"
	 * @generated
	 */
	TopLevelEvent getToplevelevent();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getToplevelevent <em>Toplevelevent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Toplevelevent</em>' container reference.
	 * @see #getToplevelevent()
	 * @generated
	 */
	void setToplevelevent(TopLevelEvent value);

	/**
	 * Returns the value of the '<em><b>Child Gate</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.informatik.dynamicFaultTree.Gate}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getParentGate <em>Parent Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Gate</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Gate</em>' containment reference list.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getGate_ChildGate()
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Gate#getParentGate
	 * @model opposite="parentGate" containment="true"
	 * @generated
	 */
	EList<Gate> getChildGate();

	/**
	 * Returns the value of the '<em><b>Parent Gate</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getChildGate <em>Child Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Gate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Gate</em>' container reference.
	 * @see #setParentGate(Gate)
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getGate_ParentGate()
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Gate#getChildGate
	 * @model opposite="childGate" transient="false"
	 * @generated
	 */
	Gate getParentGate();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getParentGate <em>Parent Gate</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Gate</em>' container reference.
	 * @see #getParentGate()
	 * @generated
	 */
	void setParentGate(Gate value);

	/**
	 * Returns the value of the '<em><b>Child Event</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.informatik.dynamicFaultTree.Event}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.dynamicFaultTree.Event#getParentGate <em>Parent Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Event</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Event</em>' containment reference list.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getGate_ChildEvent()
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Event#getParentGate
	 * @model opposite="parentGate" containment="true"
	 * @generated
	 */
	EList<Event> getChildEvent();

} // Gate
