<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/23
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>扶贫单位注册页面</title>
</head>
<body>

        <div align="center">
            <h2>扶贫单位注册</h2>
            <form action="companyRegister" method="post">
                <p>
                    用户名：<input type="text" name="username"/>${ERR_username}
                </p>
                <p>
                    新密码：<input type="password" name="password"/>${ERR_password}
                </p>
                <p>
                    确认密码：<input type="password" name="verifyPassword"/>${ERR_verifyPassword}
                </p>
                <p>
                    电话号码：<input type="text" name="telephone"/>${ERR_telephone}
                </p>
                <p>
                    公司名称：<input type="text" name="cname"/>${ERR_cname}
                </p>
                <p>
                    公司地址：<input type="text" name="address"/>${ERR_address}
                </p>
                <p>
                    公司经营方向：<input type="text" name="detail"/>${ERR_detail}
                </p>
                <p>
                    <input type="submit">

                </p>
                <p>
                    <a href="returnHome">返回上一层</a>
                </p>
            </form>
        </div>
</body>
</html>
