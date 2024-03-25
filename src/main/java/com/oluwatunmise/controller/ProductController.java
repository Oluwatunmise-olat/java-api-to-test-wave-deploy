package com.oluwatunmise.controller;

import com.oluwatunmise.models.Product;
import com.oluwatunmise.service.ProductServiceImpl;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
  @Autowired
  private Environment environment;

  @Autowired
  private ProductServiceImpl productService;

  @GetMapping("/{id}")
  public ResponseEntity getProductById(@PathVariable String id) {
    Optional<Product> product = productService.getProductById(id);
    if (product.isPresent()) {
      return ResponseEntity.ok(product.get());
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("RECORD NOT FOUND");
    }
  }

  @GetMapping("")
  public ArrayList<Product> getAllProducts() {
    System.out.println(environment.getProperty("APP_NAME"));
    System.out.println("Updates Made");
    return productService.getAllProducts();
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Product addProduct(@RequestBody Product product) {
    return productService.saveProduct(product);
  }
}
