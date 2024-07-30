package com.springboot.assessment.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assessment.model.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductRepoImplementation implements ProductRepo
{

	EntityManager emanager;
	public ProductRepoImplementation(EntityManager emanager) {
		super();
		this.emanager = emanager;
	}

	@Override
	public void save(Products product) 
	{
		emanager.persist(product);
	}

	@Override
	public List<Products> findAllProducts() 
	{
		String hql = "from Products";
		Query query =emanager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Products findById(int pid) 
	{
		return emanager.find(Products.class, pid);
	}

	@Override
	public void update(Products product) 
	{
		emanager.merge(product);
	}

	@Override
	public void delete(int pid) 
	{
		Products product = emanager.find(Products.class, pid);
		emanager.remove(product);
	}

}
