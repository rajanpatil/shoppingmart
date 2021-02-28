package com.shoppingmart.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.shoppingmart.model.Product;
import org.junit.Test;

public class ShoppingCartTest {

  @Test
  public void testAddProductToShoppingCart() {
    // given
    Product milkProduct = ProductShelf.getMilk(1);
    ShoppingCart cart = new ShoppingCart();

    // when
    cart.add(milkProduct);

    // then
    assertTrue(cart.getProducts().contains(milkProduct));
  }

  @Test
  public void testRemoveProductFromShoppingCart() {
    // given
    Product milkProduct = ProductShelf.getMilk(1);
    ShoppingCart cart = new ShoppingCart();
    cart.add(milkProduct);

    // when
    cart.remove(milkProduct);

    // then
    assertFalse(cart.getProducts().contains(milkProduct));
  }

  // Story 1
  @Test
  public void testAsACustomerWhenIAddMilkToCartThenTotalShoppingPriceIs1_10() {
    // given
    double expectedTotalShoppingPrice = 1.10;
    ShoppingCart cart = new ShoppingCart();
    Product milkProduct = ProductShelf.getMilk(1);
    cart.add(milkProduct);

    // when
    double totalShoppingPrice = cart.checkout();

    // then
    assertEquals(expectedTotalShoppingPrice, totalShoppingPrice, 0.00);
  }

  // Story 2
  @Test
  public void testAsACustomerWhenIAddMilkAndCoffeeToCartThenTotalShoppingPriceIs3_50() {
    // given
    double expectedTotalShoppingPrice = 3.50;
    ShoppingCart cart = new ShoppingCart();
    Product milkProduct = ProductShelf.getMilk(1);
    Product coffeeProduct = ProductShelf.getCoffee(1);

    cart.add(milkProduct);
    cart.add(coffeeProduct);

    // when
    double totalShoppingPrice = cart.checkout();

    // then
    assertEquals(expectedTotalShoppingPrice, totalShoppingPrice, 0.00);
  }

  // Story 3
  @Test
  public void testAsACustomerWhenIAddMilkAndCoffeeAnd2SugarToCartThenTotalShoppingPriceIs4_15() {
    // given
    double expectedTotalShoppingPrice = 4.15;
    ShoppingCart cart = new ShoppingCart();
    Product milkProduct = ProductShelf.getMilk(1);
    Product coffeeProduct = ProductShelf.getCoffee(1);
    Product sugarProduct = ProductShelf.getSugar(2);

    cart.add(milkProduct);
    cart.add(coffeeProduct);
    cart.add(sugarProduct);

    // when
    double totalShoppingPrice = cart.checkout();

    // then
    assertEquals(expectedTotalShoppingPrice, totalShoppingPrice, 0.00);
  }
}
