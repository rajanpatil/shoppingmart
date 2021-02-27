package com.shoppingmart.model;

public abstract class Offer {

  private String description;

  public Offer() {

  }

  public Offer(String description) {

  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public abstract void applyOffer(Product product);

}
