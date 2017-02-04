<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/27
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>管理员注册</title>
</head>
<body>
    <div align="center">
        <h2>管理员注册</h2>
        <form action="registerAdmin" method="post">
            <p>
                用户名：<input type="text" name="username"/>${ERR_username}
            </p>
            <p>
                密码：<input type="password" name="password"/>${ERR_password}
            </p>
            <p>
                公司：<input type="text" name="company"/>${ERR_company}
            </p>
            <p>
                秘钥：<input type="text" name="passkey"/>${ERR_passkey}
            </p>
            <p>
                <input type="submit"/>
            </p>
            <p>
                <a href="toAdminHome">返回上一层</a>
            </p>
        </form>
    </div>

</body>
</html>
