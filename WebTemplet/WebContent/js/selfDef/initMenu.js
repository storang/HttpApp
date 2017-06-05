$(function(){
	$("#mainMenu").load("menu/main_menu.html");
});
function changeColor(){
	$("#mainMenu").load("menu/main_menu.html");
	var ul = document.getElementById("mainMenu");
	var li = document.getElementsByTagName("li");
	for(var i = 0;i<li.length;i++){
		li[i].className = "";
	}
}