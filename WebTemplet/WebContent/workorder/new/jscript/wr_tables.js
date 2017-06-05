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
 function searchWr(){
	//获取第一页数据
	getUserByPageNum(1);
 }
 $(function(){
 	//获取第一页数据
 	getUserByPageNum(1);
 });
 function getUserByPageNum(page){
	 var time = document.getElementById("time").value;
 	$.post("./LoginPageServlet",{"pageNum":page,"pageSize":pageSize,"acceptdate":time},fillTable,"json");
 }
 function fillTable(data){
 	//list count
 	//获得总页数
 	var pageCount = Math.ceil(data.count/pageSize);
 	$("tr:gt(0)").remove();
	$.each(data.list,function(){
		var trHtml = "<tr><td class='bs-checkbox'><input type='checkbox' name='test' value="+this.wsid+"></td><td>"+this.wsid+"</td><td><a  href='servlet/wr_table?id="+this.wsid+"'>"+this.serial_no+"</a></td><td>"+this.accept_date+"</td>" +
				"<td>"+this.customer_grade+"</td><td>"+this.customer_band+"</td><td>"+this.customerservice_iobno+"</td><td>"+this.customerservice_solveflag+"</td><td>"+this.last_modify+"</td><td>" +
				"<a class='glyphicon glyphicon-pencil action-button' href='workorder/wr_edit.jsp?id="+this.wsid+"'></a>" +
				"<a class='glyphicon glyphicon-list-alt action-button' href='servlet/wr_tableSelect?id="+this.wsid+"'></a>" +
				"<a class='glyphicon glyphicon-trash action-button' href='servlet/wr_tableFile?id="+this.wsid+"'></a></td></tr>";
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
 function selectDel(){
		 var check = document.getElementsByName("test");
		 for(var i = 0;i<check.length;i++){
			 if(check[i].checked){
				 $.post("servlet/wr_tableFile",{"id":check[i].value},function(){
					 window.location.href="notices.html";
				 });
				 	
			 }
		 }
		
	 }