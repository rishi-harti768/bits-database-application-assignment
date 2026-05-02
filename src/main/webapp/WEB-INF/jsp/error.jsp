<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #fff3f3; text-align: center; }
        .error-container { background: white; padding: 30px; border: 2px solid #ff4c4c; border-radius: 8px; max-width: 600px; margin: auto; }
        h1 { color: #ff4c4c; }
        .back-link { display: inline-block; margin-top: 20px; padding: 10px 20px; background-color: #0056b3; color: white; text-decoration: none; border-radius: 5px; }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>An Error Occurred!</h1>
        <p><strong>Error Message:</strong> ${errorMessage}</p>
        <a href="${pageContext.request.contextPath}/books" class="back-link">Return to Book List</a>
    </div>
</body>
</html>
