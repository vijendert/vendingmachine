package com.vij.vendingmachine;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Queue;

import com.vij.vendingmachine.abstracts.AbstractVendingMachineItemManager;
import com.vij.vendingmachine.interfaces.IProduct;
import com.vij.vendingmachine.model.Product;
import com.vij.vendingmachine.model.Slot;
import com.vijendert.vendingmachine.exceptions.EmptySlotException;
import com.vijendert.vendingmachine.exceptions.WrongInputException;

public class VendingMachineItemManager extends AbstractVendingMachineItemManager {

	// private static Calendar cal = Calendar.getInstance();

	public VendingMachineItemManager(int rows, int columns, int slotSize) {
		super(rows, columns, slotSize);
	}

	public void addItemAtSlot(IProduct item, String slot) throws WrongInputException {
		if (!productHolder.containsKey(slot))
			throw new WrongInputException("Slot " + slot + " does no exist");
		productHolder.get(slot).add(item);
	}

	public IProduct removeItemFromSlot(String slot) throws WrongInputException, EmptySlotException {
		if (!productHolder.containsKey(slot))
			throw new WrongInputException("Slot " + slot + " does no exist");
		if (productHolder.get(slot).isEmpty())
			throw new EmptySlotException("Slot is Empty");
		IProduct prod = productHolder.get(slot).remove();
		// marking transaction
		Slot slotTransEntry = slotTransaction.get(slot);
		slotTransEntry.setTransaction(prod);
		return prod;
	}

	public void updatePriceOfSlot(String slot, int price) throws WrongInputException {
		if (!productHolder.containsKey(slot))
			throw new WrongInputException("Slot " + slot + " does no exist");
		Queue<IProduct> queue = productHolder.get(slot);
		Iterator<IProduct> it = queue.iterator();
		while (it.hasNext()) {
			IProduct prod = it.next();
			prod.setPrice(price);
		}
	}

	public IProduct getItemFromTheSlot(String slot) throws WrongInputException, EmptySlotException {
		if (!productHolder.containsKey(slot))
			throw new WrongInputException("Slot " + slot + " does no exist");
		if (productHolder.get(slot).isEmpty())
			throw new EmptySlotException("Slot is Empty");
		return productHolder.get(slot).peek();
	}

	public void addItemInAllSlots(IProduct item) throws Exception {
		for (Entry<String, Queue<IProduct>> entry : productHolder.entrySet()) {
			Queue<IProduct> queue = entry.getValue();
			for (int i = 0; i < slotSize; i++) {
				IProduct prod = new Product();
				prod.setPrice(item.getPrice());
				prod.setManufacturingDate(item.getManufacturingDate());
				prod.setExpiryDate(item.getExpiryDate());
				/*
				 * prod.setManufacturingDate(cal.getTime());
				 * cal.add(Calendar.YEAR, 1); prod.setExpiryDate(cal.getTime());
				 */
				queue.add(prod);
			}
		}
	}

	public void updatePriceOfAllSlots(int price) {
		for (Entry<String, Queue<IProduct>> entry : productHolder.entrySet()) {
			String key = entry.getKey();
			try {
				updatePriceOfSlot(key, price);
			} catch (WrongInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public String reportSale() {
		int totalSale = 0;
		int totalVents = 0;
		for (Entry<String, Slot> entry : slotTransaction.entrySet()) {
			totalSale += entry.getValue().getTotalCostAccountedFor();
			totalVents += entry.getValue().getTotalSuccessfullVents();
		}
		return "Till date earning : " + Integer.toString(totalSale) + ", and total Items Sold : "
				+ (Integer.toString(totalVents));
	}

}
