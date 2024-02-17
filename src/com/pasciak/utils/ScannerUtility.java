
package com.pasciak.utils;

import java.util.Scanner;

public class ScannerUtility {

	@SuppressWarnings("unchecked")
	public <T extends Comparable<T>> T getInput(String prompt, T min, T max, Scanner scanner) {

		// TODO - adjust the String version to allow for a minimum/max length, instead
		// of, or in addition to the lexicographic ordering

		boolean shouldTryAgain = false;

		T validUserInput = null;

		Class<?> clazz = min.getClass(); // Get the class of the input type

		System.out.println(clazz);

		do {

			System.out.print(prompt);

			String userInputString = scanner.nextLine();

			// TODO: Re factor the use of cast to eliminate the unchecked warning
			// TODO: Re factor to prevent rounding/conversion/loss of precision

			try {
				if (clazz.equals(Integer.class)) {
					System.out.println("Integer");
					validUserInput = (T) (Integer) Integer.parseInt(userInputString);
				} else if (clazz.equals(Float.class)) {
					System.out.println("Float");
					validUserInput = (T) (Float) Float.parseFloat(userInputString);
				} else if (clazz.equals(Double.class)) {
					System.out.println("Double");
					validUserInput = (T) (Double) Double.parseDouble(userInputString);
				} else if (clazz.equals(String.class)) {
					System.out.println("String");
					validUserInput = (T) userInputString;
				} else {
					System.out.println("Unsupported input type");
				}

			} catch (NumberFormatException numberFormatException) {

				// System.out.println(numberFormatException);

				shouldTryAgain = true;

			} catch (Exception exception) {

				// System.out.println(exception);

				shouldTryAgain = true;

			} finally {

				// System.out.println("Finally...");

				// Always executes

			}

			if (validUserInput != null) {
				if (validUserInput.compareTo(min) >= 0 && validUserInput.compareTo(max) <= 0) {
					shouldTryAgain = false;
				} else {
					shouldTryAgain = true;
				}
			}

		} while (shouldTryAgain);

		return validUserInput;
	}

	/*
	 * This can serve as a test of the GetInputUtility class
	 */
	public static void main(String[] args) {

		ScannerUtility giu = new ScannerUtility();

		Scanner scanner = new Scanner(System.in);

		int minInt = -(Integer.MAX_VALUE);
		int maxInt = Integer.MAX_VALUE;

		System.out.println(minInt);
		System.out.println(maxInt);

		int choice = giu.getInput("Enter your int: ", minInt, maxInt, scanner);
		System.out.println(choice);
		System.out.println("\n".repeat(3));

		double minDouble = -(Double.MAX_VALUE);
		double maxDouble = Double.MAX_VALUE;

		System.out.println(minDouble);
		System.out.println(maxDouble);

		double doubleChoice = giu.getInput("Enter your double: ", minDouble, maxDouble, scanner);
		System.out.println(doubleChoice);
		System.out.println("\n".repeat(3));

		String minString = "";
		String maxString = "\uffff".repeat(4095);

		String stringChoice = giu.getInput("Enter your String: ", minString, maxString, scanner);
		System.out.println(stringChoice);
		System.out.println("\n".repeat(3));

		float floatMin = -(Float.MAX_VALUE);
		float floatMax = Float.MAX_VALUE;

		System.out.println(floatMin);
		System.out.println(floatMax);

		float floatChoice = giu.getInput("Enter your float: ", floatMin, floatMax, scanner);
		System.out.println(floatChoice);
		System.out.println("\n".repeat(3));

		try {
			boolean booleanNotSupported = giu.getInput("Enter a bool!", false, true, scanner);
			System.out.println(booleanNotSupported);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("\n".repeat(3));
		}

		scanner.close();

	}

}
