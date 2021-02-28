package com.shoppingmart.service;

import com.shoppingmart.model.Product;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ShoppingCart {

  private Set<Product> products = new HashSet<>();

  public void add(Product product) {
    products.add(product);
  }

  public Set<Product> getProducts() {
    return Set.copyOf(products);
  }

  public void remove(Product product) {
    products.remove(product);
  }

  public double checkout() {
    return products.stream().mapToDouble(Product::getTotalPrice).sum();
  }
}
