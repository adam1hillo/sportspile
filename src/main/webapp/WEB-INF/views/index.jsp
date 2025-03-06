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
        <aside class="disciplines">
            <ul>
                <c:forEach var="discipline" items="${requestScope.disciplines}">
                    <li><a href="${pageContext.request.contextPath}/discipline?id=${discipline.id}">${discipline.name}</a></li>
                </c:forEach>
            </ul>
        </aside>
    </header>
    <div class="rest">
        <div>
            <img src="${pageContext.request.contextPath}/images/banner.jpg" alt="">
        </div>
        <main>
            <%@ include file="../segments/news-list.jspf"%>
        </main>
        <%@ include file="../segments/footer.jspf"%></div>
</div>
</body>
</html>














