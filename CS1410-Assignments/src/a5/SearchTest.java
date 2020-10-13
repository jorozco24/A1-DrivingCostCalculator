package a5;

import java.util.Arrays;
import java.util.Random;

/**
 * This class compares the number of operations needed to search using
 * sequential search and binary search.
 * 
 * @author Prof. David E. Johnson
 *
 */
public class SearchTest {

	/**
	 * The main method controls the rest of the program. It determines the size of
	 * the array to be tested, the number of tests to be done per array, and then
	 * runs the tests and outputs some results.
	 * 
	 * Change this to loop over a range of array sizes such that the results provide
	 * insight into the behavior of binary search vs. sequential search.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// MODIFY: Make a loop here to test different array sizes. Running
		// the program should report on average search costs for several sizes.
		int testArraySize = 1000;
		while(testArraySize < 21000) {
		int numberofTestsPerArray = 100;
		int[] testArray = randomSortedFill(testArraySize);	
		double sequentialResults = testNRepetitionsSequential(testArray, numberofTestsPerArray);
		double binaryResults = testNRepetitionsBinary(testArray, numberofTestsPerArray);
		System.out.println(" For an array of size " + testArraySize + " the average search costs are:");
		System.out.println("     binaryAvg    : " + binaryResults + " iterations");
		System.out.println("     sequentialAvg: " + sequentialResults + " iterations");
		testArraySize += 1000;
		
		}
		
	}

	/**
	 * The method tests how many search loop iterations, on average, are needed to
	 * search a given int array for different key values using sequential search.
	 * The array has values ranging from 0 to length of the array - 1.
	 * 
	 * Pick a random key in that same range of values. Search for this key in the
	 * array and measure the number of search loop iterations by using the
	 * methods that need to be implemented below.
	 * 
	 * Repeat this search on the same array but a new key for numberOfTests times.
	 * 
	 * Calculate the average tests using the total number of search iterations and the
	 * number of tests.
	 * 
	 * @param randomSortedNumbers: an array of ints filled with random sorted
	 *                             values.
	 * @param numberOfTests:       the number of times to repeat the tests. Must be
	 *                             greater than 0.
	 * @return the average iterations used to search the array.
	 * 
	 */
	public static double testNRepetitionsSequential(int[] randomSortedNumbers, int numberOfTests) {
		Random number = new Random();
		int finalSequentialCount = 0;
		for(int index = 0; index < numberOfTests; index++) {
		int binaryCount = sequentialSearchForKeyWithCount(randomSortedNumbers, number.nextInt(randomSortedNumbers.length));
		finalSequentialCount += binaryCount;
		}
		double numberOfTestDouble = numberOfTests / 1.0;
		double average = finalSequentialCount / numberOfTestDouble;
		return average; // change this code to return the average iterations
	}

	/**
	 * The method tests how many search loop iterations, on average, are needed to
	 * search a given int array for different key values using binary search.
	 * The array has values ranging from 0 to length of the array - 1.
	 * 
	 * Pick a random key in that same range of values. Search for this key in the
	 * array and measure the number of search loop iterations by using the
	 * methods that need to be implemented below.
	 * 
	 * Repeat this search on the same array but a new key for numberOfTests times.
	 * 
	 * Calculate the average tests using the total number of search iterations and the
	 * number of tests.
	 * 
	 * @param randomSortedNumbers: an array of ints filled with random sorted
	 *                             values.
	 * @param numberOfTests:       the number of times to repeat the tests. Must be
	 *                             greater than 0.
	 * @return the average iterations used to search the array.
	 * 
	 */
	public static double testNRepetitionsBinary(int[] randomSortedNumbers, int numberOfTests) {
		Random number = new Random();
		int finalBinaryCount = 0;
		for(int index = 0; index < numberOfTests; index++) {	
		int binaryCount = binarySearchForKeyWithCount(randomSortedNumbers, number.nextInt(randomSortedNumbers.length));
		finalBinaryCount += binaryCount;
		}
		double numberOfTestDouble = numberOfTests / 1.0;
		double average = finalBinaryCount / numberOfTestDouble;
		return average; // change this code to return the average iterations
	}

	/**
	 * Given a length, make an int array of that length and fill the array with
	 * random values from 0 to length-1 (inclusive) int values. Use the Random class
	 * to generate these values. The array can have duplicate values, this is not a
	 * shuffle of all values from 0 to length-1, but instead length values picked
	 * randomly from 0 to length-1.
	 * 
	 * The values are then sorted in ascending order.
	 * 
	 * This method has been implemented for you. You do not need to change the
	 * documentation for this method.
	 * 
	 * @param length: the length of an array to be filled with random values.
	 * @return the array of sorted random values.
	 */
	public static int[] randomSortedFill(int length) {
		Random generator = new Random();
		int[] randomArray = new int[length];
		for (int index = 0; index < randomArray.length; index++) {
			randomArray[index] = generator.nextInt(length);
		}
		Arrays.sort(randomArray);

		return randomArray;
	}

	/**
	 * Search values for the key using binary search. Assumes values is sorted in
	 * ascending order. This code is provided as a reminder of how binary search
	 * works. You do not need to run it or modify it.
	 * 
	 * @param values a sorted array of values
	 * @param key    the value being searched for
	 * @return the index where key is found, or -1 otherwise.
	 */
	public static int binarySearchForKey(int[] values, int key) {
		int lo = 0;
		int hi = values.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (values[mid] == key)
				return mid;
			else if (values[mid] < key)
				lo = mid + 1;
			else // if (vals[mid] > key) is the only case left, so we don't need to check it.
				hi = mid - 1;
		}
		return -1;
	}

	/**
	 * Search values for the key using binary search. Assumes values is sorted in
	 * ascending order. Count the number of times the search loop repeats.
	 * 
	 * @param values a sorted array of values
	 * @param key    the value being searched for
	 * @return the number of search loop iterations.
	 */
	public static int binarySearchForKeyWithCount(int[] values, int key) {
		int count = 0;
		int lo = 0;
		int hi = values.length - 1;
		while (lo <= hi) {
			count += 1;  
			int mid = lo + (hi - lo) / 2;
			if (values[mid] == key) {
				
				return count;
			}
			else if (values[mid] < key) {
				lo = mid + 1;
				
			}
			else // if (vals[mid] > key) is the only case left, so we don't need to check it.
				hi = mid - 1;
				
		}
		return count;
	}

	/**
	 * Search values for the key using sequential search. This code is provided as
	 * a reminder of how sequential search works. You do not need to run it or
	 * modify it.
	 * 
	 * @param values a sorted array of values
	 * @param key    the value being searched for
	 * @return the index where key is found, or -1 otherwise.
	 */
	public static int sequentialSearchForKey(int[] values, int key) {
		for (int index = 0; index < values.length; index++) {
			if (key == values[index])
				return index;
		}
		return -1;
	}

	/**
	 * Search values for the key using sequential search. Assumes values is sorted in
	 * ascending order. Count the number of times the search loop repeats.
	 * 
	 * @param values a sorted array of values
	 * @param key    the value being searched for
	 * @return the number of search loop iterations.
	 */

	public static int sequentialSearchForKeyWithCount(int[] values, int key) {
		int count = 0;
		for (int index = 0; index < values.length; index++) {
			count += 1;
			if (key == values[index])
				return count;
		}
		return count;
	}

}
