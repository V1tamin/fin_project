<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert new user</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="container marketing" style="min-height: 100vh">
    <h1>Register Form:</h1>
    <div class="card">
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="create_new_user_admin">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">First Name</label>
                    <div class="col-sm-7">
                        <label>
                            <input type="text" class="form-control" name="firstname"
                                   placeholder="Enter firstname">
                        </label>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Last Name</label>
                    <div class="col-sm-7">
                        <label>
                            <input type="text" class="form-control" name="lastname"
                                   placeholder="Enter lastname">
                        </label>
                    </div>
                </div>

                <div class=" form-group row">
                    <label class="col-sm-2 col-form-label">User
                        Name</label>
                    <div class="col-sm-7">
                        <label>
                            <input type="text" class="form-control" name="login"
                                   placeholder="Enter user name">
                        </label>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-7">
                        <label>
                            <input type="password" class="form-control" name="password"
                                   placeholder="Enter Password">
                        </label>
                    </div>
                </div>
                <button type="submit" class="btn btn-outline-success">Create</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>