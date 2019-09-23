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
                        <h5>客户信息管理<small>修改客户信息</small></h5>
                    </div>
                    <div class="ibox-content">
                    
                        <form id="addform" method="post" action="#" class="form-horizontal">
                       	<input type="hidden" name="id" value="${customer.id }" />
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">公司名称</label>
                                <div class="col-sm-3">
                                   <input value="${customer.comname }" placeholder="必填" name="comname" type="text" class="form-control input-sm notnull">
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">公司联系人</label>
                                <div class="col-sm-3">
                                   <input value="${customer.companyperson }" placeholder="必填" name="companyperson" type="text" class="form-control input-sm notnull">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">联系电话</label>
                                <div class="col-sm-3">
                                   	<input value="${customer.comphone }" placeholder="必填" name="comphone" type="text" class="form-control input-sm notnull">
                                </div>
                                <label class="col-sm-2  col-sm-offset-1 control-label">座机</label>
                                <div class="col-sm-3">
                                    <input value="${customer.camera }" name="camera" type="text" class="form-control input-sm">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">公司地址</label>
                                <div class="col-sm-9">
                                   <input value="${customer.comaddress }" placeholder="必填" name="comaddress" type="text" class="form-control input-sm notnull">
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">公司简介</label>
                                <div class="col-sm-9">
                                    <textarea value="${customer.present }" name="present" class="form-control"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">备注</label>
                                <div class="col-sm-9">
                                    <textarea value="${customer.remark }" name="remark" class="form-control"></textarea>
                                </div>
                            </div>
                        </div>
                        </form>
                        
                     	<div class="row">
                     		<div class="hr-line-dashed"></div>
                     	</div>
                          
                         <div class="row">
                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-4 text-right">
                                    <button type="button" class="btn btn-primary btnSave"><i class="fa fa-save"></i> 保存</button>
                                </div>
                            </div>
                       </div>
                       
                    </div>
                </div>
            </div>
        </div>
    </div>

 
    
    
    <script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/sweetalert/sweetalert.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins/select/bootstrap-select.min.js"></script>
	
   <script>
	$(document).ready(function() {
		// 设置按钮的样式
		$('.selectpicker').selectpicker('setStyle', 'btn-white');
	
		
		$(".btnSave").click(function(){
			if(isNull()){
				return;
			}
			var data = $("#addform").serialize();
			$.post("${pageContext.request.contextPath}/customer/update",data,function(result){
				if(result=="true"){
					 swal({
					        title: "修改成功",
					        text: "客户信息修改成功！返回列表页",
					        type: "success",
					        showCancelButton: true,
					        confirmButtonColor: "#AEDEF4",
					        confirmButtonText: "成功",
					        closeOnConfirm: false
					    }, function () {
					    	//此函数是点击成功执行的函数
						    location.href="${pageContext.request.contextPath}/customer/list";
					    });				
				}else{
					swal({
						title: "修改失败",
						text: "客户信息修改失败，请检查数据的有效性！",
						type: "warning"
					})					
				}
			},"text");
		});
		
		function isNull(){
			var form=$(".notnull");
			var isNull="";
			$(form).each(function(){
				if($(this).val()==""||$(this).val()=="0"){
					isNull=true;
				}
			});
			
			if(isNull){
				swal({
					title: "修改失败",
					text: "客户信息修改失败，请检查数据的有效性！",
					type: "warning"
				});
				return true;
			}
		}
		
		
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
