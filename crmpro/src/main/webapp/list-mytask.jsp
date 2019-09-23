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
                   <div class="ibox-content">
                        <div class="row">
                        		<div class="col-sm-3 col-sm-offset-4 text-right">
                        			<h3><small>搜索条件:</small></h3>
                        		</div>
                            <div class="col-sm-2">
                                <select class="selectpicker form-control">
                                    <option value="0">选择类型</option>
                                    <option value="1">项目名称</option>
                                    <option value="2">项目经理</option>
                                </select>
                            </div>
                           
                            <div class="col-sm-3">
                                <div class="input-group">
                                    <input type="text" placeholder="请输入关键词" class="input-sm form-control">
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"><i class="fa fa-search"></i> 搜索</button>
                                    </span>
                                </div>
                                
                            </div>
                            
                        </div>
                        <div class="hr-line-dashed2"></div>
                        <div class="table-responsive">
                            <table class="table table-striped list-table">
                                <thead>
                                    <tr>
                                        
                                        <th>序号</th>
                                        <th>任务标题</th>
                                        <th>创建人</th>
                                        <th>状态</th>
                                        <th>优先级</th>
                                        <th>开始时间</th>
                                        <th>结束时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list }" var="task">
                                    <tr>
                                       <td>
	                                        	<input type="checkbox" value="${task.id }">
	                                   </td>
                                       <td>${task.tasktitle }</td>
                                       <td>${task.distributor.ename }</td>
                                       <td>
                                        <c:if test="${task.status==0 }"><i class="fa fa-hourglass-satrt"></i>分配</c:if>
                                        <c:if test="${task.status==1 }"><i class="fa fa-hourglass-half"></i>进行中</c:if>
                                        <c:if test="${task.status==2 }"><i class="fa fa-hourglass-end"></i>完成</c:if>
                                       </td>
                                       <td>
                                       	<c:if test="${task.level=='暂缓' }">暂缓</c:if>
                                       	<c:if test="${task.level=='低' }"><i class="fa fa-star-o"></i>低</c:if>
                                       	<c:if test="${task.level=='中' }"><i class="fa fa-star-half-empty"></i>中</c:if>
                                       	<c:if test="${task.level=='高' }"><i class="fa fa-star"></i>高</c:if>
                                       </td>
                                       <td><fmt:formatDate value="${task.starttime }" pattern="yyyy-MM-dd"/></td>
                                       <td><fmt:formatDate value="${task.endtime }" pattern="yyyy-MM-dd"/></td>
                                       <td>
                                        	<a class="btn btn-primary btn-xs" href="show-task.jsp"><i class="fa fa-eye"></i>查看</a>
                                        	<c:if test="${task.status==0 }">
                                        		<button id="${task.id }" class="btn btn-success btn-xs btnStart"><i class="fa fa-hourglass-start"></i>开始</button>
                                      		</c:if>
                                      		<c:if test="${task.status==1 }">
                                        		<button id="${task.id }" class="btn btn-danger btn-xs btnFinish"><i class="fa fa-hourglass-end"></i>完成</button>
                                      		</c:if>
                                       </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                       
                        <div class="row">
	                        
							<div class="col-sm-12 text-right">
								<div class="btn-group">
	                                <a <c:if test="${page.pageNum-1>=1 }"> href="${pageContext.request.contextPath}/task/mylist?pageNum=${page.pageNum-1 }&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum-1<1 }">disabled="disabled"</c:if>><i class="glyphicon glyphicon-chevron-left"></i>
	                                </a>
	                                <c:forEach begin="1" end="${page.pages }" varStatus="index">
	                                <a href="${pageContext.request.contextPath}/project/list?pageNum=${index.index }&key=${key }&type=${type }" class="btn btn-sm btn-white" <c:if test="${page.pageNum==index.index }">active</c:if>>${index.index }</a>
	                                </c:forEach>
	                                <a <c:if test="${page.pageNum+1<=page.pages }">href="${pageContext.request.contextPath}/task/mylist?pageNum=${page.pageNum+1}&key=${key }&type=${type }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum+1>page.pages }">disabled="disabled"</c:if> ><i class="glyphicon glyphicon-chevron-right"></i></a>
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
		
		
		$(".btnStart").click(function(){
			var id=$(this).prop("id");
			var $this = $(this);
			$.post("${pageContext.request.contextPath}/task/updatestatus",{"id":id,"status":1},function(result){
				if(result=="true"){
					swal({
				     	title: "状态修改成功",
				        text: "任务已开始，请注意完成时间",
				        type: "success"
				    });
					var str = "<i class='fa fa-hourglass-half'></i>进行中";
					$this.parents("tr").children(":eq(3)").html(str);
					str ="<i class='fa fa-hourglass-end'></i>完成";
					$this.html(str).removeClass("btn-success").removeClass("btnStart").addClass("btn-danger").off();
					//这里不删除也可以，后面那个class的样式会覆盖前面的class的样式
				}else{
					swal({
				     	title: "状态修改失败",
				        text: "请稍后再试",
				        type: "warning"
				    });
				}
			},"text");
		});
		
		
	 $(".btnFinish").click(function(){
			var id=$(this).prop("id");
			var $this = $(this);
			$.post("${pageContext.request.contextPath}/task/updatestatus",{"id":id,"status":2},function(result){
				if(result=="true"){
					swal({
				     	title: "状态修改成功",
				        text: "任务已开始，请注意完成时间",
				        type: "success"
				    });
					var str = "<i class='fa fa-hourglass-end'></i>完成";
					$this.parents("tr").children(":eq(3)").html(str);
					//$this.html(str).removeClass("btn-success").removeClass("btnStart").addClass("btn-danger").off();
					$this.remove();
				}else{
					swal({
				     	title: "状态修改失败",
				        text: "请稍后再试",
				        type: "warning"
				    });
				}
			},"text");
		});
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
		
		//点击删除
		$('.btndel').click(function () {
		    swal({
		        title: "您确定要撤销该报销吗",
		        text: "撤销后将无法恢复，请谨慎操作！",
		        type: "warning",
		        showCancelButton: true,
		        confirmButtonColor: "#DD6B55",
		        confirmButtonText: "yes",
		        closeOnConfirm: false
		    }, function () {
		    	$.post("${pageContext.request.contextPath}/account/remove")
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
