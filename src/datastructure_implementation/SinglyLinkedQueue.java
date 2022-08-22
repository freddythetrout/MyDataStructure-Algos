package datastructure_implementation;

import datastructure_interface.Queue;

public class SinglyLinkedQueue<T> implements Queue<T> {

	private class Node{
		
		T item;
		Node next;
	
		Node(T item, Node next){
			this.item = item;
			this.next = next;
		}
	}
	
	
	private int count;
	private Node frontNode; 
	private Node rearNode; 
	
	public SinglyLinkedQueue() {
		count = 0;
	}
	
	@Override
	public Integer size() {return count;	}

	@Override
	public Boolean isEmpty() {return rearNode == null;	}

	@Override
	public void clear() {
		frontNode = null;
		rearNode = null;
		count = 0;
	}

	@Override
	public void enter(T item) {
		Node newNode = new Node(item,null);
		if (count ==0) {
			frontNode =newNode;
			rearNode =newNode;
			count++;
		}else if (count ==1){
			frontNode.next = newNode;
			rearNode = newNode;
			count++;
		} else {
			rearNode.next = newNode;
			rearNode = newNode;
			count++;
		}
	}

	@Override
	public T leave() throws IllegalArgumentException {
		if (this.frontNode ==null) throw new IllegalArgumentException("The queue is empty");
		return frontNode.item;
	}

	@Override
	public T front() throws IllegalArgumentException {
		if (this.frontNode ==null) throw new IllegalArgumentException("The queue is empty");
		Node returnNode = frontNode;
		frontNode = frontNode.next;
		count--;
		return returnNode.item;
	}
	
}
