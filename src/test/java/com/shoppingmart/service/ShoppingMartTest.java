package com.shoppingmart.service;

import com.shoppingmart.model.BuyOneGetOne;
import com.shoppingmart.model.Cart;
import com.shoppingmart.model.FiftyPercentDiscount;
import com.shoppingmart.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Test;

public class ShoppingMartTest {

  @Test
  public void testCheckoutProduct() {
    List<Product> products = new ArrayList<>();
    Product p1 = new Product();
    p1.setName("T-Shirt");
    p1.setUnitPrice(150.3);
    p1.setDescription("desc");
    p1.setQuantity(2);

    Product p2 = new Product();
    p2.setName("Trouser");
    p2.setUnitPrice(250.3);
    p2.setDescription("desc");
    p2.setQuantity(2);

    p1.addOffer(new BuyOneGetOne());
    p2.addOffer(new FiftyPercentDiscount());

    Cart cart = new Cart();
    cart.addProductToList(p1);
    cart.addProductToList(p2);
    Map<String, Double> finalCostMap = ShoppingMart.handleCheckout(cart);
    Assert.assertEquals(finalCostMap.get("T-Shirt"), 150.3);
    Assert.assertEquals(finalCostMap.get("Trouser"), 250.3);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testCheckoutProductNullList() {
    Cart cart = new Cart();

    ShoppingMart.handleCheckout(cart);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCheckoutProductEmptyList() {
    Cart cart = new Cart();
    cart.setProductList(new ArrayList<Product>());
    ShoppingMart.handleCheckout(cart);
  }
}
