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
                        <h5>任务管理<small>>添加任务</small></h5>
                    </div>
                    <div class="ibox-content">
                        <form method="post" id="addform" class="form-horizontal">
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">参考位置</label>
                                <div class="col-sm-3">
                                   	<select id="project" name="proFk" class="selectpicker form-control">
										<option value="0">--选择项目--</option>
									</select>
                                </div>
                                <div class="col-sm-2">
                                   	<input id="analysis" readonly="readonly" type="text" class="form-control input-sm">
                                </div>
                                <div class="col-sm-2">
                                  	<select id="module" name="moduleFk" class="selectpicker form-control">
										<option value="0">--选择模块--</option>
									</select>
                                </div>
                                <div class="col-sm-2">
                                    <select id="function" name="funFk" class="selectpicker form-control">
										<option>--选择功能--</option>
										
									</select>
                                </div>
                                
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">任务标题</label>
                                <div class="col-sm-3">
                                		<input name="tasktitle" type="text" class="form-control input-sm">
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">执行者</label>
                                <div class="col-sm-3">
                                    <select id="employee" name="empFk2" class="selectpicker form-control">
										<option>--选择执行者--</option>
									</select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">开始时间</label>
                                <div class="col-sm-3">
                                		<input type="date" name="starttime" id="starttime" class="laydate-icon form-control layer-date">
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">结束时间</label>
                                <div class="col-sm-3">
                                    <input type="date" name="endtime" id="endtime" class="laydate-icon form-control layer-date">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">优先级</label>
                                <div class="col-sm-3">
                                		<select name="level" class="selectpicker form-control">
										<option value="高">高</option>
										<option value="中">中</option>
										<option value="低">低</option>
										<option value="暂缓">暂缓</option>
									</select>
                                </div>
                            </div>
                        </div>
                        
                        
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">详细描述</label>
                                <div class="col-sm-9">
                                    <textarea name="remark" class="form-control"></textarea>
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
                                	<a href="list-task.jsp" class="btn btn-white"><i class="fa fa-reply"></i> 返回</a>
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
		//初始化日期控件
		
		//加载项目名称
		function loadProject(){
			$.post("${pageContext.request.contextPath}/project/listall",function(result){
				$(result).each(function(){
					var $option=$("<option value='"+this.pid+"'>"+this.pname+"</option>");//option也是有id与value的男人
					$("#project").append($option).selectpicker('refresh');
				});
			},"json");
		}
		loadProject();
		
		
	 	$("#project").change(function(){
			var id=$(this).val();
			getAnalysis(id);
			
		});
		
		function getAnalysis(id){
			$.post("${pageContext.request.contextPath}/analysis/getbyid",{"id":id},function(result){
				if(result==null){   // 这里返回单个对象，所以用null判断
					$("#analysis").val("");
					 swal({
					        title: "查询失败",
					        text: "没有对应的需求，是否前往添加需求",
					        type: "warning",
					        showCancelButton: true,
					        confirmButtonColor: "#DD6B55",
					        confirmButtonText: "yes",
					        closeOnConfirm: false
					    }, function () {
					    	location.href="${pageContext.request.contextPath}/save-analysis.jsp";
					    });
				}else{
					$("#analysis").val(result.title);
					$("#analysisname").val(result.id);
					getModule(id);
				}
			},"json");
		}
		
		//加载模块信息
		function getModule(id){
			$.post("${pageContext.request.contextPath}/module/listByAnalysisFk",{"analysis_fk":id},
					function(result){
				if(result.length==0){     //这里返回一个集合，所以用长度判断
					$("#module").html("");
					$(".btnSave").prop("disabled","disabled");
					 swal({
					        title: "查询失败",
					        text: "没有对应的模块，是否前往添加模块",
					        type: "warning",
					        showCancelButton: true,
					        confirmButtonColor: "#DD6B55",
					        confirmButtonText: "yes",
					        closeOnConfirm: false
					    }, function () {
					    	location.href="${pageContext.request.contextPath}/save-module.jsp";
					    });
				}else{
					$("#module").html("");
					var $option=$("<option value='0'>--请选择--</option>");
					$("#module").append($option).selectpicker('refresh');	
					$(result).each(function(){
							var $option=$("<option value='"+this.id+"'>"+this.modelname+"</option>");
							$("#module").append($option).selectpicker('refresh');
						});
				}
			},"json");
		} 
		//这里module被analysis一对多，还没有选择module，而module与function一对多，module还没确定，不能先加载出function
		$("#module").change(function(){
			var id = $(this).val();
			$.post("${pageContext.request.contextPath}/function/listbyfk",{"fk":id},function(result){
				if(result.length==0){   //一对多，返回的是个集合哦
					$("#function").html("");
					$(".btnSave").prop("disabled","disabled");
					 swal({
					        title: "查询失败",
					        text: "没有对应的功能，是否前往添加功能",
					        type: "warning",
					        showCancelButton: true,
					        confirmButtonColor: "#DD6B55",
					        confirmButtonText: "yes",
					        closeOnConfirm: false
					    }, function () {
					    	location.href="${pageContext.request.contextPath}/save-module.jsp";
					    });
				}else{
					$(".btnSave").removeAttr("disabled"); //$(".btnSave").prop("disabled",false);
					$("#function").html("");
					var $option=$("<option value='0'>--请选择--</option>");
					$("#function").append($option).selectpicker('refresh');	
					$(result).each(function(){
							var $option=$("<option value='"+this.id+"'>"+this.functionname+"</option>");
							$("#function").append($option).selectpicker('refresh');	
						});
				}
			},"json");
		}); 

		function loadEmployee(){
			$.post("${pageContext.request.contextPath}/employee/listall",function(result){
				$(result).each(function(){
					var fk = this.pFk;
					var $option=""
					if(fk==1){
						$option=$("<option value='"+this.eid+"'>[初级开发工程师] - "+this.ename+"</option>")
					}else if(eid==2){
						$option=$("<option value='"+this.eid+"'>[初级开发工程师] - "+this.ename+"</option>");
					}else if(eid==3){
						$option=$("<option value='"+this.eid+"'>[初级开发工程师] - "+this.ename+"</option>");
					}
					$("#employee").append($option).selectpicker('refresh');	
					
				});
			},"json");
		}
		loadEmployee();
		
		$(".btnSave").click(function(){
			var data = $("#addform").serialize();
			$.post("${pageContext.request.contextPath}/task/save",data,function(result){
				if(result=="true"){
					swal({
				        title: "添加成功",
				        text: "添加成功，恭喜",
				        type: "success"
				    },function(){
				    	location.href="${pageContext.request.contextPath}/save-task.jsp";
				    });
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
  <!-- 修复日期控件长度-->
   <link href="${pageContext.request.contextPath}/css/customer.css" rel="stylesheet">
</body>


</html>
