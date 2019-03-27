/**
 */
package de.hu_berlin.informatik.ctmc.model.ctmc.impl;

import de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage;
import de.hu_berlin.informatik.ctmc.model.ctmc.Label;
import de.hu_berlin.informatik.ctmc.model.ctmc.State;
import de.hu_berlin.informatik.ctmc.model.ctmc.Transition;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.StateImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.StateImpl#getExitRate <em>Exit Rate</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.StateImpl#getLabels <em>Labels</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.StateImpl#getOut <em>Out</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.StateImpl#getIn <em>In</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateImpl extends MinimalEObjectImpl.Container implements State {
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
	 * The default value of the '{@link #getExitRate() <em>Exit Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitRate()
	 * @generated
	 * @ordered
	 */
	protected static final float EXIT_RATE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getExitRate() <em>Exit Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitRate()
	 * @generated
	 * @ordered
	 */
	protected float exitRate = EXIT_RATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLabels() <em>Labels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabels()
	 * @generated
	 * @ordered
	 */
	protected EList<Label> labels;

	/**
	 * The cached value of the '{@link #getOut() <em>Out</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOut()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> out;

	/**
	 * The cached value of the '{@link #getIn() <em>In</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIn()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> in;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CtmcPackage.Literals.STATE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CtmcPackage.STATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getExitRate() {
		return exitRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExitRate(float newExitRate) {
		float oldExitRate = exitRate;
		exitRate = newExitRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CtmcPackage.STATE__EXIT_RATE, oldExitRate, exitRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Label> getLabels() {
		if (labels == null) {
			labels = new EObjectContainmentWithInverseEList<Label>(Label.class, this, CtmcPackage.STATE__LABELS,
					CtmcPackage.LABEL__STATE);
		}
		return labels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOut() {
		if (out == null) {
			out = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, CtmcPackage.STATE__OUT,
					CtmcPackage.TRANSITION__FROM);
		}
		return out;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getIn() {
		if (in == null) {
			in = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, CtmcPackage.STATE__IN,
					CtmcPackage.TRANSITION__TO);
		}
		return in;
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
		case CtmcPackage.STATE__LABELS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getLabels()).basicAdd(otherEnd, msgs);
		case CtmcPackage.STATE__OUT:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOut()).basicAdd(otherEnd, msgs);
		case CtmcPackage.STATE__IN:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getIn()).basicAdd(otherEnd, msgs);
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
		case CtmcPackage.STATE__LABELS:
			return ((InternalEList<?>) getLabels()).basicRemove(otherEnd, msgs);
		case CtmcPackage.STATE__OUT:
			return ((InternalEList<?>) getOut()).basicRemove(otherEnd, msgs);
		case CtmcPackage.STATE__IN:
			return ((InternalEList<?>) getIn()).basicRemove(otherEnd, msgs);
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
		case CtmcPackage.STATE__NAME:
			return getName();
		case CtmcPackage.STATE__EXIT_RATE:
			return getExitRate();
		case CtmcPackage.STATE__LABELS:
			return getLabels();
		case CtmcPackage.STATE__OUT:
			return getOut();
		case CtmcPackage.STATE__IN:
			return getIn();
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
		case CtmcPackage.STATE__NAME:
			setName((String) newValue);
			return;
		case CtmcPackage.STATE__EXIT_RATE:
			setExitRate((Float) newValue);
			return;
		case CtmcPackage.STATE__LABELS:
			getLabels().clear();
			getLabels().addAll((Collection<? extends Label>) newValue);
			return;
		case CtmcPackage.STATE__OUT:
			getOut().clear();
			getOut().addAll((Collection<? extends Transition>) newValue);
			return;
		case CtmcPackage.STATE__IN:
			getIn().clear();
			getIn().addAll((Collection<? extends Transition>) newValue);
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
		case CtmcPackage.STATE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case CtmcPackage.STATE__EXIT_RATE:
			setExitRate(EXIT_RATE_EDEFAULT);
			return;
		case CtmcPackage.STATE__LABELS:
			getLabels().clear();
			return;
		case CtmcPackage.STATE__OUT:
			getOut().clear();
			return;
		case CtmcPackage.STATE__IN:
			getIn().clear();
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
		case CtmcPackage.STATE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case CtmcPackage.STATE__EXIT_RATE:
			return exitRate != EXIT_RATE_EDEFAULT;
		case CtmcPackage.STATE__LABELS:
			return labels != null && !labels.isEmpty();
		case CtmcPackage.STATE__OUT:
			return out != null && !out.isEmpty();
		case CtmcPackage.STATE__IN:
			return in != null && !in.isEmpty();
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
		result.append(", exitRate: ");
		result.append(exitRate);
		result.append(')');
		return result.toString();
	}

} //StateImpl
