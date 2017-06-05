<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录</title>
<base href="/WebTemplet/"/>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<script src="js/jquery-1.11.1.min.js"></script>
<!-- <script src="workorder/new/jscript/login.js"></script> -->
<script type="text/javascript">
</script>
</head>
<%
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();
	String nowTime = sdf.format(date);
%>
<body>
	 <c:if test="${isError}">
		<c:out value="<script>alert('${requestScope.errorMsg}');</script>" escapeXml="false"></c:out>
	</c:if> 
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Log in</div>
				<div class="panel-body">
					<form action="servlet/LoginServlet?date1=<%=nowTime %>" method="post">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="用户名" name="username"/>
							</div>
							<div class="form-group" >
								<input class="form-control" placeholder="密码" name="password" type="password"/>
								<%-- <font color="#ff0000">${requestScope.errorMsg}</font> --%>
							</div>
							<!-- <div class="form-group" >
								<input class="form-control" placeholder="验证码" id="validation_code" name="validation_code" style="width:80px;margin-top:2px" size="30" maxlength="30">
								<img id="img_validation_code" src="ValidationCode"/>
								<input type="button" value="刷新" onclick="refresh()">
							</div> -->
							<input type="submit" value="Login" class="btn btn-primary"/>
						</fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->	

</body>

</html>
