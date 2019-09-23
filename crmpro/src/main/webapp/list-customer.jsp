 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <link href="${pageContext.request.contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/select/bootstrap-select.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper2 wrapper-content2 animated fadeInRight">
    <div class="ibox float-e-margins">
                   <div class="ibox-content">
                   
                   <form action="${pageContext.request.contextPath}/customer/list" method="POST">
                        <div class="row">
                        		<div class="col-sm-3 col-sm-offset-4 text-right">
                        			<h3><small>搜索条件:</small></h3>
                        		</div>
                        		
                            <div class="col-sm-2">
                                <select name="status" class="selectpicker form-control">
                                    <option value="0">选择类型</option>
                                    <option value="1" <c:if test="${status==1 }">selected="selected"</c:if>>公司联系人</option>   
                                    <option value="2" <c:if test="${status==2 }">selected="selected"</c:if>>公司名称</option>
                                </select>
                            </div>
                           
                            <div class="col-sm-3">
                                <div class="input-group">
                                    <input value="${checkName }" name="checkName" type="text" placeholder="请输入关键词" class="input-sm form-control companyperson">
                                    
                                    <span class="input-group-btn">
                                        <input type="submit" class="btn btn-sm btn-primary check"><i class="fa fa-search"></i> 搜索</input>
                                    </span>
                                </div>                        
                            </div>  
                        </div>
                   </form>
                        
                        <div class="hr-line-dashed2"></div>
                        <div class="table-responsive">
                            <table class="table table-striped list-table">
                                <thead>
                                    <tr>
                                    				
                                        <th>选择</th>
                                        <th>序号</th>
                                        <th>联系人</th>
                                        <th>公司名称</th>
                                        <th>添加时间</th>
                                        <th>联系电话</th>
                                        <th class="text-center">操作</th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list }" var="customer">
                                    <tr>
                                        <td><input  type="checkbox" value="${customer.id }"></td>
										<td>${customer.id }</td>
										<td>${customer.companyperson }</td>
										<td>${customer.comname }</td>
										<td><fmt:formatDate value="${customer.addtime }" pattern="yyyy-MM-dd"/></td>
										<td>${customer.comphone }</td>
                                        <td class="text-center">
	                                        <a href="${pageContext.request.contextPath}/customer/show?id=${customer.id }" class="btn btn-primary btn-xs"><i class="fa fa-eye"></i>查看</a>
	                                        <a href="${pageContext.request.contextPath}/customer/toupdate?id=${customer.id }" class="btn btn-primary btn-xs"><i class="fa fa-edit"></i>编辑</a>
	                                        <button id=${customer.id } class="btn btn-danger btn-xs btnRemove"><i class="fa fa-close"></i>删除</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                       
                        <div class="row">
	                        	<div class="col-sm-5">
	                        		<button class="btn btn-sm btn-primary btnAll" type="button"><i class="fa fa-check-square-o"></i> 全选</button>
	                        		<button class="btn btn-sm btn-primary btnReverse" type="button"><i class="fa fa-square-o"></i> 反选</button>
	                        		<button class="btn btn-sm btn-primary btnDel" type="button"><i class="fa fa-times-circle-o"></i> 删除</button>
	                        		<button id="demo1" class="btn btn-sm btn-primary" type="button"><i class="fa fa-table"></i> 导出Excel</button>
	                        	</div>
							<div class="col-sm-7 text-right">
								<div class="btn-group">
									
	                                <a <c:if test="${page.pageNum-1>=1 }"> href="${pageContext.request.contextPath}/customer/list?pageNum=${page.pageNum-1 }&checkName=${checkName }&status=${status }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum-1<1 }">disabled="disabled"</c:if>><i class="glyphicon glyphicon-chevron-left"></i>
	                                </a>
	                                
	                                <c:forEach begin="1" end="${page.pages }" varStatus="index">
	                                <a href="${pageContext.request.contextPath}/customer/list?pageNum=${index.index }&checkName=${checkName }&status=${status }" class="btn btn-sm btn-white" <c:if test="${page.pageNum==index.index }">active</c:if>>${index.index }</a>
	                                </c:forEach>
	                                
	                                <a <c:if test="${page.pageNum+1<=page.pages }">href="${pageContext.request.contextPath}/customer/list?pageNum=${page.pageNum+1}&checkName=${checkName }&status=${status }"</c:if> type="button" class="btn btn-sm btn-white" <c:if test="${page.pageNum+1>page.pages }">disabled="disabled"</c:if> ><i class="glyphicon glyphicon-chevron-right"></i></a>
	                                </a>
	                                
	                            </div>
							</div>
                        </div>
						
                    </div>
                </div>
     </div>       
    <script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
     <script src="${pageContext.request.contextPath}/js/plugins/select/bootstrap-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/sweetalert/sweetalert.min.js"></script>

   <script>
	$(document).ready(function() {
		// 设置按钮的样式
		$('.selectpicker').selectpicker('setStyle', 'btn-white').selectpicker('setStyle', 'btn-sm');
		
		$(".btnAll").click(function(){
			var checks = $("input[type='checkbox']");//不要忘了，给class也可以的，而我觉得给class会更好
			$(checks).prop("checked","checked");
		});
		
		$(".btnReverse").click(function(){
			var checks = $("input[type='checkbox']");
			$(checks).each(function(){
				var status = $(this).prop("checked"); //这里status是true或者fasle，是boolean哦，不是字符串
				$(this).prop("checked",!status);
			});
		});
		
		$(".btnDel").click(function(){		
			var checks = $("input:checked"); //还可以这样 $("input[type='checkbox']:checked");
			var ids=""
			$(checks).each(function(){
				var id = $(this).val();
				ids += "&ids="+id;		
			});			
				$.post("${pageContext.request.contextPath}/customer/removeAll",ids,function(result){
					if(result=="true"){
						 swal({
						        title: "删除成功",
						        text: "删除后将无法恢复，请谨慎操作！",
						        type: "success",
						        showCancelButton: true,
						    }, function () {
						    		location.href="${pageContext.request.contextPath}/customer/list";
						    });
					}else{
						swal("删除失败","删除失败，请稍后重试！","warning");
					}
				},"text");
		});
		
		$(".btnRemove").click(function(){
			var id = $(this).prop("id");
			$.post("${pageContext.request.contextPath}/customer/removeOne",{"id":id},function(result){
				if(result=="true"){
					 swal({
					        title: "删除成功",
					        text: "删除后将无法恢复，请谨慎操作！",
					        type: "success",
					        showCancelButton: true
					    }, function () {
					    		location.href="${pageContext.request.contextPath}/customer/list";
					    });
				}else{
					swal("删除失败","删除失败，请稍后重试！","warning");
				}
			},"text");
		});
		
		/* $(".check").click(function(){
			var value = $(".selectpicker option:selected").val();
			var companyperson = $(".companyperson").val();
			if(value=="1"){
				$.post("${pageContext.request.contextPath}/customer/selectByCompanyperson",{"companyperson":companyperson},
						function(result){},"text");
			} else{
				
			}
		});	    不能用ajax做，因为要刷新页面 */
		
		
		
		
		
	});
	
    </script>
    
</body>


</html>
















