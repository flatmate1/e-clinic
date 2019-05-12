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
		<title>DoctorList</title>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	</head>
<jsp:include page="_navbar.jsp" />
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1 class="display-4">Doctors</h1>
    <p class="lead">This is a list of available doctors</p>
  </div>
</div>

<table class="table table-sm">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Surname</th>
      <th scope="col">Title</th>
      <th scope="col">Specialty</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${doctors}" var="doctor">
	  <tr>  	
      <th scope="row"></th>
      <td>${doctor.named}</td>
      <td>${doctor.surname}</td>
      <td>${doctor.title}</td>
      <td>${doctor.specialty}</td>
      <td>
      <c:choose>
      	<c:when test="${doctor.available == 1}">
      		<form action="http://localhost:8080/e-clinic/reservation/doctor/${doctor.id}">
    			<input class="btn btn-primary" type="submit" value="Reserve" />
			</form>
      	</c:when>
      	<c:otherwise>
			<button type="button" class="btn btn-warning">Brak</button>	
      	</c:otherwise>
	  </c:choose>
	  </td>
    </tr>
    </c:forEach>
      <sec:authorize access="hasRole('ROLE_ADMIN')">
   	  <tr>  	
      <th scope="row"></th>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td>
	      <form action="http://localhost:8080/e-clinic/reservation/doctor/add">
	    			<input class="btn btn-primary" type="submit" value="Add new Doctor" />
		  </form>
	  </td>
      </tr>
      </sec:authorize>
  </tbody>
</table>

</html>