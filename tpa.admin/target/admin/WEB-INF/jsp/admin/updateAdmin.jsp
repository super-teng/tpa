<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/27
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>管理员更新页面</title>
</head>
<body>
    <div align="center">
        <form action="updateAdmin" method="post">
            <p>
                用户名：<input type="text" name="username" value="${admin.username}"/>${ERR_username}
            </p>
            <p>
                密码：<input type="password" name="password" value="${admin.password}"/>${ERR_password}
            </p>
            <p>
                公司：<input type="text" name="company" value="${admin.company}"/>${ERR_company}
            </p>
            <p>
                秘钥：<input type="text" name="passkey" value="${admin.passkey}" readonly/>${ERR_passkey}
            </p>
            <p>
                <input type="submit"/>
            </p>
            <a href="toAdmin">返回上一层</a>
        </form>
    </div>
</body>
</html>
