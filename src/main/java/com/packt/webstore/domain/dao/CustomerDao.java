package com.packt.webstore.domain.dao;

import com.packt.webstore.domain.entity.CustomerEntity;
import com.packt.webstore.domain.entity2.Customer;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CustomerDao extends CrudRepository<CustomerEntity, Long> {

	List<CustomerEntity> findAll();

	public CustomerEntity findByName(String name);

	public CustomerEntity findById(Integer id);

	public CustomerEntity findById(String customerId);

}