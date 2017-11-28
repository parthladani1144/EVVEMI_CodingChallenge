<%-- 
    Document   : readData
    Created on : Nov 28, 2017, 12:26:47 PM
    Author     : ParthLadani
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            
            RequestDispatcher rd=request.getRequestDispatcher("readData");
              rd.include(request, response);
        %>
    </body>
</html>
