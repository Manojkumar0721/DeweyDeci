package com.deweydeci.service.validation;

import com.deweydeci.model.User;

public class UserValidations {

	public boolean validateUser(User user) {
		if (null != user) {
			if (null != user.getFirstName()) {
				if (null != user.getLastName()) {
					if (null != user.getAddress()) {
						if (null != user.getPhoneNumber()) {
							if (null != user.getEmail()) {
								if (null != user.getPassword()) {
									return true;
								}
								System.out.println("Password can't be empty!");
								return false;
							}
							System.out.println("Email can't be empty!");
							return false;
						}
						System.out.println("Phone number can't be empty!");
						return false;
					}
					System.out.println("Address Can't be empty!");
					return false;
				}
				System.out.println("Last Name can't be empty!");
				return false;
			}
			System.out.println("First Name can't be empty!");
			return false;
		}
		System.out.println("User Details can't be empty!");
		return false;
	}

	public boolean validateLoginUser(String email, String password) {
		if (email != null) {
			if (email.contains("@") && email.contains(".")) {
				if (password.length() >= 0 && password.length() <= 16 && password != null) {
					System.out.println("Searching User!");
					return true;
				}
				System.out.println("Password length should be between 0-8.");
				return false;
			}
			System.out.println("Email should be contain @ and . is manditory!");
			return false;
		}
		System.out.println("Email is Invalid!");
		return false;

	}

}
