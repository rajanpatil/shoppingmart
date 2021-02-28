package com.shoppingmart.service;

import com.shoppingmart.model.Product;
import com.shoppingmart.offer.BuyOneGetOneOffer;
import com.shoppingmart.offer.TwentyPercentDiscountOffer;

public class ProductShelf {

  public static Product getMilk(int quantity) {
    return Product.builder()
        .name("Tesco Semi Skimmed Milk 4 pints")
        .unitPrice(1.10)
        .quantity(quantity)
        .build();
  }

  public static Product getCoffee(int quantity) {
    return Product.builder()
        .name("Nescafe Original Instant Coffee 100 gram")
        .unitPrice(3.0)
        .quantity(quantity)
        .offer(new TwentyPercentDiscountOffer())
        .build();
  }

  public static Product getSugar(int quantity) {
    return Product.builder()
        .name("Granulated Sugar 1Kg")
        .unitPrice(0.65)
        .quantity(quantity)
        .offer(new BuyOneGetOneOffer())
        .build();
  }

}
