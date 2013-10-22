<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>Hotel Management - Delete A Hospital</title>
<meta charset="utf-8">
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="image/ico" rel="icon" href="<c:url value="/resources/images/hotel.ico" />" />
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/styles/style.css" />" />

<script type="text/javascript">
    function checkDepartmentName(){
        var name = document.getElementById("departmentNameDD").value;
        
        if(name == 0){
            alert('Please make sure you choose a department to delete');
            return false;
        }else{
            return true;
        }
    }
</script>

</head>

<div id="header">
    <a href=""><img src="resources/images/hotelmanagementsoftware.png" style="height: 150px; width: 500px;"/></a>
</div>

<body>
<div id="content">
        <h1>Delete A Department</h1><br>        
        <f:form action="removeDepartment.php" method="GET" modelAttribute="departmentModel">               
            <c:choose>
                <c:when test="${fn:length(departmentList) > 0}">
                    <div class="control-group warning">
                        <label> Department Name: </label><br/> 
                        <f:select id="departmentNameDD" path="id">
                            
                            <f:options items="${departmentList}" itemValue="id" itemLabel="name" />
                        </f:select>        <br><br>           
                        <input type="submit" value="Delete Department" onclick="return checkDepartmentName();"/>
                    </div>
                </c:when>
                <c:otherwise>
                    <label>There are no departments to display, to create a new department, <a href="addDepartment.html">Click here</a></label>
                </c:otherwise>                
            </c:choose>            
        </f:form>
</div>
    </body>
</html>
