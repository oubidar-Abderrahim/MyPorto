<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Menu</title>
</head>

<body>
	<h1>SpringMVC - Home Page</h1>
	<hr />
	<br />
	<br />
	<a href="hello/showForm">Hello World Form</a>
	<br />
	<a href="student/showForm">Student Form</a>
	<br />
	<a href="customer/showForm">Customer Form</a>
	<br />
	<br />
	<img alt="nothing"
		src="${pageContext.request.contextPath}/Assets/img/oor.PNG">
</body>
</html>
