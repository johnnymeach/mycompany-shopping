
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Add Credit Card</title>
    </head>
    <body>
        <h1><c:out value="${customer.firstName}"/> <c:out value="${customer.lastName}"/>'s Credit Card</h1>
<form:form action="saveCard.htm" commandName="card">
    <form:hidden path="id" />
    <form:hidden path="customer.id" value="${customer.id}"/>
    <form:hidden path="customer.path"/>
    
    <div class="form-group">
    <label for="cardNo">Card Number</label>
    <input type="text" name="cardNo" class="form-control" id="cardNo" placeholder="Card Number">
  </div>
    <div class="form-group">
    <label for="fullName">Full Name</label>
    <input type="text" name="fullName" class="form-control" id="fullName" placeholder="Full Name">
  </div>
  <div class="form-group">
    <label for="cardCode">Code</label>
    <input type="password" name="cardCode" class="form-control" id="cardCode" placeholder="Code">
  </div>    
  </div>
    <div class="form-group">
    <label for="cardExpiry">Expiry Month</label>
    <input type="text" name="cardExpiry" class="form-control" id="cardExpiry" placeholder="Expiry Month">
  </div>
  
<input class="btn btn-primary" type="submit" value="Add Credit Card"/>    
    
</form:form>
    </body>
</html>
