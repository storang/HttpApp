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
<link href="css/jqpage.css" rel="stylesheet">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/jquery.page.js"></script>
<script src="js/selfDef/initMenu.js"></script>
<script src="usernum/script/selectyear.js"></script>
<script src="usernum/script/userpage.js"></script>
</head>
<body id="nav" class="usernum">
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
				<a class="navbar-brand" href="#"><span>CCSHXT 欢迎你</span> ${user[0].ucname }</a>
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
				<li class="active">用户统计</li>
			</ol>
		</div><!--/.row-->
		<!-- 导航说明结束 -->		
		
		<!-- 页面主题开始 -->		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">用户数统计报表</h1>
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
						    	 
						    	<!-- 查询按钮 -->
						    	<div class="pull-left search">
									<label>查询时间：</label><select name="year"  id="year">
										<option value=""></option>
									</select>
									<label>年</label><select name="month"  id="month">
										<option value=""></option>
									</select>
						        	<label>月</label>
						        	<button class="btn btn-default" type="submit" name="Search" title="Search" onclick="searchUser()"><i class="glyphicon glyphicon-search"></i></button>
						        </div>
						    </div>
						    <!-- 表格工具条结束 -->
						    
						    <div class="fixed-table-container">
						        <div class="fixed-table-body">
						            <div class="fixed-table-loading" style="top: 37px; display: none;">Loading, please wait…</div>
						            <table class="table table-hover">
						                <thead>
						                    <tr>
						                        <th class="bs-checkbox " style="width: 36px; ">
						                            <div class="th-inner "><input name="btSelectAll" type="checkbox"></div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">序号</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">地区</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">出账用户数</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">WALN用户数</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">GPRS用户数</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">年份</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                        <th>
						                            <div class="th-inner sortable">月份</div>
						                            <div class="fht-cell"></div>
						                        </th>
						                    </tr>
						                </thead>
						                <tbody>
						                	<%-- <c:forEach items="${userList}" var="user">
						                 <tr id="tId"></tr>
						                     </c:forEach>  --%>
						                </tbody>
						            </table>
						        </div>
						        <div class="tcdPageCode" align="center"></div>
						        <!--   页码位置 -->
						        
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
