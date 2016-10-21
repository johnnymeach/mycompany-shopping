<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@ page import="org.amazon.shopping.dao.VendorDao, org.amazon.shopping.model.Vendor" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Vendor> vendorList = (List<Vendor>)request.getSession().getAttribute("listingvendor");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'outputvendor.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    Vendor List:</br>
<%for(Vendor v : vendorList){

	%>
	<%=v.getVendor_name() %></br>
<%} %>
  </body>
</html>
