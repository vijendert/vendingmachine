package com.vij.vendingmachine;

import com.vij.vendingmachine.abstracts.AbstractVendingMachineMoneyManager;
import com.vijendert.vendingmachine.exceptions.WrongInputException;

public class VendingMachineMoneyManager extends AbstractVendingMachineMoneyManager {

	int[] availableDenominations = { 1, 2, 5, 10, 50, 100, 500, 2000 };

	public VendingMachineMoneyManager(int noOfCurrencySlots, int currencySlotSize) {
		super(noOfCurrencySlots, currencySlotSize);
	}

	// leaving it too late
	public void addMoneyToSlot(int slotNumber, int moneyDenomination, int count) throws WrongInputException {
		if (!changeHolder.containsKey(slotNumber)) {
			throw new WrongInputException("Slot " + slotNumber + " does no exist");
		}

	}

	public int calculateChange(int itemPrice, int moneyAdded) {
		return moneyAdded - itemPrice;
		// TODO Auto-generated method stub

	}

}
