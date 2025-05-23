package src;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ChuyenBay CB = new ChuyenBay();
        CB.nhap_thong_tin();
        CB.hienThiThongTin();
        System.out.println("Thông tin chuyến bay đã được nhập thành công.");

        KhachHang kh = new KhachHang();
        kh.nhapThongTin();
        kh.hienThiThongTin();

        VeList danhSachVe = new VeList();

        System.out.print("Nhập số lượng vé cần thêm: ");
        int soLuongVe = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soLuongVe; i++) {
            System.out.println("\n--- Nhập vé thứ " + (i + 1) + " ---");
            Ve v = new Ve();
            v.nhapThongTin();
            danhSachVe.themVe(v);
        }

        System.out.println("\n--- Danh sách vé ---");
        danhSachVe.inDanhSachVe();

        Ve timVe = danhSachVe.timVeTheoMa("VE12345");
        if (timVe != null) {
            System.out.println("\n--- Thông tin vé tìm thấy ---");
            timVe.hienThiThongTin();
        } else {
            System.out.println("\nKhông tìm thấy vé có mã VE12345.");
        }
    }
}
