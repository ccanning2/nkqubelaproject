<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<body>
<div id="content">
    <h1>View All Patients</h1><br>
    
    <c:choose>
        <c:when test="${fn:length(patients) > 0}">
        <table id="displaytable">
            <th>Patients Name</th>
            
            <th></th>   
            <th></th>   
                <c:forEach var="patient" items="${patients}"> 
                    <tr> 
                        <td align="center">
                            ${patient.patientNumber}
                        </td>
                        <td align="center">
                            <a href="editPatient.html?pk=${patient.id}"><img id="editbutton" src="resources/images/edit.png" style="height: 20px; width: 20px;"/></a>
                        </td> 
                        <td align="center">
                            <a href="deletePatient.html?pk=${patient.id}"><img id="deletebutton" src="resources/images/delete.png" style="height: 20px; width: 20px;"</a>
                        </td> 
                    </tr>
                </c:forEach>
            </table>           
        </c:when>
        <c:otherwise>
            <label>There are no patients to display, <a href="addPatient.html">Click here</a> to create a new Patients.</label>
        </c:otherwise>
    </c:choose>

</div>

<jsp:include page="../hospital/footer/include.jsp" /> 
