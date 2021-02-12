/**
 * 
 */
package com.osherove.kata;

import java.util.Arrays;

/**
 * @author Neeraj Vishwakarma
 *
 */
public class StringCalculator {

	static int invokeCount = 0;

	public long add(String input) {
		invokeCount++;
		long result = 0;
		char defaultDelimeter = ',';
		if (input.isEmpty())
			return 0;
		else {
			if (input.startsWith("//")) {
				defaultDelimeter = input.charAt(2);
				input = input.substring(3);
			}
			String[] numbersInString = input.split("[\n" + defaultDelimeter + "]");
			long[] numberInInt = new long[numbersInString.length];
			int counter = 0;

			for (String s : numbersInString)
				if (!s.isEmpty())
					numberInInt[counter++] = Integer.parseInt(s);
			counter = 0;
			try {
				long[] negativeNumbers = new long[numberInInt.length];
				boolean foundNegative = false;
				int negativeCounter = 0;
				for (long i : numberInInt) {
					if (i < 0) {
						negativeNumbers[negativeCounter++] = i;
						foundNegative = true;
					}
					if (!foundNegative) {
						if ((i <= 1000) & (i>=0))
							result += i;
					}

				}
				if (foundNegative) {
					throw new Exception(Arrays.toString(Arrays.copyOfRange(negativeNumbers, 0, negativeCounter)));
				}
			} catch (Exception e) {
				System.out.println("Negatives not allowed - " + e.getMessage());
			}
		}
		return result;
	}

	public int GetCalledCount() {
		return StringCalculator.invokeCount;
	}

}
