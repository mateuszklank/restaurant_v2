package com.packt.webstore.domain.dao.impl;

import com.packt.webstore.domain.dao.UserDao;
import com.packt.webstore.domain.entity.User;
import com.packt.webstore.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao{

    @Autowired
    UserRepository userRepository;

    public User findByLastname(String lastname){
        return userRepository.findByLastname(lastname);
    };

}
