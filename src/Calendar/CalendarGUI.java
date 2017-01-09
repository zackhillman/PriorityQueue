package Calendar;


import javax.swing.*;

import BreezySwing.*;

public class CalendarGUI extends GBFrame{

	private JLabel titleL; //Tells the user where to enter the event's title
	private JLabel dateL; //Tells the user where to enter the event's date
	
	private JButton addEvent; //Adds an event to the queue
	private JButton getEvent; //Removes an event from the queue
	
	private JTextField titleF; //Where the user enters the title of the event
	private JTextField dateF; //Where the user enters the date of the event
	
	private PriorityQueueADT<Event> queue; //Tracks all of the events

	
	/**
	 * This is the constructor method. The GUI objects are instantiated.
	 * @param- the passed in queue (created in typeDialog)
	 */
	public CalendarGUI(PriorityQueueADT<Event> q){
		titleL = addLabel("Title:",1,1,2,1);
		titleF = addTextField("",2,1,2,1);
		dateL = addLabel("Date:",3,1,2,1);
		dateF = addTextField("",4,1,2,1);
		
		addEvent = addButton("Add Event",5,1,1,1);
		getEvent = addButton("Get Event",5,2,1,1);
		
		queue = q;		
	}
	
	/**
	 * This method is called when a button is clicked
	 * @param- the button being clicked
	 */
	public void buttonClicked(JButton buttonObj) {

		try{
			if (buttonObj == addEvent) {
				Event newEvent = new Event(titleF.getText(),parseDate(dateF.getText()));
				queue.add(newEvent);
				titleF.setText("");
				dateF.setText("");
				
			}else if(buttonObj == getEvent){
				messageBox("Next event is: "+ queue.removeMin(),300,200);
				
			}	
			System.out.println(queue.toString());
		}catch(Exception e){
			messageBox(e,400,200);
		}
	}
	
	/**
	 * This method parses the inputed date.
	 * It separates the string by "/" and then 
	 * creates a date
	 * @param date- the String date passed in
	 * @return- the Object date being created
	 */
	private Date parseDate(String date){
		String[] data= date.split("/");
		return new Date(Integer.parseInt(data[0]),
						Integer.parseInt(data[1]),
						Integer.parseInt(data[2]));
	
	}
}
