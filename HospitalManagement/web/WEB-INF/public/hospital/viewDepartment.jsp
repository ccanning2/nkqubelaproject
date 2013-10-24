<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<div id="content">
    <h1>VIEW A DEPARTMENT</h1><br>
    <p>Name: ${department.name}</p>        
    <p>Description: ${department.description}</p>
    <p>Floor Number: ${department.floorNumber}</p>
    <p>Size ${department.departmentSize}&#160;Patients</p>
    <p>Contact Number: ${department.contact.contactNumber}</p>
    <p>Email Address: <a href="mailto:${department.contact.emailAddress}">${department.contact.emailAddress}</a></p>
    <p>Person In Charge: <a href="viewStaffMember.html?pk=${department.personInCharge.id}">${department.personInCharge.fullName}</a></p>

</div>

<jsp:include page="../hospital/footer/include.jsp" /> 
