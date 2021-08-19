<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Home</title>
</head>
<body>
Home page

	<nav class="navbar navbar-light bg-light justify-content-between">
  <a class="navbar-brand">Home Page</a>
  <form action="search" method="get" class="form-inline">
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="eid" value="${param.eid}">
    <button class="btn btn-outline-success my-2 my-sm-0" 
    value="search" type="submit">Search</button>
  </form>
</nav>

<!--  	<table class="table">
  <thead class="thead-light">
    <tr>      
      <th scope="col">EID</th>
      <th scope="col">FNAME</th>
      <th scope="col">LNAME</th>
      <th scope="col">GENDER</th>
      <th scope="col">EMAIL</th>
      <th colspan="2">ACTION</th>
    </tr>
  </thead>
  <tbody>
     <c:forEach var="employee" items="${elist}">
    <tr>
    	<td><c:out value="${employee.eid}"></c:out></td>
      	<td><c:out value="${employee.fname}"></c:out></td>
      	<td><c:out value="${employee.lname}"></c:out></td>
      	<td><c:out value="${employee.gender}"></c:out></td>
      	<td><c:out value="${employee.email}"></c:out></td>
      		<td><a href="edit?eid=${employee.eid}&fname=${employee.fname}&lname=${employee.lname}&gender=${employee.gender}&email=${employee.email}">Edit</a></td>
      	<td><a href="delete?eid=${employee.eid}">Delete</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>-->
	
</body>
</html>