/**
 * js파일 만들면 euc-kr로 바꾸는 프로세스를 가져갑시다 !!
 * 
 * 기본 형태
 * function 함수명(변수명1, 변수명2, ...) {
 * 		return 값; // 굳이 리턴안하더라도...?
 * }
 * 
 * 기술 컨셉 : IE쓰는 사람도 커버가능한 클래식웹(현 시점)
 * 
 * 자바 / DB / HTML
 */

// 최종프로젝트는 참신하지 않아도 됨
// 기술을 적재적소에 활용가능하다를 어필해야함
function showAlerttt() {
	alert("ㅎㅇ");
}

function gogo(a, b) {
	alert(a + b);
}

function showPrompttt() {
	var u = prompt("어디로");
	return u;
}

function moveee() {
	var uu = showPrompttt();
	// Get방식 요청 - 주소이동
	location.href = uu;
}