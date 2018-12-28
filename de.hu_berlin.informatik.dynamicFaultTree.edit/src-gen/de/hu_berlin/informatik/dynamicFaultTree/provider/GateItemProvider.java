/**
 */
package de.hu_berlin.informatik.dynamicFaultTree.provider;

import de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreeFactory;
import de.hu_berlin.informatik.dynamicFaultTree.DynamicFaultTreePackage;
import de.hu_berlin.informatik.dynamicFaultTree.Gate;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link de.hu_berlin.informatik.dynamicFaultTree.Gate} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GateItemProvider extends ElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GateItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addTopleveleventPropertyDescriptor(object);
			addChildGatePropertyDescriptor(object);
			addParentGatePropertyDescriptor(object);
			addChildEventPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Toplevelevent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTopleveleventPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Gate_toplevelevent_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Gate_toplevelevent_feature",
								"_UI_Gate_type"),
						DynamicFaultTreePackage.Literals.GATE__TOPLEVELEVENT, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Child Gate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addChildGatePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Gate_childGate_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Gate_childGate_feature", "_UI_Gate_type"),
						DynamicFaultTreePackage.Literals.GATE__CHILD_GATE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Parent Gate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentGatePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Gate_parentGate_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Gate_parentGate_feature", "_UI_Gate_type"),
						DynamicFaultTreePackage.Literals.GATE__PARENT_GATE, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Child Event feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addChildEventPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Gate_childEvent_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Gate_childEvent_feature", "_UI_Gate_type"),
						DynamicFaultTreePackage.Literals.GATE__CHILD_EVENT, true, false, true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DynamicFaultTreePackage.Literals.GATE__CHILD_GATE);
			childrenFeatures.add(DynamicFaultTreePackage.Literals.GATE__CHILD_EVENT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Gate.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Gate"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Gate) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_Gate_type")
				: getString("_UI_Gate_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Gate.class)) {
		case DynamicFaultTreePackage.GATE__CHILD_GATE:
		case DynamicFaultTreePackage.GATE__CHILD_EVENT:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(DynamicFaultTreePackage.Literals.GATE__CHILD_GATE,
				DynamicFaultTreeFactory.eINSTANCE.createAND()));

		newChildDescriptors.add(createChildParameter(DynamicFaultTreePackage.Literals.GATE__CHILD_GATE,
				DynamicFaultTreeFactory.eINSTANCE.createPAND()));

		newChildDescriptors.add(createChildParameter(DynamicFaultTreePackage.Literals.GATE__CHILD_GATE,
				DynamicFaultTreeFactory.eINSTANCE.createOR()));

		newChildDescriptors.add(createChildParameter(DynamicFaultTreePackage.Literals.GATE__CHILD_GATE,
				DynamicFaultTreeFactory.eINSTANCE.createPOR()));

		newChildDescriptors.add(createChildParameter(DynamicFaultTreePackage.Literals.GATE__CHILD_GATE,
				DynamicFaultTreeFactory.eINSTANCE.createXOR()));

		newChildDescriptors.add(createChildParameter(DynamicFaultTreePackage.Literals.GATE__CHILD_GATE,
				DynamicFaultTreeFactory.eINSTANCE.createSpare()));

		newChildDescriptors.add(createChildParameter(DynamicFaultTreePackage.Literals.GATE__CHILD_EVENT,
				DynamicFaultTreeFactory.eINSTANCE.createEvent()));
	}

}
