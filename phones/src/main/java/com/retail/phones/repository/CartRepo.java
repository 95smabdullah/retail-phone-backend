package com.retail.phones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.phones.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{
	List<Cart> findAllByUserId(int userId);
	void deleteByProdId(int prodId);
	void deleteAllByUserId(int userId);

}
