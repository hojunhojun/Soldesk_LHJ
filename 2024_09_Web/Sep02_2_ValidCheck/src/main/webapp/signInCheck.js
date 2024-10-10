function joinCheck() {
	var idField = document.joinForm.id;
	var pwField = document.joinForm.pw;
	var pwChkField = document.joinForm.pwChk;
	var ageField = document.joinForm.age;
	var photoField = document.joinForm.photo;
	
	// 아이디를 안썼거나, 4자보다 적게 썼거나, 써도 되는건만 있게 하지 않았거나
	if(isEmpty(idField) || lessThan(idField, 4) || containsHS(idField)) {
		alert("ID를 다시 입력하세요");
		idField.value="";
		idField.focus();
		return false;
	}
	
	// 비밀번호를 안썼거나, 4자리보다 적게 썼거나, 비번확인이랑 비번칸이랑 다르게 썼거나, 숫자나 영어외의 다른걸 쓰면 false 반환
	if(isEmpty(pwField) || lessThan(pwField, 4) || notEqual(pwField, pwChkField) 
		|| notContains(pwField, "1234567890")
		|| notContains(pwField,"qwertyuiopasdfghjklzxcvbnm")) {
		alert("PW을 다시 입력하세요");
		pwField.value = "";
		pwField.focus();
		return false;
	}
	
	// 나이를 안썼거나, 나이를 숫자로 안썼거나
	if(isEmpty(ageField) || isNotNum(ageField)) {
		alert("나이를 다시 입력하세요");
		pwField.value = "";
		pwField.focus();
		return false;
	}
	
	// 사진등록을 안했거나, (png도 아니고, jpg도 아니고, gif도 아니면) false 반환
	if (isEmpty(photoField) || 
		(isNotType(photoField, "png") && isNotType(photoField, "jpg") && isNotType(photoField, "gif"))) {
		alert("사진을 다시 등록해주세요");
		return false;
	}
	
	return false;
}