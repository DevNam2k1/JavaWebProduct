/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebproduct.dao.impl;

import com.javawebproduct.bean.Product;
import com.javawebproduct.connection.Connector;
import com.javawebproduct.dao.IProductDAO;
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
public class ProductDAO implements IProductDAO{
    
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products" + "  (name, image, price, title, description, amount) VALUES " +
        " (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_PRODUCT_BY_ID = "SELECT id,name,image,price,title,description,amount from products where id =?";
//    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM products LIMIT "+ (start - 1) +", " + total;
    private static final String DELETE_PRODUCTS_SQL = "DELETE FROM products where id = ?;";
    private static final String UPDATE_PRODUCTS_SQL = "update products set name = ?,image= ?, price =?, title=?, description=?, amount=? where id = ?;";
    private static final String TOTAL_PRODUCTS_SQL = "SELECT count(*) FROM products";
    private static final String TOTAL_PRODUCTS_BY_NAME_SQL = "SELECT count(*) FROM products where name like ?";
//    private static final String SEARCH_BY_NAME = "SELECT * FROM products where name like ?";

    @Override
    public Product findProductById(Integer id) {
         Product product = null;
        // Step 1: Establishing a Connection
        try (Connection connection = Connector.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                String name = rs.getString("name");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String title = rs.getString("title");
                int amount = rs.getInt("amount");
                String description = rs.getString("description");
                
                product = new Product(id, name, image, price, title, description, amount);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
       
    }

    @Override
    public List<Product> findProductByProductName(int start,int total, String nameProduct) {
         List<Product> products = new ArrayList<>();
        // Step 1: Establishing a Connection (Thiết lập kết nối)
        try (Connection connection =Connector.getConnection();

            // Step 2:Create a statement using connection object (Tạo một câu lệnh bằng cách sử dụng đối tượng kết nối)
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products where name like ? LIMIT "+ (start - 1) +", " + total );) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1,"%"+nameProduct+"%");
            // Step 3: Execute the query or update query (Thực thi truy vấn hoặc cập nhật truy vấn)
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.(Xử lý đối tượng ResultSet)
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String title = rs.getString("title");
                int amount = rs.getInt("amount");
                String description = rs.getString("description");
                products.add(new Product(id, name, image, price, title, description, amount));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }
    
    //In ra tất cả sản phẩm và phân trang
    @Override
    public List<Product> findAll(int start, int total)  {

        List<Product> products = new ArrayList<>();
        // Step 1: Establishing a Connection (Thiết lập kết nối)
        try (Connection connection =Connector.getConnection();

            // Step 2:Create a statement using connection object (Tạo một câu lệnh bằng cách sử dụng đối tượng kết nối)
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products LIMIT "+ (start - 1) +", " + total)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query (Thực thi truy vấn hoặc cập nhật truy vấn)
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.(Xử lý đối tượng ResultSet)
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String title = rs.getString("title");
                int amount = rs.getInt("amount");
                String description = rs.getString("description");
                products.add(new Product(id, name, image, price, title, description, amount));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    @Override
    public void insertProduct(Product product) {
            System.out.println(INSERT_PRODUCTS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = Connector.getConnection(); 
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getImage());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getTitle());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getAmount());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean updateProductById(Product product) {
        boolean rowUpdated = false;
        try (Connection connection = Connector.getConnection(); 
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getImage());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getTitle());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getAmount());
            preparedStatement.setInt(7, product.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteProductById(int id) {
       boolean rowDeleted = false;
        try (Connection connection = Connector.getConnection(); 
                PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
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
    public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		
		List<Product> list = dao.findAll(1,5);
		
		for (Product product : list) {
			System.out.println(product);
		}
	}

    @Override
    public int getTotalProduct() {
        // Step 1: Establishing a Connection
        try (Connection connection = Connector.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(TOTAL_PRODUCTS_SQL);) {
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
        return 0;
           }

    @Override
    public int getTotalProduct(String nameProduct) {
           // Step 1: Establishing a Connection
        try (Connection connection = Connector.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(TOTAL_PRODUCTS_BY_NAME_SQL);) {
            preparedStatement.setString(1, nameProduct);
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
        return 0;
           
    }

}
