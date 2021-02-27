package com.shoppingmart.model;

public class FiftyPercentDiscount extends Offer {

	@Override
	public void applyOffer(Product product) {
		product.setUnitPrice(product.getUnitPrice()/2);
	}

}
