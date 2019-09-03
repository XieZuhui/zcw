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
	<title>权限分配</title>
	<link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="../../css/font-awesome.min.css">
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../css/doc.min.css">
	<link rel="stylesheet" href="../../ztree/zTreeStyle.css">
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
           <div><a class="navbar-brand" style="font-size:32px;" href="http://www.zcw.com/managers/role/role.jsp">众筹平台 - 角色维护</a></div>
        </div>
        <jsp:include page="/common/userinfo.jsp"></jsp:include>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <jsp:include page="/common/menu.jsp"></jsp:include>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

			<div class="panel panel-default">
              <div class="panel-heading"><i class="glyphicon glyphicon-th-list"></i> 权限分配列表<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
			  <div class="panel-body">
                  <button id="assignBtn" class="btn btn-success">分配许可</button>
                  <br><br>
                  <ul id="permissionTree" class="ztree"></ul>
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
				<h4>没有默认类</h4>
				<p>警告框没有默认类，只有基类和修饰类。默认的灰色警告框并没有多少意义。所以您要使用一种有意义的警告类。目前提供了成功、消息、警告或危险。</p>
			  </div>
			<div class="bs-callout bs-callout-info">
				<h4>没有默认类</h4>
				<p>警告框没有默认类，只有基类和修饰类。默认的灰色警告框并没有多少意义。所以您要使用一种有意义的警告类。目前提供了成功、消息、警告或危险。</p>
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
	<script src="../../ztree/jquery.ztree.all-3.5.min.js"></script>
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
				
				var setting = {
                    check : {
                        enable : true 
                    },
                    view: {
						selectedMulti: false,
						addDiyDom: function(treeId, treeNode){
							var icoObj = $("#" + treeNode.tId + "_ico");
							if ( treeNode.icon ) {
								icoObj.removeClass("button ico_docu ico_open").addClass(treeNode.icon).css("background","");
							}
						}
			    	},
			    	async: {
			    		enable: true,
			    		url:"http://www.zcw.com/managers/permission/loadAsyncCheckedDatas.do?roleid=${role.id}",
			    		autoParam:["id", "name=n", "level=lv"]
			    	},
			    	callback: {
						onClick : function(event, treeId, json) {

						}
					}
				};
				$.fn.zTree.init($("#permissionTree"), setting);
            });
			
            $("#assignBtn").click(function(){
            	//获取树形结构中被选中的数据
            	var treeObj = $.fn.zTree.getZTreeObj("permissionTree");
            	var nodes = treeObj.getCheckedNodes(true); // 获取被选中的节点
            	var jsonData = {roleid : "${role.id}"};
            	$.each(nodes, function(i, n){
            		jsonData["ids["+i+"]"] = n.id;
            	});
            	//分配权限
            	$.ajax({
            		type : "POST",
            		url  : "/managers/role/assignPermission.do",
            		data : jsonData,
            		success : function(result){
            			if (result.success) {
            				layer.msg("许可信息分配成功", {time:1500, icon:6}, function(){
            					window.location.href = "http://www.zcw.com/managers/role/role.jsp?pageno=${param.pageno}";
            				});
						} else {
							layer.msg("许可信息分配失败", {time:1500, icon:5, shift:6});
						}
            		}
            	});
            });
        </script>
  </body>
</html>
