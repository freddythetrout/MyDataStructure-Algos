package jUnitTests;



import datastructure_implementation.DoublyLinkedList;
import datastructure_interface.List;

class DoublyLinkedListTest extends AbstractListTest {

	@Override
	protected List<Integer> createList() {
		return new DoublyLinkedList<Integer>();
	}



}
