package com.vij.vendingmachine.interfaces;

public interface ISupplier {
	public IVendingMachineItemManager getVmItemManager();

	public void setVmItemManager(IVendingMachineItemManager vmItemManager);

	public IVendingMachineMoneyManager getVmMoneyManager();

	public void setVmMoneyManager(IVendingMachineMoneyManager vmMoneyManager);

}
