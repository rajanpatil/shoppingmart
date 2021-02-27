package com.shoppingmart.service;

import com.shoppingmart.model.Cart;
import com.shoppingmart.model.Offer;
import com.shoppingmart.model.Product;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingMart {

  public static Map<String, Double> handleCheckout(Cart cart) {
    List<Product> productList = cart.getProductList();
    if (null == productList || productList.isEmpty()) {
      throw new IllegalArgumentException("Product list is empty");
    }
    Map<String, Double> finalCostMap = new HashMap<String, Double>();

    for (Product product : productList) {
      handleOffers(product);
      finalCostMap.put(product.getName(), product.getUnitPrice() * product.getQuantity());
    }
    return finalCostMap;
  }

  private static void handleOffers(Product product) {
    if (product.getOfferList() == null || product.getOfferList().isEmpty()) {
      return;
    }

    for (Offer theOffer : product.getOfferList()) {
      theOffer.applyOffer(product);
    }
  }


}
