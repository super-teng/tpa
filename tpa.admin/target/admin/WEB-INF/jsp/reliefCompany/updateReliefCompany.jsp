<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/29
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>更新扶贫单位信息</title>
</head>
<body>

<div align="center">
    <h2>更新扶贫单位</h2>
    <form action="updateCompany" method="post">
        <p>
            用户名：<input type="text" name="username" value="${reliefCompany.username}"/>${ERR_username}
        </p>
        <p>
            新密码：<input type="password" name="password" value="${reliefCompany.password}"/>${ERR_password}
        </p>
        <p>
            确认密码：<input type="password" name="verifyPassword" value="${reliefCompany.password}"/>${ERR_verifyPassword}
        </p>
        <p>
            电话号码：<input type="text" name="telephone" value="${reliefCompany.telephone}" readonly/>${ERR_telephone}
        </p>
        <p>
            公司名称：<input type="text" name="cname" value="${reliefCompany.cname}"/>${ERR_cname}
        </p>
        <p>
            公司地址：<input type="text" name="address" value="${reliefCompany.address}"/>${ERR_address}
        </p>
        <p>
            公司经营方向：<input type="text" name="detail" value="${reliefCompany.detail}"/>${ERR_detail}
        </p>
        <p>
            <input type="submit">
        </p>
    </form>
</div>
</body>
</html>
