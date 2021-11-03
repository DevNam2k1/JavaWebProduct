/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebproduct.dao.impl;

import com.javawebproduct.bean.User;
import com.javawebproduct.connection.Connector;
import com.javawebproduct.dao.IUserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author laptop88
 */
public class UserDAO implements IUserDAO{
    @Override
	public User login(String email, String password) {
		User user = null;

		try (Connection conn = Connector.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");) {

			System.out.println("conn:" + conn);

			pstmt.setString(1, email);
			pstmt.setString(2, password);

			try (ResultSet resultSet = pstmt.executeQuery()) {
				if (resultSet.next()) {
					user = new User();

					user.setId(resultSet.getInt("id"));
					user.setUsername(resultSet.getString("username"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return user;
	}

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();

		User user = dao.login("demo@gmail.com", "123");

		System.out.println(user);
	}

}
