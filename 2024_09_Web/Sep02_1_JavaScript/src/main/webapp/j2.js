function arrayTesttt() {
	// Java
	//		int[] ar = {123, 11, 12};
	var ar = [123, 11, 12];
	for (var i = 0; i < ar.length; i++) {
		alert(ar[i]);
	}
}

function ooobjectTest() {
	// Java
	// Dog d = new Dog
	// d.setName("����");
	// d.setAge(3);
	// JS������ Ŭ���� ���� �����ѵ�...
	var d = { name : "����", age : 3 };
	alert(d);
	alert(d.name);
	alert(d.age);
}

function aoTest() {
	var dogs = [
		{name:"����", age : 3},
		{name:"�ұ�", age : 4},
		{name:"����", age : 5}
	];
	for (var i = 0; i < dogs.length; i++) {
		alert(dogs[i].name + " : " + dogs[i].age);
	}
}