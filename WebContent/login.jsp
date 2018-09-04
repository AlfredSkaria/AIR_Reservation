<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AIR/Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
.error{
		background-color:red;
  		color:white;
  		font-size: 20px;
  	}
  </style>

<body>

<div>

<% String error = (String)request.getAttribute("error"); 
 if(error!=null) {%>
 	<p align="center" class="error"><%=error %></p>
 <%} %>
 
 <% String loginerror = (String)request.getAttribute("loginerror"); 
 if(loginerror!=null) {%>
 	<p align="center" class="error"><%=loginerror %></p>
 <%} %>
</div>

<div style="margin-left:3%;" >
	<form action="LoginServlet" method="post">
		<div class="col-sm-6 col-md-6">
			<div><h2>Login</h2>
			</div><br>
					<div class="form-group">
				      <label for="User Name">User Name:</label>
				      <input type="text" class="form-control" placeholder="Enter user name" name="username">
				     </div>
				     <div class="form-group">
				      <label for="pwd">Password:</label>
				      <input type="password" class="form-control" placeholder="Enter password" name="pass">
				     </div>
				     <button type="submit" class="btn btn-primary">Login</button>
				     <h3><a href="register.jsp">Register Now</a></h3>
		</div>
		
	</form>	
</div>


</body>
</html>