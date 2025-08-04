<%@ page import="beans1.Account" %>
<jsp:useBean id="acc" class="beans1.Account" scope="request" />
<jsp:setProperty name="acc" property="*" />

<%
    String accType = request.getParameter("accountType");
    session.setAttribute("accountType", accType);
%>

<!DOCTYPE html>
<html>
<head><title>Account Details</title></head>
<body>
    <h2>Account Information</h2>

    Account No: ${acc.accNo}<br><br>
    Name: ${acc.name}<br><br>
    Balance: ${acc.balance}<br><br>

    Account Type (from session): ${sessionScope.accountType}<br><br>

    <!-- Conditional display -->
    <c:choose>
        <c:when test="${acc.balance >= 1000}">
            <span style="color:green;">Sufficient Balance</span>
        </c:when>
        <c:otherwise>
            <span style="color:red;">Insufficient Balance</span>
        </c:otherwise>
    </c:choose>
</body>
</html>
