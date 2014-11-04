<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<body>
<div id="content">
    <h1>ADD SHOE BOX ITEM</h1><br>
        <f:form action="persistShoeboxItem.php" method="POST" modelAttribute="shoeboxItemModel" enctype="multipart/form-data">  
            <label> Shoe Box Item Name: </label> <br/>
            <f:input path="itemName" type="text"/> <br/>
            <label> Shoe Box Description: </label> <br/>
            <f:textarea path="itemDescription"/><br/>
            <label> Estimated Price: </label> <br/>
            <f:input path="estimatedPrice" type="number"/> <br/>
            <label> Image: </label> <br/>
            <f:input path="imageData" type="file"/> <br/>
            <input type="submit" value="Create Item"/>
            <input type="reset" value="Reset Fields"/>
        </f:form>
</div>

<jsp:include page="footer/include.jsp" /> 
