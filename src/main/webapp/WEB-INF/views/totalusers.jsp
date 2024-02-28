<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List of Users</title>
</head>
<body>
    <h2>List of Users</h2>

    <table border="1">
        <tr>
            <th>User ID</th>
            <th>User Name</th>
            <!-- Add more columns as needed -->
        </tr>

        <c:forEach var="user" items="${bl}">
            <tr>
                <td><c:out value="${user.uid}" /></td>
                <td><c:out value="${user.user}" /></td>
                <!-- Add more columns as needed -->
            </tr>
        </c:forEach>
    </table>
</body>
</html>
