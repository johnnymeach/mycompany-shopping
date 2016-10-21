
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Vendor Registration Page</title>
        <style>
            #login-box {
                width: 600px;
                margin-left: 150px;
            }
            .form-group {
                width: 200px;
            }
        </style>
    </head>
    <body>        
    <div id="login-box">
    <h3>Please enter vendor details [ Registered in USA ]</h3>
    <form:form method="POST" action="/amazonshopping/addVendor">
    <div class="form-group">
        <form:label path="vendor_name">Vendor Name</form:label>
        <form:input class="form-control" path="vendor_name" />
    </div>
    <div class="form-group">
        <form:label path="reg_num">Registration Number</form:label>
        <form:input class="form-control" path="reg_num" />
    </div>
    <div class="form-group">
        <form:label path="password">Password</form:label>
        <form:password class="form-control" path="password" />
    </div>
    <div class="form-group">
        <form:label path="country">Country</form:label>
        <form:input class="form-control" path="country" />
    </div>
    <div class="form-group">
        <form:label path="state_name">State</form:label>
        <form:input class="form-control" path="state_name" />
    </div>
    <div class="form-group">
        <form:label path="city">City</form:label>
        <form:input class="form-control" path="city" />
    </div>
    <div class="form-group">
        <form:label path="cc_num">Credit Card Number (16 digit)</form:label>
        <form:input class="form-control" path="cc_num" />
    </div>
    <div class="form-group">
        <form:hidden path="allocated_space" value="50" />
    </div>
    <div class="form-group">
        <form:hidden path="used_space" value="0" />
    </div>
    <div class="form-group">
        <form:hidden path="status" value="false" />
    </div>
          <input class="btn btn-primary" type="submit" value="Submit"/>
</form:form>
</body>
</html>