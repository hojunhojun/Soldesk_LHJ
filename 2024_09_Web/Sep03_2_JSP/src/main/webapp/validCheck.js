/**
 * 
 */

function check() {
	var nField = document.inputForm.num;

		if(isEmpty(nField)|| isntNum(nField)) {
			nField.focus();
			alert("�ٽ� �Է����ּ���");
			return false;
		}
		
	return true;
}

function isntNum(input) {
	return (isNaN(input.value) || input.value.indexOf(" ") != -1);
}