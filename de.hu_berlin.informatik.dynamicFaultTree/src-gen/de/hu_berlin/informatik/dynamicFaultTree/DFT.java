/**
 */
package de.hu_berlin.informatik.dynamicFaultTree;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DFT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.DFT#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.DFT#getTopLevelEvent <em>Top Level Event</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.DFT#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 *
 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getDFT()
 * @model
 * @generated
 */
public interface DFT extends EObject {
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
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getDFT_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.dynamicFaultTree.DFT#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Top Level Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Level Event</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Level Event</em>' containment reference.
	 * @see #setTopLevelEvent(TopLevelEvent)
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getDFT_TopLevelEvent()
	 * @model containment="true"
	 * @generated
	 */
	TopLevelEvent getTopLevelEvent();

	/**
	 * Sets the value of the '{@link de.hu_berlin.informatik.dynamicFaultTree.DFT#getTopLevelEvent <em>Top Level Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Level Event</em>' containment reference.
	 * @see #getTopLevelEvent()
	 * @generated
	 */
	void setTopLevelEvent(TopLevelEvent value);

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.informatik.dynamicFaultTree.Dependency}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage#getDFT_Dependencies()
	 * @model containment="true"
	 * @generated
	 */
	EList<Dependency> getDependencies();

} // DFT
