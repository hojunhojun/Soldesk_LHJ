// css : 여러개 작성해야함
// js : 뭐 별로 안써도됨
function calcCheck() {
	var xInput = document.calcForm.xx;
	var yInput = document.calcForm.yy;
	
	if (isEmpty(xInput) || isEmpty(yInput) || isNotNum(xInput) || isNotNum(yInput)) {
		alert("다시 입력해주세요");
		xInput.value="";
		yInput.value="";
		xInput.focus();
		return false;
	}
	
	return true;
}

function martCheck() {
	var martInput = document.martForm.martInput
	
	if (isEmpty(martInput)) {
		return false;
	}
	return true;
}