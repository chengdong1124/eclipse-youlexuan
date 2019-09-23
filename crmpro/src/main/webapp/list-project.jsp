 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    	<link href="${pageContext.request.contextPath}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/select/bootstrap-select.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper2 wrapper-content2 animated fadeInRight">
    <div class="ibox float-e-margins">
    			<form action="${pageContext.request.contextPath}/project/list" method="POST">
                   <div class="ibox-content">
                        <div class="row">
                        		<div class="col-sm-3 col-sm-offset-2 text-right">
                        			<h3><small>搜索条件:</small></h3>
                        		</div>
                            <div class="col-sm-2">
                                <select name="type" class="selectpicker form-control">                           
                                    <option value="0" <c:if test="${type==0 }">selected="selected"</c:if>>选择类型</option>
                                    <option value="1" <c:if test="${type==1 }">selected="selected"</c:if>>项目名称</option>
                                    <option value="2" <c:if test="${type==2 }">selected="selected"</c:if>>项目经理</option>
                                </select>
                            </div>
                            <div class="col-sm-3">
                                <div class="input-group">
                                    <input  name="key" value="${key }" type="text" placeholder="请输入关键词" class="input-sm form-control">
                                    <span class="input-group-btn">
                                        <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-search"></i>查询</button>
                                    </span>
                                </div>
                            </div>
				</form>
                            <div class="col-sm-2 text-right">
                            		<a href="${pageContext.request.contextPath}/save-project.jsp" class="btn btn-sm btn-primary" type="button"><i class="fa fa-plus-circle"></i> 添加项目</a>
                            	</div>
                        </div>
                        <div class="hr-line-dashed2"></div>
                        <div class="table-responsive">
                            <table class="table table-striped list-table">
                                <thead>
                                    <tr>
                                        <th>选择</th>
                                        <th>序号</th>
                                        <th>项目名称</th>
                                        <th>客户公司名称</th>
                                        <th>客户方负责人</th>
                                        <th>项目经理</th>
                                        <th>开发人员数</th>
                                        <th>开始时间</th>
                                        <th>最近更新时间</th>
                                        <th>计划完成时间</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list }" var="project">
                                    <tr>
                                        <td>
	                                    	<input  type="checkbox" value="${project.pid }">
	                                    </td>
	                                     <td>${project.pid }</td>
                                        <td></a>${project.pname }</td>
                                        <td>${project.customer.comname }</td>
                                        <td>${project.companyperson }</td>
                                        <td>${project.employee.ename }</td>
                                        <td>${project.empcount }</td>
                  						<td><fmt:formatDate value="${project.buildtime }" pattern="yyyy-MM-dd"/></td>
                                        <td><fmt:formatDate value="${project.starttime }" pattern="yyyy-MM-dd"/></td>
                                        <td><fmt:formatDate value="${project.endtime }" pattern="yyyy-MM-dd"/></td>
                                        <td><i class="fa fa-hourglass-half"></i>进行中</td>
                                        <td>
                                        	<a href="${pageContext.request.contextPath}/project/getById?pid=${project.pid }&status=1" class="detail"><i class="glyphicon glyphicon-eye-open  text-navy"></i>详情</a>
                                        	<a href="${pageContext.request.contextPath}/project/getById?pid=${project.pid }&status=2"><i class="glyphicon glyphicon-edit  text-navy"></i>修改</a>
                                        	<a id="${project.pid }" href="javascript:void(0)" class="btndel removeOne"><i class="glyphicon glyphicon-remove text-navy"></i>删除</a>
                                        </td>
                                    </tr>
                                    
                                </tbody>
                                </c:forEach> 
                            </table>
                        </div>
                       
                        <div class="row">
	                        	<div class="col-sm-5">
	                        		<button class="btn btn-sm btn-primary btnAll" type="button"><i class="fa fa-check-square-o"></i> 全选</button>
	                        		<button class="btn btn-sm btn-primary btnReverse" type="button"><i class="fa fa-square-o"></i> 反选</button>
	                        		<button class="btn btn-sm btn-primary btnDel" type="button"><i class="fa fa-times-circle-o"></i> 删除</button>
	                        		<a href="${pageContext.request.contextPath}/project/getexcel" id="demo1" class="btn btn-sm btn-primary" type="button"><i class="fa fa-table"></i> 导出Excel</a>
	                        	</div>
							<div class="col-sm-7 text-right">
								<div class="btn-group">
									
	                                <a <c:if test="${page.pageNum-1>=1 }"> href="${pageContext.request.contextPath}/project/list?pageNum=${page.pageNum-1 }&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum-1<1 }">disabled="disabled"</c:if>><i class="glyphicon glyphicon-chevron-left"></i>
	                                </a>
	                                
	                                <c:forEach begin="1" end="${page.pages }" varStatus="index">
	                                <a href="${pageContext.request.contextPath}/project/list?pageNum=${index.index }&key=${key }&type=${type }" class="btn btn-sm btn-white" <c:if test="${page.pageNum==index.index }">active</c:if>>${index.index }</a>
	                                </c:forEach>
	                                
	                                <a <c:if test="${page.pageNum+1<=page.pages }">href="${pageContext.request.contextPath}/project/list?pageNum=${page.pageNum+1}&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum+1>page.pages }">disabled="disabled"</c:if> ><i class="glyphicon glyphicon-chevron-right"></i></a>
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
			var checks = $("input[type='checkbox']"); //给个class也能选出来
			$(checks).prop("checked","checked");	//所有的checkbox一起选择被标记
		});
		
		$(".btnReverse").click(function(){
			var checks = $("input[type='checkbox']");
			$(checks).each(function(){
				var status = $(this).prop("checked");
				$(this).prop("checked",!status);  //这里被选中是true
			});
		});
		
		$(".btnDel").click(function(){		
			var checks = $("input:checked");
			var ids=""
			var message=""
			$(checks).each(function(){
				var id = $(this).val();
				ids += "&ids="+id;	
				message += ","+id;
			});	
			if(ids.length==0){
				return;
			}
				$.post("${pageContext.request.contextPath}/project/removeall",ids,function(result){
					if(result=="true"){
						swal({
							title: "删除成功",
							text: "数据删除成功，为你返回列表页",
							type: "success"
						},function(){
							location.href="${pageContext.request.contextPath}/project/list";
						});
					}else if(result=="false"){
						swal({
							title: "数据删除失败",
							text: "客户信息删除失败"+message.substring(1)+"的项目存在关系数据，请先删除关联数据",
							type: "warning"
						});
					}else{
						swal({
							title: "部分数据删除失败",
							text: "序号"+result+"的项目存在关系数据，请先删除关联数据",
							type: "warning"
						},function(){
							location.href="${pageContext.request.contextPath}/project/list";
						});
					}
				},"text");
		});
		
		
		//删除单个
		$(".removeOne").click(function(){
			var pid = $(this).prop("id");
			$.post("${pageContext.request.contextPath}/project/removeOne",{"pid":pid},function(result){
				if(result=="false"){
					swal({
						title: "数据删除失败",
						text: "客户信息删除失败"+pid+"可能是因为存在关系数据，请先删除关联数据",
						type: "warning"
					});
				}else{
					swal({
						title: "数据删除成功",
						text: "客户信息删除成功，恭喜啊",
						type: "success"
					},function(){
						location.href="${pageContext.request.contextPath}/project/list";
					});
				}
			},"text");
		});	
		
	
	});
    </script>
    
</body>


</html>








