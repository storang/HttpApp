<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Random"%>
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
<script src="workorder/new/jscript/wr_tableAdd.js"></script>
</head>
<%
	SimpleDateFormat sim = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat simd = new SimpleDateFormat("yyyyMMDDHHMMSS");
	Date date = new Date();
	String str = sim.format(date);
	Random random = new Random();
	int ran = random.nextInt()*100;
	String rannum= str+ran;
	String manNum = simd.format(date)+12;
%>
<body id="nav" class="wr_table">
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>ccshxt 欢迎你</span>  ${user[0].ucname }</a>
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
				<li class="active">投诉工单管理</li>
			</ol>
		</div><!--/.row-->
		<!-- 导航说明结束 -->
		<!-- 页面主题开始 -->	
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">添加投诉工单</h1>
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
							<form action="servlet/wr_tableADDServlrt" method="post" id="allow">
								<div class="form-group">
									<label>客服工单流水号</label>
									<input class="form-control" placeholder="请输入工单流水号" value=<%=rannum %> name="serialNo">
								</div>
								<div class="form-group">
									<label>客服受理时间</label>
									<input id="d12" type="text" class="form-control" placeholder="客服受理时间" name="acceptDate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate">
								</div>
								<div class="form-group">
									<label>用户归属地市</label>
									<select class="form-control" name="customerCity">
										<option value="111">长春</option>
										<option value="112">吉林</option>
										<option value="113">四平</option>
										<option value="114">白山</option>
										<option value="115">通化</option>
										<option value="116">白城</option>
										<option value="117">辽源</option>
										<option value="118">松原</option>
										<option value="119">延吉</option>
									</select> 
								</div>
								
								<div class="form-group">
									<label>受理号码</label>
									<input class="form-control" placeholder="请输入手机号" name="customerPhone" id="phone">
									<span id="sid" style="color:red"></span>
								</div>
								<div class="form-group">
									<label>客户级别</label>
									<select class="form-control" name="customerGrade">
										<option value="3">普通卡</option>
										<option value="2">银卡</option>
										<option value="1">金卡</option>
									</select>
								</div>
								<div class="form-group">
									<label>客户品牌</label>
									<select class="form-control" name="customerBand">
										<option value="10">全球通</option>
										<option value="11">校园通</option>
										<option value="12">动感地带</option>
										<option value="13">神州行</option>
									</select>
								</div>
								<div class="form-group">
									<label>诉求内容</label>
									<textarea class="form-control" placeholder="请输入诉求内容" name="customerContent" cols="50" rows="4" id="contentId"></textarea><span id="csId"></span>
								</div>
								<div class="form-group">
									<label>是否重复投诉</label>
									<select class="form-control" name="isReapt">
										<option value="7">否</option>
									</select>
								</div>
								<div class="form-group">
									<label>客服侧处理意见</label>
									<textarea class="form-control" placeholder="处理意见" name="serviseAdvise" cols="50" rows="4" id="adviceId"></textarea><span id="asId"></span>
								</div>
								<div class="form-group">
									<label>是否解决</label>
									<select class="form-control" name="serviceFlag">
										<option value="未解决">未解决</option>
									</select>
								</div>						
								<div class="form-group">
									<label>客服侧处理人工号</label>
									<input  class="form-control" placeholder="人工号" name="customerIobno" value="<%=manNum %>">
								</div>
								<div class="form-group">
									<label>最后操作时间</label>
									<input class="form-control" placeholder="请点击" name="lastTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate">
								</div>
								<div class="form-group">
									<label>是否大面积投诉</label>
									<select class="form-control" name="largearea">
										<option value="是">是</option>
										<option value="否">否</option>
									</select>
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
								<button type="button" class="btn btn-primary" onclick="submitForm()">Submit Button</button>
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