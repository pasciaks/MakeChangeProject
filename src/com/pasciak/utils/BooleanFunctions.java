package com.pasciak.utils;

public class BooleanFunctions {

	public static boolean isOdd(int number) {
		return number % 2 != 0;
	}

	public static boolean isEven(int number) {
		return number % 2 == 0;
	}

	public static boolean isPositive(int number) {
		return number > 0;
	}

	public static boolean isNegative(int number) {
		return number < 0;
	}

	public static boolean isZero(int number) {
		return number == 0;
	}

	public static boolean isMultipleOfThree(int number) {
		return number % 3 == 0;
	}

	public static void main(String[] args) {
		System.out.println("The following should all be true:");
		System.out.print("Checking if 3 is odd : ");
		System.out.println(isOdd(3));
		System.out.print("Checking if 2 is even : ");
		System.out.println(isEven(2));
		System.out.print("Checking if 3 is positive : ");
		System.out.println(isPositive(3));
		System.out.print("Checking if -3 is negative : ");
		System.out.println(isNegative(-3));
		System.out.print("Checking if 0 is zero : ");
		System.out.println(isZero(0));
		System.out.print("Checking if 3 is a multiple of 3 : ");
		System.out.println(isMultipleOfThree(3));

		System.out.println("The following should all be false:");
		System.out.print("Checking if 2 is odd : ");
		System.out.println(isOdd(2));
		System.out.print("Checking if 3 is even : ");
		System.out.println(isEven(3));
		System.out.print("Checking if -3 is positive : ");
		System.out.println(isPositive(-3));
		System.out.print("Checking if 3 is negative : ");
		System.out.println(isNegative(3));
		System.out.print("Checking if 3 is zero : ");
		System.out.println(isZero(3));
		System.out.print("Checking if 2 is a multiple of 3 : ");
		System.out.println(isMultipleOfThree(2));
	}

}
