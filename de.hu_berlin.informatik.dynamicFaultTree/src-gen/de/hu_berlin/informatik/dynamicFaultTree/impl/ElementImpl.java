/**
 */
package de.hu_berlin.informatik.dynamicFaultTree.impl;

import de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage;
import de.hu_berlin.informatik.dynamicFaultTree.Element;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.ElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.ElementImpl#getProbability <em>Probability</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.ElementImpl#getSequencePosition <em>Sequence Position</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.ElementImpl#getElementID <em>Element ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ElementImpl extends MinimalEObjectImpl.Container implements Element {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected static final float PROBABILITY_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected float probability = PROBABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSequencePosition() <em>Sequence Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequencePosition()
	 * @generated
	 * @ordered
	 */
	protected static final int SEQUENCE_POSITION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSequencePosition() <em>Sequence Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequencePosition()
	 * @generated
	 * @ordered
	 */
	protected int sequencePosition = SEQUENCE_POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getElementID() <em>Element ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementID()
	 * @generated
	 * @ordered
	 */
	protected static final int ELEMENT_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getElementID() <em>Element ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementID()
	 * @generated
	 * @ordered
	 */
	protected int elementID = ELEMENT_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DynamicFaultTreePackage.Literals.ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DynamicFaultTreePackage.ELEMENT__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getProbability() {
		return probability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProbability(float newProbability) {
		float oldProbability = probability;
		probability = newProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DynamicFaultTreePackage.ELEMENT__PROBABILITY,
					oldProbability, probability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSequencePosition() {
		return sequencePosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSequencePosition(int newSequencePosition) {
		int oldSequencePosition = sequencePosition;
		sequencePosition = newSequencePosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DynamicFaultTreePackage.ELEMENT__SEQUENCE_POSITION,
					oldSequencePosition, sequencePosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getElementID() {
		return elementID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElementID(int newElementID) {
		int oldElementID = elementID;
		elementID = newElementID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DynamicFaultTreePackage.ELEMENT__ELEMENT_ID,
					oldElementID, elementID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DynamicFaultTreePackage.ELEMENT__NAME:
			return getName();
		case DynamicFaultTreePackage.ELEMENT__PROBABILITY:
			return getProbability();
		case DynamicFaultTreePackage.ELEMENT__SEQUENCE_POSITION:
			return getSequencePosition();
		case DynamicFaultTreePackage.ELEMENT__ELEMENT_ID:
			return getElementID();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DynamicFaultTreePackage.ELEMENT__NAME:
			setName((String) newValue);
			return;
		case DynamicFaultTreePackage.ELEMENT__PROBABILITY:
			setProbability((Float) newValue);
			return;
		case DynamicFaultTreePackage.ELEMENT__SEQUENCE_POSITION:
			setSequencePosition((Integer) newValue);
			return;
		case DynamicFaultTreePackage.ELEMENT__ELEMENT_ID:
			setElementID((Integer) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case DynamicFaultTreePackage.ELEMENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case DynamicFaultTreePackage.ELEMENT__PROBABILITY:
			setProbability(PROBABILITY_EDEFAULT);
			return;
		case DynamicFaultTreePackage.ELEMENT__SEQUENCE_POSITION:
			setSequencePosition(SEQUENCE_POSITION_EDEFAULT);
			return;
		case DynamicFaultTreePackage.ELEMENT__ELEMENT_ID:
			setElementID(ELEMENT_ID_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case DynamicFaultTreePackage.ELEMENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case DynamicFaultTreePackage.ELEMENT__PROBABILITY:
			return probability != PROBABILITY_EDEFAULT;
		case DynamicFaultTreePackage.ELEMENT__SEQUENCE_POSITION:
			return sequencePosition != SEQUENCE_POSITION_EDEFAULT;
		case DynamicFaultTreePackage.ELEMENT__ELEMENT_ID:
			return elementID != ELEMENT_ID_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", probability: ");
		result.append(probability);
		result.append(", sequencePosition: ");
		result.append(sequencePosition);
		result.append(", elementID: ");
		result.append(elementID);
		result.append(')');
		return result.toString();
	}

} //ElementImpl
