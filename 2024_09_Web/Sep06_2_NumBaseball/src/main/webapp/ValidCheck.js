function check() {
	var iField = document.nbbForm.input;
	
	if (isEmpty(iField) || isNotNum(iField) || lessThan(iField,3)
		|| iField.value[0] == iField.value[1]
		|| iField.value[1] == iField.value[2]
		|| iField.value[2] == iField.value[0]) {
		iField.focus();
		alert("�ٽ� �Է����ּ���");
		return false;
	}
	
	return true;
}