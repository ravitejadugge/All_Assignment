package com.service;

import com.Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(int id);
}
