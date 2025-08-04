<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Result</title></head>
<body>
    <h2>Congratulations <%= request.getAttribute("name") %>!</h2>
    <p>You passed with <%= request.getAttribute("marks") %> marks.</p>
    <jsp:include page="studentfooter.jsp" />
</body>
</html>
