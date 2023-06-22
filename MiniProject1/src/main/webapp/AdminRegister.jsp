<%@page import="Model.*"%>
<%@page import="connection.DbCon"%>
<%@page import="Dao.ProductDao"%>
<%@page import="servlet.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="include/navbar.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<title>Admin Page</title>
<style>
.register {
margin-top:10%;
	font-size: 1.3em;
	border: 2px solid #000;
	margin-left:40%;
	height: 400px;
	width: 450px;
    border-radius: 30px;
	box-shadow: 0 0 30px rgba(0, 0, 0, .5);
	justify-content: center;
	align-items: center;
	padding-left: 30px;
	padding-top: 20px;

}

.button{
	
	height:40px;
	width:100px;
	font-size: 1.3em;
	position: relative;
	background: transparent;
	border: 2px solid #000;
	border-radius: 10px;
	box-shadow: 0 0 30px rgba(0, 0, 0, .5);
	
}
.button:hover{
	color:red;
	height:40px;
	width:100px;
	font-size: 1.3em;
	position: relative;
	background: transparent;
	border: 2px solid red;
	border-radius: 10px;
	
}
.heading1 {
color: red;
font-size: 1.5em;
padding-left: 50px;
}


</style>
</head>
<body>
<%@include file="/include/navbar.jsp" %>
	<form method="post" action="AdminRegister">

		<div class="register">
			<div class="heading">
				<div class="heading1">
					<h3>Admin Register Page</h3>
				</div>
				<div class="name">
					<i class="fa-solid fa-envelope"></i> <input type="text"
						placeholder="Enter AdminName" name="name"> <label>Admin Name</label>
				</div>
				<br>

				<div class="email">
					<i class="fa-solid fa-envelope"></i> <input type="text"
						placeholder="Enter Email" name="email"> <label>Email</label>
				</div>
				<br>
				<div class="">
					<i class="fa-solid fa-lock"></i> <input type="password"
						placeholder="********" name="password"> <label>Password</label>
				</div>
				<br>
			
				<div>
					<button class="button">Submit</button>
				</div>
                <br>
				<p>
					U have already account?<a href="Admin.jsp">Admin Login</a>
				</p>
				<br>
			</div>
		</div>

	</form>
</body>
</html>