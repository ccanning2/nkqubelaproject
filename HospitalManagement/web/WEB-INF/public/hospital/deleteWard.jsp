<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
    function checkWardName(){
        var name = document.getElementById("wardNameDD").value;
        
        if(name == 0){
            alert('Please make sure you choose a ward to delete');
            return false;
        }else{
            return true;
        }
    }
</script>

<body>
<div id="content">
        <h1>DELETE A WARD</h1><br>        
        <f:form action="removeWard.php" method="GET" modelAttribute="wardModel">               
            <c:choose>
                <c:when test="${fn:length(wardList) > 0}">
                    <div class="control-group warning">
                        <label> Ward Name: </label><br/> 
                        <f:select id="wardNameDD" path="id">
                            
                            <f:options items="${wardList}" itemValue="id" itemLabel="name" />
                        </f:select>        <br><br>           
                        <input type="submit" value="Delete Ward" onclick="return checkWardName();"/>
                    </div>
                </c:when>
                <c:otherwise>
                    <label>There are no wards to display, to create a new ward, <a href="addWard.html">Click here</a></label>
                </c:otherwise>                
            </c:choose>            
        </f:form>
</div>
    </body>
</html>
