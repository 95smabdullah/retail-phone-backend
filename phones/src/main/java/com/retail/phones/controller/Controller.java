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


import com.retail.phones.request.PhoneRequest;
import com.retail.phones.response.PhoneResponse;
import com.retail.phones.service.PhoneServices;

@RestController
@RequestMapping("/retail/phone")
@CrossOrigin
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
	@PutMapping("/update")
	public PhoneResponse update(@RequestBody PhoneRequest phoneRequest,@PathVariable int id) {
		return ps.update(phoneRequest, id);
	}
	@DeleteMapping("/delete")
	public void delete(@PathVariable int id) {
		ps.delete(id);
	}
}
