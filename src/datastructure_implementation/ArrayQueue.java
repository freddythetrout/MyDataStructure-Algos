package datastructure_implementation;

import datastructure_interface.Queue;



public class ArrayQueue<T> implements Queue<T> {

	private static final int INITIAL_SIZE  =4;
	private T[] store;
	
	//TODO management the frontIndex and count is is faulty
	private int count;
	private int frontIndex;
	
	public ArrayQueue(int size) {
		if (size < 1) size = INITIAL_SIZE;
		store = (T[]) new Object[size];
		count = 0;
		frontIndex = 0;
	}
	
	@Override
	public Integer size() {return count;}

	@Override
	public Boolean isEmpty() {return count == 0;}

	@Override
	public void clear() {
		count =0;
		frontIndex=0;
		store = (T[]) new Object[store.length];	
	}

	@Override
	public void enter(T item) {
		if (count == store.length) {
			T[] newStore = (T[]) new Object[store.length*2];
			for (int i = 0; i < store.length;i++) {
				newStore[i] = store[i];
			}
		}
		store[count+frontIndex]= item;
		count++;
	}

	@Override
	public T leave() throws IllegalArgumentException {
		if (count ==0) throw new IllegalArgumentException("Queue is empty");
		return store[frontIndex];
	}

	@Override
	public T front() throws IllegalArgumentException {
		if (count ==0) throw new IllegalArgumentException("Queue is empty");
		
		int returnInteger = (frontIndex + count) % store.length;
		count--;
		frontIndex++;
		return store[returnInteger];
	}
	

}
