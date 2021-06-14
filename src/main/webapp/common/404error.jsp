<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
</head>
<body>
<div class="container marketing" style="min-height: 100vh">
    <h2>Ooopss.. something went wrong!</h2>
    <br>
    <img src="https://static-cdn.jtvnw.net/jtv_user_pictures/55d2c6d9-9d70-40e2-b30b-773ea9b19cd6-profile_image-300x300.png"
         alt="ERROR!"/>
    <br>
    <form action="${pageContext.request.contextPath}/controller" method="post">
        <input type="hidden" name="command" value="index">
        <button type="submit" class="btn btn-outline-success">Back</button>
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
