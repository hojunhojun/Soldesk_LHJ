function check() {
	var nField = document.bForm.name;
	var hField = document.bForm.height;
	var wField = document.bForm.weight;
	var pField = document.bForm.photo;
	
	if (isEmpty(nField) || isEmpty(hField) || isEmpty(wField) || isEmpty(pField) ||
			isntNum(hField) || isntNum(wField)) {
		nField.focus();
		alert("다시 입력해주세요.");
		return false;
	}
	
	if (isNotType(pField, "png") && isNotType(pField, "jpg") && isNotType(pField, "gif")) {
		alert("사진 형식이 다릅니다.")
		return false;
	}
	return true;
}

function isntNum(input) {
	return (isNaN(input.value) || input.value.indexOf(" ") != -1 || input.value.indexOf("-") != -1);
}
