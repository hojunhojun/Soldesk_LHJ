function goJoin() {
	location.href = "JoinController";
}

function logOut() {
	var really = confirm("�α׾ƿ��Ͻðڽ��ϱ�?");
	if (really) {
		location.href = "LoginController";		
	}
}

function goMemberInfo() {
	location.href = "MemberInfoController";
}

function bye() {
	var msg = prompt("Ż���Ͻ÷��� \"Ż��\"�� �Է����ּ���");
	if (msg == "Ż��") {
		location.href = "ByeController";
	}
}

function goNoticeDetail(no) {
	location.href = "NoticeDetailController?no=" + no;
}

function deleteNotice(no) {
	if (confirm("�Խù��� �����Ͻðڽ��ϳ�?")) {
		location.href = "NoticeDeleteController?no=" + no;		
	}
}