function joinCheck() {
	var idField = document.joinForm.id;
	var pwField = document.joinForm.pw;
	var pwChkField = document.joinForm.pwChk;
	var ageField = document.joinForm.age;
	var photoField = document.joinForm.photo;
	
	// ���̵� �Ƚ�ų�, 4�ں��� ���� ��ų�, �ᵵ �Ǵ°Ǹ� �ְ� ���� �ʾҰų�
	if(isEmpty(idField) || lessThan(idField, 4) || containsHS(idField)) {
		alert("ID�� �ٽ� �Է��ϼ���");
		idField.value="";
		idField.focus();
		return false;
	}
	
	// ��й�ȣ�� �Ƚ�ų�, 4�ڸ����� ���� ��ų�, ���Ȯ���̶� ���ĭ�̶� �ٸ��� ��ų�, ���ڳ� ������� �ٸ��� ���� false ��ȯ
	if(isEmpty(pwField) || lessThan(pwField, 4) || notEqual(pwField, pwChkField) 
		|| notContains(pwField, "1234567890")
		|| notContains(pwField,"qwertyuiopasdfghjklzxcvbnm")) {
		alert("PW�� �ٽ� �Է��ϼ���");
		pwField.value = "";
		pwField.focus();
		return false;
	}
	
	// ���̸� �Ƚ�ų�, ���̸� ���ڷ� �Ƚ�ų�
	if(isEmpty(ageField) || isNotNum(ageField)) {
		alert("���̸� �ٽ� �Է��ϼ���");
		pwField.value = "";
		pwField.focus();
		return false;
	}
	
	// ��������� ���߰ų�, (png�� �ƴϰ�, jpg�� �ƴϰ�, gif�� �ƴϸ�) false ��ȯ
	if (isEmpty(photoField) || 
		(isNotType(photoField, "png") && isNotType(photoField, "jpg") && isNotType(photoField, "gif"))) {
		alert("������ �ٽ� ������ּ���");
		return false;
	}
	
	return false;
}