<%--
  Created by IntelliJ IDEA.
  User: onedayrex
  Date: 2016/2/6
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
  <form action="regist.do" method="post">
    <div>
      <div>
        <label>用户名</label>
        <input type="text" name="username">
      </div>
      <div>
        <label>密码</label>
        <input type="password" name="password">
      </div>
      <div>
        <label>再次输入密码</label>
        <input type="password" name="pwd">
      </div>
      <div>
        <button type="submit">提交</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>
