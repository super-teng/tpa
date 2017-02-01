<%@ page import="com.nefu.software.tpa.user.util.PageUtil" %>
<%@ page import="com.nefu.software.tpa.entity.entity.Production" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/30
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>扶贫项目信息</title>
</head>

<body>
<div align="center" id="d1">
    <p>
    <h2>扶贫项目信息</h2>
    </p>
    <table border="1">
        <%
            PageUtil pageUtil = (PageUtil) request.getSession().getAttribute("PageUtil");
            List<Production> list = pageUtil.getList();
        %>
        <tr><td>扶贫项目ID</td><td>项目名称</td><td>项目内容</td><td>项目持续时间</td><td>审核情况</td><td>贫困人员标记</td><td>帮扶主体标记</td><td>扶贫人士ID</td><td>贫困人士ID</td><td>提交时间</td><td>通过</td><td>未通过</td></tr>
        <%

            for(int i=pageUtil.getFromIndex();i<pageUtil.getToIndex();i++){
                Production production = list.get(i);
        %>

        <tr>
            <td><%=production.getProId()%></td>
            <td><%=production.getpName()%></td>
            <td><%=production.getDetail()%></td>
            <td><%=production.getDuration()%></td>
            <td><%=production.getCheckDetail()%></td>
            <td><%=production.getPovertyFlag()%></td>
            <td><%=production.getReliefFlag()%></td>
            <td><%=production.getRid()%></td>
            <td><%=production.getPid()%></td>
            <td><%=production.getSubmitTime()%></td>
            <%
                boolean result = true;
                if(production.getCheckDetail().equals("通过")){
                    result = false;
                }
            %>
            <td><a href="passProduction?index=<%=i%>" onclick="return <%=result%>; ">通过</a> </td>
            <td><a href="toNoPassProduction?index=<%=i%>" onclick="return <%=result%>;">未通过</a></td>
        </tr>
        <%}%>
    </table>
    <%
        //上一页
        if(pageUtil.getCurrentPage()!=1){
            out.println("<a href=toProduction?pageNumber="+(pageUtil.getCurrentPage()-1)+">上一页</a> ");
        }
        //显示超链接
        for(int i=1;i<=pageUtil.getPageCount();i++){
            out.println("<a href=toProduction?pageNumber="+i+">["+i+"]</a>");
        }
        //下一页
        if(pageUtil.getCurrentPage()!=pageUtil.getPageCount()){
            out.println("<a href=toProduction?pageNumber="+(pageUtil.getCurrentPage()+1)+">下一页</a>");
        }
    %>
    <a href="toAdmin">返回上一层</a>
</div>
</body>
</html>
