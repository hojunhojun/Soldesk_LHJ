function joinCheck() {
	var idField = document.JoinForm.id;
	var pwField = document.JoinForm.pw;
	var pwcField = document.JoinForm.pwChk;
	var nField = document.JoinForm.name;
	var photoField = document.JoinForm.photo;

	// ID�� �ѱ۸����� : �ٵ� ���򿡴� ��(�׷��� ��ȸ�����..)
	// 		id���� -> cookie
	//		cookie�� �ѱ��� �ٷ� ������ �ȵ�, URL���ڵ����� �ٲ㼭 �־��
	//		�����Ƽ�
	if (isEmpty(idField) || containsHS(idField)) {
		alert("ID�� �ٽ� �Է��ϼ���");
		idField.value = "";
		idField.focus();
		return false;
	}

	if (isEmpty(pwField) || notEqual(pwField, pwcField) ||
		notContains(pwField, "123456789") || notContains(pwField, "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM")) {
		alert("��й�ȣ�� �ٽ� �Է��ϼ���");
		pwField.value = "";
		pwcField.value = "";
		pwField.focus();
		return false;
	}

	if (isEmpty(nField)) {
		return false;
	}

	if (isNotType(photoField, "png") && isNotType(photoField, "gif") && isNotType(photoField, "jpg")) {
		alert("������ ������ �ٽ� �������ּ���");
		photoField.value = "";
		return false;
	}

	return true;
}

function loginCheck() {
	var idField = document.loginForm.id;
	var pwField = document.loginForm.pw;

	if (isEmpty(idField) || isEmpty(pwField)) {
		idField.value = "";
		pwField.value = "";
		idField.focus();
		return false;
	}

	return true;
}

function memberUpdateCheck() {
	var pwField = document.JoinForm.pw;
	var pwcField = document.JoinForm.pwChk;
	var nField = document.JoinForm.name;
	var photoField = document.JoinForm.photo;

	if (isEmpty(pwField) || notEqual(pwField, pwcField) ||
			notContains(pwField, "123456789") || notContains(pwField, "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM")) {
			alert("��й�ȣ�� �ٽ� �Է��ϼ���");
			pwField.value = "";
			pwcField.value = "";
			pwField.focus();
			return false;
	}
	
	if (isEmpty(nField)) {
		alert("�̸��� �ٽ� �Է��ϼ���");
		return false;
	}
	
	// ���簡 �ʼ�x(���� �ȹٲܰŸ� ���� ���ϰ�)
	// �ٵ� �����ҰŸ� ���� ���ϸ�(���� �ٲܰŸ� �����Ұ�)
	// ->  ������ ����������, �ҰŸ� ���� ���ϸ�
	if (isEmpty(photoField)) {
		return true;
	}
	if (isNotType(photoField, "png") && isNotType(photoField, "gif") && isNotType(photoField, "jpg")) {
		alert("�����ʻ����� �ٽ� �������ּ���");
		return false;
	}
	
	return true;
}

function noticeWriteCheck() {
	var titleField = document.NoticeWriteForm.title;
	var txtField = document.NoticeWriteForm.txt;
	
	if (isEmpty(titleField) || isEmpty(txtField)) {
		return false;
	}
	return true;
}

function noticeUpdateCheck() {
	var titleField = document.NoticeWriteForm.title;
	var txtField = document.NoticeWriteForm.txt;
		
	if (isEmpty(titleField) || isEmpty(txtField)) {
		alert("�ٽ� �Է����ּ���");
		titleField.focus();
		return false;
	}
	
	return true;
}

function noticeRelplyWriteCheck() {
	var txtField = document.noticeReplyWriteForm.txt 
	
	if (isEmpty(txtField)) {
		alert("���̰� ����");
		return false;
	}
	return true;
}