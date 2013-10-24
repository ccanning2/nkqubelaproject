<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<div id="content">
    <h1>VIEW A PERSON</h1><br>
    <p>Full Name: ${person.fullName}</p>        
    <p>Nick Name: ${person.name.nickName}</p>
    <p>Identity Number: ${person.identityNumber}</p> <!-- TODO: If ID is entered calculate dob otherwise check if the ID and date match-->
    <p>Date of Birth: <fmt:formatDate value="${person.demographic.dateOfBirth}" pattern="yyyy-MM-dd" /></p>        
    
    <br>
    <hr>
    <br>
    
    <p>Contact Number: ${person.contact.contactNumber}</p>
    <p>Email Address: <a href="mailto:${person.contact.emailAddress}">${person.contact.emailAddress}</a></p>

    <br>
    <hr>
    <br>
    
    <p>Race: ${person.demographic.race}</p>
    <p>Gender: ${person.demographic.gender}</p>
    <p>Title: ${person.demographic.title}</p>
    
    
    <br>
    <hr>
    <br>   

    <p>Patient Number: ${person.patientNumber}</p>
    <p>Current Condition: ${person.currentCondition}</p>
    <p>Date of Arrival: ${person.dateOfArrival}</p>
    <p>Estimated Date Of Discharge: ${person.estimatedDateOfDischarge}</p>
    <p>Reason For Stay: ${person.reasonForStay}</p>
    <p>Bed Number: ${person.bedNumber}</p>

    <c:if test="${!empty person.medicalAid}">
        <p>Medical Aid Number: ${person.medicalAid.medicalAidNumber}</p>
        <p>Medical Aid Scheme: ${person.medicalAid.medicalAidScheme}</p>
        <p>Medical Aid Name: ${person.medicalAid.medicalAidName}</p>
    </c:if>
</div>

<jsp:include page="../hospital/footer/include.jsp" /> 
