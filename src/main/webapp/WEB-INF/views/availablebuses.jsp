<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Available Buses</title>
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
    <h2>Available Buses</h2>
    <c:if test="${not empty abl}">
        <table>
            <tr>
                <th>Bus Number</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Date</th>
                <th>Time</th>
                <th>Available Seats</th>
                <th>Booked Seats</th>
            </tr>
            <c:forEach items="${abl}" var="bus">
                <tr>
                    <td>${bus.bno}</td>
                    <td>${bus.src}</td>
                    <td>${bus.dest}</td>
                    <td>${bus.date}</td>
                    <td>${bus.time}</td>
                    <td>${bus.seats}</td>
                    <td><a href="/usr/bseats?bno=${bus.bno}">view</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty abl}">
        <p>No Buses Available</p>
    </c:if>
</body>
</html>
