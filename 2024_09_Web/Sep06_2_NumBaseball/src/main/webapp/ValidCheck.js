function check() {
	var iField = document.nbbForm.input;
	
	if (isEmpty(iField) || isNotNum(iField) || lessThan(iField,3)
		|| iField.value[0] == iField.value[1]
		|| iField.value[1] == iField.value[2]
		|| iField.value[2] == iField.value[0]) {
		iField.focus();
		alert("다시 입력해주세요");
		return false;
	}
	
	return true;
}