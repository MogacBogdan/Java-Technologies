<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Permutations of a word!" %>
</h1>
<br/>
<form action="permutations" method="get">
    <label for="word">Word : </label><input type="text" id="word" name="word">
    <label for="size">Size : </label><input type="text" id="size" name="size" value="0">
    <input type="submit" value="Submit">
</form>
</body>
</html>