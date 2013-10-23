<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<body>
<div id="content">
    <h1>Add Ward</h1><br>
     <f:form action="persistWard.php" method="POST" modelAttribute="wardModel">  
        <label> Ward Name: </label> <br/>
        <f:input path="name" type="text"/> <br/>
        <label> Ward Description: </label> <br/>
        <f:input path="description" type="text"/> <br/>
        <label> Ward Size </label> <br/>
        <f:input path="size" type="number"/> <br/>
        <label> Ward Floor Number: </label> <br/>
        <f:input path="floorNumber" /> <br/>
        <label> Person in charge: </label> <br/>
        <f:input path="personInCharge" /> <br/><br/>
        <input type="submit" value="Create Ward"/>
        <input type="reset" value="Reset Fields"/>
    </f:form>
</div>

<jsp:include page="footer/include.jsp" /> 


