package com.assign;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;

@WebServlet("/editId")
public class EditIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		UserDAO ud = new UserDAO();
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		Product p = ud.singleselect(id);
		if (p!= null) {
			request.setAttribute("item", p);
			RequestDispatcher rd = request.getRequestDispatcher("EditProduct.jsp");
			rd.include(request, response);
		} else { 
			out.println("Product not Present");
			RequestDispatcher rd = request.getRequestDispatcher("EditProduct.jsp");
			rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
