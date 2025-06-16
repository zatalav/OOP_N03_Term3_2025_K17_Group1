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
            System.out.println("5. liet ke chuyến bay");
            System.out.println("0. Thoát");
            System.out.print(">> Chọn chức năng: ");

            while (!sc.hasNextInt()) {
                System.out.print("Vui lòng nhập số hợp lệ: ");
                sc.next();
            }

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 : quanLy.them(); break;
                case 2 : quanLy.timkiem();break;
                case 3 : quanLy.sua();break;
                case 4 : quanLy.xoa();break;
                case 5 : quanLy.lietKe();break;
                case 0 : System.out.println("🔙 Thoát chương trình.");break;
                default : System.out.println("❌ Lựa chọn không hợp lệ.");break;
            }
        } while (chon != 0);
    }
}
