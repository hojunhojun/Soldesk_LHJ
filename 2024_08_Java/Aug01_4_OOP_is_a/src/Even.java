import java.util.Scanner;

public class Even {
    Scanner sc = new Scanner(System.in);
    
    public int nextInt(int bound) {
        int x = sc.nextInt();
        return (x % 2 == 0 && x <= bound) ? x : nextInt(bound);
    }
}
