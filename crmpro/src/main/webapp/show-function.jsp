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
	<link href="${pageContext.request.contextPath}/css/customer.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        
      <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>需求管理<small>>添加需求信息</small></h5>
                    </div>
                    <div class="ibox-content">
                        <form method="get" action="#" class="form-horizontal">
                       	
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">选择项目</label>
                                <div class="col-sm-3 show-text">
                                	${function.project.pname }
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">选择需求</label>
                                <div class="col-sm-3 show-text">
                                	${function.analysis.title }
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">选择模块</label>
                                <div class="col-sm-3 show-text">
                                	${function.module.modelname }
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">优先级</label>
                                <div class="col-sm-3 show-text">
                                	${function.level }
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">功能名称</label>
                                <div class="col-sm-3 show-text">
                                	${function.functionname }
                                </div>
                                
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">简单描述</label>
                                <div class="col-sm-9 show-text">
                                    ${function.simpledis }
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">详细描述</label>
                                <div class="col-sm-9 show-text">
                                	${function.detaileddis}
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">备注</label>
                                <div class="col-sm-9 show-text">
                                    ${function.remark }
                                </div>
                            </div>
                        </div>
                        
                     	<div class="row">
                     		<div class="hr-line-dashed"></div>
                     	</div>
                          
                         <div class="row">
                            <div class="form-group">
                                <div class="col-sm-2 col-sm-offset-5 ">
                                	<a href="${pageContext.request.contextPath}/function/list" class="btn btn-white"><i class="fa fa-reply"></i> 返回</a>
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
	<script src="${pageContext.request.contextPath}/js/plugins/layer/laydate/laydate.js"></script>
   <script>
	$(document).ready(function() {
		// 设置按钮的样式
		$('.selectpicker').selectpicker('setStyle', 'btn-white');
		
	
		
		
		
		//--------------------下面是常用代码模版---------------------------------------
		
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
