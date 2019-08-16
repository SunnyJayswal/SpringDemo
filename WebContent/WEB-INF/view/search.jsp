<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%


%>

<table border="1 px solid black">
<tr>
<td>ID</td>
<td>Firstname</td>
<td>Lastname</td>
</tr>

<c:forEach items="${list}" var="i">
<tr>
<td>${i.id}</td>
<td>${i.firstname}</td>
<td>${i.lastname}</td>
<td><a href="editentry.html?id=${i.id}">Edit</a></td>
<td><a href="deleteentry.html?id=${i.id}">Delete</a></td>
</tr>
</c:forEach>
</body>
</html>