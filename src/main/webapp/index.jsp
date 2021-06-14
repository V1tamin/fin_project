<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en" >
<head>
    <title>Hotel</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/carousel/"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<main>
    <jsp:include page="common/header.jsp"/><br><br>
    <div class="container marketing" style="min-height: 100vh">
        <hr class="featurette-divider">
        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">First featurette heading. <span
                        class="text-muted">It'll blow your mind.</span></h2>
                <p class="lead">Some great placeholder content for the first featurette here. Imagine some exciting
                    prose here.</p>
            </div>
            <div class="col-md-5">
                <img src="img/apartment.jpg" class="img-fluid" alt="Error">
            </div>
            <div>
                <form action="${pageContext.request.contextPath}/controller" method="post">
                    <input type="hidden" name="command" value="apartments">
                    <button class="btn btn-outline-success">Booking</button>
                </form>
            </div>
        </div>
        <hr class="featurette-divider">
    </div>
    <hr class="featurette-divider">
    <jsp:include page="common/footer.jsp"/>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>
