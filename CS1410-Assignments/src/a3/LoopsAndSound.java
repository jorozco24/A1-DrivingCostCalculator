package a3;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * A3 LoopsAndSound
 * @author Jorge Orozco
 *
 */
public class LoopsAndSound {
	

	/**
	 * Computes a double array that has as its elements a sliding average of the parameter array elements.
	 * @param arrayInput the array entered to call the method
	 * @return the sliding average of the values into the new array.
	 */
	public static double[] smoothSound(double[] arrayInput) {
		double[] newArray = new double[arrayInput.length];
		double divideAverageBy = arrayInput.length;
		//initializing the first and final element of the new array.
		newArray[0] = (arrayInput[0] + arrayInput[1]) / 2;
		newArray[arrayInput.length - 1] = (arrayInput[arrayInput.length - 1] + arrayInput[arrayInput.length - 2]) / 2;
		//for loop to determine the middle section of the new array
		for(int index = 1; index < arrayInput.length - 1; index++)	{
			newArray[index] = (arrayInput[index] + arrayInput[index -1] + arrayInput[index + 1]) / divideAverageBy;	
			
		}
		
		return newArray;
	}

	/**
	 * Computes the echo of a sound file.
	 * @param arrayInput is the sound sample in the form of array.
	 * @param samples the offset of where the sound begins.
	 * @param weight is the volume to the echo.
	 * @return a new double array with the echo beginning in the offset
	 * and maximized by the index multiplied by the weight.
	 */
	public static double[] echoSound(double[] arrayInput, int samples, double weight) {
		double[] newArray = new double[arrayInput.length + samples];
		for (int index = 0; index < samples; index++) {
			newArray[index] = arrayInput[index];
		}
		for (int index = samples; index < arrayInput.length; index++) {
			double orgIndexSamples = arrayInput[index - samples];
			double samplesTimesWeight = orgIndexSamples * weight;
			newArray[index] = arrayInput[index] + samplesTimesWeight;
		}
		for (int index = arrayInput.length; index < arrayInput.length + samples; index++) {
			newArray[index] = arrayInput[index - samples] * weight;

		}

		return newArray;
	}

	/**
	 * Scales the sound array by the value inserted into the parameters.
	 * @param arrayInput the sound array entered into the main.
	 * @param val the number that's multiple creates the scale.
	 * @return a new double array which contains the original values
	 * multiplied by the value entered in the parameter.
	 */
	public static double[] scaleSound(double[] arrayInput, double val) {
		double[] newArray = new double[arrayInput.length];
		double orgArrayIndex = 0;
		for (int index = 0; index < newArray.length; index++) {
			orgArrayIndex = arrayInput[index];
			newArray[index] = orgArrayIndex * val;
		}
		return newArray;
	}

	/**
	 * Computes the elements in the parameter in reverse order in the return value.
	 * @param arrayInput is the array that is going to be changed.
	 * @return a new array with the same elements as the original array
	 * but in reverse chronological order.
	 */
	public static double[] reverseSound(double[] arrayInput) {
		double[] newArray = new double[arrayInput.length];
		int newIndex = 0;
		int arrayMinus1 = arrayInput.length - 1;
		for (int index = 0; index < newArray.length; index++) {
			newIndex = arrayMinus1 - index;
			newArray[index] = arrayInput[newIndex];
		}

		return newArray;

	}

	/**
	 *  Computes a new int array of 10 integers. 
	 *  @param arrayInput is the param array that the code looks over.
	 *  @return a new int array of 10 integers where the value in the new array at index '' 
	 *  is the number of times the value '' appears in the parameter array.
	 */
	public static int[] frequencyCount(int[] arrayInput) {
		int[] newArray = new int[10];
		int count = 0;
		for (int index = 0; index < arrayInput.length; index++) {
			count = arrayInput[index];
			newArray[count] += 1;

		}

		return newArray;
	}

	/**
	 * Computes the average of the elements inside of an int array.
	 * @param arrayInput the list of values this code reviews.
	 * @return the average number of the list of values.
	 */
	public static double averageArrayValues(int[] arrayInput) {
		double sum = 0;
		for (int index = 0; index < arrayInput.length; index++) {
			sum += arrayInput[index];

		}
		sum = sum / arrayInput.length;

		return sum;

	}

