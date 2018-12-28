/**
 */
package de.hu_berlin.informatik.dynamicFaultTree;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Top Level Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.TopLevelEvent#getGate <em>Gate</em>}</li>
 * </ul>
 *
 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getTopLevelEvent()
 * @model
 * @generated
 */
public interface TopLevelEvent extends Element {
	/**
	 * Returns the value of the '<em><b>Gate</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getToplevelevent <em>Toplevelevent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gate</em>' containment reference.
	 * @see #setGate(Gate)
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getTopLevelEvent_Gate()
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Gate#getToplevelevent
	 * @model opposite="toplevelevent" containment="true"
	 * @generated
	 */
	Gate getGate();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.dynamicFaultTree.TopLevelEvent#getGate <em>Gate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gate</em>' containment reference.
	 * @see #getGate()
	 * @generated
	 */
	void setGate(Gate value);

} // TopLevelEvent
