
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Vendor Registration Submit Page</title>
    </head>
    <body>
    <c:if test="${vendorRegStatus == 'vendor exists'}">   
        <h1>Vendor already registered at My Company!</h1>
    </c:if>    
    <c:if test="${vendorRegStatus == 'not authorized vendor'}">   
        <h1>Vendor is not registered in USA!</h1>
    </c:if>   
    <c:if test="${vendorRegStatus == null}">   
        <h1>Vendor Registration Successful!</h1>
    </c:if>
        ${vendor.vendor_name}
    </body>
</html>
