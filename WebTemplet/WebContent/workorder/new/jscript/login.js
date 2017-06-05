function refresh(){
	var img = document.getElementById("img_validation_code");
	img.src = "ValidationCode?"+Math.random();
}