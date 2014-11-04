<jsp:include page="../hospital/header/include.jsp" />

<jsp:include page="../hospital/menu/menu.jsp" />

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<div id="content">
    <h1>VIEW A SHOE BOX ITEM</h1><br>
    <p>Name: ${shoeboxItem.itemName}</p>        
    <p>Description: ${shoeboxItem.itemDescription}</p>
    <p>Estimate Price: R ${shoeboxItem.estimatedPrice}</p><br>
    <img src="${shoeboxItem.imageUrl}" width="250px" height="250px"/>
</div>

<jsp:include page="../hospital/footer/include.jsp" /> 
