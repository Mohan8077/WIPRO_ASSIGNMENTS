<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Result</title></head>
<body>
    <h2>Sorry <%= request.getAttribute("name") %>,</h2>
    <p>You failed with <%= request.getAttribute("marks") %> marks.</p>
    <jsp:include page="studentfooter.jsp" />
</body>
</html>
