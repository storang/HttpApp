function checkPhone(){
	var phone = $("#phone").val();
	var subp = phone.substr(0,3);
	if(phone.length!=11){
		/*document.getElementById("sid").innerHTML="<a>Œ“</a>";*/
		document.getElementById("sid").innerHTML='The length is 11';
		return false;
	}else if(subp==134||135||136||137||138||151||157||158){
		document.getElementById("sid").innerHTML="The phone can't to save";
		return false;
	}else{
		document.getElementById("sid").innerHTML='True';
		return true;
	}
}
function checkContent(){
	var content = $("#contentId").val();
	if(content==null||content==undefined||content==""){
		document.getElementById("csId").innerHTML = 'The content can not null';
		return false;
	}else{
		document.getElementById("csId").innerHTML = 'True';
		return true;
	}
}
function checkAdvise(){
	var advise = $("#adviceId").val();
	if(advise==""||advise==null||advise==undefined){
		document.getElementById("asId").innerHTML = 'The advise can not null';
		return false;
	}else{
		document.getElementById("asId").innerHTML = 'True';
		return true;
	}
}
function submitForm(){
	if(checkPhone()&&checkContent()&&checkAdvise()){
		document.getElementById("allow").submit();
	}
}