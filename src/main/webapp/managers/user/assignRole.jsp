<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>角色分配</title>
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
            <div><a class="navbar-brand" style="font-size:32px;" href="http://www.zcw.com/managers/user/user.jsp">众筹平台 - 用户维护</a></div>
        </div>
        <%@include file="/common/userinfo.jsp" %>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <jsp:include page="/common/menu.jsp"></jsp:include>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<ol class="breadcrumb">
				  <li><a href="http://www.zcw.com/managers/main.jsp">首页</a></li>
				  <li><a href="http://www.zcw.com/managers/user/user.jsp">角色列表</a></li>
				  <li class="active">分配角色</li>
				</ol>
			<div class="panel panel-default">
			  <div class="panel-body">
				<form role="form" class="form-inline">
				  <div class="form-group">
					<label  for="exampleInputPassword1">未分配角色列表</label><br>
					<select id="leftList" class="form-control" multiple size="10" style="width:260px;overflow-y:auto;">
						<c:forEach items="${unassignList }" var="role">
							<option value="${role.id }">${role.name }</option>
						</c:forEach>
<!--                         <option value="pm">PM</option> -->
<!--                         <option value="sa">SA</option> -->
<!--                         <option value="se">SE</option> -->
<!--                         <option value="tl">TL</option> -->
<!--                         <option value="gl">GL</option> -->
                    </select>
				  </div>
				  <div class="form-group">
                        <ul>
                            <li id="LtoRBtn" class="btn btn-default glyphicon glyphicon-chevron-right"></li>
                            <br>
                            <li id="RtoLBtn" class="btn btn-default glyphicon glyphicon-chevron-left" style="margin-top:20px;"></li>
                        </ul>
				  </div>
				  <div class="form-group" style="margin-left:40px;">
					<label for="exampleInputPassword1">已分配角色列表</label><br>
					<select id="rightList" class="form-control" multiple size="10" style="width:260px;overflow-y:auto;">
						<c:forEach items="${assignList }" var="role">
							<option value="${role.id }">${role.name }</option>
						</c:forEach>
<!--                         <option value="qa">QA</option> -->
<!--                         <option value="qc">QC</option> -->
<!--                         <option value="pg">PG</option> -->
                    </select>
				  </div>
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
            
            //将左边元素右移
            $("#LtoRBtn").click(function(){
            	//获取左边列表中被选中的元素
            	var selItems = $("#leftList :selected");
            	//判断元素数量是否为空
            	if(selItems.length == 0){
            		layer.msg("请选择需要分配的角色数据！",{time:1500, icon:5, shift:6});
            		return;
            	}else {
            		var jsonData = {userid:"${user.id}"};
            		//i：索引    n:选中的元素
            		$.each(selItems, function(i, n){
            			jsonData["ids["+i+"]"] = n.value;
            		});
            		$.ajax({
            			type:"POST",
            			url:"/managers/assignRole.do",
            			data:jsonData,
            			success:function(result){
            				if (result.success) {
            					//如果数量大于0，元素向右移动
            					$("#rightList").append(selItems);
							}else {
								layer.msg("角色数据分配失败！",{time:1500, icon:5, shift:6});
							}
            			}
            		});
				}
            });
            
            //将右边元素左移
			$("#RtoLBtn").click(function(){
				//获取右边列表中被选中的元素
            	var selItems = $("#rightList :selected");
            	//判断元素数量是否为空
            	if(selItems.length == 0){
            		layer.msg("请选择需要取消分配的角色数据！",{time:1500, icon:5, shift:6});
            		return;
            	}else {
            		var jsonData = {userid:"${user.id}"};
            		//i：索引    n:选中的元素
            		$.each(selItems, function(i, n){
            			jsonData["ids["+i+"]"] = n.value;
            		});
            		$.ajax({
            			type:"POST",
            			url:"/managers/unassignRole.do",
            			data:jsonData,
            			success:function(result){
            				if (result.success) {
            					//如果数量大于0，元素向左移动
            					$("#leftList").append(selItems);
							}else {
								layer.msg("角色数据分配失败！",{time:1500, icon:5, shift:6});
							}
            			}
            		});
				}
            });
			
        </script>
  </body>
</html>
