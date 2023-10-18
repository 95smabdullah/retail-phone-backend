package com.retail.phones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.phones.repository.UserRepo;
import com.retail.phones.request.CartRequest;
import com.retail.phones.request.PhoneRequest;
import com.retail.phones.request.UserRequest;
import com.retail.phones.response.CartResponse;
import com.retail.phones.response.PhoneResponse;
import com.retail.phones.response.UserResponse;
import com.retail.phones.service.PhoneServices;

@RestController
@RequestMapping("/retail/phone")
@CrossOrigin("http://localhost:4200")
public class Controller {
	
	@Autowired PhoneServices ps;
	
	@PostMapping("/add")
	public PhoneResponse add(@RequestBody PhoneRequest phoneRequest) {
		return ps.add(phoneRequest);
	}
	@GetMapping("/findAll")
	public List<PhoneResponse> findAll(){
		return ps.findAll();
	}
	@PutMapping("/update/{id}")
	public PhoneResponse update(@RequestBody PhoneRequest phoneRequest,@PathVariable int id) {
		return ps.update(phoneRequest, id);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		ps.delete(id);
	}
	@PostMapping("/login")
	public UserResponse login(@RequestBody UserRequest userRequest) {
		return ps.login(userRequest.getUser(), userRequest.getPassword());
	}
	@PostMapping("/register")
	public UserResponse createUser(@RequestBody UserRequest userRequest) {
		return ps.registerUser(userRequest);
	}
	@PostMapping("/addToCart")
	public CartResponse addToCart(@RequestBody CartRequest cartRequest) {
		return ps.addToCart(cartRequest);
	}
	@GetMapping("/seeCart/{userId}")
	public List<PhoneResponse> seeCart(@PathVariable int userId){
		return ps.findAllByUserId(userId);
	}
	@DeleteMapping("/deleteFromCart/{prodId}")
	public void deleteFromCart(@PathVariable int prodId) {
		ps.deleteFromCart(prodId);
	}
	@DeleteMapping("/deleteCart/{userId}")
	public void deleteCart(@PathVariable int userId) {
		ps.deleteCart(userId);
	}
	
}
