package src;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuController controller = new MenuController();
        controller.showProgramSelection(sc);
    }
}
