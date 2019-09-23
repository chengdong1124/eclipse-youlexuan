 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                        <h5>项目管理<small>>添加项目信息</small></h5>
                    </div>
                    <div class="ibox-content">
                    
                        <form id="addform" method="POST" class="form-horizontal">
                       	<div class="row">
                       	<input type="hidden" name="pid" value="${project.pid }" class="notnull"/>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">项目名称</label>
                                <div class="col-sm-3">
                                    <input value="${project.pname }" name="pname" type="text" class="form-control input-sm notnull">
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">客户公司名称</label>
                                <div class="col-sm-3">
                                    <select name="comname" id="company" class="selectpicker form-control notnull">
									  <option value="0">--请选择--</option>	
									</select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">客户方负责人</label>
                                <div class="col-sm-3">
                                    <select name="companyperson" id="customerPerson" class="selectpicker form-control notnull">
									  <option value="0">--请选择--</option>									 
									</select>
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">项目经理</label>
                                <div class="col-sm-3">
                                    <select name="empFk" id="projectManager" class="selectpicker form-control notnull">
									   <option value="0">--请选择--</option>	  
									</select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">开发人数</label>
                                <div class="col-sm-3">
                                    <input value="${project.empcount }" name="empcount" type="text" class="form-control input-sm notnull">
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">开始时间</label>
                                <div class="col-sm-3">
                                		<!--时间控件的id都不能改-->
                                    <input value="<fmt:formatDate value='${project.starttime }' pattern='yyyy/MM/dd'/>" name="starttime" id="start" class="laydate-icon form-control layer-date notnull">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">立项时间</label>
                                <div class="col-sm-3">
                                    <input value="<fmt:formatDate value='${project.buildtime }' pattern='yyyy/MM/dd'/>" name="buildtime" id="buid" class="laydate-icon form-control layer-date notnull">
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">预估成本</label>
                                <div class="col-sm-3">
                                    <input value="${project.cost }" name="cost" type="text" class="form-control input-sm notnull">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">级别</label>
                                <div class="col-sm-3">
                                    <select name="level" class="selectpicker form-control notnull">
										<option value="0">--选择级别--</option>
										<option <c:if test="${project.level==1 }">selected="selected"</c:if> value="1">一般</option>
										<option <c:if test="${project.level==2 }">selected="selected"</c:if> value="2">紧急</option>
										<option <c:if test="${project.level==3 }">selected="selected"</c:if> value="3">暂缓</option>
									
									</select>
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">计划完成时间</label>
                                <div class="col-sm-3">
                                    <input value="<fmt:formatDate value='${project.endtime }' pattern='yyyy/MM/dd'/>" name="endtime" id="finish" class="laydate-icon form-control layer-date notnull">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">备注</label>
                                <div class="col-sm-9">
                                    <textarea name="remark" class="form-control">${project.remark }</textarea>
                                </div>       
                            </div>
                        </div>
                        
                     	<div class="row">
                     		<div class="hr-line-dashed"></div>
                     	</div>
                          
                         <div class="row">
                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-3 text-right">
                                    <button type="button" class="btn btn-primary btnUpdate"><i class="fa fa-save"></i> 修改内容</button>
                                </div>
                                <div class="col-sm-3">
                                	<a href="${pageContext.request.contextPath}/project/list" class="btn btn-white"><i class="fa fa-reply"></i> 返回</a>
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
		laydate({elem: "#finish"});
		laydate({elem: "#buid"});
		laydate({elem: "#start"});
		var pid = ${project.pid };
		var comname = ${project.comname };
		var empFk = ${project.empFk }
		
		function loadCustomer(){
			$.post("${pageContext.request.contextPath}/customer/listall",function(result){
				$(result).each(function(){
					var $option=$("<option data-customer='"+this.companyperson+"'value='"+this.id+"'>"+this.comname+"</option>");
					$("#company").append($option).selectpicker('refresh');
					if(comname==this.id){//在selectpicker后面可以的
						$option.prop("selected",true);
					}
					var $option=$("<option data-id='"+this.id+"'value='"+this.companyperson+"'>"+this.companyperson+"</option>");
					$("#customerPerson").append($option).selectpicker('refresh');
					if(comname==this.id){
						$option.prop("selected",true);
					}
				});
			},"json");
		}
		loadCustomer();	
		
		
		
		
		$("#company").change(function(){
			var thisVal=$(this).children(":selected").data("customer");
			//val指value属性,选中value属性＝thisVal的选项
			$('#customerPerson').selectpicker('val',thisVal);
		});
		
		$("#customerPerson").change(function(){
			var thisVal=$(this).children(":selected").data("id");
			//val指value属性,选中value属性＝thisVal的选项
			$('#company').selectpicker('val',thisVal);
		});	
		
		
		
		
		function loadProjectManager(){
			$.post("${pageContext.request.contextPath}/employee/listByPFK","p_fk=4",function(result){
				$(result).each(function(){
					var $option=$("<option value='"+this.eid+"'>"+this.ename+"</option>");
					$("#projectManager").append($option).selectpicker('refresh');
					if(empFk==this.eid){
						$option.prop("selected",true);
					}
					$("#projectManager").append($option).selectpicker('refresh');
				});
			},"json");
		}
		loadProjectManager();
		
		//添加
		$(".btnSave").click(function(){
			if(isNull()){
				return;
			}
			var data = $("#addform").serialize();
			alert(data);
			$.post("${pageContext.request.contextPath}/project/save",data,function(result){
				if(result=="true"){
					swal({
						title: "恭喜，添加成功",
						text: "数据添加成功，为您返回列表页！",
						type:"success"
					},function(){
						location.href="${pageContext.request.contextPath}/project/list";
					});
				}else{
					swal({
						title: "恭喜，添加失败",
						text: "数据添加失败，哈哈",
						type:"warning"
					});
				}
			},"text");
		});	
	});
	
	
	function isNull(){
		var value = $(".notnull:input");
		var isNull="";
		$(value).each(function(){
			if($(this).val()==""||$(this).val()==0){ //这里0打不打双引号都可以
				isNull=true;
			}
		});
		if(isNull){
			swal({
				title: "添加失败",
				text: "客户信息添加失败，请检查数据的有效性！",
				type: "warning"
			});
			return true;
		}
	}
	

	$(".btnUpdate").click(function(){
		if(isNull()){
			return;
		}
		var data = $("#addform").serialize();
		alert(data);
		$.post("${pageContext.request.contextPath}/project/update",data,function(result){
			if(result=="true"){
				swal({
					title: "修改成功",
					text: "客户信息修改成功，恭喜！",
					type: "success"
				},function(){
					location.href="${pageContext.request.contextPath}/project/list";
				});
			}else{
				swal({
					title: "修改失败",
					text: "客户信息修改失败，没法了！",
					type: "warning"
				});
			}
		},"text");
	});
	
	
   </script>
   
</body>


</html>
