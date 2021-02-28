package com.shoppingmart.offer;

import com.shoppingmart.model.Product;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class TwentyPercentDiscountOffer implements Offer {

  @Override
  public double applyOffer(Product product) {
    return (product.getUnitPrice() * product.getQuantity()) / 5;
  }
}
