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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laptop88
 */
public class UserDAO implements IUserDAO{
    //  private static final String SELECT_ALL_USERS = "SELECT * FROM users";
        private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (username, email, password) VALUES " +
        " (?, ?, ?);";
        private static final String TOTAL_USERS_SQL = "SELECT count(*) FROM users";
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


    @Override
    public List<User> findAll(int start,int total) {
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection (Thiết lập kết nối)
        try (Connection connection =Connector.getConnection();

            // Step 2:Create a statement using connection object (Tạo một câu lệnh bằng cách sử dụng đối tượng kết nối)
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users LIMIT "+ (start - 1) +", " + total)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query (Thực thi truy vấn hoặc cập nhật truy vấn)
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.(Xử lý đối tượng ResultSet)
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
         
                users.add(new User(id, username, email, password));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;    
    }
        
            private void printSQLException(SQLException ex) {
         for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
            //Test
	public static void main(String[] args) {
                UserDAO dao = new UserDAO();
		
		List<User> list = dao.findAll(4,5);
		
		for (User product : list) {
			System.out.println(product);
		}
	}

    @Override
    public void insertUser(User user) {
                  System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = Connector.getConnection(); 
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } 
    }

    @Override
    public int getTotalUser() {
       // Step 1: Establishing a Connection
        try (Connection connection = Connector.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(TOTAL_USERS_SQL);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                    return rs.getInt(1);
               
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return 0;    }
}
