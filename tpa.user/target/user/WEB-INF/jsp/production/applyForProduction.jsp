<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/25
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>申请扶贫项目</title>
</head>
<%
    String productionStatus = request.getSession().getAttribute("productionStatus").toString();
    if(productionStatus != null && productionStatus.equals("未提交扶贫项目")){
        request.setAttribute("submit",true);
    }else{
        request.setAttribute("submit",false);
        request.setAttribute("message","已提交扶贫项目请勿重复填写");
    }
%>
<body>
    <div align="center">
        <p>
            <h2>扶贫项目</h2>
            <h3>${message}</h3>
        </p>
        <form action="applyFor" method="post" onsubmit="return ${submit}">
            <p>
                项目名称：<input type="text" name="pName" />${ERR_pName}
            </p>
            <p>
                项目内容: <input type="text" name="detail"/>${ERR_detail}
            </p>
            <p>
                帮扶对象:
                <input type="radio" name="flag" value="povertyFlag" checked="checked">贫困个人
                <input type="radio" name="flag" value="reliefFlag">自然村
            </p>
            <p>
                帮扶对象ID：<input type="text" name="id">
            </p>
            <p>
                项目持续时间：<input type="text" name="duration"/>${ERR_duration}
            </p>
            <p>
                <input type="submit">
            </p>
            <a href="returnHome">返回上一层</a>
        </form>
    </div>
</body>
</html>
