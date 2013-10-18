<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Hospital Management Software - Login Page</title>
<meta charset="utf-8">
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="image/ico" rel="icon" href="<c:url value="/resources/images/hotelmanagement.png" />" />
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/styles/style.css" />" />
</head>

<body onload='document.f.j_username.focus();'>
<!-- <div id="header">
    <a href=""><img src="resources/images/hotelmanagementsoftware.png" style="height: 150px; width: 500px;"/></a>
</div><br> -->
<h2 style="text-align: center;">Please login into Hospital Management Software to continue.</h2>

<c:if test="${not empty error}">
        <div class="errorblock">
                Your login attempt was not successful, please try again.<br /> This was caused by:
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
</c:if>

<div style="margin-left: 42.5%; padding-top: 20px;">
    <form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
        <table>
            <tr>
                <td>Username:</td>
                <td><input type='text' name='j_username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='j_password' /></td>
            </tr>
            <tr>
                <td colspan='2'><br><input name="submit" type="submit" value="Login"/>
                <input name="reset" type="reset" value="Reset Fields"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>