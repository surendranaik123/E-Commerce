<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/MiniProject1/A" method="post">
		<div class="login">
			<div class="heading">
				<div class="heading1">
					<h3>Admin Login Page</h3>
				</div>

				<div class="email">
					<i class="fa-solid fa-envelope"></i> <input type="text"
						placeholder="Enter Email" name="email"> <label>Email</label>
				</div>
				<br>
				<div class="">
					<i class="fa-solid fa-lock"></i> <input type="password"
						placeholder="**********" name="password"> <label>Password</label>
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
				<p>
					Don't have account?<a href="AdminRegister.jsp">Registration</a>
				</p>
				<br>
			</div>
		</div>

	</form>
</body>
</html>