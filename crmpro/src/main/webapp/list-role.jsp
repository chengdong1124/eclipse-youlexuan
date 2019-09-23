 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from www.gzsxt.cn/theme/hplus/table_basic.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:01 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>项目管理系统 - 基础表格</title>
    <meta name="keywords" content="项目管理系统">
    <meta name="description" content="项目管理系统">

    <link rel="shortcut icon" href="favicon.ico"> 
    	<link href="${pageContext.request.contextPath}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/select/bootstrap-select.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper2 wrapper-content2 animated fadeInRight">
	    <div class="row">
	    		<div class="col-sm-5">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>添加角色</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal" id="addformm" method="post">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">角色名称：</label>
                                
								<input type="hidden" name="roleid" id="getid" />
								
                                <div class="col-sm-8">
                                    <input id="name" name="rolename" type="email" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">角色描述：</label>

                                <div class="col-sm-8">
                                    <input id="roledis" name="roledis" type="email" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否启用：</label>

                                <div class="col-sm-8">
                                    <div class="switch">
			                            <div class="onoffswitch">
			                                <input id="status" name="status" type="checkbox" class="onoffswitch-checkbox">
			                                <label class="onoffswitch-label" for="status">
			                                    <span class="onoffswitch-inner"></span>
			                                    <span class="onoffswitch-switch"></span>
			                                </label>
			                            </div>
			                        </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button id="save" class="btn btn-sm btn-white btnSave" type="button"><i class="fa fa-save"></i> 保存</button>
                                    <button class="btn btn-sm btn-white" type="button"><i class="fa fa-undo"></i> 重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
	    		<div class="col-sm-7">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>角色列表 <small>点击修改信息将显示在左边表单</small></h5>
                    </div>
                    <div class="ibox-content">
                    <form action="${pageContext.request.contextPath}/role/list" method="post">
                    		<div class="row">
                        		<div class="col-sm-2 col-sm-offset-2 text-right">
                        			<h3><small>搜索条件:</small></h3>
                        		</div>
                            <div class="col-sm-3">
                                <select name="type" class="selectpicker form-control">
                                    <option value="0">选择类型</option>
                                    <option value="1">角色名称</option>
                                    <option value="2">角色描述</option>
                                    <option value="3">是否启用</option>
                                </select>
                            </div>
                           
                            <div class="col-sm-5">
                                <div class="input-group">
                                    <input name="key" type="text" placeholder="请输入关键词" class="input-sm form-control">
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"><i class="fa fa-search"></i> 搜索</button>
                                    </span>
                                </div>
                                
                            </div>
                        </div>
                    </form>
                        <div class="hr-line-dashed2"></div>
                        <div class="row">
                            <div class="table-responsive">
                            <table class="table table-striped list-table">
                                <thead>
                                    <tr>		
                                        <th>选择</th>
                                        <th>角色名称</th>
                                        <th>角色描述：</th>
                                        <th>是否启用</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list }" var="role">
                                    <tr>
                                        <td><input class="checks" type="checkbox" value="${role.roleid }"></td>
										<td>${role.rolename }</td>
										<td>${role.roledis }</td>
										<td>
											<c:if test="${role.status ==0}">否</c:if>
											<c:if test="${role.status ==1}">是</c:if>
										</td>
                                        <td>
	                                        	<a id="${role.roleid }" href="javascript:void(0)" class="toUpdate"><i class="glyphicon glyphicon-edit  text-navy"></i></a>
	                                        	<a data-id="${role.roleid }" href="javascript:void(0)" class="btndel"><i class="glyphicon glyphicon-remove  text-navy"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>    
                                </tbody>
                            </table>
                        </div>
                        <div class="row">
	                        	<div class="col-sm-5">
	                        		<button class="btn btn-sm btn-primary btnAll" type="button"><i class="fa fa-check-square-o"></i> 全选</button>
	                        		<button class="btn btn-sm btn-primary btnRevers" type="button"><i class="fa fa-square-o"></i> 反选</button>
	                        		<button class="btn btn-sm btn-primary btnRemoveAll" type="button"><i class="fa fa-times-circle-o"></i> 删除</button>
	                        	</div>
							<div class="col-sm-7 text-right">
								<div class="btn-group">
	                               	<a <c:if test="${page.pageNum-1>=1 }"> href="${pageContext.request.contextPath}/role/list?pageNum=${page.pageNum-1 }&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum-1<1 }">disabled="disabled"</c:if>><i class="glyphicon glyphicon-chevron-left"></i>
	                                </a>
	                                <c:forEach begin="1" end="${page.pages }" varStatus="index">
	                                <a href="${pageContext.request.contextPath}/analysis/list?pageNum=${index.index }&key=${key }&type=${type }" class="btn btn-sm btn-white" <c:if test="${page.pageNum==index.index }">active</c:if>>${index.index }</a>
	                                </c:forEach>
	                                <a <c:if test="${page.pageNum+1<=page.pages }"> href="${pageContext.request.contextPath}/role/list?pageNum=${page.pageNum+1}&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum+1>page.pages }">disabled="disabled"</c:if> ><i class="glyphicon glyphicon-chevron-right"></i></a>
	                                </a>
	                            </div>
							</div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
            
	    	</div>
	
	</div>       
    <script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
     <script src="${pageContext.request.contextPath}/js/plugins/select/bootstrap-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/sweetalert/sweetalert.min.js"></script>

   <script>
	$(document).ready(function() {
		// 设置按钮的样式
		$('.selectpicker').selectpicker('setStyle', 'btn-white').selectpicker('setStyle', 'btn-sm');
		
		
	$(".btnAll").click(function(){
		var checks = $(".checks");
		checks.prop("checked",true);
	});
	
	$(".btnRevers").click(function(){
		var checks = $(".checks");
		$(checks).each(function(){
			var status = $(this).prop("checked");
			$(this).prop("checked",!status);
		});
	});
	
	$(".btnRemoveAll").click(function(){
		var checks = $(".checks:checked");
		var ids="";
		$(checks).each(function(){
			var id = $(this).val();
			ids += "&ids="+ id;
		});
		if(ids.length==0){
			return;
		}
		$.post("${pageContext.request.contextPath}/role/removeall",ids,function(result){
			if(result=="true"){
				 swal({
				        title: "删除成功",
				        text: "删除成功，摸摸哒",
				        type: "success",
				    }, function () {
					   location.href="${pageContext.request.contextPath}/role/list";
				    });
			}else{
				 swal({
				        title: "删除失败",
				        text: "删除失败，恭喜发财！",
				        type: "warning",
				    });
			}
		},"text");
	});
	
	
	$(".toUpdate").click(function(){
		$(".btnSave").prop("id","update");
		var oo = $(".btnSave").prop("id");
		alert(oo);
		var id = $(this).prop("id");
		$.post("${pageContext.request.contextPath}/role/toupdate",{"id":id},function(result){
			$(result).each(function(){
				$("#name").val(this.rolename);
				$("#roledis").val(this.roledis);
				if(this.status==1){
					$("#status").prop("checked",true);
					$("#status").val("1");
				}else{
					$("#status").prop("checked",false);
					$("#status").val("0");
				}
				$("#getid").val(this.roleid);
			});
		},"json");
	});
	
	$(".btnSave").click(function(){
		var choose = $(".btnSave").prop("id");
		if(choose=="update"){
			alert();
			$(".btnSave").prop("id","save");
			var data = $("#addformm").serialize();
			$.post("${pageContext.request.contextPath}/role/update",data,function(result){
				if(result=="true"){
					 swal({
					        title: "删除成功",
					        text: "删除成功，摸摸哒",
					        type: "success"
					    }, function () {
						   location.href="${pageContext.request.contextPath}/role/list";
					    });
				}else{
					 swal({
					        title: "修改失败",
					        text: "修改失败，怎么办",
					        type: "warning"
					    });
				}
			},"text");
		}else{
			var data = $("#addformm").serialize();
			$.post("${pageContext.request.contextPath}/role/save",data,function(result){
				if(result=="true"){
					 swal({
					        title: "添加成功",
					        text: "添加成功，摸摸哒",
					        type: "success"
					    }, function () {
						   location.href="${pageContext.request.contextPath}/role/list";
					    });
				}else{
					swal({
				        title: "添加失败",
				        text: "添加失败，怎么办",
				        type: "warning"
				    });
				}
			},"text");
		}
	});
		
	
		
		//点击删除
		$('.btndel').click(function () {
		    var id = $(this).data("id");
		    $.post("${pageContext.request.contextPath}/role/removeOne",{"id":id},function(result){
		    	if(result=="true"){
					 swal({
					        title: "删除成功",
					        text: "删除成功，摸摸哒",
					        type: "success"
					    }, function () {
						   location.href="${pageContext.request.contextPath}/role/list";
					    });
				}else{
					 swal({
					        title: "删除失败",
					        text: "删除失败，怎么办",
					        type: "warning"
					    });
				}
		    },"text");
		});
		
		
		
		
		
		
		$("#demo1").click(function() {
			//基本消息框－留着备用
			swal({
				title: "欢迎使用SweetAlert",
				text: "Sweet Alert 是一个替代传统的 JavaScript Alert 的漂亮提示效果。"
			})
		});
	});
    </script>
    
</body>


</html>
