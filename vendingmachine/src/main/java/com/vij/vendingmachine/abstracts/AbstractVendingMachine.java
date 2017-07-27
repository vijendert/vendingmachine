package com.vij.vendingmachine.abstracts;

import com.vij.vendingmachine.VendingMachineItemManager;
import com.vij.vendingmachine.VendingMachineMoneyManager;
import com.vij.vendingmachine.interfaces.IProduct;
import com.vij.vendingmachine.interfaces.IVendingMachine;
import com.vij.vendingmachine.interfaces.IVendingMachineItemManager;
import com.vij.vendingmachine.interfaces.IVendingMachineMoneyManager;

public abstract class AbstractVendingMachine implements IVendingMachine {

	protected IVendingMachineItemManager vmItemManager;
	protected IVendingMachineMoneyManager vmMoneyManager;
	private int noOfRows;
	private int noOfColumns;
	private int slotSize;
	private int noOfCurrencySlots;
	private int currencySlotSize;

	public AbstractVendingMachine(int rows, int columns, int slotSize, int noOfCurrencySlots, int currencySlotSize) {
		this.noOfRows = rows;
		this.noOfColumns = columns;
		this.slotSize = slotSize;
		this.noOfCurrencySlots = noOfCurrencySlots;
		this.currencySlotSize = currencySlotSize;
		this.vmItemManager = new VendingMachineItemManager(rows, columns, slotSize);
		this.vmMoneyManager = new VendingMachineMoneyManager(noOfCurrencySlots, currencySlotSize);
	}

	public IVendingMachineItemManager getVmItemManager() {
		return vmItemManager;
	}

	public void setVmItemManager(IVendingMachineItemManager vmItemManager) {
		this.vmItemManager = vmItemManager;
	}

	public IVendingMachineMoneyManager getVmMoneyManager() {
		return vmMoneyManager;
	}

	public void setVmMoneyManager(IVendingMachineMoneyManager vmMoneyManager) {
		this.vmMoneyManager = vmMoneyManager;
	}

	abstract protected IProduct dispenseItem(String rowCol);

	abstract protected int dispenseChange(int change);

	abstract protected String releaseBOM();

}
