<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminPage</title>
<link	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"	rel="stylesheet" type="text/css" />
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../resources/admin.css">
</head>
<body>

<%@include file="header.jsp"%>
	<br/>
	
<div class="container">
  <br><br>
  <div class="col-md-8 col-md-offset-2">
  
  <ul class="nav nav-pills nav-justified">
    <li class="active"><a data-toggle="pill" href="#sup"><b>SUPPLIER</b></a></li>
    <li><a data-toggle="pill" href="#prod"><b>PRODUCT</b></a></li>    
</ul>
<div class="tab-content">
    
  
    <div id="sup" class="tab-pane fade in active"><br><br>
    	<form:form class="form-horizontal" id="login-form" method="post" action="${pageContext.request.contextPath}/admin/addSupplier" >
			<div class="row">
			<div class="form-group">
				<label class="control-label col-sm-4" for="sid">Supplier ID:</label>		
    			<div class="col-sm-6"><input type="text" name="sid" class="form-control" value="" required></div>
    		</div></div><br>
    		<div class="row">
			<div class="form-group">
				<label class="control-label col-sm-4" for="sname">Supplier Name: </label>
				<div class="col-sm-6"><input type="text" name="sname" class="form-control" value="" required></div>
			</div></div><br>
			<div class="row">
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-3"><button type="submit" class="btn btn-login">Save</button></div>
				<div class="col-sm-4"><button type="reset" class="btn btn-login">Cancel</button></div>
			</div></div>		
		</form:form>   
    </div> 
    <div id="prod" class="tab-pane fade"><br><br>
		<form:form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/saveProduct" enctype="multipart/form-data">
			<div class = "col-sm-10 col-sm-offset-2"><table>    
         	<tr>    
          		<td><b>Product Name</b></td><td><input type="text" name="prodname" class="form-control" value="" required></td>  
        	</tr>    
         	<tr>    
         		<td><b>Product Price</b></td><td><input type="text" name="prodprice" class="form-control" value="" required></td>  
         	</tr>   
         	<tr>    
          		<td><b>Product Description</b></td><td><input type="text" name="proddesc" class="form-control" value="" required></td>  
         	</tr>   
            <tr>    
         		<td><b>Product Stock</b></td><td><input type="text" name="prodstock" class="form-control" value="" required></td>  
         	</tr>
         	
         	<tr>
         		<td><b>Select Category</b></td>
         		<td><select class="form-control" id="categoryId" name="prodCategory" required>
         		<option value="">--Category--</option>
         		<c:forEach var="cat" items="${clist}">
         		<option value="${cat.categoryId}">${cat.categoryName}</option>
         		</c:forEach>         			
         		</select></td>
         	</tr>
           	<tr>
         		<td><b>Select Supplier</b></td>
         		<td><select class="form-control" name="prodSupplier" required>
         		<option value="">--Supplier--</option>
         		<c:forEach var="sup" items="${slist}">
         		<option value="${sup.supplierId}">${sup.supplierName}</option>
         		</c:forEach>		
         		</select></td>
         	</tr>  
         	<tr>
         		<td><b>Choose Image</b></td><td><input type="file" value="Browse" name="file" required></td>
         	</tr>
        </table><br>
        <div class="form-group">
				<div class="col-sm-6"><button type="submit" class="btn btn-login">Save</button></div>
				<div class="col-sm-6"><button type="reset" class="btn btn-login">Cancel</button></div>
			</div>
        </div>  	
		</form:form>  
	</div>  
						
	</div>
</div>
<div class="col-sm-4 col-sm-offset-5"><a href="${pageContext.request.contextPath}/admin/view" class="button btn btn-login">View All</a></div>
</div>
<br>
	<%@include file="footer.jsp"%>
</body>
</html>
