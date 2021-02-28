package com.shoppingmart.offer;

import static org.junit.Assert.assertEquals;

import com.shoppingmart.model.Product;
import org.junit.Test;

public class BuyOneGetOneOfferTest {

  @Test
  public void testApplyOffer() {
    // given
    double expectedDiscountPrice = 6.5;
    Offer bogoOffer = new BuyOneGetOneOffer();
    Product sugarProduct = Product.builder()
        .name("Granulated Sugar 1Kg")
        .unitPrice(0.65)
        .quantity(20)
        .offer(bogoOffer)
        .build();

    // when
    double discountPrice = bogoOffer.applyOffer(sugarProduct);

    // then
    assertEquals(expectedDiscountPrice, discountPrice, 0.00);
  }

}
