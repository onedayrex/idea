<%--
  Created by IntelliJ IDEA.
  User: onedayrex
  Date: 2016/2/12
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
  <form action="updata.do" method="post">
    <div>
      <div>
        <label>用户ID</label>
        <input readonly value="${user.id}" name="userid">
      </div>
      <div>
        <label>用户名</label>
        <input readonly value="${user.username}" name="username">
      </div>
      <div>
        <label>输入密码</label>
        <input type="password" name="password">
        <label>再次输入密码</label>
        <input type="password">
      </div>
      <div>
        <button type="submit">提交</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>
