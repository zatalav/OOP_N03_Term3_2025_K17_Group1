package src;

import java.util.Scanner;

public class MenuController {

    private QuanLyVe quanLyVe;
    private QuanLyChuyenBay quanLyChuyenBay;
    private QuanLyKhachHang quanLyKhachHang;

    public MenuController() {
        quanLyChuyenBay = new QuanLyChuyenBay(); // 🟢 Tạo trước
        quanLyVe = new QuanLyVe(quanLyChuyenBay); // 🟢 Truyền vào QuanLyVe
        quanLyKhachHang = new QuanLyKhachHang();
    }

    public void showProgramSelection(Scanner sc) {
        int luaChon;
        do {
            System.out.println("\n===== CHỌN CHƯƠNG TRÌNH QUẢN LÝ =====");
            System.out.println("1. Quản lý chuyến bay");
            System.out.println("2. Quản lý vé");
            System.out.println("3. Quản lý khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1 : showChuyenBayMenu(sc); break;
                case 2 : showVeMenu(sc); break;
                case 3 : showKhachHangMenu(sc); break;
                case 0 : System.out.println("Thoát chương trình."); break;
                default : System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại."); break;
            }
        } while (luaChon != 0);
    }

    private void showVeMenu(Scanner sc) {
        int chon;
        do {
            System.out.println("\n--- QUẢN LÝ VÉ ---");
            System.out.println("1. Thêm vé");
            System.out.println("2. Hiển thị tất cả vé");
            System.out.println("3. Sửa vé");
            System.out.println("4. Xóa vé");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 : 
                    quanLyVe.addVe(sc); break;
                case 2 : 
                    quanLyVe.showVe(); break;
                case 3 : 
                    quanLyVe.editVe(sc); break;
                case 4 : 
                    quanLyVe.deleteVe(sc); break;
                case 0 : 
                    System.out.println("🔙 Trở lại menu chính."); break;
                default : 
                    System.out.println("Lựa chọn không hợp lệ."); break;
            }
        } while (chon != 0);
    }

    private void showKhachHangMenu(Scanner sc) {
        int chon;
        do {
            System.out.println("\n--- QUẢN LÝ KHÁCH HÀNG ---");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị tất cả khách hàng");
            System.out.println("3. Sửa khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 : quanLyKhachHang.add(); break;
                case 2 : quanLyKhachHang.show(); break;
                case 3 : quanLyKhachHang.edit(); break;
                case 4 : quanLyKhachHang.delete(); break;
                case 0 : System.out.println("🔙 Trở lại menu chính."); break;
                default : System.out.println("Lựa chọn không hợp lệ."); break;
            }
        } while (chon != 0);
    }

    private void showChuyenBayMenu(Scanner sc) {
        int chon;
        do {
            System.out.println("\n--- QUẢN LÝ CHUYẾN BAY ---");
            System.out.println("1. Thêm chuyến bay");
            System.out.println("2. Hiển thị tất cả các chuyến bay");
            System.out.println("3. Sửa chuyến bay");
            System.out.println("4. Xóa chuyến bay");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 : quanLyChuyenBay.them(); break;
                case 2 : quanLyChuyenBay.hienThiThongTin(); break;
                case 3 : quanLyChuyenBay.edit(); break;
                case 4 : quanLyChuyenBay.delete(); break;
                case 0 : System.out.println("🔙 Trở lại menu chính."); break;
                default : System.out.println("Lựa chọn không hợp lệ."); break;
            }
        } while (chon != 0);
    }
}
