package com.shoppingmart.model;

import static org.junit.Assert.assertEquals;

import com.shoppingmart.exception.ShoppingMartException;
import com.shoppingmart.offer.BuyOneGetOneOffer;
import com.shoppingmart.offer.Offer;
import com.shoppingmart.service.ProductShelf;
import org.junit.Test;

public class ProductTest {

  @Test
  public void testCreateTescoMilkProduct() {
    // given
    Product expectedMilkProduct = ProductShelf.getMilk(1);
    Product milkProduct = ProductShelf.getMilk(1);

    // then
    assertEquals(expectedMilkProduct, milkProduct);
  }

  @Test
  public void testCreateProductWithOffer() {
    // given
    Product expectedSugarProduct = ProductShelf.getSugar(1);
    Product sugarProduct = ProductShelf.getSugar(1);

    // then
    assertEquals(expectedSugarProduct, sugarProduct);
  }

  @Test
  public void testVerifyProductOffer() {
    // given
    Offer expectedOffer = new BuyOneGetOneOffer();
    Product sugarProduct = Product.builder()
        .name("Granulated Sugar 1Kg")
        .unitPrice(0.65)
        .quantity(1)
        .offer(new BuyOneGetOneOffer())
        .build();

    // when
    Offer offer = sugarProduct.getOffer();

    // then
    assertEquals(expectedOffer, offer);
  }

  @Test
  public void testProductPrice() {
    // given
    double expectedPrice = 13.0;
    Product sugarProduct = ProductShelf.getSugar(20);

    // when
    double price = sugarProduct.getPrice();

    // then
    assertEquals(expectedPrice, price, 0.00);
  }

  @Test
  public void testProductDiscountPrice() {
    // given
    double expectedDiscountPrice = 0.65;
    Product sugarProduct = ProductShelf.getSugar(2);

    // when
    double discountPrice = sugarProduct.getDiscountPrice();

    // then
    assertEquals(expectedDiscountPrice, discountPrice, 0.00);
  }

  @Test
  public void testDiscountPriceForProductWithNoOffer() {
    // given
    double expectedDiscountPrice = 0.0;
    Product tescoMilkProduct = ProductShelf.getMilk(1);

    // when
    double discountPrice = tescoMilkProduct.getDiscountPrice();

    // then
    assertEquals(expectedDiscountPrice, discountPrice, 0.00);
  }

  @Test
  public void testTotalProductPrice() {
    // given
    double expectedTotalPrice = 24.0;
    Product coffeeProduct = ProductShelf.getCoffee(10);

    // when
    double totalPrice = coffeeProduct.getTotalPrice();

    // then
    assertEquals(expectedTotalPrice, totalPrice, 0.00);
  }

  @Test(expected = ShoppingMartException.class)
  public void testInvalidProductQuantity() {
    Product milkProduct = ProductShelf.getMilk(-2);
  }

}