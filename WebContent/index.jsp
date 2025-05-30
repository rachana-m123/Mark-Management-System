<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Marks Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            padding-top: 50px;
        }
        h1 {
            color: #333;
        }
        .nav-links {
            margin-top: 30px;
        }
        .nav-links a {
            display: inline-block;
            margin: 10px 15px;
            padding: 12px 25px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .nav-links a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Welcome to the Student Marks Management System</h1>
    <div class="nav-links">
        <a href="markadd.jsp">Add Marks</a>
        <a href="markupdate.jsp">Update Marks</a>
        <a href="markdelete.jsp">Delete Marks</a>
        <a href="markdisplay.jsp">Display Marks</a>
        <a href="reports.jsp">Generate Reports</a>
    </div>
</body>
</html>
