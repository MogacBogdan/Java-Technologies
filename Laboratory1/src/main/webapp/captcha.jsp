<%--
  Created by IntelliJ IDEA.
  User: IPanzariu
  Date: 10/18/2022
  Time: 7:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Captcha</title>
</head>
<body>
    <h1>Captcha page</h1>

    <form action="verify" method="post">
        <img src="imageServlet" width="150" height="100" alt="captcha">

        <label for="captcha"> Captcha </label><input type="text" id="captcha" name="captcha">
        <input type="submit" value="submit">
    </form>
</body>
</html>
