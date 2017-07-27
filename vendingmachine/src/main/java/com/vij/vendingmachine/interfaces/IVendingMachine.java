package com.vij.vendingmachine.interfaces;

public interface IVendingMachine {
	public void selectItem(String rowCol);

	public void inputMoney(int money);

	abstract IProduct dispenseItem();

	abstract int dispenseChange();

	abstract String releaseBOM();
}
