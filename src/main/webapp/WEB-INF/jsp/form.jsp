<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Form</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; }
        .form-container { background: white; padding: 20px; border-radius: 8px; box-shadow: 0px 0px 10px 0px #0000001a; max-width: 500px; margin: auto; }
        h2 { color: #333; text-align: center; }
        .form-group { margin-bottom: 15px; }
        label { display: block; font-weight: bold; margin-bottom: 5px; }
        input[type="text"], input[type="number"], select { width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
        .btn { width: 100%; padding: 10px; background-color: #0056b3; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }
        .btn:hover { background-color: #004494; }
        .back-link { display: block; text-align: center; margin-top: 15px; text-decoration: none; color: #0056b3; }
    </style>
</head>
<body>
    <div class="form-container">
        <c:choose>
            <c:when test="${not empty book.id}">
                <h2>Edit Book</h2>
                <c:set var="actionUrl" value="${pageContext.request.contextPath}/books/update" />
            </c:when>
            <c:otherwise>
                <h2>Add New Book</h2>
                <c:set var="actionUrl" value="${pageContext.request.contextPath}/books/save" />
            </c:otherwise>
        </c:choose>

        <form action="${actionUrl}" method="post">
            <c:if test="${not empty book.id}">
                <input type="hidden" name="id" value="${book.id}" />
            </c:if>

            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" value="${book.title}" required />
            </div>

            <div class="form-group">
                <label for="genre">Genre:</label>
                <input type="text" id="genre" name="genre" value="${book.genre}" required />
            </div>

            <div class="form-group">
                <label for="publicationYear">Publication Year:</label>
                <input type="number" id="publicationYear" name="publicationYear" value="${book.publicationYear}" required />
            </div>

            <div class="form-group">
                <label for="author">Author:</label>
                <select id="author" name="author.id" required>
                    <option value="">-- Select Author --</option>
                    <c:forEach var="author" items="${authors}">
                        <option value="${author.id}" <c:if test="${author.id == book.author.id}">selected</c:if>>${author.name}</option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn">Save</button>
        </form>
        <a href="${pageContext.request.contextPath}/books" class="back-link">Back to List</a>
    </div>
</body>
</html>
