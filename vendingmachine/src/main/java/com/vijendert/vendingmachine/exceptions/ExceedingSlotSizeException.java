package com.vijendert.vendingmachine.exceptions;

public class ExceedingSlotSizeException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceedingSlotSizeException(String msg) {
		super(msg);
	}
}
