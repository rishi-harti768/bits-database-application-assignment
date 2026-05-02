<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Library Manager</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; }
        h1 { color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        table, th, td { border: 1px solid #ddd; }
        th, td { padding: 12px; text-align: left; }
        th { background-color: #0056b3; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        a { text-decoration: none; color: #0056b3; }
        .btn { display: inline-block; padding: 10px 15px; background-color: #28a745; color: white; border-radius: 5px; margin-bottom: 15px; }
        .btn:hover { background-color: #218838; }
        .btn-edit { background-color: #ffc107; color: black; padding: 5px 10px; border-radius: 3px; }
    </style>
</head>
<body>
    <h1>Library Management - Books</h1>
    <a href="${pageContext.request.contextPath}/books/new" class="btn">Add New Book</a>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Genre</th>
                <th>Publication Year</th>
                <th>Author</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.genre}</td>
                    <td>${book.publicationYear}</td>
                    <td>${book.author.name}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/books/edit/${book.id}" class="btn-edit">Edit</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty books}">
                <tr>
                    <td colspan="6" style="text-align:center;">No books found.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
</body>
</html>
