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
                            <h2><strong>${forumpost.forumtitle }</strong></h2>
                        </div>
                        <div id="">
                      		${forumpost.forumcontent }
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-lg-12">

                                <h2>评论：</h2>
                                <div class="social-feed-box setContent">
                                    <div id="qq">
										<p>发表你的看法</p>
										<div class="message" contentEditable='true'>
											请输入评论
										</div>
										
										<div class="But">
											<img src="${pageContext.request.contextPath}/img/emj/bba_thumb.gif" class='bq' />
											<span class='submit'>发表</span>
											<!--face begin-->
											<div class="face">
												<ul>
													<li><img src="${pageContext.request.contextPath}/img/emj/smilea_thumb.gif" title="[呵呵]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/tootha_thumb.gif" title="[嘻嘻]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/laugh.gif" title="[哈哈]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/tza_thumb.gif" title="[可爱]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/kl_thumb.gif" title="[可怜]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/kbsa_thumb.gif" title="[挖鼻屎]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/cj_thumb.gif" title="[吃惊]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/shamea_thumb.gif" title="[害羞]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/zy_thumb.gif" title="[挤眼]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/bz_thumb.gif" title="[闭嘴]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/bs2_thumb.gif" title="[鄙视]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/lovea_thumb.gif" title="[爱你]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/sada_thumb.gif" title="[泪]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/heia_thumb.gif" title="[偷笑]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/qq_thumb.gif" title="[亲亲]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/sb_thumb.gif" title="[生病]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/mb_thumb.gif" title="[太开心]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/ldln_thumb.gif" title="[懒得理你]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/yhh_thumb.gif" title="[右哼哼]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/zhh_thumb.gif" title="[左哼哼]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/x_thumb.gif" title="[嘘]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/cry.gif" title="[衰]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/wq_thumb.gif" title="[委屈]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/t_thumb.gif" title="[吐]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/k_thumb.gif" title="[打哈气]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/bba_thumb.gif" title="[抱抱]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/angrya_thumb.gif" title="[怒]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/yw_thumb.gif" title="[疑问]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/cza_thumb.gif" title="[馋嘴]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/88_thumb.gif" title="[拜拜]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/sk_thumb.gif" title="[思考]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/sweata_thumb.gif" title="[汗]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/sleepya_thumb.gif" title="[困]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/sleepa_thumb.gif" title="[睡觉]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/money_thumb.gif" title="[钱]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/sw_thumb.gif" title="[失望]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/cool_thumb.gif" title="[酷]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/hsa_thumb.gif" title="[花心]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/hatea_thumb.gif" title="[哼]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/gza_thumb.gif" title="[鼓掌]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/dizzya_thumb.gif" title="[晕]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/bs_thumb.gif" title="[悲伤]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/crazya_thumb.gif" title="[抓狂]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/h_thumb.gif" title="[黑线]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/yx_thumb.gif" title="[阴险]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/nm_thumb.gif" title="[怒骂]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/hearta_thumb.gif" title="[心]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/unheart.gif" title="[伤心]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/pig.gif" title="[猪头]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/ok_thumb.gif" title="[ok]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/ye_thumb.gif" title="[耶]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/good_thumb.gif" title="[good]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/no_thumb.gif" title="[不要]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/z2_thumb.gif" title="[赞]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/come_thumb.gif" title="[来]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/sad_thumb.gif" title="[弱]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/lazu_thumb.gif" title="[蜡烛]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/clock_thumb.gif" title="[钟]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/cake.gif" title="[蛋糕]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/m_thumb.gif" title="[话筒]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/weijin_thumb.gif" title="[围脖]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/lxhzhuanfa_thumb.gif" title="[转发]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/lxhluguo_thumb.gif" title="[路过这儿]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/bofubianlian_thumb.gif" title="[bofu变脸]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/gbzkun_thumb.gif" title="[gbz困]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/boboshengmenqi_thumb.gif" title="[生闷气]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/chn_buyaoya_thumb.gif" title="[不要啊]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/daxiongleibenxiong_thumb.gif" title="[dx泪奔]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/cat_yunqizhong_thumb.gif" title="[运气中]"></li>
													<li><img src="${pageContext.request.contextPath}/img/emj/youqian_thumb.gif" title="[有钱]"></li>
												</ul>
											</div>
											<!--face end-->
										</div>
									</div>
                                </div>
                                
                                <!-- foreach这个加载到前台html的时候不会显示出来的 -->
                                <c:forEach items="${list }" var="evaluate"> 
                                <div class="social-feed-box">
                                    <div class="social-avatar">
                                        <a href="#" class="pull-left">
                                            <img alt="image" src="${pageContext.request.contextPath}/img/a1.jpg">
                                        </a>
                                        <div class="media-body">
                                        <div>
                                        <c:if test="${LOGIN.eid==evaluate.empFk4 }">    <!-- 这里很有特点，直接从session中拿登录用户 -->
                                        	<span id="${evaluate.evaid }" class="btnDel" style="float:right"><i class="fa fa-trash-o"></i></span>
                                        </c:if>    
                                            <a href="#">
                                            	${evaluate.employee.ename }
                                            </a>
                                        </div>
                                            <small class="text-muted"> <fmt:formatDate value="${evaluate.evatime }" pattern="yyyy-MM-dd HH:mm:ss"/></small>
                                        </div>
                                    </div>
                                    <div class="social-body">
                                        <p>
                                        	${evaluate.evacontent }
                                        </p>
                                    </div>
                                </div>
                                </c:forEach>
                        <hr/> 
                        <div class="row text-center">
                        <a href="list-forum.html" class="btn btn-white btn-sm" ><i class="fa fa-reply"></i> 返回</a>
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

	//点击发表按扭,发表内容
	$("span.submit").click(function () {
		var forumFk = ${forumpost.forumid };//看到没可以直接这么拿哦。
		var txt = $(".message").html(); //获取输入框内容,注意这里是html哦 ，因为这里是span标签
		
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
		$(".setContent").after(content);  														//这个after的用法  //望山不灭，万界永存
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
