package com.shoppingmart.model;

import java.util.ArrayList;
import java.util.List;

public class Product {

  private String name;
  private String description;
  private int quantity;
  private double unitPrice;
  private List<Offer> offerList;


  public Product() {

  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }


  public void addOffer(Offer offer) {
    if (null == offerList) {
      offerList = new ArrayList<>();
    }
    offerList.add(offer);
  }

  public List<Offer> getOfferList() {
    return offerList;
  }


}
