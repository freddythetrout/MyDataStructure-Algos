package algorithm_implementation;

import algorithm_interface.SortAlgorithm;
import datastructure_interface.List;

public class InsertionSort<T> implements SortAlgorithm{

	@Override
	public void sortThisList(List li) {
		T tempElement = null;
		for (int i = 1 ; i < li.size(); i++) {
			tempElement = (T) li.get(i);
			for (int j = i; j>= 0 ;j--) {
				if (li.get(j).compareTo(li.get(i)) > 0) {
					li.put(li.get(j), i);
					li.put((Comparable) tempElement, j);
				}
			}
			
		}
		
		
	}


}
