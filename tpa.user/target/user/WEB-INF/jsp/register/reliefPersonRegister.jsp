<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/23
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>扶贫个人注册页面</title>
</head>

<body>

    <div align="center">
        <h2>扶贫个人注册</h2>
        <form action="personRegister" method="post" onsubmit="return check();">
            <p>
                用户名：<input type="text" name="username"/> ${ERR_username}
            </p>
            <p>
                新密码：<input type="password" name="password" />${ERR_password}
            </p>
            <p>
                确认密码：<input type="password" name="verifyPassword"/>${ERR_verifyPassword}
            </p>
            <p>
                电话号码:<input type="text" name="telephone"/>${ERR_telephone}
            </p>
            <p>
                真实姓名：<input type="text" name="realName"/>${ERR_realName}
            </p>
            <p>
                出生日期：<input type="date" name="birth" value="2017-01-01"/>
            </p>
            <p>
                住址：<input type="text" name="address"/>${ERR_address}
            </p>
            <p>
                工作：<input type="text" name="job"/>${ERR_job}
            </p>
            <p>
                月收入情况：
                <input type="radio" name="incomeDetail" value="0-3000"/>0-3000
                <input type="radio" name="incomeDetail" value="3000-6000" checked="checked"/>3000-6000
                <input type="radio" name="incomeDetail" value="6000-10000"/>6000-10000
                <input type="radio" name="incomeDetail" value="10000-150000"/>10000-15000
                <input type="radio" name="incomeDetail" value="15000-20000"/>15000-20000
                <input type="radio" name="incomeDetail" value="20000+"/>20000+
            </p>
            <p>
                是否有贫困亲属：
                <input type="radio" name="hasPovertyRelative" value="true">是
                <input type="radio" name="hasPovertyRelative" value="false" checked="checked">否
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</body>
</html>
