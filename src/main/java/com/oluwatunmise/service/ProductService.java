package com.oluwatunmise.service;

import com.oluwatunmise.models.Product;

import java.util.ArrayList;
import java.util.Optional;

public interface ProductService {
  Optional<Product> getProductById(String id);
  ArrayList<Product> getAllProducts();
  Product saveProduct(Product product);
  void updateProduct(Product product);
  void deleteProduct(Long id);
}
