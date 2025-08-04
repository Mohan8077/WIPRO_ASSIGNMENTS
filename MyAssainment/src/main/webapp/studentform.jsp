<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
    <h2>Enter Student Details</h2>
    <form action="studentResult" method="post">
        Name: <input type="text" name="studentName" required><br><br>
        Marks: <input type="number" name="studentMarks" required><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
