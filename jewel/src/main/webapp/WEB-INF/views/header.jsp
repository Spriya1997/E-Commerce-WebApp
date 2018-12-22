<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<!-- Header -->


<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
     <div class="navbar-header">
      <img src="../resources/images/logo 1.jpg" alt="jewel" width="100" height="50">
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      <li class="active"><a href="${pageContext.request.contextPath}/admin/adminPage">Admin</a></li>
      
      <li class="dropdown active">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Product Category <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:forEach var="cat" items="${clist}">
          <c:if test="${pageContext.request.userPrincipal.name == null}">
		        	<li><a href="login">${cat.categoryName}</a></li>
		        </c:if>
		        <c:if test="${pageContext.request.userPrincipal.name != null}">
		        	<li><a href="custProductList?categoryId=${cat.categoryId}">${cat.categoryName}</a></li>
		       </c:if>
         
     </c:forEach>
        </ul>
      </li>
       <li class="active"><a href="${pageContext.request.contextPath}/admin/adminProductList">Admin ProductList</a></li>
      
            
     <!--   <li><a href="#">Cart</a></li>-->
    </ul>
    <ul class="nav navbar-nav navbar-right">
    
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        	<li class="active"><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li class="active"><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
      		<li class="active"> <a><b>Welcome : ${pageContext.request.userPrincipal.name} </b></a></li>
      		<li class="active"><a href="${pageContext.request.contextPath}/cart"><span class="glyphicon glyphicon-shopping-cart"></span> <b>My Cart</b></a></li>
         	<li class="active"><a href="<c:url value="/logout"/>"><b>Logout</b></a></li>  
        </c:if>  
        
      
    </ul>
  </div>
</nav>
 

<!-- Header Ends -->

</body>
</html>