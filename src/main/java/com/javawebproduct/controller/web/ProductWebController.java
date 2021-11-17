/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebproduct.controller.web;

import com.javawebproduct.bean.Product;
import com.javawebproduct.dao.impl.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author laptop88
 */
public class ProductWebController extends HttpServlet {

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
            case "/shop-grid":
                this.listProduct(request, response);
                break;
            case "/search":
                this.searchByProductName(request, response);
                break;
            case "/blog":
                this.showBlog(request, response);
                break;
            case "/contact":
                this.showContact(request, response);
                break;
            case "/shop-details":
                this.showShopDetails(request, response);
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
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("start", start);
        List<Product> listProduct = productDAO.findAll(page, total);
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/web/shop-grid.jsp");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/web/shop-grid.jsp");
        dispatcher.forward(request, response);
    }

    private void showBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = 
		request.getRequestDispatcher("/view/web/shop-blog.jsp");
                dispatcher.forward(request, response);
    }

    private void showContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                RequestDispatcher dispatcher = 
		request.getRequestDispatcher("/view/web/shop-contant.jsp");
                dispatcher.forward(request, response);    
    }

    private void showShopDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int productId = Integer.parseInt(request.getParameter("product"));
        
        Product detailsProduct = productDAO.findProductById(productId);
        
        request.setAttribute("productDetails", detailsProduct);
        RequestDispatcher dispatcher = 
		request.getRequestDispatcher("/view/web/shop-details.jsp");
                dispatcher.forward(request, response);
    }

}
