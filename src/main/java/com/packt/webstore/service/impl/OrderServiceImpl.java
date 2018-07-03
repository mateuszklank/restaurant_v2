package com.packt.webstore.service.impl;

import com.packt.webstore.domain.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.webstore.domain.entity.Product;
import com.packt.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private ProductDao productDao;
	
	public void processOrder(String productId, int count) {
		Product productById = productDao.getProductById(productId);
//		if(productById.getUnitsInStock() < count) {
//			throw new IllegalArgumentException("To danie nie jest dostępne w takiej ilości. Pozostało: " + productById.getUnitsInStock());
//		}
//		productById.setUnitsInStock(productById.getUnitsInStock() - count);
	}
	
}