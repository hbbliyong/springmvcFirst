<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/9
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JQueryTest</title>
    <script type="text/javascript"  src="/assets/js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#add').click(function () {
                $('#test').append('<h2>Hello Spring MVC</h2>')
            });
        });
    </script>
</head>
<body>
<input id="add" type="button" value="增加"/>
<h1 id="test">Hello</h1>

</body>
</html>
