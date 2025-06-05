package src;

import java.util.Scanner;

public class QuanLyKhachHang extends manager<KhachHang> {

    @Override
    protected KhachHang nhap() {
        KhachHang kh = new KhachHang();
        kh.nhapThongTin();
        return kh;
    }

    public static void main(String[] args) {
        QuanLyKhachHang ql = new QuanLyKhachHang();
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Sửa khách hàng");
            System.out.println("3. Xóa khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    ql.add();
                    break;
                case 2:
                    System.out.print("Nhập mã khách hàng cần sửa: ");
                    ql.edit();
                    break;
                case 3:
                    System.out.print("Nhập mã khách hàng cần xóa: ");
                    ql.delete();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (chon != 0);

        ql.close();
        sc.close();
    }
}
