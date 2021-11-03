/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebproduct.controller.admin;

import com.javawebproduct.bean.User;
import com.javawebproduct.dao.impl.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author laptop88
 */
public class Authentication extends HttpServlet {

    private static final long serialVersionUID = 1L;
    	private final UserDAO dao = new UserDAO();
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
		// TODO Auto-generated method stub
		String uri = request.getServletPath();

		switch (uri) {
		case "/login/form":
			this.showFormLogin(request, response);
			break;

		case "/view/admin/login-user":
			this.login(request, response);
			break;
                case "/dashboard":
                        this.dashboard(request, response);

		default:
			break;
		}
	}

	protected void showFormLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/view/admin/login/login.jsp").forward(request, response);

		return;
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(email + password);
		
		User user = this.dao.login(email, password);
		
		System.out.println(user);
		if (user != null) {
			response.sendRedirect("/JavaWebProduct/dashboard");
			
			return;
		} else {
			response.sendRedirect("/JavaWebProduct/login/form");
			
			return;
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

    private void dashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            request.getRequestDispatcher("/view/admin/dashboard.jsp").forward(request, response);
    }

}
