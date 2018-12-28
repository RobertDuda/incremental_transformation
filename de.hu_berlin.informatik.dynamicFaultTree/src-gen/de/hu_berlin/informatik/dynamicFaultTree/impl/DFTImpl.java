/**
 */
package de.hu_berlin.informatik.dynamicFaultTree.impl;

import de.hu_berlin.informatik.dynamicFaultTree.DFT;
import de.hu_berlin.informatik.dynamicFaultTree.Dependency;
import de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage;
import de.hu_berlin.informatik.dynamicFaultTree.TopLevelEvent;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DFT</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.DFTImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.DFTImpl#getTopLevelEvent <em>Top Level Event</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.dynamicFaultTree.impl.DFTImpl#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DFTImpl extends MinimalEObjectImpl.Container implements DFT {
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
	 * The cached value of the '{@link #getTopLevelEvent() <em>Top Level Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopLevelEvent()
	 * @generated
	 * @ordered
	 */
	protected TopLevelEvent topLevelEvent;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> dependencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DFTImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DynamicFaultTreePackage.Literals.DFT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DynamicFaultTreePackage.DFT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopLevelEvent getTopLevelEvent() {
		return topLevelEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTopLevelEvent(TopLevelEvent newTopLevelEvent, NotificationChain msgs) {
		TopLevelEvent oldTopLevelEvent = topLevelEvent;
		topLevelEvent = newTopLevelEvent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					DynamicFaultTreePackage.DFT__TOP_LEVEL_EVENT, oldTopLevelEvent, newTopLevelEvent);
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
	public void setTopLevelEvent(TopLevelEvent newTopLevelEvent) {
		if (newTopLevelEvent != topLevelEvent) {
			NotificationChain msgs = null;
			if (topLevelEvent != null)
				msgs = ((InternalEObject) topLevelEvent).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - DynamicFaultTreePackage.DFT__TOP_LEVEL_EVENT, null, msgs);
			if (newTopLevelEvent != null)
				msgs = ((InternalEObject) newTopLevelEvent).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - DynamicFaultTreePackage.DFT__TOP_LEVEL_EVENT, null, msgs);
			msgs = basicSetTopLevelEvent(newTopLevelEvent, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DynamicFaultTreePackage.DFT__TOP_LEVEL_EVENT,
					newTopLevelEvent, newTopLevelEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList<Dependency>(Dependency.class, this,
					DynamicFaultTreePackage.DFT__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DynamicFaultTreePackage.DFT__TOP_LEVEL_EVENT:
			return basicSetTopLevelEvent(null, msgs);
		case DynamicFaultTreePackage.DFT__DEPENDENCIES:
			return ((InternalEList<?>) getDependencies()).basicRemove(otherEnd, msgs);
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
		case DynamicFaultTreePackage.DFT__NAME:
			return getName();
		case DynamicFaultTreePackage.DFT__TOP_LEVEL_EVENT:
			return getTopLevelEvent();
		case DynamicFaultTreePackage.DFT__DEPENDENCIES:
			return getDependencies();
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
		case DynamicFaultTreePackage.DFT__NAME:
			setName((String) newValue);
			return;
		case DynamicFaultTreePackage.DFT__TOP_LEVEL_EVENT:
			setTopLevelEvent((TopLevelEvent) newValue);
			return;
		case DynamicFaultTreePackage.DFT__DEPENDENCIES:
			getDependencies().clear();
			getDependencies().addAll((Collection<? extends Dependency>) newValue);
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
		case DynamicFaultTreePackage.DFT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case DynamicFaultTreePackage.DFT__TOP_LEVEL_EVENT:
			setTopLevelEvent((TopLevelEvent) null);
			return;
		case DynamicFaultTreePackage.DFT__DEPENDENCIES:
			getDependencies().clear();
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
		case DynamicFaultTreePackage.DFT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case DynamicFaultTreePackage.DFT__TOP_LEVEL_EVENT:
			return topLevelEvent != null;
		case DynamicFaultTreePackage.DFT__DEPENDENCIES:
			return dependencies != null && !dependencies.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //DFTImpl
