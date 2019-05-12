<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core" %>
	
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Przychodnia</title>
</head>
<body>
<nav style="background: #e3f2fd;" class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/e-clinic/">E-Przychodnia</a>
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">${message} <span class="sr-only">(current)</span></a>
      </li>
    </ul>
	    <div>
			<ul class="nav justify-content-end">
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			 <li class="nav-item">
			    <a class="nav-link active" href="">Admin Panel</a>
			  </li>
			  </sec:authorize>
			  <li class="nav-item">
			    <a class="nav-link active" href="/e-clinic/myreservation">My Reservation</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="/e-clinic/doctors">Doctors</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#">Settings</a>
			  </li>
			  <li class="nav-item">
			    <form action="logout" method="post">
					<input class="btn btn-link" value="Logout" type="submit">
				</form>
			  </li>
			</ul>
		</div>
		<div>
  </div>
</nav>
</body>
</html>