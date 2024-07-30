package com.springboot.assessment.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.assessment.model.Products;
import com.springboot.assessment.service.ProductServiceImplementation;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:8021")
public class ProductController 
{
	Logger logger = (Logger) LoggerFactory.getLogger(ProductController.class);
	
	ProductServiceImplementation service;

	public ProductController(ProductServiceImplementation service) {
		super();
		this.service = service;
	}
	@PostMapping
	public String insertRequest(@RequestBody Products product) {
		String msg = "";
		try {
			msg = service.addProduct(product);
			logger.trace(product.getPname());
		} catch (Exception e) {
			logger.error(msg);
			msg = "Failer";
		}
		return msg;
	}
	
	@GetMapping("all")
	public List<Products> getProducts() {
		return service.getAllProducts();
	}
	
	@PutMapping
	public String updateRequest(@RequestBody Products product) {
		String msg = "";
		try {
			msg = service.updateProduct(product);
		} catch (Exception e) {
			logger.error(msg);
			msg = "Failer";
		}
		return msg;
	}
	
	@DeleteMapping("{pid}")
	public String deleteProduct(@PathVariable("pid") int pid) {
		String msg="";
		try {
			service.deleteProduct(pid);
			msg="Success";
		}
		catch(Exception e) {	
			msg="Failure";
		}
		return msg;
	}
	
	@GetMapping("{pid}")
	public Products findProductById(@PathVariable("pid") int pid) {
		return service.getProduct(pid);
	}
}
