package src;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyChuyenBay {
    private ArrayList<ChuyenBay> danhSachChuyenBay = new ArrayList<>();

    public void addChuyenBay(Scanner sc) {
        ChuyenBay cb = new ChuyenBay();
        cb.nhap_thong_tin();
        danhSachChuyenBay.add(cb);
        System.out.println("Đã thêm chuyến bay thành công!");
    }

    public void editChuyenBay(Scanner sc) {
        System.out.print("Nhập mã chuyến bay cần sửa: ");
        String maCB = sc.nextLine();
        for (int i = 0; i < danhSachChuyenBay.size(); i++) {
            if (danhSachChuyenBay.get(i).getMaChuyenBay().equals(maCB)) {
                System.out.println("Nhập thông tin mới cho chuyến bay:");
                ChuyenBay cbMoi = new ChuyenBay();
                cbMoi.nhap_thong_tin();
                danhSachChuyenBay.set(i, cbMoi);
                System.out.println("Đã sửa chuyến bay thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã chuyến bay này!");
    }

    public void deleteChuyenBay(Scanner sc) {
        System.out.print("Nhập mã chuyến bay cần xóa: ");
        String maCB = sc.nextLine();
        for (int i = 0; i < danhSachChuyenBay.size(); i++) {
            if (danhSachChuyenBay.get(i).getMaChuyenBay().equals(maCB)) {
                danhSachChuyenBay.remove(i);
                System.out.println("Đã xóa chuyến bay thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã chuyến bay này!");
    }

    public void showChuyenBay() {
        if (danhSachChuyenBay.isEmpty()) {
            System.out.println("Danh sách chuyến bay rỗng.");
            return;
        }
        for (int i = 0; i < danhSachChuyenBay.size(); i++) {
            System.out.println("Chuyến bay số " + (i + 1) + ":");
            danhSachChuyenBay.get(i).hienThiThongTin();
            System.out.println("--------------------------------");
        }
    }
}