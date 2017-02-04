<%@ page import="com.nefu.software.tpa.user.util.PageUtil" %>
<%@ page import="com.nefu.software.tpa.entity.entity.Plan" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/2/3
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>扶贫计划</title>
</head>
<body>
<div align="center" id="d1">
    <p>
    <h2>扶贫计划</h2>
    </p>
    <table border="1">
        <%
            PageUtil pageUtil = (PageUtil) request.getSession().getAttribute("adminPageUtil");
            List<Plan> list = pageUtil.getList();
        %>
        <tr><td>扶贫计划ID</td><td>计划名称</td><td>计划内容</td><td>计划持续时间</td><td>计划开始时间</td><td>扶贫对象ID</td><td>扶贫对象</td><td>帮扶主体ID</td><td>帮扶主体</td><td>扶贫日志</td><td>删除</td></tr>
        <%

            for(int i=pageUtil.getFromIndex();i<pageUtil.getToIndex();i++){
                Plan plan = list.get(i);
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
            <td><a href="toPlanLog?index=<%=i%>&pageNumber=1">查看扶贫日志</a> </td>
            <td><a href="deletePlan?index=<%=i%>">删除</a> </td>
        </tr>
        <%}%>
    </table>
    <%
        //上一页
        if(pageUtil.getCurrentPage()!=1){
            out.println("<a href=toPlan?pageNumber="+(pageUtil.getCurrentPage()-1)+">上一页</a> ");
        }
        //显示超链接
        for(int i=1;i<=pageUtil.getPageCount();i++){
            out.println("<a href=toPlan?pageNumber="+i+">["+i+"]</a>");
        }
        //下一页
        if(pageUtil.getCurrentPage()!=pageUtil.getPageCount()){
            out.println("<a href=toPlan?pageNumber="+(pageUtil.getCurrentPage()+1)+">下一页</a>");
        }
    %>
    <a href="toAdmin">返回上一层</a>
</div>
</body>
</html>
