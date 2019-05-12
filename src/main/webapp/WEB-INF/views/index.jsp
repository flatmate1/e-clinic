<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<title>PRZYCHODNIA</title>
</head>
<body>
<jsp:include page="_navbar.jsp" />
	<form action="login" method="POST">
		<div style="margin: 20px auto;
		  width: 100%;
		  max-width: 200px;
		  height: 40px; "> 
		  <div class="form-group">
		    <input type="text" class="form-control" name='name' placeholder="Search Doctor...">
		  </div>
		  <input type="submit" value="Search" />
		  </div>
	</form>
</body>
</html>
