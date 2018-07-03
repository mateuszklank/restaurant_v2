package com.packt.webstore.domain.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.packt.webstore.domain.dao.CustomerDao;
import com.packt.webstore.domain.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class InMemoryCustomerRepositoryImpl implements CustomerDao {

	private List<Customer> listOfCustomers = new ArrayList<Customer>();
	
	public InMemoryCustomerRepositoryImpl() {
		
		Customer uzytkownik1 = new Customer("1", "Mateusz Klank", "Urzędnicza 7a/70");
		uzytkownik1.setNoOfOrdersMade(20);
		
		Customer uzytkownik2 = new Customer("2", "Anna Kusaj", "Związkowa 7");
		uzytkownik2.setNoOfOrdersMade(10);
		
		Customer uzytkownik3 = new Customer("3", "Jolanta Klank", "Urzędnicza 7a/70");
		uzytkownik3.setNoOfOrdersMade(0);
		
		listOfCustomers.add(uzytkownik1);
		listOfCustomers.add(uzytkownik2);
		listOfCustomers.add(uzytkownik3);
	}
	
	public List<Customer> getAllCustomers() {
		return listOfCustomers;
	}
	
	public Customer getCustomerById(String customerId) {
		Customer customerById = null;
		for(Customer customer : listOfCustomers) {
			if(customer!=null && customer.getCustomerId()!=null && customer.getCustomerId().equals(customerId)) {
				customerById = customer;
				break;
			}
		}
		if(customerById == null) {
			throw new IllegalArgumentException("Brak klienta o wskazanym id: " + customerId);
		}
		return customerById;
	}
	
}