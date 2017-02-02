<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/24
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>扶贫个人信息维护</title>
</head>
<body>
    <div align="center">
        <form action="updatePerson" method="post">
            <p>
                用户名：<input type="text" name="username" value="${sessionScope.reliefPerson.username}"/> ${ERR_username}
            </p>
            <p>
                新密码：<input type="password" name="password" value="${sessionScope.reliefPerson.password}"/>${ERR_password}
            </p>
            <p>
                确认密码：<input type="password" name="verifyPassword" value="${sessionScope.reliefPerson.password}"/>${ERR_verifyPassword}
            </p>
            <p>
                电话号码:<input type="text" name="telephone" value="${sessionScope.reliefPerson.telephone}" readonly/>${ERR_telephone}
            </p>
            <p>
                真实姓名：<input type="text" name="realName" value="${sessionScope.reliefPerson.realName}"/>${ERR_realName}
            </p>
            <p>
                出生日期：<input type="date" name="birth" value="${sessionScope.reliefPerson.birth}"/>
            </p>
            <p>
                住址：<input type="text" name="address" value="${sessionScope.reliefPerson.address}"/>${ERR_address}
            </p>
            <p>
                工作：<input type="text" name="job" value="${sessionScope.reliefPerson.job}"/>${ERR_job}
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
            <a href="returnHome">返回上一层</a>
        </form>
    </div>
</body>
</html>
