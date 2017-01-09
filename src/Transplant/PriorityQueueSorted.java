package Transplant;
public class PriorityQueueSorted<T extends Comparable<T>> implements PriorityQueueADT<T>{

	private ListNode<T> head; //This is the reference to the head of the linked list
	
	/**
	 * This is the default constructor, it sets head to null
	 */
	public PriorityQueueSorted(){
		head = null;
	}

	/**
	 * This method adds an element to the queue. When adding the queue finds the correct
	 * spot for the element.
	 * @param- the element to add to the queue
	 */
	public void add(T element) {
		if(head == null || head.getValue().compareTo(element)>0){
			head = new ListNode<T>(element,head);
		}else{
			ListNode<T> node = head.getNext();
			ListNode<T> previous = head;
			while(node!=null && node.getValue().compareTo(element)<=0){
				previous = node;
				node = node.getNext();
			}
			previous.setNext(new ListNode<T>(element,node));
		}
	}
	
	/**
	 * This method removes the item next in line. In a sorted PQ the element will
	 * be at the front
	 * @return- the Element with the highest priority
	 */
	public T removeMin() {
		if(isEmpty())
			throw new IllegalArgumentException("Queue is Empty");
		T min = head.getValue();
		head = head.getNext();
		return min;
	}
	
	/**
	 * This methods gets the item next in line. In a sorted PQ the element will
	 * be at the front
	 * @return- the Element with the highest priority
	 */
	public T peekMin() {
		if(isEmpty())
			throw new IllegalArgumentException("Queue is Empty");
		return head.getValue();
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
