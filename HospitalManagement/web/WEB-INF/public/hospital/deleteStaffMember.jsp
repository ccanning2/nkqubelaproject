<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
    function checkStaffMemberName(){
        var name = document.getElementById("staffMemberNameDD").value;
        
        if(name == 0){
            alert('Please make sure you choose a staff member to delete');
            return false;
        }else{
            return true;
        }
    }
</script>

<body>
<div id="content">
        <h1>DELETE A STAFF MEMBER</h1><br>        
        <f:form action="removeStaffMember.php" method="GET" modelAttribute="staffMemberModel">               
            <c:choose>
                <c:when test="${fn:length(staffMemberList) > 0}">
                    <div class="control-group warning">
                        <label> Staff Member Name: </label><br/> 
                        <f:select id="staffMemberNameDD" path="id">                            
                            <f:options items="${staffMemberList}" itemValue="id" itemLabel="fullName" />
                        </f:select>        <br><br>           
                        <input type="submit" value="Delete Staff Member" onclick="return checkStaffMemberName();"/>
                    </div>
                </c:when>
                <c:otherwise>
                    <label>There are no staff members to display, to create a new staff member, <a href="addPatient.html">Click here</a></label>
                </c:otherwise>                
            </c:choose>            
        </f:form>
</div>
    </body>
</html>
