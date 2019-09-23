 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
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
    <div class="ibox float-e-margins">
    <form action="${pageContext.request.contextPath}/datacollect/list" method="post">
                   <div class="ibox-content">
                        <div class="row">
                        		<div class="col-sm-3 text-right">
                        			<h3><small>搜索条件:</small></h3>
                        		</div>
                            <div class="col-sm-2">
                                <select name="type" class="selectpicker form-control">
                                    <option <c:if test="${type==0 }">selected="selected"</c:if> value="0">选择类型</option>
                                    <option <c:if test="${type==1 }">selected="selected"</c:if> value="1">企业名称</option>
                                    <option <c:if test="${type==2 }">selected="selected"</c:if> value="2">企业性质</option>
                                    
                                </select>
                            </div>
                           
                            <div class="col-sm-3">
                                <div class="input-group">
                                    <input value="${key }" name="key" type="text" placeholder="请输入关键词" class="input-sm form-control">
                                    <span class="input-group-btn">
                                        <button type="sumbit" class="btn btn-sm btn-primary"><i class="fa fa-search"></i> 搜索</button>
                                    </span>
                                </div>
     </form>                           
                            </div>
                            <div class="col-sm-2 text-right">
                            		<a href="${pageContext.request.contextPath}/save-benchmarking.jsp" class="btn btn-sm btn-primary" type="button"><i class="fa fa-plus-circle"></i>添加对标信息</a>
                            	</div>
                            	<div class="col-sm-2 text-right">
                            		<a href="${pageContext.request.contextPath}/save-benchmarkingforfile.jsp" class="btn btn-sm btn-primary" type="button"><i class="fa fa-plus-circle"></i>采集对标信息</a>
                            	</div>
                        </div>
                        <div class="hr-line-dashed2"></div>
                        <div class="table-responsive">
                            <table class="table table-striped list-table">
                                <thead>
                                    <tr>
                                        <th>选择</th>
                                        <th>序号</th>
                                        <th>企业名称</th>
                                        <th>年营业额</th>
                                        <th>企业性质</th>
                                        <th>员工数量</th>
                                        <th>成立时间</th>
                                        <th class="text-center">操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list }" var="datacollect">
                                    <tr>
                                        <td><input class="checkboxs" type="checkbox" value="${datacollect.daid }"></td>
										<td>${datacollect.daid }</td>
										<td>${datacollect.dacname }</td>
										<td>${datacollect.daturnover }亿</td>
										<td>${datacollect.dabusiness }</td>
										<td>${datacollect.empcount}</td>
										<td><fmt:formatDate value="${datacollect.buildtime}" pattern="yyyy/MM/dd"/></td>
                                        <td class="text-right">
	                                        	<a href="${pageContext.request.contextPath}/datacollect/show?id=${datacollect.daid }" class="btn btn-primary btn-xs"><i class="fa fa-eye"></i>查看</a>
	                                        	<a href="${pageContext.request.contextPath}/datacollect/toupdate?id=${datacollect.daid }" class="btn btn-primary btn-xs"><i class="fa fa-edit"></i>编辑</a>
	                                        	<button id="${datacollect.daid }" type="button" class="btn btn-danger btn-xs btnRemove"><i class="fa fa-close"></i>删除</button>
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
	                                <a <c:if test="${page.pageNum-1>=1 }"> href="${pageContext.request.contextPath}/datacollect/list?pageNum=${page.pageNum-1 }&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum-1<1 }">disabled="disabled"</c:if>><i class="glyphicon glyphicon-chevron-left"></i>
	                                </a>
	                                <c:forEach begin="1" end="${page.pages }" varStatus="index">
	                                <a href="${pageContext.request.contextPath}/datacollect/list?pageNum=${index.index }&key=${key }&type=${type }" class="btn btn-sm btn-white" <c:if test="${page.pageNum==index.index }">active</c:if>>${index.index }</a>
	                                </c:forEach>
	                                <a <c:if test="${page.pageNum+1<=page.pages }">href="${pageContext.request.contextPath}/datacollect/list?pageNum=${page.pageNum+1}&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum+1>page.pages }">disabled="disabled"</c:if> ><i class="glyphicon glyphicon-chevron-right"></i></a>
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
			$(".checkboxs").prop("checked",true);
		});
		
		$(".btnRevers").click(function(){
			var checks = $(".checkboxs");
			$(checks).each(function(){
				var status = $(this).prop("checked");
				$(this).prop("checked",!status);
			});
		});
		
		$(".btnRemoveAll").click(function(){
			var checks = $(".checkboxs:checked");
			var ids =""
			$(checks).each(function(){
				var id = $(this).val();
				ids += "&ids="+id;
			});
			if(ids.length<0){ //直接在前台就给予控制
				return;
			}
			$.post("${pageContext.request.contextPath}/datacollect/removeall",ids,function(result){
				if(result=="true"){
					 swal({
					        title: "删除成功",
					        text: "删除成功，恭喜恭喜！",
					        type: "success"
					    }, function () {
						    location.href="${pageContext.request.contextPath}/datacollect/list";
					    });
				}else if(result=="false"){
					swal({
				        title: "删除失败",
				        text: "删除失败，这可杂么办",
				        type: "warning"
				    })
				}else{
					swal({
				        title: "部分删除失败",
				        text: result+"删除失败",
				        type: "warning"
				    },function () {
					    location.href="${pageContext.request.contextPath}/datacollect/list";
				    })
				}
			},"text");
		});
		
		$(".btnRemove").click(function(){
			var id = $(this).prop("id");
			$.post("${pageContext.request.contextPath}/datacollect/removeone",{"id":id},function(result){
				if(result=="true"){
					swal({
				        title: "删除成功",
				        text: "删除成功，恭喜发财",
				        type: "success"
				    },function () {
					    location.href="${pageContext.request.contextPath}/datacollect/list";
				    });
				}else{
					swal({
				        title: "删除失败",
				        text: "删除失败，"+id+"与其他数据有联系",
				        type: "warning"
				    });
				}
			},"text");
		});
		
		
		
		
		
		
		
		
		
	
	});
    </script>
    
</body>


</html>
