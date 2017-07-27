package com.vij.vendingmachine.interfaces;

public interface IVendingMachineMoneyManager {
	public void addMoneyToSlot(int slotNumber, int moneyDenomination, int count) throws Exception;

	public int calculateChange(int itemPrice, int moneyAdded) throws Exception;
}
