
<%@page session="true"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  </head>
  
  <body>
     <form name='form1'
			action="<c:url value='/listingproduct' />" method='POST'>
     <input type="submit"  value='List Product by Category'/> 
     </form>
     </br></br>
     
     <form name='form2'
			action="<c:url value='/listingvendor' />" method='POST'>
     <input type="submit" value="List Vendors by Brand"/>
     </form>
  </body>
</html>
