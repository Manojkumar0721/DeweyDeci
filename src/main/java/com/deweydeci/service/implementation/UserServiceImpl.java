package com.deweydeci.service.implementation;

import com.deweydeci.model.User;
import com.deweydeci.reposiroty.UserRepository;
import com.deweydeci.reposiroty.implementation.UserRepositoryImpl;
import com.deweydeci.service.UserService;
import com.deweydeci.service.validation.UserValidations;

public class UserServiceImpl implements UserService{
	
	UserValidations validation = new UserValidations();
	UserRepository userRepo = new UserRepositoryImpl();
	
	@Override
	public boolean save(User user) {
		if(validation.validateUser(user)) {
			boolean save = userRepo.save(user);
			if(save) {
				System.out.println("User saved Successfully!");
				return true;
			}else {
				System.out.println("User Not Saved, try again!");
				return false;
			}
		}
		return false;
	}

	@Override
	public User findByEamilAndPassword(String email, String password) {
		if(validation.validateLoginUser(email, password)) {
			User user = userRepo.findByEmail(email);
			if(password.equals(user.getPassword())) {
				System.out.println("Login Successful!");
				return user;
			}else {
				System.out.println("Login failed, you enterd the wrong password try again!");
				return null;
			}
		}
		return null;
	}

}
