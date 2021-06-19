<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Apartments</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/carousel/"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<c:forEach var="room" items="${apartments}">

    <c:choose>
        <c:when test="${room.apartmentStatusId != null}">
            <div style="margin: 10px">
                <h2>${room.description}</h2>

                    <c:if test="${room.apartmentStatusId == 1}">
                        <h2>Clear</h2>
                    </c:if>

                <img src="${room.photoUrl}" style="width: 500px; height: 500px"/>

                <form action="${pageContext.request.contextPath}/controller" method="post">
                    <input type="hidden" name="command" value="select_time_booked">
                    <input type="hidden" name="apartment_id" value="${room.id}">
                    <button class="btn btn-outline-success" style="margin-top: 10px">Booking</button>
                </form>
                <hr>
            </div>

        </c:when>
    </c:choose>


</c:forEach>

</body>
</html>
