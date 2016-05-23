<%-- 
    Document   : simple
    Created on : May 21, 2016, 10:59:33 AM
    Author     : yougu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/taglibs.jspf"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Theme resolver demo</title>
        <spring:theme var="stylelink" code="style" text="/css/base.css"/>
        <link rel="stylesheet" type="text/css" href="${CDNHOST}${ctx}${stylelink}">
    </head>
    <body>
        <h1>Spring Theme resolver demo<spring:eval expression="@propertyConfigurer.getProperty('jms.server')" /></h1>
    </body>
</html>
