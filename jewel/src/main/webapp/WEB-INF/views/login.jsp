<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./resources/css/login.css">
<title>Login</title>
<style>
body {
    background-image:    url(./resources/images/back.gif);
    background-size:     cover;                      /* <------ */
    background-repeat:   no-repeat;
    background-position: center center;              /* optional, center the image */    
}
</style>
</head>
<body>
<br>
<br>
<center>
  <div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <!--  div class="account-wall">-->
                <img class="content-image" src="./resources/images/usericon1.png"
                    alt="icon">
                <form class="form-signin" method="post" action="<c:url value='/j_spring_security_check' />">
                <input type="text" name="username" class="form-control" placeholder="Enter Email" required autofocus>
                <br> 
                <br>
                <input type="password" name="password" class="form-control" placeholder="Enter Password" required>
                <br>
                <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Sign in</button>
                    <br>
                    <br>
                <label class="checkbox pull-left">
                    <input type="checkbox" value="remember-me">
                    Remember me   
                </label>
                <a href="#" class="pull-right need-help">   Need help? </a><span class="clearfix"></span>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
           
            <br>
            <a href="#" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div>
</center>

<%@include file="footer.jsp"%>	
</body>
</html>