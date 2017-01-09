package Transplant;

public class Patient implements Comparable<Patient>{

	private String name; //This holds the patient's name
	private int priority; //This holds the patient's priority ranking (1-3)
	
	/**
	 * This is the constructor method the name and priority are instantiated.
	 * @param n- the patient's name
	 * @param p the patient's priority
	 */
	public Patient(String n, int p){
		priority = p;
		name = n;
	}
	
	/**
	 * This method gets the patient's priority
	 * @return the integer value of the patient's priority
	 */
	public int getPriority(){
		return priority;
	}
	
	/**
	 * This method compares two patient's by priority
	 * @param- the patient to compare to
	 * @return- negative if it comes before
	 * 			0 if it is equal
	 * 			positive if it comes after
	 */
	public int compareTo(Patient o) {
		return priority-o.getPriority();
	}
	
	/**
	 * This method gets the string representation of the patient
	 * @return- the patient in string form
	 */
	public String toString(){
		return name+":"+priority;
	}
	
}
