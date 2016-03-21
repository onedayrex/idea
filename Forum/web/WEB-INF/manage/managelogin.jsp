<%--
  Created by IntelliJ IDEA.
  User: onedayrex
  Date: 2016/2/13
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
  <form action="managelogin.do" method="post">
    <div class="panel">
      <fieldset>
        <legend>登录</legend>
        <div  class="form-group">
          <label for="userid">用户ID</label>
          <input type="text" name="manageid" placeholder="请输入用户ID" id="userid">
        </div>
        <div class="form-group">
          <label for="pwd">密码</label>
          <input type="password" name="password"  placeholder="密码" id="pwd">
          <p>${error}</p>
        </div>
        <div>
          <button type="submit">登录</button>
        </div>
      </fieldset>
    </div>
  </form>
</div>
</body>
</html>
