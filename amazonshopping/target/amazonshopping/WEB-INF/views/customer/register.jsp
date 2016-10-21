
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Customer Registration</title>
    </head>
    <body>
<form:form action="register" commandName="customer">
	<table>
		<tr>
			<td>Name :</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Date of birth :</td>
			<td><form:input path="dob" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Register"></td>
		</tr>
	</table>
</form:form>
    </body>
</html>
