package com.shoppingmart.model;

import junit.framework.Assert;
import org.junit.Test;

public class FiftyPercentDiscountTest {

  @Test
  public void test() {
    Product product = new Product();
    product.setDescription("desc");
    product.setName("Name");
    product.setQuantity(2);
    product.setUnitPrice(122);

    Offer discount = new FiftyPercentDiscount();
    discount.applyOffer(product);
    Assert.assertTrue(product.getUnitPrice() == 61);
  }

}
