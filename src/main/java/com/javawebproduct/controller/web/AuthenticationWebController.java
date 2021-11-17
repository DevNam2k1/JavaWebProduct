/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebproduct.controller.web;

import com.javawebproduct.bean.Customer;
import com.javawebproduct.dao.impl.CustomerDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.graalvm.compiler.nodes.memory.address.OffsetAddressNode.address;

/**
 *
 * @author laptop88
 */
public class AuthenticationWebController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private final CustomerDAO customerDAO = new CustomerDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("fallthrough")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String uri = request.getServletPath();

		switch (uri) {                   
		case "/login-form":
			this.showFormLogin(request, response);
			break;
		case "/login":
			this.login(request, response);
			break;
                case "/reigster-form":
                        this.showFormReigsiter(request, response);
                case "/reigster":
                        this.reigster(request, response);
                case "/logout":
                        this.logout(request, response);
                case "/profile":
                        this.profile(request, response);

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

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = 
		request.getRequestDispatcher("/view/web/pages/login.jsp");
                dispatcher.forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        System.out.println(email + password);
        HttpSession session = request.getSession();
        
        Customer customer = this.customerDAO.login(email, password);
        
        System.out.println(customer);
		if (customer != null) {

			session.setAttribute("customer", customer );
                        RequestDispatcher dispatcher = 
                        request.getRequestDispatcher("index.jsp");
                        dispatcher.forward(request, response);
//                        response.sendRedirect("/JavaWebProduct/");
			return;
		} else {
                        
                        request.setAttribute("error", "Tài khoản sai, vui lòng kiểm tra!");
                        RequestDispatcher dispatcher = 
                        request.getRequestDispatcher("/view/web/pages/login.jsp");
                        dispatcher.forward(request, response);
//			response.sendRedirect("/JavaWebProduct/admin");
			
			return;
		}
        
        
    }

    private void reigster(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String address = "Add your address";
        String password = request.getParameter("password");
        String comfirmPassword = request.getParameter("comfirm_password");
        
        if(password != comfirmPassword){
            request.setAttribute("error", "Mật khẩu không trùng nhau!");
            RequestDispatcher dispatcher = 
                        request.getRequestDispatcher("/view/web/pages/reigster.jsp");
                        dispatcher.forward(request, response);
        } else {
        
        Customer newCustomer = new Customer(username, email, password, address);
        System.out.println(newCustomer);
        customerDAO.insertCustomer(newCustomer);
        response.sendRedirect("/JavaWebProduct/login-form");
        }
    }

    private void showFormReigsiter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = 
		request.getRequestDispatcher("/view/web/pages/reigster.jsp");
                dispatcher.forward(request, response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        System.out.println(session);
        session.removeAttribute("customer");

        System.out.println("Session đã bị xóa");

        response.sendRedirect("/JavaWebProduct/");
    }

    private void profile(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
