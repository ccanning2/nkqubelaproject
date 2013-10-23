<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<body>
<div id="content">
    <h1>ADD WARD</h1><br>
     <f:form action="persistWard.php" method="POST" modelAttribute="wardModel">  
        <label> Ward Name: </label> <br/>
        <f:input path="name" type="text"/> <br/>        
        <label> Ward Number: </label> <br/>
        <f:input path="wardNumber" type="text"/> <br/>
        <label> Visiting Hours: (Start) </label> <br/>
        <f:input path="visitingHoursStart" type="time"/> <br/>
        <label> Visiting Hours: (End) </label> <br/>
        <f:input path="visitingHoursEnd" type="time"/> <br/>
        <label> Email Address: </label> <br/>
        <f:input path="emailAddress" type="email"/> <br/>
        <label> Contact Number: </label> <br/>
        <f:input path="contactNumber" type="text"/> <br/>
        <label> Floor Number: </label> <br/>
        <f:input path="floorNumber" /> <br/>
        <label> Person In Charge: </label> <br/>
        <f:select path="personInCharge">
            <f:options items="${personInChargeList}" itemValue="id" itemLabel="fullName" />
        </f:select><br/><br/> <!-- TODO: Need to add the rest of the fields -->
        <input type="submit" value="Create Ward"/>
        <input type="reset" value="Reset Fields"/>
    </f:form>
</div>

<jsp:include page="footer/include.jsp" /> 


