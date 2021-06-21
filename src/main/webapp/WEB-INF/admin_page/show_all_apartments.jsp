<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Rooms</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/carousel/"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<h2>All rooms</h2>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="create_new_room_admin">
    <button class="btn btn-outline-success m-3">Add new room</button>
</form>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="admin_patrol">
    <button type="submit" class="btn btn-outline-success m-3">Back</button>
</form>

<c:forEach var="room" items="${apartments}">
    <div style="margin: 10px">
        <table style="margin: auto" border="1">
            <tr style="margin-left: 25px">
                <li> ID: ${room.id}</li>
                <li>Description: ${room.description}</li>
                <li>Places: ${room.places}</li>
                <li>Price: ${room.price}</li>
                <li><img src="${room.photoUrl}" style="size: 500px;"></li>

                <form action="${pageContext.request.contextPath}/controller" method="post">
                    <input type="hidden" name="command" value="delete_room">
                    <input type="hidden" name="id" value="${room.id}">
                    <button class="btn btn-outline-success m-3">Delete</button>
                </form>

                <form action="${pageContext.request.contextPath}/controller" method="post">
                    <input type="hidden" name="command" value="edit_room">
                    <input type="hidden" name="id" value="${room.id}">
                    <button class="btn btn-outline-success m-3">Edit</button>
                </form>
                <hr>
            </tr>
        </table>
    </div>
</c:forEach>

<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="admin_patrol">
    <button type="submit" class="btn btn-outline-success">Back</button>
</form>
</body>
</html>
