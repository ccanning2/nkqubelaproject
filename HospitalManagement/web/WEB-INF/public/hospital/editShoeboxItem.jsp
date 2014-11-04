<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<body>
<div id="content">
    <%-- <c:when test="${shoeBoxModel.isVirtual == true}">
        <h1>Edit ${shoeBoxModel.itemName}</h1><br>
    </c:when>
    <c:otherwise>
        <h1>New Shoebox Item</h1><br>
    </c:otherwise> --%>
    
    <h1>New/Edit Shoebox Item</h1><br>
    
    <form:form action="mergeShoeboxItem.php" method="POST" modelAttribute="shoeboxItemModel">  
        <form:errors path="*" cssClass="errorblock" element="div"/>
        
        <table>
            <tr>
                <td><label> Shoe Box Item Name: </label></td>
                <td><form:input path="itemName" type="text"/></td>                
                <td class="errors"><form:errors path="itemName"/></td>
             </tr>
             <tr>
                <td><label> Shoe Box Description: </label></td>
                <td><form:textarea path="itemDescription"/></td>
                <td class="errors"><form:errors path="itemDescription"/></td>
            </tr>
             <tr>
                <td><label> Estimated Price: </label></td>
                <td><form:input path="estimatedPrice" type="number"/></td>
                <td class="errors"><form:errors path="estimatedPrice"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update Item"/></td>
                <td><input type="reset" value="Reset Fields"/></td>
            </tr>
        </table>
    </form:form>
</div>

<jsp:include page="footer/include.jsp" /> 
