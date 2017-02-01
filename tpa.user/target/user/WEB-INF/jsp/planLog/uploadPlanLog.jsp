<%--
  Created by IntelliJ IDEA.
  User: Super腾
  Date: 2017/2/1
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>上传工作日志</title>
</head>
<body>
    <div align="center">
        <p>
            <h2>上传工作日志</h2>
        </p>
        <form action="uploadPlanLog" method="post" enctype="multipart/form-data">
            <p>
                文件：<input type="file" name="file"/>
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</body>
</html>
