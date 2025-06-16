package src.view;

import java.util.Scanner;

public class menu_controller {
    private Scanner scanner = new Scanner(System.in);
    menu_khachhang menu2 = new menu_khachhang();
    menu_chuyenbay menu1 = new menu_chuyenbay();
    menu_ve menu3= new menu_ve(); 

    public void loadAllData() {
        menu1.quanLy.loadFromDatabase();
        menu2.quanLy.loadFromDatabase();
        menu3.quanLy.loadFromDatabase();
    }

    public void runMenu() {
        int choice;
        do {
            System.out.println("***** MENU QUẢN LÍ *****");
            System.out.println("1. Quản lí chuyến bay");
            System.out.println("2. Quản lí hành khách");
            System.out.println("3. Quản lí vé");
            System.out.println("0. Thoát");
            System.out.print("Mời chọn chức năng quản lí: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Vui lòng nhập số.");
                scanner.nextLine();
                System.out.print("Mời chọn chức năng quản lí: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    menu1.menu_cb();
                    break;
                case 2:
                    menu2.menu_kh();
                    break;
                case 3:
                    menu3.menu_v();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ.");
            }
        } while (choice != 0);
    }
}
