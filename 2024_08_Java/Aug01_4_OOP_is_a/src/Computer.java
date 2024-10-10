
public class Computer extends Product {
	String cpu;
	int ram;
	int hdd;
	
	
	public Computer() {

	}
	
	
	public Computer(String name, int price, String cpu, int ram, int hdd) {
		super(name, price);
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}


	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("CPU : " + cpu);
		System.out.println("RAM : " + ram + "GB");
		System.out.println("HDD : " + hdd + "GB");
	}
}
