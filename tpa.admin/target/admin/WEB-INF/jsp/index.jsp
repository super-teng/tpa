<html>
<head>
    <title>精准扶贫系统管理员系统</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">
    var i = 1;
    function changeCode() {
        document.getElementById('vcode').src="vcode?v=" + (i++);
    }

</script>
<div align="center">
    <h2>精准扶贫系统管理员后台登录</h2>
    <form action="adminLogin" method="post">
        <p>用户名：<input type="text" name="username"></p>
        <p>密码：<input type="password" name="password"></p>
        <p>
            验证码：<input type="text" name="vcode">
            <img  id="vcode" src="vcode" onclick="changeCode()"> ${vcodeMessage}
        </p>
        <p>
            <input type="submit">${message}
        </p>
        <p>
            <a href="toRegisterAdmin">管理员注册</a>
        </p>
        <a href="http://localhost:8080/">扶贫用户登录页面</a>
    </form>
</div>
</body>
</html>
