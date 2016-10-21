
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Cart</title>
    </head>
<body>
    <div class="panel panel-default">
    <div class="panel-heading">
      Selected Items   
    </div>
    <table class="table">
        <tr>
            <th>SL.</th>
            <th>Product</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        <c:forEach var="p" items="${cartItems}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${p.itemName}</td>
                    <td>${p.itemQty}</td>
                    <td>${p.amount}</td>
                    <td><button style="height: 28px;" onclick='window.location="<c:url value="/cart/removeItem?itemId=${p.id}"/>";'>Remove</button></td>
                </tr>
         </c:forEach>
         </table>
    </div>
    <button class="btn btn-success" onclick='window.location="<c:url value="/cart/placeOrder"/>";'>Proceed</button>
</body>
</html>
