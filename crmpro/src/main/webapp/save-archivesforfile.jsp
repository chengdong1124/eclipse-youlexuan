 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/select/bootstrap-select.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
	
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        
      <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>档案管理<small>>档案基本信息</small></h5>
                    </div>
                    <div class="ibox-content">
                    
                    	<!-- 发现没有，用ajax的话method是get或者post并不重要，且不用设置encitype -->
                        <form id="addform" method="get" action="#" class="form-horizontal">
                        <div class="row">
                            <div class="form-group">
	                                <div id="file-pretty">
	                                <label class="col-sm-3 control-label">采集信息附件</label>
	                                <div class="col-sm-4">
	                                		<!---->
	                                		<input name="myfiles" type="file" class="form-control" >
	                                </div>
                                </div>
                            </div>
                        </div>
                     	<div class="row">
                     		<div class="hr-line-dashed"></div>
                     	</div>
                          
                        <div class="row">
                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-3 text-right">
                                    <button type="button" class="btn btn-primary btnSave"><i class="fa fa-save"></i> 保存内容</button>
                                </div>
                                <div class="col-sm-3">
                                	<a href="list-benchmarking.jsp" class="btn btn-white"><i class="fa fa-reply"></i> 返回</a>
                                	</div>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

 
    
    
    <script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/sweetalert/sweetalert.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins/select/bootstrap-select.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/inputfile.js"></script>
	
   <script>
	$(document).ready(function() {
		// 设置按钮的样式
		$('.selectpicker').selectpicker('setStyle', 'btn-white');
		
			$(".btnSave").click(function(){
				$.ajax({ 
					url: "${pageContext.request.contextPath}/archives/saveall", 
					type: "POST",
					dataType:"text",
					cache: false, 
					data: new FormData($("#addform")[0]), //获取到class为addform的数组，然后取第一个
					processData: false, 
					contentType: false, 
					success: function (result) {
						if(result=="true"){
							swal({
								title:"全部添加成功",
								text:"全部添加成功，为您返回列表页",
								type:"success"
							},function(){
								location.href="${pageContext.request.contextPath}/archives/list";
							});
						}else if(result=="false"){
							swal("全部添加失败","不存在该名字的员工","error");
						}else if(result=="nofile"){
							swal("没有选择文件","请选择excel文件","error");
						}else{//部分添加失败
							swal({
								title:"部分添加成功",
								text:result+"不是本公司员工，添加失败",
								type:"success"
							});
						}
					}
				});
			});
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	});	
   </script>
</body>


</html>
