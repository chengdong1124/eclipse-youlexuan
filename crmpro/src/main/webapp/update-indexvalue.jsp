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
    <link href="${pageContext.request.contextPath}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/select/bootstrap-select.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
	<link rel="stylesheet" href="css/customer.css" />
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        
      <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>对标管理<small>>添加指标基本信息</small></h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal">
                        	<div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">选择对标公司:</label>
                                <div class="col-sm-3">
                                    <select id="dacname" name="dacname" class="selectpicker form-control">
										<option>--请选择--</option>
                                    </select>
									</select>
                                </div>
                            </div>
                        </div>
                     	<div class="row indexvalue-title">
                     		<div class="col-sm-12 list-group-item-info indexvalue-text">
                     			<h4>对标企业信息如下 <i class="fa fa-hand-o-down"></i></h4>
                     		</div>
                     	</div>
                       	<div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">公司名称:</label>
                                <div id="pname" class="col-sm-3 show-text">
                                    
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">营业额:</label>
                                <div id="daturnover" class="col-sm-3 show-text">
                                    
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">年份:</label>
                                <div id="datime" class="col-sm-3 show-text">
                                    
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">员工数量:</label>
                                <div id="empcount" class="col-sm-3 show-text">
                                   
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">行业地位:</label>
                                <div id="dasort" class="col-sm-3 show-text">
                                    
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">创建时间:</label>
                                <div id="buildtime" class="col-sm-3 show-text">
                                    
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">主要业务:</label>
                                <div id="dabusiness" class="col-sm-9 show-text">
                                    
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">优势:</label>
                                <div id="dasuperiority" class="col-sm-9 show-text">
                                    
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">劣势:</label>
                                <div id="dainforiority" class="col-sm-9 show-text">
                                    
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">简单描述:</label>
                                <div id="remark" class="col-sm-9 show-text">
                                    
                                </div>
                            </div>
                        </div>
                        </form>
                     	
                     	<div class="row indexvalue-title">
                     		<div class="col-sm-12 list-group-item-info indexvalue-text">
                     			<h4>添加对标信息  <i class="fa fa-hand-o-down"></i></h4>
                     		</div>
                     	</div>

                     	<form id="addform" method="get" action="#" class="form-horizontal">
                     	<input type="hidden" name="id" value="${indexvalue.id }" />
                       	<div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">目标公司</label>
                                 <div class="col-sm-3">
                                    <select id="datacollectFk" name="datacollectFk" class="selectpicker form-control">
										<option>--请选择--</option>
                                    </select>
									
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">目标营业额</label>
                                <div class="col-sm-3">
                                    <input value="${indexvalue.turnover }" name="turnover" type="text" class="form-control input-sm">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">业务方向</label>
                                <div class="col-sm-3">
                                    <input value="${indexvalue.business }" name="business" type="text" class="form-control input-sm">
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">开始时间</label>
                                <div class="col-sm-3">
                                     <input value='<fmt:formatDate value="${indexvalue.starttime }" pattern="yyyy/MM/dd"/>' name="starttime" id="start" class="laydate-icon form-control layer-date">
                                
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">上传详细计划书</label>
                                <div class="col-sm-3">
                                   <input name="myfiles" type="file" class="form-control" >
                                </div>
                                <label class="col-sm-2 col-sm-offset-1 control-label">截止时间</label>
                                <div class="col-sm-3">
                                    <input value='<fmt:formatDate value="${indexvalue.endtime }" pattern="yyyy/MM/dd"/>' name="endtime" id="finish" class="laydate-icon form-control layer-date">
                               
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">备注</label>
                                <div class="col-sm-9">
                                    <textarea name="remark" class="form-control">"${indexvalue.remark }"</textarea>
                                </div>
                            </div>
                        </div>
                        </form>
                     	<div class="row">
                     		<div class="hr-line-dashed"></div>
                     	</div>
                          
                         <div class="row">
                            <div class="form-group">
                                <div class="col-sm-3 col-sm-offset-3 text-right">
                                    <button type="button" class="btn btn-primary btnSave"><i class="fa fa-save"></i> 保存内容</button>
                                </div>
                                <div class="col-sm-3">
                                	<a href="list-indexvalue.jsp" class="btn btn-white"><i class="fa fa-reply"></i> 返回</a>
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
	<script src="${pageContext.request.contextPath}/js/plugins/layer/laydate/laydate.js"></script>
	<script src="${pageContext.request.contextPath}/js/inputfile.js"></script>
   <script>
	$(document).ready(function() {
		// 设置按钮的样式
		$('.selectpicker').selectpicker('setStyle', 'btn-white');
	    var dfk = ${indexvalue.datacollectFk }
	    getVal(dfk);
	    
		function uploadCompany(){
			$.post("${pageContext.request.contextPath}/datacollect/listall",function(result){
				$(result).each(function(){
					var $option = "<option value='"+this.daid+"'>"+this.dacname+"</option>"
					if(dfk==this.daid){
						$option = "<option selected value='"+this.daid+"'>"+this.dacname+"</option>"
					}
					$("#dacname").append($option).selectpicker('refresh');
					$("#datacollectFk").append($option).selectpicker('refresh');
				});
			},"json");
		}
		uploadCompany();
		
		
		$("#dacname").change(function(){
			var id = $(this).val();	 //value可以直接拿哦option中的value，但是option中的data就不能直接拿，必须children(":selected")
			getVal(id);
		});
		
		function getVal(id){
			$.post("${pageContext.request.contextPath}/datacollect/getbyid",{"id":id},function(result){
				if(result!=null){
					$(result).each(function(){
						$("#pname").html(this.dacname);
						$("#daturnover").html(this.daturnover);
						$("#datime").html(this.datime);
						$("#empcount").html(this.empcount);
						$("#dasort").html(this.dasort);
						$("#buildtime").html(this.buildtime);
						$("#dabusiness").html(this.dabusiness);
						$("#dasuperiority").html(this.dasuperiority);
						$("#dainforiority").html(this.dainforiority);
						$("#remark").html(this.remark);
					});
				}
			},"json");
		} 
	
	          		
		$(".btnSave").click(function(){
			$.ajax({ 
				url: "${pageContext.request.contextPath}/indexvalue/update", 
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
						},function(){
							location.href="${pageContext.request.contextPath}/indexvalue/list";
						});
					}else{
						swal("发布失败","请稍后再试","warning");
					}
				}
			});
		});
		 
		
		
		
		
		
		
		
		
		
		
		
		//初始化日期控件
		laydate({elem: "#start"});
		laydate({elem: "#finish"});
		laydate({elem: "#buid"});
		
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
