package com.vij.vendingmachine.interfaces;

import java.util.Date;

public interface IProduct {

	public void setPrice(int price);

	public int getPrice();

	public void setManufacturingDate(Date manufacturingDate);

	public Date getManufacturingDate();

	public void setExpiryDate(Date manufacturingDate);

	public Date getExpiryDate();

	public void setProductId(String id);

	public String getProductId();

}
