package com.springboot.assessment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.assessment.model.Products;
import com.springboot.assessment.repo.ProductRepo;

@Service
public class ProductServiceImplementation implements ProductService
{
	ProductRepo repo;
	public ProductServiceImplementation(ProductRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addProduct(Products product) 
	{
		repo.save(product);
		return "Product Added";
	}

	@Override
	public List<Products> getAllProducts() 
	{
		return repo.findAllProducts();
	}

	@Override
	public Products getProduct(int pid) 
	{
		return repo.findById(pid);
	}

	@Override
	public String updateProduct(Products product) 
	{
		repo.update(product);
		return "Product Updated";
	}

	@Override
	public String deleteProduct(int pid) 
	{
		repo.delete(pid);
		return "Product Deleted";
	}
}
