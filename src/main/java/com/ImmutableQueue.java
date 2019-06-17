package main.java.com;

import java.util.Iterator;

public class ImmutableQueue<T> implements Queue<T>, Iterable<T> {
	private java.util.Queue<T> queue;

	public ImmutableQueue(java.util.Queue<T> queue) {
		this.queue = new java.util.LinkedList<>(queue);
	}

	@Override
	public Queue<T> enQueue(T t) {
		java.util.Queue<T> newQueue = new java.util.LinkedList<>(this.queue);
		newQueue.add(t);
		return new ImmutableQueue<T>(newQueue);
	}

	@Override
	public Queue<T> deQueue() throws NullPointerException {
		java.util.Queue<T> newQueue = new java.util.LinkedList<>(this.queue);
		newQueue.remove();
		return new ImmutableQueue<T>(newQueue);
	}

	@Override
	public T head() {
		return this.queue.peek();
	}

	@Override
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

	/**
	 * Get a mutable queue with same values as this queue
	 * 
	 * @return A java queue with copied contents of this queue
	 */
	public java.util.Queue<T> getMutableQueue() {
		return new java.util.LinkedList<>(this.queue);
	}

	/**
	 * Get an iterator to iterate the queue. Any changes to the iterator won't
	 * affect this queue.
	 * 
	 * @return An iterator for a copy of this queue
	 */
	@Override
	public Iterator<T> iterator() {
		return new java.util.LinkedList<>(queue).iterator();
	}

	/**
	 * Check if object is present in the queue
	 * 
	 * @param o Object to find in the queue
	 * @return True if object is present in queue, else False
	 */
	public boolean contains(T o) {
		return queue.contains(o);
	}

	/**
	 * Check the size of the queue
	 * 
	 * @return Number of objects in queue
	 */
	public int size() {
		return queue.size();
	}
}
