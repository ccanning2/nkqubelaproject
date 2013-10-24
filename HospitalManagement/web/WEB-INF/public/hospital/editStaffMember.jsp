<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<body>
<div id="content">
    <h1>EDIT STAFF MEMBER:</h1><br>
    <f:form action="mergeStaffMember.php" method="POST" modelAttribute="staffMemberModel">  
        <label>First Name: </label> <br/>
        <f:input path="firstName" type="text"/> <br/>
        <label>Last Name: </label> <br/>
        <f:input path="lastName" type="text"/> <br/>
        <label>Middle Name: </label> <br/>
        <f:input path="middleName" type="text"/> <br/>
        <label>Nick Name: </label> <br/>
        <f:input path="nickName" type="text"/> <br/>
        <label>Staff Number: </label> <br/>
        <f:input path="staffNumber" type="text"/> <br/>
        <label>Email Address: </label> <br/>
        <f:input path="emailAddress" type="text"/> <br/>
        <label>Contact Number: </label> <br/>
        <f:input path="contactNumber" type="text"/> <br/>
        <label> Identity Number: </label> <br/>
        <f:input path="identityNumber" type="text"/> <br/>
        <label> Type: </label> <br/>
        <f:input path="type" type="text"/> <br/>
        <label> Start Time: </label> <br/>
        <f:input path="startTime" type="time"/> <br/>
        <label> End Time: </label> <br/>
        <f:input path="endTime" type="time"/> <br/>
        <label>Field:  </label> <br/>
        <f:input path="field" id="date" type="text"/> <br/><br/>
        <label>Date Of Birth:  </label> <br/>
        <f:input path="dateOfBirth" id="date" type="text"/> <br/><br/>
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
        
        <input type="submit" value="Save Changes"/>
        <input type="reset" value="Reset Fields"/>
    </f:form>
</div>

<jsp:include page="footer/include.jsp" />