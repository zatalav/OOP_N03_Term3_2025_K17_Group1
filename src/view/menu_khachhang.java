package src.view;

import java.util.Scanner;
import src.controller.QuanLyKhachHang;

public class menu_khachhang {
    public QuanLyKhachHang quanLy = new QuanLyKhachHang();
    private Scanner sc = new Scanner(System.in);

    public void menu_kh() {
        int chon;
        do {
            System.out.println("\n=== MENU QUẢN LÝ KHÁCH HÀNG ===");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Tìm kiếm khách hàng ");
            System.out.println("3. Sửa khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. liệt kê khách hàng");
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
                case 2 -> quanLy.timKiem();
                case 3 -> quanLy.sua();
                case 4 -> quanLy.xoa();
                 case 5 -> quanLy.lietKe();

                case 0 -> System.out.println("🔙 Thoát chương trình.");
                default -> System.out.println("❌ Lựa chọn không hợp lệ.");
            }
        } while (chon != 0);
    }
}
