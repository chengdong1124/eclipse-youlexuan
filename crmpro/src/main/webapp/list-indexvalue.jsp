 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
    <form action="${pageContext.request.contextPath}/indexvalue/list" method="post">
                   <div class="ibox-content">
                        <div class="row">
                        		<div class="col-sm-3 col-sm-offset-2 text-right">
                        			<h3><small>搜索条件:</small></h3>
                        		</div>
                            <div class="col-sm-2">
                                <select value="${type }" name="type" class="selectpicker form-control">
                                    <option <c:if test="${type==0 }">select="selected"</c:if> value="0">选择类型</option>
                                    <option <c:if test="${type==1 }">select="selected"</c:if> value="1">目标公司</option>
                                    <option <c:if test="${type==2 }">select="selected"</c:if> value="2">制定制定人</option>
                                    
                                </select>
                            </div>
                           
                            <div class="col-sm-3">
                                <div class="input-group">
                                    <input value="${key }" name="key" type="text" placeholder="请输入关键词" class="input-sm form-control">
                                    <span class="input-group-btn">
                                        <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-search"></i> 搜索</button>
                                    </span>
                                </div>
    </form>                        
                            </div>
                            <div class="col-sm-2 text-right">
                            		<a href="${pageContext.request.contextPath}/save-indexvalue.jsp" class="btn btn-sm btn-primary" type="button"><i class="fa fa-plus-circle"></i>添加指标信息</a>
                            	</div>
                        </div>
                        <div class="hr-line-dashed2"></div>
                        <div class="table-responsive">
                            <table class="table table-striped list-table">
                                <thead>
                                    <tr>
                                        <th>选择</th>
                                        <th>序号</th>
                                        <th>目标公司</th>
                                        <th>目标营业额</th>
                                        <th>指标制定人</th>
                                        <th>指标开始时间</th>
                                        <th>指标截止时间</th>
                                        <th class="text-center">操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list }" var="indexvalue">
                                    <tr>
                                        <td><input  type="checkbox" value="${indexvalue.id }"></td>
										<td>${indexvalue.id }</td>
										<td>${indexvalue.datacollect.dacname }</td>
										<td>${indexvalue.turnover }</td>
										<td>${indexvalue.employee.ename }</td>
										<td><fmt:formatDate value="${indexvalue.starttime }" pattern="yyyy/MM/dd"/></td>
										<td><fmt:formatDate value="${indexvalue.endtime }" pattern="yyyy/MM/dd"/></td>
                                        <td class="text-right">
	                                        	<a href="${pageContext.request.contextPath}/indexvalue/show?id=${indexvalue.id }" class="btn btn-primary btn-xs"><i class="fa fa-eye"></i> 查看</a>
	                                        	<a href="${pageContext.request.contextPath}/indexvalue/toupdate?id=${indexvalue.id }" class="btn btn-primary btn-xs"><i class="fa fa-edit"></i> 编辑</a>
	                                        	<a href="/upload/${indexvalue.file }" class="btn btn-danger btn-xs"><i class="fa fa-download"></i> 附件下载</a>
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
	                        		<button class="btn btn-sm btn-primary removeAll" type="button"><i class="fa fa-times-circle-o"></i> 删除</button>
	                        		<button id="demo1" class="btn btn-sm btn-primary" type="button"><i class="fa fa-table"></i> 导出Excel</button>
	                        	</div>
							<div class="col-sm-7 text-right">
								<div class="btn-group">
	                                <a <c:if test="${page.pageNum-1>=1 }"> href="${pageContext.request.contextPath}/indexvalue/list?pageNum=${page.pageNum-1 }&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum-1<1 }">disabled="disabled"</c:if>><i class="glyphicon glyphicon-chevron-left"></i>
	                                </a>
	                                <c:forEach begin="1" end="${page.pages }" varStatus="index">
	                                <a href="${pageContext.request.contextPath}/indexvalue/list?pageNum=${index.index }&key=${key }&type=${type }" class="btn btn-sm btn-white" <c:if test="${page.pageNum==index.index }">active</c:if>>${index.index }</a>
	                                </c:forEach>
	                                <a <c:if test="${page.pageNum+1<=page.pages }">href="${pageContext.request.contextPath}/indexvalue/list?pageNum=${page.pageNum+1}&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum+1>page.pages }">disabled="disabled"</c:if> ><i class="glyphicon glyphicon-chevron-right"></i></a>
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
		$(".removeAll").click(function(){
			var checks = $("input[type=checkbox]:checked"); //或者 $("input:checked")也可选出来
			var ids ="";
			$(checks).each(function(){
				var id = $(this).val();
				ids += "&ids="+id;
			});
			if(ids.length==0){
				return;
			}
			ids = ids.substring(1);
			$.post("${pageContext.request.contextPath}/indexvalue/removeall",ids,function(result){
				if(result=="true"){
					swal({
				        title: "删除成功",
				        text: "删除成功，恭喜发财！",
				        type: "success"
				    }, function() {
					    location.href="${pageContext.request.contextPath}/indexvalue/list";
				    });
				}else{
					swal({
				        title: "删除失败",
				        text: "删除失败，没法了！",
				        type: "warning"
				    });
				}
			},"text");
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//点击删除
		$('.btndel').click(function () {
		    swal({
		        title: "您确定要删除这条信息吗",
		        text: "删除后将无法恢复，请谨慎操作！",
		        type: "warning",
		        showCancelButton: true,
		        confirmButtonColor: "#DD6B55",
		        confirmButtonText: "删除",
		        closeOnConfirm: false
		    }, function () {//此函数是点击删除执行的函数
		    		//这里写ajax代码
		    		// 以下是成功的提示框，请在ajax回调函数中执行
			    swal("删除成功！", "您已经永久删除了这条信息。", "success");
		    });
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
