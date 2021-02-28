package com.shoppingmart.offer;

import com.shoppingmart.model.Product;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class BuyOneGetOneOffer implements Offer {

  @Override
  public double applyOffer(Product product) {
    return getDiscountQuantity(product.getQuantity()) * product.getUnitPrice();
  }

  private int getDiscountQuantity(int quantity) {
    int totalQuantityEligibleForOffer = quantity - (quantity % 2);
    return totalQuantityEligibleForOffer / 2;
  }

}
