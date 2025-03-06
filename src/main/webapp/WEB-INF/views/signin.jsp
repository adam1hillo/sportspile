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
        <form action="j_security_check" method="post" class="user-form">
            <h2 class="user-form-title">Register on Sportspile</h2>
            <input name="j_username" placeholder="Username" required>
            <input name="j_password" placeholder="Password" type="password" required>
            <button class="user-form-button">Register</button>
            <p>Need new account? <a href="${pageContext.request.contextPath}/signup">Register</a></p>
        </form>
        <%@ include file="../segments/footer.jspf"%>
    </div>
</div>
</body>
</html>