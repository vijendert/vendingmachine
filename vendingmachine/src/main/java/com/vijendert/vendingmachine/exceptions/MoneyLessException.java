package com.vijendert.vendingmachine.exceptions;

public class MoneyLessException extends Exception {
	public MoneyLessException(String msg) {
		super(msg);
	}
}
