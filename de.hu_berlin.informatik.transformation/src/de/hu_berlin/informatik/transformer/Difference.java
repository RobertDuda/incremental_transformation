package de.hu_berlin.informatik.transformer;

import de.hu_berlin.informatik.dynamicFaultTree.Element;

//TODO work in progress
public class Difference {
	
	private int priority; //what to apply first
	private String type; //update, new, removed, is this even relevant
	private Element refOld;
	private Element refNew;
	private int difference; //ref what exactly changed
	

	public Difference() {
		
	}


	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}


	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the refOld
	 */
	public Element getRefOld() {
		return refOld;
	}


	/**
	 * @param refOld the refOld to set
	 */
	public void setRefOld(Element refOld) {
		this.refOld = refOld;
	}


	/**
	 * @return the refNew
	 */
	public Element getRefNew() {
		return refNew;
	}


	/**
	 * @param refNew the refNew to set
	 */
	public void setRefNew(Element refNew) {
		this.refNew = refNew;
	}


	/**
	 * @return the difference
	 */
	public int getDifference() {
		return difference;
	}


	/**
	 * @param difference the difference to set
	 */
	public void setDifference(int difference) {
		this.difference = difference;
	}
	
}
