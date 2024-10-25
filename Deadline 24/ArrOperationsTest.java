package com.operationsOnArray;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ArrOperationsTest {

	@Test
	void maxMirror_whenArrayIsPassed_returnsMaxMirrorLength() {
		
		ArrOperations arrayOperations = new ArrOperations();
		
		int array1[] = {1,1,2,2,1};
		int array2[] = {1,2,3,4,5,3,2,1};
		int array3[] = {1,1,1,1,1};
		int array4[] = {-1, 1, -2, 3, -2, 1};
		int array5[] = {};
		
		int expected1 = arrayOperations.maxMirror(array1);
		int expected2 = arrayOperations.maxMirror(array2);
		int expected3 = arrayOperations.maxMirror(array3);
		int expected4 = arrayOperations.maxMirror(array4);
		AssertionError exception1 = assertThrows(AssertionError.class, () ->{
			arrayOperations.maxMirror(array5);
		});
		
		
		int actual1 = 4;
		int actual2 = 3;
		int actual3 = 5;
		int actual4 = 5;
		String actual5 = "Array is empty, cannot find mirror section";
		
		assertEquals(actual1, expected1);
		assertEquals(actual2, expected2);
		assertEquals(actual3, expected3);
		assertEquals(actual4, expected4);
		assertEquals(actual5, exception1.getMessage());
		
	}
		
		@Test
		void countClumps_whenPassedArray_returnNumberOfClumps() {
			ArrOperations arrayOperations = new ArrOperations();

			int array1[] = {1,1,2,2,1};
			int array2[] = {1,2,3,4,5,3,2,1};
			int array3[] = {1,1,1,1,1};
			int array4[] = {1,1,2,1,1};
			
			int expected1 = arrayOperations.countClumps(array1);
			int expected2 = arrayOperations.countClumps(array2);
			int expected3 = arrayOperations.countClumps(array3);
			int expected4 = arrayOperations.countClumps(array4);
			
			int actual1 = 2;
			int actual2 = 0;
			int actual3 = 1;
			int actual4 = 2;
			
			assertEquals(actual1, expected1);
			assertEquals(actual2, expected2);
			assertEquals(actual3, expected3);
			assertEquals(actual4, expected4);
		}
		
		@Test
		void fixXY_whenPassedArrayInetegrXIntegerY_returnRearrangedArray() {
			ArrOperations arrayOperations = new ArrOperations();
			
			int array1[] = {5, 4, 9, 4, 9, 5};
			int array2[] = {1, 4, 1, 5};
			int array3[] = {1, 4, 1, 5, 5, 4, 1};
			
			int actual1[] = {9, 4, 5, 4, 5, 9};
			int actual2[] = {1, 4, 5, 1};
			int actual3[] = {1, 4, 5, 1, 1, 4, 5};
			
			int expected1[] = arrayOperations.fixXY(array1, 4, 5);
			int expected2[] = arrayOperations.fixXY(array2, 4, 5);
			int expected3[] = arrayOperations.fixXY(array3, 4, 5);
			
			assertArrayEquals(actual1, expected1);
			assertArrayEquals(actual2, expected2);
			assertArrayEquals(actual3, expected3);
		}
		
		@Test
		void splitArray_whenPassedArray_returnSplitIndex() {
			ArrOperations arrayOperations = new ArrOperations();
			
			int array1[] = {1, 1, 1, 2, 1};
			int array2[] = {2, 1, 1, 2, 1};
			int array3[] = {10, 10};
			
			int actual1 = 3;
			int actual2 = -1;
			int actual3 = 1;
			
			int expected1 = arrayOperations.splitArray(array1);
			int expected2 = arrayOperations.splitArray(array2);
			int expected3 = arrayOperations.splitArray(array3);
			
			assertEquals(actual1, expected1);
			assertEquals(actual2, expected2);
			assertEquals(actual3, expected3);
		}
		
		
		
}


