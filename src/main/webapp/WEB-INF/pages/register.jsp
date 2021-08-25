<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"/>

<title>Register here</title>
</head>
<body>
	<h1>Welcome...!!!</h1>

	<a href="loginpage">Login here</a>
	<fieldset>
	
	<form action="adduser" method="post">
		<div class="form-row">

			<div class="form-group">
				<label for="lblname"> Name </label> 
				<input type="text" class="form-control" id="lblname" name="txtname"
					placeholder="Enter Name">
			</div>
			
			
			<div class="form-group">
				<label for="lblemail">Email</label> 
				<input type="email" class="form-control" id="lblemail" name="txtemail"
					placeholder="Enter Email">
			</div>
			<div class="form-group">
				<label for="lblpwd">Password </label> 
				<input type="password" class="form-control" id="lblpwd" name="txtpwd"
					placeholder="Enter password">
			</div>
			<div class="form-group">
				<label for="lblphn">Phone Number </label> 
				<input type="number" class="form-control" id="lblphn" name="txtphn"
					placeholder="Enter phone number">
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Sign-up</button>
	
	</form>

	</fieldset>

</body>
</html>