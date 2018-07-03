package com.packt.webstore.domain.dao;

import com.packt.webstore.domain.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerDao {
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerById(String customerId);
	
}