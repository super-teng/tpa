<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/29
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>更新扶贫个人页面</title>
</head>
<body>

<div align="center">
    <form action="updateReliefPerson" method="post">
        <p>
            编号：<input type="text" name="rid" value="${reliefPerson.rid}" readonly/>${ERR_rid}
        </p>
        <p>
            用户名：<input type="text" name="username" value="${reliefPerson.username}"/>${ERR_username}
        </p>
        <p>
            密码：<input type="text" name="password" value="${reliefPerson.password}"/>${ERR_password}
        </p>
        <p>
            真实姓名：<input type="text" name="realName" value="${reliefPerson.realName}"/>${ERR_realName}
        </p>
        <p>
            出生日期：<input type="text" name="birth" value="${reliefPerson.birth}"/>${ERR_birth}
        </p>
        <p>
            住址：<input type="text" name="address" value="${reliefPerson.address}"/>${ERR_address}
        </p>
        <p>
            工作：<input type="text" name="job" value="${reliefPerson.job}"/>${ERR_job}
        </p>
        <p>
            电话号：<input type="text" name="telephone" value="${reliefPerson.telephone}" readonly/>${ERR_telephone}
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
