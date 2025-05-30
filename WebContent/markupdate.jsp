<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student Marks</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            padding-top: 50px;
        }
        h2 {
            color: #333;
        }
        form {
            display: inline-block;
            background-color: #fff;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        input[type="text"],
        input[type="number"],
        input[type="date"] {
            width: 250px;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 25px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .back-link {
            margin-top: 20px;
            display: block;
            color: #333;
            text-decoration: none;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Update Student Marks</h2>
    <form action="UpdateMarkServlet" method="post">
        <label for="studentID">Student ID:</label><br>
        <input type="text" id="studentID" name="studentID" required><br><br>

        <label for="studentName">Student Name:</label><br>
        <input type="text" id="studentName" name="studentName" required><br><br>

        <label for="subject">Subject:</label><br>
        <input type="text" id="subject" name="subject" required><br><br>

        <label for="marks">Marks:</label><br>
        <input type="number" id="marks" name="marks" min="0" max="100" required><br><br>

        <label for="examDate">Exam Date:</label><br>
        <input type="date" id="examDate" name="examDate" required><br><br>

        <input type="submit" value="Update Marks">
    </form>
    <a class="back-link" href="index.jsp">Back to Home</a>
</body>
</html>