	/**
	 * Determines between the values of the array given
	 * which is greater, the number of even numbers or odd.
	 * @param arrayInput the list of values given to the method to review.
	 * @return if there are more even numbers it returns true
	 * if there are more odd it returns false.
	 */
	public static boolean hasMoreEvenThanOdd(int[] arrayInput) {

		int counterEven = 0;
		int counterOdd = 0;

		for (int index = 0; index < arrayInput.length; index++) {
			if (arrayInput[index] % 2 == 0) {
				counterEven += 1;

			} else {
				counterOdd += 1;
			}
		}
		if (counterEven > counterOdd) {
			return true;
		}
		return false;

	}

	/**
	 * Replaces all the 'a' in the given String to '*'.
	 * @param phrase the String sent to the method to replace all the 'a' with '*'.
	 * @return every character 'a' in the String, it changes to '*'
	 * and replaces the String to the main. 
	 */
	public static String hideLetterA(String phrase) {
		String result = "";
		for (int index = 0; index < phrase.length(); index++) {
			if (phrase.charAt(index) == 'a') {
				result += '*';
			} else {
				result += phrase.charAt(index);
			}
		}

		return result;

	}

	/**
	 * Changes the int Array into a String phrase. 
	 * @param arrayInput is the array that gets converted to a String.
	 * @return an array in the form of a String.
	 */
	public static String arrayToString(int[] arrayInput) {
		String result = "";
		String comma = ", ";
		for (int index = 0; index < arrayInput.length - 1; index++) {
			result += arrayInput[index] + comma;

		}
		int finalIndex = arrayInput.length - 1;
		result += arrayInput[finalIndex];
		result = "{" + result + "}";
		return result;
	}

	/**
	 * changes all the values in the array to '0'
	 * @param arrayInput
	 *
	 */
	public static void clearArray(int[] arrayInput) {
		for (int index = 0; index < arrayInput.length; index++) {
			arrayInput[index] = 0;

		}

	}

	public static void main(String[] args) {
		//Testing the clearArray
		int[] arrayInput = { 2, 4, 5, 6, 79 };
		clearArray(arrayInput);
		System.out.println(Arrays.toString(arrayInput));
		//Testing arrayToString
		int[] arrayToStringTest = { 1, 2, 6, 7, 8, 9, 10 };
		System.out.println(arrayToString(arrayToStringTest));
		//Testing hideLetterA method
		System.out.println(hideLetterA("Everybody put your hands up!"));
		//Testing hasMoreEvenThanOdd method
		int[] arrayForEvenOdd = { 1, 2, 4, 7, 9, 21 };
		System.out.println(hasMoreEvenThanOdd(arrayForEvenOdd));
		//Testing averageArrayValues method
		int[] testArrayAverage = { 1, 2, 2, 8 };
		System.out.println(averageArrayValues(testArrayAverage));
		//Testing frequencyCount method
		int[] testingFrequencyCount = frequencyCount(testArrayAverage);
		System.out.println(Arrays.toString(testingFrequencyCount));
		//Testing reverseSound method
		double[] reverseArrayTest = { 1.0, 1.5, 2.0, 4.5, 5.0 };
		double[] newReverseTest = reverseSound(reverseArrayTest);
		System.out.println(Arrays.toString(newReverseTest));
		//Testing scaleSound method
		double[] testScaleArray = { 1.0, 2.0, 3.0, 4.0 };
		double[] testingScaleSound = scaleSound(testScaleArray, 2.0);
		System.out.println(Arrays.toString(testingScaleSound));
		//Testing echoSound method
		double[] echoArray = { 0.1, 0.2, 0.3, 0.4 };
		double[] testEchoSound = echoSound(echoArray, 2, 0.5);
		System.out.println(Arrays.toString(testEchoSound));
		//Test smoothSound method
		double[] testSmoothSound = {0.0,1.0,0.7,0.2};
		double[] testingSmoothSound = smoothSound(testSmoothSound);
		System.out.println(Arrays.toString(testingSmoothSound));
		

	}

}
