<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bookings</title>
    <style>
        table {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Bookings</h2>
    <c:if test="${not empty bl}">
        <table>
            <tr>
                <th>Bus Number</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Date</th>
                <th>Time</th>
                <th>Cancel</th>
            </tr>
            <c:forEach items="${bl}" var="bus">
                <tr>
                    <td>${bus.bno}</td>
                    <td>${bus.src}</td>
                    <td>${bus.dest}</td>
                    <td>${bus.date}</td>
                    <td>${bus.time}</td>
                 <td><a href="/usr/cacl?bno=${bus.bno}&uid=${uid}">cancel</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty bl}">
        <p>No Bookings Found</p>
    </c:if>
</body>
</html>
