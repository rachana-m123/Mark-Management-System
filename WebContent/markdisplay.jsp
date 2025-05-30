<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Student Marks</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 30px;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        form {
            text-align: center;
            margin-bottom: 20px;
        }
        input[type="text"] {
            padding: 8px;
            width: 200px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            padding: 8px 16px;
            margin-left: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #333;
            text-decoration: none;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Display Student Marks</h2>
    <form action="DisplayMarksServlet" method="get">
        <label for="studentID">Enter Student ID:</label>
        <input type="text" id="studentID" name="studentID" placeholder="e.g., 101">
        <input type="submit" value="Search">
    </form>

    <c:if test="${not empty studentList}">
        <table>
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Subject</th>
                <th>Marks</th>
                <th>Exam Date</th>
            </tr>
            <c:forEach var="student" items="${studentList}">
                <tr>
                    <td>${student.studentID}</td>
                    <td>${student.studentName}</td>
                    <td>${student.subject}</td>
                    <td>${student.marks}</td>
                    <td>${student.examDate}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty studentList}">
        <p style="text-align: center;">No records found.</p>
    </c:if>

    <a class="back-link" href="index.jsp">Back to Home</a>
</body>
</html>
