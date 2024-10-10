// Notebook is a Product
// Notebook is a Computer
// Product -> Computer -> Notebook
public class Notebook extends Computer {
	double weight;
	int battery;
	
	public Notebook() {

	}
	
	
	public Notebook(String name, int price, String cpu, int ram, int hdd, double weight, int battery) {
		super(name, price, cpu, ram, hdd);
		this.weight = weight;
		this.battery = battery;
	}


	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("무게 : " + weight + "kg");
		System.out.println("배터리 : " + battery + "시간");
	}
}
