package algorithm_interface;

import datastructure_interface.List;

public interface SortAlgorithm<T> {
	/**
	 * Type SortAlgorithm is a functional interface to be used in List tpye. This method can be used for various a implementations sort algorithms in the implementing class of this interface.
	 * @param li defines the list to be sorted. 
	 */
	public void sortThisList(List<?> li);

}
