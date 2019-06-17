package test.java.com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import main.java.com.ImmutableQueue;

import org.junit.Test;

public class ImmutableQueueTest {
	
	private static java.util.Queue<String> getBasicQueue() {
		java.util.Queue<String> q = new java.util.LinkedList<>();
		q.add("London");
		q.add("Paris");
		return q;
	}

	@Test
	public void testQueueConstructor() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		assertFalse(immutableQueue.isEmpty(), "Queue not created properly!");
		assertEquals(q.size(), immutableQueue.size(), "All the elements are not pressent in immutable queue!");
	}

	@Test
	public void testQueueEnQueue() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		ImmutableQueue<String> immutableQueueEnQueued = (ImmutableQueue<String>) immutableQueue.enQueue("New York");
		assertEquals(q.size(), immutableQueue.size(), "Enqueue changed queue size!");
		assertEquals(q.size() + 1, immutableQueueEnQueued.size(), "Enqueued queue does not have all the elements!");
	}

	@Test
	public void testQueueDeQueue() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		ImmutableQueue<String> immutableQueueDeQueued = (ImmutableQueue<String>) immutableQueue.deQueue();
		assertEquals(q.size(), immutableQueue.size(), "Dequeue changed queue size!");
		assertEquals(q.size() - 1, immutableQueueDeQueued.size(), "Dequeued queue does not have proper elements!");
	}

	@Test
	public void testQueueHead() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		assertEquals(q.peek(), immutableQueue.head(), "Value at head is wrong!");
	}

	@Test
	public void testQueueContains() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		assertEquals(q.contains("London"), immutableQueue.contains("London"), "Contains gives wrong result!");
		assertEquals(q.contains("Berlin"), immutableQueue.contains("Berlin"), "Contains gives wrong result!");
	}

	@Test
	public void testQueueGetMutableQueue() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		java.util.Queue<String> mutableQueue = immutableQueue.getMutableQueue();
		// Changes in mutable queue should not affect immutable queue
		mutableQueue.poll();
		assertEquals(q.size(), immutableQueue.size(), "Changes in mutable queue changed immutable queue size!");
		mutableQueue.add("New York");
		mutableQueue.add("Berlin");
		assertEquals(q.size(), immutableQueue.size(), "Changes in mutable queue changed immutable queue size!");
	}

	@Test
	public void testQueueIterator() {
		java.util.Queue<String> q = getBasicQueue();
		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(q);
		Iterator<String> iter = immutableQueue.iterator();
		iter.next();
		iter.remove();
		assertEquals(q.size(), immutableQueue.size(), "Changes in iterator changed immutable queue size!");
	}

}
