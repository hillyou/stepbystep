<%-- 
    Document   : model
    Created on : Apr 29, 2016, 12:30:28 PM
    Author     : Colin_You
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Enumeration<String> names = request.getAttributeNames();
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                out.println("<br>"+name + " <> " + request.getAttribute(name));
            }
        %>
    </body>
</html>
