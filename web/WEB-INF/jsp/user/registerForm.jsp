<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/27
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>注册页面</title>
    <meta http-equiv="Content-Type" content="text/html charset=utf-8">
</head>
<body>
<form action="register" method="post">
    <table>
        <tr>
            <td><label>登录名：</label></td>
            <td><input type="text" id="loginname" name="loginname"> </td>
        </tr>
        <tr>
            <td><label>密码：</label></td>
            <td><input type="password" id="password" name="password"> </td>
        </tr>
        <tr>
            <td><label>真实姓名：</label></td>
            <td><input type="text" id="username" name="username"> </td>
        </tr>
        <tr>
            <td><input type="submit" id="submit" value="注册"> </td>
        </tr>
    </table>
</form>
</body>
</html>

