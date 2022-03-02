<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.assign.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" >
<style>
.container {
	width: 40%;
	border: solid black 2px;
	margin: auto;
	padding: 20px;
	font-size: 20px;
	border-radius: 10px;
	margin-top: 150px;
}

#myform table tr td input {
	font-size: 20px;
	border-radius: 7px;
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

<nav class="navbar navbar-light bg-light text-center">
  <a href="Welcome.jsp" class="navbar-brand mb-0 h1">Dashboard</a>
  <a href="logout" class="navbar-brand mb-0 h1">LogOut</a>
</nav>
<br>
	<%
		Product p = (Product) request.getAttribute("item");
		if (p != null) {
	%>
	<form action="addProd" id="myform" method="post">
  <div class="form-group row text-center">
    <label for="inputPassword" class="offset-2 col-sm-2 col-form-label">Product ID</label>
    <div class="col-sm-2 text-center">
      <input type="text" class="form-control" id="inputPassword" placeholder="ID" required="required"  value="<%= p.getId() %>" name="id" disabled="disabled" >
    </div>
  </div>
<br/>
  <div class="form-group row text-center">
    <label for="inputPassword" class="offset-2 col-sm-2 col-form-label">Product Name</label>
    <div class="col-sm-2 text-center">
      <input type="text" class="form-control" id="inputPassword" placeholder="Name" required="required" value="<%= p.getName() %>"   name="name" disabled="disabled" >
    </div>
  </div>
<br/>
  <div class="form-group row text-center">
    <label for="inputPassword" class="offset-2 col-sm-2 col-form-label">Price</label>
    <div class="col-sm-2 text-center">
      <input type="text" class="form-control" id="inputPassword" placeholder="Price"  required="required" name="price"  value="<%= p.getPrice() %>" disabled="disabled" >
    </div>
  </div>
<br/>
  <div class="form-group row text-center">
    <label for="inputPassword" class="offset-2 col-sm-2 col-form-label">Quantity</label>
    <div class="col-sm-2 text-center">
      <input type="text" class="form-control" id="inputPassword" name="quantity"  required="required" placeholder="Quantity" value="<%= p.getQuantity() %>"   disabled="disabled" >
    </div>
  </div>
<br/>
  <div class="form-group row text-center">
    <label for="inputPassword" class="offset-2 col-sm-2 col-form-label">Discount</label>
    <div class="col-sm-2 text-center">
      <input type="text" class="form-control" id="inputPassword" name="discount" required="required"  disabled="disabled"  value="<%= p.getDiscount() %>" placeholder="Discount">
    </div>
  </div>
  </form>
	<%
		} else {
	%>
	<form action="searchId" id="myform" method="post">
  <div class="form-group row text-center">
    <label for="inputPassword" class="offset-2 col-sm-2 col-form-label">Product ID</label>
    <div class="col-sm-2 text-center">
      <input type="text" class="form-control" id="inputPassword" placeholder="ID" required="required"  name="id">
    </div>
  </div>
  <br>
  <div class="form-group row text-center">
	    <button type="submit" class="col-sm-1 btn btn-primary offset-3">Search</button>
    <div class="col-sm-4 text-center">
	    <button type="reset" class="col-sm-2 btn btn-primary">Reset</button>
     </div>
  </div>
  </form>
	<%
		}
	%>
</body>
</html>