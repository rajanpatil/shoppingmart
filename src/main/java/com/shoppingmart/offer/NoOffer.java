package com.shoppingmart.offer;

import com.shoppingmart.model.Product;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class NoOffer implements Offer {

  @Override
  public double applyOffer(Product product) {
    return 0.0;
  }
}
