<%@ page import="com.nefu.software.tpa.user.util.PageUtil" %>
<%@ page import="com.nefu.software.tpa.entity.entity.Poverty" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/28
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>贫困个人信息</title>
</head>
<body>
<div align="center" id="d1">
    <p>
    <h2>贫困者信息</h2>
    </p>
    <table border="1">
        <%
            PageUtil pageUtil = (PageUtil) request.getSession().getAttribute("PageUtil");
            List<Poverty> list = pageUtil.getList();
        %>
        <tr><td>贫困人士ID</td><td>贫困人士姓名</td><td>性别</td><td>出生日期</td><td>地址</td><td>是否有收入</td><td>收入详细情况</td><td>工作</td><td>疾病情况</td><td>贫困原因</td></td><td>贫困等级</td><td>修改</td><td>删除</td></tr>
        <%

            for(int i=pageUtil.getFromIndex();i<pageUtil.getToIndex();i++){
                Poverty poverty = list.get(i);
                String hasIncome = "没有";
                if(poverty.isHasIncome()){
                    hasIncome = "有";
                }
        %>

        <tr>
            <td><%=poverty.getPid()%></td>
            <td><%=poverty.getpName()%></td>
            <td><%=poverty.getSex()%></td>
            <td><%=poverty.getBirth()%></td>
            <td><%=poverty.getAddress()%></td>
            <td><%=hasIncome%></td>
            <td><%=poverty.getIncomeDetail()%></td>
            <td><%=poverty.getJob()%></td>
            <td><%=poverty.getIllness()%></td>
            <td><%=poverty.getPovertyReason()%></td>
            <td><%=poverty.getpLevel()%></td>
            <td><a href="toUpdatePoverty?index=<%=i%>">修改</a> </td>
            <td><a href="toDeletePoverty?index=<%=i%>">删除</a> </td>
        </tr>
        <%}%>
    </table>
    <p>
    <%
        //上一页
        if(pageUtil.getCurrentPage()!=1){
            out.println("<a id = 'a1' href=toPoverty?pageNumber="+(pageUtil.getCurrentPage()-1)+">上一页</a> ");
        }
        //显示超链接
        for(int i=1;i<=pageUtil.getPageCount();i++){
            out.println("<a id = 'a2' href=toPoverty?pageNumber="+i+">["+i+"]</a>");
        }
        //下一页
        if(pageUtil.getCurrentPage()!=pageUtil.getPageCount()){
            out.println("<a id = 'a3' href=toPoverty?pageNumber="+(pageUtil.getCurrentPage()+1)+">下一页</a>");
        }
    %>

        <a href="toInsertPoverty">新增贫困用户</a>
    </p>
    <p>
        <a href="toAdmin">返回上一层</a>

    </p>
</div>
</body>
</html>
