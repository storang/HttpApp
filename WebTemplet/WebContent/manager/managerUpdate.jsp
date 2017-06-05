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
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/selfDef/initMenu.js"></script>
<script type="text/javascript" src="Date/WdatePicker.js"></script>
</head>

<body id="nav" class="manager">
	<%
		DBUtil db=DBUtil.getDB(); 
		String mirid = request.getParameter("id");
		String sql = "SELECT mirid,di.dict_value AS reaptValue,dic.dict_value AS dataValue,mm_code,operation,country,di.dict_lable gsm_roaming,dic.dict_lable data_roaming,open_date FROM mobile_inter_roaming m,dicts di,dicts dic WHERE dic.dict_type = 'reapt' AND dic.dict_value=m.gsm_roaming AND di.dict_type = 'reapt' AND di.dict_value=m.data_roaming AND mirid="+mirid;
		List<Map<String,Object>> alist=db.list(sql);
	%>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>ccshxt 欢迎你</span> ${user[0].ucname}</a>
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
				<li class="active">主叫工单</li>
			</ol>
		</div><!--/.row-->
		<!-- 导航说明结束 -->
		<!-- 页面主题开始 -->	
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">主叫显示和国漫编辑</h1>
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
							<form action="servlet/managerUpdate" method="post">
							<div class="form-group">
									<label>id</label>
									<input class="form-control" placeholder="Placeholder" value="<%=alist.get(0).get("mirid")%>" name="id" onfocus="this.blur()">
								</div>
								<div class="form-group">
									<label>国家</label>
									<input class="form-control" placeholder="Placeholder" value="<%=alist.get(0).get("country")%>" name="serialNo" onfocus="this.blur()">
								</div>
								<div class="form-group">
									<label>IMIS</label>
									<input name="acceptDate" type="text" class="form-control" value="<%=alist.get(0).get("mm_code")%>"  onfocus="this.blur()"/>
								</div>
								<div class="form-group">
									<label>运营商</label>
									<input name="acceptDate" type="text" class="form-control" value="<%=alist.get(0).get("operation")%>"  onfocus="this.blur()"/>
								</div>
								<div class="form-group">
									<label>GSM</label>
									<select class="form-control" name="gsm">
										<option value="<%=alist.get(0).get("reaptValue") %>"><%=alist.get(0).get("gsm_roaming")%></option>
										<option value="6">是</option>
										<option value="7">否</option>
									</select>
								</div>
								<div class="form-group">
									<label>数据漫游</label>
									<select class="form-control" name="data">
										<option value="<%=alist.get(0).get("dataValue") %>"><%=alist.get(0).get("data_roaming")%></option>
										<option value="6">是</option>
										<option value="7">否</option>
									</select>
								</div>
								<div class="form-group">
									<label>开通时间</label>
									<input name="lastTime" class="form-control" placeholder="Placeholder" value="<%=alist.get(0).get("open_date") %>"  onfocus="this.blur()">
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
								
								
								<button type="submit" class="btn btn-primary">Submit Button</button>
								<button type="reset" class="btn btn-default">Reset Button</button>
							</form>
							</div>
					</div>
				</div>
			</div><!-- /.col-->
		</div><!-- /.row -->
		
	</div><!--/.main-->

</body>
</html>