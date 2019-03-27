/**
 */
package de.hu_berlin.informatik.ctmc.model.ctmc.impl;

import de.hu_berlin.informatik.ctmc.model.ctmc.CtmcPackage;
import de.hu_berlin.informatik.ctmc.model.ctmc.State;
import de.hu_berlin.informatik.ctmc.model.ctmc.Transition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.TransitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.TransitionImpl#getProbability <em>Probability</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.TransitionImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.TransitionImpl#getFrom <em>From</em>}</li>
 *   <li>{@link de.hu_berlin.informatik.ctmc.model.ctmc.impl.TransitionImpl#getTo <em>To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends MinimalEObjectImpl.Container implements Transition {
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
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final float DURATION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected float duration = DURATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected State to;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CtmcPackage.Literals.TRANSITION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CtmcPackage.TRANSITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getProbability() {
		return probability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbability(float newProbability) {
		float oldProbability = probability;
		probability = newProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CtmcPackage.TRANSITION__PROBABILITY, oldProbability,
					probability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(float newDuration) {
		float oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CtmcPackage.TRANSITION__DURATION, oldDuration,
					duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getFrom() {
		if (eContainerFeatureID() != CtmcPackage.TRANSITION__FROM)
			return null;
		return (State) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFrom(State newFrom, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newFrom, CtmcPackage.TRANSITION__FROM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(State newFrom) {
		if (newFrom != eInternalContainer()
				|| (eContainerFeatureID() != CtmcPackage.TRANSITION__FROM && newFrom != null)) {
			if (EcoreUtil.isAncestor(this, newFrom))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFrom != null)
				msgs = ((InternalEObject) newFrom).eInverseAdd(this, CtmcPackage.STATE__OUT, State.class, msgs);
			msgs = basicSetFrom(newFrom, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CtmcPackage.TRANSITION__FROM, newFrom, newFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getTo() {
		if (to != null && to.eIsProxy()) {
			InternalEObject oldTo = (InternalEObject) to;
			to = (State) eResolveProxy(oldTo);
			if (to != oldTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CtmcPackage.TRANSITION__TO, oldTo, to));
			}
		}
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTo(State newTo, NotificationChain msgs) {
		State oldTo = to;
		to = newTo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CtmcPackage.TRANSITION__TO,
					oldTo, newTo);
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
	public void setTo(State newTo) {
		if (newTo != to) {
			NotificationChain msgs = null;
			if (to != null)
				msgs = ((InternalEObject) to).eInverseRemove(this, CtmcPackage.STATE__IN, State.class, msgs);
			if (newTo != null)
				msgs = ((InternalEObject) newTo).eInverseAdd(this, CtmcPackage.STATE__IN, State.class, msgs);
			msgs = basicSetTo(newTo, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CtmcPackage.TRANSITION__TO, newTo, newTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CtmcPackage.TRANSITION__FROM:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetFrom((State) otherEnd, msgs);
		case CtmcPackage.TRANSITION__TO:
			if (to != null)
				msgs = ((InternalEObject) to).eInverseRemove(this, CtmcPackage.STATE__IN, State.class, msgs);
			return basicSetTo((State) otherEnd, msgs);
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
		case CtmcPackage.TRANSITION__FROM:
			return basicSetFrom(null, msgs);
		case CtmcPackage.TRANSITION__TO:
			return basicSetTo(null, msgs);
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
		case CtmcPackage.TRANSITION__FROM:
			return eInternalContainer().eInverseRemove(this, CtmcPackage.STATE__OUT, State.class, msgs);
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
		case CtmcPackage.TRANSITION__NAME:
			return getName();
		case CtmcPackage.TRANSITION__PROBABILITY:
			return getProbability();
		case CtmcPackage.TRANSITION__DURATION:
			return getDuration();
		case CtmcPackage.TRANSITION__FROM:
			return getFrom();
		case CtmcPackage.TRANSITION__TO:
			if (resolve)
				return getTo();
			return basicGetTo();
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
		case CtmcPackage.TRANSITION__NAME:
			setName((String) newValue);
			return;
		case CtmcPackage.TRANSITION__PROBABILITY:
			setProbability((Float) newValue);
			return;
		case CtmcPackage.TRANSITION__DURATION:
			setDuration((Float) newValue);
			return;
		case CtmcPackage.TRANSITION__FROM:
			setFrom((State) newValue);
			return;
		case CtmcPackage.TRANSITION__TO:
			setTo((State) newValue);
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
		case CtmcPackage.TRANSITION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case CtmcPackage.TRANSITION__PROBABILITY:
			setProbability(PROBABILITY_EDEFAULT);
			return;
		case CtmcPackage.TRANSITION__DURATION:
			setDuration(DURATION_EDEFAULT);
			return;
		case CtmcPackage.TRANSITION__FROM:
			setFrom((State) null);
			return;
		case CtmcPackage.TRANSITION__TO:
			setTo((State) null);
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
		case CtmcPackage.TRANSITION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case CtmcPackage.TRANSITION__PROBABILITY:
			return probability != PROBABILITY_EDEFAULT;
		case CtmcPackage.TRANSITION__DURATION:
			return duration != DURATION_EDEFAULT;
		case CtmcPackage.TRANSITION__FROM:
			return getFrom() != null;
		case CtmcPackage.TRANSITION__TO:
			return to != null;
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
		result.append(", duration: ");
		result.append(duration);
		result.append(')');
		return result.toString();
	}

} //TransitionImpl
