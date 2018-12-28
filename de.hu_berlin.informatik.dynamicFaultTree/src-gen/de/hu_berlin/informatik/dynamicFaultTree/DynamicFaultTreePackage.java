/**
 */
package de.hu_berlin.informatik.dynamicFaultTree;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreeFactory
 * @model kind="package"
 * @generated
 */
public interface DynamicFaultTreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dynamicFaultTree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/dynamicFaultTree";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dynamicFaultTree";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DynamicFaultTreePackage eINSTANCE = de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl
			.init();

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.DFTImpl <em>DFT</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DFTImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getDFT()
	 * @generated
	 */
	int DFT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Top Level Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFT__TOP_LEVEL_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFT__DEPENDENCIES = 2;

	/**
	 * The number of structural features of the '<em>DFT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>DFT</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DFT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.ElementImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__PROBABILITY = 1;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__FAILED = 2;

	/**
	 * The feature id for the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__SEQUENCE_POSITION = 3;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.TopLevelEventImpl <em>Top Level Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.TopLevelEventImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getTopLevelEvent()
	 * @generated
	 */
	int TOP_LEVEL_EVENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_EVENT__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_EVENT__PROBABILITY = ELEMENT__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_EVENT__FAILED = ELEMENT__FAILED;

	/**
	 * The feature id for the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_EVENT__SEQUENCE_POSITION = ELEMENT__SEQUENCE_POSITION;

	/**
	 * The feature id for the '<em><b>Gate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_EVENT__GATE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Top Level Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_EVENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Top Level Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_EVENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.GateImpl <em>Gate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.GateImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getGate()
	 * @generated
	 */
	int GATE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__PROBABILITY = ELEMENT__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__FAILED = ELEMENT__FAILED;

	/**
	 * The feature id for the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__SEQUENCE_POSITION = ELEMENT__SEQUENCE_POSITION;

	/**
	 * The feature id for the '<em><b>Toplevelevent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__TOPLEVELEVENT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Child Gate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__CHILD_GATE = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent Gate</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__PARENT_GATE = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Child Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE__CHILD_EVENT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Gate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Gate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.EventImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PROBABILITY = ELEMENT__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__FAILED = ELEMENT__FAILED;

	/**
	 * The feature id for the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__SEQUENCE_POSITION = ELEMENT__SEQUENCE_POSITION;

	/**
	 * The feature id for the '<em><b>Parent Gate</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PARENT_GATE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__DEPENDENCY = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.DependencyImpl <em>Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DependencyImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getDependency()
	 * @generated
	 */
	int DEPENDENCY = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__PROBABILITY = ELEMENT__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__FAILED = ELEMENT__FAILED;

	/**
	 * The feature id for the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__SEQUENCE_POSITION = ELEMENT__SEQUENCE_POSITION;

	/**
	 * The feature id for the '<em><b>Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__EVENTS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.SequenceImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__NAME = DEPENDENCY__NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__PROBABILITY = DEPENDENCY__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__FAILED = DEPENDENCY__FAILED;

	/**
	 * The feature id for the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__SEQUENCE_POSITION = DEPENDENCY__SEQUENCE_POSITION;

	/**
	 * The feature id for the '<em><b>Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__EVENTS = DEPENDENCY__EVENTS;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_OPERATION_COUNT = DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.FunctionalDependencyImpl <em>Functional Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.FunctionalDependencyImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getFunctionalDependency()
	 * @generated
	 */
	int FUNCTIONAL_DEPENDENCY = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEPENDENCY__NAME = DEPENDENCY__NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEPENDENCY__PROBABILITY = DEPENDENCY__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEPENDENCY__FAILED = DEPENDENCY__FAILED;

	/**
	 * The feature id for the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEPENDENCY__SEQUENCE_POSITION = DEPENDENCY__SEQUENCE_POSITION;

	/**
	 * The feature id for the '<em><b>Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEPENDENCY__EVENTS = DEPENDENCY__EVENTS;

	/**
	 * The number of structural features of the '<em>Functional Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEPENDENCY_FEATURE_COUNT = DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Functional Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONAL_DEPENDENCY_OPERATION_COUNT = DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.ANDImpl <em>AND</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.ANDImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getAND()
	 * @generated
	 */
	int AND = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__NAME = GATE__NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__PROBABILITY = GATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__FAILED = GATE__FAILED;

	/**
	 * The feature id for the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__SEQUENCE_POSITION = GATE__SEQUENCE_POSITION;

	/**
	 * The feature id for the '<em><b>Toplevelevent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__TOPLEVELEVENT = GATE__TOPLEVELEVENT;

	/**
	 * The feature id for the '<em><b>Child Gate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__CHILD_GATE = GATE__CHILD_GATE;

	/**
	 * The feature id for the '<em><b>Parent Gate</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__PARENT_GATE = GATE__PARENT_GATE;

	/**
	 * The feature id for the '<em><b>Child Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__CHILD_EVENT = GATE__CHILD_EVENT;

	/**
	 * The number of structural features of the '<em>AND</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = GATE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>AND</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATION_COUNT = GATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.PANDImpl <em>PAND</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.PANDImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getPAND()
	 * @generated
	 */
	int PAND = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAND__NAME = GATE__NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAND__PROBABILITY = GATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAND__FAILED = GATE__FAILED;

	/**
	 * The feature id for the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAND__SEQUENCE_POSITION = GATE__SEQUENCE_POSITION;

	/**
	 * The feature id for the '<em><b>Toplevelevent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAND__TOPLEVELEVENT = GATE__TOPLEVELEVENT;

	/**
	 * The feature id for the '<em><b>Child Gate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAND__CHILD_GATE = GATE__CHILD_GATE;

	/**
	 * The feature id for the '<em><b>Parent Gate</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAND__PARENT_GATE = GATE__PARENT_GATE;

	/**
	 * The feature id for the '<em><b>Child Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAND__CHILD_EVENT = GATE__CHILD_EVENT;

	/**
	 * The number of structural features of the '<em>PAND</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAND_FEATURE_COUNT = GATE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>PAND</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAND_OPERATION_COUNT = GATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.ORImpl <em>OR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.ORImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getOR()
	 * @generated
	 */
	int OR = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__NAME = GATE__NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__PROBABILITY = GATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__FAILED = GATE__FAILED;

	/**
	 * The feature id for the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__SEQUENCE_POSITION = GATE__SEQUENCE_POSITION;

	/**
	 * The feature id for the '<em><b>Toplevelevent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__TOPLEVELEVENT = GATE__TOPLEVELEVENT;

	/**
	 * The feature id for the '<em><b>Child Gate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__CHILD_GATE = GATE__CHILD_GATE;

	/**
	 * The feature id for the '<em><b>Parent Gate</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__PARENT_GATE = GATE__PARENT_GATE;

	/**
	 * The feature id for the '<em><b>Child Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__CHILD_EVENT = GATE__CHILD_EVENT;

	/**
	 * The number of structural features of the '<em>OR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = GATE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>OR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATION_COUNT = GATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.PORImpl <em>POR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.PORImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getPOR()
	 * @generated
	 */
	int POR = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POR__NAME = GATE__NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POR__PROBABILITY = GATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POR__FAILED = GATE__FAILED;

	/**
	 * The feature id for the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POR__SEQUENCE_POSITION = GATE__SEQUENCE_POSITION;

	/**
	 * The feature id for the '<em><b>Toplevelevent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POR__TOPLEVELEVENT = GATE__TOPLEVELEVENT;

	/**
	 * The feature id for the '<em><b>Child Gate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POR__CHILD_GATE = GATE__CHILD_GATE;

	/**
	 * The feature id for the '<em><b>Parent Gate</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POR__PARENT_GATE = GATE__PARENT_GATE;

	/**
	 * The feature id for the '<em><b>Child Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POR__CHILD_EVENT = GATE__CHILD_EVENT;

	/**
	 * The number of structural features of the '<em>POR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POR_FEATURE_COUNT = GATE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>POR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POR_OPERATION_COUNT = GATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.XORImpl <em>XOR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.XORImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getXOR()
	 * @generated
	 */
	int XOR = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__NAME = GATE__NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__PROBABILITY = GATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__FAILED = GATE__FAILED;

	/**
	 * The feature id for the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__SEQUENCE_POSITION = GATE__SEQUENCE_POSITION;

	/**
	 * The feature id for the '<em><b>Toplevelevent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__TOPLEVELEVENT = GATE__TOPLEVELEVENT;

	/**
	 * The feature id for the '<em><b>Child Gate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__CHILD_GATE = GATE__CHILD_GATE;

	/**
	 * The feature id for the '<em><b>Parent Gate</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__PARENT_GATE = GATE__PARENT_GATE;

	/**
	 * The feature id for the '<em><b>Child Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__CHILD_EVENT = GATE__CHILD_EVENT;

	/**
	 * The number of structural features of the '<em>XOR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_FEATURE_COUNT = GATE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>XOR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_OPERATION_COUNT = GATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.SpareImpl <em>Spare</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.SpareImpl
	 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getSpare()
	 * @generated
	 */
	int SPARE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARE__NAME = GATE__NAME;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARE__PROBABILITY = GATE__PROBABILITY;

	/**
	 * The feature id for the '<em><b>Failed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARE__FAILED = GATE__FAILED;

	/**
	 * The feature id for the '<em><b>Sequence Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARE__SEQUENCE_POSITION = GATE__SEQUENCE_POSITION;

	/**
	 * The feature id for the '<em><b>Toplevelevent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARE__TOPLEVELEVENT = GATE__TOPLEVELEVENT;

	/**
	 * The feature id for the '<em><b>Child Gate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARE__CHILD_GATE = GATE__CHILD_GATE;

	/**
	 * The feature id for the '<em><b>Parent Gate</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARE__PARENT_GATE = GATE__PARENT_GATE;

	/**
	 * The feature id for the '<em><b>Child Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARE__CHILD_EVENT = GATE__CHILD_EVENT;

	/**
	 * The feature id for the '<em><b>Spares</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARE__SPARES = GATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Spare</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARE_FEATURE_COUNT = GATE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Spare</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPARE_OPERATION_COUNT = GATE_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.DFT <em>DFT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DFT</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DFT
	 * @generated
	 */
	EClass getDFT();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.informatik.dynamicFaultTree.DFT#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DFT#getName()
	 * @see #getDFT()
	 * @generated
	 */
	EAttribute getDFT_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.hu_berlin.informatik.dynamicFaultTree.DFT#getTopLevelEvent <em>Top Level Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Top Level Event</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DFT#getTopLevelEvent()
	 * @see #getDFT()
	 * @generated
	 */
	EReference getDFT_TopLevelEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.informatik.dynamicFaultTree.DFT#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.DFT#getDependencies()
	 * @see #getDFT()
	 * @generated
	 */
	EReference getDFT_Dependencies();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.informatik.dynamicFaultTree.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.informatik.dynamicFaultTree.Element#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Element#getProbability()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Probability();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.informatik.dynamicFaultTree.Element#isFailed <em>Failed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failed</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Element#isFailed()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Failed();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.informatik.dynamicFaultTree.Element#getSequencePosition <em>Sequence Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequence Position</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Element#getSequencePosition()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_SequencePosition();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.TopLevelEvent <em>Top Level Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level Event</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.TopLevelEvent
	 * @generated
	 */
	EClass getTopLevelEvent();

	/**
	 * Returns the meta object for the containment reference '{@link de.hu_berlin.informatik.dynamicFaultTree.TopLevelEvent#getGate <em>Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Gate</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.TopLevelEvent#getGate()
	 * @see #getTopLevelEvent()
	 * @generated
	 */
	EReference getTopLevelEvent_Gate();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.Gate <em>Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gate</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Gate
	 * @generated
	 */
	EClass getGate();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getToplevelevent <em>Toplevelevent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Toplevelevent</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Gate#getToplevelevent()
	 * @see #getGate()
	 * @generated
	 */
	EReference getGate_Toplevelevent();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getChildGate <em>Child Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child Gate</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Gate#getChildGate()
	 * @see #getGate()
	 * @generated
	 */
	EReference getGate_ChildGate();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getParentGate <em>Parent Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Gate</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Gate#getParentGate()
	 * @see #getGate()
	 * @generated
	 */
	EReference getGate_ParentGate();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.informatik.dynamicFaultTree.Gate#getChildEvent <em>Child Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child Event</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Gate#getChildEvent()
	 * @see #getGate()
	 * @generated
	 */
	EReference getGate_ChildEvent();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.informatik.dynamicFaultTree.Event#getParentGate <em>Parent Gate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Gate</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Event#getParentGate()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_ParentGate();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.informatik.dynamicFaultTree.Event#getDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dependency</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Event#getDependency()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Dependency();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.Dependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Dependency
	 * @generated
	 */
	EClass getDependency();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.informatik.dynamicFaultTree.Dependency#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Events</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Dependency#getEvents()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Events();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.FunctionalDependency <em>Functional Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Functional Dependency</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.FunctionalDependency
	 * @generated
	 */
	EClass getFunctionalDependency();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.AND <em>AND</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AND</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.AND
	 * @generated
	 */
	EClass getAND();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.PAND <em>PAND</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PAND</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.PAND
	 * @generated
	 */
	EClass getPAND();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.OR <em>OR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OR</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.OR
	 * @generated
	 */
	EClass getOR();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.POR <em>POR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>POR</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.POR
	 * @generated
	 */
	EClass getPOR();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.XOR <em>XOR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XOR</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.XOR
	 * @generated
	 */
	EClass getXOR();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.dynamicFaultTree.Spare <em>Spare</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Spare</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Spare
	 * @generated
	 */
	EClass getSpare();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.informatik.dynamicFaultTree.Spare#getSpares <em>Spares</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Spares</em>'.
	 * @see de.hu_berlin.informatik.dynamicFaultTree.Spare#getSpares()
	 * @see #getSpare()
	 * @generated
	 */
	EReference getSpare_Spares();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DynamicFaultTreeFactory getDynamicFaultTreeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.DFTImpl <em>DFT</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DFTImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getDFT()
		 * @generated
		 */
		EClass DFT = eINSTANCE.getDFT();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DFT__NAME = eINSTANCE.getDFT_Name();

		/**
		 * The meta object literal for the '<em><b>Top Level Event</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFT__TOP_LEVEL_EVENT = eINSTANCE.getDFT_TopLevelEvent();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DFT__DEPENDENCIES = eINSTANCE.getDFT_Dependencies();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.ElementImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__PROBABILITY = eINSTANCE.getElement_Probability();

		/**
		 * The meta object literal for the '<em><b>Failed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__FAILED = eINSTANCE.getElement_Failed();

		/**
		 * The meta object literal for the '<em><b>Sequence Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__SEQUENCE_POSITION = eINSTANCE.getElement_SequencePosition();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.TopLevelEventImpl <em>Top Level Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.TopLevelEventImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getTopLevelEvent()
		 * @generated
		 */
		EClass TOP_LEVEL_EVENT = eINSTANCE.getTopLevelEvent();

		/**
		 * The meta object literal for the '<em><b>Gate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_LEVEL_EVENT__GATE = eINSTANCE.getTopLevelEvent_Gate();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.GateImpl <em>Gate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.GateImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getGate()
		 * @generated
		 */
		EClass GATE = eINSTANCE.getGate();

		/**
		 * The meta object literal for the '<em><b>Toplevelevent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GATE__TOPLEVELEVENT = eINSTANCE.getGate_Toplevelevent();

		/**
		 * The meta object literal for the '<em><b>Child Gate</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GATE__CHILD_GATE = eINSTANCE.getGate_ChildGate();

		/**
		 * The meta object literal for the '<em><b>Parent Gate</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GATE__PARENT_GATE = eINSTANCE.getGate_ParentGate();

		/**
		 * The meta object literal for the '<em><b>Child Event</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GATE__CHILD_EVENT = eINSTANCE.getGate_ChildEvent();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.EventImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Parent Gate</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__PARENT_GATE = eINSTANCE.getEvent_ParentGate();

		/**
		 * The meta object literal for the '<em><b>Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__DEPENDENCY = eINSTANCE.getEvent_Dependency();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.DependencyImpl <em>Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DependencyImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getDependency()
		 * @generated
		 */
		EClass DEPENDENCY = eINSTANCE.getDependency();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPENDENCY__EVENTS = eINSTANCE.getDependency_Events();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.SequenceImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.FunctionalDependencyImpl <em>Functional Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.FunctionalDependencyImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getFunctionalDependency()
		 * @generated
		 */
		EClass FUNCTIONAL_DEPENDENCY = eINSTANCE.getFunctionalDependency();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.ANDImpl <em>AND</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.ANDImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getAND()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAND();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.PANDImpl <em>PAND</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.PANDImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getPAND()
		 * @generated
		 */
		EClass PAND = eINSTANCE.getPAND();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.ORImpl <em>OR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.ORImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getOR()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOR();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.PORImpl <em>POR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.PORImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getPOR()
		 * @generated
		 */
		EClass POR = eINSTANCE.getPOR();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.XORImpl <em>XOR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.XORImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getXOR()
		 * @generated
		 */
		EClass XOR = eINSTANCE.getXOR();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.dynamicFaultTree.impl.SpareImpl <em>Spare</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.SpareImpl
		 * @see de.hu_berlin.informatik.dynamicFaultTree.impl.DynamicFaultTreePackageImpl#getSpare()
		 * @generated
		 */
		EClass SPARE = eINSTANCE.getSpare();

		/**
		 * The meta object literal for the '<em><b>Spares</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPARE__SPARES = eINSTANCE.getSpare_Spares();

	}

} //DynamicFaultTreePackage
