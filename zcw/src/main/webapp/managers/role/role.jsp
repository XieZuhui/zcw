<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>角色维护</title>
	<link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="../../css/font-awesome.min.css">
	<link rel="stylesheet" href="../../css/main.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	table tbody tr:nth-child(odd){background:#F4F4F4;}
	table tbody td:nth-child(even){color:#C00;}
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
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 角色维护数据列表</h3>
			  </div>
			  <div class="panel-body">
<form class="form-inline" role="form" style="float:left;">
  <div class="form-group has-feedback">
    <div class="input-group">
      <div class="input-group-addon">查询条件</div>
      <input id="queryTest" class="form-control has-success" type="text" placeholder="请输入查询条件">
    </div>
  </div>
  <button id="queryButton" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
</form>
<button type="button" onclick="deleteRoles()" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
<button type="button" onclick="window.location.href='http://www.zcw.com/managers/role/addrole.jsp'" class="btn btn-primary" style="float:right;"><i class="glyphicon glyphicon-plus"></i> 新增</button>
<br>
 <hr style="clear:both;">
          <div class="table-responsive">
            <table class="table  table-bordered">
              <thead>
                <tr >
                  <th width="30">#</th>
				  <th width="30"><input type="checkbox" onclick="selRoleBox(this)"></th>
                  <th>名称</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              <tbody id="roleTableBody">
                
              </tbody>
			  <tfoot>
			     <tr >
				     <td colspan="6" align="center">
						<ul class="pagination">
<!-- 								<li class="disabled"><a href="#">上一页</a></li> -->
<!-- 								<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li> -->
<!-- 								<li><a href="#">2</a></li> -->
<!-- 								<li><a href="#">3</a></li> -->
<!-- 								<li><a href="#">4</a></li> -->
<!-- 								<li><a href="#">5</a></li> -->
<!-- 								<li><a href="#">下一页</a></li> -->
							 </ul>
					 </td>
				 </tr>

			  </tfoot>
            </table>
          </div>
			  </div>
			</div>
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
          //查询第一页数据
		    <c:if test="${empty param.pageno }">
		    	pageQuery(1);
			</c:if>
			<c:if test="${not empty param.pageno }">
	    		pageQuery(${param.pageno});
			</c:if>
		  	//高级查询
		    $("#queryButton").click(function(){
		    	var queryTest =  $("#queryTest");
		    	if(queryTest.val() == ""){
		    		layer.msg("请输入查询条件！",{time:1500, icon:5, shift:6},function(){
		    			queryTest.focus();
		    		});
		    	}else{
		    	   cond = true;
		    	   pageQuery(1);
		    	}
		    });
        var cond =false;
        var loadIndex=-1;
        function pageQuery(pageno){
        	var jsonData = {
           		 pageno:pageno,
           		 pageSize:8
           	}
        	if(cond){
        		//第一种写法
        		//jsonData.querytext = $("#queryTest").val();
        		//第二种写法
        		jsonData["querytext"] = $("#queryTest").val();
        	}
        	$.ajax({
        		type:"POST",
        		url:"/managers/role/RolepageQuery.do",
        		data:jsonData,
        		beforeSend:function(){
        			loadingIndex = layer.load(2, {time: 10*1000});
        		},
        		success:function(result){
//         			console.log(result);
//         			//ajax和拦截器的配合
//         			if(result.pageUrl != ""){
//         				window.location.href = "http://www.crm.com/login.html";
//         			}
        			layer.close(loadingIndex);
        			if(result.success){
        				var pageObj = result.pageBean;
        				var userList = pageObj.datas;
        				var userContent="";
        				//循环取数据到页面上显示
        				$.each(userList,function(i,role){
        					  userContent += '<tr><td>'+(i+1)+'</td>';
        					  userContent += '<td><input type="checkbox" value="'+role.id+'"></td>';
        	                  userContent += '<td>'+role.name+'</td>';
        					  userContent += '<td><button type="button" onclick="window.location.href=\'http://www.zcw.com/managers/role/assign.do?pageno='+pageno+'&id='+role.id+'\'" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
        					  userContent += '  <button type="button" onclick="window.location.href=\'http://www.zcw.com/managers/role/edit.do?pageno='+pageno+'&id='+role.id+'\'" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>';
        					  userContent += '  <button type="button" onclick="deleteRole('+role.id+',\''+role.name+'\')" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
        					  userContent += '</td></tr>';
        				});
        				//表格数据
        				//$("#userTableBody").empty();
        				//$("#userTableBody").append(userContent);
        				$("#roleTableBody").html(userContent);
        			//页码
        				var pageingConten="";
        			    if(pageno!=1){
        			    	pageingConten+='<li><a href="javascript:void(0)" onclick="pageQuery('+(pageno-1)+')">上一页</a></li>';
        			    }							
        				for(var i=1;i<=pageObj.totalno;i++){
        					pageingConten+='<li '+(pageno==i?'class="active"':'')+'><a href="javascript:void(0)" onclick="pageQuery('+i+')">'+i+'</a> </li>';
        				} 
        				if(pageno!=pageObj.totalno){
							pageingConten+='<li><a href="javascript:void(0)" onclick="pageQuery('+(pageno+1)+')">下一页</a></li>';
        			    }
        				$(".pagination").html(pageingConten);
        			}else{
        				layer.msg("角色分页数据查询失败！",{time:1500, icon:5, shift:6});
        			}
        		}
        	});
        }
      //角色删除
        function deleteRole(id,name){
        	layer.confirm("删除角色："+name+",是否继续？",{icon: 3, title:'提示'}, function(cindex){
			    //确认
			    $.ajax({
            		type:"POST",
            		url:"/managers/role/delete.do",
            		data:{
            			id:id
            		},
            		beforeSend:function(){
            			loadingIndex = layer.load(2, {time: 10*1000});
            		},
            		success:function(result){
            			if(result.success){
            				layer.msg("角色删除成功！",{time:1500, icon:6}, function(){
            					pageQuery(1);
            				});
            			}else{
            				layer.msg("角色删除失败！",{time:1500, icon:5, shift:6});
            			}
            		}
			    });
        		layer.close(cindex);
			}, function(cindex){
				//取消
			    layer.close(cindex);
			});
        }
        
        //批量删除
        function deleteRoles(){
        	//获取被选中的角色复选框
        	var userBoxs = $("tbody :checked");
        	//判断复选框是否为空
        	if(userBoxs.length == 0){
        		layer.msg("请选择需要删除的角色信息！",{time:1500, icon:5, shift:6});
        	}else {
        		layer.confirm("是否删除选择的角色信息？",  {icon: 3, title:'提示'}, function(cindex){
            		//删除数据
            		var jsonData = {};
            		//循环得到数据   i：索引  n：复选框
            		$.each(userBoxs, function(i, n){
            			jsonData["ids["+i+"]"] = n.value;
            		});
					$.ajax({
						type:"POST",
						url:"/managers/role/deletes.do",
						data:jsonData,
						success:function(result){
							if (result.success) {
								layer.msg("角色信息删除成功！",{time:1500, icon:6}, function(){
									pageQuery(1);
								});
							} else {
								layer.msg("角色信息删除失败！",{time:1500, icon:5, shift:6});
							}
						}
					});
					layer.close(cindex);
    			}, function(cindex){
    				//取消
    			    layer.close(cindex);
    			});
			}
        }
        
        function selRoleBox(obj){
        	var flg = obj.checked;
        	//获取角色的复选框
        	//tbody ==》checkbox
        	//$.each() 适用于所有     $().each 适用于JQuary 
        	$("tbody :checkbox").each(function(){
        		this.checked = flg;
        	});
        }
        </script>
  </body>
</html>
