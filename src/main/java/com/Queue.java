package main.java.com;

public interface Queue<T> {

	/**
	 * Adds an element at the end of the immutable queue
	 * 
	 * @param  t  the element to add 
	 * @return    A new immutable queue after adding element to the queue
	 */
	public Queue<T> enQueue(T t);

	/**
	 * Removes the element at the beginning of the immutable queue
	 * 
	 * @return A new immutable queue after removing element from the queue
	 */
	public Queue<T> deQueue();

	/**
	 * Peek the object at the head of the queue without removing it
	 * 
	 * @return A copy of the object at the beginning of the queue
	 */
	public T head();

	/**
	 * Check if the queue is empty
	 * 
	 * @return True if queue is empty, else False
	 */
	public boolean isEmpty();
}
