package algorithm_implementation;

import algorithm_interface.SortAlgorithm;
import datastructure_interface.List;

public class BubbleSort<T> implements SortAlgorithm {
	@Override
	public void sortThisList(List li) {
		T tempElement;
		for (int i = 1; i < li.size() - 1; i++) {
			for (int j = i; j < li.size(); j++) {
				if (li.get(j).compareTo(li.get(j - 1)) < 0) {
					tempElement = (T) li.get(j);
					li.put(li.get(j - 1), j);
					li.put((Comparable) tempElement, j - 1);
				}
			}
		}
	}

}
