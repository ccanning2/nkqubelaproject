<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<body>
<div id="content">
    <h1>View All Departments</h1><br>
    
    <c:choose>
        <c:when test="${fn:length(departments) > 0}">
        <table id="displaytable">
            <th>Department Name</th>
            <th>Department Description</th>   
            <th>Department Size</th>   
            <th>Person In Charge</th>
            <th>Email Address</th>
            <th>Contact Number</th>
            <th></th>   
            <th></th>   
                <c:forEach var="department" items="${departments}"> 
                    <tr> 
                        <td align="center">
                            ${department.name}
                        </td>              
                        <td align="center">
                            ${department.description}
                        </td> 
                        <td align="center">
                            ${department.departmentSize}
                        </td> 
                        <td align="center">
                            <a href="viewStaffMember.html?pk=${department.personInCharge}">${department.personInCharge}</a>
                        </td> 
                        <td align="center">
                            ${department.contact.emailAddress}
                        </td> 
                        <td align="center">
                            ${department.contact.contactNumber}
                        </td>                        
                        <td align="center">
                            <a href="editDepartment.html?pk=${department.id}"><img id="editbutton" src="resources/images/edit.png" style="height: 20px; width: 20px;"/></a>
                        </td> 
                        <td align="center">
                            <a href="deleteDepartment.html?pk=${department.id}"><img id="deletebutton" src="resources/images/delete.png" style="height: 20px; width: 20px;"</a>
                        </td> 
                    </tr>
                </c:forEach>
            </table>           
        </c:when>
        <c:otherwise>
            <label>There are no departments to display</label>
        </c:otherwise>
    </c:choose>

</div>

<jsp:include page="../hospital/footer/include.jsp" /> 
