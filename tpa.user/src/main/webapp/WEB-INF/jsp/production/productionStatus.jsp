<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/26
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>查看扶贫项目进展</title>
</head>
<body>
    <div align="center">
        <p>
            <h1>当前扶贫项目状态：${productionStatus}</h1>
        </p>
        <p>

            <h2>
            <%
                if(!request.getSession().getAttribute("productionStatus").equals("通过")){
                    out.println("<a href='toUpdateProduction'>更新当前项目状态</a>");
                }
            %>
            </h2>
        </p>
    </div>
</body>
</html>
