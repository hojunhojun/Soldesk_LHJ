function joinCheck() {
	var idField = document.JoinForm.id;
	var pwField = document.JoinForm.pw;
	var pwcField = document.JoinForm.pwChk;
	var nField = document.JoinForm.name;
	var photoField = document.JoinForm.photo;

	// ID에 한글못쓰게 : 근데 요즘에는 됨(그래서 사회적약속..)
	// 		id저장 -> cookie
	//		cookie에 한글을 바로 저장이 안됨, URL인코딩으로 바꿔서 넣어야
	//		귀찮아서
	if (isEmpty(idField) || containsHS(idField)) {
		alert("ID를 다시 입력하세요");
		idField.value = "";
		idField.focus();
		return false;
	}

	if (isEmpty(pwField) || notEqual(pwField, pwcField) ||
		notContains(pwField, "123456789") || notContains(pwField, "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM")) {
		alert("비밀번호를 다시 입력하세요");
		pwField.value = "";
		pwcField.value = "";
		pwField.focus();
		return false;
	}

	if (isEmpty(nField)) {
		return false;
	}

	if (isNotType(photoField, "png") && isNotType(photoField, "gif") && isNotType(photoField, "jpg")) {
		alert("프로필 사진을 다시 선택해주세요");
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
			alert("비밀번호를 다시 입력하세요");
			pwField.value = "";
			pwcField.value = "";
			pwField.focus();
			return false;
	}
	
	if (isEmpty(nField)) {
		alert("이름을 다시 입력하세요");
		return false;
	}
	
	// 프사가 필수x(프사 안바꿀거면 선택 안하게)
	// 근데 선택할거면 사진 파일만(프사 바꿀거면 선택할거)
	// ->  선택을 하지말든지, 할거면 사진 파일만
	if (isEmpty(photoField)) {
		return true;
	}
	if (isNotType(photoField, "png") && isNotType(photoField, "gif") && isNotType(photoField, "jpg")) {
		alert("프로필사진을 다시 선택해주세요");
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
		alert("다시 입력해주세요");
		titleField.focus();
		return false;
	}
	
	return true;
}

function noticeRelplyWriteCheck() {
	var txtField = document.noticeReplyWriteForm.txt 
	
	if (isEmpty(txtField)) {
		alert("어이가 없네");
		return false;
	}
	return true;
}