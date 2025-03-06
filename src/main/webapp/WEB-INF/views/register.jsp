<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register - Sportspile</title>
    <%@ include file="../segments/head.jspf"%>
    <link rel="stylesheet" href="${pageContext.request.cntextPath}/styles/forms.css">
</head>
<body>
<div class="container">
    <header id="my-header">
        <%@ include file="../segments/nav.jspf"%>
    </header>
    <div class="rest">
        <form action="${pageContext.request.contextPath}/signup" method="post" class="user-form">
            <h2 class="user-form-title">Register on Sportspile</h2>
            <input name="username" placeholder="Username" required>
            <input name="email" placeholder="E-mail" type="email" required>
            <input name="password" placeholder="Password" type="password" required>
            <button class="user-form-button">Register</button>
        </form>
        <%@ include file="../segments/footer.jspf"%>
    </div>
</div>
</body>
</html>