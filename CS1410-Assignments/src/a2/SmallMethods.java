package a2;

public class SmallMethods {

	/**
	 * Computes true if the number is zero, false if it isn't.
	 * 
	 * @param number that will go through the if statement.
	 * @return if the number is zero or not.
	 */

	public static boolean isZero(int number) {
		if (number == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Calls the isZero method and computes if the number is "Zero" or "Not Zero"
	 * 
	 * @param isZeroNumber int number that gets determined if it is Zero or not.
	 * @return "Zero" or "Not Zero" depending on the value.
	 */

	public static String describeNumber(int isZeroNumber) {
		String numberDescription = "";
		if (isZero(isZeroNumber) == true) {
			numberDescription = numberDescription + "Zero";
			return numberDescription;

		} else
			numberDescription = numberDescription + "Not Zero";
		return numberDescription;

	}

	/**
	 * Determines if a number is Zero, Positive or Negative
	 * 
	 * @param numberToClassify is an int variable that will be classified
	 * @return the classification of the number
	 */

	public static String classifyNumber(int numberToClassify) {
		String numberClassification = "";
		if (numberToClassify == 0) {
			numberClassification = numberClassification + "Zero";
			return numberClassification;

		}
		if (numberToClassify > 0) {
			numberClassification = numberClassification + "Positive";
			return numberClassification;

		}
		numberClassification = numberClassification + "Negative";
		return numberClassification;
	}

	/**
	 * Determines if the number is divisible by three or five
	 * 
	 * @param divisbleByThreeOrFiveNumber the number that is getting divided
	 * @return true if the number is divisible by three or five. False otherwise
	 */

	public static boolean isEvenlyDivisibleByThreeOrFive(int divisibleByThreeOrFiveNumber) {
		// '%' is used to see if there is any remainder when divided
		// by 3, if it equals zero then yes it is divisible.
		if ((divisibleByThreeOrFiveNumber % 3) == 0) {
			return true;

		}
		if ((divisibleByThreeOrFiveNumber % 5) == 0) {
			return true;

		}

		return false;
	}

	/**
	 * Compares the two parameters to see which one is smaller
	 * 
	 * @param chooseSmallerNumber1
	 * @param chooseSmallerNumber2
	 * @return The smaller number of the two parameters
	 */

	public static double chooseSmaller(double chooseSmallerNumber1, double chooseSmallerNumber2) {
		if (chooseSmallerNumber1 > chooseSmallerNumber2) {
			return chooseSmallerNumber2;
		}
		if (chooseSmallerNumber1 < chooseSmallerNumber2) {
			return chooseSmallerNumber1;
		}
		return chooseSmallerNumber1;
	}

	/**
	 * Doubles the int variable until it surpasses one hundred then it returns the
	 * number before the one hundred mark.
	 * 
	 * @param doublingPastOneHundredNumber the int variable it doubles
	 * @return The number before the one hundred mark.
	 */

	public static int firstDoublingPastOneHundred(int doublingPastOneHundredNumber) {
		//if the output is zero or a negative the output will be 0
		if (doublingPastOneHundredNumber <= 0) {
			return 0;
		}
		while (doublingPastOneHundredNumber <= 100) {
			doublingPastOneHundredNumber = doublingPastOneHundredNumber * 2;
		}

		return doublingPastOneHundredNumber;

	}

	/**
	 * This method skips every other letter of the parameter.
	 * 
	 * @param wordToBeSkipped is storing the word which letters we are skipping.
	 * @return A string of letters that have been skipped in the main word.
	 */

	public static String skipLetters(String wordToBeSkipped) {
		String wordReturned = "";
		//numberOfLetter is the number of letters in the word.
		int numberOfLetter = wordToBeSkipped.length();
		//The number inside the index of the word. 
		int skipIndex = 0;
		while (skipIndex < numberOfLetter) {
			wordReturned += wordToBeSkipped.charAt(skipIndex);
			skipIndex = skipIndex + 2;

		}

		return wordReturned;
	}

	/**
	 * Produces a String starting and ending with the edge character and having the
	 * inner char repeated in-between. The total number of characters in the string
	 * is width. As an example makeLine('+', '-', 8) would return the string
	 * "+------+".
	 * 
	 * NOTE: This method is already completely implemented and must not be modified
	 * for the assignment.
	 * 
	 * @param edge  The character used at the start and end of the returned string.
	 * @param inner The character repeated in-between the edge char.
	 * @param width The total number of characters in the returned string. Width
	 *              must be greater or equal to 2.
	 * @return A string with width characters.
	 */

	public static String makeLine(char edge, char inner, int width) {
		String line = "";
		int currentLocation = 0;
		// Make the middle part of the line first.
		while (currentLocation < width - 2) {
			line = line + inner;
			currentLocation = currentLocation + 1;
		}
		// Add in the start and end character to the line.
		return edge + line + edge;
	}

	/**
	 * Produces a string that makes the edges of a square by using the while loop to
	 * determine the length
	 * 
	 * @param sizeOfSquare is the restriction inside the while loop
	 * @return "| |" which will end up being the edge of the square.
	 */

	public static String makeSquare(int sizeOfSquare) {
		String lineSquare = "|    |";
		String returnSquare = "";
		//Calling the makeLine method to get the top and bottom of square.
		String squareLine = makeLine('+', '-', 6);
		int squareLocation = 0;
		while (squareLocation < sizeOfSquare) {
			returnSquare = returnSquare + lineSquare + '\n';
			squareLocation = squareLocation + 1;
		}

		//Connecting the dots to create the edge of a square.
		returnSquare = squareLine + '\n' + returnSquare + squareLine;

		return returnSquare;

	}

	public static void main(String[] args) {
		//Testing the isZero method below.
		int testIsZero = 3;
		System.out.println("Is the number zero? " + isZero(testIsZero));
		//Testing the describeNumber method below.
		int testDescribeNumber = 8;
		System.out.println("Hey, is it zero? " + describeNumber(testDescribeNumber));
		//Testing the classifyNumber method below.
		int testClassifyNumber = 23;
		System.out.println("What kind of number is it? " + classifyNumber(testClassifyNumber));
		//Testing isEvenlyDivisibleByThreeOrFive method.
		int testNumberThreeFive = 15;
		String testStringFiveThree = "True/False? Is this divisible by 3 or 5? ";
		System.out.println(testStringFiveThree + isEvenlyDivisibleByThreeOrFive(15));
		//Testing chooseSmaller method.
		System.out.println(chooseSmaller(4.7, 4.6));
		//Testing firstDoublingPastOneHundred method.
		System.out.println(firstDoublingPastOneHundred(0));
		//Testing skipLetters method. 
		String wordOfTheDay = "Tattoo";
		System.out.println(skipLetters(wordOfTheDay));
		//Testing makeSquare method.
		String presentSquare = "I present to you my square!";
		System.out.println(presentSquare + '\n' + makeSquare(6));

	}

}
