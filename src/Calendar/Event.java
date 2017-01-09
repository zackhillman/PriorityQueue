package Calendar;

public class Event implements Comparable<Event>{

	private String title; //Holds the event's title
	private Date date; //Holds the event's date
	
	/**
	 * This is the constructor method. Title and date are set 
	 * based on what is passed in.
	 * @param t- the event's title
	 * @param d- the event's date
	 */
	public Event(String t, Date d) {
		title = t;
		date = d;
	}

	/**
	 * This method compares two different events
	 * It uses the events' dates to compare them
	 * @param- the other event
	 * @return- returns negative if this event comes before the passed in one
	 * 					positive if this event comes after
	 * 					0 if the events are equivalent
	 */
	public int compareTo(Event o) {
		
		return date.compareTo(o.getDate());
	}
	/**
	 * This method gets the event's date
	 * @return- the date object
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * This method gets the String representation of the event
	 * @return- the event in string form
	 */
	public String toString(){
		return title +":"+ date;
	}

	
	
}
