<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Generate Student Reports</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f3;
            padding: 30px;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        .report-form {
            background-color: #fff;
            padding: 25px;
            border-radius: 8px;
            max-width: 500px;
            margin: 0 auto;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .report-form label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }
        .report-form input[type="text"],
        .report-form input[type="number"],
        .report-form select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .report-form input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 25px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 20px;
        }
        .report-form input[type="submit"]:hover {
            background-color: #45a049;
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
    <h2>Generate Student Reports</h2>
    <div class="report-form">
        <form action="ReportServlet" method="post">
            <label for="reportType">Select Report Type:</label>
            <select id="reportType" name="reportType" required>
                <option value="">--Select--</option>
                <option value="aboveThreshold">Students with Marks Above Threshold</option>
                <option value="specificSubject">Students in Specific Subject</option>
                <option value="topN">Top N Students</option>
            </select>

            <div id="thresholdInput" style="display:none;">
                <label for="threshold">Enter Threshold Marks:</label>
                <input type="number" id="threshold" name="threshold" min="0" max="100">
            </div>

            <div id="subjectInput" style="display:none;">
                <label for="subject">Enter Subject Name:</label>
                <input type="text" id="subject" name="subject">
            </div>

            <div id="topNInput" style="display:none;">
                <label for="topN">Enter N (Number of Top Students):</label>
                <input type="number" id="topN" name="topN" min="1">
            </div>

            <input type="submit" value="Generate Report">
        </form>
    </div>
    <a class="back-link" href="index.jsp">Back to Home</a>

    <script>
        const reportTypeSelect = document.getElementById('reportType');
        const thresholdInput = document.getElementById('thresholdInput');
        const subjectInput = document.getElementById('subjectInput');
        const topNInput = document.getElementById('topNInput');

        reportTypeSelect.addEventListener('change', function() {
            thresholdInput.style.display = 'none';
            subjectInput.style.display = 'none';
            topNInput.style.display = 'none';

            if (this.value === 'aboveThreshold') {
                thresholdInput.style.display = 'block';
            } else if (this.value === 'specificSubject') {
                subjectInput.style.display = 'block';
            } else if (this.value === 'topN') {
                topNInput.style.display = 'block';
            }
        });
    </script>
</body>
</html>
