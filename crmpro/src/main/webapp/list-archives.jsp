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
    <form action="${pageContext.request.contextPath}/archives/list" method="post">
                   <div class="ibox-content">
                        <div class="row">
                        		<div class="col-sm-3 text-right">
                        			<h3><small>搜索条件:</small></h3>
                        		</div>
                            <div class="col-sm-2">
                                <select name="type" class="selectpicker form-control">
                                    <option <c:if test="${type==0 }">selected="selected"</c:if> value="0">选择类型</option>
                                    <option <c:if test="${type==1 }">selected="selected"</c:if> value="1">姓名</option>
                                    <option <c:if test="${type==2 }">selected="selected"</c:if> value="2">毕业院校</option>
                                   
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
                            		<a href="${pageContext.request.contextPath}/save-archives.jsp" class="btn btn-sm btn-primary" type="button"><i class="fa fa-plus-circle"></i> 添加档案</a>
                            </div>
                            
                            <div class="col-sm-2 text-right">
                            		<a href="${pageContext.request.contextPath}/save-archivesforfile.jsp" class="btn btn-sm btn-primary" type="button"><i class="fa fa-plus-circle"></i> 采集档案</a>
                            </div>
                            
                        </div>
                        <div class="hr-line-dashed2"></div>
                        <div class="table-responsive">
                            <table class="table table-striped list-table">
                                <thead>
                                    <tr>
                                        <th>选择</th>
                                        <th>序号</th>
                                        <th>姓名</th>
                                        <th>年龄</th>
                                        <th>毕业院校</th>
                                        <th>入职时间</th>
                                        <th>联系方式</th>
                                        <th>学历</th>
                                        <th>邮箱</th>
                                        <th>政治面貌</th>
                                        <th>民族</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list }" var="archives">
                               		<tr>
                                        <td><input class="checkboxs" type="checkbox" value="${archives.num }"></td>
										<td>${archives.num }</td>
										<td>${archives.employee.ename }</td>
										<td>${archives.employee.eage }</td>
										<td>${archives.school }</td>
										<td><fmt:formatDate value="${archives.employee.hiredate }" pattern="yyyy/MM/dd"/></td>
										<td>${archives.telephone }</td>
										<td>${archives.eductaion }</td>
										<td>${archives.email }</td>
										<td>${archives.policstatus }</td>
										<td>${archives.nation }</td>
                                        <td>
	                                        <a href="${pageContext.request.contextPath}/archives/show?id=${archives.num }"><i class="glyphicon glyphicon-eye-open  text-navy"></i></a>
	                                        <a href="${pageContext.request.contextPath}/archives/toupdate?id=${archives.num }"><i class="glyphicon glyphicon-edit  text-navy"></i></a>
	                                        <a id="${archives.num }" href="javascript:void(0)" class="btndel"><i class="glyphicon glyphicon-remove  text-navy"></i></a>
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
	                                <a <c:if test="${page.pageNum-1>=1 }"> href="${pageContext.request.contextPath}/archives/list?pageNum=${page.pageNum-1 }&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum-1<1 }">disabled="disabled"</c:if>><i class="glyphicon glyphicon-chevron-left"></i>
	                                </a>
	                                <c:forEach begin="1" end="${page.pages }" varStatus="index">
	                                <a href="${pageContext.request.contextPath}/archives/list?pageNum=${index.index }&key=${key }&type=${type }" class="btn btn-sm btn-white" <c:if test="${page.pageNum==index.index }">active</c:if>>${index.index }</a>
	                                </c:forEach>
	                                <a <c:if test="${page.pageNum+1<=page.pages }">href="${pageContext.request.contextPath}/archives/list?pageNum=${page.pageNum+1}&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum+1>page.pages }">disabled="disabled"</c:if> ><i class="glyphicon glyphicon-chevron-right"></i></a>
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
			var ids = "";
			$(checks).each(function(){
				var id = $(this).val();
				ids += "&ids="+id;
			});
			if(ids.length==0){
				return;
			}
			$.post("${pageContext.request.contextPath}/archives/removeall",ids,function(result){
				if(result=="true"){
					 swal({
					        title: "删除成功",
					        text: "删除成功，恭喜恭喜！",
					        type: "success"
					    }, function () {
					    	location.href="${pageContext.request.contextPath}/archives/list";
					    });
				}else{
					 swal({
					        title: "删除失败",
					        text: "删除失败，么办法！",
					        type: "warning"
					    });
				}
			},"text");
		});
		
		$(".btndel").click(function(){
			var id = $(this).prop("id");
			$.post("${pageContext.request.contextPath}/archives/removeone",{"id":id},function(result){
				if(result=="true"){
					swal({
				        title: "删除成功",
				        text: "删除成功，恭喜恭喜！",
				        type: "success"
				    }, function () {
				    	location.href="${pageContext.request.contextPath}/archives/list";
				    });
				}else{
					 swal({
					        title: "删除失败",
					        text: "删除失败，么办法！",
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
