<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<body>
<div id="content">
    <h1>VIEW ALL WARDS</h1><br>
    
    <c:choose>
        <c:when test="${fn:length(wards) > 0}">
        <table id="displaytable">
            <th>Name</th>
            <th>Ward Number</th>
            <th>Person In Charge</th>
            <th>Belongs to Department</th>
            
            <th></th>   
            <th></th>   
                <c:forEach var="ward" items="${wards}"> 
                    <tr> 
                        <td align="center">
                            ${ward.name}
                        </td>
                        <td align="center">
                            ${ward.wardNumber}
                        </td>
                        <td align="center">
                            <a href="viewStaffMember.html?pk=${ward.personInCharge.id}">${ward.personInCharge.name.firstName}&#160;${ward.personInCharge.name.lastName}</a>
                        </td>
                        <td align="center">
                            <a href="viewDepartment.html?pk=${ward.department.id}">${ward.department.name}</a>
                        </td>
                        <td align="center">
                            <a href="editWard.html?pk=${ward.id}"><img id="editbutton" src="resources/images/edit.png" style="height: 20px; width: 20px;"/></a>
                        </td> 
                        <td align="center">
                            <a href="deleteWardFromTable.html?pk=${ward.id}"><img id="deletebutton" src="resources/images/delete.png" style="height: 20px; width: 20px;"</a>
                        </td> 
                    </tr>
                </c:forEach>
            </table>           
        </c:when>
        <c:otherwise>
            <label>There are no wards to display, <a href="addWard.html">Click here</a> to create a new Ward.</label>
        </c:otherwise>
    </c:choose>

</div>

<jsp:include page="../hospital/footer/include.jsp" /> 
