function goJoin() {
	location.href = "JoinController";
}

function logOut() {
	var really = confirm("로그아웃하시겠습니까?");
	if (really) {
		location.href = "LoginController";		
	}
}

function goMemberInfo() {
	location.href = "MemberInfoController";
}

function bye() {
	var msg = prompt("탈퇴하시려면 \"탈퇴\"를 입력해주세요");
	if (msg == "탈퇴") {
		location.href = "ByeController";
	}
}

function goNoticeDetail(no) {
	location.href = "NoticeDetailController?no=" + no;
}

function deleteNotice(no) {
	if (confirm("게시물을 삭제하시겠습니끼?")) {
		location.href = "NoticeDeleteController?no=" + no;		
	}
}