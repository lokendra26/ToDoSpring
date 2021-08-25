<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="updateuser" method="get">
		<div class="form-row">

			<div class="form-group">
				<label for="lbluname">User Name </label> <input type="text"
					class="form-control" id="lbluname" name="userName"
					value="${param.userName}">

			</div>
			<div class="form-group">
				<label for="lblphn">Phone Number </label> <input type="text"
					class="form-control" id="lblphn" name="phoneNumber"
					value="${param.phoneNumber}">

			</div>

			<div class="form-group">
				<label for="lblemail">Email</label> <input type="email"
					class="form-control" id="lblemail" name="emailId"
					value="${param.emailId}" placeholder="Enter Email"
					readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="lblpwd">Password </label> <input type="text"
					class="form-control" id="lblpwd" name="password"
					value="${param.password}">

			</div>
		</div>
		<button type="submit" value="updateuser" class="btn btn-primary">UPDATE
			EMPLOYEE</button>

	</form>

</body>
</html>