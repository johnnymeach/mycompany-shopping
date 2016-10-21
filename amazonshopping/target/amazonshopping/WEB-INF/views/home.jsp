
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MUM Online Shopping</title>
        <script type="text/javascript">
            
            
            
            function addToCart(id, name) {
                var qty = $("#p_"+id+" input")[0].value;
                $("#adding_"+id)[0].style.display = 'inline';
                $.ajax({
                    url: "cart/addItem?productId="+id+"&qty="+qty,
                    context: document.body
                }).done(function() {
                    $("#adding_"+id)[0].style.display = 'none';
                    $("#added_"+id)[0].innerHTML="Added";
                }).fail(function() {
                    $("#adding_"+id)[0].style.display = 'none';
                    $("#added_"+id)[0].innerHTML="Failed";
                    //console.log( "error" );
                }).always(function() {
                    setTimeout(function() {
                        $("#added_"+id)[0].innerHTML="";
                    }, 2000);
                    console.log( "done" );
                });
                
            }
            
            function doSearch() {
                window.location = "home.htm?str="+$("#search_text")[0].value;
            }
        </script>

    </head>
    <body style="margin: 5px;">
<div style="margin-left: 65px;">    
        <input type='text' id='search_text'></input> <a onclick="doSearch()" class="btn btn-default" href='#' id="ssearch_tbn">Search</a>
</div>    
<div>        
<aside style="margin-top: 50px;" class="col-md-4">
        <div class="col-md-12 col-md-offset-1">
            <c:forEach var="p" items="${productList}" varStatus="status">
            <div class="list-group">
                <div class="list-group-item" style="padding:4px; margin:0;">
                    <div class="col-md-3" style="padding:10px; margin:0;">
                    <img src="./resources/images/product_image/${p.imageUrl}" style="width:85px;"></div>
                    <div class="col-md-9">
                        <div class="list-group-item-heading">
                            <h4 class="pull-right">$${p.price}</h4>
                            <h4 class="pull-left">${p.productName}</h4>
                            <div class="clearfix"></div>
                        </div>
                            
                            <p class="list-group-item-text" style="margin-bottom: 10px;">${p.productDetails}</p>
                            <p><small>${p.quantity} item left</small></p> 
                            
                    </div>
                    <div class="form-group" id="p_${p.productId}">
                        <label for="qty" class="control-label">Quantity</label >
			<input style="width:70px; display: inline-block;"
                               type="number" class="form-control"  value="1" min="1"  max="64" 
                                ng-min-err-type="tooYoung"
                                ng-max-err-type="tooOld"
                                required="required">
                    <input type="button" onclick="addToCart('${p.productId}', '${p.productName}')" value="Add to cart"></input>
                    <img id="adding_${p.productId}" src="./resources/images/ajax-loader.gif" style="height:35px; display:none;">
                    <label id="added_${p.productId}"></label>
			
                    </div >
                    <div class="clearfix"></div>
                </div>                        
            </div>
            </c:forEach>
            
        </div>
    </aside>
</div>
</body>
</html>
