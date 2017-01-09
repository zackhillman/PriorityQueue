package Calendar;

public interface PriorityQueueADT <T>{

	public boolean isEmpty(); //Checks if the queue is empty
	public void add(T element); //Adds an element to the queue
	public T removeMin(); //returns & removes the next element in line
	public T peekMin(); //returns the next element in line
	
}
