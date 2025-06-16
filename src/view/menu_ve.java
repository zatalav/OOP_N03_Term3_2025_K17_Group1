package src.view;

import java.util.Scanner;
import src.controller.QuanLyVe;

public class menu_ve {
    public QuanLyVe quanLy = new QuanLyVe();
    private Scanner sc = new Scanner(System.in);

    public void menu_v() {
        int chon;
        do {
            System.out.println("\n=== MENU QUẢN LÝ VÉ ===");
            System.out.println("1. Thêm vé");
            System.out.println("2. Tìm kiếm vé ");
            System.out.println("3. Sửa vé");
            System.out.println("4. Xóa vé");
            System.out.println("5. liệt kê vé");
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
                 case 5 -> quanLy.lietKe();

                case 0 -> System.out.println("🔙 Thoát chương trình.");
                default -> System.out.println("❌ Lựa chọn không hợp lệ.");
            }
        } while (chon != 0);
    }
}
