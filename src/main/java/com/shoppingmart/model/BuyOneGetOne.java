package com.shoppingmart.model;

public class BuyOneGetOne extends Offer {

  @Override
  public void applyOffer(Product product) {
    int productQuantity = product.getQuantity();
    product.setQuantity(productQuantity % 2 == 0 ? productQuantity / 2 : productQuantity / 2 + 1);
  }

}
