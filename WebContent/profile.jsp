<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AIR/Profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script>
    $(document).ready(function() {
      $(".menu").click(function() {
        $("ul").slideToggle().toggleClass('active');    
      });
    });
</script>

<style>
* {margin: 0;padding: 0;}    
nav {background: #00316d;width: 100%;}
ul {padding: 0;margin: 0 auto;width: 80%;}
ul li {list-style: none;display: inline-block;padding:20px;}
ul li:hover {background: #e91e63;}
ul li a {color: #fff;text-decoration: none;}
.toggle {width: 100%;padding: 10px 20px;background: #001f44;text-align: right;box-sizing:border-box;color: #fff;font-size: 30px;display:none;}


@media only screen and (max-width: 768px) {
  .toggle {display: block;}
  ul {width: 100%;display: none;}
  ul li {display: block;text-align: center;}
  .active {display: block;}
}

.updated{
background-color: blue;
color: white;
}

.error{
background-color: red;
color: white;
}


</style>
</head>
<body>



	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma","no-cache");
	response.setHeader("Pragma","0");
	%>
	
	
	<div >	
		<nav >
		  <div class="toggle"><i class="fas fa-bars menu"></i></div>
		  <ul >
		    <li><a href="search.jsp" >Search Flights</a></li>
		    <li><a href="search.jsp">Book Flights</a></li>
		    <li><a href="cancel.jsp">Cancel Ticket</a></li>
		    
		    <li><a href="profile.jsp">
		    <% if(session.getAttribute("username")!=null) {%>
				Hi <%=session.getAttribute("username")%> !!
			<%} %>
		    </a></li>
		    <li><a href="logout.jsp">Logout</a></li>
		  </ul>
		  
		</nav>  
</div>

<div class="container" style="margin-left:3%;" >
			<form action="ProfileServlet" method="post" >
				<div class="col-sm-6 col-md-6">
					<div><h3>Edit Profile</h3></div><br>
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
				      <label for="User Name" >User Name:</label>
				      <input type="text" class="form-control" placeholder="Enter user name" name="username" disabled>
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
				 
				     <button type="submit" class="btn btn-primary">Edit Profile</button>
				     
				</div>
				
			</form>
	</div>
	
	<% String error = (String)request.getAttribute("error"); 
 if(error!=null) {%>
 	<p class="error"><%=error %></p>
 <%} %>
 
 	<% String updated = (String)request.getAttribute("updated"); 
 if(updated!=null) {%>
 	<p class="updated"><%=updated %></p>
 <%} %>
</body>
</html>