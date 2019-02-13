/**
 */
package de.hu_berlin.informatik.dynamicFaultTree.impl;

import de.hu_berlin.informatik.dynamicFaultTree.Dependency;
import de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage;
import de.hu_berlin.informatik.dynamicFaultTree.Event;
import de.hu_berlin.informatik.dynamicFaultTree.Gate;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.EventImpl#getParentGate <em>Parent Gate</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.EventImpl#getDependency <em>Dependency</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventImpl extends ElementImpl implements Event {
	/**
	 * The cached value of the '{@link #getDependency() <em>Dependency</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependency()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> dependency;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DynamicFaultTreePackage.Literals.EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Gate getParentGate() {
		if (eContainerFeatureID() != DynamicFaultTreePackage.EVENT__PARENT_GATE)
			return null;
		return (Gate) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentGate(Gate newParentGate, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newParentGate, DynamicFaultTreePackage.EVENT__PARENT_GATE, msgs);
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
				|| (eContainerFeatureID() != DynamicFaultTreePackage.EVENT__PARENT_GATE && newParentGate != null)) {
			if (EcoreUtil.isAncestor(this, newParentGate))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentGate != null)
				msgs = ((InternalEObject) newParentGate).eInverseAdd(this, DynamicFaultTreePackage.GATE__CHILD_EVENT,
						Gate.class, msgs);
			msgs = basicSetParentGate(newParentGate, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DynamicFaultTreePackage.EVENT__PARENT_GATE,
					newParentGate, newParentGate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Dependency> getDependency() {
		if (dependency == null) {
			dependency = new EObjectWithInverseResolvingEList.ManyInverse<Dependency>(Dependency.class, this,
					DynamicFaultTreePackage.EVENT__DEPENDENCY, DynamicFaultTreePackage.DEPENDENCY__EVENTS);
		}
		return dependency;
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
		case DynamicFaultTreePackage.EVENT__PARENT_GATE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetParentGate((Gate) otherEnd, msgs);
		case DynamicFaultTreePackage.EVENT__DEPENDENCY:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDependency()).basicAdd(otherEnd, msgs);
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
		case DynamicFaultTreePackage.EVENT__PARENT_GATE:
			return basicSetParentGate(null, msgs);
		case DynamicFaultTreePackage.EVENT__DEPENDENCY:
			return ((InternalEList<?>) getDependency()).basicRemove(otherEnd, msgs);
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
		case DynamicFaultTreePackage.EVENT__PARENT_GATE:
			return eInternalContainer().eInverseRemove(this, DynamicFaultTreePackage.GATE__CHILD_EVENT, Gate.class,
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
		case DynamicFaultTreePackage.EVENT__PARENT_GATE:
			return getParentGate();
		case DynamicFaultTreePackage.EVENT__DEPENDENCY:
			return getDependency();
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
		case DynamicFaultTreePackage.EVENT__PARENT_GATE:
			setParentGate((Gate) newValue);
			return;
		case DynamicFaultTreePackage.EVENT__DEPENDENCY:
			getDependency().clear();
			getDependency().addAll((Collection<? extends Dependency>) newValue);
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
		case DynamicFaultTreePackage.EVENT__PARENT_GATE:
			setParentGate((Gate) null);
			return;
		case DynamicFaultTreePackage.EVENT__DEPENDENCY:
			getDependency().clear();
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
		case DynamicFaultTreePackage.EVENT__PARENT_GATE:
			return getParentGate() != null;
		case DynamicFaultTreePackage.EVENT__DEPENDENCY:
			return dependency != null && !dependency.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EventImpl
