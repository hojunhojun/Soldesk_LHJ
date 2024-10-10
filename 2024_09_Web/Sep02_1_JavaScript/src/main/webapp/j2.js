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
	// d.setName("후추");
	// d.setAge(3);
	// JS에서도 클래스 만들어서 가능한데...
	var d = { name : "후추", age : 3 };
	alert(d);
	alert(d.name);
	alert(d.age);
}

function aoTest() {
	var dogs = [
		{name:"후추", age : 3},
		{name:"소금", age : 4},
		{name:"설탕", age : 5}
	];
	for (var i = 0; i < dogs.length; i++) {
		alert(dogs[i].name + " : " + dogs[i].age);
	}
}