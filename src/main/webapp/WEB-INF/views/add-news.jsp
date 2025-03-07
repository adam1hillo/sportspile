<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add something yourself - Sportspile</title>
    <%@ include file="../segments/head.jspf"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/add-news-form.css">
</head>
<body>
<div class="container">
    <header id="my-header">
        <%@ include file="../segments/nav.jspf"%>
    </header>
    <div class="rest">
        <form action="${pageContext.request.contextPath}//news/add" method="post" class="news-form">
            <h2 class="news-form-title">Add something new</h2>
            <input name="title" placeholder="Title" required>
            <input name="url" placeholder="URL" type="url" required>
            <select name="disciplineId">
                <c:forEach var="discipline" items="${requestScope.disciplines}">
                    <option value="${discipline.id}">${discipline.name}</option>
                </c:forEach>
            </select>
            <textarea name="description" placeholder="Description"></textarea>
            <button class="news-form-button">Add</button>
        </form>
        <%@ include file="../segments/footer.jspf"%>
    </div>
</div>
</body>
</html>