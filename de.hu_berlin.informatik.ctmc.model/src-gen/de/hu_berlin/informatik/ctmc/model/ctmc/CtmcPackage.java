/**
 */
package de.hu_berlin.informatik.ctmc.model.ctmc;

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
 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CtmcFactory
 * @model kind="package"
 * @generated
 */
public interface CtmcPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ctmc";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/ctmc";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ctmc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CtmcPackage eINSTANCE = de.hu_berlin.informatik.ctmc.model.ctmc.impl.CtmcPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.CTMCImpl <em>CTMC</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.CTMCImpl
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.CtmcPackageImpl#getCTMC()
	 * @generated
	 */
	int CTMC = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CTMC__NAME = 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CTMC__STATES = 1;

	/**
	 * The number of structural features of the '<em>CTMC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CTMC_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>CTMC</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CTMC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.StateImpl
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.CtmcPackageImpl#getState()
	 * @generated
	 */
	int STATE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Exit Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__EXIT_RATE = 1;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__LABELS = 2;

	/**
	 * The feature id for the '<em><b>Out</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUT = 3;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IN = 4;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.TransitionImpl
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.CtmcPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__PROBABILITY = 1;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__DURATION = 2;

	/**
	 * The feature id for the '<em><b>From</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__FROM = 3;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TO = 4;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.LabelImpl <em>Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.LabelImpl
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.CtmcPackageImpl#getLabel()
	 * @generated
	 */
	int LABEL = 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__TEXT = 0;

	/**
	 * The feature id for the '<em><b>State</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__STATE = 1;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.ctmc.model.ctmc.CTMC <em>CTMC</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CTMC</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CTMC
	 * @generated
	 */
	EClass getCTMC();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.informatik.ctmc.model.ctmc.CTMC#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CTMC#getName()
	 * @see #getCTMC()
	 * @generated
	 */
	EAttribute getCTMC_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.informatik.ctmc.model.ctmc.CTMC#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.CTMC#getStates()
	 * @see #getCTMC()
	 * @generated
	 */
	EReference getCTMC_States();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.ctmc.model.ctmc.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getExitRate <em>Exit Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exit Rate</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.State#getExitRate()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_ExitRate();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Labels</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.State#getLabels()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Labels();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Out</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.State#getOut()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Out();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.informatik.ctmc.model.ctmc.State#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.State#getIn()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_In();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getName()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getProbability()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Probability();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getDuration()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Duration();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>From</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getFrom()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_From();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.Transition#getTo()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_To();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Label#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.Label#getText()
	 * @see #getLabel()
	 * @generated
	 */
	EAttribute getLabel_Text();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.informatik.ctmc.model.ctmc.Label#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>State</em>'.
	 * @see de.hu_berlin.informatik.ctmc.model.ctmc.Label#getState()
	 * @see #getLabel()
	 * @generated
	 */
	EReference getLabel_State();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CtmcFactory getCtmcFactory();

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
		 * The meta object literal for the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.CTMCImpl <em>CTMC</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.CTMCImpl
		 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.CtmcPackageImpl#getCTMC()
		 * @generated
		 */
		EClass CTMC = eINSTANCE.getCTMC();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CTMC__NAME = eINSTANCE.getCTMC_Name();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CTMC__STATES = eINSTANCE.getCTMC_States();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.StateImpl
		 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.CtmcPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__NAME = eINSTANCE.getState_Name();

		/**
		 * The meta object literal for the '<em><b>Exit Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__EXIT_RATE = eINSTANCE.getState_ExitRate();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__LABELS = eINSTANCE.getState_Labels();

		/**
		 * The meta object literal for the '<em><b>Out</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OUT = eINSTANCE.getState_Out();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__IN = eINSTANCE.getState_In();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.TransitionImpl
		 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.CtmcPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__NAME = eINSTANCE.getTransition_Name();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__PROBABILITY = eINSTANCE.getTransition_Probability();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__DURATION = eINSTANCE.getTransition_Duration();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__FROM = eINSTANCE.getTransition_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TO = eINSTANCE.getTransition_To();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.LabelImpl <em>Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.LabelImpl
		 * @see de.hu_berlin.informatik.ctmc.model.ctmc.impl.CtmcPackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL__TEXT = eINSTANCE.getLabel_Text();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL__STATE = eINSTANCE.getLabel_State();

	}

} //CtmcPackage
