<%--
  Created by IntelliJ IDEA.
  User: onedayrex
  Date: 2016/2/14
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <title></title>
  <style type="text/css">
    .main{
      height: 100px;
      width: auto;
      color: #00a0e9;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header"><a href="toalltitle.do" style="color: white" class="navbar-brand">主页</a></div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li>
          <c:choose>
            <c:when test="${user!=null}"><a href="#">${user.username}</a></c:when>
            <c:when test="${manage!=null}">${manage.managename}</c:when>
            <c:otherwise><a href="tologin.do">登录</a></c:otherwise>
          </c:choose>
        </li>
        <li><a href="logout.do">退出</a></li>
      </ul>
    </div>
  </div>
</nav>

</body>
</html>
