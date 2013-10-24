<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<body>
<div id="content">
    <h1>VIEW ALL STAFF MEMBERS:</h1><br>
    
    <c:choose>
        <c:when test="${fn:length(staffMembers) > 0}">
        <table id="displaytable">
            <th>Staff Member Name</th>
            
            <th></th>   
            <th></th>   
                <c:forEach var="staffMember" items="${staffMembers}"> 
                    <tr> 
                        <td align="center">
                            ${staffMember.staffNumber}
                        </td>
                        <td align="center">
                            <a href="editStaffMember.html?pk=${staffMember.id}"><img id="editbutton" src="resources/images/edit.png" style="height: 20px; width: 20px;"/></a>
                        </td> 
                        <td align="center">
                            <a href="deleteStaffMemberFromTable.html?pk=${staffMember.id}"><img id="deletebutton" src="resources/images/delete.png" style="height: 20px; width: 20px;"</a>
                        </td> 
                    </tr>
                </c:forEach>
            </table>           
        </c:when>
        <c:otherwise>
            <label>There are no Staff Members to display, <a href="addStaffMember.html">Click here</a> to create a new Staff Member.</label>
        </c:otherwise>
    </c:choose>

</div>

<jsp:include page="../hospital/footer/include.jsp" />