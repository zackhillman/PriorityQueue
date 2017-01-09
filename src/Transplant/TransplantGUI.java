package Transplant;
import javax.swing.*;
import BreezySwing.*;

public class TransplantGUI extends GBFrame{

	private JLabel nameL; //Tells the user where to enter the patient's name
	private JLabel priorityL; //Tells the user where to enter the patient's priority
	
	private JButton addPatient; //Adds a patient to the queue
	private JButton getPatient; //Removes a patient from the queue
	
	private JTextField nameF; //Where the user enters the name of the patient
	private JComboBox<String> priorityF;
	
	
	private QueueADT<Patient> hQueue; //This is the queue which holds patients already asked
	private PriorityQueueADT<Patient> queue; //This queue holds the patient's currently in line
	
	/**
	 * This is the constructor method. The GUI objects are instantiated.
	 * hQueue is instantiated
	 * @param- the Priority Queue to use
	 */
	public TransplantGUI(PriorityQueueADT<Patient> q){
		nameL = addLabel("Name:",1,1,1,1);
		nameF = addTextField("",2,1,1,1);
		priorityL = addLabel("Priority:",1,2,1,1);
		priorityF = addComboBox(2,2,1,1);
		
		addPatient = addButton("Add Patient",3,1,1,1);
		getPatient = addButton("Get Patient",3,2,1,1);
		
		hQueue = new QueueLinkedList<Patient>();
		queue = q;		
		priorityF.addItem("1");
		priorityF.addItem("2");
		priorityF.addItem("3");
	}
	
	/**
	 * This method is called when a button is clicked
	 * @param- the button being clicked
	 */
	public void buttonClicked(JButton buttonObj) {
		try{
			
			if (buttonObj == addPatient) {
				Patient newPatient = new Patient(nameF.getText(),Integer.parseInt(priorityF.getSelectedItem().toString()));
				queue.add(newPatient);
				nameF.setText("");
			}else if(buttonObj == getPatient){
				remPatient();
				
				while(!hQueue.isEmpty()){
					queue.add(hQueue.dequeue());
				}
			}	
			System.out.println(queue.toString());
		}catch(Exception e){
			messageBox(e,400,200);
		}
	}
	
	/**
	 * This method gets called recursively to get the next patient
	 */
	private void remPatient(){
		acceptDialog aDialog = new acceptDialog(this,queue.peekMin().toString());
		aDialog.setVisible(true);
		boolean result = aDialog.getResult();
		Patient min = queue.peekMin();
		queue.removeMin();
		if(!result){
			if(queue.isEmpty()){
				messageBox("You must accept",300,200);
			}else{
				hQueue.enqueue(min);
				remPatient();
			}
		}
	}
}
