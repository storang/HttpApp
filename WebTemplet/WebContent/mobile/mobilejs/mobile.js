$(selCountry)
function selCountry(){
	//input�Ǳ�׼��������¼���һ��Ӧ����inputԪ�أ���input��value�����仯�ͻᷢ��
	//�����Ǽ������뻹���������ĸı䶼�ܼ�ʱ�������仯ֻҪ��ǰ�������Է����ı䡣
	$("#countryId").bind('keyup',function(){
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
function selectGPRS(){
	$.post("servlet/selectGPRServlet",{"country" :  $("#countryId").val(),"tel" : $("#telid").val()},fillTable,"json");
}
function fillTable(data){
	for(var i = 0;i<data.list.length;i++)
	if(data.list[i].data_roaming==1){
		document.getElementById("win").style.display="block";
	}else{
		document.getElementById("win2").style.display="block";
	}
}
function closeLogin(){
	document.getElementById("win").style.display="none";
}
function closeLogin2(){
	document.getElementById("win2").style.display="none";
}
function checkTelPhone(){
	var phone = $("#telid").val();
	var subp = phone.substr(0,3);
	if(phone.length!=11){
		document.getElementById("sid").innerHTML="The phone length is 11";
	}else if(subp!=134||135||136||137||138||151||157||158){
		document.getElementById("sid").innerHTML="The phone is not exist";
	}else{
		document.getElementById("sid").innerHTML='True';
	}
}