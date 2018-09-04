<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AIR/Flights</title>
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

.empty{
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

</body>
</html>