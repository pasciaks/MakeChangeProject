package com.skilldistillery.makechange;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {

		/*
		 * Overview: In the cash register we will calculate the amount of change
		 * returned to a customer based on the purchase price and the amount tendered.
		 * 
		 * We will also notify the attendant how many of each type of currency
		 * 
		 * ($20 ,$10 ,$5, $1, .25c, .10c, .05c, .01c) is needed to make the change for
		 * the customer.
		 * 
		 * Change will be provided using a combination of the largest bill and coin
		 * denominations as possible.
		 * 
		 * Denominations that are not used will not be displayed.
		 * 
		 * Hint: Mod operator
		 * 
		 */

		/*
		 * User Story #1
		 * 
		 * The user is prompted asking for the price of the item.
		 * 
		 * User Story #2
		 * 
		 * The user is then prompted asking how much money was tendered by the customer.
		 * 
		 * User Story #3
		 * 
		 * Display an appropriate message if the customer provided too little money or
		 * the exact amount.
		 * 
		 * User Story #4
		 * 
		 * If the amount tendered is more than the cost of the item, display the number
		 * of bills and coins that should be given to the customer. Denominations that
		 * are not used will not be displayed.
		 * 
		 */

		/*
		 * Grading
		 * 
		 * This is a graded project. You are to have your project completed and pushed
		 * to Git by 0830 on Monday morning.
		 * 
		 * If the code:
		 * 
		 * meets all stated requirements by the due date, you will receive 1 point.
		 * 
		 * meets most of the stated requirements by the due date, you may receive .5
		 * point.
		 * 
		 * does not meet the stated requirements by the due date, you may receive 0
		 * points.
		 * 
		 */

		/*
		 * Here are example test conditions:
		 * 
		 * Amount: .67, Tendered: .50, Result: Error message
		 * 
		 * Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
		 * 
		 * Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
		 * 
		 * Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill,
		 * 1 one dollar bill, 4 pennies.
		 * 
		 * Amount: any amount less than 20.00,
		 * 
		 * Tendered: anything greater than amount
		 * 
		 * Result: correct denominations for correct change.
		 * 
		 */

		/*
		 * If the project receives 0 points, re submission for potential partial credit
		 * may, at the discretion of the instructor, be granted. Ignored assignments are
		 * given 0 points with no possibility for re submission.
		 * 
		 * To turn in a project, you must push it to a GitHub repository named
		 * MakeChangeProject. You must include a README.md describing how to run your
		 * program.
		 * 
		 */

		// Additional requirements for attention to detail:

		// Formatting the output
		// Pluralizing the denominations
		// Ending with period
		// Don't display non-used denominations
		// Off by 1 penny error

		Scanner keyboard = new Scanner(System.in);

		System.out.println("------------------------------");
		System.out.println("Welcome to the Cash Register!");
		System.out.println("------------------------------");

		try {

			double purchasePrice = 0.0;
			double amountTendered = 0.0;

			System.out.print("Enter the purchase price of the item: ");
			purchasePrice = keyboard.nextDouble();

			System.out.print("Enter the amount tendered by the customer: ");
			amountTendered = keyboard.nextDouble();

			makeChange(purchasePrice, amountTendered);

		} catch (Exception e) {

			System.out.println("\n\nInvalid input, or something went wrong.\n");

			System.out.println("Possible error: " + e.getClass() + "\n");
			System.out.println("Possible error: " + e.getMessage() + "\n");

		} finally {

			System.out.println("-----------------------------------------------------------------");
			System.out.print("Would you like to run some test cases? (Y/N) ? ");
			String runTestCases = keyboard.next();

			if (runTestCases.equalsIgnoreCase("Y")) {
				testCases();
				extraTestCases();
			}

		}

		System.out.println("-----------------------------------------------------------------");
		System.out.println("Thank you for trying this Make Change program!");

		keyboard.close();
	}

	public static void testCases() {

		/*
		 * Here are example test conditions:
		 * 
		 * Amount: .67, Tendered: .50, Result: Error message
		 * 
		 * Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
		 * 
		 * Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
		 * 
		 * Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill,
		 * 1 one dollar bill, 4 pennies.
		 * 
		 * Amount: any amount less than 20.00, Tendered: anything greater than amount
		 * 
		 * Result: correct denominations for correct change.
		 * 
		 */

		makeChange(.67, .50);
		makeChange(.67, 1.00);
		makeChange(.59, 1.00);
		makeChange(3.96, 20.00);
		makeChange(19.67, 19.85);
		makeChange(.72, .72);

	}

	public static void extraTestCases() {

		Random r = new Random();

		int rangeMin = 0;
		int rangeMax = Integer.MAX_VALUE;

		for (int i = 1; i <= 3; i++) {
			double randomPrice = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
			double randomValue = -10 + (20 - -10) * r.nextDouble();
			double randomTendered = randomPrice + randomValue;
			double priceTest = randomPrice;
			double tenderedTest = randomTendered;
			makeChange(priceTest, tenderedTest);
		}

		makeChange(0.7235, 000.720_000_6);

		// Test all the possible values from 0.00 to 20.00
		// (note, round had to be used to compare for max 20.00)
		for (double i = 0.00; round(i, 2) <= round(20.00, 2); i += 0.01) {
			makeChange(i, 20.00);
		}

	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/*
	 * This method is used to calculate the change and return the result as a string
	 */
	public static void makeChange(double doublePurchasePrice, double doubleAmountTendered) {

		doublePurchasePrice = round(doublePurchasePrice, 2);

		doubleAmountTendered = round(doubleAmountTendered, 2);

		double doubleChange = (doubleAmountTendered - doublePurchasePrice);

		doubleChange = round(doubleChange, 2);

		System.out.println("-----------------------------------------------------------------");
		System.out.printf("Amount Tendered:    %30.2f\n", doubleAmountTendered);
		System.out.printf("Purchase Price:     %30.2f\n", doublePurchasePrice);
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("Change:             %30.2f\n\n", doubleChange);

		// NOTE: The idea of entering 0 or negative amounts is not realistic
		if (doubleAmountTendered <= 0.00) {
			System.out.println("Invalid amount tendered! (Must be greater than 0) " + doubleAmountTendered);
			return;
		}

		// NOTE: The idea of entering 0 or negative amounts is not realistic
		if (doublePurchasePrice <= 0.00) {
			System.out.println("Invalid purchase price! (Must be greater than 0) " + doublePurchasePrice);
			return;
		}

		// User Story #3 : Display an appropriate message if the customer provided too
		// little money or the exact amount.

		if (doubleAmountTendered < doublePurchasePrice) {
			System.out.println("Not enough money!");
			return;
		} else if (doubleAmountTendered == doublePurchasePrice) {
			System.out.println("Exact amount tendered!");
			return;
		}

		displayChange(doubleChange);

	}

	public static void displayChange(double doubleChange) {

		long changeNeeded = (long) Math.round(doubleChange * 100); // Convert to cents, to avoid floating point errors

		// NOTE: STRIPE uses the concept of "cents" to avoid floating point errors

		long twentiesNeeded = 0;
		long tensNeeded = 0;
		long fivesNeeded = 0;
		long onesNeeded = 0;
		long quartersNeeded = 0;
		long dimesNeeded = 0;
		long nickelsNeeded = 0;
		long penniesNeeded = 0;

		twentiesNeeded = changeNeeded / 2000;
		changeNeeded = changeNeeded % 2000;

		tensNeeded = changeNeeded / 1000;
		changeNeeded = changeNeeded % 1000;

		fivesNeeded = changeNeeded / 500;
		changeNeeded = changeNeeded % 500;

		onesNeeded = changeNeeded / 100;
		changeNeeded = changeNeeded % 100;

		quartersNeeded = changeNeeded / 25;
		changeNeeded = changeNeeded % 25;

		dimesNeeded = changeNeeded / 10;
		changeNeeded = changeNeeded % 10;

		nickelsNeeded = changeNeeded / 5;
		changeNeeded = changeNeeded % 5;

		penniesNeeded = changeNeeded;

		displayChangeStringBuilder(twentiesNeeded, tensNeeded, fivesNeeded, onesNeeded, quartersNeeded, dimesNeeded,
				nickelsNeeded, penniesNeeded);

	}

	/*
	 * This method is used to display the change needed as a string using string
	 * concatenation
	 */
	public static void displayChangeString(long twentiesNeeded, long tensNeeded, long fivesNeeded, long onesNeeded,
			long quartersNeeded, long dimesNeeded, long nickelsNeeded, long penniesNeeded) {

		String outputStringResult = "";

		// NOTE: The following implementation is not the most efficient way to build the
		// string result, It is the most readable way to build the string result.

		// The most efficient way to build the string result would be to use a
		// StringBuilder

		// This code is kept here (and not - commented) for readability and to
		// demonstrate the progress, lessons learned and the re factoring process.

		if (twentiesNeeded > 0) {
			outputStringResult += twentiesNeeded + " "
					+ (twentiesNeeded > 1 ? "twenty dollar bills" : "twenty dollar bill");
		}
		if (tensNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += tensNeeded + " " + (tensNeeded > 1 ? "ten dollar bills" : "ten dollar bill");
		}
		if (fivesNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += fivesNeeded + " " + (fivesNeeded > 1 ? "five dollar bills" : "five dollar bill");
		}
		if (onesNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += onesNeeded + " " + (onesNeeded > 1 ? "one dollar bills" : "one dollar bill");
		}
		if (quartersNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += quartersNeeded + " " + (quartersNeeded > 1 ? "quarters" : "quarter");
		}
		if (dimesNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += dimesNeeded + " " + (dimesNeeded > 1 ? "dimes" : "dime");
		}
		if (nickelsNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += nickelsNeeded + " " + (nickelsNeeded > 1 ? "nickels" : "nickel");
		}
		if (penniesNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += penniesNeeded + " " + (penniesNeeded > 1 ? "pennies" : "penny");
		}

		if (outputStringResult.length() > 0) {
			outputStringResult += ".";
		}

		System.out.println(outputStringResult);

	}

	/*
	 * This method is used to display the change needed as a string using the
	 * StringBuilder class
	 */
	public static void displayChangeStringBuilder(long twentiesNeeded, long tensNeeded, long fivesNeeded,
			long onesNeeded, long quartersNeeded, long dimesNeeded, long nickelsNeeded, long penniesNeeded) {

		// The StringBuilder is more efficient than the previous implementation

		// This is due to the fact that the previous implementation uses string
		// concatenation which creates a new string each time it is called

		// The StringBuilder appends the strings to the same object
		// and then converts the StringBuilder to a string

		// I noticed that in some cases, the StringBuilder took longer to complete

		StringBuilder sb = new StringBuilder();

		if (twentiesNeeded > 0) {
			sb.append(twentiesNeeded + " twenty dollar bill" + (twentiesNeeded > 1 ? "s" : ""));
		}
		if (tensNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(tensNeeded + " ten dollar bill" + (tensNeeded > 1 ? "s" : ""));
		}
		if (fivesNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(fivesNeeded + " five dollar bill" + (fivesNeeded > 1 ? "s" : ""));
		}
		if (onesNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(onesNeeded + " one dollar bill" + (onesNeeded > 1 ? "s" : ""));
		}
		if (quartersNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(quartersNeeded + " quarter" + (quartersNeeded > 1 ? "s" : ""));
		}
		if (dimesNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(dimesNeeded + " dime" + (dimesNeeded > 1 ? "s" : ""));
		}
		if (nickelsNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(nickelsNeeded + " nickel" + (nickelsNeeded > 1 ? "s" : ""));
		}
		if (penniesNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(penniesNeeded + " " + (penniesNeeded > 1 ? "pennies" : "penny"));
		}
		if (sb.length() > 0) {
			sb.append(".");
		}

		System.out.println(sb.toString());
	}

}
