<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
   <head>
      <title>c:forEach Tag Example</title>
   </head>

   <body>
      <c:forEach var = "i" begin = "1" end = "5">
         Item <c:out value = "${i}"/><p>
      </c:forEach>
      
       <c:forTokens items = "Zara,nuha,roshy" delims = "," var = "name">
         <c:out value = "${name}"/><p>
      </c:forTokens>
   </body>
</html>