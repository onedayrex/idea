<%--
  Created by IntelliJ IDEA.
  User: Tarena-java
  Date: 2016/2/3
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
  <link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="../../ueditor/themes/default/css/ueditor.css" type="text/css" rel="stylesheet">
  <script type="text/javascript" src="../../ueditor/third-party/jquery.min.js"></script>
  <script type="text/javascript" charset="utf-8" src="../../ueditor/ueditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="../../ueditor/ueditor.all.min.js"></script>
  <script type="text/javascript" src="../../ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body style="background-color: #e2e2e2">
<c:import url="/WEB-INF/navi/navi.jsp"></c:import>
<div class="container">
  <div class="content-wrap">
    <div class="row">
      <div class="col-lg-9">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 style="text-align: center">${topic.title}</h3>
          </div>
          <div class="panel-body">
            <div>
              ${topic.content}
            </div>
          </div>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading">
            <div class="panel-body">
              <c:if test="${replays.isEmpty()}"><div style="text-align: center">现在还没有回复哦</div></c:if>
              <c:forEach items="${replays}" var="c">
              <div class="media">
                <div class="media-left">
                  <a href="#">${c.userid}</a>
                </div>
                <div class="media-body">
                  <div>
                    <span>${c.content}</span>
                    <p class="small">发表时间：<fmt:formatDate value="${c.replaytime}" type="both"></fmt:formatDate></p>
                  </div>
                </div>
              </div>
                <hr>
              </c:forEach>
              <c:if test="${requestScope.replaypage>1}"><a href="toshow.do?id=${topic.id}&replaypage=${requestScope.replaypage-1}" class="btn btn-success">上一页</a></c:if>
              <c:forEach var="c" begin="1" end="${requestScope.count}">
                <a href="toshow.do?id=${topic.id}&replaypage=${c}" class="btn btn-success">${c}</a>
              </c:forEach>
              <c:if test="${requestScope.replaypage lt requestScope.count}"><a href="toshow.do?id=${topic.id}&replaypage=${requestScope.replaypage+1}" class="btn btn-success">下一页</a></c:if>共${count}页
            </div>
          </div>
        </div>
        <div class="panel panel-default">
          <div class="panel-body">
          <form action="replay.do" method="post">
            <input type="hidden" name="topicid" value="${topic.id}">
            <script id="editor" type="text/plain" name="content"></script>
            <input type="submit" value="回复">
          </form>
          </div>
        </div>
      </div>
      <div class="col-lg-3">
          <div class="panel panel-default">
            <div class="panel-heading">作者</div>
            <div class="panel-body">
              <span>UID：${requestScope.showuser.id}</span><br>
              <span>用户名：${requestScope.showuser.username}</span><br>
              <p class="small">注册时间：<fmt:formatDate value="${requestScope.showuser.creatime}"></fmt:formatDate></p>
            </div>
          </div>
          <div>
          </div>
      </div>
    </div>
  </div>
</div>
</body>
<script type="text/javascript">
  var ue = UE.getEditor("editor",{//这里可以选择自己需要的工具按钮名称,此处仅选择如下五个
    toolbars:[[
      'bold','fontfamily', //字体
      'fontsize', //字号
      'insertcode', //代码语言
      '|',
      'link', //超链接
      'unlink', //取消链接
      'simpleupload', //单图上传
      'insertimage', //多图上传
    ]],
    //focus时自动清空初始化时的内容
    autoClearinitialContent:true,
    //关闭字数统计
    wordCount:false,
    //关闭elementPath
    elementPathEnabled:false,
    //默认的编辑区域高度
    initialFrameHeight:300
    //更多其他参数，请参考ueditor.config.js中的配置项
  });
</script>
</html>
