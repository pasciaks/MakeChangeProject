package com.skilldistillery.makechange;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * 
 * Sheldon Pasciak
 * 
 * For this homework assignment, please grade the MakeChange.java file.
 * 
 * This CashRegister class and additional code is for self-study and practice.
 * 
 * Slowly, I am working to understand the concepts of object-oriented programming.
 * 
 * I was exposed to OOP a long time ago, and self learned a bit of JAVA almost 10 years ago.
 * 
 * I am now working to understand it more deeply. (It's coming back to me!)
 */

public class CashRegister {

	private double purchasePrice = 0.0;
	private double amountTendered = 0.0;

	/*
	 * Constructors are used to initialize the object’s state.
	 * 
	 * Constructors should always be public.
	 * 
	 * Constructors are declared without any return ype.
	 */
	public CashRegister(double purchasePrice, double amountTendered) {
		this.purchasePrice = purchasePrice;
		this.amountTendered = amountTendered;
	}

	protected double getPurchasePrice() {
		return purchasePrice;
	}

	protected void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	protected double getAmountTendered() {
		return amountTendered;
	}

	protected void setAmountTendered(double amountTendered) {
		this.amountTendered = amountTendered;
	}

	public double round(double value, int places) {
		if (places < 0) {
			throw new IllegalArgumentException();
		}
		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	protected void calculateChange() {

		double doublePurchasePrice = round(getPurchasePrice(), 2);

		double doubleAmountTendered = round(getAmountTendered(), 2);

		double doubleChange = (doubleAmountTendered - doublePurchasePrice);

		doubleChange = round(doubleChange, 2);

		makeChange(doublePurchasePrice, doubleAmountTendered, doubleChange);
	}

	/*
	 * This method is used to calculate the change and return the result as a string
	 */
	public static void makeChange(double doublePurchasePrice, double doubleAmountTendered, double doubleChange) {

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
