<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" style="margin: auto">
        <div class="container-fluid">
            <c:set var="auth" scope="session" value="${userLoggedIn}"/>
            <c:choose>
                <c:when test="${auth != true}">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Hotel</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarCollapse"
                            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <ul class="navbar-nav me-auto mb-2 mb-md-0">
                            <li class="nav-item">
                                <form action="${pageContext.request.contextPath}/controller" method="post">
                                    <input type="hidden" name="command" value="login">
                                    <button class="btn btn-outline-success">Login</button>
                                </form>
                            </li>
                            <p>&nbsp;</p>
                            <li class="nav-item">
                                <form action="${pageContext.request.contextPath}/controller" method="post">
                                    <input type="hidden" name="command" value="apartments">
                                    <button class="btn btn-outline-success">Apartments</button>
                                </form>
                            </li>
                        </ul>
                    </div>
                </c:when>

                <c:when test="${userLoggedIn == true}">
                    <div style="float: left">
                        <p style="margin-bottom: 0; size: A3; color: aliceblue">${user.firstname} ${user.lastname}</p>
                    </div>

                    <div style="float: right">
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                Settings
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                <li><a class="dropdown-item" href="controller?command=booked_rooms">Booked rooms</a></li>
                                <li><a class="dropdown-item" href="controller?command=list_requests">List requests</a></li>
                                <li><a class="dropdown-item" href="controller?command=logout">Log out</a></li>
                            </ul>
                        </div>
                    </div>
                </c:when>
            </c:choose>
        </div>
    </nav>
</header>

