<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/7
  Time: 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
    <tr>
        <td>编号</td>
        <td>名称</td>
        <td>价格</td>
        <td>种类</td>
    </tr>
    <tr>
         <td>${p.id}</td>
         <td>${p.name}</td>
        <td>${p.price}</td>
        <td>${p.cid}</td>
    </tr>
</table>
</div>
</body>
</html>
