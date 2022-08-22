package jUnitTests;

import datastructure_implementation.ArrayList;
import datastructure_interface.List;

class ArrayListTest extends AbstractListTest {

	@Override
	protected List<Integer> createList() {
		return new ArrayList<Integer>(8);
	}


}