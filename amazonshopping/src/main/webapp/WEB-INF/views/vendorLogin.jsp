
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Vendor Log In Page</title>
        <style>
            #login-box {
                width: 400px;
                margin-left: 150px;
            }
            .form-group {
                width: 200px;
            }
        </style>
    </head>
    <body>
    <c:if test="${vendor != null}">
        <h1>You are already logged In!</h1>
    </c:if>
    <c:if test="${vendor == null}">
        <div id="login-box">
		<h3>Login with username and password</h3>
        <form:form method="POST" action="/amazonshopping/loginVendor">
            <div class="form-group">
                <form:label path="vendor_name">User Name</form:label>
                <form:input class="form-control" path="vendor_name" />
            </div>
            <div class="form-group">
                <form:label path="password">Password</form:label>
                <form:password class="form-control" path="password" />
            </div>
            <div>
                 <input class="btn btn-primary" type="submit" value="Submit"/>
            </div>
            </table>  
        </form:form>
    </div>     
    </c:if>        
</body>
</html>
