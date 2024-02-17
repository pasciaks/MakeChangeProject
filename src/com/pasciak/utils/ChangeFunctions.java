package com.pasciak.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.pasciak.models.Change;

public class ChangeFunctions {

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/*
	 * This method is used to display the change needed as a string using the
	 * StringBuilder class
	 */
	public static String displayChangeStringBuilder(long twentiesNeeded, long tensNeeded, long fivesNeeded,
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

		return sb.toString();
	}

	public static String displayChangeFromObjectProperties(Change change) {
		return displayChangeStringBuilder(change.getTwentiesNeeded(), change.getTensNeeded(), change.getFivesNeeded(),
				change.getOnesNeeded(), change.getQuartersNeeded(), change.getDimesNeeded(), change.getNickelsNeeded(),
				change.getPenniesNeeded());
	}

	public static void main(String[] args) {

		// StringBuilder implementation using parameters

		String exampleResult = displayChangeStringBuilder(1, 1, 1, 1, 1, 1, 1, 1);
		System.out.println(exampleResult);

		// StringBuilder implementation using object properties

		Change change = new Change(1, 1, 1, 1, 1, 1, 1, 1);
		System.out.println(displayChangeFromObjectProperties(change));

		String toStringResult = change.toString();
		System.out.println(toStringResult);

		for (int i = 1; i <= 10; i++) {

			long randomTwenties = (long) (Math.random() * 2);
			long randomTens = (long) (Math.random() * 2);
			long randomFives = (long) (Math.random() * 2);
			long randomOnes = (long) (Math.random() * 2);
			long randomQuarters = (long) (Math.random() * 2);
			long randomDimes = (long) (Math.random() * 2);
			long randomNickels = (long) (Math.random() * 2);
			long randomPennies = (long) (Math.random() * 2);

			System.out.println("\n".repeat(2));

			change = new Change(randomTwenties, randomTens, randomFives, randomOnes, randomQuarters, randomDimes,
					randomNickels, randomPennies);

			System.out.println(displayChangeFromObjectProperties(change));

			toStringResult = change.toString();
			System.out.println(toStringResult);

			double getValueResult = change.getTotal();
			System.out.printf("%30s$%.2f", "", round(getValueResult, 2));

			System.out.println("\n".repeat(2));

		}

	}

}
