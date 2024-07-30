package com.springboot.assessment.service;

import java.util.List;

import com.springboot.assessment.model.Products;

public interface ProductService 
{
	public String addProduct(Products product);
	
	public List<Products> getAllProducts();
	
	public Products getProduct(int pid);
	
	public String updateProduct(Products product);
	
	public String deleteProduct(int pid);
}
