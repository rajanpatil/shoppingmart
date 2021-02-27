package com.shoppingmart.model;

import junit.framework.Assert;
import org.junit.Test;

public class CartTest {

  @Test
  public void testAddProduct() {
    Product product = new Product();
    product.setName("T-Shirt");
    product.setDescription("T-Shirt");
    product.setQuantity(2);

    Cart cart = new Cart();
    cart.addProductToList(product);
    Assert.assertEquals(1, cart.getProductList().size());

  }

}
