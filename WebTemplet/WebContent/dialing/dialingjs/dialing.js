$(selCountry)
function selCountry(){
	//input是标准的浏览器事件，一般应用于input元素，当input的value发生变化就会发生
	//无论是键盘输入还是鼠标黏贴的改变都能及时监听到变化只要当前对象属性发生改变。
	$("#countryId").bind('keydown',function(){
	//清空上次数据
	$("#mbCountry").empty();	
	$.post("servlet/SelectCountryServlet",{"country" : $("#countryId").val()},function(data){
		for(var i = 0;i<data.length;i++){
			//option标签中的label属性使下拉框更为剪短
			var temp = "<option value='"+data[i].country+"'>";
			$("#mbCountry").append(temp);
		}
	},"json");
	});
}
function selectServe(){
	$.post("servlet/changeCountry",{"country" :$("#countryId").val()},fillTable,"json");
}
function fillTable(data){
	$.each(data.list,function(){
		/*$("#win2").append(+this.operation);*/
		document.getElementById("win2").value=this.operation
	});
}
	/*for(var i = 0;i<data.list.length;i++)
		alert(this.operation);
		document.getElementById("win2").innerHTML=this.operation;
	}
function closeLogin(){
	document.getElementById("win").style.display="none";
}
function closeLogin2(){
	document.getElementById("win2").style.display="none";
}*/