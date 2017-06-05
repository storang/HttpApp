function msgbox(n){
	document.getElementById("inputbox").style.display=n?'block':'none';
}
function verify1(){
	var t1 = document.getElementById("old").value;
	var pwd = document.getElementById("upwd").value;
	if(t1!=pwd){
		document.getElementById("oid").innerHTML=false;
		return false;
	}else{
		document.getElementById("oid").innerHTML=true;
		return true;
	}
}
function verify2(){
	var t2 = document.getElementById("new").value;
	var t3 = document.getElementById("again").value;
	if(t2!=t3||t2==""||t2==null||t2==undefined){
		document.getElementById("nid").innerHTML=false;
		return false;
	}else{
		document.getElementById("nid").innerHTML=true;
		return true;
	}
}
function submitForm(){
	if(verify1()&&verify2()){
		document.getElementById("allow").submit();
	}
}