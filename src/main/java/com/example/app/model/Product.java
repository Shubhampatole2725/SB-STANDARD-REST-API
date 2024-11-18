package com.example.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private Integer productId;
	
	private String productName;
	
	private Double productPrice;
	
	private String companyName;

	private String category;
	 
	private String productColor;
	

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Product(Integer productId, String productName, Double productPrice, String category, String productColor,
			String companyName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.category = category;
		this.productColor = productColor;
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", category=" + category + ", productColor=" + productColor + ", companyName=" + companyName + "]";
	}
	public Product() {
		
	}
public void m1(){
	System.out.println("m1--Method Added");
}
