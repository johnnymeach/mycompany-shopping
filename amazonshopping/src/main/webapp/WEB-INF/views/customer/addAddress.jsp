
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Add Address</title>
    </head>
    <body>
        <h1><c:out value="${customer.firstName}"/> <c:out value="${customer.lastName}"/>'s Address</h1>
<form:form action="saveAddress.htm" commandName="address">
    <form:hidden path="id" />
    <form:hidden path="customer.id" value="${customer.id}"/>
    <form:hidden path="addressType"/>
    <form:hidden path="customer.path"/>
<div class="form-group">
    <label for="addressLine1">Address:</label>
    <input type="text" name="addressLine1" class="form-control" id="addressLine1" placeholder="Street number and Apertment number">
  </div>
 <div class="form-group">
    <label for="city">City</label>
    <input type="text" name="city" class="form-control" id="city" placeholder="City name">
  </div>    
 <div class="form-group">
    <label for="stateName">State</label>
    <input type="text" name="stateName" class="form-control" id="stateName" placeholder="State">
  </div>    
 <div class="form-group">
    <label for="zipCode">ZIP</label>
    <input type="text" name="zipCode" class="form-control" id="zipCode" placeholder="ZIP">
  </div>    
 
<input class="btn btn-primary" type="submit" value="Add Customer Address"/>
  
</form:form>

    </body>
</html>
