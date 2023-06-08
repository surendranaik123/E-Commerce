
<%@page import="Dao.*"%>
<%@page import="Model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Register.css" />
<link rel="stylesheet" href="include/navbar.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />

<title>Register Page</title>
<style type="text/css">
.Register{
padding-left:45px;
font-size: 1.030em;
height: 570px;
}
.heading1{

padding-left:40px;

}

</style>
</head>
<body>
	<%@include file="include/navbar.jsp"%>
	<form method="post" action="Register">

		<div class="Register">
			<div class="container">
				<div class="heading1">
					<h3 style="color:red">Registration Page</h3>
				</div>

				<div>
					<i class="fa-solid fa-user"></i> <input type="text" name="name"
						id="name"><label for="name">Name</label>
				</div>
				<br>
				<div>
					<i class="fa-solid fa-envelope"></i> <input type="text"
						name="email" id="email"><label for="email">Email</label>
				</div>
				<br>
				<div>
					<i class="fa-solid fa-lock"></i> <input type="password"
						name="password" id="password"><label for="password">Password</label>
				</div>
				<br>
				<div>
					<i class="fa-solid fa-phone-volume"></i> <input type="number"
						name="phone" id="phoneNumber"><label for="phoneNumber">Phone
						Number</label>
				</div>
				<br>
				<div>
					<i class="fa-solid fa-transgender"></i> <label for="gender">Gender:</label>
					Male: <input type="radio" name="gender" value="male">
					Female: <input type="radio" name="gender" value="female">
					Other: <input type="radio" name="gender" value="other">
				</div>
				<br>
				<div>
					<i class="fa-solid fa-language"></i> <select name="language"
						id="language">
						<option value="">Select language</option>
						<option value="English">English</option>
						<option value="Spanish">Telugu</option>
						<option value="Hindi">Hindi</option>
						<option value="Arabic">Arabic</option>
						<option value="Russian">Russian</option>
					</select> <label for="language">language</label>
				</div>
				<br>
				<div>
					<i class="fa-solid fa-location-dot"></i> <input type="text"
						name="address" id="address" placeholder="Write you address">
					<label for="address">Address</label>
				</div>
				<br>
				<div>
					<i class="fa-solid fa-house"></i> <input type="number"
						name="zipcode" id="zipcode"> <label for="zipcode">Zip
						Code</label>
				</div>
				<br>
				<div>
					<input type="submit" class="button" value="Register" />

				</div>
				<br>
				<div>
				<h5>You have account?<a href="Loginpage.jsp">Login</a></h5>	
				</div>

			</div>
		</div>
	</form>
</body>
</html>