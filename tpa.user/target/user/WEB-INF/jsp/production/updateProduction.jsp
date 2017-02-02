<%@ page import="com.nefu.software.tpa.entity.entity.Production" %><%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/26
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>更新扶贫计划</title>
</head>
<body>
    <div align="center">
        <h2>更新扶贫项目</h2>
        <%
            Production production = (Production) request.getSession().getAttribute("production");
        %>
        <form action="updateProduction" method="post">
            <p>
                项目名称：<input type="text" name="pName" value="<%=production.getpName()%>" readonly/>${ERR_pName}
            </p>
            <p>
                项目内容: <input type="text" name="detail" value="<%=production.getDetail()%>"/>${ERR_detail}
            </p>
            <p>
                帮扶对象:
                <input type="radio" name="flag" value="povertyFlag" checked="checked">贫困个人
                <input type="radio" name="flag" value="reliefFlag">自然村
            </p>
            <p>
                帮扶对象ID：<input type="text" name="id"  value="<%=production.getPid()%>">
            </p>
            <p>
                项目持续时间：<input type="text" name="duration" value="<%=production.getDuration()%>"/>${ERR_duration}
            </p>
            <p>
                <input type="submit">
                <a href="returnHome">返回上一层</a>
            </p>
        </form>
    </div>
</body>
</html>
