 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
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
                        <h5>添加部门</h5>
                    </div>
                    <div class="ibox-content">
                        <form id="addform" class="form-horizontal" method="post">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">部门编号：</label>
                                <div class="col-sm-8">
                                    <input class="deptno" name="deptno" type="email" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">部门名称：</label>
                                <div class="col-sm-8">
                                    <input class="dname" name="dname" type="email" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">区域：</label>
                                <div class="col-sm-8">
                                    <input class="dlocation" name="dlocation" type="email" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button id="save" class="btn btn-sm btn-white btnSave" type="button"><i class="fa fa-save"></i> 保存</button>
                                    <button class="btn btn-sm btn-white reset" type="button"><i class="fa fa-undo"></i> 重置</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
	    		<div class="col-sm-7">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>部门列表 <small>点击修改信息将显示在左边表单</small></h5>
                    </div>
                    <div class="ibox-content">
                    <form action="${pageContext.request.contextPath}/depatment/list" method="post">
                    		<div class="row">
                        		<div class="col-sm-2 col-sm-offset-2 text-right">
                        			<h3><small>搜索条件:</small></h3>
                        		</div>
                            <div class="col-sm-3">
                                <select name="type" class="selectpicker form-control">
                                    <option value="0">选择类型</option>
                                    <option value="1">部门编号</option>
                                    <option value="2">部门名称</option>
                                    <option value="3">区域</option>
                                </select>
                            </div>
                           
                            <div class="col-sm-5">
                                <div class="input-group">
                                    <input name="key" type="text" placeholder="请输入关键词" class="input-sm form-control">
                                    <span class="input-group-btn">
                                        <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-search"></i> 搜索</button>
                                    </span>
                                </div>
                                
                            </div>
                        </form>
                        </div>
                        <div class="hr-line-dashed2"></div>
                        <div class="row">
                            <div class="table-responsive">
                            <table class="table table-striped list-table">
                                <thead>
                                    <tr>		
                                        <th>选择</th>
                                        <th>部门编号</th>
                                        <th>部门名称</th>
                                        <th>区域</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list }" var="depatment">
                                    <tr>
                                        <td><input type="checkbox" value="${depatment.deptno }"></td>
										<td>${depatment.deptno }</td>
										<td>${depatment.dname }</td>
										<td>${depatment.dlocation }</td>
                                        <td>
	                                        	<a data-dlocation="${depatment.dlocation }" data-dname="${depatment.dname }" data-deptno="${depatment.deptno }" href="javascript:void(0)" id="${depatment.deptno }" class="toUpdate"><i class="glyphicon glyphicon-edit  text-navy"></i></a>
	                                        	<a href="javascript:void(0)" id="${depatment.deptno }" class="btndel"><i class="glyphicon glyphicon-remove  text-navy"></i></a>
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
	                                <a <c:if test="${page.pageNum-1>=1 }"> href="${pageContext.request.contextPath}/depatment/list?pageNum=${page.pageNum-1 }&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum-1<1 }">disabled="disabled"</c:if>><i class="glyphicon glyphicon-chevron-left"></i>
	                                </a>
	                                
	                                <c:forEach begin="1" end="${page.pages }" varStatus="index">
	                                <a href="${pageContext.request.contextPath}/depatment/list?pageNum=${index.index }&key=${key }&type=${type }" class="btn btn-sm btn-white" <c:if test="${page.pageNum==index.index }">active</c:if>>${index.index }</a>
	                                </c:forEach>
	                                
	                                <a <c:if test="${page.pageNum+1<=page.pages }">href="${pageContext.request.contextPath}/depatment/list?pageNum=${page.pageNum+1}&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum+1>page.pages }">disabled="disabled"</c:if> ><i class="glyphicon glyphicon-chevron-right"></i></a>
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
			var checks = $("input[type=checkbox]");
			checks.prop("checked",true);
		});
		$(".btnRevers").click(function(){
			var checks = $("input[type=checkbox]");
			$(checks).each(function(){
				var status = $(this).prop("checked");
				$(this).prop("checked",!status);
			});
		});
		
		$(".btnRemoveAll").click(function(){
			var checks = $("input[type=checkbox]:checked");
			var ids=""
			$(checks).each(function(){
				var id = $(this).val();
				ids += "&ids="+id;
			});
			if(ids.length==0){
				return;
			}
			$.post("${pageContext.request.contextPath}/depatment/removeall",ids,function(result){
				if(result=="true"){
					 swal({
					        title: "删除成功",
					        text: "恭喜恭喜!",
					        type: "success"
					    }, function () {
					    		location.href="${pageContext.request.contextPath}/depatment/list";
					    });
				}else if(result=="false"){
					ids = ids.subString(1);
					 swal({
					        title: "删除失败",
					        text: "可能是因为"+ids+"有关联数据",
					        type: "warning"
					    });
				}else{
					swal({
				        title: "删除失败",
				        text: "因为"+result+"有关联数据",
				        type: "warning"
				    });
				}
			},"text");
		});
		
		$(".toUpdate").click(function(){
			$(".btnSave").prop("id","update");
			var deptno = $(this).data("deptno");
			var dlocation = $(this).data("dlocation");
			var dname = $(this).data("dname");
			$(".deptno").val(deptno);
			$(".dlocation").val(dlocation);
			$(".dname").val(dname);
		});
		
		$(".btnSave").click(function(){
			var id = $(this).prop("id");
			if(id=="save"){
				var data = $("#addform").serialize();
				$.post("${pageContext.request.contextPath}/depatment/save",data,function(result){
					if(result=="true"){
						 swal({
						        title: "添加成功",
						        text: "添加成功，恭喜恭喜",
						        type: "success"
						    },function(){
						    	location.href="${pageContext.request.contextPath}/depatment/list";
						    });
					}else{
						swal({
					        title: "添加失败",
					        text: "添加失败，这可咋办",
					        type: "warning"
					    });
					}
				},"text");
			}else{
				$(this).prop("id","save");
				var data = $("#addform").serialize();
				$.post("${pageContext.request.contextPath}/depatment/update",data,function(result){
					if(result=="true"){
						 swal({
						        title: "修改成功",
						        text: "修改成功，恭喜恭喜",
						        type: "success"
						    },function(){
						    	location.href="${pageContext.request.contextPath}/depatment/list";
						    });
					}else{
						swal({
					        title: "修改失败",
					        text: "修改失败，这可咋办",
					        type: "warning"
					    });
					}
				},"text");
				
			}
		});
		
		$(".reset").click(function(){
			$("#addform")[0].reset();
		});
		
		//点击删除
		$('.btndel').click(function () {
			var id = $(this).prop("id");
		   $.post("${pageContext.request.contextPath}/depatment/removeone",{"id":id},function(result){
			   if(result=="true"){
				   swal({
				        title: "删除成功",
				        text: "修改成功，太好了",
				        type: "success"
				    },function(){
				    	location.href="${pageContext.request.contextPath}/depatment/list";
				    });
			   }else{
				   swal({
				        title: "删除失败",
				        text: "修改失败，可能是因为deptno="+id+"的数据有关联数据",
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
