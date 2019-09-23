 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from www.gzsxt.cn/theme/hplus/article.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:47 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>绿地中央广场综合物业办公系统 - 文章页面</title>
    <meta name="keywords" content="绿地中央广场综合物业办公系统">
    <meta name="description" content="绿地中央广场综合物业办公系统">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/pinglun.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight article">
        <div class="row">
            <div class="col-lg-10 col-lg-offset-1">
                <div class="ibox">
                    <div class="ibox-content">
                    		<div class="pull-right">
                            <a href="javascript:history.back()" class="btn btn-white btn-sm" ><i class="fa fa-reply"></i>  返回</a>
                            <%-- <a href="${pageContext.request.contextPath}/forumpost/list?forumsort_kf=${forumpost.forumsortFk }" class="btn btn-white btn-sm" ><i class="fa fa-reply"></i>  返回</a> --%>
                        </div>
                        <div class="text-center  article-title">
                            <h2><strong>${notice.title }</strong></h2>
                            <p><fmt:formatDate value="${notice.date }" pattern="yyyy/MM/dd"/></p>
                        </div>
                        <div id="">
                      		${notice.remark }
                        </div>
                        <hr>
                        <div id="">
                      		附件:<a href="/upload/${notice.path }">下载</a>		<!-- 神奇的东方茶叶 -->
                        </div>
                        <hr>
                        <div class="row text-center">
                        <a href="javascript:history.back()" class="btn btn-white btn-sm" ><i class="fa fa-reply"></i> 返回</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/js/content.min.js?v=1.0.0"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript">
	
	//点击小图片，显示表情
	$(".bq").click(function (e) {
		$(".face").slideDown(); //慢慢向下展开
		e.stopPropagation(); //阻止冒泡事件
	});

	//在桌面任意地方点击，关闭表情框
	$(document).click(function () {
		$(".face").slideUp(); //慢慢向上收
	});

	//点击小图标时，添加功能
	$(".face ul li").click(function () {
		var simg = $(this).find("img").clone();
		$(".message").append(simg); //将表情添加到输入框
	});

	//点击发表按扭，发表内容
	$("span.submit").click(function () {
		var forumFk = ${forumpost.forumid };
		var txt = $(".message").html(); //获取输入框内容,注意这里是html哦
		if (!txt) {
			$('.message').focus(); //自动获取焦点
			return;
		}
		$('.message').html('') // 清空输入框

		$.post("${pageContext.request.contextPath}/evaluate/save",{"evacontent":txt,"forumFk":forumFk},function(result){
			if(result){
				if(result=="true"){
					swal({
				        title: "添加成功",
				        text: "添加成功，恭喜你",
				        type: "success"
				    });
					addEvaluate(txt);
				}else{
					swal({
				        title: "添加失败",
				        text: "添加失败，这下没救了",
				        type: "warning"
				    });
				}
			}
		},"text");
	});

	function addEvaluate(txt){
		var name = "${LOGIN.ename}";	//因为${LOGIN.ename}为字符串
		var time=new Date().format("yyyy-MM-dd hh:mm:ss");
		var content = `<div class="social-feed-box">
        <div class="social-avatar">
            <a href="#" class="pull-left">
                <img alt="image" src="${pageContext.request.contextPath}/img/a1.jpg">
            </a>
            <div class="media-body">
            <div>
                <a href="#">`+name+`</a>
            </div>
                <small class="text-muted">`+time+`</small>
            </div>
        </div>
        <div class="social-body">
            <p>
            	`+txt+`
            </p>
        </div>
    </div>`;
		$(".setContent").after(content);  //这个after的用法    //望山不灭，万界永存
	}
	
	Date.prototype.format = function(fmt) { 
	     var o = { 
	        "M+" : this.getMonth()+1,                 //月份 
	        "d+" : this.getDate(),                    //日 
	        "h+" : this.getHours(),                   //小时 
	        "m+" : this.getMinutes(),                 //分 
	        "s+" : this.getSeconds(),                 //秒 
	        "q+" : Math.floor((this.getMonth()+3)/3), //季度 
	        "S"  : this.getMilliseconds()             //毫秒 
	    }; 
	    if(/(y+)/.test(fmt)) {
	            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	    }
	     for(var k in o) {
	        if(new RegExp("("+ k +")").test(fmt)){
	             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
	         }
	     }
	    return fmt; 
	}

	$(".btnDel").click(function(){
		var id = $(this).prop("id");
		var $this = $(this);
		$.post("${pageContext.request.contextPath}/evaluate/remove",{"id":id},function(result){
			if(result=="true"){
				swal({
			        title: "删除成功",
			        text: "删除成功，恭喜你",
			        type: "success"
			    });
				$this.parents(".social-feed-box").remove();
				
			}else{
				swal({
			        title: "删除失败",
			        text: "删除失败，南无发了",
			        type: "warning"
			    });
			}
		},"text");
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</script>
</body>


<!-- Mirrored from www.gzsxt.cn/theme/hplus/article.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:47 GMT -->
</html>
