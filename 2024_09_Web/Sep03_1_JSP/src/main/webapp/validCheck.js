/**
 * �ѱ�ó�� �Ϸ�
 */
function numCheck() {
	var xField = document.xyForm.xx;
	var yField = document.xyForm.yy;
	
	if (isEmpty(xField) || isEmpty(yField) || isNotNum(xField) || isNotNum(yField)) {
		alert("���ڸ� �ٽ� �Է��ϼ���");
		xField.value = "";
		yField.value = "";
		return false;
	}
	
	return true;
}