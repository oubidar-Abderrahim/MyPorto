<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Confirmation</title>
</head>

<body>

	<h1>Welcome ${student.firstName} ${student.lastName} from
		${student.country}</h1>
	<h2> Favorite Language : ${student.favoriteLanguage}</h2>
	<p>
		Used OS : <ul>
						<c:forEach var="temp" items="${student.operatingSystem}" >
							<li> ${temp} </li>
						</c:forEach>
				  </ul>
		<br />
	</p>

</body>

</html>