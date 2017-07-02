<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="/today/dist/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
  
  <table class="table table-hover text-center">
    <tr>
      <th width="10%">ID</th>
      <th width="20%">图片</th>
      <th width="15%">名称</th>
      <th width="20%">描述</th>
      <th width="10%">排序</th>
      <th width="15%">操作</th>
    </tr>
   
   	<c:forEach var="carousel" items="${carouselList }" varStatus="status">
   	  <tr>
	      <td>${status.count }</td>
	      <td><img src="${path }/${carousel.url }" alt="${carousel.name }" width="120" height="50" /></td>  
	      <td>${carousel.name }</td>
	      <td>${carousel.description }</td>
	      <td>${carousel.imgorder }</td>
	      <td>
		      <div class="button-group">
		      	<a class="button border-main" href="" onclick="modify(${carousel.id}, '${carousel.name }', '${carousel.url }', '${carousel.description }', ${carousel.imgorder });"><span class="icon-edit"></span> 修改</a>
		      	<a class="button border-red" href="${path }/carousel/delete?id=${carousel.id }"><span class="icon-trash-o"></span> 删除</a>
		      </div>
	      </td>
      </tr>
   	</c:forEach>
  </table>
</div>

<div class="padding border-bottom">  
  <button type="button" class="button border-yellow" onclick="setOperation(addOperation)"><span class="icon-plus-square-o"> 添加内容</span></button>
</div>
<div class="panel admin-panel margin-top" id="add">
  <div class="panel-head"><strong><span class="icon-pencil-square-o" id="operationType"> 增加内容</span></strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="" id="dataForm">
      <input type="hidden" name="id" id="id" value="0" />    
      <div class="form-group">
        <div class="label">
          <label>标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" id="name" name="name" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>URL：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="url" name="url" value="" readonly />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="field">
          <label>图片：</label>
          <br />
          <img id="imagePanel" src="" alt="请选择图片" style="width:25%;" />
          <!-- <input type="hidden" id="image" name="image" value="" /> -->
          <!-- <input type="button" class="button bg-blue margin-left" id="selectImage" value="- 初始值" onclick="changeImage(document.getElementById('originImage').value);" /> -->
        </div>
        <div class="field">
          <input type="file" id="imageFile" name="imageFile" class="input tips" style="width:25%; float:left;"  value="" data-toggle="hover" data-place="right" data-image="" />
          <input type="button" class="button bg-blue margin-left" value="+ 上传" id="imageSubmit" />
          <!-- <div class="tipss">图片尺寸：1920*500</div> -->
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>描述：</label>
        </div>
        <div class="field">
          <textarea type="text" class="input" id="description" name="description" style="height:120px;" value=""></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>排序：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="imgorder" name="imgorder" value="0"  data-validate="required:,number:排序必须为数字" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button id="carouselSubmit" class="button bg-main icon-check-square-o" type="button"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
<script type="text/javascript" src="../today/dist/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="../today/dist/js/jquery.form.js"></script>
<script type="text/javascript">
var ajax = getAjax();
var addOperation = "add";
var modifyOperation = "modify";
//初始值为添加模式
var operationType = addOperation;

function getAjax() {
	if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	} else {
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
}

function del(id,mid){
	if(confirm("您确定要删除吗?")){
	
	}
}

function initForm() {
	$("#dataForm")[0].reset();	
}

function setOperation(newOperation) {
	//更新全局变量
	operationType = newOperation;
	
	if (operationType == addOperation) {
		$("#operationType").text("增加内容");
		initForm();
	} else if (operationType == modifyOperation) {
		$("#operationType").text("修改内容");
	}
}

function modify(id, name, url, description, imgorder) {
	setOperation(modifyOperation);
	document.getElementById("id").value = id;
	document.getElementById("name").value = name;
	document.getElementById("url").value = url;
	document.getElementById("imagePanel").setAttribute("src", '${path }' + url);
	document.getElementById("description").value = description;
	document.getElementById("imgorder").value = imgorder;
}

function changeImage() {
	//alert(newImage + "1234");
	var newImage = document.getElementById("imageFile").value;
	//alert(newImage);
	if (newImage != "") {
		document.getElementById("url").value = newImage;
		document.getElementById("imagePanel").setAttribute("src", "");
		document.getElementById("imagePanel").setAttribute("alt", "已选择本地文件");
	}
}

/* var $j=jQuery.noConflict();
alert($j); */

	$(document).ready(function(){
	$("#imageSubmit").click(function() {
	//alert("imageSubmit");
	//只提交image，不提交其他内容
	$("#id").attr("disabled", "disabled");
	$("#name").attr("disabled", "disabled");
	//$("#url").attr("disabled", "disabled");
	$("#description").attr("disabled", "disabled");
	$("#imgorder").attr("disabled", "disabled");
	//$("#image").removeAttr("disabled");
	$("#dataForm").attr("enctype", "multipart/form-data");
	$("#dataForm").attr("action", "${path}/carousel/upload");
	
	$("#dataForm").ajaxSubmit({
			type: "post",
            url: "${path }/carousel/upload",
            success: function (data) {
            	//alert(data);
            	console.log($("#url"));
            	$("#url").val(data);
            	$("#imagePanel").attr("src", "${path }" + data);
            	$("#imagePanel").attr("alt", "已选择本地文件");
            	console.log(data);
            },
            error: function (msg) {
            	//alert("error");
            	alert(msg);
            }
		});
	
	$("#id").removeAttr("disabled");
	$("#name").removeAttr("disabled");
	//$("#url").attr("disabled", "disabled");
	$("#description").removeAttr("disabled");
	$("#imgorder").removeAttr("disabled");
	});
	
	$("#carouselSubmit").click(function() {
		//alert("carouselSubmit");
		//不提交image，提交其他内容
		$("#imageFile").attr("disabled", "disabled");

		$("#url").removeAttr("disabled");
		
		$("#dataForm").removeAttr("enctype");
		if (operationType == addOperation) {
			//alert("addOperation");
			$("#dataForm").attr("action", "${path}/carousel/add");
		} else if (operationType == modifyOperation) {
			//alert("modifyOperation");
			$("#dataForm").attr("action", "${path}/carousel/update");
		}
		
		
		$("#dataForm").submit();
		
		$("#imageFile").removeAttr("disabled");
		$("#url").attr("disabled", "disabled");
	});
});

</script>
</html>