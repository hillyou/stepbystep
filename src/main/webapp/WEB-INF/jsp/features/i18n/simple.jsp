<%-- 
    Document   : simple
    Created on : May 21, 2016, 9:06:22 PM
    Author     : yougu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/taglibs.jspf"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <spring:message var="pageTitle" scope="application" code="test.title" text="default title"></spring:message>
        <title>${pageTitle}</title>
    </head>
    <body>
        <h1>A Page for demo spring in18</h1>
        <h1>${pageTitle}</h1>
    </body>
</html>
