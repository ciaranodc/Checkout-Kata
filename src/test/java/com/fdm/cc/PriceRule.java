package com.fdm.cc;

public class PriceRule {

	char itemName;
	int quantityForDiscount;
	int totalDiscountedPrice;
	
	public PriceRule(char itemName, int quantityForDiscount, int totalDiscountedPrice) {
		this.itemName = itemName;
		this.quantityForDiscount = quantityForDiscount;
		this.totalDiscountedPrice = totalDiscountedPrice;
	}
	
	public char getItemName() {
		return itemName;
	}
	public int getQuantityForDiscount() {
		return quantityForDiscount;
	}
	public int getTotalDiscountedPrice() {
		return totalDiscountedPrice;
	}
	
}
