package com.retail.phones.response;

import com.retail.phones.entity.Phone;

import lombok.Data;

@Data
public class PhoneResponse {
	private int id;
	private String name;
	private String descr;
	private int price;
	private int disc;
	private String imgUrl;
	public PhoneResponse(Phone p) {
		super();
		this.id = p.getId();
		this.name = p.getName();
		this.descr = p.getDescr();
		this.price = p.getPrice();
		this.disc = p.getDisc();
		this.imgUrl = p.getImgUrl();
	}
	
	

}
