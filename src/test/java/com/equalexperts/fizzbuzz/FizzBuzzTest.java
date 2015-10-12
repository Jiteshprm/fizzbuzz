package com.equalexperts.fizzbuzz;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for EqualExperts FizzBuzz interview test
 * 
 * @author jitesh
 *
 */
public class FizzBuzzTest {

	private static final String MSG_MULTIPLE_OF_THREE = "fizz";
	private static final String MSG_MULTIPLE_OF_FIVE = "buzz";
	private static final String MSG_MULTIPLE_OF_FIFTHEEN = "fizzbuzz";
	private static final String MSG_NUMBER_CONTAINING_THREE = "lucky";
	private static final String THREE = "3";
	private static final String RESULT_STRING_STEP_THREE = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz"
			.concat(System.lineSeparator());
	private static final String RESULT_STRING_STEP_THREE_1 = "fizz: 4"
			.concat(System.lineSeparator());
	private static final String RESULT_STRING_STEP_THREE_2 = "buzz: 3"
			.concat(System.lineSeparator());
	private static final String RESULT_STRING_STEP_THREE_3 = "fizzbuzz: 1"
			.concat(System.lineSeparator());
	private static final String RESULT_STRING_STEP_THREE_4 = "lucky: 2"
			.concat(System.lineSeparator());
	private static final String RESULT_STRING_STEP_THREE_5 = "integer: 10";

	private Integer range = 0;
	private FizzBuzz fizzbuzz = null;
	private List<String> resultingList = null;
	private String resultingString = null;

	@Before
	public void initTests() {
		range = 20;
		fizzbuzz = new FizzBuzz(range);
		resultingList = fizzbuzz.generateList();
		resultingString = fizzbuzz.generateString();
	}

	@Test
	public void testWithRangeZero() {
		fizzbuzz = new FizzBuzz(0);
		resultingList = fizzbuzz.generateList();
		resultingString = fizzbuzz.generateString();
		assertEquals("", resultingString);
	}

	@Test(expected = RuntimeException.class)
	public void testWithRangeNegative() {
		fizzbuzz = new FizzBuzz(-1);
	}

	@Test
	public void testWithLongRange() {
		fizzbuzz = new FizzBuzz(1000);
		resultingList = fizzbuzz.generateList();
		resultingString = fizzbuzz.generateString();
		assertEquals(resultingList.get(75 - 1), MSG_MULTIPLE_OF_FIFTHEEN);
		assertEquals(resultingList.get(300 - 1), MSG_NUMBER_CONTAINING_THREE);
		assertEquals(resultingList.get(294 - 1), MSG_MULTIPLE_OF_THREE);
		assertEquals(resultingList.get(100 - 1), MSG_MULTIPLE_OF_FIVE);
	}

	@Test
	public void testIfRangeIsEqualToResultingListSize() {
		assertEquals(range.intValue(), resultingList.size());
	}

	@Test
	public void testGeneratedListContainingFizzBuzzOnMultiplesOfThree() {
		Integer counter = 1;
		for (String s : resultingList) {
			if (isMultipleOfThreeButNotFifteenAndDoesNotContainThree(counter)) {
				assertEquals(MSG_MULTIPLE_OF_THREE, s);
			}
			counter++;
		}
	}

	@Test
	public void testGeneratedListContainingFizzBuzzOnMultiplesOfFive() {
		Integer counter = 1;
		for (String s : resultingList) {
			if (isMultipleOfFiveButNotFifteenAndDoesNotContainThree(counter)) {
				assertEquals(MSG_MULTIPLE_OF_FIVE, s);
			}
			counter++;
		}
	}

	@Test
	public void testGeneratedListContainingFizzBuzzOnMultiplesOfFiftheen() {
		Integer counter = 1;
		for (String s : resultingList) {
			if (isMultipleOfFiftheen(counter)) {
				assertEquals(MSG_MULTIPLE_OF_FIFTHEEN, s);
			}
			counter++;
		}
	}

	@Test
	public void testGeneratedListContainingFizzBuzzOnNumbersHavingThree() {
		Integer counter = 1;
		for (String s : resultingList) {
			if (isNumberContainsThree(counter)) {
				assertEquals(MSG_NUMBER_CONTAINING_THREE, s);
			}
			counter++;
		}
	}

	@Test
	public void testGeneratedListContainingFizzBuzzOnNumbers() {
		Integer counter = 1;
		for (String s : resultingList) {
			if (!isANumber(counter)) {
				assertEquals(String.valueOf(counter), s);
			}
			counter++;
		}
	}

	@Test
	public void testGeneratedFizzBuzzStringStepThree() {
		assertEquals(buildResultStringStepThree(), resultingString);
	}

	private String buildResultStringStepThree() {
		return RESULT_STRING_STEP_THREE.concat(RESULT_STRING_STEP_THREE_1)
				.concat(RESULT_STRING_STEP_THREE_2)
				.concat(RESULT_STRING_STEP_THREE_3)
				.concat(RESULT_STRING_STEP_THREE_4)
				.concat(RESULT_STRING_STEP_THREE_5);
	}

	private boolean isMultipleOfFive(Integer counter) {
		return counter % 5 == 0;
	}

	private boolean isMultipleOfThree(Integer counter) {
		return counter % 3 == 0;
	}

	private boolean isMultipleOfFiftheen(Integer counter) {
		return isMultipleOfThree(counter) && isMultipleOfFive(counter);
	}

	private boolean isNumberContainsThree(Integer counter) {
		return counter.toString().contains(THREE);
	}

	private boolean isMultipleOfFiveButNotFifteenAndDoesNotContainThree(
			Integer counter) {
		return isMultipleOfFive(counter) && !isMultipleOfThree(counter)
				&& !isNumberContainsThree(counter);
	}

	private boolean isMultipleOfThreeButNotFifteenAndDoesNotContainThree(
			Integer counter) {
		return isMultipleOfThree(counter) && !isMultipleOfFive(counter)
				&& !isNumberContainsThree(counter);
	}

	private boolean isANumber(Integer counter) {
		return isMultipleOfThree(counter) || isMultipleOfFive(counter)
				|| isMultipleOfFiftheen(counter)
				|| isNumberContainsThree(counter);
	}

}
