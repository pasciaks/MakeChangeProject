package com.skilldistillery.makechange;

import java.util.InputMismatchException;
import java.util.Scanner;

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

public class CashRegisterApp {

	public static void displayWelcomeMessage() {
		System.out.println("------------------------------------------------------------------");
		System.out.println("Welcome to the Cash Register App!");
		System.out.println("------------------------------------------------------------------");
		System.out.println("This app will calculate the change due to the customer.");
		System.out.println("This is self-learning, the HW to grade is the file MakeChange.java");
		System.out.println("------------------------------------------------------------------");
	}

	public static void displayGoodbyeMessage() {
		System.out.println("------------------------------------------------------------------");
		System.out.println("Thank you for using the Cash Register App!");
		System.out.println("Goodbye!");
		System.out.println("------------------------------------------------------------------");
	}

	public static void main(String[] args) {

		CashRegister cashRegister = new CashRegister(0.0, 0.0);

		Scanner keyboard = new Scanner(System.in);

		displayWelcomeMessage();

		boolean validPurchasePrice = false;

		do {
			double tempPurchasePrice = 0.0;
			validPurchasePrice = false;
			try {
				System.out.print("Enter the purchase price of the item: ");
				tempPurchasePrice = keyboard.nextDouble();
				keyboard.nextLine();
				if (tempPurchasePrice < 0) {
					System.out.println("Invalid purchase price. Please enter a valid purchase price.");
				} else {
					validPurchasePrice = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid value!");
				// https://stackoverflow.com/questions/3572160/how-to-handle-infinite-loop-caused-by-invalid-input-inputmismatchexception-usi
				keyboard.next(); // this consumes the invalid token
			} catch (Exception e) {
				System.out.println("Invalid purchase price. Please enter a valid purchase price.");
			}
			cashRegister.setPurchasePrice(tempPurchasePrice);
		} while (!validPurchasePrice);

		boolean validAmountTendered = false;

		do {
			double tempAmountTendered = 0.0;
			validAmountTendered = false;
			try {
				System.out.print("Enter the amount tendered: ");
				tempAmountTendered = keyboard.nextDouble();
				keyboard.nextLine();
				if (tempAmountTendered < 0) {
					System.out.println("Invalid amount tendered. Please enter a valid amount tendered.");
				} else {
					validAmountTendered = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid value!");
				// https://stackoverflow.com/questions/3572160/how-to-handle-infinite-loop-caused-by-invalid-input-inputmismatchexception-usi
				keyboard.next(); // this consumes the invalid token
			} catch (Exception e) {
				System.out.println("Invalid amount tendered. Please enter a valid amount tendered.");
			}
			cashRegister.setAmountTendered(tempAmountTendered);
		} while (!validAmountTendered);

		cashRegister.calculateChange();

		displayGoodbyeMessage();

		keyboard.close();

	}

}
