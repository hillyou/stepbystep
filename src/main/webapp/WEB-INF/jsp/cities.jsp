<%-- 
    Document   : cities
    Created on : Oct 23, 2014, 2:28:35 PM
    Author     : Colin.You
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../jspf/taglibs.jspf"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="${ctx}/js/base.js"></script>
        <link href="${ctx}/css/base.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>CITIES</title>
    </head>
    <body>
        <h1>Session ID:${cookie.JSESSIONID.value}</h1>

        <hr>
        <img src="${ctx}/images/test.jpeg" alt="test image"/>
        <hr>
        <div class="container">
            <div class="row">
                <c:choose>
                    <c:when test="${empty cities}">
                        <div>${response.message}</div>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="city" items="${cities}">
                            <div class="col-sm-2">${city.cityId}</div>
                            <div class="col-sm-2">${city.cityName}</div>
                            <div class="col-sm-2">${city.country}</div>
                            <div class="col-sm-2">${city.airport}</div>
                            <div class="col-sm-2">${city.language}</div>
                            <div class="col-sm-2">${city.countryISOCode}</div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

    </body>
</html>
