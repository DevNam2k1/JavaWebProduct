/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebproduct.dao;

import com.javawebproduct.bean.User;

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
    public User login(String email, String password);
}
