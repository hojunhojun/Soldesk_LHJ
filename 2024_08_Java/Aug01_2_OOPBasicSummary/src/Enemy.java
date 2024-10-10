import java.util.Random;

public class Enemy {
	
	Random brain = new Random();
	
	public Enemy() {
		brain = new Random();
	}
	
	public int submit() {
		return brain.nextInt(3)+1;
	}
}
