<%@ page import="java.util.Calendar" %>
<html>
<head>
    <title>Demo Scripting Tags</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            text-align: center;
            color: #2c3e50;
        }
        .section {
            margin-top: 15px;
            padding: 10px;
            background-color: #f4f4f4;
            border-radius: 5px;
        }
        .label {
            font-weight: bold;
            color: #34495e;
        }
        .tag-title {
            font-size: 1.1em;
            font-weight: bold;
            color: #8e44ad;
            margin-bottom: 5px;
        }
        hr {
            border: none;
            border-top: 1px solid #ccc;
            margin: 10px 0;
        }
    </style>
</head>
<body>

    <h1>Demo Scripting Tags</h1>

   <%-- ========================= --%>
	<%-- Scriptlet Tag: <% ... %> --%>
	<%-- ========================= --%>
    <div class="section">
        <div class="tag-title">Scriptlet Tag (`&lt;% ... %&gt;`)</div>
        <p>Used to write Java code inside a JSP page. Runs when the page is requested, and can contain any valid Java statements.</p>
        <hr>
        <% out.print("Welcome to JSP<br/>"); %>

        <% 
            String name = request.getParameter("uname");
            out.print("Welcome to: " + (name != null ? name : "Guest"));
        %>
    </div>
	<%-- ========================= --%>
	<%-- Expression Tag:: 
	<%-- ========================= --%>
   
    <div class="section">
        <div class="tag-title">Expression Tag (`&lt;%= ... %&gt;`)</div>
        <p>Outputs the result of a Java expression directly into the HTML response. No need to use <code>out.print()</code>.</p>
        <hr>
        <%= "Hello, welcome to Java class<br/>" %>
        <span class="label">Current Time:</span> 
        <%= Calendar.getInstance().getTime() %>
    </div>

    <!-- ========================= -->
    <!-- Another Expression Example -->
    <!-- ========================= -->
    <div class="section">
        <div class="tag-title">Expression Tag Example with Parameter</div>
        <p>Here we output a request parameter directly, with a null check to avoid printing "null".</p>
        <hr>
        <%= "Hello, welcome to: " + (request.getParameter("uname") != null ? request.getParameter("uname") : "Guest") %>
    </div>

    <%-- ========================= --%>
	<%-- Declaration Tag:: 
	<%-- ========================= --%>
    <div class="section">
        <div class="tag-title">Declaration Tag (`&lt;%! ... %&gt;`)</div>
        <p>Used to declare methods or variables that become part of the generated servlet class. These are shared across requests.</p>
        <hr>
        <%! 
            int cube(int n) {
                return n * n * n;
            }
        %>

        <!-- Using the declared method -->
        <%= "The cube of 5 is: " + cube(5) %>
    </div>

</body>
</html>
