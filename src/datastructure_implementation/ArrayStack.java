package datastructure_implementation;

import datastructure_interface.Stack;



public class ArrayStack<T> implements Stack<T> {

	public static final int INITIAL_SIZE = 8;
	private T[] store; 
	private int count;
	
	public ArrayStack(int initialSize) {
		if (initialSize <1) initialSize = INITIAL_SIZE;
		store = (T[]) new Object[initialSize];
		count = 0;
	}
	
	@Override
	public Integer size() {return count;}

	@Override
	public Boolean isEmpty() {return count==0;}

	@Override
	public void clear() {store = (T[]) new Object[INITIAL_SIZE];}

	@Override
	public void push(T item) {
		if (count == store.length) {
			T[] newStore = (T[]) new Object[store.length * 2];
			for (int i=0; i < store.length; i++) {
				newStore[i] = store[i];
			}
			store = newStore;
		}
		store[count++] = item;
	}

	@Override
	public T top() throws IllegalArgumentException {
		if (isEmpty()) throw new IllegalArgumentException("Stack is emtpy");
		return store[count-1];
	}
	
	@Override
	public T pop() throws IllegalArgumentException {
		if (isEmpty()) throw new IllegalArgumentException("Stack is emtpy");
		return store[--count];
	}

}

