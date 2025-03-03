<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sportspile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap">
    <script src="./js/sticky.js" type="module" defer></script>
</head>
<body>
<div class="container">
    <header id="my-header">
        <nav class="navbar">
            <a href="#" class="logo">
                <i class="fa-solid fa-person-running"></i>
                Sportspile
            </a>
            <a href="#" class="login-button">Sign in
                <i class="fa-solid fa-user-large"></i>
            </a>
        </nav>
        <aside class="disciplines">
            <ul>
                <li><a href="#">Football</a></li>
                <li><a href="#">Basketball</a></li>
                <li><a href="#">Tennis</a></li>
                <li><a href="#">Winter Sports</a></li>
                <li><a href="#">Combat Sports</a></li>
            </ul>
        </aside>
    </header>
    <div class="rest">
        <div>
            <img src="./images/banner.jpg" alt="">
        </div>
        <main>
            <c:forEach var="news" items="${requestScope.news}">
                <article class="news">
                    <h2 class="news-header"><c:out value="${news.title}"/></h2>
                    <p class="news-details">Dodane przez: Mietek, ${news.dateAdded.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))}</p>
                    <a href="<c:out value="${news.url}"/>" target="_blank" class="news-link"><c:out value="${news.url}"/></a>
                    <p><c:out value="${news.description}"/></p>
                    <section class="news-bar">
                        <a href="#" class="news-link upvote">
                            <i class="fa-regular fa-thumbs-up news-upvote"></i>
                        </a>
                        <p class="news-votes">32</p>
                        <a href="#" class="news-link downvote">
                            <i class="fa-regular fa-thumbs-down news-downvote"></i>
                        </a>
                    </section>
                </article>
            </c:forEach>
        </main>
        <footer>Sportspile&reg, debeloped by AdamH, Last update: 27/02/2025</footer>
    </div>
</div>
</body>
</html>














