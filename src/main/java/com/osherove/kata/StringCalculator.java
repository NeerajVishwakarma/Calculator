/**
 * 
 */
package com.osherove.kata;

/**
 * @author Neeraj Vishwakarma
 *
 */
public class StringCalculator {

	public int add(String input) {
		int result = 0;
		if (input.isEmpty())
			return 0;
		else {
			String[] numbersInString = input.split(",");
			int[] numberInInt = new int[numbersInString.length];
			int counter = 0;
			for (String s : numbersInString)
				numberInInt[counter++] = Integer.parseInt(s);
			counter = 0;
			for (int i : numberInInt)
				result += i;
		}
		return result;
	}

}
