<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.println("Hello");
	%>
	
	<c:out value = "${'<tag> , &'}"/>
	<c:out value ="Hello"/>
	
	<c:forEach var = "i" begin = "1" end = "5">
         Item <c:out value = "${i}"/><p>
    </c:forEach>
    
    <%
    	for(int i=1;i<5;i++)
    	{
    		out.println("<p>Item"+i+"</p>");
    	}
    %>
    
     <c:forTokens items = "Zara,nuha,roshy" delims = "," var = "name">
         <c:out value = "${name}"/><p>
      </c:forTokens>
      
</body>
</html>
