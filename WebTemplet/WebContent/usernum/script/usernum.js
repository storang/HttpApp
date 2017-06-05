/*
 * 1 page limit 0,5   0,10
 * 2 page limit 5,5   10,10
 * 3 page limit 10,5  20,10
 *  
 * limit (pageNum-1)*pageSize,pageSize;
 * 
 * pageCount : recordCount/pageSize 
 * 
 */
 var pageNum = 1,pageSize = 7;
 function searchUser(){
	 getUserByPageNum(1);
 }
 $(function(){
 	//获取第一页数据
 	getUserByPageNum(1);
 });
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
				"<td>"+this.account_user+"</td><td>"+this.gprs_user+"</td><td>"+this.wlan_user+"</td><td>"+this.data_year+"</td><td>"+this.data_month+"</td></tr>";
		$("tbody").append(trHtml);
	});
	 $(".tcdPageCode").createPage({
	 		pageCount:pageCount,
	 		current:pageNum,
	 		backFn:function(pageNumber){
	 			pageNum = pageNumber;
	 			getUserByPageNum(pageNumber);
	 		}
	 	});
 }