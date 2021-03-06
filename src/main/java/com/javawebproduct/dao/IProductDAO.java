/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebproduct.dao;

import com.javawebproduct.bean.Product;
import java.util.List;

/**
 *
 * @author laptop88
 */
public interface IProductDAO {
    // Tìm kiếm sản phẩm ID
    Product findProductById(Integer id);
    
    //Tím kiếm sản phẩm bằng tên
    List<Product> findProductByProductName(String name);
    
    //In ra tất cả sản phẩm
    List<Product> findAll();
    
    //Thêm sản phẩm
    void insertProduct(Product product);
    
    //Cập nhật sản phẩm 
    boolean updateProductById(Product product);
    
    //Xóa sản phẩm
    boolean deleteProductById(int id);
}
