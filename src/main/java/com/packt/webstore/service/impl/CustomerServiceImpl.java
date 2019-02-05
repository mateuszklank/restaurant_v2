package com.packt.webstore.service.impl;

import com.packt.webstore.domain.dao.CustomerDao;
import com.packt.webstore.domain.entity.CustomerEntity;
import com.packt.webstore.domain.entity2.Customer;
import com.packt.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<CustomerEntity> findAll() {
        return customerDao.findAll();
    }

    /*
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }
    */
}