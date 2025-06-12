package src.controller.qlve;

import java.util.ArrayList;
import java.util.Scanner;
import src.controller.QuanLyChuyenBay;
import src.model.Ve;

public class QuanLyVe {
    private ArrayList<Ve> danhSachVe = new ArrayList<>();
    private QuanLyChuyenBay qlChuyenBay;

    public QuanLyVe(QuanLyChuyenBay qlChuyenBay) {
        this.qlChuyenBay = qlChuyenBay;
    }

    // Thêm vé mới
    public void addVe(Scanner sc) {
        Ve ve = new Ve();
        ve.nhapThongTin(sc, qlChuyenBay);
        danhSachVe.add(ve);
        System.out.println("Đã thêm vé thành công!");
    }

    // Sửa thông tin vé
    public void editVe(Scanner sc) {
        System.out.print("Nhập mã vé cần sửa: ");
        String maVe = sc.nextLine().trim();

        for (int i = 0; i < danhSachVe.size(); i++) {
            Ve ve = danhSachVe.get(i);
            if (ve.getMaVe().equalsIgnoreCase(maVe)) {
                System.out.println("Nhập thông tin mới cho vé:");
                Ve veMoi = new Ve();
                veMoi.nhapThongTin(sc, qlChuyenBay);
                danhSachVe.set(i, veMoi);
                System.out.println("Đã sửa vé thành công!");
                return;
            }
        }

        System.out.println("Không tìm thấy mã vé này!");
    }

    // Xoá vé theo mã
    public void deleteVe(Scanner sc) {
        System.out.print("🗑 Nhập mã vé cần xóa: ");
        String maVe = sc.nextLine().trim();

        for (int i = 0; i < danhSachVe.size(); i++) {
            if (danhSachVe.get(i).getMaVe().equalsIgnoreCase(maVe)) {
                danhSachVe.remove(i);
                System.out.println("Đã xóa vé thành công!");
                return;
            }
        }

        System.out.println("Không tìm thấy mã vé này!");
    }

    // Hiển thị toàn bộ vé
    public void showVe() {
        if (danhSachVe.isEmpty()) {
            System.out.println("Danh sách vé đang rỗng.");
            return;
        }

        int index = 1;
        for (Ve ve : danhSachVe) {
            System.out.println("\n===== Vé số " + index++ + " =====");
            ve.hienThiThongTin();

            if (ve.getChuyenBay() != null) {
                System.out.println("Thông tin chuyến bay liên kết:");
                System.out.println(ve.getChuyenBay().toString());
            } else {
                System.out.println("Chưa liên kết chuyến bay.");
            }

            System.out.println("--------------------------------------------------");
        }
    }

    // Getter
    public ArrayList<Ve> getDanhSachVe() {
        return danhSachVe;
    }
}
