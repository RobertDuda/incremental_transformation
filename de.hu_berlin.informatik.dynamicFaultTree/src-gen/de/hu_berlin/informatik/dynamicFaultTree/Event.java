/**
 */
package de.hu_berlin.informatik.dynamicFaultTree;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Event#getParentGate <em>Parent Gate</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Event#getDependency <em>Dependency</em>}</li>
 * </ul>
 *
 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends Element {
	/**
	 * Returns the value of the '<em><b>Parent Gate</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getChildEvent <em>Child Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Gate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Gate</em>' container reference.
	 * @see #setParentGate(Gate)
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getEvent_ParentGate()
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Gate#getChildEvent
	 * @model opposite="childEvent" transient="false"
	 * @generated
	 */
	Gate getParentGate();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.dynamicFaultTree.Event#getParentGate <em>Parent Gate</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Gate</em>' container reference.
	 * @see #getParentGate()
	 * @generated
	 */
	void setParentGate(Gate value);

	/**
	 * Returns the value of the '<em><b>Dependency</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.informatik.dynamicFaultTree.Dependency}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.dynamicFaultTree.Dependency#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency</em>' reference list.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getEvent_Dependency()
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Dependency#getEvents
	 * @model opposite="events"
	 * @generated
	 */
	EList<Dependency> getDependency();

} // Event
