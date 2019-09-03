<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>资质修改</title>
	<link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="../../css/font-awesome.min.css">
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../css/doc.min.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	</style>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;" href="http://www.zcw.com/managers/cert/cert.jsp">众筹平台 - 资质维护</a></div>
        </div>
        <jsp:include page="/common/userinfo.jsp"></jsp:include>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <jsp:include page="/common/menu.jsp"></jsp:include>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<ol class="breadcrumb">
				  <li><a href="http://www.zcw.com/managers/main.jsp">首页</a></li>
				  <li><a href="http://www.zcw.com/managers/cert/cert.jsp">资质管理</a></li>
				  <li class="active">修改</li>
				</ol>
			<div class="panel panel-default">
              <div class="panel-heading">资质表单<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
			  <div class="panel-body">
				<form id="userForm" role="form">
				  
				  <div class="form-group">
					<label for="exampleInputPassword1">资质名称</label>
					<input type="text" class="form-control" id="name" value="${cert.name }" placeholder="请输入资质名称">
				  </div>
				  
				  <button id="editBtn" type="button" class="btn btn-success"><i class="glyphicon glyphicon-pencil"></i> 修改</button>
				  <button id="resetBtn" type="button" class="btn btn-danger"><i class="glyphicon glyphicon-refresh"></i> 重置</button>
				</form>
			  </div>
			</div>
        </div>
      </div>
    </div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			<h4 class="modal-title" id="myModalLabel">帮助</h4>
		  </div>
		  <div class="modal-body">
			<div class="bs-callout bs-callout-info">
				<h4>测试标题1</h4>
				<p>测试内容1，测试内容1，测试内容1，测试内容1，测试内容1，测试内容1</p>
			  </div>
			<div class="bs-callout bs-callout-info">
				<h4>测试标题2</h4>
				<p>测试内容2，测试内容2，测试内容2，测试内容2，测试内容2，测试内容2</p>
			  </div>
		  </div>
		  <!--
		  <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="button" class="btn btn-primary">Save changes</button>
		  </div>
		  -->
		</div>
	  </div>
	</div>
    <script src="../../jquery/jquery-2.1.1.min.js"></script>
    <script src="../../bootstrap/js/bootstrap.min.js"></script>
	<script src="../../script/docs.min.js"></script>
	<script src="../../jquery/layer/layer.js"></script>
        <script type="text/javascript">
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
            });
            $("#resetBtn").click(function(){
            	//JQ对象[0] ==》DOM对象
            	//$(DOM对象) ==》JQ对象
            	 $("#userForm")[0].reset();
            });
            var loadingIndex = -1;
            $("#editBtn").click(function(){
            	var name = $("#name");
            	if(name.val() == ""){
            		layer.msg("资质信息不能为空！",{time:1500, icon:5, shift:6},function(){
            			name.focus();
		    		});
            	}else{
            		$.ajax({
                		type:"POST",
                		url:"/managers/cert/update.do",
                		data:{
                			"name":name.val(),
                			"id":"${cert.id}"
                		},
                		beforeSend:function(){
                			loadingIndex = layer.load(2, {time: 10*1000});
                		},
                		success:function(result){
                			layer.close(loadingIndex);
                			if(result.success){
                				layer.msg("资质信息修改成功！",{time:1500, icon:6, shift:6});
                				window.location.href="http://www.zcw.com/managers/cert/cert.jsp?pageno=${param.pageno}";
                			}else{
                    			layer.msg("资质信息修改失败！",{time:1500, icon:5, shift:6});
                    		}
                		 }
                		});
            		}
            	 }); 
        </script>
  </body>
</html>