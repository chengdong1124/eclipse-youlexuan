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
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">
    	<div class="row">
    	<c:forEach items="${list }" var="forumpost">
    		<div class="col-sm-6">
	    		<div class="ibox">
	            <div class="ibox-content">
	                <a href="${pageContext.request.contextPath}/forumpost/show?id=${forumpost.forumid }" class="btn-link">
	                    <h3>${forumpost.forumtitle }</h3>
	                </a>
	                <div class="small m-b-xs">
	                    <strong>${forumpost.employee.ename }</strong> <span class="text-muted"><i class="fa fa-clock-o"></i><fmt:formatDate value="${forumpost.createtime }" pattern="yyyy/MM/dd"/></span>
	                </div>
	                <p>
	                   <c:if test="${forumpost.forumcontent.length()>90 }">
	                   		${forumpost.forumcontent.substring(0,70).replaceAll("<p>","").replaceAll("</p>","") }...
	                   </c:if>
	                   <c:if test="${forumpost.forumcontent.length()<=90 }">
	                   		${forumpost.forumcontent.replaceAll("<p>","").replaceAll("</p>","") }
	                   </c:if>
	                </p>
	                <div class="row">
	                    <div class="col-md-6">
	                        <h5>标签：</h5>
	                        <c:if test="${forumpost.label.contains('1') }"><button class="btn btn-white btn-xs" type="button">文件</button></c:if>
	                        <c:if test="${forumpost.label.contains('2') }"><button class="btn btn-white btn-xs" type="button">资源</button></c:if>
	                        <c:if test="${forumpost.label.contains('3') }"><button class="btn btn-white btn-xs" type="button">分享</button></c:if>
	                        <c:if test="${forumpost.label.contains('4') }"><button class="btn btn-white btn-xs" type="button">技术</button></c:if>
	                        <c:if test="${forumpost.label.contains('5') }"><button class="btn btn-white btn-xs" type="button">问答</button></c:if>
	                        <c:if test="${forumpost.label.contains('6') }"><button class="btn btn-white btn-xs" type="button">讨论</button></c:if>
	                        <c:if test="${forumpost.label.contains('7') }"><button class="btn btn-white btn-xs" type="button">其他</button></c:if>
	                    </div>
	                    <div class="col-md-6">
	                        <div class="small text-right">
	                            <h5>状态：${forumpost.status }</h5>
	                            <div> <i class="fa fa-comments-o"> </i>${forumpost.commentCount }评论</div>
	                            <i class="fa fa-eye"> </i> ${forumpost.click }浏览
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
        </div>
        </c:forEach>
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
