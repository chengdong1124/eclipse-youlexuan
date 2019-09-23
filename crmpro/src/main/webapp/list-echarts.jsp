 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
</head>

<body class="gray-bg">
	<div class="wrapper2 wrapper-content2 animated fadeInRight">
    		<div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>折线图</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="graph_flot.jsp#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="graph_flot.jsp#">选项1</a>
                                </li>
                                <li><a href="graph_flot.jsp#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div height="400" class="echarts" id="echarts-line-chart"></div>
                    </div>
                </div>
            </div>
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>柱状图</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="graph_flot.jsp#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="graph_flot.jsp#">选项1</a>
                                </li>
                                <li><a href="graph_flot.jsp#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div width="800" class="echarts" id="echarts-bar-chart"></div>
                    </div>
                </div>
            </div>
        </div>
	</div>       
    <script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
     <script src="${pageContext.request.contextPath}/js/plugins/select/bootstrap-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/sweetalert/sweetalert.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins/echarts/echarts-all.js"></script>
	 
   <script>
	$(document).ready(function() {
		// 设置按钮的样式
		$('.selectpicker').selectpicker('setStyle', 'btn-white').selectpicker('setStyle', 'btn-sm');
		
		var lineChart = echarts.init(document.getElementById('echarts-line-chart'));
		var barChart = echarts.init(document.getElementById('echarts-bar-chart'));
		
		var companyName=[];
		var turnover=[];
		var employeeNumber=[];
		
		$.getJSON("${pageContext.request.contextPath}/datacollect/listall",function(result){
			$(result).each(function(){
				companyName.push(this.dacname);
				turnover.push(this.daturnover);
				employeeNumber.push(this.empcount);
			});
			lineChart.setOption(lineoption);
			barChart.setOption(baroption);
			
		});
		
		var lineoption = {
				title: {
					text: '对标公司营业额'
				},
				tooltip: {},	//小提示
				legend: {
					data: ['营业额/亿']
				},

				xAxis: {
					
					data: companyName,
				},
				yAxis: [{
					type: 'value',
					name: '年度营业额（亿）',
					splitNumber: 5
				}],

				series: [{
					//折线上数字
					 label: {
					     normal: {
					         show: true,
					         position: 'top',
					         formatter:100
					     }
					 },

					//顶上小图标名称
					name: '营业额/亿',
					type: 'line',
					data: turnover,

					//平均值
					markLine: {
						data: [{
							type: 'average',
							name: '平均值'
						}]
					},

				}]
			};

		//柱状图
		// 指定图表的配置项和数据
		var baroption = {
			title: {
				text: '员工数量'
			},
			tooltip: {},
			legend: {
				data: ['数量/个']
			},
			xAxis: {
				data: companyName,
			},
			yAxis: {
				type: 'value',
				name: '员工人数/个',
				splitNumber: 5
			},
			series: [{
				name: '数量/个',
				type: 'bar',
				//柱状宽度
				barWidth: 5,
				data: employeeNumber
				
			}]
		};
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//点击删除
		$('.btndel').click(function () {
		    swal({
		        title: "您确定要删除这条信息吗",
		        text: "删除后将无法恢复，请谨慎操作！",
		        type: "warning",
		        showCancelButton: true,
		        confirmButtonColor: "#DD6B55",
		        confirmButtonText: "删除",
		        closeOnConfirm: false
		    }, function () {//此函数是点击删除执行的函数
		    		//这里写ajax代码
		    		// 以下是成功的提示框，请在ajax回调函数中执行
			    swal("删除成功！", "您已经永久删除了这条信息。", "success");
		    });
		});
		
		
		$("#demo1").click(function() {
			//基本消息框－留着备用
			swal({
				title: "欢迎使用SweetAlert",
				text: "Sweet Alert 是一个替代传统的 JavaScript Alert 的漂亮提示效果。"
			})
		});
	});
    </script>
    
</body>


</html>
