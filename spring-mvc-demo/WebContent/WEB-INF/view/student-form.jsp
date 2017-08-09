
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Form</title>
</head>

<body>
 <p>
	<form:form action="processStudentForm" modelAttribute="student">	
		First name : <form:input path="firstName" />
		<br />
		<br />
		Last name  : <form:input path="lastName" />
		<br />
		<br />
		Country : <form:select path="country">
			<!--  <form:option value="Germany" label="Germany" />
				  		<form:option value="Japan"   label="Japan"   />
				  		<form:option value="Morocco" label="Morocco" />
				  		<form:option value="Russia"  label="Russia"  />		-->
						<form:options items="${theCountries}" />
				  </form:select>
		<br />
		<br />
		Favorite Language: <br />
		Java : <form:radiobutton path="favoriteLanguage" value="Java" />
		C#   : <form:radiobutton path="favoriteLanguage" value="C#" />
		PHP  : <form:radiobutton path="favoriteLanguage" value="PHP" />
		Ruby : <form:radiobutton path="favoriteLanguage" value="Ruby" />
		<br />
		<br />
		Operating System you used: <br />
		Linux   <form:checkbox path="operatingSystem" value="Linux" /> <br />
		Mac OS  <form:checkbox path="operatingSystem" value="Mac OS" /> <br />
		Windows <form:checkbox path="operatingSystem" value="Windows" /> <br />
		<input type="submit" value="Submit" />
	</form:form>
 </p>
</body>
</html>