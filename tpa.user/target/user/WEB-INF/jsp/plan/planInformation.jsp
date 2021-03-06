<%@ page import="com.nefu.software.tpa.entity.entity.Plan" %><%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/31
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>扶贫计划页面</title>
</head>
<body>
    <div align="center">
        <h2>扶贫计划</h2>
        <table border="1">
            <%
                Plan plan = (Plan) request.getSession().getAttribute("plan");
                String povertyFlag;
                if(plan.getPovertyFlag().equals("0")){
                    povertyFlag = "扶贫个人";
                }else{
                    povertyFlag = "自然村";
                }
                String reliefFlag = "扶贫单位";
                if(plan.getReliefFlag().equals("0")){
                    reliefFlag = "扶贫个人";
                }
            %>
            <tr><td>计划名称</td><td>计划内容</td><td>计划持续时间</td><td>计划开始时间</td><td>贫困类型</td><td>贫困对象编号</td><td>扶贫类型</td><td>扶贫编号</td><td>扶贫日志</td></tr>
            <tr>
                <td>${plan.pName}</td>
                <td>${plan.detail}</td>
                <td>${plan.duration}</td>
                <td>${plan.beginTime}</td>
                <td><%=povertyFlag%></td>
                <td>${plan.povertyId}</td>
                <td>${plan.reliefId}</td>
                <td><%=reliefFlag%></td>
                <td><a href="searchPlanLog?pageNumber=1">查看扶贫日志</a></td>
            </tr>
        </table>
        <p>
            <a href="returnHome">返回上一层</a>
        </p>
    </div>
</body>
</html>
