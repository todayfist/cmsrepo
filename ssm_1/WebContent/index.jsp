<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" charset="utf-8"
	src="utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="utf8-jsp/ueditor.all.min.js">
</script>
<script type="text/javascript" charset="utf-8"
	src="utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
	//实例化编辑器
	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue = UE.getEditor('editor').getContent();
</script>
</head>
<body>
<form action="article/articleadd" method="post" enctype="multipart/form-data">
<input type="text" name="categoryid">
<input type="text" name="headlineid">
<input type="text" name="viewcount">
<input type="text" name="headline">
<script id="editor" type="text/plain"
						style="width:1024px;height:500px;" name="content"></script>
<input type="text" name="headname">
<input type="file" name="file">
<input type="text" name="headimg">
<input type="submit" value="tijiao">
</form>
</body>
</html>