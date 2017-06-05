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
<link href="css/layui.css" media="all">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/jquery.page.js"></script>
<script src="js/layui.js"></script>
<script src="js/selfDef/initMenu.js"></script>
<script src="mobile/mobilejs/mobile.js" charset="UTF-8"></script>
</head>
<body id="nav" class="mobile">
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
				<a class="navbar-brand" href="#"><span>CCSHXT 欢迎你 </span> ${user[0].ucname}</a>
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
				<li class="active">国漫开通</li>
			</ol>
		</div><!--/.row-->
		<!-- 导航说明结束 -->		
		
		<!-- 页面主题开始 -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">国漫开通查询</h1>
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
						    	<form id="sss">
						    	<div class="pull-left search">
						    	手机号:<input class="layui-input" type="text" placeholder="请输入手机号" style="width: 400px;" name="tel" id="telid" onblur="checkTelPhone()"><span id="sid" style="color:red;"></span>
						    	</div>
						    	<div class="pull-left search">
						    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	国家:<input class="layui-input" type="text" placeholder="请输入国家" style="width: 400px;" name="country" id="countryId" list="mbCountry">
						    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						    	</div>
						    	</form>
						        <!-- <ul id="colors_ul"></ul> -->
						         <!-- datalist
			 						 标签定义选项列表。请与 input 元素配合使用该元素，来定义 input 可能的值。
			  						datalist 及其选项不会被显示出来，它仅仅是合法的输入值列表。
			 					 -->
			 					 <datalist id="mbCountry">
			 					 </datalist>
			 					 <div id=win style="display:none; POSITION:absolute; left:50%; top:50%; 
									width:300px; height:300px;margin-left:-300px; margin-top:10px; 
									border:1px solid #888; background-color:#edf;text-align:center">
									当前国家没有开通该服务<br><div class="columns btn-group pull-center">
						 			<input type="button" class="btn btn-primary" value=" 关闭 " onclick="closeLogin()"/>
						 		</div></div>
						 		<div id=win2 style="display:none; POSITION:absolute; left:50%; top:50%; 
									width:300px; height:300px;margin-left:-300px; margin-top:10px; 
									border:1px solid #888; background-color:#edf;text-align:center">
									当前国家开通了该服务<br><div class="columns btn-group pull-center">
						 			<input type="button" class="btn btn-primary" value=" 关闭 " onclick="closeLogin2()"/>
						 		</div></div>
						        <div class="columns btn-group pull-left">
						        	<button class="btn btn-default" type="button" name="Search" title="Search" id="submitId" onclick="selectGPRS()"><i class="glyphicon glyphicon-search"></i></button>
						        </div>
					</div>
				</div>
			</div>
		</div><!--/.row-->	
		</div>
		
	</div><!--/.main-->
</body>

</html>
