
function selectOnchange() {
	var mode = $("#mode").val();
	if (mode == "坐标模式") {
		$('#origin').attr('placeholder', '39.084105,121.817608')
		$('#destination').attr('placeholder', '39.057184,121.781387')
		$('#origin').attr('title', '支持小数点六位')
		$('#destination').attr('title', '支持小数点六位')
	}
	if (mode == "地址模式") {
		$('#origin').attr('placeholder', 'xx市xx区xx街道xx号')
		$('#destination').attr('placeholder', 'xx市xx区xx街道xx号')
		$('#origin').attr('title', '地址越准确定位精度越高')
		$('#destination').attr('title', '地址越准确定位精度越高')
	}
}

$(document).ready(function() {
	origin = document.getElementById("origin")
	$('#origin').attr('placeholder', '39.084105,121.817608')
	$('#destination').attr('placeholder', '39.057184,121.781387')
	$('#origin').attr('title', '支持小数点六位')
	$('#destination').attr('title', '支持小数点六位')
})