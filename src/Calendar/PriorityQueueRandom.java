package Calendar;


public class PriorityQueueRandom<T extends Comparable<T>> implements PriorityQueueADT<T>{

	private ListNode<T> head; //This is the reference to the head of the linked list
	
	/**
	 * This is the default constructor, it sets head to null
	 */
	public PriorityQueueRandom(){
		head = null;
	}
	/**
	 * This method adds an element to the queue in random order.
	 * @param- the element to be added
	 */
	public void add(T element) {
		if(head != null){
			ListNode<T> node = head;
			while(node.getNext()!=null)
				node = node.getNext();
			
			node.setNext(new ListNode<T>(element,null));
		}else{
			head = new ListNode<T>(element,head);
		}
		
	}
	/**
	 * This method removes the next element in line. It has to search
	 * for the element with the highest priority.
	 * @return- the element next in line
	 */
	public T removeMin() {
		if(head == null)
			throw new IllegalArgumentException("Queue is empty");
		else if(head.getNext()==null){
			T element = head.getValue();
			head=head.getNext();
			return element;
		}
		ListNode<T> node = head.getNext();
		ListNode<T> previous = head;
		ListNode<T> min = head;
		ListNode<T> previousMin = null;
		while(node!=null){
			if(min.getValue().compareTo(node.getValue())>0){
				min = node;
				previousMin = previous;
			} 
			previous = node;
			node = node.getNext();
			
		}
		if(previousMin == null)
			head=head.getNext();
		else
			previousMin.setNext(min.getNext());
		return min.getValue();
	}
	/**
	 * This method gets the next element in line. It has to search
	 * for the element with the highest priority.
	 * @return- the element next in line
	 */
	public T peekMin() {
		if(head == null)
			throw new IllegalArgumentException("Queue is empty");
		else if(head.getNext()==null)
			return head.getValue();
		ListNode<T> node = head.getNext();
		ListNode<T> min = head;
		while(node!=null){
			if(min.getValue().compareTo(node.getValue())>0){
				min = node;
			} 
			node = node.getNext();
			
		}
		return min.getValue();
	}
	/**
	 * This method checks if the queue is empty
	 * @return	true- if the queue is empty
	 * 			false- if the queue is non empty 
	 */
	public boolean isEmpty() {
		return head==null;
	}
	/**
	 * This method gets the string representation of the queue
	 * @return- Each of the elements on the queue
	 */
	public String toString(){
		if(head == null)
			return "Empty Queue";
		ListNode<T> currentNode = head;
		String output = "[ ";
		while(currentNode!=null){
			output += currentNode.getValue().toString()+", ";
			currentNode = currentNode.getNext();
		}
		return output+"]";
	}
	

}
