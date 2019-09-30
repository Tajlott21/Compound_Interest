package Money;

import java.util.*;
import java.lang.Math;
import java.text.DecimalFormat;

public class compoundInterestCalculator {

	/*
	 * 
	 * Date: 8/30/19 Author: Taj Lott Program Purpose: Creating an application that
	 * will ask 3 questions:
	 * 
	 * 1) How much principal is in the account? 2) What is the Annual Return Rate
	 * APY of the account? 3) What is the investment length?
	 * 
	 * Then show the user how much they would profit if they deposited their money
	 * in a savings account with a corresponding APY or Interest Rate on the console
	 * 
	 * 
	 * Future Updates* - [ ] Create Exception for if the user inserts a comma within
	 * the principal variable  - [ ]
	 * Create Notes for code review - [ ] Handle Exceptions - [ ] Tidy up the UI
	 * (use a table-like format) - [ ] Provide the names of real banks or options
	 * close to the percentage of the APY value
	 * 
	 * 
	 */

	static double principal, APY, a, cI;
	static int compound, investLength, b;
	static DecimalFormat df = new DecimalFormat("####0.00");

	public static void main(String[] args) {

		System.out.println("Welcome to FinanceBoss' Compound Interest Calculator!");
		System.out.println();
		System.out.println();
		Introduction();

	}

	public static void Introduction() {

		Scanner user = new Scanner(System.in);
		System.out.print("How much would you like to deposit: $");
		principal = user.nextDouble(); // Read user input and assign it to principal
		System.out.println();
		System.out.print("What is the Annual Return Rate(%):  ");
		APY = user.nextDouble();
		System.out.println();
		System.out.println("APY = " + APY + " %");

		// turn APY into decimal for calculation
		APY = (APY / 100);
		System.out.println("Decimal APY = " + APY);
		System.out.println();

		System.out.println("How often is it compounded? ");
		System.out.println("Enter 1 for Daily");
		System.out.println("Enter 2 for Weekly");
		System.out.println("Enter 3 for Monthly");
		System.out.println("Enter 4 for Quarterly");
		System.out.println();
		System.out.print("Answer: ");
		compound = user.nextInt();
		System.out.println();

		System.out.print("Last question, How many years would you like to invest: ");
		investLength = user.nextInt();
		System.out.println();

		user.close();
		CompoundInterest(principal, APY, compound, investLength);

	}

	public static void CompoundInterest(double principal, double APY, int compound, int investLength) {

		switch (compound) {
		case 1:

			a = (1 + APY / 365);
			b = 365;

			cI = principal * (Math.pow(a, b));

			InterestCalculator(principal, APY, cI, investLength, a, b);

			break;

		case 2:

			a = (1 + APY / 52);
			b = 52;
			cI = principal * (Math.pow(a, b));

			InterestCalculator(principal, APY, cI, investLength, a, b);

			break;

		case 3:

			a = (1 + APY / 12);
			b = 12;

			cI = principal * (Math.pow(a, b));

			InterestCalculator(principal, APY, cI, investLength, a, b);

			break;

		case 4:

			a = (1 + APY / 4);
			b = 4;

			cI = principal * (Math.pow(a, b));

			InterestCalculator(principal, APY, cI, investLength, a, b);

			break;

		default:
			System.out.println("Incorrect Value. Please Try Again. ");
			Introduction();
		}

	}
	
	public static void InterestCalculator(double principal, double APY, double cI, int investLength, double a, int b) {

		System.out.println("With the following information: ");

		System.out.println();
		System.out.println("Principal Deposit: $" + principal);
		System.out.println("APY: " + (APY * 100) + "%");
		System.out.println("At an investment length of: " + investLength + " Years");
		System.out.println();
		System.out.println("Here is your Profit Table posted below!");
		System.out.println();

		for (int i = 0; i < (investLength + 1); i++) {

			double futureValue = principal * (Math.pow(a, (b * i)));
			double profit = futureValue - principal;

			System.out.println(
					// \t is the command shortcut to inputing a tab
					"Year " + i + " = " + (df.format(futureValue)) + "\t\t\tProfit = " + (df.format(profit)));
		}

		Recommence();

	}

	private static void Recommence() {

		Scanner sc = new Scanner(System.in);
		System.out.println("What would you like to do next: ");
		System.out.println("Enter 1 to restart application \nEnter 2 to exit "); // \n is the key shortcut to starting a
																					// new line
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			Introduction();

			break;

		case 2:

			System.out.println(
					"Thank you for using the FinanceBoss' Compound Interest Calculator! Till we meet again...");

			sc.close();

			System.exit(0);

		default:

			System.out.println("Invalid Entry. Please Try Again");

			Recommence();
		}

	}

}
