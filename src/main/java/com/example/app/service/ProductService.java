package com.example.app.service;

import java.util.List;

import com.example.app.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProduct(int id);

	boolean deleteProduct(int id);

	Product updateProduct(int id, Product product);

	Product addProduct(Product product);

}
