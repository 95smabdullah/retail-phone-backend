package com.retail.phones.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.phones.entity.Phone;
import com.retail.phones.repository.PhoneRepo;
import com.retail.phones.request.PhoneRequest;
import com.retail.phones.response.PhoneResponse;

@Service
public class PhoneServices {
	@Autowired PhoneRepo pr;
	
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
		List<Phone> lp = new ArrayList<Phone>();
		List<PhoneResponse> lpr = new ArrayList<PhoneResponse>();
		for (Phone p : lp) {
			lpr.add(new PhoneResponse(p));
		}
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
}
