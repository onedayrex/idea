<%--
  Created by IntelliJ IDEA.
  User: Tarena-java
  Date: 2016/2/3
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link href="../../ueditor/themes/default/css/ueditor.css" type="text/css" rel="stylesheet">
  <script type="text/javascript" src="../../ueditor/third-party/jquery.min.js"></script>
  <script type="text/javascript" charset="utf-8" src="../../ueditor/ueditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="../../ueditor/ueditor.all.min.js"></script>
  <script type="text/javascript" src="../../ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<form action="/creattopic.do" method="post">
  <input type="text" name="title">
  <script id="editor" type="text/plain" style="width:500px;height:300px;" name="content"></script>
  <input type="submit" value="提交">
</form>
</body>
<script type="text/javascript">
  var ue = UE.getEditor("editor",{//这里可以选择自己需要的工具按钮名称,此处仅选择如下五个
    toolbars:[[
      'FullScreen','bold','fontfamily', //字体
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
