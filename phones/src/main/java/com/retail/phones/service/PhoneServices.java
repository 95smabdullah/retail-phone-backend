package com.retail.phones.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.phones.entity.Cart;
import com.retail.phones.entity.Phone;
import com.retail.phones.entity.User;
import com.retail.phones.repository.CartRepo;
import com.retail.phones.repository.PhoneRepo;
import com.retail.phones.repository.UserRepo;
import com.retail.phones.request.CartRequest;
import com.retail.phones.request.PhoneRequest;
import com.retail.phones.request.UserRequest;
import com.retail.phones.response.CartResponse;
import com.retail.phones.response.PhoneResponse;
import com.retail.phones.response.UserResponse;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PhoneServices {
	@Autowired PhoneRepo pr;
	@Autowired UserRepo ur;
	@Autowired CartRepo cr;
	
	public PhoneResponse add(PhoneRequest phoneRequest) {
		Phone p = new Phone();
		p.setName(phoneRequest.getName());
		p.setDescr(phoneRequest.getDescr());
		p.setPrice(phoneRequest.getPrice());
		p.setDisc(phoneRequest.getDisc());
		p.setImgUrl(phoneRequest.getImgUrl());
		p = pr.save(p);
		return new PhoneResponse(p);
	}
	
	public List<PhoneResponse> findAll(){
		List<Phone> lp = pr.findAll();
		List<PhoneResponse> lpr = new ArrayList<PhoneResponse>();
		for (Phone p : lp) {
			lpr.add(new PhoneResponse(p));
		}
		System.out.println(lpr.toString());
		return lpr;
	}
	
	public PhoneResponse update(PhoneRequest phoneRequest, int id) {
		Phone p = pr.findById(id).get();
		p.setName(phoneRequest.getName());
		p.setDescr(phoneRequest.getDescr());
		p.setPrice(phoneRequest.getPrice());
		p.setDisc(phoneRequest.getDisc());
		p.setImgUrl(phoneRequest.getImgUrl());
		p = pr.save(p);
		return new PhoneResponse(p);
		
	}
	
	public void delete(int id) {
		pr.deleteById(id);
		this.deleteFromCart(id);
	}
	
	public UserResponse registerUser(UserRequest userRequest) {
		User u = new User();
		u.setUser(userRequest.getUser());
		u.setPassword(userRequest.getPassword());
		u=ur.save(u);
		return new UserResponse(u);
	}
	
	public UserResponse login(String user, String password) {
		User u = ur.findByUserAndPassword(user, password);
		if(u!=null)	return new UserResponse(u);
		else return new UserResponse(new User());
		
	}
	public CartResponse addToCart(CartRequest cartRequest) {
		Cart c = new Cart();
		c.setProdId(cartRequest.getProdId());
		c.setUserId(cartRequest.getUserId());
		c=cr.save(c);
		CartResponse cartResponse = new CartResponse(c);
		cartResponse.setPhoneResponse(new PhoneResponse(pr.findById(cartResponse.getProdId()).get()));
		return cartResponse;
	}
	
	public List<PhoneResponse> findAllByUserId(int userId){
		List<Cart> lc = cr.findAllByUserId(userId);
//		System.out.println(userId);
//		System.out.println(lc.toString());
		List<PhoneResponse> lpr = new ArrayList<PhoneResponse>();
		for (Cart c : lc) {
//			System.out.println(pr.findById(c.getProdId()).get());
			PhoneResponse phoneResponse = new PhoneResponse(pr.findById(c.getProdId()).get());
			
			lpr.add(phoneResponse);			
		}
		return lpr;
	}
	
	public void deleteFromCart(int prodId) {
		cr.deleteByProdId(prodId);
	}
	
	public void deleteCart(int userId) {
		cr.deleteAllByUserId(userId);
	}
}
