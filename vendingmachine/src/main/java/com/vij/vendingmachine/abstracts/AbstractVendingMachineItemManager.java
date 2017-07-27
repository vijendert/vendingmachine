package com.vij.vendingmachine.abstracts;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.vij.vendingmachine.interfaces.IProduct;
import com.vij.vendingmachine.interfaces.IVendingMachineItemManager;
import com.vij.vendingmachine.model.Slot;

public abstract class AbstractVendingMachineItemManager implements IVendingMachineItemManager {

	protected int rows;
	protected int columns;
	protected int slotSize;
	protected Map<String, Queue<IProduct>> productHolder;
	protected Map<String, Slot> slotTransaction;

	public AbstractVendingMachineItemManager(int rows, int columns, int slotSize) {
		this.rows = rows;
		this.columns = columns;
		this.slotSize = slotSize;
		init();
	}

	protected void init() {
		slotTransaction = new HashMap<String, Slot>();
		productHolder = new HashMap<String, Queue<IProduct>>();
		String key = "";
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				key = Integer.toString(i).concat(Integer.toString(j));
				Queue<IProduct> queue = new LinkedList<IProduct>();
				productHolder.put(key, queue);
				slotTransaction.put(key, new Slot());
			}
		}

	}

}
