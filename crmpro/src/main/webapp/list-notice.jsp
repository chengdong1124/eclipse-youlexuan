<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from www.gzsxt.cn/theme/hplus/mailbox.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:21 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>项目管理系统 - 收件箱</title>
    <meta name="keywords" content="项目管理系统">
    <meta name="description" content="项目管理系统">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="${pageContext.request.contextPath}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-3">
                <div class="ibox float-e-margins">
                    <div class="ibox-content mailbox-content">
                        <div class="file-manager">
                            <a class="btn btn-block btn-primary compose-mail" href="save-message.jsp"><i class="fa fa-paper-plane"></i>&nbsp;&nbsp;写信</a>
                            <div class="space-25"></div>
                            <h5>文件夹</h5>
                            <ul class="folder-list m-b-md" style="padding: 0">
                                <li>
                                    <a href="mailbox.jsp"> <i class="fa fa-inbox "></i> 收件箱 <span class="label label-warning pull-right">${noread }</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="mailbox.jsp"> <i class="fa fa-envelope-o"></i>发件箱</a>
                                </li>
                                <li>
                                    <a href="mailbox.jsp"> <i class="fa fa-certificate"></i> 重要</a>
                                </li>
                                <li>
                                    <a href="mailbox.jsp"> <i class="fa fa-file-text-o"></i> 草稿 <span class="label label-danger pull-right">${draft }</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="mailbox.jsp"> <i class="fa fa-trash-o"></i> 垃圾箱<span class="label label-danger pull-right">${rubbish }</span></a>
                                </li>
                            </ul>
                            <h5>分类</h5>
                            <ul class="category-list" style="padding: 0">
                             	<li>
                                    <a href="${pageContext.request.contextPath}/notice/list"> <i class="fa fa-circle text-danger"></i> 公告通知</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/message/list?type=0"> <i class="fa fa-circle text-navy"></i> 工作</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/message/list?type=1"> <i class="fa fa-circle text-primary"></i> 社交</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/message/list?type=2"></i> 文件</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/message/list?type=3"> <i class="fa fa-circle text-warning"></i> 重要</a>
                                </li>
                            </ul>

                            
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-9 animated fadeInRight">
                <div class="mail-box-header">

                    <form method="get" action="http://www.gzsxt.cn/theme/hplus/index.jsp" class="pull-right mail-search">
                        <div class="input-group">
                            <input type="text" class="form-control input-sm" name="search" placeholder="搜索标题">
                            <div class="input-group-btn">
                                <button type="submit" class="btn btn-sm btn-primary">
                                    <i class="fa fa-search"></i> 搜索
                                </button>
                            </div>
                        </div>
                    </form>
                    <h2>
                    收件箱 (16)
                </h2>
                    <div class="mail-tools tooltip-demo m-t-md">
                        <div class="btn-group pull-right">
                            <button class="btn btn-white btn-sm"><i class="fa fa-arrow-left"></i>
                            </button>
                            <button class="btn btn-white btn-sm"><i class="fa fa-arrow-right"></i>
                            </button>

                        </div>
                        <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" title="刷新邮件列表"><i class="fa fa-refresh"></i> 刷新</button>
                        <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="标为已读"><i class="fa fa-eye"></i>
                        </button>
                        <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="标为重要"><i class="fa fa-exclamation"></i>
                        </button>
                        <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="标为垃圾邮件"><i class="fa fa-trash-o"></i>
                        </button>

                    </div>
                </div>
                <div class="mail-box">

                    <table class="table table-hover table-mail">
                        <tbody>
                        <c:forEach items="${list }" var="notice">
                            <tr class="unread">
                                <td class="check-mail">
                                    <input type="checkbox" >
                                </td>
                                <td class="mail-ontact"><a href="${pageContext.request.contextPath}/notice/show?id=${notice.nid }">${notice.title }</a>
                                </td>
                                <td class="mail-subject"><a href="${pageContext.request.contextPath}/notice/show?id=${notice.nid }">
                                	<c:if test="${notice.remark.length()>20 }">
	                   						${notice.remark.substring(0,20).replaceAll("<p>","").replaceAll("</p>","") }...
	                   				</c:if>
	                   				<c:if test="${notice.remark.length()<=20 }">
	                   						${notice.remark.replaceAll("<p>","").replaceAll("</p>","") }
	                   				</c:if>
                               		</a>
                                </td>
                                
                                <td class="">
                                	<c:if test="${notice.path != null and notice.path != '' }">
                                		<i class="fa fa-paperclip"></i>
                                	</c:if>
                                </td>
                                
                                <td class="text-right mail-date">
                                <fmt:formatDate value="${notice.date }" pattern="yyyy/MM/dd HH:mm"/>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/js/content.min.js?v=1.0.0"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>


<!-- Mirrored from www.gzsxt.cn/theme/hplus/mailbox.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:22 GMT -->
</html>
