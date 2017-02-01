<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/30
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>扶贫项目未通过原因</title>
</head>
<body>
    <div align="center">
        <form action="noPass" method="post">
            <p>
                <input type="hidden" name="index" value="${index}">
            </p>
            <p>
                未通过原因：<input type="text" name="reason">
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</body>
</html>
