package com.packt.webstore.domain.dao;

import com.packt.webstore.domain.entity.CartEntity;
import com.packt.webstore.domain.entity2.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartDao extends CrudRepository<CartEntity, Integer> {



}