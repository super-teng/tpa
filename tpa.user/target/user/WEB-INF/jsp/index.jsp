<html>
<head>
    <title>精准扶贫系统</title>
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
    <h2>精准扶贫系统</h2>
    <form action="login" method="post">
        <p>用户名：<input type="text" name="username"></p>
        <p>密码：<input type="password" name="password"></p>
        <input type="radio" name="identity" value="扶贫个人" checked="checked"/>扶贫个人
        <input type="radio" name="identity" value="扶贫单位"/>扶贫单位
        <p>
            验证码：<input type="text" name="vcode">
            <img  id="vcode" src="vcode" onclick="changeCode()"> ${vcodeMessage}
        </p>
        <p>
            <input type="submit">${message}
        </p>
        <p>
            <a href="reliefPersonRegister">扶贫个人注册</a>
            <a href="reliefCompanyRegister">扶贫单位注册</a>
        </p>
        <p>
            <a href="http://localhost:8080/admin">管理员登录</a>
        </p>
    </form>
</div>
</body>
</html>
