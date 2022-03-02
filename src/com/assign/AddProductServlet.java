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

import com.pair.Pair;

@WebServlet("/addProd")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		if (session == null)
			response.sendRedirect("Login.html");
		else {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			float price = Float.parseFloat(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			float discount = Float.parseFloat(request.getParameter("discount"));
			Product p = new Product(id, name, price, quantity, discount);
			UserDAO ud = new UserDAO();
			Pair<Boolean, String> status = ud.insertCommand(p);
			PrintWriter out = response.getWriter();
			if (status.getKey()) {
				out.println(status.getValue());
				RequestDispatcher rd = request.getRequestDispatcher("Add.jsp");
				rd.include(request, response);
			} else {
				out.println(status.getValue());
				RequestDispatcher rd = request.getRequestDispatcher("Add.jsp");
				rd.include(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
