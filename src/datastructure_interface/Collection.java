package datastructure_interface;

import algorithm_interface.SortAlgorithm;

/**
 * 
 * traversable data structures like lists, sets, maps
 *
 */

public interface Collection<T> extends Container {
	/**
	 * Checks if an item is in the collection.
	 * @param item to check for.
	 * @return true, if the item it in the list.
	 */
	Boolean contains(T item);
	
}
