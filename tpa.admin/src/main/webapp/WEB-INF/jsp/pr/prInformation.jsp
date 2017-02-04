<%@ page import="com.nefu.software.tpa.user.util.PageUtil" %>
<%@ page import="com.nefu.software.tpa.entity.entity.PR" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/2/4
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>扶贫结对</title>
</head>
<body>
<div align="center" id="d1">
    <p>
    <h2>扶贫结对信息</h2>
    </p>
    <table border="1">
        <%
            PageUtil pageUtil = (PageUtil) request.getAttribute("prPageUtil");
            List<PR> list = pageUtil.getList();
        %>
        <tr><td>帮扶结对ID</td><td>扶贫对象</td><td>扶贫ID</td><td>帮扶对象</td><td>帮扶ID</td><td>扶贫计划</td></tr>
        <%

            for(int i=pageUtil.getFromIndex();i<pageUtil.getToIndex();i++){
                PR pr = list.get(i);
                String povertyFlag = "自然村";
                if(pr.getpFlag().equals("0")){
                    povertyFlag = "贫困个人";
                }
                String reliefFlag = "扶贫单位";
                if(pr.getrFlag().equals("0")){
                    reliefFlag = "扶贫个人";
                }
        %>

        <tr>
            <td><%=pr.getPrId()%></td>
            <td><%=povertyFlag%></td>
            <td><%=pr.getPrId()%></td>
            <td><%=reliefFlag%></td>
            <td><%=pr.getRid()%></td>
            <td>
                <a href="searchPlan?planId=<%=pr.getPlanId()%>">查看扶贫计划</a>
            </td>
        </tr>
        <%}%>
    </table>
    <%
        //上一页
        if(pageUtil.getCurrentPage()!=1){
            out.println("<a href=toPR?pageNumber="+(pageUtil.getCurrentPage()-1)+">上一页</a> ");
        }
        //显示超链接
        for(int i=1;i<=pageUtil.getPageCount();i++){
            out.println("<a href=toPR?pageNumber="+i+">["+i+"]</a>");
        }
        //下一页
        if(pageUtil.getCurrentPage()!=pageUtil.getPageCount()){
            out.println("<a href=toPR?pageNumber="+(pageUtil.getCurrentPage()+1)+">下一页</a>");
        }
    %>
    <a href="toAdmin">返回上一层</a>
</div>
</body>
</html>
