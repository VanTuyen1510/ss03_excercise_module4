<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Mail</title>
</head>
<body>
<h1>List Mail</h1>
<table border = 1>
    <tr>
        <th>ID</th>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams filter</th>
        <th>Signature</th>
        <th>Update</th>
    </tr>
    <c:forEach items="${mails}" var="m">
        <tr>
            <td>${m.mailID}</td>
            <td>${m.language}</td>
            <td>${m.pageSize}</td>
            <td>
                <c:choose>
                    <c:when test="${m.haveSpamsFilter == true}">
                        Yes
                    </c:when>
                    <c:otherwise>
                        No
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${m.signature}</td>
            <td>
               <a href="/mail/update?id=${m.mailID}">Update</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>