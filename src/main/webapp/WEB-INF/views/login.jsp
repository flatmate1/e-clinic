<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<title>Przychodnia</title>
</head>
<body>
	<form action="login" method="POST">
	<div style="padding: 1em;
		        position: absolute;
		        top: 50%;
		        left: 50%;
		        margin-right: -50%;
		        transform: translate(-50%, -50%)"> 
	  <div class="form-group">
	    <label for="username">Username</label>
	    <input type="text" class="form-control" name='username' placeholder="Enter Username">
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input type="password" class="form-control" name='password' placeholder="Enter Password">
	  </div>
	  <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
		<h4 class="text-center"><a href="http://localhost:8080/e-clinic/register">Create an account</a></h4>
	  </div>
	</form>
</body>
</html>