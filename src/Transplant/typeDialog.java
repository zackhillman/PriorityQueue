package Transplant;
import javax.swing.*;

import BreezySwing.*;

public class typeDialog extends GBFrame{

	private JButton sorted; //Creates a queue which sorts the elements when added
	private JButton random; //Creates a queue which searches for elements when removed
		
	/**
	 * This is the constructor for the typeDialog box
	 *
	 */
	public typeDialog() {
		
		sorted = addButton("Sorted",1,1,1,1);
		random = addButton("Random",1,2,1,1);
		
	}

	/**
	 * This method is called when a but1ton is clicked
	 * @param- the button being clicked
	 */
	public void buttonClicked(JButton buttonObj) {
		TransplantGUI theGUI;
		if (buttonObj == sorted){
			 theGUI = new TransplantGUI(new PriorityQueueRandom<Patient>());
		}else{
			 theGUI = new TransplantGUI(new PriorityQueueRandom<Patient>());
		}
	
		theGUI.setSize(400, 250);
		theGUI.setVisible(true);
		theGUI.setTitle("Scheduler Program");
		
		dispose();
	}
	
	/**
	 * This is the main method it creates the actual GUI
	 * @param args
	 */
	public static void main(String[] args) {
		typeDialog theGUI = new typeDialog();
		theGUI.setSize(250, 100);
		theGUI.setLocationRelativeTo(null);
		theGUI.setVisible(true);
		theGUI.setTitle("Choose Type");
		
	}

	
}
