<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/carousel/"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<h2>All clients</h2>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="add_user">
    <button class="btn btn-outline-success m-3">Add new user</button>
</form>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="admin_patrol">
    <button type="submit" class="btn btn-outline-success m-3">Back</button>
</form>

<table>
    <c:forEach var="client" items="${clients}">
        <table style="margin: auto" border="1">
            <tr style="margin-left: 25px">
                <li> ID: ${client.id}</li>
                <li>First Name: ${client.firstname}</li>
                <li>Last Name: ${client.lastname}</li>
                <li>Patronymic: ${client.patronymic}</li>
                <li>Login: ${client.login}</li>
                <li>Password: ${client.password}</li>

                <form action="${pageContext.request.contextPath}/controller" method="post">
                    <input type="hidden" name="command" value="delete_user">
                    <input type="hidden" name="id" value="${client.id}">
                    <button class="btn btn-outline-success m-3">Delete</button>
                </form>

                <form action="${pageContext.request.contextPath}/controller" method="post">
                    <input type="hidden" name="command" value="edit_user">
                    <input type="hidden" name="id" value="${client.id}">
                    <button class="btn btn-outline-success m-3">Edit</button>
                </form>
                <hr>
            </tr>
        </table>
    </c:forEach>
</table>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="admin_patrol">
    <button type="submit" class="btn btn-outline-success">Back</button>
</form>
</body>
</html>
