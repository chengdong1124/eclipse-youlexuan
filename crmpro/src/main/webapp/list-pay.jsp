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
    <link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/select/bootstrap-select.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper2 wrapper-content2 animated fadeInRight">
    <div class="ibox float-e-margins">
                  <form action="${pageContext.request.contextPath}/account/list" method="post">
    	<input type="hidden" name="status" value="2"/>
                   <div class="ibox-content">
                        <div class="row">
                        		<div class="col-sm-3 col-sm-offset-4 text-right">
                        			<h3><small>搜索条件:</small></h3>
                        		</div>
                            <div class="col-sm-2">
                                <select name="type" class="selectpicker form-control">
                                    <option  <c:if test="${type==0 }">selected="selected"</c:if> value="0">选择类型</option>
                                    <option  <c:if test="${type==1 }">selected="selected"</c:if> value="1">报销单号</option>
                                    <option  <c:if test="${type==2 }">selected="selected"</c:if> value="2">报销人员</option>
                                </select>
                            </div>
                           
                            <div class="col-sm-3">
                                <div class="input-group">
                                    <input value="${key }" name="key" type="text" placeholder="请输入关键词" class="input-sm form-control">
                                    <span class="input-group-btn">
                                        <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-search"></i> 搜索</button>
                                    </span>
                                </div>
                            </div>
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
                                        <td>未付款</td>
                                        <td>
	                                        	<button data-bxid="${account.bxid }" type="button" class="btndel btn btn-danger btn-xs btnUpdate">付款</button>
                                        </td>
                                    </tr>
                                </c:forEach>    
                                </tbody>
                            </table>
                        </div>
                       
                        <div class="row">
	                        
							<div class="col-sm-12 text-right">
								<div class="btn-group">
	                                <a <c:if test="${page.pageNum-1>=1 }"> href="${pageContext.request.contextPath}/analysis/list?pageNum=${page.pageNum-1 }&key=${key }&type=${type }&status=2"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum-1<1 }">disabled="disabled"</c:if>><i class="glyphicon glyphicon-chevron-left"></i>
	                                </a>
	                                <c:forEach begin="1" end="${page.pages }" varStatus="index">
	                                <a href="${pageContext.request.contextPath}/analysis/list?pageNum=${index.index }&key=${key }&type=${type }&status=2" class="btn btn-sm btn-white" <c:if test="${page.pageNum==index.index }">active</c:if>>${index.index }</a>
	                                </c:forEach>
	                                <a <c:if test="${page.pageNum+1<=page.pages }">href="${pageContext.request.contextPath}/analysis/list?pageNum=${page.pageNum+1}&key=${key }&type=${type }&status=2"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum+1>page.pages }">disabled="disabled"</c:if> ><i class="glyphicon glyphicon-chevron-right"></i></a>
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
		
		$(".btndel").click(function(){
			var bxid = $(this).data("bxid");
			$.post("${pageContext.request.contextPath}/account/updatestatus",{"bxid":bxid,"bxstatus":3},function(result){
				if(result=="true"){
					 swal({
					        title: "付款成功",
					        text: "付款成功，恭喜恭喜",
					        type: "success"
					    }, function () {
						    location.href="${pageContext.request.contextPath}/account/list?status=2";
					    });
				}else{
					swal("付款失败","付款失败，请稍后再试!","warning");
				}
			},"text");
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//点击删除
		$('.btndel').click(function () {
		    swal({
		        title: "您确定已经打款了吗？",
		        text: "确定后将无法恢复，请谨慎操作！",
		        type: "warning",
		        showCancelButton: true,
		        confirmButtonColor: "#1ab394",
		        confirmButtonText: "已打款",
		        closeOnConfirm: false
		    }, function () {//此函数是点击删除执行的函数
		    		//这里写ajax代码
		    		// 以下是成功的提示框，请在ajax回调函数中执行
			    swal("付款成功！", "您已经成功对此条报销记录完成付款。", "success");
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
