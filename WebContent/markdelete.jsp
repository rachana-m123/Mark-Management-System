<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Student Marks</title>
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
        input[type="text"] {
            width: 250px;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #f44336;
            color: white;
            padding: 12px 25px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
        }
        input[type="submit"]:hover {
            background-color: #d32f2f;
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
    <h2>Delete Student Marks</h2>
    <form action="DeleteMarkServlet" method="post">
        <label for="studentID">Student ID:</label><br>
        <input type="text" id="studentID" name="studentID" required><br><br>

        <input type="submit" value="Delete Marks">
    </form>
    <a class="back-link" href="index.jsp">Back to Home</a>
</body>
</html>
