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
    	<link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/select/bootstrap-select.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/plugins/zTreeStyle/zTreeStyle.css" />

</head>

<body class="gray-bg">
	<div class="wrapper2 wrapper-content2 animated fadeInRight">
	    <div class="row">
	    		<div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>资源管理</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="zTreeDemoBackground left" style="font-size: 16px">
							<ul id="treeDemo" class="ztree"></ul>
						</div>
                    </div>
                </div>
            </div>
	    		<div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5 class="sourcesTitle">资源添加</h5>
                    </div>
                    <div class="ibox-content">
                        <form id="addform" class="form-horizontal">
                            <input type="hidden" id="opr" value="save">
                            <input type="hidden" name="id" >
                            <div class="form-group">
                                <label class="col-sm-4 control-label">菜单资源名称：</label>

                                <div class="col-sm-7">
                                    <input type="text" name="name" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">父菜单：</label>

                                <div class="col-sm-7">
                                    <select id="sources" name="pid" class="selectpicker form-control">
										
									</select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">菜单资源路径：</label>

                                <div class="col-sm-7">
                                    <input name="url" type="text" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">备注：</label>
                                <div class="col-sm-7">
                                    <textarea name="remark" class="form-control"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button class="btn btn-sm btn-white btnSend" type="button"><i class="fa fa-save"></i> 保存</button>
                                    <button class="btn btn-sm btn-white btnReset" type="button"><i class="fa fa-undo"></i> 重置</button>
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
     <script src="${pageContext.request.contextPath}/js/plugins/select/bootstrap-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/sweetalert/sweetalert.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins/ztree/jquery.ztree.core.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins/ztree/jquery.ztree.exedit.js"></script>
   <script>
	
    
	var setting = {
			async: {
				enable: true,
				url: "${pageContext.request.contextPath}/sources/listztree",
				autoParam: ["id"]
			},
			view: {
					addHoverDom: function(treeId, treeNode){  
						var aObj = $("#" + treeNode.tId + "_a"); // tId = permissionTree_1, ==> $("#permissionTree_1_a")
						aObj.attr("href", "javascript:;");
						if (treeNode.editNameFlag || $("#btnGroup"+treeNode.tId).length>0) return;
						var s ='<span id="btnGroup'+treeNode.tId+'">';
						if ( treeNode.level == 1 ) {
							s += '<span class="button edit" onclick="editNode('+treeNode.id+')"></span>';
							if (treeNode.children.length == 0) {
								s += '<span class="button remove" onclick="deleteNode('+treeNode.id+')"></span>';
							}
						} else if ( treeNode.level == 2 ) {
							s += '<span class="button edit" onclick="editNode('+treeNode.id+')" ></span>';
							s += '<span class="button remove" onclick="deleteNode('+treeNode.id+')" ></span>';
						}
						s += '</span>';
						aObj.append(s);
					},
					removeHoverDom: function(treeId, treeNode){
						$("#btnGroup"+treeNode.tId).remove();
					}
				}
			 
	  };
	
	//编辑
	function editNode(id){
		$(".sourcesTitle").html("资源修改");
		$("#opr").val("update");
		$.getJSON("${pageContext.request.contextPath}/sources/get",
			{"id":id},
			function(sources){
			//把返回的数据填到表单中
			$(":input[name='name']").val(sources.name); //看到没，返回的是一个对象不用遍历
			$(":input[name='url']").val(sources.url);
			$(":input[name='remark']").val(sources.remark);
			$(":input[name='id']").val(sources.id);
			loadSources(sources.pid);//重新加载下拉
		});
	}
	
	//删除
	function deleteNode(id){
		//ajax请求台
		$.post("${pageContext.request.contextPath}/sources/remove","id="+id,function(result){
			if(result=="true"){
				swal("删除成功","删除成功","success");
				refreshZtree();
			}else{
				swal("删除失败","删除失败","error");
			}
			
		},"text");
	}
	
	
	
	
	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting);
		// 设置按钮的样式
		$('.selectpicker').selectpicker('setStyle', 'btn-white').selectpicker('setStyle', 'btn-sm');
		
		
		
		//加载父菜单下拉框
		function loadSources(sysPid){
			$.post("${pageContext.request.contextPath}/sources/list",function(result){
				$("#sources").html(""); //清空原有的内容
				var $option=$("<option value='0'>---作为顶层菜单---</option>");
				$("#sources").append($option).selectpicker("refresh");
				$(result).each(function(){
					var $option=$("<option value='"+this.id+"'>"+this.name+"</option>")
					if(this.id==sysPid){
						$option=$("<option selected value='"+this.id+"'>"+this.name+"</option>")
					}
					$("#sources").append($option).selectpicker("refresh");
				});
			},"json");
		}
		
		
		
		loadSources(0);//加载下拉
		
		$(".btnReset").click(function(){
			$("#addform")[0].reset();
			$(".sourcesTitle").html("资源添加");
			$(".opr").val("save");
			loadSources(0);
		});
		
		//添加功能
		$(".btnSend").click(function(){
			var data=$("#addform").serialize();
			var opr=$("#opr").val();
			var message="添加";
			if(opr=="update"){
				message="修改";
			}
			//根据opr请求不同的路径
			$.post("${pageContext.request.contextPath}/sources/"+opr,data,function(result){
				if(result=="true"){
					swal(message+"成功",message+"成功","success");
					refreshZtree();//刷新Ztree数据
					$("#addform")[0].reset();//清空表单
					loadSources(0);//数据已更新，重新加载下拉列表
				}else{
					swal(message+"失败",message+"失败","error");
				}
			},"text");
			
		});
		
		// 刷新Ztree数据
		function refreshZtree(){
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			treeObj.reAsyncChildNodes(null, "refresh");
		}
	});
	</SCRIPT>
</body>


</html>
