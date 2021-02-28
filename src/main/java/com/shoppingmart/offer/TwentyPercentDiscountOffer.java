package com.shoppingmart.offer;

import com.shoppingmart.model.Product;

public class TwentyPercentDiscountOffer implements Offer {

  @Override
  public double applyOffer(Product product) {
    return (product.getUnitPrice() * product.getQuantity()) / 5;
  }
}
