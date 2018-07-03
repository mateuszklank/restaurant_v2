package com.packt.webstore.domain.dao;

import com.packt.webstore.domain.entity.User;

public interface UserDao {

    User findByLastname(String lastname);

}
