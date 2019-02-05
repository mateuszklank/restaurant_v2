package com.packt.webstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.webstore.domain.entity2.Product;
import com.packt.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
	
	public Product getProductById(String productID) {
		return productDao.getProductById(productID);
	}
	
	public List<Product> getProductsByCategory(String category) {
		return productDao.getProductsByCategory(category);
	}
	
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productDao.getProductsByFilter(filterParams);
	}
	
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}
	
}