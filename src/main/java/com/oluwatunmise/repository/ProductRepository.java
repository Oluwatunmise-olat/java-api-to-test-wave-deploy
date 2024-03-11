package com.oluwatunmise.repository;

import com.oluwatunmise.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepository {
  ArrayList<Product> allProducts = new ArrayList<>();
  public Optional<Product> getProductById (String productId) {
    return allProducts.stream().filter(product -> product.getId() == productId).findFirst();
  }

  public ArrayList<Product> getAllProducts() {
    return allProducts;
  }

  public Product saveProduct (Product product) {
    product.setId(UUID.randomUUID().toString());
    allProducts.add(product);
    return product;
  }
}
