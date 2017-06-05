$(function(){
	selectYear();
	selectMonth();
})
function selectYear(){
	var obj = document.getElementById("year");
	for(var i = 2000;i<2020;i++){
		var op = new Option(i,i);
		obj.add(op);
	}
}
function selectMonth(){
	var obj = document.getElementById("month");
	for(var i = 1;i<13;i++){
		var op = new Option(i,i);
		obj.add(op);
	}
}
/*var pageNum = 1,pageSize = 3;
function searchUser(){
	//获取第一页数据
	getUserByPageNum(1);
	
}
function getUserByPageNum(page){
	 var year = document.getElementById("year").value;
	 var month = document.getElementById("month").value;
	$.post("usernumPageServlet",{"pageNum":page,"pageSize":pageSize,"year":year,"month":month},fillTable,"json");
}
function fillTable(data){
	//list count
	//获得总页数
	var pageCount = Math.ceil(data.count/pageSize);
	$("tr:gt(0)").remove();
	$.each(data.list,function(){
		var trHtml = "<tr><td class='bs-checkbox'><input type='checkbox' name='test' value="+this.unid+"></td><td>"+this.unid+"</td><td>"+this.city_id+"</td>" +
				"<td>"+this.account_user+"</td><td>"+this.gprs_user+"</td><td>"+this.wlan_user+"</td><td></tr>";
		$("tbody").append(trHtml);
	});
	//生成页码
	 $(".tcdPageCode").createPage({
	 		pageCount:pageCount,
	 		current:pageNum,
	 		backFn:function(pageNumber){
	 			pageNum = pageNumber;
	 			getUserByPageNum(pageNumber);
	 		}
	 	});
	
}*/