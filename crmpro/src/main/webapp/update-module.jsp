 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
                        <h5>需求管理<small>>添加需求信息</small></h5>
                    </div>
                    <div class="ibox-content">
                        <form id="addform" method="post" class="form-horizontal">
                       	<input type="hidden" name="id" value="${module.id }"/>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">选择项目</label>
                                <div class="col-sm-3">
                                    <select id="project" name="projectname" class="selectpicker form-control">
										<option value="0">--请选择--</option>
									</select>
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">选择需求</label>
                                <div class="col-sm-3">
                                	<input value="${module.analysisFk }" type="hidden" id="analysisid" name="analysisFk" />
                                    <input value="${module.analysis.title }" id="analysis" class="selectpicker form-control" readonly="readonly" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">模块名称</label>
                                <div class="col-sm-3">
                                    <select id="module" name="modelname" class="selectpicker form-control">
										<option value="0">--请选择--</option>
										
									</select>
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">优先级</label>
                                <div class="col-sm-3">
                                    <select id="level" name="level" class="selectpicker form-control">
										<option <c:if test="${module.level=='0' }">selected="selected"</c:if> value="0">--请选择--</option>
										<option <c:if test="${module.level=='低' }">selected="selected"</c:if> value="低">低</option>
										<option <c:if test="${module.level=='中' }">selected="selected"</c:if> value="中">中</option>
										<option <c:if test="${module.level=='高' }">selected="selected"</c:if> value="高">高</option>
										
										
									</select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">简单描述</label>
                                <div class="col-sm-9">
                                    <textarea name="simpledis" class="form-control">${module.simpledis }</textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">详细描述</label>
                                <div class="col-sm-9">
                                    <textarea name="detaileddis" class="form-control">${module.detaileddis }</textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">备注</label>
                                <div class="col-sm-9">
                                    <textarea name="remark" class="form-control">${module.remark }<</textarea>
                                </div>
                            </div>
                        </div>
                        
                     	<div class="row">
                     		<div class="hr-line-dashed"></div>
                     	</div>
                          
                         <div class="row">
                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-3 text-right">
                                    <button type="button" class="btn btn-primary btnUpdate"><i class="fa fa-save"></i> 保存内容</button>
                                </div>
                                <div class="col-sm-3">
                                	<a href="${pageContext.request.contextPath}/module/list" class="btn btn-white"><i class="fa fa-reply"></i> 返回</a>
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
		var mid = ${module.id };
		var fk = ${module.analysisFk };
		// 设置按钮的样式
		$('.selectpicker').selectpicker('setStyle', 'btn-white');
		
		
		function loadProject(){
			$.post("${pageContext.request.contextPath}/project/listall",function(result){
				$(result).each(function(){
					$option=$("<option data-id='"+this.pid+"' value='"+this.pname+"'>"+this.pname+"</option>");
					if(fk==this.pid){
						$option.prop("selected",true);
					}
					$("#project").append($option).selectpicker("refresh");
				});
			},"json");
		}
		loadProject();
		
	
		$("#project").change(function(){
			var id = $(this).children(":selected").data("id");
			$.post("${pageContext.request.contextPath}/analysis/getbyid",{"id":id},function(result){
				if(result!=null){
					var title = result.title;
					$("#analysis").val(title);
					$("#analysisid").val(id);
					loadModule(id);
			
				}else{
					 swal({
					        title: "好像少了个啥",
					        text: "不能这么添加",
					        type: "warning",
					    });
				}
			},"json");
		});
		
		function loadModule(id){
			$.post("${pageContext.request.contextPath}/module/listByAnalysisFk",{"analysis_fk":id},function(result){
				$(result).each(function(){
					$option=$("<option value='"+this.modelname+"'>"+this.modelname+"</option>");
					if(this.id==mid){
						$option.prop("selected",true);
					}
					$("#module").append($option).selectpicker("refresh");
				});
			},"json");
		}
		loadModule(fk);
		
		$("#level").change(function(){
			$(".btnSave").prop("disabled",false);
		});
		
		$(".btnSave").click(function(){
			var data = $("#addform").serialize();
			$.post("${pageContext.request.contextPath}/module/save",data,function(result){
				if(result=="true"){
					 swal({
					        title: "添加成功",
					        text: "添加成功，恭喜",
					        type: "success"
					    });
				}else{
					 swal({
					        title: "添加失败",
					        text: "添加失败，sorry",
					        type: "warning"
					    });
				}
			},"text");
		});
		
		$(".btnUpdate").click(function(){
			var data = $("#addform").serialize();
			$.post("${pageContext.request.contextPath}/module/update",data,function(result){
				if(result=="true"){
					swal({
				        title: "修改成功",
				        text: "修改成功，恭喜",
				        type: "success"
				    });
				}else{
					swal({
				        title: "修改失败",
				        text: "修改失败，sorry",
				        type: "warning"
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
   
</body>


</html>
