<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./resources/css/login.css">
<title>Insert title here</title>
</head>
<body>

<center>
  <div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign in for jewel emails</h1>
            <!--  div class="account-wall">-->
                <img class="content-image" src="./resources/images/usericon1.png"
                    alt="">
               <!--   <form class="form-signin">
                <input type="text" class="form-control" placeholder="Email" required autofocus>
                <br> 
                <br>
                <input type="password" class="form-control" placeholder="Password" required>-->
                <div class="container">
  <form action="/nextpage.jsp">
    <label for="usrname">Username</label>
    <input type="text" id="usrname" name="usrname" required>
    <br>
    <br>
    <label for="psw">Password</label>
    <input type ="password" id="psw" name="psw" pattern = "(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title= "Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required >
    

  </form>
</div>
                
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
                </form>
           
            <br>
            <a href="#" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div>
</center>
		
</body>
</html>