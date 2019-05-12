<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  </head>

  <body>

    <div style="padding: 1em;
		        position: absolute;
		        top: 50%;
		        left: 50%;
		        margin-right: -50%;
		        transform: translate(-50%, -50%);
  				width: 500px;">

        <form:form method="POST" modelAttribute="reservationForm" class="form-signin">
            <h2 class="form-signin-heading">Medicine Card</h2>

                 <div class="form-group">
				    <label for="foodAllergies">Food Allergies</label>
				    <form:textarea path="foodAllergies" class="form-control" id="foodAllergies" rows="3"/>
				 </div>
            
                 <div class="form-group">
				    <label for="medicineAllergies">Medicie Allergies</label>
				    <form:textarea path="medicineAllergies" class="form-control" id="medicineAllergies" rows="3"/>
				 </div>
				 
                <div class="form-group">
				    <label for="symptons">Symptons</label>
				    <form:textarea path="symptons" class="form-control" id="symptons" rows="3"/>
				 </div>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Reserve</button>
        </form:form>

    </div>
  </body>
</html>
