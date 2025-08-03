<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>List of Books</title>
</head>
<body>
    <h1 style="color:black; font-size:28px; font-weight:bold;">Books Management</h1>

    <a href="book?action=new">Add New Book</a> |
    <a href="book?action=list">List All Books</a>

    <h3>List of Books</h3>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Actions</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listBooks}">
                <c:forEach var="book" items="${listBooks}">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.price}</td>
                        <td>
                            <!-- You can add edit/delete links here -->
                            Edit | Delete
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="5">Koi book database mein nahi mili.</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</body>
</html>
