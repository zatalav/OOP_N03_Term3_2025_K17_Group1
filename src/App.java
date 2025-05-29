package src;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ChuyenBay1 chuyenBay1 = new ChuyenBay1();
        chuyenBay1.nhap_thong_tin();  

        QuanLyVe quanLyVe = new QuanLyVe();
        QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
        QuanLyChuyenBay quanLyChuyenBay = new QuanLyChuyenBay();

        int luaChon;

        do {
            System.out.println("\n===== MENU CHƯƠNG TRÌNH =====");
            System.out.println("1. Thêm vé");
            System.out.println("2. Hiển thị tất cả vé");
            System.out.println("3. Sửa vé");
            System.out.println("4. Xóa vé");
            System.out.println("5. Quản lý chuyến bay");
            System.out.println("6. Quản lý khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = sc.nextInt();
            sc.nextLine(); 

            switch (luaChon) {
                case 1:
                    quanLyVe.addVe(sc);
                    break;
                case 2:
                    quanLyVe.showVe();
                    break;
                case 3:
                    quanLyVe.editVe(sc);
                    break;
                case 4:
                    quanLyVe.deleteVe(sc);
                    break;
                case 5:
                    menuChuyenBay(sc, quanLyChuyenBay);
                    break;
                case 6:
                    menuKhachHang(sc, quanLyKhachHang);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (luaChon != 0);

        sc.close();
    }

    public static void menuKhachHang(Scanner sc, QuanLyKhachHang qlkh) {
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
                case 1:
                    qlkh.addKhachHang(sc);
                    break;
                case 2:
                    qlkh.showKhachHang();
                    break;
                case 3:
                    qlkh.editKhachHang(sc);
                    break;
                case 4:
                    qlkh.deleteKhachHang(sc);
                    break;
                case 0:
                    System.out.println("🔙 Trở lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (chon != 0);
    }

    public static void menuChuyenBay(Scanner sc, QuanLyChuyenBay qlcb) {
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
                case 1:
                    qlcb.addChuyenBay(sc);
                    break;
                case 2:
                    qlcb.showChuyenBay();
                    break;
                case 3:
                    qlcb.editChuyenBay(sc);
                    break;
                case 4:
                   qlcb.deleteChuyenBay(sc);
                    break;
                case 0:
                    System.out.println("🔙 Trở lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (chon != 0);
    }
}
