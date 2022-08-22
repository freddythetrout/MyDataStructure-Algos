package datastructure_implementation;

import datastructure_interface.Stack;

public class SinglyLinkedStack<T> implements Stack<T> {

	
	private class Node {
		
		public T item;
		public Node next;
		
		Node(T item, Node next){
			this.item = item;
			this.next = next;
		}		
	}
	
	private int count;
	private Node store;
	
	@Override
	public Integer size() {return count;}

	@Override
	public Boolean isEmpty() {
		return store == null;
	}

	@Override
	public void clear() {
		store = null;
		count = 0;
	}

	@Override
	public void push(T item) {
		Node nodee = new Node(item, this.store);
		store = nodee;
		count++;
	}

	@Override
	public T pop() throws IllegalArgumentException {
		if (this.store == null) throw new IllegalArgumentException("Stack is empty");
		T tempItem = store.item;
		store = store.next;
		return tempItem;
	}

	@Override
	public T top() throws IllegalArgumentException {
		if (this.store == null) throw new IllegalArgumentException("Stack is empty");
		return store.item;
	}



}
