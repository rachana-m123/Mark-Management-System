<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Add Student Mark</title>
</head>
<body>
    <h2>Add Student Mark</h2>
    <form action="AddMarkServlet" method="post">
        Student ID: <input type="text" name="studentID" required><br>
        Student Name: <input type="text" name="studentName" required><br>
        Subject: <input type="text" name="subject" required><br>
        Marks: <input type="number" name="marks" required><br>
        Exam Date: <input type="date" name="examDate" required><br>
        <input type="submit" value="Add Mark">
    </form>
</body>
</html>
