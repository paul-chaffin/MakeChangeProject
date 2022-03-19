package com.skilldistillery.makechange;

import java.util.Scanner;

public class CashRegister {

	public static double amountSale = 0, amountTendered = 0, bulkChange = 0;
	public static double prettyCoins, prettyBills;
	public static int billsTen = 0, billsFive = 0, billsOne = 0;
	public static int coinsQ = 0, coinsD = 0, coinsN = 0, coinsP = 0;

	public static void main(String[] args) {

		getAmount();

		printFinalBills();
		printFinalCoins();
	}

	public static void getAmount() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the purchase cost: > ");
		amountSale = kb.nextDouble();
		kb.nextLine();
		System.out.println("Enter your payment amount: > ");
		amountTendered = kb.nextDouble();
		kb.close();
		getPayment();

	}

	public static void getPayment() {
		if (amountTendered < amountSale) {
			System.out.println("Insufficient funds.");
		} else if (amountTendered == amountSale) {
			System.out.println("No change due.");
		} else {
			bulkChange = amountTendered - amountSale;
			prettyBills = (int) bulkChange;
//			System.out.printf("Change due: $%s.%s", prettyBills, prettyCoins);
//			TODO: FIX PRETTY PRINTING
			getBills(bulkChange);
		}
	}

	public static void getBills(double changeBills) {
		while (changeBills >= 10.0) {
			billsTen++;
			changeBills -= 10.0;
		}
		while (changeBills >= 5.0) {
			billsFive++;
			changeBills -= 5.0;
		}
		while (changeBills >= 1.0) {
			billsOne++;
			changeBills -= 1.0;
		}
		getCoins(changeBills);
	}

	public static void getCoins(double changeCoins) {
		changeCoins = (changeCoins % 10);
		formatCoins(changeCoins);
		while (changeCoins >= .25) {
			coinsQ++;
			changeCoins -= .25;
		}
		while (changeCoins >= .10) {
			coinsD++;
			changeCoins -= .10;
		}
		while (changeCoins >= .05) {
			coinsN++;
			changeCoins -= .05;
		}
		while (changeCoins >= .01) {
			coinsP++;
			changeCoins -= .01;
		}
	}

	public static void formatCoins(double uglyCoins) {
		prettyCoins = (int) (uglyCoins * 100);
	}

	public static void printFinalBills() {
		if (billsTen > 0) {
			System.out.println("$10: " + billsTen);
		}
		if (billsFive > 0) {
			System.out.println("$5: " + billsFive);
		}
		if (billsOne > 0) {
			System.out.println("$1: " + billsOne);
		}
	}

	public static void printFinalCoins() {
		if (coinsQ > 0) {
			System.out.println("25c: " + coinsQ);
		}
		if (coinsD > 0) {
			System.out.println("10c: " + coinsD);
		}
		if (coinsN > 0) {
			System.out.println("5c: " + coinsN);
		}
		if (coinsP > 0) {
			System.out.println("1c: " + coinsP);
		}
	}

}
