// css : ������ �ۼ��ؾ���
// js : �� ���� �Ƚᵵ��
function calcCheck() {
	var xInput = document.calcForm.xx;
	var yInput = document.calcForm.yy;
	
	if (isEmpty(xInput) || isEmpty(yInput) || isNotNum(xInput) || isNotNum(yInput)) {
		alert("�ٽ� �Է����ּ���");
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