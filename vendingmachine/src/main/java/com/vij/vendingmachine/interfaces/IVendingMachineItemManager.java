package com.vij.vendingmachine.interfaces;

/**
 * This interface for Vending machine item manager. Here we have a concept of
 * slot. Slot is the queue of the item We have price of the whole slot not an
 * individual item
 * 
 * @author root
 *
 */
public interface IVendingMachineItemManager {
	public void addItemAtSlot(IProduct item, String slot) throws Exception;

	public void addItemInAllSlots(IProduct item) throws Exception;

	public IProduct getItemFromTheSlot(String slot) throws Exception;

	public IProduct removeItemFromSlot(String slot) throws Exception;

	public void updatePriceOfSlot(String slot, int price) throws Exception;

	public void updatePriceOfAllSlots(int price);

	public String reportSale();

}
