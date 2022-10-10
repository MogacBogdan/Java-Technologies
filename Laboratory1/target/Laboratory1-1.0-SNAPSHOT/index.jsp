<%@ page import="java.util.Objects" %>
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
    <label for="category">Category : </label><input type="text" id="category" name="category"
        <%
            String selectedCategory = null;
            Cookie[] cookies = null;
            
            cookies = request.getCookies();
            
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("PermutationServlet.categoryCookie")) {
                        selectedCategory = cookie.getValue();
                    }
                }
            }
            if (selectedCategory != null ){
               out.println("value=" + selectedCategory);
               System.out.println("UA BUHAIULE");
            } else {
                System.out.println("UA PROSTULE");
            }
        %>
    >
    <input type="submit" value="Submit">
</form>
</body>
</html>