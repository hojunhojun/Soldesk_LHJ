/**
 * 한글처리 X
 * 1) 최종적으로는 utf-8을 쓰자고~
 * 2) 한글쓸일없음
 */
// 어떤 웹사이트에서든 쓸수 있게 : 최대한 일반적으로

// 부정적으로 : 잘못되면 true / 잘되면 false

// input 넣었을때
// 값이 없으면 true
function isEmpty(input) {
	return !input.value;
}

// 최소글자수
function lessThan(input, len) {
	return input.value.length < len;
}

// 써도 되는것만 있게(영어대소문자, 숫자, @-_.(이메일, 전화번호 아이디 고려))
function containsHS(input) {
	var set = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890@-_.";
	for (var i = 0; i < input.value.length; i++) {
		if (set.indexOf(input.value[i]) == -1) {
			return true;
		}
	}
}

// PW이랑 PW확인이랑 다르면 true
function notEqual(input1, input2) {
	return input1.value != input2.value;
}

// input, 문자열세트
// 문자열세트중에 하나도 없으면 true
function notContains(input, set) {
	for (var i = 0; i < set.length; i++) {
		if (input.value.indexOf(set[i]) == -1) {
			return false;
		}
	}
	return true;
}

// 숫자만을 포함하는가? 숫자아닌게 있으면 true // 정수만, 띄어쓰기 금지, 숫자만, 양수만
function isNotNum(input) {
	return (isNaN(input.value) || input.value.indexOf(" ") != -1 || input.value.indexOf(".") != -1
		|| input.value.indexOf("-") != -1);
}

// 정해놓은 형식의 파일만
function isNotType(input, type) {
	type = "." + type;
	return input.value.toLowerCase().indexOf(type) == -1;
}