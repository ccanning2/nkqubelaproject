<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<body>
<div id="content">
    <h1>Add Patient</h1><br>
     <f:form action="persistPatient.php" method="POST" modelAttribute="patientModel">  
        <label> Patient Name: </label> <br/>
        <f:input path="name" type="text"/> <br/>
        <label> Patient bed Number: </label> <br/>
        <f:input path="bedNumber" type="text"/> <br/>
        <label>Date of arrival:  </label> <br/>
        <f:input path="dateofArrival" type="text"/> <br/>
        <label> Medical aid id: </label> <br/>
        <f:input path="medicalAidID"type="text" /> <br/>
        <label> Patient number: </label> <br/>
         <f:input path="patientNumber"type="text" /> <br/>
         <label>Reason for stay: </label> <br/>
         <f:input path="reasonForStay"type="text" /> <br/>
      
        
        <input type="submit" value="Create Patient"/>
        <input type="reset" value="Reset Fields"/>
    </f:form>
</div>

<jsp:include page="footer/include.jsp" /> 
