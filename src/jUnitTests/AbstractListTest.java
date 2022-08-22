package jUnitTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import algorithm_implementation.BubbleSort;
import datastructure_interface.List;

abstract class AbstractListTest<T extends Comparable<T>> {
    protected abstract List<Integer> createList();
	
    List<Integer> li;
    
    @BeforeEach                                         
    void setUp() {
        li = createList();
    }
    
    @Test
	void testCotains() {
		li.insert(1);
		li.insert(2);
		li.insert(3);
		assertTrue(li.contains(2));
	}
	
	@Test
	void testSize() {
		li.insert(1);
		li.insert(2);
		li.insert(3);
		assertTrue(li.size() == 3);
	}
	
	@Test
	void testIsEmpty() {
		assertTrue(li.isEmpty());
	}
	
	@Test
	void testClear() {
		li.insert(1);
		li.insert(2);
		li.insert(3);
		li.clear();
		assertTrue(li.isEmpty());
	}
	
	@Test
	void testInsertAtIndex() {
		li.insert(1);
		li.insert(2);
		li.insert(3);
		li.insert(0, 0);
		li.insert(1, 1);
		li.insert(5, 5);
		assertTrue(li.get(0)==0 && li.get(1)==1 && li.get(5)==5);
	}
	
	
	@Test
	void testGetInvalidIndex() {
	     Exception exception = assertThrows(IllegalArgumentException.class, () -> li.get(100));
	     assertEquals("must not index>count", exception.getMessage());
	}
	
	@Test
	@DisplayName("clear() list with one item")
	void testClearList() {
    	li.insert(1);
		li.clear();
		assertTrue(li.isEmpty(), "list is emty");
	
	}
	
	@Test
	@Order(2)
	@DisplayName("clear() list with several item")
	void testClearList1() {
    	li.insert(1);
    	li.insert(2);
		li.clear();
		assertTrue(li.isEmpty(), "list is emty");
	
	}
	
	@Test
	@DisplayName("size of empty list")
	void testSizeZero() {
		assertTrue(li.size() ==0, "list is emty");
	
	}
	
	@Test
	@DisplayName("size of list with one element")
	void testSizeOne() {
    	li.insert(1);
		assertTrue(li.size() ==1, "list has one element");
	
	}
	
	@Test
	@DisplayName("size of list with two element")
	void testSizeTwo() {
    	li.insert(1);
    	li.insert(2);
		assertTrue(li.size() == 2, "list has two elements");
	
	}
	
	@Test
	void testInsertFirstInEmptylist() {
		li.insert(0, 0);
		assertTrue((Integer) li.get(0) == 0);
	}
	
	@Test
	void testInsertFirstInNotEmptylist() {
		li.insert(1);
		li.insert(0, 0);
		assertTrue((Integer) li.get(0) == 0);
	}
	
	@Test
	void testInsertInBetween() {
		li.insert(0);
		li.insert(2);
		li.insert(1, 1);
		assertTrue((Integer) li.get(1) == 1);
	}
	@Test
	void testInsertBeforeTail() {
		li.insert(0);
		li.insert(1);
		li.insert(2,2);
		assertTrue((Integer) li.get(2) == 2 && (Integer) li.get(0) == 0 && (Integer) li.get(1) == 1 );
	}
	
	@Test
	void testDelete() {
		li.insert(0);
		li.insert(1);
		li.insert(2);
		li.delete(1);
		assertTrue((Integer) li.get(1) == 2 && (Integer) li.get(0) == 0 && li.size() == 2 );
	}
	
	@Test
	@Order(1)
	void testContains() {
		li.insert(0);
		li.insert(1);
		li.insert(2);
		assertTrue(li.contains(2) && li.contains(0) && li.contains(1) );
	}
	
	@Test
	void testput() {
		li.insert(0);
		li.insert(1);
		li.insert(2);
		li.put(10,1);
		assertTrue(li.get(1) == 10);
	}
	
	@Test
	void testsort() {
		li.insert(5);
		li.insert(2);
		li.insert(2);
		li.insert(2);
		li.insert(4);
		li.sort(new BubbleSort<Integer>());
		for (int elem : li) {
			System.out.println(elem);
		}
		for (int i = 1; i<li.size();i++) {
			assertTrue(li.get(i)>i-1);
		}
	}
		


}
