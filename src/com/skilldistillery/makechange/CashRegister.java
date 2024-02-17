package com.skilldistillery.makechange;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CashRegister {

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
		 * Amount: any amount less than 20.00, Tendered: anything greater than amount:
		 * correct denominations for correct change.
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

		showWelcomeMessage();

		try {

			String purchasePrice = "";
			String amountTendered = "";

			System.out.print("Enter the purchase price of the item: ");
			purchasePrice = keyboard.nextLine();

			System.out.print("Enter the amount tendered by the customer: ");
			amountTendered = keyboard.nextLine();

			String changeGenerated = makeChange(purchasePrice, amountTendered);
			System.out.println(changeGenerated);

		} catch (Exception e) {

			System.out.println("\n\nInvalid input, or something went wrong.\n\n");
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("\n\n");

		} finally {

			// testCases();

		}

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

		String changeGenerated = "";

		changeGenerated = makeChange(".67", ".50");
		System.out.println(changeGenerated);

		changeGenerated = makeChange(".67", "1.00");
		System.out.println(changeGenerated);

		changeGenerated = makeChange(".59", "1.00");
		System.out.println(changeGenerated);

		changeGenerated = makeChange("3.96", "20.00");
		System.out.println(changeGenerated);

		changeGenerated = makeChange(".67", ".50");
		System.out.println(changeGenerated);

		changeGenerated = makeChange("0.7235", "000.7200006");
		System.out.println(changeGenerated);

		for (int i = 1; i <= 3; i++) {
			String randomCost = Math.random() * 20 + "";
			String randomTendered = Math.random() * 100 + 20 + "";
			changeGenerated = makeChange(randomCost, randomTendered);
			System.out.println(changeGenerated);
		}

	}

	/*
	 * This method is used to round the double to the specified number of decimal //
	 * Stack Overflow resource reference:
	 * https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-
	 * places
	 */
	public static double round(double value, int places) {
		if (places < 0) {
			throw new IllegalArgumentException();
		}
		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public static void showWelcomeMessage() {
		System.out.println("------------------------------");
		System.out.println("Welcome to the Cash Register!");
		System.out.println("------------------------------");
	}

	/*
	 * This method is used to calculate the change and return the result as a string
	 */
	public static String makeChange(String price, String tendered) {

		double doubleAmountTendered = round(Double.parseDouble(tendered), 2);
		double doublePurchasePrice = round(Double.parseDouble(price), 2);

		// NOTE: Reconsider this extra rounding, probably not necessary
		double doubleChange = round(round((doubleAmountTendered - doublePurchasePrice), 2), 2);

		System.out.println("------------------------------");
		System.out.printf("Amount Tendered:    %10.2f\n", doubleAmountTendered);
		System.out.printf("Purchase Price:     %10.2f\n", doublePurchasePrice);
		System.out.println("------------------------------");
		System.out.printf("Change:             %10.2f\n\n", doubleChange);

		// NOTE: The idea of entering negative amounts is not realistic
		if (doubleAmountTendered < 0.00) {
			return "Invalid amount tendered!";
		}

		// NOTE: The idea of entering negative amounts is not realistic
		if (doublePurchasePrice < 0.00) {
			return "Invalid purchase price!";
		}

		// User Story #3 : Display an appropriate message if the customer provided too
		// little money or the exact amount.

		if (doubleAmountTendered < doublePurchasePrice) {
			return "Not enough money!";
		} else if (doubleAmountTendered == doublePurchasePrice) {
			return "Exact amount tendered!";
		}

		int twentiesNeeded = 0;
		int tensNeeded = 0;
		int fivesNeeded = 0;
		int onesNeeded = 0;
		int quartersNeeded = 0;
		int dimesNeeded = 0;
		int nickelsNeeded = 0;
		int penniesNeeded = 0;

		while (round(doubleChange, 2) >= round(20.0, 2)) { // These additional round call might not be necessary
			twentiesNeeded++;
			doubleChange -= 20.0;
		}

		while (round(doubleChange, 2) >= round(10.0, 2)) {
			tensNeeded++;
			doubleChange -= 10.0;
		}

		while (round(doubleChange, 2) >= round(5.0, 2)) {
			fivesNeeded++;
			doubleChange -= 5.0;
		}

		while (round(doubleChange, 2) >= round(1.0, 2)) {
			onesNeeded++;
			doubleChange -= 1.0;
		}

		while (round(doubleChange, 2) >= round(0.25, 2)) {
			quartersNeeded++;
			doubleChange -= 0.25;
		}

		while (round(doubleChange, 2) >= round(0.10, 2)) {
			dimesNeeded++;
			doubleChange -= 0.10;
		}

		while (round(doubleChange, 2) >= round(0.05, 2)) {
			nickelsNeeded++;
			doubleChange -= 0.05;
		}

		while (round(doubleChange, 2) >= round(0.01, 2)) {
			penniesNeeded++;
			doubleChange -= round(0.01, 2);
		}

		String outputStringResult = "";

		// NOTE: The following implementation is not the most efficient way to build the
		// string result, It is the most readable way to build the string result.

		// The most efficient way to build the string result would be to use a
		// StringBuilder

		// NOTE: This was the first implementation of the string result and has be
		// re factored below.

		// This code is kept here (and not - commented) for readability and to
		// demonstrate the progress, lessons learned and the re factoring process.

		if (twentiesNeeded > 0) {
			outputStringResult += twentiesNeeded + " "
					+ (twentiesNeeded > 1 ? "Twenty dollar bills" : "Twenty dollar bill");
		}
		if (tensNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += tensNeeded + " " + (tensNeeded > 1 ? "Ten dollar bills" : "Ten dollar bill");
		}
		if (fivesNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += fivesNeeded + " " + (fivesNeeded > 1 ? "Five dollar bills" : "Five dollar bill");
		}
		if (onesNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += onesNeeded + " " + (onesNeeded > 1 ? "One dollar bills" : "One dollar bill");
		}
		if (quartersNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += quartersNeeded + " " + (quartersNeeded > 1 ? "Quarters" : "Quarter");
		}
		if (dimesNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += dimesNeeded + " " + (dimesNeeded > 1 ? "Dimes" : "Dime");
		}
		if (nickelsNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += nickelsNeeded + " " + (nickelsNeeded > 1 ? "Nickels" : "Nickel");
		}
		if (penniesNeeded > 0) {
			if (outputStringResult.length() > 0) {
				outputStringResult += ", ";
			}
			outputStringResult += penniesNeeded + " " + (penniesNeeded > 1 ? "Pennies" : "Penny");
		}

		if (outputStringResult.length() > 0) {
			outputStringResult += ".";
		}

		// Using a string builder to build the string result is as follows:

		// The StringBuilder is more efficient than the previous implementation

		// This is due to the fact that the previous implementation uses string
		// concatenation which creates a new string each time it is called

		// The StringBuilder appends the strings to the same object
		// and then converts the StringBuilder to a string

		StringBuilder sb = new StringBuilder();

		if (twentiesNeeded > 0) {
			sb.append(twentiesNeeded + " Twenty dollar bill" + (twentiesNeeded > 1 ? "s" : ""));
		}
		if (tensNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(tensNeeded + " Ten dollar bill" + (tensNeeded > 1 ? "s" : ""));
		}
		if (fivesNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(fivesNeeded + " Five dollar bill" + (fivesNeeded > 1 ? "s" : ""));
		}
		if (onesNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(onesNeeded + " One dollar bill" + (onesNeeded > 1 ? "s" : ""));
		}
		if (quartersNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(quartersNeeded + " Quarter" + (quartersNeeded > 1 ? "s" : ""));
		}
		if (dimesNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(dimesNeeded + " Dime" + (dimesNeeded > 1 ? "s" : ""));
		}
		if (nickelsNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(nickelsNeeded + " Nickel" + (nickelsNeeded > 1 ? "s" : ""));
		}
		if (penniesNeeded > 0) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(penniesNeeded + " " + (penniesNeeded > 1 ? "Pennies" : "Penny"));
		}
		if (sb.length() > 0) {
			sb.append(".");
		}

		return sb.toString(); // Using the result of the StringBuilder

	}

}
