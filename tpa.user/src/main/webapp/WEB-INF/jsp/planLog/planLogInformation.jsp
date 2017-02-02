<%@ page import="com.nefu.software.tpa.entity.entity.PlanLog" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nefu.software.tpa.user.util.PageUtil" %>
<%@ page import="com.nefu.software.tpa.entity.entity.Poverty" %>
<%@ page import="com.nefu.software.tpa.entity.entity.Plan" %><%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/2/2
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>扶贫日志信息</title>
</head>
<body>
<div align="center" id="d1">
    <p>
    <h2>扶贫日志信息</h2>
    </p>
    <table border="1">
        <%
            PageUtil pageUtil = (PageUtil) request.getAttribute("planLogPageUtil");
            List<PlanLog> list = pageUtil.getList();
        %>
        <tr><td>扶贫日志编号</td><td>提交时间</td><td>详细信息</td><td>附件</td></tr>
        <%

            for(int i=pageUtil.getFromIndex();i<pageUtil.getToIndex();i++){
                PlanLog planLog = list.get(i);
        %>

        <tr>
            <td><%=planLog.getLid()%></td>
            <td><%=planLog.getSubmitTime()%></td>
            <td><%=planLog.getDetail()%></td>
            <td><a href="downLoadPlanLog?url=<%=planLog.getLogUrl()%>">下载</a> </td>
        </tr>
        <%}%>
    </table>
    <%
        //上一页
        if(pageUtil.getCurrentPage()!=1){
            out.println("<a  href=searchPlanLog?pageNumber="+(pageUtil.getCurrentPage()-1)+">上一页</a> ");
        }
        //显示超链接
        for(int i=1;i<=pageUtil.getPageCount();i++){
            out.println("<a  href=searchPlanLog?pageNumber="+i+">["+i+"]</a>");
        }
        //下一页
        if(pageUtil.getCurrentPage()!=pageUtil.getPageCount()){
            out.println("<a href=searchPlanLog?pageNumber="+(pageUtil.getCurrentPage()+1)+">下一页</a>");
        }
    %>
    <a href="searchPlan">返回上一层</a>
</div>
</body>
</html>
