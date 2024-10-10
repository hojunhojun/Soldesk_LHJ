function check() {
	var nField = document.inputForm.num;
	
		// JavaScript : Front-end개발자
		if(isEmpty(nField)|| isntNum(nField)) {
			nField.focus();
			alert("다시 입력해주세요");
			return false;
		}
		
	return true;
}

function isntNum(input) {
	return (isNaN(input.value) || input.value.indexOf(" ") != -1);
}