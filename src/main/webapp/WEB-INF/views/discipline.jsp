<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sportspile</title>
    <%@include file="../segments/head.jspf"%>
</head>
<body>
<div class="container">
    <header id="my-header">
        <%@ include file="../segments/nav.jspf"%>
    </header>
    <div class="rest">
        <main>
            <h1>${requestScope.discipline.name}</h1>
            <p>${requestScope.discipline.description}</p>
            <%@ include file="../segments/news-list.jspf"%>
        </main>
        <%@ include file="../segments/footer.jspf"%>
    </div>
</div>
</body>
</html>














