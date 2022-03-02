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

@WebServlet("/searchId")
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		response.setContentType("text/html");
		UserDAO ud = new UserDAO();
		Product p = ud.singleselect(id);
//		RequestDispatcher rd = request.getRequestDispatcher("Search.jsp");
		PrintWriter out = response.getWriter();
		if(p!=null) {
			request.setAttribute("item", p);
			RequestDispatcher rd = request.getRequestDispatcher("Search.jsp");
			rd.include(request, response);
		}
		else {
			out.print("<h2>Id Not Present</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("Search.jsp");
			rd.include(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
