<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<f:form action="start.html" method="post" modelAttribute="data">
Firstname:
<f:input type="text" path="firstname"/><br>

Lastname:
<f:input type="text" path="lastname"/><br>

Username:
<f:input type="text" path="vo.username"/><br>

Password:
<f:input type="password" path="vo.password"/><br>

<input type="SUBMIT">

</f:form>


</body>
</html>