package com.vij.vendingmachine.interfaces;

import com.vijendert.vendingmachine.exceptions.MoneyLessException;

public interface IVendingMachine extends ISupplier {
	public void selectItem(String rowCol);

	public void inputMoney(int money) throws MoneyLessException;

}
