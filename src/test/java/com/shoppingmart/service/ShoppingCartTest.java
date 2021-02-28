package com.shoppingmart.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.shoppingmart.model.Product;
import com.shoppingmart.offer.BuyOneGetOneOffer;
import com.shoppingmart.offer.TwentyPercentDiscountOffer;
import org.junit.Test;

public class ShoppingCartTest {

  @Test
  public void testAddProductToShoppingCart() {
    // given
    Product milkProduct = Product.builder()
        .name("Tesco Semi Skimmed Milk 4 pints")
        .unitPrice(1.10)
        .quantity(1)
        .build();
    ShoppingCart cart = new ShoppingCart();

    // when
    cart.addProduct(milkProduct);

    // then
    assertTrue(cart.getProducts().contains(milkProduct));
  }

  @Test
  public void testRemoveProductFronShoppingCart() {
    // given
    Product milkProduct = Product.builder()
        .name("Tesco Semi Skimmed Milk 4 pints")
        .unitPrice(1.10)
        .quantity(1)
        .build();
    ShoppingCart cart = new ShoppingCart();
    cart.addProduct(milkProduct);

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
    Product milkProduct = Product.builder()
        .name("Tesco Semi Skimmed Milk 4 pints")
        .unitPrice(1.10)
        .quantity(1)
        .build();
    cart.addProduct(milkProduct);

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
    Product milkProduct = Product.builder()
        .name("Tesco Semi Skimmed Milk 4 pints")
        .unitPrice(1.10)
        .quantity(1)
        .build();
    Product coffeeProduct = Product.builder()
        .name("Nescafe Original Instant Coffee 100 gram")
        .unitPrice(3.00)
        .quantity(1)
        .offer(new TwentyPercentDiscountOffer())
        .build();

    cart.addProduct(milkProduct);
    cart.addProduct(coffeeProduct);

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
    Product milkProduct = Product.builder()
        .name("Tesco Semi Skimmed Milk 4 pints")
        .unitPrice(1.10)
        .quantity(1)
        .build();
    Product coffeeProduct = Product.builder()
        .name("Nescafe Original Instant Coffee 100 gram")
        .unitPrice(3.00)
        .quantity(1)
        .offer(new TwentyPercentDiscountOffer())
        .build();
    Product sugarProduct = Product.builder()
        .name("Granulated Sugar 1Kg")
        .unitPrice(0.65)
        .quantity(2)
        .offer(new BuyOneGetOneOffer())
        .build();

    cart.addProduct(milkProduct);
    cart.addProduct(coffeeProduct);
    cart.addProduct(sugarProduct);

    // when
    double totalShoppingPrice = cart.checkout();

    // then
    assertEquals(expectedTotalShoppingPrice, totalShoppingPrice, 0.00);
  }
}
