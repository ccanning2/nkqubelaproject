<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        jQuery("#medicalAidDetails").hide();
    });
    
    function showMedicalAidDetails(){
        if(document.getElementById('hasMedicalAid').checked === false){
            jQuery("#medicalAidDetails").hide();
        }else{
            jQuery("#medicalAidDetails").show();
        }
    }
</script>

<body>
<div id="content">
    <h1>ADD PATIENT</h1><br>
    <f:form action="persistPatient.php" method="POST" modelAttribute="patientModel">  
        <label>First Name: </label> <br/>
        <f:input path="firstName" type="text"/> <br/>
        <label>Last Name: </label> <br/>
        <f:input path="lastName" type="text"/> <br/>
        <label>Middle Name: </label> <br/>
        <f:input path="middleName" type="text"/> <br/>
        <label>Nick Name: </label> <br/>
        <f:input path="nickName" type="text"/> <br/>      
        <label>Email Address: </label> <br/>
        <f:input path="emailAddress" type="text"/> <br/>
        <label>Contact Number: </label> <br/>
        <f:input path="contactNumber" type="text"/> <br/>
        <label> Identity Number: </label> <br/>
        <f:input path="identityNumber" type="text"/> <br/>
        <label>Date Of Birth:  </label> <br/>
        <f:input path="dateOfBirth" type="date"/><br/><br/>

        <label>Gender: </label> <br/>
        <f:select id="genderDD" path="race">                            
            <f:option value="Select A Race"/>
            <f:option value="Black"/>
            <f:option value="White"/>
            <f:option value="Coloured"/>
            <f:option value="Other"/>
        </f:select><br/>
        <label>Race: </label> <br/>
        <f:select id="raceDD" path="gender">                            
            <f:option value="Select A Gender"/>
            <f:option value="Male"/>
            <f:option value="Female"/>
        </f:select><br/>
        <label>Title: </label> <br/>
        <f:select id="titleDD" path="title">                            
            <f:option value="Select A Title"/>
            <f:option value="Mr"/>
            <f:option value="Mrs"/>
            <f:option value="Ms"/>
            <f:option value="Miss"/>
            <f:option value="Dr"/>
            <f:option value="Master"/>
            <f:option value="Rev"/>
            <f:option value="Prof"/>            
        </f:select><br/><br/>

        <label> Ward: </label><br/> 
        <f:select id="wardNameDD" path="ward">                            
            <f:options items="${wardList}" itemValue="id" itemLabel="name" />
        </f:select> <br/>
        
        <label>Date of arrival: </label> <br/>
        <f:input path="dateOfArrival" type="date"/> <br/><br/>
        <label>Estimated Date of Discharge:  </label> <br/>
        <f:input path="estimatedDateOfDeparture" type="date"/> <br/><br/>
        <label> Patient Bed Number: </label> <br/>
        <f:input path="bedNumber" type="number"/> <br/>
        <label>Current Condition: </label> <br/>
        <f:input path="currentCondition" type="text"/> <br/><br/>
        <label>Has Medical Aid: </label> <br/>
        <f:checkbox path="hasMedicalAid" id="hasMedicalAid" name="hasMedicalAid" onclick="showMedicalAidDetails()"/><br/>
        <div id="medicalAidDetails">
            <label>Medical Aid Number: </label> <br/>
            <f:input path="medicalAidNumber" type="text" /> <br/>
            <label>Medical Aid Name: </label> <br/>
            <f:input path="medicalAidName" type="text" /> <br/>
            <label>Medical Aid Scheme: </label> <br/>
            <f:input path="medicalAidScheme" type="text" /> <br/>
        </div>
        <label>Patient Number: </label> <br/>
        <f:input path="patientNumber" type="text" /> <br/>
        <label>Reason for stay: </label> <br/>
        <f:input path="reasonForStay" type="text" /> <br/>        
        <input type="submit" value="Create Patient"/>
        <input type="reset" value="Reset Fields"/>
    </f:form>
</div>

<jsp:include page="footer/include.jsp" /> 
