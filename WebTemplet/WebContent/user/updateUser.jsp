<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.ccshxt.util.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>客服支撑系统</title>
<base href="/WebTemplet/"/>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<link href="user/usercss/user.css" rel="stylesheet">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/selfDef/initMenu.js"></script>
<script type="text/javascript" src="Date/WdatePicker.js"></script>
<script src="user/userjs/user.js"></script>
</head>

<body id="nav" class="user">
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>ccshxt 欢迎你</span>  ${user[0].ucname}</a>
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
		<ul class="nav menu" id="mainMenu">
		</ul>
		<!-- 菜单结束 -->
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">	
	<!-- 导航说明开始 -->			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">个人信息管理</li>
			</ol>
		</div><!--/.row-->
		<!-- 导航说明结束 -->
		<!-- 页面主题开始 -->	
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">个人信息编辑</h1>
			</div>
		</div><!--/.row-->
		<!-- 页面主题结束 -->			
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">WorkOrder Edit</div>
					<div class="panel-body">
						<div class="col-md-6">
							<!-- 
							/UserAddServlet 
							1.  ../UserAddServlet 相对路径
							2.  /WebTemplet/UserAddServlet 绝对路径
							-->
								<div class="form-group">
									<label>账号</label>
									<input class="form-control" placeholder="Placeholder" value="${user[0].uname }"  onfocus="this.blur()">
								</div>
								<div class="form-group">
									<label>密码</label>
									<input  type="password" class="form-control" value="${user[0].upwd }" id="upwd" onfocus="this.blur()"/>
								</div>
								<form action="servlet/userServlet" method="post" id="allow">
								<div id="inputbox" class="box">
								原&nbsp;&nbsp;密&nbsp;&nbsp;码：<input type="password" id="old"><span id="oid"></span><br>
								新&nbsp;&nbsp;密&nbsp;&nbsp;码：<input type="password" id="new" name="upwd"><span id="nid"></span><br>
								再次确认：<input type="password" id="again"><br>
								<input  onclick="msgbox(0)" type="button" value="取消">
								<input type="button" value="确定" onclick="submitForm()">
								</div>
								</form>
								<div class="form-group">
									<label>姓名</label>
									<input class="form-control" placeholder="Placeholder" value="${user[0].ucname }"  onfocus="this.blur()">
								</div>
								<div class="form-group">
									<label>是否启用</label>
									<input class="form-control" name="customerContent" placeholder="Placeholder" value="启用" onfocus="this.blur()">
								</div>
								<!-- <div class="form-group checkbox">
								  <label>
								    <input type="checkbox">Remember me</label>
								</div> -->
								<!-- <div class="form-group">
									<label>Selects</label>
									<select class="form-control">
										<option>Option 1</option>
										<option>Option 2</option>
										<option>Option 3</option>
										<option>Option 4</option>
									</select>
								</div>	 -->							
								
								<!-- <div class="form-group">
									<label>Radio Buttons</label>
									<div class="radio">
										<label>
											<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>Radio Button 1
										</label>
									</div>
									<div class="radio">
										<label>
											<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Radio Button 2
										</label>
									</div> 
								</div>-->
								<button type="button" class="btn btn-primary" onclick="msgbox(1)">修改密码</button>
								<button type="reset" class="btn btn-default">Reset Button</button>
							</div>
					</div>
				</div>
			</div><!-- /.col-->
		</div><!-- /.row -->
		
	</div><!--/.main-->

</body>
</html>