<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="connection.DbCon"%>
<%@page import="Model.Product"%>
<%@page import="servlet.*"%>
<%@page import="servlet.ProductManual"%>
<%@page import="connection.*"%>
<%@page import="Dao.ProductDao"%>
<%@page import="Model.*"%>
<%
ProductDao pd=new ProductDao(DbCon.getConnection());
List<Product> products=pd.getAllProducts();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="include/navbar.css" />
<title>Home Page</title>
<style>
body {
	padding-top: 5%;
	height: 80vh;
	text-align: center;
	align-items: center;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

.row {
	padding: 10px;
	display: flex;
}

.column {
	
}

.container {
	background: pink;
}

.img {
	width: Auto;
}
</style>
</head>
<body>
	<%@include file="include/navbar.jsp"%>
	<h2>All Products</h2>
	<div class="row">
	<%
	if(!products.isEmpty()){
		
	for(Product p:products){
	
	%>
		<div class="col-md-2">

			<div class=" card w-100">

				<img class="card-img-top" src="image/<%=p.getImage() %>" alt="Card image cap">
				<h5 class="card-title">Name:<%=p.getName() %></h5>
				<h5 class="price">Price:$<%=p.getPrice() %></h5>
				<h6 class="category">Category:<%=p.getCategory() %></h6>
				<div class="mt-3 d-flex justify-content-between">
					<a class="btn btn-dark" href="Add_To_CartPage?id=<%=p.getId()%>">Add to Cart</a>
					 <a class="btn btn-primary" href="Add_To_Cart">Buy Now</a>
				</div>
				<br>

			</div>
			
		</div>

	<%	
	}
		
	}else{
		out.println("There is no Products");
		
	} 
	
	%>
	
	</div>

	<%@include file="/include/footer.jsp"%>
</body>
</html>