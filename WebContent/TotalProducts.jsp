<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.assign.Product, java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products Display</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.html");
	} else {
%>

<nav class="navbar navbar-light bg-light text-center">
  <a href="Welcome.jsp" class="navbar-brand mb-0 h1">Dashboard</a>
  <a href="logout" class="navbar-brand mb-0 h1">LogOut</a>
</nav>


<table class="table table-striped table-dark">
  <thead>
    <tr class="text-center">
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
      <th scope="col">Quantity</th>
	  <th scope="col">Discount</th>
    </tr>
  </thead>
  <tbody>
		<% 	List<Product> list = (List<Product>) session.getAttribute("total");
			for(Product p: list){
		%>
			<tr class="text-center">
				<th scope="row"><%= p.getId() %></th>
				<td><%= p.getName() %></td>
				<td><%= p.getPrice() %></td>
				<td><%= p.getQuantity() %></td>
				<td><%= p.getDiscount() %></td>
			</tr>
		<%
			}
		}
		%>
  </tbody>
</table>
	</table>
	</div>


</body>
</html>