/**
 */
package de.hu_berlin.informatik.dynamicFaultTree.impl;

import de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage;
import de.hu_berlin.informatik.dynamicFaultTree.Gate;
import de.hu_berlin.informatik.dynamicFaultTree.TopLevelEvent;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Top Level Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.TopLevelEventImpl#getGate <em>Gate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TopLevelEventImpl extends ElementImpl implements TopLevelEvent {
	/**
	 * The cached value of the '{@link #getGate() <em>Gate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGate()
	 * @generated
	 * @ordered
	 */
	protected Gate gate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopLevelEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DynamicFaultTreePackage.Literals.TOP_LEVEL_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Gate getGate() {
		return gate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGate(Gate newGate, NotificationChain msgs) {
		Gate oldGate = gate;
		gate = newGate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					DynamicFaultTreePackage.TOP_LEVEL_EVENT__GATE, oldGate, newGate);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGate(Gate newGate) {
		if (newGate != gate) {
			NotificationChain msgs = null;
			if (gate != null)
				msgs = ((InternalEObject) gate).eInverseRemove(this, DynamicFaultTreePackage.GATE__TOPLEVELEVENT,
						Gate.class, msgs);
			if (newGate != null)
				msgs = ((InternalEObject) newGate).eInverseAdd(this, DynamicFaultTreePackage.GATE__TOPLEVELEVENT,
						Gate.class, msgs);
			msgs = basicSetGate(newGate, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DynamicFaultTreePackage.TOP_LEVEL_EVENT__GATE,
					newGate, newGate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DynamicFaultTreePackage.TOP_LEVEL_EVENT__GATE:
			if (gate != null)
				msgs = ((InternalEObject) gate).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - DynamicFaultTreePackage.TOP_LEVEL_EVENT__GATE, null, msgs);
			return basicSetGate((Gate) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DynamicFaultTreePackage.TOP_LEVEL_EVENT__GATE:
			return basicSetGate(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DynamicFaultTreePackage.TOP_LEVEL_EVENT__GATE:
			return getGate();
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
		case DynamicFaultTreePackage.TOP_LEVEL_EVENT__GATE:
			setGate((Gate) newValue);
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
		case DynamicFaultTreePackage.TOP_LEVEL_EVENT__GATE:
			setGate((Gate) null);
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
		case DynamicFaultTreePackage.TOP_LEVEL_EVENT__GATE:
			return gate != null;
		}
		return super.eIsSet(featureID);
	}

} //TopLevelEventImpl
