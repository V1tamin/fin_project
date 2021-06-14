<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <style>
        .category-wrap {
            padding: 15px;
            background: white;
            width: 200px;
            box-shadow: 2px 2px 8px rgba(0, 0, 0, .1);
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        }

        .category-wrap h3 {
            font-size: 16px;
            color: rgba(0, 0, 0, .6);
            margin: 0 0 10px;
            padding: 0 5px;
            position: relative;
        }

        .category-wrap h3:after {
            content: "";
            width: 6px;
            height: 6px;
            background: #80C8A0;
            position: absolute;
            right: 5px;
            bottom: 2px;
            box-shadow: -8px -8px #80C8A0, 0 -8px #80C8A0, -8px 0 #80C8A0;
        }

        .category-wrap ul {
            list-style: none;
            margin: 0;
            padding: 0;
            border-top: 1px solid rgba(0, 0, 0, .3);
        }

        .category-wrap li {
            margin: 12px 0 0 0;
        }

        .category-wrap a {
            text-decoration: none;
            display: block;
            font-size: 13px;
            color: rgba(0, 0, 0, .6);
            padding: 5px;
            position: relative;
            transition: .3s linear;
        }

        .category-wrap a:after {
            content: "\f18e";
            font-family: FontAwesome, serif;
            position: absolute;
            right: 5px;
            color: white;
            transition: .2s linear;
        }

        .category-wrap a:hover {
            background: #80C8A0;
            color: white;
        }
    </style>
</head>
<body>
<div class="category-wrap">
    <h3>Категории</h3>
    <ul>
        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="all_clients">
            <li>
                <button>Все клиенты</button>
            </li>
        </form>

        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="all_managers">
            <li>
                <button>Все менеджеры</button>
            </li>
        </form>

        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="all_apartments">
            <li>
                <button>Все номера</button>
            </li>
        </form>

        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="logout">
            <li>
                <button>Выход</button>
            </li>
        </form>
    </ul>
</div>
</body>
</html>
