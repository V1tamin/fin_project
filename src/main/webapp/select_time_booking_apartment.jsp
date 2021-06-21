<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Select time</title>

    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />
    <script src="js/jquery.min.js"></script>
    <script src="js/moment-with-locales.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
<h2>booked_apartment</h2>

<form>
    <div class="form-group">
        <label for="inputDate">Введите дату:</label>
        <input name="date_booked" value="1" type="date" class="form-control">
    </div>
</form>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="booked_apartment">
    <%--<input type="hidden" name="apartment_id" value="${apartment.id}">--%>
    <input type="hidden" name="until_what_date" value="123">
    <button type="submit" class="btn btn-outline-success">Booking</button>
</form>

<fmt:message key="logOut"/>
</body>
</html>
