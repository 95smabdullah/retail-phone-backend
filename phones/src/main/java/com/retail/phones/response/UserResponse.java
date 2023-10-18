package com.retail.phones.response;

import com.retail.phones.entity.User;

import lombok.Data;

@Data
public class UserResponse {
	private int id;
	private String user;
	private String password;
	public UserResponse(User u) {
		
		this.id = u.getId();
		this.user = u.getUser();
		this.password = u.getPassword();
	}
	
	
}
