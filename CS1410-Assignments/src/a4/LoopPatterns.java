package a4;

import java.awt.Color;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * A4 LoopPatterns by
 * 
 * @author Jorge Orozco
 *
 */
public class LoopPatterns {
	/**
	 * makeBrighter method changes the color of the pixels to make the param picture
	 * brighter.
	 * 
	 * @param picture thats pixels color change
	 * @return a much brighter copy due to the pixel colors being doubled.
	 */
	public static Picture makeBrighter(Picture picture) {
		Picture copyOfPicture = new Picture(picture);
		int colorMax = 255;
		int colorMin = 0;
		int width = picture.width();
		int height = picture.height();
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				Color color = picture.get(col, row);
//With help of the FOR loop, we get to change each pixels colors
// by doubling them by two. 				
				int red = color.getRed() * 2;
				int blue = color.getBlue() * 2;
				int green = color.getGreen() * 2;
//The if statements below make sure there are no colors outside of the 0-255 range		
				if (red > colorMax) {
					red = 255;
				}
				if (red < colorMin) {
					red = 0;
				}
				if (blue > colorMax) {
					blue = 255;
				}
				if (blue < colorMin) {
					blue = 0;
				}
				if (green > colorMax) {
					green = 255;
				}
				if (green < colorMin) {
					green = 0;
				}
				Color Newcolor = new Color(red, green, blue);
				copyOfPicture.set(col, row, Newcolor);
			}
		}
		return copyOfPicture;
	}
	/**
	 * The safeColor method ensures that the int value does not 
	 * go outside of the 0-255 color range.
	 * @param colorValue is the number that represents a color in 
	 * the Red, Blue, Green spectrum.
	 * @return the number is it's within the color range.
	 * If it's outside it is greater than 255 returns 255.
	 * If it's less than 0 returns 0.
	 */
	public static int safeColor(int colorValue) {
		int safeNumberMax = 255;
		int safeNumberMin = 0;
		int resultValue = 0;
		if (colorValue > safeNumberMin && colorValue < safeNumberMax) {
			resultValue = colorValue;
		}
		if (colorValue < safeNumberMin) {
			resultValue = safeNumberMin;
		}
		if (colorValue >= safeNumberMax) {
			resultValue = safeNumberMax;
		}

		return resultValue;

	}
	/**
	 * The makeNegative method sets the colors of the picture
	 * to be in a negative tone.
	 * This is achieved by going through the picture and subtract the 
	 * color's number from 255. 
	 * @param picture is the image where the colors of the pixels
	 * will be changed and made into a copy.  
	 * @return a copy of the picture but in a negative tone.
	 */
	public static Picture makeNegative(Picture picture) {
		Picture copyOfPicture = new Picture(picture);
		int width = picture.width();
		int height = picture.height();
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				Color color = picture.get(col, row);
				int negativeRed = 255 - color.getRed();
				int negativeBlue = 255 - color.getBlue();
				int negativeGreen = 255 - color.getGreen();
				Color negativeColor = new Color(negativeRed, negativeGreen, negativeBlue);
				copyOfPicture.set(col, row, negativeColor);
			}
		}
		return copyOfPicture;
	}
	/**
	 * The makeGrey method changes the colors in the image's pixels
	 * to make the picture be a grey tone. 
	 * @param picture is the image thats pixels will be changed and copied to
	 * a grey toned picture. 
	 * @return copy of the picture but in a grey tone. 
	 */
	public static Picture makeGrey(Picture picture) {
		Picture copyOfPicture = new Picture(picture);
		int width = picture.width();
		int height = picture.height();
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				Color color = picture.get(col, row);
				int red = color.getRed();
				int blue = color.getBlue();
				int green = color.getGreen();
				int grey = (red + blue + green) / 3;
				Color allGreyColor = new Color(grey, grey, grey);
				copyOfPicture.set(col, row, allGreyColor);
			}
		}
		return copyOfPicture;
	}
	/**
	 * The containsThisColor method computes True if a picture contains
	 * the color sent from the main method. False otherwise!
	 * @param picture is the image where the method will check
	 * if it contains a certain color. 
	 * @param color is the certain color the method will see if
	 * the picture has. 
	 * @return True if the picture has the color
	 * False otherwise.
	 */
	public static boolean containsThisColor(Picture picture, Color color) {
		int width = picture.width();
		int height = picture.height();
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				Color picColor = picture.get(col, row);
				if (picColor.equals(color)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * The findSmallestPositiveNumber method computes the smallest positive number
	 * in the array of values given in the param. 
	 * @param values a list of double values to use the method on.
	 * @return the smallest positive number in a double type.
	 */
	public static double findSmallestPositiveNumber(double[] values) {
		double smallestPositiveNumber = values[0];
		//Gathering all positive numbers below into an array.
		for (int index = 0; index < values.length; index++) {
			if (values[index] > 0) {
				smallestPositiveNumber = values[index];

			}
		}
		//Finding the smallest positive number in the array.
		for (int index = 0; index < values.length; index++) {
			if (smallestPositiveNumber > values[index] && values[index] > 0) {
				smallestPositiveNumber = values[index];
			}

		}

		return smallestPositiveNumber;

	}
	
	/**
	 * The curveScores method subtracts the highest number in the array by 100
	 * then changes that number to 100. 
	 * The difference of that calculation gets added onto the rest of the numbers. 
	 * @param values list of array values to change.
	 * @return a new array with the highest score being 100
	 * and the rest being the original numbers with the difference added. 
	 */
	public static int[] curveScores(int[] values) {
		int[] resultValues = new int[values.length];
		int numberMinus100 = 0;
		int indexPlusOne = 1;
		int highestNumber = values[0];
		for (int index = 0; index < values.length - 1; index++) {
			if (highestNumber > values[indexPlusOne]) {
				numberMinus100 = 100 - highestNumber;
				indexPlusOne += 1;

			} else {
				highestNumber = values[indexPlusOne];
				numberMinus100 = 100 - highestNumber;
				indexPlusOne += 1;
			}

		}
		for (int index = 0; index < resultValues.length; index++) {
			resultValues[index] = values[index] + numberMinus100;
		}

		return resultValues;
	}

	/**
	 * The findSmallestNumberInTwoArrays computes the smallest number from
	 * the two arrays into an int type. 
	 * @param values first array to review for the smallest number
	 * @param values2 second array to review to find the smallest number
	 * @return the smallest number out of the two arrays
	 * in a int type. 
	 */
	public static int findSmallestNumberInTwoArrays(int[] values, int[] values2) {
		int smallestNumber = values[0];
	//finding the smallest number in the first array.	
		for (int index = 0; index < values.length; index++) {
			if (smallestNumber < values[index]) {
				smallestNumber = values[smallestNumber];
			} else {
				smallestNumber = values[index];
			}

		}
	//comparing the smallest number in the first array to the second.	
		for (int index = 0; index < values2.length; index++) {
			if (smallestNumber > values2[index]) {
				smallestNumber = values2[index];
			}

		}

		return smallestNumber;

	}

	/**
	 * The lowestAlphabetically method computes the word or letter in 
	 * the string that is the lowest alphabetically with the help
	 * of a lexicographic comparison. 
	 * @param words the array of words this method will be reviewing.
	 * @return the lowest word or letter that is the lowest alphabetically.
	 */
	public static String lowestAlphabetically(String[] words) {
		String result = words[0];

		int indexPlusOne = 1;
		for (int index = 0; indexPlusOne < words.length; index++) {
	//The compareTo method compares the two words using a lexicographic comparison. 		
			if (result.compareTo(words[indexPlusOne]) < 0) {
				indexPlusOne += 1;

			} else {
				result = words[indexPlusOne];
				indexPlusOne += 1;

			}

		}
		return result;
	}

	public static void main(String[] args) {
		// testing the lowestAlphabetically method
		String[] word = { "c", "e", "b", "d" };
		System.out.println("The lowest letter in the array is " + lowestAlphabetically(word));
		// testing findTheSmallestNumberOfTheTwoArrays
		int[] vals = { 4, 1, 2, 3 };
		int[] vals2 = { 2, 0, 6, 5 };
		System.out.println(findSmallestNumberInTwoArrays(vals, vals2));
		// testing curveScores
		int[] curveScoresArray = { 10, 40, 50, 80, 60 };
		System.out.println(Arrays.toString(curveScores(curveScoresArray)));
		// testing findSmallestPostiveNumber
		double[] testPostiveNumber = { 3.0, -4.0, 2.0 };
		System.out.println(findSmallestPositiveNumber(testPostiveNumber));
		// testing containThisColor
		Picture testPicture = new Picture("oceans.jpeg");
		Color colorMethod = new Color(100, 100, 100);
		System.out.println(containsThisColor(testPicture, colorMethod));
		// testing makeGrey method
		Picture makeGreyPicture = new Picture("Arches.jpg");
		makeGreyPicture.show();
		Picture pictureGrey = makeGrey(makeGreyPicture);
		pictureGrey.show();
		// testing makeNegative method
		Picture beforeNegativePicture = new Picture("Arches.jpg");
		Picture negativePicture = makeNegative(beforeNegativePicture);
		negativePicture.show();
		// testing safeColor below
		int valueSafe = 34;
		int safeColorNumber = safeColor(valueSafe);
		System.out.println(safeColorNumber);
		// testing makeBrighter method
		Picture makeBrighterPicture = new Picture("Arches.jpg");
		Picture testMakeBrighter = makeBrighter(makeBrighterPicture);
		testMakeBrighter.show();

	}

}
