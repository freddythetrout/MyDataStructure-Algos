package datastructure_interface;

public interface Queue<T> extends Dispenser {
	/**
	 * Adds an element in the last position of the queue
	 * @param e element to enter the queue
	 */
	void enter(T item);	
	
	/**
	 * Returns the front element of the queue without removing it from the queue
	 * @return
	 * @throws IllegalArgumentException if queue is empty
	 */
	T leave() throws IllegalArgumentException;
	
	/**
	 * Returns the front element and removing it from the queue
	 * @return
	 * @throws IllegalArgumentException if queue is empty
	 */
	T front() throws IllegalArgumentException;
	
}
