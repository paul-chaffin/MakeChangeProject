package com.skilldistillery.makechange;

import java.util.Scanner;

public class CashRegister {

	public static double amountSale = 0, amountTendered = 0, bulkChange = 0;
	public static int prettyCoins, prettyBills;
	public static int billsTen = 0, billsFive = 0, billsOne = 0;
	public static int coinsQ = 0, coinsD = 0, coinsN = 0, coinsP = 0;

	public static void main(String[] args) {

		makeChange();

	}

	public static void makeChange() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the purchase cost:  > ");
		amountSale = kb.nextDouble();
		kb.nextLine();
		System.out.print("Enter the payment amount: > ");
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
			prettyChange();
			getBills(bulkChange);
			printFinalBills();
			printFinalCoins();
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
		changeCoins = (changeCoins % 10) + .001;
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

	public static void prettyChange() {
		prettyBills = (int) bulkChange;
		double modCoins = bulkChange % 1 + .001;
//		System.out.println("modCoins" + modCoins);
		prettyCoins = (int) (modCoins * 100);
//		System.out.println("pC: " + prettyCoins);
		System.out.println();
		System.out.print("Change due: $" + prettyBills + ".");
		if (prettyCoins % 10 == prettyCoins) {
			System.out.printf("0%s", prettyCoins);
			System.out.println();
		} else {
			System.out.println(prettyCoins);
		}
		System.out.println("------------------");
		System.out.println();

	}

	public static void printFinalBills() {
		if (billsTen + billsFive + billsOne < 1) {
			System.out.print("");
		} else {
			System.out.println("Bills:");

			if (billsTen > 0) {
				System.out.println("\t$10: " + billsTen);
			}
			if (billsFive > 0) {
				System.out.println("\t$5:  " + billsFive);
			}
			if (billsOne > 0) {
				System.out.println("\t$1:  " + billsOne);
			}
		}
	}

	public static void printFinalCoins() {
		if (billsTen + billsFive + billsOne < 1) {
			System.out.print("");
		} else {
			System.out.println("Coins:");
			if (coinsQ > 0) {
				System.out.println("\t25c: " + coinsQ);
			}
			if (coinsD > 0) {
				System.out.println("\t10c: " + coinsD);
			}
			if (coinsN > 0) {
				System.out.println("\t5c:  " + coinsN);
			}
			if (coinsP > 0) {
				System.out.println("\t1c:  " + coinsP);
			}
		}
	}

}
