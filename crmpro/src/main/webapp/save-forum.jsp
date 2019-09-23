 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
   <link href="${pageContext.request.contextPath}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/customer.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/plugins/select/bootstrap-select.min.css" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        
      <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>论坛<small>>发帖</small></h5>
                    </div>
                    <div class="ibox-content">
                        <form id="addform" method="get" action="#" class="form-horizontal">
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">板块</label>
                                <div class="col-sm-4">
                                <select id="sort" name="forumsortFk" class="selectpicker form-control">
                                    <option  value="0">--选择板块--</option>
                                </select>
                                </div>
                            </div>
                        </div>
                         <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">标题</label>
                                <div class="col-sm-9">
                                    <input name="forumtitle" type="text" class="form-control input-sm">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">内容</label>
                                <div class="col-sm-9">
                                	<input id="forumcontent" type="hidden" name="forumcontent">
                                    <script id="editor" type="text/plain"></script>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">标签</label>
                                <div class="col-sm-9 tips">
                                    <input  name="label" value="1" type="checkbox" >文件
                                    <input  name="label" value="2" type="checkbox" >资源
                                    <input  name="label" value="3" type="checkbox" >分享
                                    <input  name="label" value="4" type="checkbox" >技术
                                    <input  name="label" value="5" type="checkbox" >问答
                                    <input  name="label" value="6" type="checkbox" >讨论
                                    <input  name="label" value="7" type="checkbox" >其它
                                </div>
                            </div>
                        </div>
                     	<div class="row">
                     		<div class="hr-line-dashed"></div>
                     	</div>
                          
                         <div class="row">
                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-4 text-right">
                                    <button type="button" class="btn btn-primary btnSave"><i class="fa fa-save"></i> 保存内容</button>
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
	
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
    
    <script>
	$(document).ready(function() {
		//实例化编辑器
		var ue = UE.getEditor('editor');     //实例化编辑器
		
		// 设置按钮的样式
		$('.selectpicker').selectpicker('setStyle', 'btn-white');
		
		$(".btnSave").click(function(){
			var UEdata = UE.getEditor('editor').getContent();
			$("#forumcontent").val(UEdata);
			var data = $("#addform").serialize();
			$.post("${pageContext.request.contextPath}/forumpost/save",data,function(result){
				if(result=="true"){
					swal("添加成功","添加成功，这谁顶得住","success");
				}else{
					swal("添加失败","添加失败，这也没办法","warning");
				}
			},"text");
		});
		
		
		function loadForumsortTitle(){
			var type="";
			$.getJSON("${pageContext.request.contextPath}/forumsort/listall",function(result){
				$(result).each(function(){
					if(this.type==0){
						type="[主版块]"
					}else{
						type="[副板块]"
					}
					var $option=$("<option value='"+this.id+"'>"+type+"-"+this.title+"</option>");
					$("#sort").append($option).selectpicker('refresh');
				});
			});
		}
		loadForumsortTitle();
		


		
		
		
		
		
		
		
		
		
		
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
