package main.java.com;
import main.java.com.ImmutableQueue;
import java.util.LinkedList;
public class CheckImmutableQueue {

	public static void main(String[] args) {
		java.util.Queue<String> queue = new LinkedList<>();
		queue.add("Tokyo");
		queue.add("New Delhi");
		queue.add("London");
		queue.add("Paris");

		ImmutableQueue<String> immutableQueue = new ImmutableQueue<>(queue);
		// Can iterate over the queue
		System.out.println("Contents of original queue:");
		for (String str : immutableQueue) {
			System.out.println(str);
		}
		System.out.printf("Size of queue: %d\n", immutableQueue.size());

		// Check that enQueue works properly
		ImmutableQueue<String> enqueuedQueue = (ImmutableQueue<String>) immutableQueue.enQueue("Berlin");
		System.out.printf("After calling enQueue... Size of original queue: %d \t Size of enqueued queue: %d\n",
				immutableQueue.size(), enqueuedQueue.size());

		// Check that deQueue works properly
		ImmutableQueue<String> dequeuedQueue = (ImmutableQueue<String>) immutableQueue.deQueue();
		System.out.printf("After calling deQueue... Size of original queue: %d \t Size of dequeued queue: %d\n",
				immutableQueue.size(), dequeuedQueue.size());

	}
}
