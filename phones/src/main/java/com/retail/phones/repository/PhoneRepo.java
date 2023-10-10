package com.retail.phones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.phones.entity.Phone;

public interface PhoneRepo extends JpaRepository<Phone, Integer>{

}
