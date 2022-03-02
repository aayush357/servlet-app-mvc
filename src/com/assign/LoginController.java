package com.assign;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = (String) request.getParameter("name");
		String passwd = (String) request.getParameter("passwd");
		PrintWriter out = response.getWriter();
		UserDAO ud = new UserDAO();
		String url = request.getServletPath();
		if(url.equals("/login")){
			if (ud.validate(name, passwd)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", name);
				response.sendRedirect("Welcome.jsp");
			} else {
				out.println("<div style=\"text-align:center\">"
						+ "UserName or Password Incorrect"
						+ "</div>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
		}else if(url.equals("/add")) {
			RequestDispatcher rd = request.getRequestDispatcher("Add.jsp");
			rd.forward(request, response);
		} else if(url.equals("/edit")) {
			RequestDispatcher edit = request.getRequestDispatcher("EditProduct.jsp");
			edit.forward(request, response);
		} else if(url.equals("/remove")) {
			RequestDispatcher remove = request.getRequestDispatcher("Remove.jsp");
			remove.forward(request, response);
		} else if(url.equals("/search")) {
			RequestDispatcher search = request.getRequestDispatcher("Search.jsp");
			search.forward(request, response);
		} else if(url.equals("/totalProd")) {
			RequestDispatcher total = request.getRequestDispatcher("total");
			total.forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
