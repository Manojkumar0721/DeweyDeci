package com.deweydeci.reposiroty.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.deweydeci.model.User;
import com.deweydeci.reposiroty.UserRepository;
import com.deweydeci.util.DbUtils;

public class UserRepositoryImpl implements UserRepository{

	@Override
	public boolean save(User user) {
		try {
			Connection connection = DbUtils.getConnection();
			
			String insertQuery = "insert into user(first_name,last_name,address,phone_number,email,password) values(?,?,?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getPhoneNumber());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getPassword());
			
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println(rowsAffected);
			
			return true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User findByEmail(String email) {
		try {
			Connection connection = DbUtils.getConnection();
			
			String findQuery = "select * from user where email = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(findQuery);
			
			preparedStatement.setString(1, email);
			
			ResultSet rset = preparedStatement.executeQuery();
			
			User user = new User();
			
			if(rset.next()) {
				user.setFirstName(rset.getString("first_name"));
				user.setLastName(rset.getString("last_name"));
				user.setAddress(rset.getString("address"));
				user.setPhoneNumber(rset.getString("phone_number"));
				user.setEmail(rset.getString("email"));
				user.setPassword(rset.getString("password"));
			}
			
			return user;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
