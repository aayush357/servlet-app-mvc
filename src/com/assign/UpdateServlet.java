package com.assign;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;

import com.pair.Pair;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		float discount = Float.parseFloat(request.getParameter("discount"));
		Product p = new Product(id, name, price, quantity, discount);
		UserDAO ud = new UserDAO();
		Pair<Boolean, String> status = ud.updateCommand(p);
		PrintWriter out = response.getWriter();
		if(status.getKey()) {
			out.println(status.getValue());
			RequestDispatcher rd = request.getRequestDispatcher("EditProduct.jsp");
			rd.include(request, response);
		}
		else { 
			out.println(status.getValue());
			RequestDispatcher rd = request.getRequestDispatcher("EditProduct.jsp");
			rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
