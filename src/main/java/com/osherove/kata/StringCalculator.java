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
			for (long i : numberInInt) {
				if(i<0)
					throw new Exception(Long.toString(i));
				result += i;
			}
			}
			catch(Exception e) {
				System.out.println("Negatives not allowed - "+e.getMessage());
			}
		}
		return result;
	}

}
