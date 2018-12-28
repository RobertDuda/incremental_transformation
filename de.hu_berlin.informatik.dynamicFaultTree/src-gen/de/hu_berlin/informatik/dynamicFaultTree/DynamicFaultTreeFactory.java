/**
 */
package de.hu_berlin.informatik.dynamicFaultTree;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage
 * @generated
 */
public interface DynamicFaultTreeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DynamicFaultTreeFactory eINSTANCE = de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreeFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>DFT</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DFT</em>'.
	 * @generated
	 */
	DFT createDFT();

	/**
	 * Returns a new object of class '<em>Top Level Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Level Event</em>'.
	 * @generated
	 */
	TopLevelEvent createTopLevelEvent();

	/**
	 * Returns a new object of class '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event</em>'.
	 * @generated
	 */
	Event createEvent();

	/**
	 * Returns a new object of class '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence</em>'.
	 * @generated
	 */
	Sequence createSequence();

	/**
	 * Returns a new object of class '<em>Functional Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Functional Dependency</em>'.
	 * @generated
	 */
	FunctionalDependency createFunctionalDependency();

	/**
	 * Returns a new object of class '<em>AND</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AND</em>'.
	 * @generated
	 */
	AND createAND();

	/**
	 * Returns a new object of class '<em>PAND</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PAND</em>'.
	 * @generated
	 */
	PAND createPAND();

	/**
	 * Returns a new object of class '<em>OR</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OR</em>'.
	 * @generated
	 */
	OR createOR();

	/**
	 * Returns a new object of class '<em>POR</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>POR</em>'.
	 * @generated
	 */
	POR createPOR();

	/**
	 * Returns a new object of class '<em>XOR</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XOR</em>'.
	 * @generated
	 */
	XOR createXOR();

	/**
	 * Returns a new object of class '<em>Spare</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Spare</em>'.
	 * @generated
	 */
	Spare createSpare();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DynamicFaultTreePackage getDynamicFaultTreePackage();

} //DynamicFaultTreeFactory
