
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MUM Online Shopping</title>
    </head>
    <body>
        <h1>Register</h1>
        
<form:form action="save.htm" commandName="customer">
<table>
    <c:if test="${!empty customer.lastName}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="firstName">
                <spring:message text="First Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="firstName" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="lastName">
                <spring:message text="Last Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="lastName" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="email">
                <spring:message text="Email/Username"/>
            </form:label>
        </td>
        <td>
            <form:input path="email" />
        </td> 
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty customer.lastName}">
                <input type="submit"
                    value="<spring:message text="Edit Customer"/>" />
            </c:if>
            <c:if test="${empty customer.lastName}">
                <input type="submit"
                    value="<spring:message text="Add Customer"/>" />
            </c:if>
        </td>
    </tr>
</table>  
</form:form>

</body>
</html>
