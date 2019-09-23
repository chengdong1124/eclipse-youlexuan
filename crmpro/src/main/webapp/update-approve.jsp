 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
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
                        <h5>报销<small>>报销申请</small></h5>
                    </div>
                    <div class="ibox-content">
                        <form id="addform" method="get" action="#" class="form-horizontal">
                       	<input type="hidden" name="bxid" value="${account.bxid }"/> 
                       	<input type="hidden" name="bxstatus" id="bxstatus" /> 
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">支出类型</label>
                                <div class="col-sm-3">
									<input type="text" class="selectpicker form-control" readonly="readonly" value="${account.paymode }"/> 
                                </div>
                                <label class="col-sm-2 control-label">使用时间</label>
                                <div class="col-sm-3">
                                    <!--时间控件的id都不能改-->
                                    <input readonly="readonly" value="<fmt:formatDate value='${account.bxtime }' pattern='yyyy-MM-dd' />" id="start" class="laydate-icon form-control layer-date">
                                
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">总金额</label>
                                <div class="col-sm-3">
                                    <input readonly="readonly" value="${account.totalmoney }" type="text" class="form-control" >
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">备注</label>
                                <div class="col-sm-9">
                                    <textarea readonly="readonly" class="form-control">${account.bxremark }</textarea>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">批准信息</label>
                                <div class="col-sm-9">
                                    <textarea name="result" class="form-control"></textarea>
                                </div>
                            </div>
                        </div>
                        
                     	<div class="row">
                     		<div class="hr-line-dashed"></div>
                     	</div>
                          
                         <div class="row">
                            <div class="form-group">
                                <div class="col-sm-2 col-sm-offset-3 text-right">
                                    <button data-status="2" type="button" class="btn btn-primary btnUpdate"><i class="fa fa-check"></i> 同意</button>
                                </div>
                                <div class="col-sm-2">
                                	<button data-status="0" type="button" class="btn btn-danger btnUpdate"><i class="fa fa-close"></i> 驳回</button>
                                </div>
                                <div class="col-sm-2">
                                	<a href="${pageContext.request.contextPath}/account/list?status=1" class="btn btn-white"><i class="fa fa-reply"></i> 返回</a>
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
	<script src="${pageContext.request.contextPath}/js/inputfile.js"></script>
	
   <script>
	$(document).ready(function() {
		
		// 设置按钮的样式
		$('.selectpicker').selectpicker('setStyle', 'btn-white');
		//初始化日期控件
		laydate({elem: "#start"});


		$(".btnUpdate").click(function(){
			var status = $(this).data("status");
			$("#bxstatus").val(status);
			var data = $("#addform").serialize();
			$.post("${pageContext.request.contextPath}/account/updatestatus",data,function(result){
				if(result=="true"){
					 swal({
					        title: "审批成功",
					        text: "审批成功，此申请将进入代付款状态！",
					        type: "success"
					    }, function () {
						    location.href="${pageContext.request.contextPath}/account/list?status=1";
					    });
				}else{
					swal("审批失败","审批失败，请稍后再试!","warning");
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
