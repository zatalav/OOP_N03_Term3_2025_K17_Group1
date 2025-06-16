package src.main;

import src.view.menu_controller;

public class main {
    public static void main(String[] args) {
        menu_controller menu = new menu_controller();
        menu.runMenu(); // chỉ gọi menu, không xử lý gì trong main
    }
}
