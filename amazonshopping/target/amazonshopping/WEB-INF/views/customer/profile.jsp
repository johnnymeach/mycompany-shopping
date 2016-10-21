
<%@page contentType="text/html" pageEncoding="windows-1252"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Profile</title>
    </head>
    <body>
        <table class="table" style="width:500px;">
            
            <tr>
                <th>First Name : </th>
                <td>${customer.firstName}</td>
        </tr>
        <tr>        
            <th>Last Name : </th>
                <td>${customer.lastName}</td>
        </tr>
        <tr>        
                <th>Email/Username : </th>
                <td>${customer.email}</td>
        </tr>
        <tr>        
            <th>Member Since : </th>
                <td>${customer.createTime}</td>
        </tr>
            
        </table>
        
    
  <div class="panel panel-default">
  <div class="panel-heading">
      Credit Card <button onclick='window.location="<c:url value="/customer/addCard"/>";'>Add</button>  
  </div>
    <table class="table">
        <tr>
            <th>SL</th>
            <th>Card Number</th>
            <th>Status</th>
        </tr>
        
        <c:forEach var="card" items="${customer.cardList}" varStatus="status">
            <tr>
                    <td>${status.index + 1}</td>
                    <td>${card.cardNo}</td>
                    <td><c:if test="${card.enabled == true}">Default</c:if></td>
                    
            </tr>
            
        </c:forEach>
    </table>
</div>  
        
        
<div class="panel panel-default">
  <div class="panel-heading">
      Shipping Address <button onclick='window.location="<c:url value="/customer/addAddress?addressType=0"/>";'>Add</button>
  </div>
    <table class="table">
        <tr>
            <th>Address</th>
            <th>City</th>
            <th>State</th>
            <th>ZIP</th>
        </tr>
        
      <c:forEach var="address" items="${customer.addressList}" varStatus="status">
            <c:if test="${address.addressType == 0}">
                <tr>
                    <td>${address.addressLine1}</td>
                    <td>${address.city}</td>
                    <td>${address.stateName}</td>
                    <td>${address.zipCode}</td>
                </tr>
            </c:if>
        </c:forEach>
      
  </table>
</div>  

  <div class="panel panel-default">
  <div class="panel-heading">
      Billing Address <button onclick='window.location="<c:url value="/customer/addAddress?addressType=1"/>";'>Add</button>
  </div>
    <table class="table">
        <tr>
            <th>Address</th>
            <th>City</th>
            <th>State</th>
            <th>ZIP</th>
        </tr>
        <c:forEach var="address" items="${customer.addressList}" varStatus="status">
            <c:if test="${address.addressType == 1}">
                <tr>
                    <td>${address.addressLine1}</td>
                    <td>${address.city}</td>
                    <td>${address.stateName}</td>
                    <td>${address.zipCode}</td>
                </tr>
            </c:if>
        </c:forEach>
  </table>
</div>  

  <div class="panel panel-default">
  <div class="panel-heading">
      Transaction History
  </div>
    <table class="table">
        <tr>
            <th>Date</th>
            <th>Transaction#</th>
            <th>Amount</th>
        </tr>
        
        <c:forEach var="tran" items="${customer.tranList}" varStatus="status">
            <tr>
                    <td>${tran.createTime}</td>
                    <td>${tran.id}</td>
                    <td>${tran.amount}</td>
                    
            </tr>
            
        </c:forEach>
    </table>
</div>  

    </body>
</html>
