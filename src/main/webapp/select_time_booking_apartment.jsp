<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>

    <!-- 1. Подключить CSS-файл Bootstrap 3 -->
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <!-- 2. Подключить CSS-файл библиотеки Bootstrap 3 DateTimePicker -->
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css" />
    <!-- 3. Подключить библиотеку jQuery -->
    <script src="js/jquery.min.js"></script>
    <!-- 4. Подключить библиотеку moment -->
    <script src="js/moment-with-locales.min.js"></script>
    <!-- 5. Подключить js-файл фреймворка Bootstrap 3 -->
    <script src="js/bootstrap.min.js"></script>
    <!-- 6. Подключить js-файл библиотеки Bootstrap 3 DateTimePicker -->
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
</body>
</html>
