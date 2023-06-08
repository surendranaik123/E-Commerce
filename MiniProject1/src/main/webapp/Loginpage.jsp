<%@page import="Dao.*"%>
<%@page import="Model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="include/login.css" />
<link rel="stylesheet" href="include/navbar.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />

<title>Login</title>
<style type="text/css">
.heading1{
color: red;
text-align: center;

}

</style>
</head>
<body >
<%@include file="include/navbar.jsp" %>
	<form method="post" action="Loginpage">
		
		<div class="login">
			<div class="heading">
			<div class="heading1">
			<h3>Login Page</h3>
						</div>
				
				<div class="email">
					<i class="fa-solid fa-envelope"></i> <input type="text"
						placeholder="Enter Email" name="email" required> <label>Email</label>
				</div>
				<br>
				<div class="">
					<i class="fa-solid fa-lock"></i> <input type="password"
						placeholder="Enter Password" name="password" required> <label>Password</label>
				</div>
				<br>
				<div class="remember-forgot ">
					<input type="checkbox" checked="checked">Remember me<a
						href="Forgotpassword.html">Forgot password?</a>
				</div>
				<br>
				<div>
					<button class="button">Login</button>
				</div>
				<br>
				<div class="">
					<label>Or login with</label>
					 <a href="Home.html"
							class="fa-brands fa-square-facebook"></a> <a
							href="Home.html"
							class="fa-brands fa-square-twitter"></a> <a
							href="Home.html" class="fa-brands fa-google"></a> 
				</div>
				<br>
				<p>
					Don't have account?<a href="Register.jsp">Registration</a>
				</p>
				<br>
			</div>
			</div>

	</form>
</body>
</html>