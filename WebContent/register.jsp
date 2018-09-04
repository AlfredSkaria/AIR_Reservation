<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AIR/Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.error{
		background-color:red;
  		color:white;
  		font-size: 20px;
  	}
  </style>
</head>
<body>

<div>
<h1 align="center">AIR TICKET RESERVATION</h1>
<% String error = (String)request.getAttribute("error"); 
 if(error!=null) {%>
 	<p align="center" class="error"><%=error %></p>
 <%} %>

</div>


<div class="container" style="margin-left:3%;" >
			<form action="Register" method="post" >
				<div class="col-sm-6 col-md-6">
					<div><h3>Registration</h3></div><br>
					<div class="form-group">
				      <label for="Name">Name:</label>
				      <input type="text" class="form-control" placeholder="Enter name" name="name">
				     </div>
				     <div class="form-group">
				      <label for="Mobile">Mobile Number:</label>
				      <input type="tel" class="form-control"  placeholder="Enter mobile number" name="phno">
				     </div>
				     <div class="form-group">
				      <label for="email">Email:</label>
				      <input type="email" class="form-control"  placeholder="Enter email" name="mail">
				     </div>
				     <div class="form-group">
				      <label for="User Name">User Name:</label>
				      <input type="text" class="form-control" placeholder="Enter user name" name="username">
				     </div>
				     <div class="form-group">
				      <label for="pwd">Password:</label>
				      <input type="password" class="form-control" placeholder="Enter password" name="pass">
				     </div>
					 
				     
				     <label for="gender">Gender:</label><br>
				  
				      <label class="radio-inline"><input type="radio" name="gender" value="male">Male</label>
				     
				     
				      <label class="radio-inline"><input type="radio" name="gender" value="female">Female</label>
				     
				     
				      <label class="radio-inline"><input type="radio" name="gender" value="other">Other</label><br>
				     
				     
					     <br><div class="form-group">
					    	<label for="inputCity">City</label>
					    	<select id="city" name="city" class="form">
					    		<option value="delhi">Delhi</option>
					    		<option value="trivandrum">Trivandrum</option>
					    		<option value="alappuzha">Alappuzha</option>
					    		<option value="jaipur">Jaipur</option>
					    		<option value="thrissur">Thrissur</option>
					    		<option value="mumbai">Mumbai</option>
					    		<option value="chennai">chennai</option>
					    		<option value="punjab">Punjab</option>
					    		<option value="lucknow">Lucknow</option>
					    		<option value="bangalore">Bangalore</option>
					    	</select>
					    </div>
				 
				     <button type="submit" class="btn btn-primary">Register</button>
				     <p><br><a href="login.jsp">Already Registered?Please Login</a></p>
				</div>
				
			</form>
			</div>
</body>
</html>