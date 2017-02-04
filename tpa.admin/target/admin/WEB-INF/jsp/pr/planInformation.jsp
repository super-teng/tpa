<%@ page import="com.nefu.software.tpa.entity.entity.Plan" %><%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/2/4
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>扶贫计划</title>
</head>
<body>
<div align="center" id="d1">
    <p>
    <h2>扶贫计划</h2>
    </p>
    <p>
    <table border="1">
        <%
            Plan plan = (Plan) request.getAttribute("searchPlan");
        %>
        <tr><td>扶贫计划ID</td><td>计划名称</td><td>计划内容</td><td>计划持续时间</td><td>计划开始时间</td><td>扶贫对象ID</td><td>扶贫对象</td><td>帮扶主体ID</td><td>帮扶主体</td></tr>
        <%

                String povertyFlag = "自然村";
                if(plan.getPovertyFlag().equals("0")){
                    povertyFlag = "贫困个人";
                }
                String reliefFlag = "扶贫单位";
                if(plan.getReliefFlag().equals("0")){
                    reliefFlag = "扶贫个人";
                }
        %>

        <tr>
            <td><%=plan.getPlanId()%></td>
            <td><%=plan.getpName()%></td>
            <td><%=plan.getDetail()%></td>
            <td><%=plan.getDuration()%></td>
            <td><%=plan.getBeginTime()%></td>
            <td><%=plan.getPovertyId()%></td>
            <td><%=povertyFlag%></td>
            <td><%=plan.getReliefId()%></td>
            <td><%=reliefFlag%></td>
        </tr>
    </table>
    </p>
    <p>
    <a href="toPRInformation">返回上一层</a>
    </p>
</div>
</body>
</html>
