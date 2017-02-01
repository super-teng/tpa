<%@ page import="com.nefu.software.tpa.user.util.PageUtil" %>
<%@ page import="com.nefu.software.tpa.entity.entity.ReliefCompany" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/29
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>扶贫单位信息</title>
</head>
<body>
<div align="center" id="d1">
    <p>
    <h2>扶贫单位信息</h2>
    </p>
    <table border="1">
        <%
            PageUtil pageUtil = (PageUtil) request.getSession().getAttribute("PageUtil");
            List<ReliefCompany> list = pageUtil.getList();
        %>
        <tr><td>扶贫单位ID</td><td>用户名</td><td>密码</td><td>单位名称</td><td>地址</td><td>单位经营信息</td><td>电话号</td><td>修改</td></tr>
        <%

            for(int i=pageUtil.getFromIndex();i<pageUtil.getToIndex();i++){
                ReliefCompany reliefCompany = list.get(i);
        %>

        <tr>
            <td><%=reliefCompany.getCid()%></td>
            <td><%=reliefCompany.getUsername()%></td>
            <td><%=reliefCompany.getPassword()%></td>
            <td><%=reliefCompany.getCname()%></td>
            <td><%=reliefCompany.getAddress()%></td>
            <td><%=reliefCompany.getDetail()%></td>
            <td><%=reliefCompany.getTelephone()%></td>
            <td><a href="toUpdateReliefCompany?index=<%=i%>">修改</a> </td>
        </tr>
        <%}%>
    </table>
    <%
        //上一页
        if(pageUtil.getCurrentPage()!=1){
            out.println("<a href=toReliefCompany?pageNumber="+(pageUtil.getCurrentPage()-1)+">上一页</a> ");
        }
        //显示超链接
        for(int i=1;i<=pageUtil.getPageCount();i++){
            out.println("<a href=toReliefCompany?pageNumber="+i+">["+i+"]</a>");
        }
        //下一页
        if(pageUtil.getCurrentPage()!=pageUtil.getPageCount()){
            out.println("<a href=toReliefCompany?pageNumber="+(pageUtil.getCurrentPage()+1)+">下一页</a>");
        }
    %>
    <a href="toAdmin">返回上一层</a>
</div>
</body>
</html>
