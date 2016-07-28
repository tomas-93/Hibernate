<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 27/07/2016
  Time: 07:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>

</head>
<body>
<c:forEach items="${personList}" var="person">
    <h4>${person.id}</h4>
    <h4>${person.name}</h4>
    <h4>${person.surname}</h4>
    <h4>${person.age}</h4>
    <br>
    <br>
</c:forEach>
</body>
</html>
