package com.shoppingmart.offer;

import static org.junit.Assert.assertEquals;

import com.shoppingmart.model.Product;
import org.junit.Test;

public class TwentyPercentDiscountOfferTest {

  @Test
  public void testTwentyPercentDiscountOffer() {
    // given
    double expectedDiscountPrice = 1.20;
    Offer twentyPercentDiscountOffer = new TwentyPercentDiscountOffer();
    Product coffeeProduct = Product.builder()
        .name("Nescafe Original Instant Coffee 100 gram")
        .unitPrice(3.0)
        .quantity(2)
        .offer(twentyPercentDiscountOffer)
        .build();

    // when
    double discountPrice = twentyPercentDiscountOffer.applyOffer(coffeeProduct);

    // then
    assertEquals(expectedDiscountPrice, discountPrice, 0.00);
  }

}
