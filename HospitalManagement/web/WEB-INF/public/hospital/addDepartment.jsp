<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<body>
<div id="content">
    <h1>ADD DEPARTMENT</h1><br>
        <f:form action="persistDepartment.php" method="POST" modelAttribute="departmentModel">  
            <label> Department Name: </label> <br/>
            <f:input path="name" type="text"/> <br/>
            <label> Department Description: </label> <br/>
            <f:input path="description" type="text"/> <br/>
            <label> Department Size </label> <br/>
            <f:input path="size" type="number"/> <br/>
            <label> Department Floor Number: </label> <br/>
            <f:input path="floorNumber" /> <br/>
            <label> Person in charge: </label> <br/>
            <f:select path="personInCharge">
                <f:options items="${personInChargeList}" itemValue="id" itemLabel="fullName" />
            </f:select><br/><br/>
            <input type="submit" value="Create Department"/>
            <input type="reset" value="Reset Fields"/>
        </f:form>
</div>

<jsp:include page="footer/include.jsp" /> 
