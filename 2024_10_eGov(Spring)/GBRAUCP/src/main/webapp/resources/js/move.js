function joinGo() {
	location.href="join.go";
}

function logOut() {
	var really = confirm("로그아웃하시겠습니까?");
	if (really) {
		location.href = "logout.do";		
	}
}

function memberInfoGo() {
	location.href = "member.info.go";
}

function bye() {
	var msg = prompt("탈퇴하시려면 \"탈퇴\"를 입력해주세요");
	if (msg == "탈퇴") {
		location.href = "bye.do";
	}
}

function snsPageTest(page) {
	location.href="sns.page.change?page=" + page;
}

function snsPostDelete(no, page) {
	if (confirm("정말 삭제하시겠습니까")) {
		location.href="sns.post.delete?gs_no=" + no + "&page=" + page;
	}
}

function snsPostUpdate(no, txt, page) {
	txt = prompt("수정할 내용 입력", txt); // 줄바꾸기 불가
	if (txt != null && txt.length > 0 && txt.length <= 450) {
		location.href="sns.post.update?gs_no=" + no + "&gs_txt=" + txt + "&page=" + page;
	}
}

function snsReplyUpdate(no, txt) {
	txt = prompt("수정할 내용 입력", txt); // 줄바꾸기 불가
	if (txt != null && txt.length > 0 && txt.length <= 150) {
		location.href="sns.reply.update?gsr_no=" + no + "&gsr_txt=" + txt;
	}
}

function snsReplyDelete(no) {
	if (confirm("정말 삭제하시겠습니까")) {
		location.href="sns.reply.delete?gsr_no=" + no;
	}
}

function photoDelete(no) {
	if (confirm("정말 삭제하시겠습니까")) {
		location.href="photo.delete.do?p_no=" + no;
	}
}

function dataDelete(no) {
	if (confirm("정말 삭제하시겠습니까")) {
		location.href="data.delete.do?gd_no=" + no;
	}	
}