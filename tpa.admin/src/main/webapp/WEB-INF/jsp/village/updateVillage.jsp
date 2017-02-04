<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/29
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>更新自然村信息</title>
</head>
<body>

<div align="center">
    <form action="updateVillage" method="post">
        <p>
            编号：<input type="text" name="vid" value="${village.vid}" readonly/>${ERR_vid}
        </p>
        <p>
            自然村名称：<input type="text" name="vname" value="${village.vname}"/>${ERR_vname}
        </p>
        <p>
            地址：<input type="text" name="address" value="${village.address}"/>${ERR_address}
        </p>
        <p>
            总人口：<input type="text" name="population" value="${village.population}"/>${ERR_population}
        </p>
        <p>
            贫困人口：<input type="text" name="povertyCount" value="${village.povertyCount}"/>${ERR_povertyCount}
        </p>
        <p>
            年生产总值：<input type="text" name="gdp" value="${village.gdp}"/>${ERR_gdp}
        </p>
        <p>
            自然村特色：<input type="text" name="feature" value="${village.feature}"/>${ERR_feature}
        </p>
        <p>
            自然村贫困等级：<input type="text" name="vlevel" value="${village.vlevel}"/>${ERR_vlevel}
        </p>
        <p>
            <input type="submit">
        </p>
    </form>
    <a href="toVillage?pageNumber=1">返回上一层</a>
</div>
</body>
</html>
