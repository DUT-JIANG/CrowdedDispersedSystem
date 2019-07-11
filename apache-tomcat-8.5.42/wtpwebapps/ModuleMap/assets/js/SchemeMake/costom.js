


function selectOnchange(){
	var mode = $("#mode").val();
	if(mode=="坐标模式"){
		$('#origin').attr('placeholder','121.817608,39.084105')
		$('#destionation').attr('placeholder','121.781387,39.057184')
		$('#origin').attr('title','支持小数点六位，先输入经度后输入纬度用英文逗号隔开')
		$('#destionation').attr('title','支持小数点六位，先输入经度后输入纬度用英文逗号隔开')
	}
	if(mode=="地址模式"){
		$('#origin').attr('placeholder','xx市xx区xx街道xx号')
		$('#destionation').attr('placeholder','xx市xx区xx街道xx号')
		$('#origin').attr('title','输入详细地址')
		$('#destionation').attr('title','输入详细地址')
	}
	
}

$(document).ready(function(){
	origin=document.getElementById("origin")
		$('#origin').attr('title','支持小数点六位，先输入经度后输入纬度用英文逗号隔开')
		$('#destionation').attr('title','支持小数点六位，先输入经度后输入纬度用英文逗号隔开')
		$('#origin').attr('placeholder','121.817608,39.084105')
		$('#destionation').attr('placeholder','121.781387,39.057184')
		
})