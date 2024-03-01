package com.aca.Bank;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankGame {
	
	private Customer[] customers;
	
	public static void main(String[] args) {
		new BankGame().getCustomer();
	}

	private BankGame() {
		
		Customer customer1 = new Customer("Ryan", "Bates", 9274, new BigDecimal("100.00"));
		Customer customer2 = new Customer("John", "Smith", 6441, new BigDecimal("100.00"));

		customers = new Customer[2];
		customers[0] = customer1;
		customers[1] = customer2;
	}
	
	private void displayBalance(Customer currentCustomer) {
		System.out.println("You currently have a balance of $" + currentCustomer.getSavings());
	}

	private void withdraw(Customer currentCustomer) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the amount you would like to withdraw: ");
		BigDecimal amount = scanner.nextBigDecimal();
		currentCustomer.withdraw(amount);
		System.out.println(amount + " has been succesfully withdrawn");
	}

	private void deposit(Customer currentCustomer) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the amount you would like to deposit: ");
		BigDecimal amount = scanner.nextBigDecimal();
		currentCustomer.deposit(amount);
		System.out.println(amount + " has been succesfully deposited");
	}

	private Customer getCustomer() {
		Customer currentCustomer = customers[0];
		boolean invalidCustomer = true;
		boolean bankGameLoop = true;
		boolean bankGame = true;

		do {

			do {
				System.out.println("Please enter your 4-digit pin: ");
				Scanner scanner = new Scanner(System.in);
				int enteredPin = scanner.nextInt();

				for (Customer customer: customers) {
					if (enteredPin == customer.getCustomerPin()) {
						currentCustomer = customer;
						System.out.println("Welcome " + customer.getfullName());
						menu(currentCustomer);
						invalidCustomer = false;
						break;
					} else if(enteredPin == 9999) {
						System.out.println("Bank closing, goodbye!");
						System.exit(0);
					} else {
						bankGameLoop = false;
						invalidCustomer = true;
					}
				}

			} while (bankGameLoop);
			if (invalidCustomer) {
				System.out.println("Invalid pin, plese try again");
			}

		} while (bankGame);

		return currentCustomer;

	}

	private void menu(Customer currentCustomer) {
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		while (option !=4) {
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Display Balance");
			System.out.println("4. Exit");
			option = scanner.nextInt();

			switch (option) {
			case 1:
				deposit(currentCustomer);
				break;
			case 2:
				withdraw(currentCustomer);
			case 3: 
				displayBalance(currentCustomer);
			case 4:
				break;
			default:
				System.out.println("Invalid option. Try again.");
			}

		}

	}
}




	


