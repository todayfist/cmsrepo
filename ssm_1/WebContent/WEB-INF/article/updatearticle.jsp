<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" charset="utf-8"
	src="${path }/utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${path }/utf8-jsp/ueditor.all.min.js">
	
</script>
<script type="text/javascript" charset="utf-8"
	src="${path }/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
	//实例化编辑器
	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue = UE.getEditor('editor').getContent();
	
	function imgPreview(fileDom) {
		//判断是否支持FileReader
		if (window.FileReader) {
			var reader = new FileReader();
		} else {
			alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
		}
		//获取文件
		var file = fileDom.files[0];
		var imageType = /^image\//;
		//是否是图片
		if (!imageType.test(file.type)) {
			alert("请选择图片！");
			return;
		}
		//读取完成
		reader.onload = function(e) {
			//获取图片dom
			var img = document.getElementById("preview");
			//图片路径设置为读取的图片
			img.src = e.target.result;
		};
		reader.readAsDataURL(file);
	}
</script>
</head>
<body style="background-color: #DBD76B">
	<div class="panel panel-info">
		<div class="panel-heading">
			<center>
				<font color="red"><h4>
						<b>修改文章</b>
					</h4> </font>
			</center>
		</div>
	</div>
	<center>
		<form action="${path }/article/articleupdate" method="post" enctype="multipart/form-data">
		
			<div class="form-group" style="display: none" >
				<div style="width: 400px"> <input type="text"
					class="form-control"  name="id" 
					value="${article.id}">
				</div>
			</div>
			<div class="form-group" style="display: none" >
				<div style="width: 400px"> <input type="text"
					class="form-control"  name="categoryid" 
					value="${article.categoryid}">
				</div>
			</div>
			<div class="form-group" style="display: none" >
				<div style="width: 400px"> <input type="text"
					class="form-control"  name="headlineid" 
					value="${article.headlineid}">
				</div>
			</div>
			<div class="form-group" style="display: none" >
				<div style="width: 400px"> <input type="text"
					class="form-control"  name="viewcount" 
					value="${article.viewcount}">
				</div>
			</div>
			<div class="form-group" style="display: none" >
				<div style="width: 400px"> <input type="text"
					class="form-control"  name="thumb" 
					value="${article.thumb}">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">图片</label>
				<div class="col-sm-10">
					<img src="${article.thumb}"
						style="width: 200px">
						
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">新图片</label>
				<div class="col-sm-10">
					<img id="preview" /> <input type="file" id="exampleInputFile"
						onchange="imgPreview(this)" name="file">
				</div>
			</div>
			
			<div class="form-group">
				<div style="width: 400px"> <input type="text"
					class="form-control" id="title" name="headline" required="required"
					value="${article.headline}">
				</div>
			</div>

			<script id="editor" type="text/plain"
				style="width:1024px;height:500px;" name="content">${article.content}</script>
			<br>
			<button style="width: 100px" onclick="check()"
				class="btn btn-success">
				<font size="3" color="black"><b>提&nbsp;&nbsp;交</b></font>
			</button>
		</form>
	</center>
</body>
</html>