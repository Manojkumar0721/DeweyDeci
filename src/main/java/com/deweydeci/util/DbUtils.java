package com.deweydeci.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.deweydeci.constants.DbCredentials;

public class DbUtils {

	public static Connection getConnection() {
		try {
			// Load the Driver
			Class.forName(DbCredentials.DRIVER.getValue());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

			return DriverManager.getConnection(DbCredentials.HOST.getValue(), DbCredentials.USER.getValue(),
					DbCredentials.PASSWORD.getValue());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
