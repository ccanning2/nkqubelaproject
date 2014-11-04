<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<body>
<div id="content">
    <h1>VIEW ALL SHOE BOX ITEMS:</h1><br>
    
    <c:choose>
        <c:when test="${fn:length(shoeboxItems) > 0}">
        <table id="displaytable">
            <th>Item Name</th>
            <th>Item Description</th>   
            <th>Estimated Price</th>
            <th></th>   
            <th></th>   
                <c:forEach var="shoeboxItem" items="${shoeboxItems}"> 
                    <tr> 
                        <td align="center">
                            <a href="viewShoeboxItem.html?pk=${shoeboxItem.id}">${shoeboxItem.itemName}</a>
                        </td>              
                        <td align="center">
                            ${shoeboxItem.itemDescription}
                        </td> 
                        <td align="center">
                            R ${shoeboxItem.estimatedPrice}
                        </td>                
                        <td align="center">
                            <a href="editShoeboxItem.html?pk=${shoeboxItem.id}"><img id="editbutton" src="resources/images/edit.png" style="height: 20px; width: 20px;"/></a>
                        </td> 
                        <td align="center">
                            <a href="deleteShoeboxItem.html?pk=${shoeboxItem.id}"><img id="deletebutton" src="resources/images/delete.png" style="height: 20px; width: 20px;"</a>
                        </td> 
                    </tr>
                </c:forEach>
            </table>           
        </c:when>
        <c:otherwise>
            <label>There are no shoe box items to display, <a href="addShoeboxItem.html">Click here</a> to create a new Shoebox Item.</label>
        </c:otherwise>
    </c:choose>

</div>

<jsp:include page="../hospital/footer/include.jsp" /> 
