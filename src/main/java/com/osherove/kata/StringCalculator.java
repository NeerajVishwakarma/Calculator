/**
 * 
 */
package com.osherove.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Neeraj Vishwakarma
 *
 */
public class StringCalculator {

	static int invokeCount = 0;

	public long add(String inputString) {
		String input = inputString;
		invokeCount++;
		long result = 0;
		List<String> delimiterList = new ArrayList<String>();
		List<String> numbers = new ArrayList<String>();
		if (input.isEmpty())
			return 0;
		else {
			if (input.startsWith("//")) {
				delimiterList = this.getDelimeters(input.substring(0, input.indexOf("\n")));
//					defaultDelimeter = Character.toString(input.charAt(2));
				input = input.substring(input.indexOf("\n") + 1);
			}else {
				delimiterList.add(",");
				delimiterList.add("\n");
			}
			
			/*
				 * else { // defaultDelimeter = input.substring(input.indexOf("[") + 1,
				 * input.indexOf("]")); // input = input.substring(input.indexOf("]") + 2);
				 * String[] numbers = }
				 */
//			String[] numbersInString = input.split(Pattern.quote(defaultDelimeter)); 

			numbers = this.getNumbers(input, delimiterList);
			String[] numbersInString = numbers.toArray(new String[0]);
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
						if ((i <= 1000) & (i >= 0))
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

	private ArrayList<String> getNumbers(String input, List<String> delimitersList) {
		ArrayList<String> numbers = new ArrayList<String>();
		int delCounter = 0;
		for (int count = 0; count < delimitersList.size(); count++) {
			numbers = new ArrayList<String>(Arrays.asList(input.split(Pattern.quote(delimitersList.get(count)))));
			if (numbers.size() > 0) {
				delCounter = count;
				break;
			}
		}

		for (int i = 0; i < numbers.size(); i++) {
			boolean removed = false;
			for (int j = delCounter + 1; j < delimitersList.size(); j++) {
				if (numbers.get(i).contains(delimitersList.get(j))) {
					numbers.addAll(new ArrayList<String>(
							Arrays.asList(numbers.get(i).split(Pattern.quote(delimitersList.get(j))))));
					numbers.remove(i);
					removed = true;
				}
				
			}
			if(removed)
				i--;
		}

		return numbers;
	}

	private List<String> getDelimeters(String delimins) {
		String[] delimiterArr = delimins.substring(2).split("[\\[\\]]");
		List<String> delimitersList = new ArrayList<String>();
		for (String delimiter : delimiterArr)
			if (!delimiter.trim().isEmpty())
				delimitersList.add(delimiter);
		delimitersList.add("\n");
		return delimitersList;
	}

	public int GetCalledCount() {
		return StringCalculator.invokeCount;
	}

}
