package com.vijendert.vendingmachine.exceptions;

public class WrongInputException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongInputException(String msg) {
		super(msg);
	}
}
