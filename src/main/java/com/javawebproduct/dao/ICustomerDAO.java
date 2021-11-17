/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebproduct.dao;

import com.javawebproduct.bean.Customer;
import java.util.List;

/**
 *
 * @author laptop88
 */
public interface ICustomerDAO {
    //Đăng nhập tài khoản người dùng
    public Customer login(String email, String password);
    
    // Tìm kiếm người dùng ID
    Customer findCustomerById(Integer id);
    
    //Tím kiếm người dùng bằng tên
    List<Customer> findByCustomertName(String username);
    
    //In ra tất cả người dùng
    List<Customer> findAll();
    
    //Đăng kí tài khoản mới
    void insertCustomer(Customer customer);
    
    //Cập nhật thông tin người dùng
    boolean updateCustomerById(Customer customer);
    
    //Vô hiệu khóa người dùng
    boolean disableCustomerById(int id);
    
    //Người dùng xóa tài khoản
    boolean deleteCustomerById(int id);
}
