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
	<title>参数管理</title>
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
          <div><a class="navbar-brand" style="font-size:32px;" href="http://www.zcw.com/managers/param/param.jsp">众筹平台 - 参数管理</a></div>
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
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 参数管理列表</h3>
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
<br>
 <hr style="clear:both;">
          <div class="table-responsive">
            <table class="table  table-bordered">
              <thead>
                <tr >
                  <th width="30">#</th>
                  <th>名称</th>
                  <th>代码</th>
                  <th>值</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              <tbody id="paramTableBody">
                
                
              </tbody>
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
           		 pageSize:5
           	}
        	if(cond){
        		//第一种写法
        		//jsonData.querytext = $("#queryTest").val();
        		//第二种写法
        		jsonData["querytext"] = $("#queryTest").val();
        	}
        	$.ajax({
        		type:"POST",
        		url:"/managers/param/ParampageQuery.do",
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
        				$.each(userList,function(i,param){
        					  userContent += '<tr><td>'+(i+1)+'</td>';
        	                  userContent += '<td>'+param.name+'</td>';
        	                  userContent += '<td>'+param.code+'</td>';
        	                  userContent += '<td>'+param.val+'</td>';
        					  userContent += '<td><button type="button" onclick="window.location.href=\'http://www.zcw.com/managers/param/edit.do?pageno='+pageno+'&id='+param.id+'\'" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>';
        					  userContent += '</td></tr>';
        				});
        				//表格数据
        				$("#paramTableBody").html(userContent);
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
        				layer.msg("参数分页数据查询失败！",{time:1500, icon:5, shift:6});
        			}
        		}
        	});
        }
        </script>
  </body>
</html>
