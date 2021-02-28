package com.shoppingmart.model;

import static org.junit.Assert.assertEquals;

import com.shoppingmart.offer.BuyOneGetOneOffer;
import com.shoppingmart.offer.Offer;
import com.shoppingmart.offer.TwentyPercentDiscountOffer;
import org.junit.Test;

public class ProductTest {

  @Test
  public void testCreateTescoMilkProduct() {
    // given
    Product expectedTescoMilkProduct = Product.builder()
        .name("Tesco Semi Skimmed Milk 4 pints")
        .unitPrice(1.10)
        .quantity(1)
        .build();
    Product tescoMilkProduct = Product.builder()
        .name("Tesco Semi Skimmed Milk 4 pints")
        .unitPrice(1.10)
        .quantity(1)
        .build();

    // then
    assertEquals(expectedTescoMilkProduct, tescoMilkProduct);
  }

  @Test
  public void testCreateProductWithOffer() {
    // given
    Product expectedSugarProduct = Product.builder()
        .name("Granulated Sugar 1Kg")
        .unitPrice(0.65)
        .quantity(1)
        .offer(new BuyOneGetOneOffer())
        .build();
    Product sugarProduct = Product.builder()
        .name("Granulated Sugar 1Kg")
        .unitPrice(0.65)
        .quantity(1)
        .offer(new BuyOneGetOneOffer())
        .build();

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
    Product sugarProduct = Product.builder()
        .name("Granulated Sugar 1Kg")
        .unitPrice(0.65)
        .quantity(20)
        .offer(new BuyOneGetOneOffer())
        .build();

    // when
    double price = sugarProduct.getPrice();

    // then
    assertEquals(expectedPrice, price, 0.00);
  }

  @Test
  public void testProductDiscountPrice() {
    // given
    double expectedDiscountPrice = 0.65;
    Product sugarProduct = Product.builder()
        .name("Granulated Sugar 1Kg")
        .unitPrice(0.65)
        .quantity(2)
        .offer(new BuyOneGetOneOffer())
        .build();

    // when
    double discountPrice = sugarProduct.getDiscountPrice();

    // then
    assertEquals(expectedDiscountPrice, discountPrice, 0.00);
  }

  @Test
  public void testDiscountPriceForProductWithNoOffer() {
    // given
    double expectedDiscountPrice = 0.0;
    Product tescoMilkProduct = Product.builder()
        .name("Tesco Semi Skimmed Milk 4 pints")
        .unitPrice(1.10)
        .quantity(1)
        .build();

    // when
    double discountPrice = tescoMilkProduct.getDiscountPrice();

    // then
    assertEquals(expectedDiscountPrice, discountPrice, 0.00);
  }

  @Test
  public void testTotalProductPrice() {
    // given
    double expectedTotalPrice = 24.0;
    Product coffeeProduct = Product.builder()
        .name("Nescafe Original Instant Coffee 100 gram")
        .unitPrice(3.00)
        .quantity(10)
        .offer(new TwentyPercentDiscountOffer())
        .build();

    // when
    double totalPrice = coffeeProduct.getTotalPrice();

    // then
    assertEquals(expectedTotalPrice, totalPrice, 0.00);
  }

}