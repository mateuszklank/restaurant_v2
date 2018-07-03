package com.packt.webstore.domain.repository;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import com.packt.webstore.domain.entity.User;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByLastname(String lastname);



}