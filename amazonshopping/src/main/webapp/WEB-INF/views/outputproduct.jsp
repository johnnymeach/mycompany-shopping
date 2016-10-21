<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="org.amazon.shopping.dao.ProductDao, org.amazon.shopping.model.Product;" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//ProductDao productDao = (ProductDao)request.getSesstion().getParameter("listingproduct");
List<Product> productList = (List<Product>)request.getSession().getAttribute("listingproduct");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
Product List:</br>
<%for(Product p : productList){

	%>
	<%=p.getProductName() %></br>
<%} %>
  </body>
</html>
