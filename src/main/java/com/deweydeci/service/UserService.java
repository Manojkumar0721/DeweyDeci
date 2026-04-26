package com.deweydeci.service;

import com.deweydeci.model.User;

public interface UserService {
	
	boolean save(User user);
	
	User findByEamilAndPassword(String email,String password);

}
