$(selCountry)
function selCountry(){
	//input�Ǳ�׼��������¼���һ��Ӧ����inputԪ�أ���input��value�����仯�ͻᷢ��
	//�����Ǽ������뻹���������ĸı䶼�ܼ�ʱ�������仯ֻҪ��ǰ�������Է����ı䡣
	$("#countryId").bind('keydown',function(){
	//����ϴ�����
	$("#mbCountry").empty();	
	$.post("servlet/SelectCountryServlet",{"country" : $("#countryId").val()},function(data){
		for(var i = 0;i<data.length;i++){
			//option��ǩ�е�label����ʹ�������Ϊ����
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