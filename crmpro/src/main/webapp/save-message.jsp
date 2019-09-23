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
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/select/bootstrap-select.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/customer.css" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        
      <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>消息推送<small>>发送消息</small></h5>
                    </div>
                    <div class="ibox-content">
                        <form id="addform" method="get" action="#" class="form-horizontal">
                        <input type="hidden" name="status" value="1">
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">收件人</label>
                                <div class="col-sm-4">
                                    <select id="receive" name="receive" class="selectpicker form-control">
										<option>--选择收件人--</option>
									</select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">标题</label>
                                <div class="col-sm-9">
                                    <input name="title" type="text" class="form-control" >
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">内容</label>
                                <div class="col-sm-9">
                                <input id="content" type="hidden" name="content" />
                                    <script id="editor" type="text/plain"></script>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group">
	                                <div id="file-pretty">
	                                <label class="col-sm-2 control-label">附件</label>
	                                <div class="col-sm-4">
	                                		<!---->
	                                		<input name="myfiles" type="file" class="form-control" >
	                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">标签</label>
                                <div class="col-sm-9 tips">
                                    <input  name="type" type="radio" value="0" checked="checked">工作
                                    <input  name="type" type="radio" value="1">社交
                                    <input  name="type" type="radio" value="2">文件
                                    <input  name="type" type="radio" value="3">重要
                                </div>
                            </div>
                        </div>
                     	<div class="row">
                     		<div class="hr-line-dashed"></div>
                     	</div>
                          
                         <div class="row">
                            <div class="form-group">
                                <div class="col-sm-11 text-right">
                                    <button type="button" id="btnSend" class="btn btn-primary btnSave"><i class="fa fa-paper-plane"></i> 发送</button>
                                    <a href="list-message.jsp" class="btn btn-white"><i class="fa fa-times"></i> 放弃</a>
                                		<a href="list-message.jsp" class="btn btn-white"><i class="fa fa-pencil"></i> 存为草稿</a>
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
	<script src="${pageContext.request.contextPath}/js/plugins/prettyfile/bootstrap-prettyfile.js"></script>
	<script src="${pageContext.request.contextPath}/js/inputfile.js"></script>
	
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
   <script>
	$(document).ready(function() {
		//实例化编辑器
		var ue = UE.getEditor('editor');
		// 设置按钮的样式
		$('.selectpicker').selectpicker('setStyle', 'btn-white');
		
		$("#btnSend").click(function(){
			var txt = ue.getContent();
			$("#content").val(txt);
			$.ajax({ 
				url: "${pageContext.request.contextPath}/message/save", 
				type: "POST",
				dataType:"text",
				cache: false, 
				data: new FormData($("#addform")[0]), //获取到class为addform的数组，然后取第一个
				processData: false, 
				contentType: false, 
				success: function (result) {
					if(result=="true"){
						swal({
							title: "恭喜，发布成功",
							text: "发布成功",
							type: "success"
						});
						$("#addform")[0].reset();
						ue.setContent("");//清空编辑器
					}else{
						swal("发布失败","请稍后再试","warning");
					}
				}
			});
		});

		function loadEmployee(){
			$.post("${pageContext.request.contextPath}/employee/listall",function(result){
				$(result).each(function(){
				    var $option=$("<option value='"+this.eid+"'>"+this.ename+"</option>")
					$("#receive").append($option).selectpicker('refresh');
				});
			},"json");
		}
		loadEmployee();

	});
	
   </script>
   <style>
   	.edui-box{ width: 30px; height: 30px;}
   	
   </style>
</body>


</html>
