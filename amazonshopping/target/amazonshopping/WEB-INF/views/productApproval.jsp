

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Product Approval</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
    
    <script src="./resources/js/jquery.js"></script>
    
    <script src="./resources/js/bootstrap.js"></script>
    
    <script>
        function onApproval(productId) {
          
            var Eid = $("#Eid").html();
            var Tid = "#Tid" + productId;
            var Bid = "#Bid" + productId;
            $.ajax({
               
                url:"product/productStatusChange/" + productId,
                type:'PUT',
                success:function(data) {
                    $(Tid).text("Approved!");
                    $(Tid).css({"color":"blue", "font-weight":"bold"});
                    alert(data);
                    window.location.reload();
                }
            });
        }
        
        function disApproval(productId) {
            var Tid = "#Tid" + productId;
            $.ajax({
               
                url: "product/productDisapproval/" + productId,
                type:'PUT',
                
                success:function(data) {
                    $(Tid).text("Disapproved!");
                    $(Tid).css({"color":"red", "font-weight":"bold"}); 
                    alert(data);
                    window.location.reload();
                }
            });
            
        }
        
    </script>
</head>

<body>
    

    

    <div class="container">
        <div class="page-header">
            <h3 class="text-center">Products who need you approve!</h3></div>
        <p style="color: red; font-weight: bold">PS: Once you approval the product, the product status can not be changed again!</p>    
        <table border="1px" width="1000px">
            <tr align="center" style="font-weight: bold;">
                <td>Product Id</td>
                <td>Product Name</td>
                <td>Price</td>
                <td>Quantity</td>
                <td>Category</td>
                <td>Vendor Name</td>
                <td>Brand</td>
                <td>Image URL</td>
                <td>Product Details</td>
                <td>Operation</td>
            </tr>
            <c:forEach var="product" items="${products}" varStatus="productIndex">
                <tr align="center">
                    <td>${product.productId}</td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td>${product.category}</td>
                    <td>${product.vendorName}</td>
                    <td>${product.brand}</td>
                    <td>${product.imageUrl}</td>
                    <td>${product.productDetails}</td>
                    <td id="Tid${productIndex.count}">
                        <%-- //status has three attributes: '0' means need to approve, '1' means approved, '2' means disapprove --%>
                        <c:choose>
                            <c:when test="${product.status eq '0'}">
                                <button id="Bid1${productIndex.count}" onclick="onApproval(${product.productId})">Approval</button>
                                &nbsp;&nbsp;
                                <button id="Bid2${productIndex.count}" onclick="disApproval(${product.productId})">Disapproval</button>
                            </c:when>
                            <c:when test="${product.status eq '1'}">
                                <p style="color: blue;font-weight: bold">Approved!</p>
                            </c:when>
                            <c:when test="${product.status eq '2'}">
                                <p style="color:red;font-weight: bold">Disapproved!</p>
                            </c:when>
                        </c:choose>
                        
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>

</html>