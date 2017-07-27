package com.vij.vendingmachine.abstracts;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.vij.vendingmachine.interfaces.IVendingMachineMoneyManager;

public abstract class AbstractVendingMachineMoneyManager implements IVendingMachineMoneyManager {
	protected int noOfCurrencySlots;
	protected int currencySlotSize;
	protected Map<String, Stack<Integer>> changeHolder;

	public AbstractVendingMachineMoneyManager(int noOfCurrencySlots, int currencySlotSize) {
		this.noOfCurrencySlots = noOfCurrencySlots;
		this.currencySlotSize = currencySlotSize;
		this.changeHolder = new HashMap<String, Stack<Integer>>();
		init();
	}

	private void init() {
		for (int i = 1; i <= noOfCurrencySlots; i++) {
			changeHolder.put(Integer.toString(i), new Stack<Integer>());
		}

	}

}
