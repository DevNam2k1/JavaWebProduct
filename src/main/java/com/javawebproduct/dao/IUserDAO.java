/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebproduct.dao;

import com.javawebproduct.bean.User;
import java.util.List;

/**
 *
 * @author laptop88
 */
public interface IUserDAO {

    /**
     *
     * @param email
     * @param password
     * @return
     */
    //Đăng nhập tài khoản nhân viên
    public User login(String email, String password);
    
    //Đăng kí tài khoản cho nhân viên
    void insertUser (User user);
    
    //Hiển thị tài khoản nhân viên
    public List<User> findAll(int start,int total);
    
    //Đếm số lượng nhân viên
    int getTotalUser();
}
