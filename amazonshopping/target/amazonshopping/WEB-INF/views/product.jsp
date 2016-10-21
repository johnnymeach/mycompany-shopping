<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Upload Page</title>
</head>
<body>
    <c:if test="${vendor != null}">
    <h2>Hello, ${vendorName}</h2>
    Please <a href="productUpload.xhtml">Click Here</a> to Upload Product
    </c:if>
    <c:if test="${vendor == null}">
        Please <a href="vendorLogin">Log In</a> with registered vendor account in order to upload product
    </c:if>
</body>
</html>
