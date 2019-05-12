<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <h1 class="display-4">My reservation</h1>
    <p class="lead">This is a list of your reservation</p>
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
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${reservationInfoObject}" var="reservation">
	  <tr>  	
      <th scope="row"></th>
      <td>${reservation.doctor.name}</td>
      <td>${reservation.doctor.surname}</td>
      <td>${reservation.doctor.title}</td>
      <td>${reservation.doctor.specialty}</td>
      <td>
   	   <form action="http://localhost:8080/e-clinic/reservation/doctor/${reservation.doctor.id}/finish">
    			<input class="btn btn-primary" type="submit" value="Finish" />
	   </form>
	  </td>
	  
	  <td>
	    <form action="http://localhost:8080/e-clinic/details/doctor/${reservation.doctor.id}/">
    			<input class="btn btn-primary" type="submit" value="Details" />
	   </form>
	  </td>
	   
    </tr>
    </c:forEach>
  </tbody>
</table>

</html>