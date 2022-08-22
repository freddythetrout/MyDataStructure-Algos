package datastructure_implementation;

import java.util.Iterator;

import algorithm_interface.SortAlgorithm;
import datastructure_interface.List;

public class DoublyLinkedList<T extends Comparable<T>> implements List<T> {

	private Node head;
	private Node tail;
	private int count;

	public DoublyLinkedList() {
		head = new Node(null, null, new Node(head, null, null));
		tail = head.succ;
		count = 0;
	}

	@Override
	public Integer size() {
		return count;
	}

	@Override
	public Boolean isEmpty() {
		return head.succ.item == null;
	}

	@Override
	public void clear() {
		head.succ = tail;
		tail.pred = head;
		count = 0;
	}

	@Override
	public void insert(T item) {
		Node newNode = new Node(null, item, null);
		if (this.isEmpty()) {
			insertInEmptyList(newNode);
		} else {
			insertBeforeTail(newNode);
		}
		count++;
	}

	@Override
	public void insert(T item, Integer index) throws IllegalArgumentException {
		if (index > this.size())
			throw new IllegalArgumentException(
					String.format("i must not be > size of the list. Current size is %s", this.size()));

		Node newNode = new Node(null, item, null);
		if (this.isEmpty()) {
			insertInEmptyList(newNode);
		} else if (index == 0) {
			insertAtFirstPosition(newNode);
		} else if (index == count) {
			insertBeforeTail(newNode);
		} else {
			insertInBetween(newNode, index);
		}
		count++;
	}

	private void insertInEmptyList(Node newNode) {
		assert isEmpty();
		newNode.pred = head;
		newNode.succ = tail;
		head.succ = newNode;
		tail.pred = newNode;
	}

	private void insertAtFirstPosition(Node newNode) {
		assert !isEmpty();
		newNode.pred = head;
		newNode.succ = head.succ;
		head.succ.pred = newNode;
		head.succ = newNode;
	}

	private void insertInBetween(Node newNode, Integer i) {
		Node cursor = moveToIndex(i);
		newNode.succ = cursor;
		newNode.pred = cursor.pred;
		cursor.pred.succ = newNode;
		cursor.pred = newNode;
	}

	private Node moveToIndex(Integer i) {
		Node cursor = head.succ;
		for (int j = 0; j < i; j++) {
			cursor = cursor.succ;
		}
		return cursor;
	}

	private void insertBeforeTail(Node newNode) {
		newNode.pred = tail.pred;
		newNode.succ = tail;
		tail.pred.succ = newNode;
		tail.pred = newNode;
	}

	@Override
	public void delete(Integer index) throws IllegalArgumentException {
		Node cursor = moveToIndex(index);
		cursor.pred.succ = cursor.succ;
		cursor.succ.pred = cursor.pred;
		count--;
	}

	@Override
	public T get(Integer index) throws IllegalArgumentException {
		if (index > this.size()) {
			throw new IllegalArgumentException("must not index>count");
		}
		
		return (T) moveToIndex(index).item;
	}

	@Override
	public List<T> slice(Integer i, Integer j) {
		Node cursorI = moveToIndex(i);
		Node cursorJ = moveToIndex(j);
		List<T> returnList = new DoublyLinkedList<T>();

		while (cursorI != cursorJ) {
			returnList.insert(cursorI.item);
			cursorI = cursorI.succ;
		}
		return returnList;
	}

	@Override
	public Boolean contains(T item) {
		Node cursor = moveToIndex(0);
		while (cursor != tail) {
			if (cursor.item == item)
				return true;
			cursor = cursor.succ;
		}
		return false;
	}

	private class Node {

		Node pred;
		T item;
		Node succ;

		Node(Node pred, T item, Node succ) {
			this.pred = pred;
			this.item = item;
			this.succ = succ;
		}

	}

	private class ListIterator implements Iterator<T> {

		private Node next = head.succ;

		@Override
		public boolean hasNext() {
			return next.succ != null;
		}

		@Override
		public T next() {
			Node returnNode = next;
			next = next.succ;
			return returnNode.item;
		}

	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	@Override
	public void put(T item, Integer index) {
		if (this.size() < index) {
			throw new IllegalArgumentException("Index must not be smaller than size() of this list");
		}
		moveToIndex(index).item = item;
	}

	public void sort(SortAlgorithm<T> sortAlgo) {
		if (this.size() == 0) {
			throw new IllegalArgumentException("List must not be emtpy");
		}
		sortAlgo.sortThisList(this);
	}



}
