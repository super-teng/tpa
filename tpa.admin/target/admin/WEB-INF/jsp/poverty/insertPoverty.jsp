<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/2/4
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>新增贫困个人</title>
</head>
<body>


<div align="center">
    <h2>新增贫困个人</h2>
    <form action="insertPoverty" method="post">
        <p>
            姓名：<input type="text" name="pName"/>${ERR_pName}
        </p>
        <p>
            性别：<input type="text" name="sex" />${ERR_sex}
        </p>
        <p>
            生日：<input type="date" name="birth" />
        </p>
        <p>
            住址：<input type="text" name="address" />${ERR_address}
        </p>
        <p>
            是否有收入：
            <input type="radio" name="hasIncome" value="true" checked="checked">有
            <input type="radio" name="hasIncome" value="false">没有
        </p>${ERR_hasIncome}
        <p>
            收入情况：<input type="text" name="incomeDetail" />${ERR_incomeDetail}
        </p>
        <p>
            工作：<input type="text" name="job" />${ERR_job}
        </p>
        <p>
            疾病情况：<input type="text" name="illness" />${ERR_illness}
        </p>
        <p>
            疾病原因：<input type="text" name="povertyReason" />${ERR_povertyReason}
        </p>
        <p>
            贫困等级：<input type="text" name="pLevel" />${ERR_pLevel}
        </p>
        <p>
            <input type="submit">
        </p>
    </form>
    <a href="toPoverty?pageNumber=1">返回上一层</a>
</div>
</body>
</html>
