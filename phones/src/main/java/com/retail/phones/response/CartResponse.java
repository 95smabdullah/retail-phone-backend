package com.retail.phones.response;

import com.retail.phones.entity.Cart;

import lombok.Data;

@Data
public class CartResponse {
	private int id;
	private int userId;
	private int prodId;
	private PhoneResponse phoneResponse;
	public CartResponse(Cart c) {
		super();
		this.id = c.getId();
		this.userId = c.getUserId();
		this.prodId = c.getProdId();
	}
	
	

}
