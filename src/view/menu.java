package src.view;

import src.controller.QuanLyChuyenBay;
import java.util.Scanner;

public class menu {
    public QuanLyChuyenBay quanLy = new QuanLyChuyenBay();
    private Scanner sc = new Scanner(System.in);

    public void chayMenu() {
        int chon;
        do {
            System.out.println("\n=== MENU QUẢN LÝ CHUYẾN BAY ===");
            System.out.println("1. Thêm chuyến bay");
            System.out.println("2. Tim kiem chuyến bay");
            System.out.println("3. Sửa chuyến bay");
            System.out.println("4. Xóa chuyến bay");
            System.out.println("0. Thoát");
            System.out.print(">> Chọn chức năng: ");

            while (!sc.hasNextInt()) {
                System.out.print("Vui lòng nhập số hợp lệ: ");
                sc.next();
            }

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> quanLy.them();
                case 2 -> quanLy.timkiem();
                case 3 -> quanLy.sua();
                case 4 -> quanLy.xoa();
                case 0 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (chon != 0);
    }
}
