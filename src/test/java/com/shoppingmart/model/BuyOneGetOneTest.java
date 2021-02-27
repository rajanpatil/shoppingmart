package com.shoppingmart.model;

import junit.framework.Assert;
import org.junit.Test;

public class BuyOneGetOneTest {

  @Test
  public void testApplyOffer() {
    Product product = new Product();
    product.setDescription("desc");
    product.setName("Name");
    product.setQuantity(2);
    product.setUnitPrice(122);

    BuyOneGetOne buyOneGetOne = new BuyOneGetOne();
    buyOneGetOne.applyOffer(product);

    Assert.assertEquals(product.getQuantity(), 1);
  }

}
