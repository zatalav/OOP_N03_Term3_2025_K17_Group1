package src.main;

import java.util.Scanner;

import src.view.MenuController;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuController controller = new MenuController();
        controller.showProgramSelection(sc);
    }
}
