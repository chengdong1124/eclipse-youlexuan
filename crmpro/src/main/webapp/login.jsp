<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
	<title>Home</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content="" />
	
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	
	<link href="${pageContext.request.contextPath}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginstyle.css" type="text/css" media="all" />
	<link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/js/plugins/sweetalert/sweetalert.min.js"></script>
</head>

<body>
	<!-- bg effect -->
	<div id="bg">
		<canvas></canvas>
		<canvas></canvas>
		<canvas></canvas>
	</div>
	
	<!-- content -->
	<div class="sub-main-w3">
		<form id="loginform" action="#" method="post">
			<h2>欢迎登录项目管理系统
				<i class="fa fa-level-down"></i>
			</h2>
			 <div class="row">
                <div class="form-group">
                    <label class="col-sm-4 control-label text-right">用户名<i class="fa fa-user"></i></label>
                    <div class="col-sm-6">
                        <input name="username" type="text" class="form-control input-sm">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label class="col-sm-4 control-label text-right">密码<i class="fa fa-unlock-alt"></i></label>
                    <div class="col-sm-6">
                        <input name="password" type="password" class="form-control input-sm">
                    </div>
                </div>
            </div>
			<div class="row">
                <div class="form-group">
                    <label class="col-sm-4 control-label text-right">验证码<i class="fa fa-picture-o"></i></label>
                    <div class="col-sm-3">
                        <input name="code" type="text" class="form-control input-sm">
                    </div>
                    <div class="col-sm-3 text-right">
                        <img id="img" src="${pageContext.request.contextPath}/logincode.jpg" class="logincode" onclick="document.getElementById('img').src='logincode.jpg?'+new Date().getTime();" />
                    </div>
                </div>
            </div>
			<button id="btnLogin" type="button"><i class="fa fa-send"></i> 登 录</button>
			
		</form>
	</div>

	<div class="footer">
		<p>Copyright &copy; 2018.项目理管系统 All rights reserved.</p>
	</div>

	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/js/canva_moving_effect.js"></script>
	
	
	<script>	
		$("#btnLogin").click(function(){
			//alert("${pageContext.request.contextPath}");  这里是crmpro
			
			var data = $("#loginform").serialize();
			
			$.post("${pageContext.request.contextPath}/employee/login",data,function(result){
				if(result=="true"){
					 location.href="${pageContext.request.contextPath}/index.jsp";
				}else if(result=="error"){
					 swal({
					        title: "登录失败",
					        text: "验证码不正确",
					        type: "warning",
					    });
				}else{
					 swal({
					        title: "登录失败",
					        text: "用户名或者密码不正确",
					        type: "warning",
					    });
				}
			},"text");
		});
	
	
	</script>

</body>

</html>