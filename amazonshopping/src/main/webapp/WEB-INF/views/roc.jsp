
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>ROC Entry Page</title>
    </head>
    <body>
        <h1>Please enter company details:</h1>
    <form:form method="POST" action="/amazonshopping/addROC">
    <table>   
    <tr>
        <td><form:label path="company_name">Company Name</form:label></td>
        <td><form:input path="company_name" /></td>
    </tr>
    <tr>
        <td><form:label path="reg_num">Registration Number</form:label></td>
        <td><form:input path="reg_num" /></td>
    </tr>
    <tr>
        <td><form:label path="country">Country</form:label></td>
        <td><form:input path="country" /></td>
    </tr>
    <tr>
        <td><form:label path="state_name">State</form:label></td>
        <td><form:input path="state_name" /></td>
    </tr>
    <tr>
        <td><form:label path="city">City</form:label></td>
        <td><form:input path="city" /></td>
    </tr>
    <tr>
        <td><form:label path="phone_num">Phone Number</form:label></td>
        <td><form:input path="phone_num" /></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>