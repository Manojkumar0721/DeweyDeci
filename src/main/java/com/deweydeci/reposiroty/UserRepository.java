package com.deweydeci.reposiroty;

import com.deweydeci.model.User;

public interface UserRepository {
	
	boolean save(User user);
	
	User findByEmail(String email);

}
