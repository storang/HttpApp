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
 var pageNum = 1,pageSize = 5;
 function searchUser(){
	//获取第一页数据
	 	getUserByPageNum(1);
 }
 function getUserByPageNum(page){
	 var time = document.getElementById("time").value;
 	$.post("servlet/managerSelect",{"pageNum":page,"pageSize":pageSize,"opendate":time},fillTable,"json");
 }
 function fillTable(data){
 	//list count
 	//获得总页数
 	var pageCount = Math.ceil(data.count/pageSize);
 	$("tr:gt(0)").remove();
	$.each(data.list,function(){
		var trHtml = "<tr><td class='bs-checkbox'><input type='checkbox' name='test' value="+this.mirid+"></td><td>"+this.country+"</td><td>"+this.mm_code+"</td>" +
				"<td>"+this.operation+"</td><td>"+this.gsm_roaming+"</td><td>"+this.data_roaming+"</td><td>"+this.open_date+"</td><td>" +
				"<a class='glyphicon glyphicon-pencil action-button' href='manager/managerUpdate.jsp?id="+this.mirid+"'></a>" +
				"<a class='glyphicon glyphicon-list-alt action-button' href='manager/managerUpdate.jsp?id="+this.mirid+"'></a>" +
				"<a class='glyphicon glyphicon-trash action-button' href='servlet/deletManager?id="+this.mirid+"'></a></td></tr>";
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
	
 }
 function deleteCheck(){
	 	alert(456);
		 var check = document.getElementsByName("test");
		 for(var i = 0;i<check.length;i++){
			 if(check[i].checked){
				 $.post("servlet/deletALL",{"id":check[i].value},function(){
					 window.location.href="success.html";
				 });
				 	
			 }
		 }
		
	 }