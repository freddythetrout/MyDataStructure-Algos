package algorithm_implementation;

import algorithm_interface.SortAlgorithm;
import datastructure_interface.List;

public class SelectionSort<T> implements SortAlgorithm {

	@Override
	public void sortThisList(List li) {
		T tempMinElement = null;
		for (int j = 0; j < li.size()-1; j++) {
			int minIndex = j;
			for (int i = j + 1; i < li.size(); i++) {
				if (li.get(i).compareTo(li.get(minIndex)) <0) {
					minIndex = i;
				}
			}
			tempMinElement = (T) li.get(minIndex);
			li.put(li.get(j), minIndex);
			li.put((Comparable) tempMinElement, j);
		}
	}
}