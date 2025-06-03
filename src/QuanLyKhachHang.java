package src;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyKhachHang {
    private ArrayList<KhachHang> danhSachKH = new ArrayList<>();

    public void addKhachHang(Scanner sc) {
        KhachHang kh = new KhachHang();
        kh.nhapThongTin();
        danhSachKH.add(kh);
        System.out.println("Đã thêm khách hàng thành công!");
    }

    public void editKhachHang(Scanner sc) {
        System.out.print("Nhập mã khách hàng cần sửa: ");
        String maKH = sc.nextLine();
        for (int i = 0; i < danhSachKH.size(); i++) {
            if (danhSachKH.get(i).getMaKhachHang().equals(maKH)) {
                System.out.println("Nhập thông tin mới cho khách hàng:");
                KhachHang khMoi = new KhachHang();
                khMoi.nhapThongTin();
                danhSachKH.set(i, khMoi);
                System.out.println("Đã sửa khách hàng thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã khách hàng này!");
    }

    public void deleteKhachHang(Scanner sc) {
        System.out.print("Nhập mã khách hàng cần xóa: ");
        String maKH = sc.nextLine();
        for (int i = 0; i < danhSachKH.size(); i++) {
            if (danhSachKH.get(i).getMaKhachHang().equals(maKH)) {
                danhSachKH.remove(i);
                System.out.println("Đã xóa khách hàng thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã khách hàng này!");
    }

    public void showKhachHang() {
        if (danhSachKH.isEmpty()) {
            System.out.println("Danh sách khách hàng rỗng.");
            return;
        }

        for (int i = 0; i < danhSachKH.size(); i++) {
            System.out.println("Khách hàng số " + (i + 1) + ":");
            danhSachKH.get(i).hienThiThongTin();
            System.out.println("------------------------------");
        }
    }
}