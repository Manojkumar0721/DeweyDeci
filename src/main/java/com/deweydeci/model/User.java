package com.deweydeci.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	

	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private String password;

}
