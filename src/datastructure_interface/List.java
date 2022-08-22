package datastructure_interface;

import algorithm_interface.SortAlgorithm;

public interface List<T extends Comparable<T>>  extends Collection<T>, Iterable<T>  {
	
	/**
	 * Insert an item in the list
	 * @param item to insert
	 */
	void insert(T item);
	
	/**
	 * inserts item at the end of the list
	 * @param item is the element to insert
	 * @param index of the list to insert the new element. index <= count
	 */
	void insert(T item, Integer index) throws IllegalArgumentException;
	
	/**
	 * Deletes the element on position of the index in the list
	 * @param 0 <= index <= size()
	 */
	void delete(Integer index)throws IllegalArgumentException;
	
	/**
	 * Returns the element on position of the index from the list
	 * @param 0 <= index <= size()
	 * @return element on position index
	 */
	T get(Integer index)throws IllegalArgumentException;
	
	/**
	 * Creates a new list that begins on index and ends with index j based on the current list.
	 * @param i starting index to slice the current list
	 * @param j ending index to slice the current list
	 * @return a new list which first element is i of the current list and which last element is j of the current list.
	 */
	List<T> slice(Integer i, Integer j);
	
	/**
	 * Replaces the current item at the index position of the list
	 * @param item put into the list
	 * @param index is the position in the list to put the item
	 */
	void put(T item, Integer index);
	
	/**
	 * Sorts all the elements of the list in den ascending order
	 */
	void sort(SortAlgorithm<T> sortAlgo);


	

}
