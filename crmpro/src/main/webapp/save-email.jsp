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
	<link href="${pageContext.request.contextPath}/css/customer.css" rel="stylesheet">
	
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        
      <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>信箱<small>>发送邮件</small></h5>
                    </div>
                    <div class="ibox-content">
                        <form id="addform" method="get" action="#" class="form-horizontal">
                       	
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">收件人</label>
                                <div class="col-sm-4">
                                    <select id="sendto" name="sendto" class="selectpicker form-control">
										<option>--选择收件人--</option>
									</select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">主题</label>
                                <div class="col-sm-9">
                                    <input name="title" type="text" class="form-control" >
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">内容</label>
                                <div class="col-sm-9">
                                <input type="hidden" name="content" id="content"/>
                                    <script id="editor" type="text/plain"></script>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">定时发送</label>
                                <div class="col-sm-1 text-left tips">
                                	<input name="isTime" type="checkbox" />
                                </div>
                                <label class="col-sm-1 control-label">时间</label>
                                <div class="col-sm-4">
                                    <input name="time" class="form-control layer-date" placeholder="YYYY-MM-DD hh:mm:ss" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
                                    <label class="laydate-icon"></label>
                                </div>
                            </div>
                        </div>
                        
                     	<div class="row">
                     		<div class="hr-line-dashed"></div>
                     	</div>
                          
                         <div class="row">
                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-3 text-right">
                                    <button type="button" class="btn btn-primary btnSave"><i class="fa fa-paper-plane"></i> 发送</button>
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
	<script src="${pageContext.request.contextPath}/js/plugins/layer/laydate/laydate.js"></script>
	
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
   <script>
	$(document).ready(function() {
		
		//实例化编辑器
		var ue = UE.getEditor('editor');
		// 设置按钮的样式
		$('.selectpicker').selectpicker('setStyle', 'btn-white');
		
		
		
		function loadEmployee(){
			$.post("${pageContext.request.contextPath}/employee/listall",function(result){
				$(result).each(function(){
				    var $option=$("<option value='"+this.eid+"'>"+this.ename+"</option>")
					$("#sendto").append($option).selectpicker('refresh');
				});
			},"json");
		}
		loadEmployee();
		
		
		$(".btnSave").click(function(){
			var txt = ue.getContent();
			$("#content").val(txt);
			var data = $("#addform").serialize();
			$.post("${pageContext.request.contextPath}/email/send",data,function(result){
				if(result=="true"){
					swal("发送成功","恭喜你，邮件发送成功","success");
				}else{
					swal("发送失败","失败，邮件发送失败","warning");
				}
			},"text");
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		//下拉列表使用ajax加载说明例子
		function loadSelect(){
			var option='<option value="0">-------请选择------</option><option value="4">用友软件</option><option selected value="5">浪潮软件</option>';
			$("#company").jsp(option);
			//ajax填充数据后需调用下面的方法来刷新下拉列表
			$("#company").selectpicker('refresh');
		}
		loadSelect();
		
		//点击按钮，消息提示框
		$("#demo1").click(function() {
			//基本消息框－留着备用
			swal({
				title: "恭喜，添加成功",
				text: "数据添加成功，为您返回列表页！"
			})
		});
		
		// 选择客户公司名称时自动选对应的客户方负责人
		$("#company").change(function(){
			var thisVal=$(this).val();
			//val指value属性,选中value属性＝thisVal的选项
			$('#customer').selectpicker('val',thisVal);
		});
		
	});
   </script>
</body>


</html>
