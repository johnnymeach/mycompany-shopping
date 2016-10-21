 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
 <title><sitemesh:write property='title'/></title>
 <sitemesh:write property='head'/>
 <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript" src="./resources/js/angular.min.js"></script>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" >
        <link href="./resources/js/ladda-themeless.min.css" rel="stylesheet">
	<link href="./resources/css/main.css" rel="stylesheet" >        
 </head>
 <body style="margin:5px;">
 <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="/amazonshopping" class="navbar-brand">AmazonShopping.com</a>
                <sec:authorize access="isAuthenticated()">
                <a style="color: #FFFFFF" class="navbar-brand" id="cart">
                    <sec:authentication property="principal.username" />
                </a>
                </sec:authorize>
            </div>            
                <ul class="nav navbar-nav navbar-right">
                    <li><a style="color: #FFFFFF" href='<c:url value="/home.htm"/>'>Shop</a></li>
                    <sec:authorize access="hasRole('ROLE_USER')">
                    <li><a style="color: #FFFFFF" href='<c:url value="/cart/detail"/>'>My Cart</a></li>
                    <li><a style="color: #FFFFFF" href='<c:url value="/customer/profile"/>'>Profile</a></li>
                    </sec:authorize>
                    <sec:authorize access="isAnonymous()">
                    <c:if test="${vendorName==null}"> 
                    <li><a style="color: #FFFFFF" href='<c:url value="/signup.htm"/>'>User Sign Up</a></li>
                    
                    
                    <li><a style="color: #FFFFFF" href='<c:url value="/login"/>'>User Login</a></li>
                     </c:if>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                    <li><a href='<c:url value="/logout"/>'>Logout</a></li>
                    </sec:authorize>
                    
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a style="color: #FFFFFF" href='<c:url value="/report"/>'>Reports</a></li>
                    </sec:authorize>
                    
                     <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a style="color: #FFFFFF" href='<c:url value="/productApproval"/>'>Approal Product</a></li>
                    </sec:authorize>
                    
                    <c:if test="${vendor!=null}"> 
                    <li><a style="color: #FFFFFF" href="/amazonshopping/productUpload">Upload Product</a></li>
                    </c:if>
                    
                    
                  
                    <c:if test="${vendor!=null}">                 
                    <li><a style="color: #FFFFFF" href="/amazonshopping/vendorLogout">Logout</a></li>
                    </c:if>
                    
                     <sec:authorize access="isAnonymous()">
                    <c:if test="${vendorName==null}">
                    <li><a style="color: #FFFFFF" href="/amazonshopping/vendorLogin">Vendor Login</a></li>
                    </c:if>
                    </sec:authorize>
                    
                     <sec:authorize access="isAnonymous()">
                    <c:if test="${vendorName==null}">
                    <li><a style="color: #FFFFFF" href="/amazonshopping/vendor">Vendor Signup</a></li>
                    </c:if>
                     </sec:authorize>
                    
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li><a style="color: #FFFFFF" href='<c:url value="/approval"/>'>Approal Vendor</a></li>
                    </sec:authorize>
                   
                    
                </ul>          
        </div>
    </nav>
 <sitemesh:write property='body'/>
 </body>
</html>