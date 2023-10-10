package com.retail.phones.request;

import lombok.Data;

@Data
public class PhoneRequest {
	private String name;
	private String descr;
	private int price;
	private int disc;
	private String imgUrl;
}
