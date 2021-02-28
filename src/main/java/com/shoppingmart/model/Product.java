package com.shoppingmart.model;

import com.shoppingmart.offer.NoOffer;
import com.shoppingmart.offer.Offer;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Product {

  private String name;
  private int quantity;
  private double unitPrice;
  private Offer offer;

  public Product(String name, int quantity, double unitPrice, Offer offer) {
    this.name = name;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
    this.offer = offer != null ? offer : new NoOffer();
  }

  public double getPrice() {
    return unitPrice * quantity;
  }

  public double getDiscountPrice() {
    return offer.applyOffer(this);
  }

  public double getTotalPrice() {
    return getPrice() - getDiscountPrice();
  }
}
