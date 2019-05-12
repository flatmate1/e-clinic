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
<form:form method="POST" modelAttribute="userForm">

 	<div class="section1">
	  <div class="form-group">
	    <label>Username</label>
	    <form:input path="username" type="text" class="form-control" placeholder="Username"/>
	    <form:errors path ="username" cssClass="error"/>
	  </div>
	  <div class="form-group">
	    <label>Password</label>
	    <form:input path="password" type="password" class="form-control" placeholder="Password"/>
	  </div>
  <h2>User Details</h2>
	<div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label>Name</label>
	      <form:input path="name" type="text" class="form-control" placeholder="Name"/>
	    </div>
	    <div class="form-group col-md-6">
	      <label>Surname</label>
	      <form:input path="surname" type="text" class="form-control" placeholder="Surname"/>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="inputAddress">Phone Number</label>
	    <form:input path="phoneNumber" type="text" class="form-control" placeholder="Phone Number"/>
	  </div>
	  <div class="form-group">
	    <label for="inputAddress2">Date of birth</label>
	    <form:input path="dateOfBirth" type="text" class="form-control"  placeholder="Date of birth"/>
	  </div>
	  <fieldset class="form-group">
	    <div class="row">
	      <label class="col-form-label col-sm-2 pt-0">Radios</label>
	      <div class="col-sm-10">
	        <div class="form-check">
	          <form:radiobutton path="sex" value="male"/>
	          <label class="form-check-label" for="gridRadios1">
	            Male
	          </label>
	        </div>
	        <div class="form-check">
	          <form:radiobutton path="sex" value="female"/>
	          <label class="form-check-label" for="gridRadios2">
	            Female
	          </label>
	        </div>
	      </div>
	    </div>
	  </fieldset>
	  </div>
  <input type="submit" class="btn btn-primary" value="Submit">
 </div>
 </form:form>
 </div>
</body>
</html>