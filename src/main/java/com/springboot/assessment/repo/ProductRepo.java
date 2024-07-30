package com.springboot.assessment.repo;

import java.util.List;

import com.springboot.assessment.model.Products;


public interface ProductRepo 
{
	public void save(Products product);
	
	public List<Products> findAllProducts();
	
	public Products findById(int pid);
	
	public void update(Products product);
	
	public void delete(int pid);
}
