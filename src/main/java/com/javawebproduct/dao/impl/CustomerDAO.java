/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebproduct.dao.impl;

import com.javawebproduct.bean.Customer;
import com.javawebproduct.connection.Connector;
import java.util.List;
import com.javawebproduct.dao.ICustomerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author laptop88
 */
public class CustomerDAO implements ICustomerDAO{
    private static final String CHECK_LOGIN = "SELECT * FROM customers where email = ? and password = ?";
    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customers" + "  (username, email, password, address) VALUES " +
        " (?, ?, ?, ?);";

    private static final String SELECT_CUSTOMERS_BY_ID = "SELECT id,name,image,price,title,description,amount from products where id =?";
    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customers";
    private static final String DELETE_CUSTOMER_SQL = "DELETE FROM customers where id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update products set name = ?,image= ?, price =?, title=?, description=?, amount=? where id = ?;";
    
    
    @Override
    public Customer findCustomerById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> findByCustomertName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        // Step 1: Establishing a Connection (Thiết lập kết nối)
        try (Connection connection =Connector.getConnection();

            // Step 2:Create a statement using connection object (Tạo một câu lệnh bằng cách sử dụng đối tượng kết nối)
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query (Thực thi truy vấn hoặc cập nhật truy vấn)
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.(Xử lý đối tượng ResultSet)
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String address = rs.getString("address");
                customers.add(new Customer(id, username, email, password, address));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customers;
    }

    @Override
    public void insertCustomer(Customer customer) {
            System.out.println(INSERT_CUSTOMERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = Connector.getConnection(); 
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL)) {
            preparedStatement.setString(1, customer.getUsername());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPassword());
            preparedStatement.setString(4, customer.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean updateCustomerById(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean disableCustomerById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCustomerById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public Customer login(String email, String password) {
	Customer customer = null;

		try (Connection conn = Connector.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement(CHECK_LOGIN);) {

			System.out.println("conn:" + conn);

			pstmt.setString(1, email);
			pstmt.setString(2, password);

			try (ResultSet resultSet = pstmt.executeQuery()) {
				if (resultSet.next()) {
					customer = new Customer();

					customer.setId(resultSet.getInt("id"));
					customer.setUsername(resultSet.getString("username"));
					customer.setEmail(resultSet.getString("email"));
					customer.setPassword(resultSet.getString("password"));
                                        customer.setAddress(resultSet.getString("address"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return customer;    }
    
    	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAO();

		Customer cus = dao.login("namsky1826@gmail.com", "123");

		System.out.println(cus);
	}
    
}
