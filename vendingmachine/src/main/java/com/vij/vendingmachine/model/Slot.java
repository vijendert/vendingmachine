package com.vij.vendingmachine.model;

import com.vij.vendingmachine.interfaces.IProduct;

import lombok.Data;

@Data
public class Slot {
	private int price;
	private int totalSuccessfullVents;
	private int totalCostAccountedFor;

	public void setTransaction(IProduct prod) {
		// TODO Auto-generated method stub
		totalCostAccountedFor += prod.getPrice();
		totalSuccessfullVents++;
	}
}
