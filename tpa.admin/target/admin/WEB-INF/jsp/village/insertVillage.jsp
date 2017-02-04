<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/2/4
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>新增自然村信息</title>
</head>
<body>

<div align="center">
    <h2>新增自然村</h2>
    <form action="insertVillage" method="post">

        <p>
            自然村名称：<input type="text" name="vname" />${ERR_vname}
        </p>
        <p>
            地址：<input type="text" name="address" />${ERR_address}
        </p>
        <p>
            总人口：<input type="text" name="population" />${ERR_population}
        </p>
        <p>
            贫困人口：<input type="text" name="povertyCount"/>${ERR_povertyCount}
        </p>
        <p>
            年生产总值：<input type="text" name="gdp"/>${ERR_gdp}
        </p>
        <p>
            自然村特色：<input type="text" name="feature" />${ERR_feature}
        </p>
        <p>
            自然村贫困等级：<input type="text" name="vlevel"/>${ERR_vlevel}
        </p>
        <p>
            <input type="submit">
        </p>
    </form>
    <a href="toVillage?pageNumber=1">返回上一层</a>
</div>
</body>
</html>
