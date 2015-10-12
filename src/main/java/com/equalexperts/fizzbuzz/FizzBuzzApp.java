package com.equalexperts.fizzbuzz;

/**
 * Main application for FizzBuzz. You should specify the desired range in the
 * command line argument
 * 
 * @author jitesh
 *
 */
public class FizzBuzzApp {
	public static void main(String[] args) {
		Integer range = 0;
		if (args.length > 0) {
			try {
				range = Integer.parseInt(args[0]);
				FizzBuzz fizzbuzz = new FizzBuzz(range);
				System.out.println(fizzbuzz.generateString());
			} catch (NumberFormatException e) {
				System.err.println("Argument" + args[0]
						+ " must be an integer.");
				System.exit(1);
			}
		} else {
			System.out.println("Usage: FizzBuzzApp <RangeOfFizzBuzz>");
		}

	}
}
