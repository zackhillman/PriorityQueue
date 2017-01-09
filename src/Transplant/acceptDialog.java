package Transplant;
import javax.swing.*;

import BreezySwing.*;

public class acceptDialog<Job> extends GBDialog{

	private JLabel textL; //Tells the user what to do
	private JButton yes; //Accept's the heart
	private JButton no; //Decline's the heart
	
	private boolean result; //Tracks what the user selects
	
	/**
	 * This is the constructor for the accepteDialog box
	 * @param frame- the super class
	 */
	public acceptDialog(JFrame frame,String p) {
		super(frame);
		
		setSize(250,150);
		setTitle("Accept/Deny");
		
		setDlgCloseIndicator("Cancel");
		
		textL = addLabel( p+" is next in line",1,1,2,1);
		yes = addButton("Acccept",2,1,1,1);
		no = addButton("Decline",2,2,1,1);
		
	}

	/**
	 * This method is called when a but1ton is clicked
	 * @param- the button being clicked
	 */
	public void buttonClicked(JButton buttonObj) {
		
		if (buttonObj == yes){
			result = true;
		}else{
			result = false;
		}
		dispose();
	}
	
	/**
	 * This method gets the result
	 * @return- the result
	 * 			true: accept
	 * 			false: decline
	 */
	public boolean getResult(){
		return result;
	}
	
}
