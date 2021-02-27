package com.shoppingmart.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  private List<Product> productList;

  public List<Product> getProductList() {
    return productList;
  }

  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

  public void addProductToList(Product product) {
    if (null == productList) {
      productList = new ArrayList();
    }
    productList.add(product);

  }
}
