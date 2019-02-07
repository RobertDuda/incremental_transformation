/**
 */
package de.hu_berlin.informatik.dynamicFaultTree.impl;

import de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage;
import de.hu_berlin.informatik.dynamicFaultTree.Event;
import de.hu_berlin.informatik.dynamicFaultTree.Gate;
import de.hu_berlin.informatik.dynamicFaultTree.TopLevelEvent;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.GateImpl#getToplevelevent <em>Toplevelevent</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.GateImpl#getChildGate <em>Child Gate</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.GateImpl#getParentGate <em>Parent Gate</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.GateImpl#getChildEvent <em>Child Event</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GateImpl extends ElementImpl implements Gate {
	/**
	 * The cached value of the '{@link #getChildGate() <em>Child Gate</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildGate()
	 * @generated
	 * @ordered
	 */
	protected EList<Gate> childGate;

	/**
	 * The cached value of the '{@link #getChildEvent() <em>Child Event</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildEvent()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> childEvent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DynamicFaultTreePackage.Literals.GATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TopLevelEvent getToplevelevent() {
		if (eContainerFeatureID() != DynamicFaultTreePackage.GATE__TOPLEVELEVENT)
			return null;
		return (TopLevelEvent) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToplevelevent(TopLevelEvent newToplevelevent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newToplevelevent, DynamicFaultTreePackage.GATE__TOPLEVELEVENT,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setToplevelevent(TopLevelEvent newToplevelevent) {
		if (newToplevelevent != eInternalContainer()
				|| (eContainerFeatureID() != DynamicFaultTreePackage.GATE__TOPLEVELEVENT && newToplevelevent != null)) {
			if (EcoreUtil.isAncestor(this, newToplevelevent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newToplevelevent != null)
				msgs = ((InternalEObject) newToplevelevent).eInverseAdd(this,
						DynamicFaultTreePackage.TOP_LEVEL_EVENT__GATE, TopLevelEvent.class, msgs);
			msgs = basicSetToplevelevent(newToplevelevent, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DynamicFaultTreePackage.GATE__TOPLEVELEVENT,
					newToplevelevent, newToplevelevent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Gate> getChildGate() {
		if (childGate == null) {
			childGate = new EObjectContainmentWithInverseEList<Gate>(Gate.class, this,
					DynamicFaultTreePackage.GATE__CHILD_GATE, DynamicFaultTreePackage.GATE__PARENT_GATE);
		}
		return childGate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Gate getParentGate() {
		if (eContainerFeatureID() != DynamicFaultTreePackage.GATE__PARENT_GATE)
			return null;
		return (Gate) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentGate(Gate newParentGate, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentGate, DynamicFaultTreePackage.GATE__PARENT_GATE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentGate(Gate newParentGate) {
		if (newParentGate != eInternalContainer()
				|| (eContainerFeatureID() != DynamicFaultTreePackage.GATE__PARENT_GATE && newParentGate != null)) {
			if (EcoreUtil.isAncestor(this, newParentGate))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentGate != null)
				msgs = ((InternalEObject) newParentGate).eInverseAdd(this, DynamicFaultTreePackage.GATE__CHILD_GATE,
						Gate.class, msgs);
			msgs = basicSetParentGate(newParentGate, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DynamicFaultTreePackage.GATE__PARENT_GATE,
					newParentGate, newParentGate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Event> getChildEvent() {
		if (childEvent == null) {
			childEvent = new EObjectContainmentWithInverseEList<Event>(Event.class, this,
					DynamicFaultTreePackage.GATE__CHILD_EVENT, DynamicFaultTreePackage.EVENT__PARENT_GATE);
		}
		return childEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DynamicFaultTreePackage.GATE__TOPLEVELEVENT:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetToplevelevent((TopLevelEvent) otherEnd, msgs);
		case DynamicFaultTreePackage.GATE__CHILD_GATE:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildGate()).basicAdd(otherEnd, msgs);
		case DynamicFaultTreePackage.GATE__PARENT_GATE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentGate((Gate) otherEnd, msgs);
		case DynamicFaultTreePackage.GATE__CHILD_EVENT:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildEvent()).basicAdd(otherEnd, msgs);
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
		case DynamicFaultTreePackage.GATE__TOPLEVELEVENT:
			return basicSetToplevelevent(null, msgs);
		case DynamicFaultTreePackage.GATE__CHILD_GATE:
			return ((InternalEList<?>) getChildGate()).basicRemove(otherEnd, msgs);
		case DynamicFaultTreePackage.GATE__PARENT_GATE:
			return basicSetParentGate(null, msgs);
		case DynamicFaultTreePackage.GATE__CHILD_EVENT:
			return ((InternalEList<?>) getChildEvent()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case DynamicFaultTreePackage.GATE__TOPLEVELEVENT:
			return eInternalContainer().eInverseRemove(this, DynamicFaultTreePackage.TOP_LEVEL_EVENT__GATE,
					TopLevelEvent.class, msgs);
		case DynamicFaultTreePackage.GATE__PARENT_GATE:
			return eInternalContainer().eInverseRemove(this, DynamicFaultTreePackage.GATE__CHILD_GATE, Gate.class,
					msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DynamicFaultTreePackage.GATE__TOPLEVELEVENT:
			return getToplevelevent();
		case DynamicFaultTreePackage.GATE__CHILD_GATE:
			return getChildGate();
		case DynamicFaultTreePackage.GATE__PARENT_GATE:
			return getParentGate();
		case DynamicFaultTreePackage.GATE__CHILD_EVENT:
			return getChildEvent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case DynamicFaultTreePackage.GATE__TOPLEVELEVENT:
			setToplevelevent((TopLevelEvent) newValue);
			return;
		case DynamicFaultTreePackage.GATE__CHILD_GATE:
			getChildGate().clear();
			getChildGate().addAll((Collection<? extends Gate>) newValue);
			return;
		case DynamicFaultTreePackage.GATE__PARENT_GATE:
			setParentGate((Gate) newValue);
			return;
		case DynamicFaultTreePackage.GATE__CHILD_EVENT:
			getChildEvent().clear();
			getChildEvent().addAll((Collection<? extends Event>) newValue);
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
		case DynamicFaultTreePackage.GATE__TOPLEVELEVENT:
			setToplevelevent((TopLevelEvent) null);
			return;
		case DynamicFaultTreePackage.GATE__CHILD_GATE:
			getChildGate().clear();
			return;
		case DynamicFaultTreePackage.GATE__PARENT_GATE:
			setParentGate((Gate) null);
			return;
		case DynamicFaultTreePackage.GATE__CHILD_EVENT:
			getChildEvent().clear();
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
		case DynamicFaultTreePackage.GATE__TOPLEVELEVENT:
			return getToplevelevent() != null;
		case DynamicFaultTreePackage.GATE__CHILD_GATE:
			return childGate != null && !childGate.isEmpty();
		case DynamicFaultTreePackage.GATE__PARENT_GATE:
			return getParentGate() != null;
		case DynamicFaultTreePackage.GATE__CHILD_EVENT:
			return childEvent != null && !childEvent.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GateImpl
