<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "java.io.*,java.util.*" %>

<%
    String x = request.getParameter("input1");
    String y = request.getParameter("input2");
    String result = "";
    
    if (x != null && y != null ) {
        try {
            int sum = Integer.parseInt(x) + Integer.parseInt(y);
            result = String.valueOf(sum);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sum</title>
</head>
<body>
    <form method="post">
        <h1>Hello World</h1>
        <input type="text" name="input1" value="<%= x != null ? x : "" %>"><br/><br/>
        <input type="text" name="input2" value="<%= y != null ? y : "" %>"><br/><br/>
        <input type="text" name="output" value="<%= result %>"><br/><br/>
        <input type="submit" name="submit" value="Submit">
    </form>
</body>
</html>
