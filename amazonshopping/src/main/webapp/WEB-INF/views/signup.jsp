
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
        
<form:form action="signup" commandName="customer">
    
    <div class="form-group">
    <label for="firstName">First Name</label>
    <input type="text" name="firstName" class="form-control" id="firstName" placeholder="First Name">
  </div>
    <div class="form-group">
    <label for="lastName">Last Name</label>
    <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Last Name">
  </div>
    
    <div class="form-group">
    <label for="email">Email/Username</label>
    <input type="text" name="email" class="form-control" id="email" placeholder="Email or Username">
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" name="password" class="form-control" id="password" placeholder="Password">
  </div>    
<input type="submit" class="btn btn-primary" value="<spring:message text="Register"/>" />
    
    <c:if test="${!empty customer.lastName}">
        <form:input path="id" readonly="true" size="8"  disabled="true" />
        <form:hidden path="id" />
    </c:if>
      
    
</form:form>

</body>
</html>
