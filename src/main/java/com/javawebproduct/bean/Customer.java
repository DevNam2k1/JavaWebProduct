/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebproduct.bean;

/**
 *
 * @author laptop88
 */
public class Customer {
    private int id;
    private String username;
    private String email;
    private String password;
    private String address;
    
    public Customer(){
    }

    public Customer(int id, String username,String email, String password, String address) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
    }
    
        public Customer( String username,String email, String password, String address) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", username=" + username + ", password=" + password + ", address=" + address + '}';
    }
    
    
    
}

