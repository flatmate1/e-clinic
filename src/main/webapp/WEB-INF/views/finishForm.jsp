<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
<title>Przychodnia</title>
</head>
<body>
<div style="margin: 20px auto;
		  width: 100%;
		  max-width: 500px;
		  height: 40px; ">
<h2>User Register</h2>
<form:form method="POST" modelAttribute="reviewForm">

 	<div class="section1">
		<div class="form-group">
		    <label for="exampleSelect2">Rate</label>
		    <form:select path="rating" class="form-control" id="exampleSelect2">
		      <form:option value="1">1</form:option>
		      <form:option value="2">2</form:option>
		      <form:option value="3">3</form:option>
		      <form:option value="4">4</form:option>
		      <form:option value="5">5</form:option>
		    </form:select>
		  </div>
	</div>
	
<div class="section2">
  <h2>User Details</h2>
			  	<div class="form-group">
			    <label for="exampleTextarea">Write review</label>
			    <form:textarea path="comment" class="form-control" id="exampleTextarea" rows="3"></form:textarea>
		  	</div>
  <input type="submit" class="btn btn-primary" value="Submit">
 </div>
 </form:form>
 </div>
</body>
</html>
