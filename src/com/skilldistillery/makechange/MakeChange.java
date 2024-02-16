package com.skilldistillery.makechange;

public class MakeChange {

//	MORE TO DO HERE, RE-READ AND FINISH NICELY!

//	MORE TO DO HERE, RE-READ AND FINISH NICELY!

//	MORE TO DO HERE, RE-READ AND FINISH NICELY!

//	MORE TO DO HERE, RE-READ AND FINISH NICELY!

//	MORE TO DO HERE, RE-READ AND FINISH NICELY!

//	MORE TO DO HERE, RE-READ AND FINISH NICELY!

	/*
	 * Make Change (Cash Register) Overview In the cash register we will calculate
	 * the amount of change returned to a customer based on the purchase price and
	 * the amount tendered. We will also notify the attendant how many of each type
	 * of currency ($20 ,$10 ,$5 ,$1, .25c, .10c, .05c, .01c) is needed to make the
	 * change for the customer.
	 * 
	 * Change will be provided using a combination of the largest bill and coin
	 * denominations as possible.
	 * 
	 * Denominations that are not used will not be displayed.
	 * 
	 * Hint: Mod operator
	 * 
	 * User Story #1 The user is prompted asking for the price of the item.
	 * 
	 * User Story #2 The user is then prompted asking how much money was tendered by
	 * the customer.
	 * 
	 * User Story #3 Display an appropriate message if the customer provided too
	 * little money or the exact amount.
	 * 
	 * User Story #4 If the amount tendered is more than the cost of the item,
	 * display the number of bills and coins that should be given to the customer.
	 * Denominations that are not used will not be displayed.
	 * 
	 * Grading This is a graded project. You are to have your project completed and
	 * pushed to Git by 0830 on Monday morning.
	 * 
	 * If the code:
	 * 
	 * meets all stated requirements by the due date, you will receive 1 point.
	 * meets most of the stated requirements by the due date, you may receive .5
	 * point. does not meet the stated requirements by the due date, you may receive
	 * 0 points. Here are example test conditions:
	 * 
	 * Amount: .67, Tendered: .50, Result: Error message Amount: .67, Tendered:
	 * 1.00, Result: 1 quarter, 1 nickel, 3 pennies. Amount: .59, Tendered: 1.00,
	 * Result: 1 quarter, 1 dime, 1 nickel, 1 penny. Amount: 3.96, Tendered: 20.00,
	 * Result: 1 ten dollar bill, 1 five dollar bill, 1 one dollar bill, 4 pennies.
	 * Amount: any amount less than 20.00, Tendered: anything greater than amount:
	 * correct denominations for correct change. If the project receives 0 points,
	 * resubmission for potential partial credit may, at the discretion of the
	 * instructor, be granted. Ignored assignments are given 0 points with no
	 * possibility for resubmission.
	 * 
	 * To turn in a project, you must push it to a GitHub repository named
	 * MakeChangeProject. You must include a README.md describing how to run your
	 * program.
	 */

	public static void main(String[] args) {

		double num = 3.96;

		double test = num / .10;

		System.out.println(test);

		System.out.println(5 - 3.97);

		printHeader();

		System.out.println(makeChange(.32));
	}

	/*
	 * Refactor printHeader(): Remove its System.out.println statements. Call
	 * buildHeader() and assign its return value to a variable. Output that variable
	 * to the screen.
	 */
	public static void printHeader() {
		String headerText = buildHeader();
		System.out.println(headerText);

	}

	// Create a method called buildHeader that returns a String

	public static String buildHeader() {
		return "/////////////////\n" + "//// BALANCE ////\n" + "/////////////////\n";
	}

	// This method will generate change of a dollar amount by breaking it down into
	// in the forms of $20, $10, $5, $1, .50, .25, .10, .5, .1

	public static String makeChange(double amount) {

		int iHaveThisManyTwenties = 100000;
		int twenty = 0;

		int iHaveThisManyTens = 100000;
		int ten = 0;

		int iHaveThisManyFives = 100000;
		int five = 0;

		int iHaveThisManyOnes = 100000;
		int one = 0;

		int iHaveThisManyHalf = 100000;
		int half = 0;

		int iHaveThisManyQuarters = 100000;
		int quarter = 0;

		int iHaveThisManyDimes = 100000;
		int dime = 0;

		int iHaveThisManyNickels = 100000;
		int nickel = 0;

		int iHaveThisManyPennies = 100000;
		int penny = 0;

		while (amount >= 20 && iHaveThisManyTwenties > 1) {
			twenty++;
			iHaveThisManyTwenties--;
			amount -= 20;
		}
		while (amount >= 10 && iHaveThisManyTens > 1) {
			ten++;
			iHaveThisManyTens--;
			amount -= 10;
		}
		while (amount >= 5 && iHaveThisManyFives > 1) {
			five++;
			iHaveThisManyFives--;
			amount -= 5;
		}
		while (amount >= 1 && iHaveThisManyOnes > 1) {
			one++;
			iHaveThisManyOnes--;
			amount -= 1;
		}
		while (amount >= .5 && iHaveThisManyHalf > 1) {
			half++;
			iHaveThisManyHalf--;
			amount -= .5;
		}
		while (amount >= .25 && iHaveThisManyQuarters > 1) {
			quarter++;
			iHaveThisManyQuarters--;
			amount -= .25;
		}
		while (amount >= .1 && iHaveThisManyDimes > 1) {
			dime++;
			iHaveThisManyDimes--;
			amount -= .1;
		}
		while (amount >= .05 && iHaveThisManyNickels > 1) {
			nickel++;
			iHaveThisManyNickels--;
			amount -= .05;
		}
		while (amount >= .01 && iHaveThisManyPennies > 1) {
			penny++;
			iHaveThisManyPennies--;
			amount -= .01;
		}

		if (amount > 0) {
			System.out.println("Not enough change!");
		}

		return "Twenties: " + twenty + "\nTens: " + ten + "\nFives: " + five + "\nOnes: " + one + "\nHalf: " + half
				+ "\nQuarters: " + quarter + "\nDimes: " + dime + "\nNickels: " + nickel + "\nPennies: " + penny;
	}

}
