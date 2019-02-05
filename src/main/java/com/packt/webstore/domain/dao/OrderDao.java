package com.packt.webstore.domain.dao;

import javax.transaction.Transactional;

import com.packt.webstore.domain.entity.OrderEntity;
import com.packt.webstore.domain.entity2.Order;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface OrderDao extends CrudRepository<OrderEntity, Integer> {

//    public Order findByStreet(String street);

}