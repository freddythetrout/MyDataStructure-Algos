package datastructure_interface;

public interface Stack<T> extends Dispenser {

	/**
	 * Add a element to the top of the stack
	 * @param item is the type of the element in the stack
	 */
	void push(T item);
	
	/**
	 * Returns the top element of the stack and removes it from the stack.
	 * @return the top value of the stack
	 * @throws IllegalArgumentException if the stack is emtpy
	 */
	T pop() throws IllegalArgumentException;
	
	/**
	 * Returns the top element of the stack and keep it in the stack.
	 * @return the top element of the stack
	 * @throws IllegalArgumentException if the stack is emtpy
	 */
	T top() throws IllegalArgumentException;
	
}
