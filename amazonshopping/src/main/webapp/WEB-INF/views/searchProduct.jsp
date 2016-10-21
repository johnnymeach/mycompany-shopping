
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Product Search Page</title>
    </head>
    <body>
        <form:form method="POST" action="/amazonshopping/findProduct">
            <div class="form-group">
                <form:label>Search By</form:label>
                <form:select path="searchBy">
                    <form:option value="brand" label="Search By Brand"/>               
                </form:select>
            </div>
            <div>
                 <input class="btn btn-primary" type="submit" value="Submit"/>
            </div>
            </table>  
        </form:form>
    </body>
</html>
