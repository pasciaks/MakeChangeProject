package com.pasciak.utils;

import com.pasciak.models.Change;

public class ChangeFunctions {

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

		String exampleResult = displayChangeStringBuilder(1, 1, 1, 1, 1, 1, 1, 1);
		System.out.println(exampleResult);

		Change change = new Change(1, 1, 1, 1, 1, 1, 1, 1);
		System.out.println(displayChangeFromObjectProperties(change));

	}

}
