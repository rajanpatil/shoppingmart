package com.shoppingmart.offer;

import static org.junit.Assert.assertEquals;

import com.shoppingmart.model.Product;
import org.junit.Test;

public class NoOfferTest {

  @Test
  public void testNoOffer() {
    // given
    double expectedDiscountPrice = 0.0;
    Product milkProduct = Product.builder()
        .name("Tesco Semi Skimmed Milk 4 pints")
        .unitPrice(1.10)
        .quantity(1)
        .build();
    Offer noOffer = new NoOffer();

    // when
    double discountPrice = noOffer.applyOffer(milkProduct);

    // then
    assertEquals(expectedDiscountPrice, discountPrice, 0.00);
  }

}