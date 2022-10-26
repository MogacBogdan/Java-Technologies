<%--
  Created by IntelliJ IDEA.
  User: IPanzariu
  Date: 10/4/2022
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Result page</title>
    <style>
        table, th, td {
            border: 2px inset black;
            border-collapse: collapse;
            padding: 10px;
            align-content: center;
        }

    </style>
</head>
<body>
<h1>Result page</h1>

<table>
    <tr>
        <th>Nr.</th>
        <th>Permutation</th>
    </tr>
    <c:forEach var="permutation" items="${permutations}" varStatus="loop">
         <tr>
             <td>${loop.index}</td>
             <td>${permutation}</td>
         </tr>
     </c:forEach>
</table>
<h1><a href="/Laboratory1_war/">Back to the form</a></h1>
</body>
</html>