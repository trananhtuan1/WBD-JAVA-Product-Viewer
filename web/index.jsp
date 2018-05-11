<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/10/2018
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  </body>

  <h1>Customers</h1>

  <table border="1">
    <strong>${requestScope['products'][0].getName()}</strong>
    <tr>
      <td>Id</td>
      <td>Code</td>
      <td>Name</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
      <tr>
        <td><a href="/products?action=view&id=${product.getId()}">${product.getId()}</a></td>
        <td>${product.getCode()}</td>
        <td>${product.getName()}</td>
      </tr>
    </c:forEach>
  </table>
</html>
