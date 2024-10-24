function joinCheck() {
	var idField = document.joinForm.gm_id;
	var pwField = document.joinForm.gm_pw;
	var pwcField = document.joinForm.gm_pwchk;
	var jumin1Field = document.joinForm.gm_jumin1;
	var jumin2Field = document.joinForm.gm_jumin2;
	var photoField = document.joinForm.gm_photo;
	
	if (isEmpty(idField) || containsHS(idField)) {
		alert("ID를 다시 입력하세요");
		return false;
	}
	
	if (isEmpty(pwField) || notEqual(pwField, pwcField) || notContains(pwField, "1234567890")) {
		alert("PW를 다시 입력하세요");
		return false;
	}
	
	if (isEmpty(photoField) || (isNotType(photoField, "jpg") && isNotType(photoField, "png") && isNotType(photoField, "gif"))) {
		alert("프로필사진을 다시 선택하세요");
		return false;
	}
	
	//주민번호는..
	if (isEmpty(jumin1Field) || isNotNum(jumin1Field) || isNotNum(jumin2Field)
			|| lessThan(jumin1Field, 6) || lessThan(jumin2Field, 1)) {
		alert("주민번호를 다시 입력하세요");
		return false;
	}
	
	return true;
}

function loginCheck() {
	var idField = document.loginForm.gm_id;
	var pwField = document.loginForm.gm_pw;
	if (isEmpty(idField) || isEmpty(pwField)) {
		alert("?");
		idField.value = "";
		pwField.value = "";
		idField.focus();
		return false;
	}
	return true;
}

function memberUpdateCheck() {
	var pwField = document.JoinForm.gm_pw;
	var pwcField = document.JoinForm.gm_pwChk;
	var photoField = document.JoinForm.gm_photo;

	if (isEmpty(pwField) || notEqual(pwField, pwcField) ||
			notContains(pwField, "123456789") || notContains(pwField, "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM")) {
			alert("비밀번호를 다시 입력하세요");
			pwField.value = "";
			pwcField.value = "";
			pwField.focus();
			return false;
	}
	
	if (isEmpty(photoField)) {
		return true;
	}
	if (isNotType(photoField, "png") && isNotType(photoField, "gif") && isNotType(photoField, "jpg")) {
		alert("프로필사진을 다시 선택해주세요");
		return false;
	}
	
	return true;
}

function snsWriteCheck() {
	if (isEmpty(document.snsWriteForm.gs_txt)) {
		alert("다시 입력해주세요")
		return false;
	}
	
	return true;
}

function snsReplyWriteCheck(ff) {
	var txtField = ff.gsr_txt;
	if (isEmpty(txtField)) {
		alert("다시 입력해주세요");
		return false;
	}
	
	return true;
}