<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Welcome Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style type="text/css">
	div{
		float: left;
		padding: 20px;
		border: 20px;
	}
	div a{
	 font-size: 30px;
	 color: aliceblue;
	 background-color: black;
	}
</style>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.html");
	}
%>
<nav class="navbar navbar-light bg-light">
  <a href="Welcome.jsp" class="navbar-brand mb-0 h1">Welcome Admin</a>
  <a href="logout" class="navbar-brand mb-0 h1">LogOut</a>
</nav>
	<div>
		<a href="add">Add Product</a>
	</div>
	<div>
		<a href="search">Search Product</a>
	</div>
	<div>
		<a href="edit">Edit Product</a>
	</div>
	<div>
		<a href="remove">Remove Product</a>
	</div>
	<div>
		<a href="totalProd">Total Product</a>
	</div>
</body>
</html>