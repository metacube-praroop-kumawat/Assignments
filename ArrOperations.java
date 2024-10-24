/*******************************************************************************************************
* @classname: ArrOperations
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/10/24         Making functions to do specified operations on Arrays
********************************************************************************************************/

import java.util.Scanner;

public class ArrOperations {
	
	/**
	 * find the max length of mirror in an array such that left side portion should be
	 * 		mirror image of right side portion
	 * @param - arr array in which maximum length mirror is present
	 * @return - length maxMirror as its the maximum length
	 */
	public int maxMirror(int arr[]) {
		// Throw the exception if the array is empty
		if( arr.length == 0) {
			throw new IllegalArgumentException("Array is empty, cannot find mirror section");
		}
		int maxMirror = 0;
		int n  = arr.length;
		// Loop through all starting points in the array for comparison
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int length = 0;
				// compare forward from i and backward from j
				while(i + length < n && j - length >= 0 && arr[i + length] == arr[j - length]) {
					length++;
				}
				// update maximum mirror length
				maxMirror = Math.max(maxMirror, length);
			}
		}
		return maxMirror;
	}
	
	/**
	 * counting the subarray with same elements possible in array
	 * @param - arr array in which subarray are present
	 * @return - int clumps which are total number of subarray possible
	 */
	public int countClumps(int arr[]) {
		// Throw the exception if the array is empty
		if( arr.length == 0) {
			throw new IllegalArgumentException("Array is empty, cannot find clumps");
		}
		int clumps = 0;
		boolean prevIsEqual = false;
		// loop to check for subarray with same elements
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] == arr[i+1]) {
				prevIsEqual = true;
			//a subarray found and incrementing clumps 
			}else if(arr[i] != arr[i+1] && prevIsEqual) {
				clumps++;
				prevIsEqual = false;
			}			
		}
		//checking for last subarray separately because of out of bound exception
		if(prevIsEqual) {
			clumps++;
		}
		return clumps;
	}
	
	/**
	 * X should be followed by Y, thus rearranging array by swapping
	 * 		 Y with other elements present in array
	 * @param arr - array in which swapping is performed
	 * @param X - followed by Y, also X is fixed 
	 * @param Y - should follow X immediately
	 * @return - arr array after rearranging the original one
	 */
	public int[] fixXY (int arr[], int X, int Y) {
		// Throw the exception if the array is empty
		if( arr.length == 0) {
			throw new IllegalArgumentException("Array is empty, cannot perform rearranging");
		}
		for(int i=0; i<arr.length-1; i++) {
			//checking for index where X is not followed by Y
			if(arr[i] == X && arr[i+1]!= Y) {
				for(int j=0; j<arr.length; j++) {
					// case for j=0 as Index out of bound exception
					if(j==0 && arr[j] == Y) {
						arr[j] = arr[i+1];
						arr[i+1] = Y;
					}
					// case so if already rearranged Y don't get moved
					if(arr[j] == Y && arr[j-1]!= X && j>1 ) {
						arr[j] = arr[i+1];
						arr[i+1] = Y;
					}
				}
			}
		}
		return arr;
	}
	
	/**
	 * splitting array at index where left subarray sum is equal to right subarray sum
	 * @param arr - array in which index to be found
	 * @return - integer splitIndex around which array to be splitted
	 */
	public int splitArray(int arr[]) {
		// Throw the exception if the array is empty
		if( arr.length == 0) {
			throw new IllegalArgumentException("Array is empty, cannot find split index");
		}
		int splitIndex = -1;
		int n = arr.length;
		int sum = 0;
		for(int i = 0; i < n; i++ ) {
			sum += arr[i];
		}
		int halfSum = 0;
		for(int i = 0; i < n; i++) {
			halfSum += arr[i];
			if( halfSum == sum/2) {
				splitIndex = i+1;
				break;
			}
		}
		
		return splitIndex;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrOperations ao = new ArrOperations();
		System.out.print("Enter the size of array : ");
		int size = sc.nextInt();
		int array[] = new int[size];
		/* taking input in array */
		for(int i=0; i<size; i++) {
			System.out.print("Enter the " + (i+1) + "-index value : " );
			array[i] = sc.nextInt();
		}
		boolean condition = true;
		while(condition == true) {
			System.out.print("Enter the option :- " + '\n' + 
					"1. Perform maxMirror" + '\n' + "2. Perform countClumps " + '\n' + "3. Perform fixXY" + '\n' +
					"4. Perform splitArray" + '\n' + "5. Exit" + '\n' + "Enter your choice : ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				/* calling maxMirror function*/
				try {
					System.out.println(ao.maxMirror(array));
				}catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				/* calling countClump function */
				System.out.println(ao.countClumps(array));
				break;
			case 3:
				/* calling fixXY function */
				System.out.print("Enter X and Y respectively :");
				int X = sc.nextInt();
				int Y = sc.nextInt();
				int result[] = ao.fixXY(array, X, Y);
				for(int i = 0; i < result.length; i++) {
					System.out.print(result[i]+", ");
				}
				System.out.println();
				break;
			case 4:
				/* calling splitArray function */
				System.out.println(ao.splitArray(array));
				break;
			case 5:
				break;
			default:
				System.out.print("Inavalid choice" + '\n');
				break;
			}
			/* asking user if they wants to continue or not */
			System.out.print("Do you want to continue : Y/N");
			char continuation = sc.next().charAt(0);
			if(continuation == 'y' || continuation == 'Y') {
				condition = true;
			}else if( continuation == 'n' || continuation == 'N'){
				condition = false;
				System.out.print("Thank You for using ArrOperation Program.");
			}else{
				System.out.print("Invalid input !!" + '\n');
			}
			System.out.println();
		}
		try {
		int arr[] = {};
		System.out.println(ao.maxMirror(arr));
		}catch(IllegalArgumentException e) {
			System.out.print(e.getMessage());
		}
	}

}
