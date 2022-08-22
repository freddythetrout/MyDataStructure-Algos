package datastructure_implementation;

import java.util.Iterator;

import algorithm_interface.SortAlgorithm;
import datastructure_interface.List;

public class ArrayList<T extends Comparable<T>> implements List<T>, Iterable<T> {

	private static final Integer INITIAL_SIZE = 8;
	private Integer count;
	private T[] store;

	public ArrayList(Integer initialSize) {
		if (initialSize < 1)
			initialSize = INITIAL_SIZE;
		store = (T[]) new Comparable[initialSize];
		count = 0;
		
	}

	private ArrayList(T[] array, Integer count) {
		this.store = array;
		this.count = count;
	}

	@Override
	public Boolean contains(T item) {
		for (T elem : store) {
			if (elem == item)
				return true;
		}
		return false;
	}

	@Override
	public Integer size() {
		return count;
	}

	@Override
	public Boolean isEmpty() {
		return count == 0;
	}

	@Override
	public void clear() {
		store = (T[]) new Comparable[store.length];
		count = 0;
	}

	@Override
	public void insert(T element) {
		if (this.isFull())
			doubleSizeThisList();
		store[count++] = element;
	}

	@Override
	public void insert(T element, Integer index) {
		if (index > count)
			throw new IllegalArgumentException("must not index>count");
		doubleSizeThisList();

		T[] tempStore = internalSlice(index, this.count);
		for (int k = index; k < tempStore.length - 1; k++) {
			store[k + 1] = tempStore[k];
		}
		store[index++] = element;
		count++;
	}

	@Override
	public void delete(Integer index) {
		if (index > count)
			throw new IllegalArgumentException("must not index>count");
		T[] tempStore = internalSlice(index + 1, this.count);
		int l = 0;
		for (int k = index; k < tempStore.length - 1; k++) {
			store[k] = tempStore[l++];
		}
		count--;
	}

	@Override
	public T get(Integer index) {
		if (index > count)
			throw new IllegalArgumentException("must not index>count");
		return store[index];
	}

	private void doubleSizeThisList() {
		T[] newStore = (T[]) new Comparable[store.length * 2];
		for (int i = 0; i < store.length; i++) {
			newStore[i] = store[i];
		}
		this.store = newStore;
	}

	private Boolean isFull() {
		return store.length == count;
	}

	@Override
	public List<T> slice(Integer i, Integer j) {
		return new ArrayList<T>(internalSlice(i, j), j - i);
	}

	private T[] internalSlice(Integer i, Integer j) {
		T[] returnStore = (T[]) new Comparable[store.length];
		int l = 0;
		for (int k = i; k < j; k++) {
			returnStore[l++] = store[k];
		}
		return returnStore;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T> {

		int currentPosition = 0;

		@Override
		public boolean hasNext() {
			return currentPosition <= count;
		}

		@Override
		public T next() {
			return get(currentPosition++);
		}

	}

	@Override
	public void put(T item, Integer index) {
		if (this.size() < index) {
			throw new IllegalArgumentException("Index must not be smaller than size() of this list");
		}
		this.store[index] = item;
	}

	@Override
	public void sort(SortAlgorithm<T> sortAlgo) {
		// TODO Auto-generated method stub
	}

}
