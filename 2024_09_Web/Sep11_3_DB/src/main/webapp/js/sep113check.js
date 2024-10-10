function productRegCheck() {
	var nameField = document.productRegForm.name;
	var priceField = document.productRegForm.price;
	
	if (isEmpty(nameField)) {
		return false;
	}
	
	if (isEmpty(priceField) || isNotNum(priceField)) {
		return false;
	}
	return true;
}