<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Report Results</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
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
    <h2>Generated Report Results</h2>

    <c:choose>
        <c:when test="${not empty reportData}">
            <table>
                <thead>
                    <tr>
                        <th>Student ID</th>
                        <th>Name</th>
                        <th>Subject</th>
                        <th>Marks</th>
                        <th>Exam Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${reportData}">
                        <tr>
                            <td>${student.studentID}</td>
                            <td>${student.studentName}</td>
                            <td>${student.subject}</td>
                            <td>${student.marks}</td>
                            <td>${student.examDate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p style="text-align: center;">No records found matching your criteria.</p>
        </c:otherwise>
    </c:choose>

    <a class="back-link" href="report_form.jsp">Back to Report Selection</a>
</body>
</html>
