<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/select/bootstrap-select.min.css" rel="stylesheet">
</head>

<body class="gray-bg">
	<div class="wrapper2 wrapper-content2 animated fadeInRight">
    <div class="ibox float-e-margins">
    <form action="${pageContext.request.contextPath}/account/mylist" method="post">
                   <div class="ibox-content">
                        <div class="row">
                        		<div class="col-sm-3 col-sm-offset-4 text-right">
                        			<h3><small>搜索条件:</small></h3>
                        		</div>
                            <div class="col-sm-2">
                                <select name="status" class="selectpicker form-control">
                                    <option <c:if test="${status==4 }">selected="selected"</c:if> value="4">选择状态</option>
                                    <option <c:if test="${status==0 }">selected="selected"</c:if> value="0">驳回</option>
                                    <option <c:if test="${status==1 }">selected="selected"</c:if> value="1">待审批</option>
                                    <option <c:if test="${status==2 }">selected="selected"</c:if> value="2">待付款</option>
                                    <option <c:if test="${status==3 }">selected="selected"</c:if> value="3">已付款</option>
                                   
                                </select>
                            </div>
                           
                            <div class="col-sm-3">
                                <div class="input-group">
                                    <input value="${key }" name="key" type="text" placeholder="请输入报销单号" class="input-sm form-control">
                                    <span class="input-group-btn">
                                        <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-search"></i> 搜索</button>
                                    </span>
                                </div>
                                
                            </div>
	</form> 
                        </div>
                        <div class="hr-line-dashed2"></div>
                        <div class="table-responsive">
                            <table class="table table-striped list-table">
                                <thead>
                                    <tr>
                                        <th>单号</th>
                                        <th>类型</th>
                                        <th>报销人</th>
                                        <th>总金额</th>
                                        <th>使用时间</th>
                                        <th>备注信息</th>
                                        <th>审批意见</th>
                                        <th>审批状态</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list }" var="account">
                                    <tr>
                                        <td>${account.bxid }</td>
                                        <td>${account.paymode }</td>
                                        <td>${account.employee.ename }</td>
                                        <td>${account.totalmoney }</td>
                                       	<td><fmt:formatDate value="${account.bxtime }" pattern="yyyy-MM-dd"/></td>
                                        <td>${account.bxremark }</td>
                                        <td>${account.result }</td>
                                        <td>
                                        	<c:if test="${account.bxstatus==0 }"><font color="red">驳回</font></c:if>
                                        	<c:if test="${account.bxstatus==1 }">待审批</c:if>
                                        	<c:if test="${account.bxstatus==2 }">未支付</c:if>
                                        	<c:if test="${account.bxstatus==3 }">已支付</c:if>
                                        </td>
                                        <td>
                                        	<a href="${pageContext.request.contextPath}/account/show?id=${account.bxid }&pageNum=${page.pageNum }">查看</a>
                                        	<c:if test="${account.bxstatus!=3 }">
	                                        	<a href="${pageContext.request.contextPath}/account/toupdate?id=${account.bxid }">编辑</a>
	                                        	<a id="${account.bxid }" href="javascript:void(0)" class="btndel">撤销</a>
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
	                                 <a <c:if test="${page.pageNum-1>=1 }"> href="${pageContext.request.contextPath}/account/mylist?pageNum=${page.pageNum-1 }&key=${key }&status=${status }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum-1<1 }">disabled="disabled"</c:if>><i class="glyphicon glyphicon-chevron-left"></i>
	                                </a>
	                                <c:forEach begin="1" end="${page.pages }" varStatus="index">
	                                <a href="${pageContext.request.contextPath}/account/mylist?pageNum=${index.index }&key=${key }&status=${status }" class="btn btn-sm btn-white" <c:if test="${page.pageNum==index.index }">active</c:if>>${index.index }</a>
	                                </c:forEach>
	                                <a <c:if test="${page.pageNum+1<=page.pages }">href="${pageContext.request.contextPath}/account/mylist?pageNum=${page.pageNum+1}&key=${key }&status=${status }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum+1>page.pages }">disabled="disabled"</c:if> ><i class="glyphicon glyphicon-chevron-right"></i></a>
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
		
		//点击删除
		$('.btndel').click(function () {
			var id =$(this).prop("id");
		    swal({
		        title: "您确定要撤销该报销吗",
		        text: "撤销后将无法恢复，请谨慎操作！",
		        type: "warning",
		        showCancelButton: true,
		        confirmButtonColor: "#DD6B55",
		        confirmButtonText: "yes",
		        closeOnConfirm: false
		    }, function () {
		    	$.post("${pageContext.request.contextPath}/account/remove",{"id":id},function(result){
		    		if(result=="true"){
		    			swal({
		    				title: "撤销成功",
		    				text: "撤销成功，恭喜恭喜",
		    				type: "success"
		    			},function(){
		    				location.href="${pageContext.request.contextPath}/account/mylist";
		    			});
		    		}else{
		    			 swal("撤销失败！", "请稍后再试。", "warning");
		    		}
		    	},"text")
			   
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
