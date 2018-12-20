<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Sign Up</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./resources/css/signup.css">
</head>

<body>
<%@include file="header.jsp" %>
<br><br>
<center>
   <form:form class="form-horizontal" method="post" action="signup" commandName="user" modelAttribute="user" style="border:1px solid #ccc" >
		<div class="container"><br><br>
			<label class="control-label col-sm-5"><b>UserName:</b></label>		
    		<div class="col-sm-4"><form:input path = "userName" />
    		<form:errors path="userName" cssStyle="color: #ff0000"/></div>
    		    		<br>
			<label class="control-label col-sm-5"><b>Email:</b></label>		
    		<div class="col-sm-4"><form:input path="email" type="text" />
    		<form:errors path="email" cssStyle="color: #ff0000"/></div>
    		<br>
			<label class="control-label col-sm-5"><b>Password:</b></label>		
    		<div class="col-sm-4"><form:input path="password" type="password" />
    		<form:errors path="password" cssStyle="color: #ff0000"/></div>
    		
			<label class="control-label col-sm-5"><b>Mobile:</b></label>		
    		<div class="col-sm-4"><form:input path="mobile" type="text" />
    		<form:errors path="mobile" cssStyle="color: #ff0000"/></div>
    		
    		<div class="form-group">
    		<div class="col-sm-3"></div>
			<div class="col-sm-4 col-sm-offset-2"><button type="submit" class="btn">SignUp</button></div>
    		<div class="col-sm-4"><button type="submit" class="btn">Cancel</button></div><br>
    		</div>
    	
    		<br>
		</div>
	</form:form>
	</center>
<%@include file="footer.jsp"  %>

</body>
</html>