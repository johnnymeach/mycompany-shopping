<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <title>Approval</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
    
    <script src="./resources/js/jquery.js"></script>
    
    <script src="./resources/js/bootstrap.js"></script>
    
    <script>
        function onApproval(vendorId) {
            var Eid = $("#Eid").html();
            var Tid = "#Tid" + vendorId;
            var Bid = "#Bid" + vendorId;
            $.ajax({
            	
                url:"vendor/approve/" + vendorId,
                type:'PUT',

                success:function(data) {
                    $(Tid).text("true");
                    $(Tid).css("color", "blue");
                    $(Bid).attr({"disabled":"disabled"});
                    alert(data);
                    window.location.reload();
                }
            });
        }
        
    </script>
</head>

<body>
    

    

    <div class="container">
        <div class="page-header">
            <h3 class="text-center">Vendors who need you approval</h3></div>
        <p style="color: red; font-weight: bold">ps: if vendor did not be approval yet, the status column should be false</p >    
        <table border="1px" width="1000px">
            <tr align="center" style="font-weight: bold;">
                <td>Vendor Name</td>
                <td>Allocated_space</td>
                <td>Registration number</td>
                <td>Used_space</td>
                <td>Credit Card Number</td>
                <td>City</td>
                <td>State Name</td>
                <td>Email Address</td>
                <td>Status</td>
                <td>Operation</td>
            </tr>
            <c:forEach var="vendor" items="${vendors}" varStatus="vendorIndex">
                <tr align="center">
                    <td>${vendor.vendor_name}</td>
                    <td>${vendor.allocated_space}</td>
                    <td>${vendor.reg_num}</td>
                    <td>${vendor.used_space}</td>
                    <td>${vendor.cc_num}</td>
                    <td>${vendor.city}</td>
                    <td>${vendor.state_name}</td>
                    <td id="Eid">${vendor.email}</td>
                    <td style="font-weight: bold;" id="Tid${vendorIndex.count}">
                        <c:choose>
                            <c:when test="${vendor.status eq false}">
                                <p style="color: red">false</p >
                            </c:when>
                            <c:otherwise>
                                <p style="color: blue">true</p >
                            </c:otherwise>
                        </c:choose>
                        
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${vendor.status eq false}">
                                <button onclick="onApproval(${vendor.vendorId})" id="Bid${vendorIndex.count}">Approval</button>
                            </c:when>
                            <c:otherwise>
                                <button  disabled="disabled">Approval</button>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                
                
            </c:forEach>
        </table>

    </div>

</body>

</html>