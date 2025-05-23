package src;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ChuyenBay chuyenBay = new ChuyenBay();
        chuyenBay.nhap_thong_tin();  

        KhachHang khachHang = new KhachHang();
        khachHang.nhapThongTin(); 

        QuanLyVe quanLyVe = new QuanLyVe();
        int luaChon;

        do {
            System.out.println("\n===== MENU CHƯƠNG TRÌNH =====");
            System.out.println("1. Thêm vé");
            System.out.println("2. Hiển thị tất cả vé");
            System.out.println("3. Sửa vé");
            System.out.println("4. Xóa vé");
            System.out.println("5. Hiển thị thông tin chuyến bay");
            System.out.println("6. Hiển thị thông tin khách hàng");
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
                    chuyenBay.hienThiThongTin();
                    break;
                case 6:
                    khachHang.hienThiThongTin();
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
}
