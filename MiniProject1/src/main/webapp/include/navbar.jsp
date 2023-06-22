
<%@page import="Model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Shopping Cart</title>
<link rel="stylesheet" href="navbar.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<link rel="stylesheet" href="nav.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'sans-serif';
} 
 
header {
	height: 10vh;
	position: fixed;
	display: flex;
	justify-content: space-between;
	align-content: center;
	z-index: 99;
	top: 0;
	left: 0;
	width: 100%;
	padding: 10px;
	background: rgba(0, 0, 0, .1);
}

.commerce {
	color: blue;
	width: 100%;
	position: absolute;
	top: 17px;
	transform: translate(-50%, -20%);
	text-align: center;
	left: 14%;
}

.navigation a {
	top: 10px;
	color: blue;
	position: relative;
	font-size: 1.4em;
	text-decoration: none;
	font-weight: 500;
	margin-left: 20px;
	padding-top: 15px;
	left: 300%;
}

.navigation a:hover {
	color: red;
	animation: anim2 500ms cubic-bezier(0.175, 0.885, 0.32, 0.275) infinite;
}
</style>

</head>
<body>
	<header>
		<div class="commerce">

			<h2>E-Commerce Shopping</h2>
		</div>
		<nav class="navigation">
			<a href="index.jsp">Home</a> <a href="cart.jsp">Cart<span
				class="badge badge-danger" style="background: red">${cart_list.size()}</span></a>
			<%
			if (auth != null) {
			%>

			<a href="order.jsp">Order</a> <a href="Log_out1">Logout</a>
			<%
			} else {
			%>
			<a href="Loginpage.jsp">Login</a>
			<%
			}
			%>
		</nav>
	</header>
</body>
</html>