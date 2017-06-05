<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>客服支撑系统</title>
<base href="/WebTemplet/"/>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/bootstrap-table.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/selfDef/initMenu.js"></script>
</head>
<body id="nav" class="wr_table">
<script>
</script>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>CCSHXT 欢迎你</span>  ${user[0].ucname}</a>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<!-- <input type="text" class="form-control" placeholder="Search"> -->
			</div>
		</form>
		<!-- 菜单开始 -->
		<ul class="nav menu" id="mainMenu"></ul><!-- 无序列表 --><!-- ol有序列表 -->
		<!-- 菜单结束 -->
		
		<div class="attribution">Template by <a href="http://www.medialoot.com/item/lumino-admin-bootstrap-template/">Medialoot</a></div>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">	
		<!-- 导航说明开始 -->		
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">投诉工单</li>
			</ol>
		</div><!--/.row-->
		<!-- 导航说明结束 -->		
		
		<!-- 页面主题开始 -->		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">投诉工单管理</h1>
			</div>
		</div><!--/.row-->
		<!-- 页面主题结束 -->		
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<!-- 
					<div class="panel-heading">Advanced Table</div>
					 -->
					<div class="panel-body">
						<!-- 数据表格开始 -->
						 <div class="bootstrap-table">
						 <!-- 表格工具条开始 -->
						    <div class="fixed-table-toolbar">
						    	<!-- 新增按钮 -->
						    	<form action="workorder/wr_tableAdd.jsp">
						 		<div class="columns btn-group pull-left">
						 			<input type="submit" class="btn btn-primary" value=" Add "/>
						 		</div>
						 		</form>
						    	<div class="columns btn-group pull-left">
						    		<input type="button" class="btn btn-danger" value=" Del "/>
						    	</div>
						    	<!-- 查询按钮 -->
						    </div>
						    <!-- 表格工具条结束 -->
						    
						    <div class="fixed-table-container">
						        <div class="fixed-table-body">
						            <div class="fixed-table-loading" style="top: 37px; display: none;">Loading, please wait…</div>
						            <table class="table table-hover">
						                <thead>
						                    <tr>
						                        <th>
						                            <div class="th-inner sortable">id</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">客服工单流水号</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">受理时间</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">归属地市</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">受理号码</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">客户级别</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">客户品牌</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">诉求内容</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">重复投诉</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">客服侧处理意见</div>
						                            <div class="fht-cell"></div>
						                        </th> 
						                        <th>
						                            <div class="th-inner sortable">是否解决</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">客服侧处理人工号</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">归档时间</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">是否超时</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">最后操作时间</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">是否大面积投诉</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                    </tr>
						                </thead>
						                <tbody>
						                	<c:forEach items="${workList}" var="work">
						                 <tr id="tId"></tr>
						                 <td>${work.wsid}</td>
						                 <td>${work.serial_no}</td>
						                 <td>${work.accept_date}</td>
						                 <td>${work.customer_city}</td>
						                 <td>${work.customer_phonenum}</td>
						                 <td>${work.customer_grade}</td>
						                 <td>${work.customer_band}</td>
						                 <td>${work.customer_content}</td>
						                 <td>${work.is_reapt}</td>
						                 <td>${work.customerservice_advise}</td>
						                 <td>${work.customerservice_solveflag}</td>
						                 <td>${work.customerservice_iobno}</td>
						                 <td>${work.customerservice_archiye_data}</td>
						                 <td>${work.overtime_flag}</td>
						                 <td>${work.last_modify}</td>
						                 <td>${work.audit_is_largearea}</td>
						                     </c:forEach> 
						                </tbody>
						            </table>
						        </div>
						        <!--   页码位置 -->
						        <form action="workorder/wr_tables.jsp">
						 		 <div align="center"> 
						 			<input type="submit" class="btn btn-primary" value=" 返回 "/>
						 		 </div> 
						 		</form>
						        </div>
						    </div>
						</div>
						<!-- 数据表格结束 -->
						
					</div>
				</div>
			</div>
		</div><!--/.row-->	
		
		
	</div><!--/.main-->

</body>

</html>
