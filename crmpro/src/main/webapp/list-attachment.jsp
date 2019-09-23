<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from www.gzsxt.cn/theme/hplus/file_manager.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>项目管理系统 -文件管理器</title>
    <meta name="keywords" content="项目管理系统">
    <meta name="description" content="项目管理系统">

    <link rel="shortcut icon" href="favicon.ico"> 
    	<link href="${pageContext.request.contextPath}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/customer.css" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <div class="file-manager">
                        	<!-- 1 表示图片,2 表示文档,3 表示视频,4 表示种子,5 表示音乐,6 表示其它 -->	
                            <h5>显示：</h5>
                            <a href="${pageContext.request.contextPath}/attachment/list">所有</a>
                            <a href="${pageContext.request.contextPath}/attachment/listbytype?type=2">文档</a>
                            <a href="${pageContext.request.contextPath}/attachment/listbytype?type=3">视频</a>
                            <a href="${pageContext.request.contextPath}/attachment/listbytype?type=1">图片</a>
                            <div class="hr-line-dashed"></div>
                            <a href="${pageContext.request.contextPath}/save-attachment.jsp" class="btn btn-primary btn-block"><i class="fa fa-cloud-upload"></i> 上传文件</a>
                            <div class="hr-line-dashed"></div>
                            <div class="input-group">
                            	<form action="${pageContext.request.contextPath}/attachment/list" method="post">
                                <input name="key" type="text" value="${key }" class="form-control">
                                <span class="input-group-btn">
                                	 <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i>搜索</button> 
                                </span>
                            	</form>   
                            </div>
                            
                            <h5 class="tag-title">标签</h5>
                            <ul class="tag-list" style="padding: 0">
                                <li><a href="${pageContext.request.contextPath}/attachment/list?key=爱人">爱人</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/attachment/list?key=工作">工作</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/attachment/list?key=家庭">家庭</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/attachment/list?key=孩子">孩子</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/attachment/list?key=假期">假期</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/attachment/list?key=音乐">音乐</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/attachment/list?key=照片">照片</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/attachment/list?key=电影">电影</a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-9 animated fadeInRight">
                <div class="row">
                    <div class="col-sm-12">
                    <c:forEach items="${list }" var="attachment">
                        <div class="file-box">
                            <div class="file">
                                <a href="${pageContext.request.contextPath}/attachment/show?id=${attachment.id }">
                                    <span class="corner"></span>
                                    <div class="icon">
                                    	<!-- 1 表示图片,2 表示文档,3 表示视频,4 表示种子,5 表示音乐,6 表示其它 -->
                                        <c:if test="${attachment.type==1 }"><i class="fa fa-picture-o"></i></c:if>
                                        <c:if test="${attachment.type==2 }"><i class="fa fa-file-word-o"></i></c:if>
                                        <c:if test="${attachment.type==3 }"><i class="fa fa-film"></i></c:if>
                                        <c:if test="${attachment.type==4 }"><i class="fa fa-download"></i></c:if>
                                        <c:if test="${attachment.type==5 }"><i class="fa fa-music"></i></c:if>
                                        <c:if test="${attachment.type==6 }"><i class="fa fa-file"></i></c:if>
                                    </div>
                                    <div class="file-name">
                                        ${attachment.attname }
                                        <br/>
                                        <small>${attachment.project.pname }</small>
                                    </div>
                                </a>
                            </div>

                        </div>
                    </c:forEach> 
                        
                </div>
               
            		<!--分页-->
            		<div class="row">
            			<div class="col-sm-10 text-right">
						<div class="btn-group">
                         <a <c:if test="${page.pageNum-1>=1 }"> href="${pageContext.request.contextPath}/attachment/list?pageNum=${page.pageNum-1 }&key=${key }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum-1<1 }">disabled="disabled"</c:if>><i class="glyphicon glyphicon-chevron-left"></i>
	                     </a>
	                                
	                     <c:forEach begin="1" end="${page.pages }" varStatus="index">
	                     <a href="${pageContext.request.contextPath}/attachment/list?pageNum=${index.index }&key=${key }" class="btn btn-sm btn-white" <c:if test="${page.pageNum==index.index }">active</c:if>>${index.index }</a>
	                     </c:forEach>
	                                
	                     <a <c:if test="${page.pageNum+1<=page.pages }">href="${pageContext.request.contextPath}/attachment/list?pageNum=${page.pageNum+1}&key=${key }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum+1>page.pages }">disabled="disabled"</c:if> ><i class="glyphicon glyphicon-chevron-right"></i></a>
                       	 </a>
                        </div>
					</div>
            		</div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/js/content.min.js?v=1.0.0"></script>
    <script>$(document).ready(function() {
	$(".file-box").each(function() {
		animationHover(this, "pulse")
	})
});</script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>



</html>
