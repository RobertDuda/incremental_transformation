/**
 */
package de.hu_berlin.informatik.dynamicFaultTree;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spare</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.Spare#getSpares <em>Spares</em>}</li>
 * </ul>
 *
 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getSpare()
 * @model
 * @generated
 */
public interface Spare extends Gate {
	/**
	 * Returns the value of the '<em><b>Spares</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.informatik.dynamicFaultTree.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spares</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spares</em>' reference list.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getSpare_Spares()
	 * @model
	 * @generated
	 */
	EList<Event> getSpares();

} // Spare
