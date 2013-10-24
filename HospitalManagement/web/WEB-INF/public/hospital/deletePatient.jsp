<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
    function checkPatientName(){
        var name = document.getElementById("patientNameDD").value;
        
        if(name == 0){
            alert('Please make sure you choose a patient to delete');
            return false;
        }else{
            return true;
        }
    }
</script>

<body>
<div id="content">
        <h1>DELETE A PATIENT</h1><br>        
        <f:form action="removePatient.php" method="GET" modelAttribute="patientModel">               
            <c:choose>
                <c:when test="${fn:length(patientList) > 0}">
                    <div class="control-group warning">
                        <label> Patient Name: </label><br/> 
                        <f:select id="patientNameDD" path="id">                            
                            <f:options items="${patientList}" itemValue="id" itemLabel="fullName" />
                        </f:select>        <br><br>           
                        <input type="submit" value="Delete Patient" onclick="return checkPatientName();"/>
                    </div>
                </c:when>
                <c:otherwise>
                    <label>There are no patients to display, to create a new patient, <a href="addPatient.html">Click here</a></label>
                </c:otherwise>                
            </c:choose>            
        </f:form>
</div>
    </body>
</html>
