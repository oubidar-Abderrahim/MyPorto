
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
   <head>
      <title>c:if Tag Example</title>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   </head>

   <body>
 <c:url value = "/index.jsp" var = "myURL">
   <c:param name = "trackingId" value = "1234"/>
   <c:param name = "reportType" value = "summary"/>
</c:url>
	<c:import url = "${myURL}"/>
   </body>
</html>