/**
 * 한글처리 완료
 */
function numCheck() {
	var xField = document.xyForm.xx;
	var yField = document.xyForm.yy;
	
	if (isEmpty(xField) || isEmpty(yField) || isNotNum(xField) || isNotNum(yField)) {
		alert("숫자를 다시 입력하세요");
		xField.value = "";
		yField.value = "";
		return false;
	}
	
	return true;
}