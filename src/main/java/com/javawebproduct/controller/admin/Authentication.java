/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javawebproduct.controller.admin;

import com.javawebproduct.bean.User;
import com.javawebproduct.dao.impl.ProductDAO;
import com.javawebproduct.dao.impl.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    @SuppressWarnings("fallthrough")
    	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getServletPath();

		switch (uri) {                   
		case "/admin":
			this.showFormLogin(request, response);
			break;
		case "/admin/login":
			this.login(request, response);
			break;
                case "/admin/logout":
                        this.logout(request, response);
                        break;
                case "/admin/error":
			this.error(request, response);
			break;
                case "/dashboard":
                        this.dashboard(request, response);
                        break;
                case "/employee":
                        this.showEmployeeManager(request,response);
                        break;
                case "/employee/new":
                        this.showFormEmployee(request,response);
                        break;
                case "/employee/store":
                        this.showStoreEmployee(request,response);
                        break;
		default:
			break;
		}
	}

	protected void showFormLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                RequestDispatcher dispatcher = 
		request.getRequestDispatcher("/view/admin/login/login.jsp");
                dispatcher.forward(request, response);

	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		System.out.println(email + password);
		
		User user = this.dao.login(email, password);


		System.out.println(user);
		if (user != null) {

			session.setAttribute("username", user );
                        RequestDispatcher dispatcher = 
                        request.getRequestDispatcher("/view/admin/dashboard.jsp");
                        dispatcher.forward(request, response);
//                        response.sendRedirect("/JavaWebProduct/dashboard");
			return;
		} else {
                        
                        request.setAttribute("error", "Tài khoản sai, vui lòng kiểm tra!");
                        RequestDispatcher dispatcher = 
                        request.getRequestDispatcher("/view/admin/login/login.jsp");
                        dispatcher.forward(request, response);
//			response.sendRedirect("/JavaWebProduct/admin");
			
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

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        System.out.println(session);
        session.removeAttribute("username");

        System.out.println("Session đã bị xóa");

        RequestDispatcher dispatcher = 
                        request.getRequestDispatcher("/view/admin/login/login.jsp");
                        dispatcher.forward(request, response);
    }

    private void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                RequestDispatcher dispatcher = 
		request.getRequestDispatcher("/view/admin/pages/404error.jsp");
                dispatcher.forward(request, response);    
    }

    private void showEmployeeManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        int count = this.dao.getTotalUser();
        int totalPage = count/total;
        if(totalPage % total != 0){
            totalPage++;
        }
        List<User> user  = this.dao.findAll(page, total);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("start", start);
        request.setAttribute("listUser", user);
        RequestDispatcher dispatcher = 
		request.getRequestDispatcher("/view/admin/manager/employee.jsp");
                dispatcher.forward(request, response);
    }


    private void showStoreEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        System.out.println(password + confirmPassword);

        
        User newUser = new User(username, email, password);
        System.out.println(newUser);
        this.dao.insertUser(newUser);
        request.setAttribute("success", "Thêm nhân viên thành công");
        response.sendRedirect("/JavaWebProduct/employee-manager");
       
        
        
    }

    private void showFormEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                RequestDispatcher dispatcher = 
		request.getRequestDispatcher("/view/admin/employee/add.jsp");
                dispatcher.forward(request, response);  
    }

}
