package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.model.Product;
import com.example.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public Product getProduct(int id) {
		if(productRepository.existsById(id)) {
			return productRepository.findById(id).get();
		}
		return null;
	}
	@Override
	public boolean deleteProduct(int id) {
		if(productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		}
		return false;		
	}
	@Override
	public Product updateProduct(int id,Product product) {
		if(productRepository.existsById(id)) {
			product.setProductId(id);
			return productRepository.save(product);
		}
		return null;
	}
	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
}
