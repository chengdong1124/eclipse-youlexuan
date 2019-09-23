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
    <div class="ibox float-e-margins">
    <form action="${pageContext.request.contextPath}/module/list">
                   <div class="ibox-content">
                        <div class="row">
                        		<div class="col-sm-3 col-sm-offset-2 text-right">
                        			<h3><small>搜索条件:</small></h3>
                        		</div>
                            <div class="col-sm-2">
                                <select name="type" class="selectpicker form-control">
                                    <option <c:if test="${type==0 }">selected="selected"</c:if> value="0">选择类型</option>
                                    <option <c:if test="${type==1 }">selected="selected"</c:if> value="1">模块名称</option>
                                    <option <c:if test="${type==2 }">selected="selected"</c:if> value="2">需求名称</option>
                                    <option <c:if test="${type==3 }">selected="selected"</c:if> value="3">项目名称</option>
                                </select>
                            </div>
                            <div class="col-sm-3">
                                <div class="input-group">
                                    <input value="${key }" name="key" type="text" placeholder="请输入关键词" class="input-sm form-control">
                                    <span class="input-group-btn">
                                        <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-search"></i>  搜索</button>
                                    </span>
                                </div>
                            </div>
    </form>
                            <div class="col-sm-2 text-right">
                            		<a href="${pageContext.request.contextPath}/save-module.jsp" class="btn btn-sm btn-primary" type="button"><i class="fa fa-plus-circle"></i> 添加模块</a>
                            	</div>
                        </div>
                        <div class="hr-line-dashed2"></div>
                        <div class="table-responsive">
                            <table class="table table-striped list-table">
                                <thead>
                                    <tr>
                                        <th>选择</th>
                                        <th>序号</th>
                                        <th>模块名称</th>
                                        <th>需求名称</th>
                                        <th>项目名称</th>
                                        <th>优先级</th>
                                        <th>修改时间</th>
                                        <th>修改时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list }" var="module">
                                    <tr>
                                        <td><input type="checkbox" value="${module.id }"></td>
										<td>${module.id }</td>
										<td>${module.modelname }</a></td>
										<td>${module.analysis.title }</a></td>
										<td>${module.projectname }</a></td>
										<td>
											<c:if test="${module.level=='中' }"><i class="fa fa-star-half-empty"></i>中</c:if>
											<c:if test="${module.level=='高' }"><i class="fa fa-star"></i>高</c:if>
											<c:if test="${module.level=='低' }"><i class="fa fa-star-half-o"></i>低</c:if>
										</td>
										
										<td><fmt:formatDate value="${module.analysis.addtime }"  pattern="yyyy-MM-dd"/></td>
										<td><fmt:formatDate value="${module.analysis.updatetime }"  pattern="yyyy-MM-dd"/></td>
                                        <td>
	                                        	<a href="${pageContext.request.contextPath}/module/show?id=${module.id }"><i class="glyphicon glyphicon-eye-open  text-navy"></i></a>
	                                        	<a href="${pageContext.request.contextPath}/module/toupdate?id=${module.id }"><i class="glyphicon glyphicon-edit  text-navy"></i></a>
	                                        	<a id="${module.id }" href="javascript:void(0)" class="btndel"><i class="glyphicon glyphicon-remove  text-navy"></i></a>
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
	                        		<button id="demo1" class="btn btn-sm btn-primary" type="button"><i class="fa fa-table"></i> 导出Excel</button>
	                        	</div>
							<div class="col-sm-7 text-right">
								<div class="btn-group">
	                                <a <c:if test="${page.pageNum-1>=1 }"> href="${pageContext.request.contextPath}/module/list?pageNum=${page.pageNum-1 }&checkName=${checkName }&status=${status }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum-1<1 }">disabled="disabled"</c:if>><i class="glyphicon glyphicon-chevron-left"></i>
	                                </a>
	                                <c:forEach begin="1" end="${page.pages }" varStatus="index">
	                                <a href="${pageContext.request.contextPath}/module/list?pageNum=${index.index }&checkName=${checkName }&status=${status }" class="btn btn-sm btn-white" <c:if test="${page.pageNum==index.index }">active</c:if>>${index.index }</a>
	                                </c:forEach>
	                                <a <c:if test="${page.pageNum+1<=page.pages }">href="${pageContext.request.contextPath}/module/list?pageNum=${page.pageNum+1}&checkName=${checkName }&status=${status }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum+1>page.pages }">disabled="disabled"</c:if> ><i class="glyphicon glyphicon-chevron-right"></i></a>
	                                </a>
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
			var checkbox = $("input[type=checkbox]");
			checkbox.prop("checked",true);
		});
		
		$(".btnRevers").click(function(){
			var checkbox = $("input[type=checkbox]");
			$(checkbox).each(function(){
				var status = $(this).prop("checked");
				$(this).prop("checked",!status);
			});
		});
		
		$(".btnRemoveAll").click(function(){
			var checkbox = $("input[type=checkbox]:checked");//$("input:checked";)也可以哦
			var ids ="";
			$(checkbox).each(function(){
				var id = $(this).val();
				ids += "&ids="+id;
			})
			$.post("${pageContext.request.contextPath}/module/removeall",ids,function(result){
				if(result=="true"){
					 swal({
					        title: "删除成功",
					        text: "删除成功，为您返回主页！",
					        type: "success"
					    }, function () {
						   location.href="${pageContext.request.contextPath}/module/list";
					    });
				}else if(result=="false"){
					swal({
				        title: "删除失败",
				        text: "删除成失败，为您返回主页！",
				        type: "warning"
				    });
				}else{
					swal({
				        title: "删除失败",
				        text: "删除成失败，"+result+"有关联数据",
				        type: "warning"
				    });
				}
			},"text");
		});

		//点击删除
		$('.btndel').click(function () {
			var id = $(this).prop("id");
			$.post("${pageContext.request.contextPath}/module/removeone",{"id":id},function(result){
				if(result=="true"){
					 swal({
					        title: "删除成功",
					        text: "删除成功，为您返回主页！",
					        type: "success"
					    }, function () {
						   location.href="${pageContext.request.contextPath}/module/list";
					    });
				}else{
					swal({
				        title: "删除失败",
				        text: "删除成失败，"+result+"有关联数据,请先删除关联数据",
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
