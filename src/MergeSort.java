// Class: 		CS5381
// Student:		Jordan Hudgens
// Level:		Graduate Student
// Date:		2014-03-01
// Project:		Merge Sort for 10, 100, and 1000 items
// Algorithm:	Comments are listed next to the merge sort method

import java.util.Arrays;
import java.util.Random;
 
public class MergeSort {

	public static void main(String[] args) {
		MergeSort app = new MergeSort();
		
		// Start of array of size 10
		    System.out.println("------------------- 10 items ------------------------");
		    int[] input_10 = app.generateRandomNumbers(10);
			
		    // Values before sort
		    System.out.println("Before sorting: ");
		    System.out.println(Arrays.toString(input_10));
			
		    // After merge sort completes
		    System.out.println("After sorting: ");
		    System.out.println(Arrays.toString(app.mergeSort(input_10)));
	    // End of array of size 10
	    
	    // Start of array of size 100
		    System.out.println();
		    System.out.println("------------------- 100 items ------------------------");
		    int[] input_100 = app.generateRandomNumbers(100);
			
		    // Values before sort
		    System.out.println("Before sorting: ");
		    System.out.println(Arrays.toString(input_100));
			
		    // After merge sort completes
		    System.out.println("After sorting: ");
		    System.out.println(Arrays.toString(app.mergeSort(input_100)));
	    // End of array of size 100
	    
	    // Start of array of size 1000
		    System.out.println();
		    System.out.println("------------------- 1000 items ------------------------");
		    int[] input_1000 = app.generateRandomNumbers(1000);
			
		    // Values before sort
		    System.out.println("Before sorting: ");
		    System.out.println(Arrays.toString(input_1000));
			
		    // After merge sort completes
		    System.out.println("After sorting: ");
		    System.out.println(Arrays.toString(app.mergeSort(input_1000)));
		 // End of array of size 1000
	}
	
	private int[] mergeSort(int[] input){
		
		if(input.length == 1){
			return input;
		}
		
		int middle = (int) Math.ceil((double)input.length / 2); // finds a middle point of the supplied array
		int[] left = new int[middle]; // then sets the left value
		
		int rightLength = 0; // sets the right length value to 0 to start
		if(input.length % 2 == 0){ // iterates through the length with the modulus operators
			rightLength = middle; // and sets the rightLength value to the value in middle
		} else {
			rightLength = middle - 1; // or sets it to the value - 1
		}
		int[] right = new int[rightLength]; // sets the value of right to the position in the new array where rightLength is located
		
		int leftIndex = 0;  // sets the left and right index positions to 0 to start out
		int rightIndex = 0;
		
		for (int i = 0; i < input.length; i++) { // iterates through the length of the array
			if(i < middle){ // if the index is less than the middle
				left[leftIndex] = input[i]; // it sets the value of the leftIndex equal to the value at input index
				leftIndex++; // increments through the array from the left index
			} else {
				right[rightIndex] = input[i]; // if the index is greater than the middle, it sets the value of the right index
				rightIndex++; // increments through the array from the right index position
			}
		}
		
		left = mergeSort(left); // makes recursive calls
		right = mergeSort(right);
		
		return merge(left, right);
	}
	
	// Merge function that combines the arrays
	private int[] merge(int[] left, int[] right){
		int[] result = new int[left.length + right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		
		while(leftIndex < left.length || rightIndex < right.length){
			if(leftIndex < left.length && rightIndex < right.length){
				if(left[leftIndex] < right[rightIndex]){
					result[resultIndex] = left[leftIndex];
					leftIndex++;
					resultIndex++;
				} else {
					result[resultIndex] = right[rightIndex];
					rightIndex++;
					resultIndex++;
				}
			} else if(leftIndex < left.length){
				for (int i = resultIndex; i < result.length; i++) {
					result[i] = left[leftIndex];
					leftIndex++;
				}
			} else if(rightIndex < right.length){
				for (int i = resultIndex; i < result.length; i++) {
					result[i] = right[rightIndex];
					rightIndex++;
				}
			}
		}
		
		return result;
	}
	
	// Random number function that takes in an integer value for the
	// length of the initial array
	private int[] generateRandomNumbers(int n){
		
	    int[] result = new int[n];
	    Random random = new Random();
		
	    for (int i = 0; i < result.length; i++) {
		    result[i] = random.nextInt(n * 100);
	    }
	
	    return result;
	}
 
}