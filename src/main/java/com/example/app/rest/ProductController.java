package com.example.app.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Product;
import com.example.app.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping(value = "/products",
			produces = {"application/json"}
			)
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> list = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	
	@GetMapping(value = "/products/{id}",produces = {"application/json"})
	public ResponseEntity<Product> getProduct(@PathVariable ("id") int id){
		Product prod = productService.getProduct(id);
		if(prod!=null) {
			return new ResponseEntity<Product>(prod,HttpStatus.OK);
		}
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value = "/products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable ("id") int id){
		boolean flag = productService.deleteProduct(id);
		if(flag) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/products/{id}",
			produces = {"application/json"},
			consumes = {"application/json"} 
			)
	public ResponseEntity<Product> updateProduct(@PathVariable ("id") int id,@RequestBody Product product){
		Product updatedProduct = productService.updateProduct(id,product);
		if(updatedProduct!=null) {
			return new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
		}
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/products",
			produces = {"application/json"},
			consumes = {"application/json"} 
			)
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product prod = productService.addProduct(product);
		return new ResponseEntity<Product>(prod,HttpStatus.CREATED);
	}
	
}
