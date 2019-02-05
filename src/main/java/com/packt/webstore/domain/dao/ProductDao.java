package com.packt.webstore.domain.dao;

import com.packt.webstore.domain.entity2.Product;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Transactional
public interface ProductDao {
//public interface ProductDao extends CrudRepository<Product, String> {
	
	List<Product> getAllProducts();
	
	Product getProductById(String productId);
	
	List<Product> getProductsByCategory(String category);
	
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	void addProduct(Product product);
	
}