<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<link rel="stylesheet" href="navi.css" />
<link rel="stylesheet" href="Product.css" />
<title>Product Register</title>
</head>
<body>
	<header>
		<div class="commerce">

			<h1>E-Commerce Shopping</h1>
		</div>
		<nav class="navigation">

			<a href="#">Home</a> <a href="#">Cart</a> <a href="#">Order</a> <a
				href="#">Logout</a> <a href="#">Login</a>

		</nav>
	</header>

	<div class="heading">
	<h2 style="color: green">ProductPage</h2>
		<form action="/MiniProject1/ProductAdd" method="post">
			<table width="400px" align="center" border=1>
				<tr>
					<td align="center" colspan="2">Form Details</td>
				</tr>
			
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Image Link:</td>
					<td><input type="file" name="file"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>

		</form>
		<div class="heading1">
		<br> <a style="color: red" href="viewAll.jsp">View All </a>
		</div>
	</div>
</body>
</html>