package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	private List<Customer> listOfCustomers = new ArrayList<Customer>();
	
	public InMemoryCustomerRepository() {
		
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