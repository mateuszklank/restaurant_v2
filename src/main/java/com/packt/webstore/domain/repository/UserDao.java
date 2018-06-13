package com.packt.webstore.domain.repository;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import com.packt.webstore.domain.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {
	
	public User findByLastname(String lastname);

}