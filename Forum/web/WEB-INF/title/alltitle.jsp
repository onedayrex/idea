<%--
  Created by IntelliJ IDEA.
  User: Tarena-java
  Date: 2016/2/3
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <title></title>
  <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <style type="text/css">
    /*html {*/
      /*filter: grayscale(100%);*/
      /*-webkit-filter: grayscale(100%);*/
      /*-moz-filter: grayscale(100%);*/
      /*-ms-filter: grayscale(100%);*/
      /*-o-filter: grayscale(100%);* 变灰/
      /*filter: url("data:image/svg+xml;utf8,<svg xmlns=\"http://www.w3.org/2000/svg\"><filter id=\"grayscale\"><feColorMatrix type=\"matrix\" values=\"0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0 0 0 1 0\"/></filter></svg>#grayscale");*/
      /*filter: progid:DXImageTransform.Microsoft.BasicImage(grayscale=1);*/
      /*filter: gray;*/
      /*-webkit-filter: grayscale(1)*/
    /*}*/
  </style>
</head>
<body style="background-color: #e2e2e2">
<c:import url="/WEB-INF/navi/navi.jsp"></c:import>
<div class="container">
<div class="panel panel-success">
  <div class="panel-body">
    <c:forEach items="${titlelist}" var="c">
      <div class="row">
        <div class="col-lg-9">
        <div class="media-left"><span class=""></span></div>
        <div class="media-body">
          <div class="media-heading">
          <a href="/toshow.do?id=${c.id}" class="am-text-truncate" style="color: #778087;font-size: large">${c.title}</a>
            <p class="small">发贴时间：<fmt:formatDate value="${c.creatime}" type="both"></fmt:formatDate></p>
          </div>
          <div class="media-right">
            <c:if test="${sessionScope.manage!=null}"><a href="deletetopic.do?id=${c.id}">删除</a></c:if>
          </div>
          <hr>
        </div>
        </div>
        <div class="col-lg-3"></div>
      </div>
    </c:forEach>
  </div>
  <c:if test="${pages>1}"><a href="toalltitle.do?page=${pages-1}" class="btn btn-success">上一页</a></c:if>
  <c:forEach var="c" begin="1" end="${count}">
    <a href="toalltitle.do?page=${c}" class="btn btn-success">${c}</a>
  </c:forEach>
  <c:if test="${pages lt count}"><a href="toalltitle.do?page=${pages+1}" class="btn btn-success">下一页</a></c:if>共${count}页
</div>
</div>
<div>
  <a href="totopic.do" class="btn btn-lg btn-success">发表主题</a>
</div>
</body>
<script src="js/bootstrap.min.js"></script>
</html>
