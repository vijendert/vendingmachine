package com.vij.vendingmachine;

import com.vij.vendingmachine.abstracts.AbstractVendingMachine;
import com.vij.vendingmachine.interfaces.IProduct;
import com.vij.vendingmachine.interfaces.IVendingMachine;
import com.vij.vendingmachine.interfaces.IVendingMachineItemManager;
import com.vij.vendingmachine.model.Product;
import com.vijendert.vendingmachine.exceptions.MoneyLessException;

public class VendingMachine extends AbstractVendingMachine {

	private IProduct selectedItem;
	private String selectedRowCol;

	public VendingMachine(int rows, int columns, int slotSize, int noOfCurrencySlots, int currencySlotSize) {
		super(rows, columns, slotSize, noOfCurrencySlots, currencySlotSize);
	}

	public static void main(String[] args) {

		IVendingMachine vm = new VendingMachine(3, 3, 10, 8, 1000);

		IVendingMachineItemManager vmItemManager = vm.getVmItemManager();

		IProduct product = new Product();
		product.setPrice(10);

		try {
			vmItemManager.addItemInAllSlots(product);

			vm.selectItem("11");
			vm.inputMoney(9);

			vm.selectItem("11");
			vm.inputMoney(100);

			vm.selectItem("11");
			vm.inputMoney(100);

			vm.selectItem("11");
			vm.inputMoney(100);

			vm.selectItem("11");
			vm.inputMoney(100);

			vm.selectItem("11");
			vm.inputMoney(100);

			vm.selectItem("11");
			vm.inputMoney(100);

			vm.selectItem("11");
			vm.inputMoney(100);

			vm.selectItem("11");
			vm.inputMoney(100);

			vm.selectItem("11");
			vm.inputMoney(100);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(vmItemManager.reportSale());
	}

	public void selectItem(String rowCol) {
		try {
			selectedItem = vmItemManager.getItemFromTheSlot(rowCol);
			selectedRowCol = rowCol;
			System.out.println(selectedItem);
			System.out.println("Please enter amount : " + selectedItem.getPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inputMoney(int money) throws MoneyLessException {
		int change = 0;
		System.out.println("You entered amount " + money);
		if (money > selectedItem.getPrice()) {
			try {
				change = vmMoneyManager.calculateChange(selectedItem.getPrice(), money);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispenseItem(selectedRowCol);
			dispenseChange(change);
			System.out.println(releaseBOM());
		}
		if (money < selectedItem.getPrice()) {
			throw new MoneyLessException("Money add is " + money + "where required is " + selectedItem.getPrice());
		}

	}

	@Override
	protected IProduct dispenseItem(String rowCol) {
		// TODO Auto-generated method stub
		IProduct prod = null;
		try {
			prod = vmItemManager.removeItemFromSlot(rowCol);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Please collect your item " + prod);
		return prod;
	}

	@Override
	protected int dispenseChange(int change) {
		// TODO Auto-generated method stub
		System.out.println("PLease collect your change " + change);
		return change;
	}

	@Override
	protected String releaseBOM() {
		// TODO Auto-generated method stub
		return "Thank you for your purchase " + selectedItem.toString();
	}

}
