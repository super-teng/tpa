<%@ page import="com.nefu.software.tpa.user.util.PageUtil" %>
<%@ page import="com.nefu.software.tpa.entity.entity.Village" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/1/29
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>自然村信息管理</title>
</head>
<body>
<div align="center" id="d1">
    <p>
    <h2>自然村信息</h2>
    </p>
    <table border="1">
        <%
            PageUtil pageUtil = (PageUtil) request.getSession().getAttribute("PageUtil");
            List<Village> list = pageUtil.getList();
        %>
        <tr><td>自然村ID</td><td>自然村名称</td><td>地址</td><td>总人口</td><td>贫困人口</td><td>年生产总值</td><td>自然村特色</td><td>自然村贫困等级</td><td>修改</td></tr>
        <%

            for(int i=pageUtil.getFromIndex();i<pageUtil.getToIndex();i++){
                Village village = list.get(i);
        %>

        <tr>
            <td><%=village.getVid()%></td>
            <td><%=village.getVname()%></td>
            <td><%=village.getAddress()%></td>
            <td><%=village.getPopulation()%></td>
            <td><%=village.getPovertyCount()%></td>
            <td><%=village.getGdp()%></td>
            <td><%=village.getFeature()%></td>
            <td><%=village.getVlevel()%></td>
            <td><a href="toUpdateVillage?index=<%=i%>">修改</a> </td>
        </tr>
        <%}%>
    </table>
    <p>
    <%
        //上一页
        if(pageUtil.getCurrentPage()!=1){
            out.println("<a href=toVillage?pageNumber="+(pageUtil.getCurrentPage()-1)+">上一页</a> ");
        }
        //显示超链接
        for(int i=1;i<=pageUtil.getPageCount();i++){
            out.println("<a href=toVillage?pageNumber="+i+">["+i+"]</a>");
        }
        //下一页
        if(pageUtil.getCurrentPage()!=pageUtil.getPageCount()){
            out.println("<a href=toVillage?pageNumber="+(pageUtil.getCurrentPage()+1)+">下一页</a>");
        }
    %>
        <a href="toInsertVillage">新增自然村信息</a>
    </p>
    <p>

        <a href="toAdmin">返回上一层</a>
    </p>
</div>
</body>
</html>
