import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.osherove.kata.StringCalculator;

/**
 * 
 */

/**
 * @author Neeraj Vishwakarma
 *
 */
public class StringCalculatorTest {

	private StringCalculator calculator;

	@Before
	public void initialization() {
		calculator = new StringCalculator();
	}

	/*
	 * 1. The method can take 0, 1 or 2 numbers, and will return their sum (for an
	 * empty string it will return 0) for example “” == 0 , “1” == 1 , “1,2” == 3
	 */
	@Test
	public void takeSimpleInputAndCalculate() {
		assertTrue("Empty String Validation", (calculator.add("") == 0));
		assertTrue("Validation of addtion of one numbers", (calculator.add("101") == 101));
		assertTrue("Validation of addtion of two numbers", (calculator.add("8,9") == 17));
		assertTrue("Validation of addtion of two numbers", (calculator.add("78,19") == 97));
	}

	// 2. Allow the Add method to handle an unknown amount of numbers
	@Test
	public void takeUnknownInputAndCalculate() {
		assertTrue("Empty String Validation", (calculator.add("") == 0.000));
		assertTrue("Validation of addtion of one numbers", (calculator.add("102123121") == 0));
		assertTrue("Validation of addtion of two numbers", (calculator.add("2,34459") == 2));
		assertTrue("Validation of addtion of two numbers", (calculator.add("7324238,193222") == 0));
	}

	// 3. Allow the Add method to handle new lines between numbers (instead of
	// commas).
	@Test
	public void takenewLinesbtwNumberAndCalculate() {
		assertTrue("Validation of addtion of multiple numbers", (calculator.add("2\n34,3\n75,3,3,2\n3\n4\n8\n101") == 238));
		assertTrue("Validation of addtion of multiple numbers",
				(calculator.add("1\n6\n7324238,193222\n8\n342543") == 15));
	}

	// 4. Support different delimiters
	@Test
	public void supportDiffDelimiterbtwNumberAndCalculate() {
		assertTrue("Validation of addtion of multiple numbers", (calculator.add("//;\n2\n34;3\n75") == 114));
		assertTrue("Validation of addtion of multiple numbers",
				(calculator.add("//?\n1?6\n7324238?193222?8\n342543") == 15));
	}

	// 5. Calling Add with a negative number will throw an exception “negatives not
	// allowed” -
	// and the negative that was passed.
	@Test
	public void negativeNumberthrowExceptionAndCalculate() {
		System.out.println("Output of 5. Add A Negative Number");
		calculator.add("//;\n-2\n34;3\n75");
		calculator.add("//?\n1?6\n7324238?-193222?8\n342543");
	}

	// 6. If there are multiple negatives, show all of them in the exception message
	@Test
	public void multiNegativeNumberthrowExceptionAndCalculate() {
		System.out.println("Output of 6. Add Multiple Negative Numbers");
		calculator.add("//;\n-2\n-34;3\n-75");
		calculator.add("//?\n-1?6\n-7324238?-193222?8\n342543");
	}
	
	/*
	 * 7. Using TDD, Add a method to StringCalculator called public int
	 * GetCalledCount() that returns how many times Add() was invoked.
	 */
	@Test
	public void validateGetCalledCount() {
		negativeNumberthrowExceptionAndCalculate();
		takenewLinesbtwNumberAndCalculate();
		multiNegativeNumberthrowExceptionAndCalculate();
		assertEquals("Invoke Count Fails since Add Method is invoke multiple times.",6, calculator.GetCalledCount());
	}
	
	// 9. Numbers bigger than 1000 should be ignored,
	@Test
	public void numberBiggerThan1000IgnoredAndRestCalculated() {
		assertEquals("Validation of addtion of multiple numbers and 1000 is ignored", calculator.add("//;\n2\n34;3\n75"), 114);
		assertEquals("Validation of addtion of multiple numbers and 1000 is ignored", calculator.add("//?\n1?6\n7324238?193222?8\n342543"), 15);
		assertEquals("Validation of addtion of multiple numbers and 1000 is ignored", calculator.add("//?\n1000?600\n1001?0?8\n342543"), 1608);
	}
	
	// 10. Delimiters can be of any length with the following format:
	// “//[delimiter]\n”
	// “//[***]\n1***2***3” == 6
	@Test
	public void anylengthDelimitersAndCalculated() {
		assertEquals("Validation of any length of Delimiters", calculator.add("//[***]\n2***34***3***75"), 114);
		assertEquals("any length of Delimiters", calculator.add("//[%%]\n1%%6\n732%%42%%38%%193%%222%%8\n342%%543"), 2127);
		assertEquals("any length of Delimiters", calculator.add("//[,,]\n1000,,600\n1001,,0,,8\n3,,42,,543"), 2196);
	}
	
	// 11. Allow multiple delimiters
	@Test
	public void multipleDelimitersAsCharAndCalculated() {
		assertEquals("Validation of any length of Delimiters", calculator.add("//[*][?][^]\n2*3?4^3?7^5"), 24);
		assertEquals("any length of Delimiters", calculator.add("//[%][^]\n1^6\n732^42^38%19%32%22^8\n34%25^43"), 1002);
		assertEquals("any length of Delimiters", calculator.add("//[!][@][#][$]\n100$10!600\n10@01!0$8\n34#25#43"), 831);
	}
	
	// 12. make sure you can also handle multiple delimiters with length longer than one char
		@Test
		public void multipleDelimitersAsStringAndCalculated() {
			assertEquals("Validation of any length of Delimiters", calculator.add("//[***][???][%%%]\n2???3***4%%%3***7???5"), 24);
			assertEquals("any length of Delimiters", calculator.add("//[&&][@@@]\n1&&6\n73@@@193@@@8\n34&&43"), 358);
			assertEquals("any length of Delimiters", calculator.add("//[&&][$$][##][!!]\n10!!600\n10$$01##0$$8\n342&&543"), 1514);
		}
}
