<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<jsp:include page="common/header.jsp"/>
<div class="container marketing" style="min-height: 100vh; margin: auto" >
    <h1>Login Form:</h1>
    <div class="card">
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/controller" method="post">
                <div class=" form-group row">
                    <input type="hidden" name="command" value="login">
                    <label class="col-sm-2 col-form-label">Login</label>
                    <div class="col-sm-7">
                        <label>
                            <input type="text" class="form-control" name="login"
                                   placeholder="Enter login">
                        </label>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-7">
                        <label>
                            <input type="password" class="form-control" name="password"
                                   placeholder="Enter password">
                        </label>
                    </div>
                </div>
                <br/>
                <button type="submit" class="btn btn-outline-success">Login</button>
            </form>
            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="reg">
                <button type="submit" class="btn btn-outline-success">Register</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>