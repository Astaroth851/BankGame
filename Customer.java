package com.aca.Bank;

import java.math.BigDecimal;

public class Customer {

	private String firstName;
	private String lastName;
	private int customerPin;
	private BigDecimal savings;


	Customer(String firstName, String lastName, int customerPin, BigDecimal savings) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerPin = customerPin;
		this.savings = savings;
		
	}

	public BigDecimal deposit(BigDecimal depositAmmount) {
		savings = depositAmmount.add(savings);
		return savings;
	}
	
	public BigDecimal withdraw(BigDecimal withdawAmmount) {
		savings = savings.subtract(withdawAmmount);
		return savings;
	}
	
	
	public int getCustomerPin() {
		return customerPin;
	}

	public BigDecimal getSavings() {
		return savings;
	}

	public String getfullName() {
		String fullName = firstName + " " + lastName;
		return fullName;
		
	}
	
	public String toString() {
		return firstName + " " + lastName + ", Pin Number: " + customerPin + ", Savings:  " + savings;
		
	}




}
