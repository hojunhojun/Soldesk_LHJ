package com.lhj.LMP1.main;

public class HomeController {
    public static void main(String[] args) {
        ConsoleScreen cs = new ConsoleScreen();
        
        String addr;
        while (true) {
			addr = cs.showInputAddr();
			cs.showWeather(addr);
			cs.show(addr);
			break;
        }
    }
}
