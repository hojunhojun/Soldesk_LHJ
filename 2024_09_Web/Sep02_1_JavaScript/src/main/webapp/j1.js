/**
 * js���� ����� euc-kr�� �ٲٴ� ���μ����� �������ô� !!
 * 
 * �⺻ ����
 * function �Լ���(������1, ������2, ...) {
 * 		return ��; // ���� ���Ͼ��ϴ���...?
 * }
 * 
 * ��� ���� : IE���� ����� Ŀ�������� Ŭ������(�� ����)
 * 
 * �ڹ� / DB / HTML
 */

// ����������Ʈ�� �������� �ʾƵ� ��
// ����� �������ҿ� Ȱ�밡���ϴٸ� �����ؾ���
function showAlerttt() {
	alert("����");
}

function gogo(a, b) {
	alert(a + b);
}

function showPrompttt() {
	var u = prompt("����");
	return u;
}

function moveee() {
	var uu = showPrompttt();
	// Get��� ��û - �ּ��̵�
	location.href = uu;
}