package com.packt.webstore.service;

import java.util.List;
import com.packt.webstore.domain.entity.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomers();
	
}