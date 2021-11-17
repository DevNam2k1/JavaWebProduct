/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebproduct.controller.admin;

import com.javawebproduct.bean.Product;
import com.javawebproduct.dao.impl.ProductDAO;


import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author laptop88
 */
@MultipartConfig
public class ProductController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private final ProductDAO productDAO = new ProductDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getServletPath();
        
        switch (action) {
            case "/product/new":
                this.showNewForm(request, response);
                break;
            case "/product/create":
                this.insertProduct(request, response);
                break;
            case "/product/delete":
                this.deleteProduct(request, response);
                break;
            case "/product/edit":
                this.showEditForm(request, response);
                break;
            case "/product/update":
                this.updateProduct(request, response);
                break;
            case "/product/search":
                this.searchByProductName(request, response);
                break;
            case "/product":
                this.listProduct(request, response);
                break;
            default:
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/product/add.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        //Lưu ảnh vào folder upload
        Part fileImage = request.getPart("image");
        String image = fileImage.getSubmittedFileName();
        for(Part part : request.getParts()){
            part.write("C:\\Users\\laptop88\\OneDrive\\Máy tính\\JavaPrograms\\JavaWebProduct\\src\\main\\webapp\\assets\\upload\\"+ image);
        }
        double price = Double.parseDouble(request.getParameter("price"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int amount = Integer.parseInt(request.getParameter("amount"));
        Product newProduct = new Product(name, image, price, title, description, amount);
        System.out.println(newProduct);
        productDAO.insertProduct(newProduct);
        response.sendRedirect("/JavaWebProduct/product");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        productDAO.deleteProductById(id);
        response.sendRedirect("/JavaWebProduct/product");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        //Lưu ảnh vào folder upload
        Part fileImage = request.getPart("image");
        String image = fileImage.getSubmittedFileName();
        for(Part part : request.getParts()){
            part.write("C:\\Users\\laptop88\\OneDrive\\Máy tính\\JavaPrograms\\JavaWebProduct\\src\\main\\webapp\\assets\\upload\\"+ image);
        }
        double price = Double.parseDouble(request.getParameter("price"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int amount = Integer.parseInt(request.getParameter("amount"));

        Product pro = new Product(id, name, image, price, title, description, amount);
        productDAO.updateProductById(pro);
        response.sendRedirect("/JavaWebProduct/product");
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int total = 5;
        String start = request.getParameter("page");
        if(start == null){
         start = "1";
        }
        
        int page = Integer.parseInt(start);
        
        if(page != 1){
        page = page - 1;
        page = page*total + 1;
        }
        int count = this.productDAO.getTotalProduct();
        int totalPage = count/total;
        if(totalPage % total != 0){
            totalPage++;
        }
        
        List<Product> listProduct = productDAO.findAll(page, total);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("start", start);
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        Product existingProduct = this.productDAO.findProductById(id);
        System.out.println(existingProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/product/edit.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);
    }

    private void searchByProductName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String productName = request.getParameter("productName");
        int total = 5;
        String start = request.getParameter("page");
        if(start == null){
         start = "1";
        }
        
        int page = Integer.parseInt(start);
        
        if(page != 1){
        page = page - 1;
        page = page*total + 1;
        }
        int count = this.productDAO.getTotalProduct(productName);
        int totalPage = count/total;
        if(totalPage % total != 0){
            totalPage++;
        }
        //Đẩy dữ liệu lên JSP
        request.setAttribute("searchName",productName);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("start", start);
        List<Product> listProduct = productDAO.findProductByProductName(page, total, productName);
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/product/list.jsp");
        dispatcher.forward(request, response);
    }

}
