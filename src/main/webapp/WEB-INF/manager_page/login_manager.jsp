<%--
  Created by IntelliJ IDEA.
  User: Anton Lopatin
  Date: 08.06.2021
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Login From</title>
</head>
<body>

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
</body>
</html>
