/**
 * 
 */
package com.osherove.kata;

/**
 * @author Neeraj Vishwakarma
 *
 */
public class StringCalculator {

	public long add(String input) {
		long result = 0;
		if (input.isEmpty())
			return 0;
		else {
			String[] numbersInString = input.split(",");
			long[] numberInInt = new long[numbersInString.length];
			int counter = 0;
			for (String s : numbersInString)
				numberInInt[counter++] = Integer.parseInt(s);
			counter = 0;
			for (long i : numberInInt)
				result += i;
		}
		return result;
	}

}
