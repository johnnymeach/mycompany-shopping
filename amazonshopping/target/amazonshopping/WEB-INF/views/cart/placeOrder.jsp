
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Place Order</title>
        <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript">
            
            $(document).ready(function() {
                setTotalCost();
            });
            
            function submitOrder() {
                var shipCost = $("input[name=shipOption]:checked")[0].value;
                $.ajax({
                    url: '<c:url value="/cart/submitOrder?ship="/>'+shipCost,
                    context: document.body
                }).done(function(data) {
                    $("#adding")[0].style.display = 'none';
                    $("#added")[0].innerHTML=data;
                }).fail(function() {
                    $("#adding")[0].style.display = 'none';
                    $("#added")[0].innerHTML="Failed";
                }).always(function() {
                    console.log( "done" );
                });
            }
            
            function setShippingCost(shipCost) {
                
                var cost = parseFloat($("#cost")[0].innerHTML);
                var totalCost = cost+shipCost;
                $("#total_cost")[0].innerHTML=totalCost;
                $("#ship_cost")[0].innerHTML=shipCost;
                $("#ship_cost_hi")[0].innerHTML=shipCost;
            }
            
            function setTotalCost() {
                var totalCost = 0.0;
                    <c:forEach var="p" items="${cartItems}" varStatus="status">
                    totalCost += ${p.amount};
                    </c:forEach>
                    $("#total_cost")[0].innerHTML=totalCost;
                    $("#cost")[0].innerHTML=totalCost;
            }
        </script>
    </head>
    <body>
    
        <aside class="col-md-4">
        <div class="col-md-10 col-md-offset-1">
            <div class="list-group">
                <div class="list-group-item" style="padding:4px; margin-top: 10px;">
                    <div class="col-md-12">
                        <div class="list-group-item-heading">
                            <button class="pull-right btn btn-primary" onclick='window.location="<c:url value="/customer/addCard?&path=/cart/placeOrder"/>";'>Add New</button>
                            <h4 class="pull-left">Credit Card:</h4>
                            <div class="clearfix"></div>
                            <ul style="list-style: outside none none; margin-top: 12px; padding-left: 0px;">
                                <c:forEach var="card" items="${customer.cardList}" varStatus="status">
                                <li style="line-height: 25px;"><div class="pull-right">
                                        <c:if test="${card.enabled == true}">selected</c:if>
                                        <c:if test="${card.enabled != true}"><a href="#" class="btn btn-default btn-xs">use this</a></c:if>
                                    </div>${card.cardNo}</li>
                                </c:forEach>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                
                <div class="list-group-item" style="padding:4px; margin-top: 10px;">
                    <div class="col-md-12">
                        <div class="list-group-item-heading">
                            <button class="pull-right btn btn-primary" onclick='window.location="<c:url value="/customer/addAddress?addressType=1&path=/cart/placeOrder"/>";'>Add New</button>
                            <h4 class="pull-left">Billing Address:</h4>
                            <div class="clearfix"></div>
                            <ul style="list-style: outside none none; margin-top: 12px; padding-left: 0px;">
                                <c:forEach var="address" items="${customer.addressList}" varStatus="status">
                                    <c:if test="${address.addressType == 1}">
                                        <li style="line-height: 25px;"><div class="pull-right">
                                                <c:if test="${address.enabled == true}">selected</c:if>
                                                <c:if test="${address.enabled != true}"><a href="#" class="btn btn-default btn-xs">use this</a></c:if>
                                            </div>${address.addressLine1}, ${address.city}, ${address.stateName}</li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                
                <div class="list-group-item" style="padding:4px; margin-top: 10px;">
                    <div class="col-md-12">
                        <div class="list-group-item-heading">
                            <button class="pull-right btn btn-primary" onclick='window.location="<c:url value="/customer/addAddress?addressType=0"/>";'>Add New</button>
                            <h4 class="pull-left">Shipping Address:</h4>
                            <div class="clearfix"></div>
                            <ul style="list-style: outside none none; margin-top: 12px; padding-left: 0px;">
                                <c:forEach var="address" items="${customer.addressList}" varStatus="status">
                                    <c:if test="${address.addressType == 0}">
                                        <li style="line-height: 25px;"><div class="pull-right">
                                            <c:if test="${address.enabled == true}">selected</c:if>
                                            <c:if test="${address.enabled != true}"><a href="#" class="btn btn-default btn-xs">use this</a></c:if>
                                    </div>${address.addressLine1}, ${address.city}, ${address.stateName}</li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>                
            </div>
            
        </div>
    </aside>

        
        <aside class="col-md-4">
        <div class="col-md-10 col-md-offset-1">
            <div class="list-group">
                <div class="list-group-item" style="padding:4px; margin:0;">
                    <div class="col-md-12">
                        <div class="list-group-item-heading">
                            <h4 class="pull-right" id="total_cost">$0.00</h4>
                            <h4 class="pull-left">Total Cost:</h4>
                            <div class="clearfix"></div>
                            <ul style="list-style: outside none none; padding-left: 0px;">
                                <li><div class="pull-right" id="cost">0.00</div><div>Cost:</div></li>
                                <li><div class="pull-right">0.00</div>Tax:</li>
                                <li><div class="pull-right" id="ship_cost">0.00</div>Shipping:</li>
                            </ul>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                    <div class="list-group-item" style="padding:4px; margin-top: 10px;">
                    <div class="col-md-12">
                        <div class="list-group-item-heading">
                            <h4 class="pull-right" id="ship_cost_hi">Free</h4>
                            <h4 class="pull-left">Shipping:</h4>
                            <div class="clearfix"></div>
                            <ul style="list-style: outside none none; padding-left: 0px;">
                                <li style="line-height: 25px;"><input onclick="setShippingCost(0)" type="radio" name="shipOption" value="0" checked>10-day free shipping</li>
                                <li style="line-height: 25px;"><input onclick="setShippingCost(5)" type="radio" name="shipOption" value="5">3-day express shipping</li>
                                <li style="line-height: 25px;"><input onclick="setShippingCost(7)" type="radio" name="shipOption" value="7">Same day delivery</li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>                        
        
            </div>

            <button class="btn btn-success" onclick='submitOrder()'>Place Order</button>
            <img id="adding" src="./resources/images/ajax-loader.gif" style="height:35px; display:none;">
            <label id="added"></label>
        </div>

        </aside>                    
    
    </body>
</html>
