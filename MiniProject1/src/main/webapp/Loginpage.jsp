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
}
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	ProductDao pDao = new ProductDao(DbCon.getConnection());
	cartProduct= pDao.getCartProducts(cart_list);
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="include/login.css" />
<link rel="stylesheet" href="include/navbar.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />

<title>Login</title>
<style type="text/css">
.heading1{
color: red;
text-align: center;

}
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'sans-serif';
}

header {
	position: fixed;
	display: flex;
	justify-content: space-between;
	align-content: center;
	z-index: 99;
	top: 0;
	left: 0;
	width: 100%;
	padding: 10px;
}
.logoimg {
width:100%;
  position: absolute;
  top:50%;
  left:5%;
  transform: translate(-50%, -20%);
  text-align: center;
}


.logoimg img {
  width:80px;
  border-radius: 50%;
}

.navigation a {
	position: relative;
	font-size: 1.5em;
	color: #fff;
	text-decoration: none;
	font-weight: 500;
	margin-left: 20px;
	padding-top: 15px;
}

.navigation a:hover {
	color: red;
	animation: anim2 500ms cubic-bezier(0.175, 0.885, 0.32, 0.275) infinite;
}

	

footer {
	position: fixed;
	bottom: 0;
	
}

body {
	color: #fff;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 80vh;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
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
.login {
	font-size: 1.2em;
	position: relative;
	height: 450px;
	width: 400px;
	background: transparent;
	border: 2px solid #000;
	border-radius: 30px;
	box-shadow: 0 0 30px rgba(0, 0, 0, .5);
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top:50%;

}

</style>
</head>
<body >
	<%@include file="include/navbar.jsp"%>
	<form method="get" action="Loginpage">
		
		<div class="login">
			<div class="heading">
			<div class="heading1">
			<h3>Login Page</h3>
						</div>
				
				<div class="email">
					<i class="fa-solid fa-envelope"></i> <input type="text"
						placeholder="Enter Email" name="email" > <label>Email</label>
				</div>
				<br>
				<div class="">
					<i class="fa-solid fa-lock"></i> <input type="password"
						placeholder="**********" name="password" > <label>Password</label>
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