package com.vij.vendingmachine.abstracts;

import java.util.Date;
import java.util.UUID;

import com.vij.vendingmachine.interfaces.IProduct;

public abstract class AbstractProduct implements IProduct {
	protected String productId;
	protected int price;
	protected Date manufacturingDate;
	protected Date expiryDate;

	public AbstractProduct() {
		productId = UUID.randomUUID().toString();
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ProductId: " + this.productId + ", price: " + this.price;
	}

}
