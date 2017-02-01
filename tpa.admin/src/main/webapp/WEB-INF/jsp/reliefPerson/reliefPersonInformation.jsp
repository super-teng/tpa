<%@ page import="com.nefu.software.tpa.user.util.PageUtil" %>
<%@ page import="com.nefu.software.tpa.entity.entity.ReliefPerson" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/29
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>扶贫个人信息管理</title>
</head>
<body>
<div align="center" id="d1">
    <p>
    <h2>扶贫个人信息</h2>
    </p>
    <table border="1">
        <%
            PageUtil pageUtil = (PageUtil) request.getSession().getAttribute("PageUtil");
            List<ReliefPerson> list = pageUtil.getList();
        %>
        <tr><td>用户名ID</td><td>用户名</td><td>密码</td><td>真实姓名</td><td>出生日期</td><td>住址</td><td>工作</td><td>电话号</td><td>收入情况</td><td>是否有贫困亲属</td><td>修改</td></tr>
        <%

            for(int i=pageUtil.getFromIndex();i<pageUtil.getToIndex();i++){
                ReliefPerson reliefPerson = list.get(i);
        %>

        <tr>
            <td><%=reliefPerson.getRid()%></td>
            <td><%=reliefPerson.getUsername()%></td>
            <td><%=reliefPerson.getPassword()%></td>
            <td><%=reliefPerson.getRealName()%></td>
            <td><%=reliefPerson.getBirth()%></td>
            <td><%=reliefPerson.getAddress()%></td>
            <td><%=reliefPerson.getJob()%></td>
            <td><%=reliefPerson.getTelephone()%></td>
            <td><%=reliefPerson.getIncomeDetail()%></td>
            <td><%=reliefPerson.isHasPovertyRelative()%></td>
            <td><a href="toUpdateReliefPerson?index=<%=i%>">修改</a> </td>
        </tr>
        <%}%>
    </table>
    <%
        //上一页
        if(pageUtil.getCurrentPage()!=1){
            out.println("<a href=toReliefPerson?pageNumber="+(pageUtil.getCurrentPage()-1)+">上一页</a> ");
        }
        //显示超链接
        for(int i=1;i<=pageUtil.getPageCount();i++){
            out.println("<a href=toReliefPerson?pageNumber="+i+">["+i+"]</a>");
        }
        //下一页
        if(pageUtil.getCurrentPage()!=pageUtil.getPageCount()){
            out.println("<a href=toReliefPerson?pageNumber="+(pageUtil.getCurrentPage()+1)+">下一页</a>");
        }
    %>
    <a href="toAdmin">返回上一层</a>
</div>
</body>
</html>
