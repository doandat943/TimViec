<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Apply Page</title>
</head>
<body>

    <h2>Application Status</h2>
    
    <c:if test="${not empty requestScope.error}">
        <p style="color: green;">${requestScope.error}</p>
    </c:if>

    <form action="ApplyServlet" method="post" enctype="multipart/form-data">
        
        <label>Resume File:</label>
        <input type="file" name="file" accept=".pdf, .doc, .docx" required><br>

        <input type="submit" value="Submit Application">
    </form>

</body>
</html>
