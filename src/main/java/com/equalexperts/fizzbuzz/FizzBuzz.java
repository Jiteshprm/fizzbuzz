package com.equalexperts.fizzbuzz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** sdd
 * Fizz buzz is a program that prints to the console a string for a contiguous
 * range of numbers, replacing some of them based on these set of rules:
 * <ul>
 * <li>'fizz' for numbers that are multiples of 3</li>
 * <li>'buzz' for numbers that are multiples of 5</li>
 * <li>'fizzbuzz' for numbers that are multiples of 15</li>
 * <li>the number itself otherwise</li>
 * </ul>
 * 
 * @author jitesh
 *
 */
public class FizzBuzz {

	private static final String REPORT_SPACE = " ";
	private static final String REPORT_KEY_SEPARATOR = ": ";
	private static final String MSG_MULTIPLE_OF_FIVE = "buzz";
	private static final String MSG_MULTIPLE_OF_THREE = "fizz";
	private static final String MSG_MULTIPLE_OF_FIFTHEEN = "fizzbuzz";
	private static final String MSG_NUMBER_CONTAINING_THREE = "lucky";
	private static final String MSG_INTEGER = "integer";
	private static final String THREE = "3";
	private List<String> listWithFizzBuzz = null;
	private Map<String, Integer> mapWithWordCount = null;

	private Integer range = 0;

	public FizzBuzz() {
		super();
		this.listWithFizzBuzz = new ArrayList<String>();
		mapWithWordCount = new HashMap<String, Integer>();
	}

	public FizzBuzz(Integer range) {
		super();
		if (range < 0) {
			throw new RuntimeException("Range can only be a positive number");
		}
		this.range = range;
		this.listWithFizzBuzz = new ArrayList<String>();
		mapWithWordCount = new HashMap<String, Integer>();
	}

	/**
	 * Method that returns a list where each position hold the number or word
	 * according to the FizzBuzz rules
	 * 
	 * @return The list collection,
	 */
	public List<String> generateList() {
		for (int i = 1; i < range + 1; i++) {
			listWithFizzBuzz.add(generateFizzBuzzElementBasedOnRules(i));
		}
		return listWithFizzBuzz;
	}

	/**
	 * Method that returns a fully formed FizzBuzz string, by first generating
	 * the list with all the elements and then arranging them properly in the
	 * string, as specified
	 * 
	 * @return The FizzBuzz string
	 */
	public String generateString() {
		StringBuilder resultingString = new StringBuilder();
		if (listWithFizzBuzz.isEmpty()) {
			generateList();
		}

		if (listWithFizzBuzz.size() > 0) {
			resultingString.append(printFizzBuzzLine());
			resultingString.append(printCountMapKey(MSG_MULTIPLE_OF_THREE));
			resultingString.append(printCountMapKey(MSG_MULTIPLE_OF_FIVE));
			resultingString.append(printCountMapKey(MSG_MULTIPLE_OF_FIFTHEEN));
			resultingString
					.append(printCountMapKey(MSG_NUMBER_CONTAINING_THREE));
			resultingString.append(printCountMapKey(MSG_INTEGER));
		}

		return resultingString.toString().trim();
	}

	private String generateFizzBuzzElementBasedOnRules(int i) {

		if (isMultipleOfThreeButNotFifteenAndDoesNotContainThree(i)) {
			updateWordCountMap(MSG_MULTIPLE_OF_THREE);
			return MSG_MULTIPLE_OF_THREE;
		} else if (isMultipleOfFiveButNotFifteenAndDoesNotContainThree(i)) {
			updateWordCountMap(MSG_MULTIPLE_OF_FIVE);
			return MSG_MULTIPLE_OF_FIVE;
		} else if (isMultipleOfFiftheenAndDoesNotContainThree(i)) {
			updateWordCountMap(MSG_MULTIPLE_OF_FIFTHEEN);
			return MSG_MULTIPLE_OF_FIFTHEEN;
		} else if (isNumberContainsThree(i)) {
			updateWordCountMap(MSG_NUMBER_CONTAINING_THREE);
			return MSG_NUMBER_CONTAINING_THREE;
		} else {
			updateWordCountMap(MSG_INTEGER);
			return String.valueOf(i);
		}
	}

	private void updateWordCountMap(String updatedMap) {
		Integer currentCount = mapWithWordCount.get(updatedMap);
		if (currentCount == null) {
			currentCount = 0;
		}
		mapWithWordCount.put(updatedMap, ++currentCount);

	}

	private String printFizzBuzzLine() {
		StringBuilder fizzBuzzLine = new StringBuilder();
		for (String s : listWithFizzBuzz) {
			fizzBuzzLine.append(s);
			fizzBuzzLine.append(REPORT_SPACE);
		}
		fizzBuzzLine.setLength(fizzBuzzLine.length() - 1);
		fizzBuzzLine.append(System.lineSeparator());
		return fizzBuzzLine.toString();
	}

	private String printCountMapKey(String keyToPrint) {
		StringBuilder countLineString = new StringBuilder();
		countLineString.append(keyToPrint);
		countLineString.append(REPORT_KEY_SEPARATOR);
		countLineString.append(mapWithWordCount.get(keyToPrint).toString());
		countLineString.append(System.lineSeparator());
		return countLineString.toString();
	}

	private boolean isMultipleOfFive(Integer counter) {
		return counter % 5 == 0;
	}

	private boolean isMultipleOfThree(Integer counter) {
		return counter % 3 == 0;
	}

	private boolean isMultipleOfFiftheenAndDoesNotContainThree(Integer counter) {
		return isMultipleOfThree(counter) && isMultipleOfFive(counter)
				&& !isNumberContainsThree(counter);
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

}
