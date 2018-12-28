/**
 */
package de.hu_berlin.informatik.dynamicFaultTree;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Dependency#getEvents <em>Events</em>}</li>
 * </ul>
 *
 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getDependency()
 * @model abstract="true"
 * @generated
 */
public interface Dependency extends Element {
	/**
	 * Returns the value of the '<em><b>Events</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.informatik.dynamicFaultTree.Event}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.informatik.dynamicFaultTree.Event#getDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' reference list.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getDependency_Events()
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Event#getDependency
	 * @model opposite="dependency"
	 * @generated
	 */
	EList<Event> getEvents();

} // Dependency
