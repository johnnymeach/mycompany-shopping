
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>product Upload Success</title>
    </head>
    <body>
        <h1>product Upload Success!</h1>
        <c:forEach var="product" items="${allProductList}">
            <c:out value="${product.productName}"/> 
        </c:forEach>
    </body>
</html>
