package com.skilldistillery.makechange;

import java.util.Scanner;

public class CashRegister {

	public static double amount = 0, tendered = 0, bulkChange = 0;
	public static int billsTen = 0, billsFive = 0, billsOne = 0;
	public static int coinsQ = 0, coinsD = 0, coinsN = 0, coinsP = 0;

	public static void main(String[] args) {

//		getAmount();
//		System.out.println(amount);

	}

	public static void getAmount() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the cost: > ");
		amount = kb.nextDouble();
		kb.close();
		getBills(amount);
		printFinalChange();

	}

	public static void getBills(double changeBills) {
		changeBills = (int)(changeBills);
		while (changeBills >= 10.0) {
			billsTen++;
		}
		while (changeBills >= 5.0) {
			billsFive++;
		}
		while (changeBills >= 1.0) {
			billsOne++;
		}
	}

	public static void getCoins(double changeCoins) {
		changeCoins = tendered % 10;
	}
	
	public static void printFinalChange() {
		if (billsTen > 0) {
			System.out.println("Tens: " + billsTen);
		}
		if (billsFive > 0) {
			System.out.println("Fives: " + billsFive);
		}
		if (billsOne > 0) {
			System.out.println("Ones: " + billsOne);
		}
		if (coinsQ > 0) {
			System.out.println("25c: " + coinsQ);
		}
		if (billsOne > 0) {
			System.out.println("10c: " + coinsD);
		}
		if (billsOne > 0) {
			System.out.println("5c: " + coinsN);
		}
		if (billsOne > 0) {
			System.out.println("1c: " + coinsP);
		}
	}
	
	public static v

}
