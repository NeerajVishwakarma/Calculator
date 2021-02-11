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
	
	//2. Allow the Add method to handle an unknown amount of numbers
	@Test
	public void takeUnknownInputAndCalculate() {
		assertTrue("Empty String Validation", (calculator.add("") == 0.000));
		assertTrue("Validation of addtion of one numbers", (calculator.add("102123121") == 102123121));
		assertTrue("Validation of addtion of two numbers", (calculator.add("2,34459") == 34461));
		assertTrue("Validation of addtion of two numbers", (calculator.add("7324238,193222") == 7517460));
	}
}
