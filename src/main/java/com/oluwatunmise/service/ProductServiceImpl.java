package com.oluwatunmise.service;

import com.oluwatunmise.models.Product;
import com.oluwatunmise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository productRepository;
  @Override
  public Optional<Product> getProductById(String id) {
    return this.productRepository.getProductById(id);
  }

  @Override
  public ArrayList<Product> getAllProducts() {
    return this.productRepository.getAllProducts();
  }

  @Override
  public Product saveProduct(Product product) {
    return this.productRepository.saveProduct(product);
  }

  @Override
  public void updateProduct(Product product) {
  }

  @Override
  public void deleteProduct(Long id) {
  }
}
