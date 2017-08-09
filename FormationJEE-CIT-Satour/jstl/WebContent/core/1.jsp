<%-- <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %> --%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
  <head>
    <title>Exemple</title>
  </head>


   <body>
      <c:set var = "salary" scope = "session" value = "${5 lt 7}" />
      <p>Before Remove Value: <c:out value = "${salary}"/></p>
      ${salary}
         <c:remove var = "salary" />
      <p>After Remove Value: <c:out value = "${salary}"/></p>
   </body>
</html>