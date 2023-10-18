package com.retail.phones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.retail.phones.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUserAndPassword(String user, String password);
}