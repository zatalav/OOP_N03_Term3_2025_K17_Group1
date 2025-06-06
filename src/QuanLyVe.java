package src;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyVe {
    private ArrayList<Ve> danhSachVe = new ArrayList<>();
    private QuanLyChuyenBay qlChuyenBay;

    public QuanLyVe(QuanLyChuyenBay qlChuyenBay) {
        this.qlChuyenBay = qlChuyenBay;
    }

    public void addVe(Scanner sc) {
        Ve ve = new Ve();
        ve.nhapThongTin(sc, qlChuyenBay); // truyền đúng scanner + quản lý chuyến bay
        danhSachVe.add(ve);
        System.out.println("Đã thêm vé thành công!");
    }

    public void editVe(Scanner sc) {
        System.out.print("Nhập mã vé cần sửa: ");
        String maVe = sc.nextLine().trim();

        for (int i = 0; i < danhSachVe.size(); i++) {
            if (danhSachVe.get(i).getMaVe().equalsIgnoreCase(maVe)) {
                System.out.println("Nhập thông tin mới cho vé:");
                Ve veMoi = new Ve();
                veMoi.nhapThongTin(sc, qlChuyenBay); // sửa đúng theo hàm mới
                danhSachVe.set(i, veMoi);
                System.out.println("Đã sửa vé thành công!");
                return;
            }
        }

        System.out.println("Không tìm thấy mã vé này!");
    }

    public void deleteVe(Scanner sc) {
        System.out.print("Nhập mã vé cần xóa: ");
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

    public void showVe() {
        if (danhSachVe.isEmpty()) {
            System.out.println("Danh sách vé đang rỗng.");
            return;
        }

        int index = 1;
        for (Ve ve : danhSachVe) {
            System.out.println("\nVé số " + index++ + ":");
            ve.hienThiThongTin();

            if (ve.getChuyenBay() != null) {
                System.out.println("Thông tin chuyến bay:");
                System.out.println(ve.getChuyenBay().toString());
            } else {
                System.out.println("Chưa liên kết chuyến bay.");
            }

            System.out.println("--------------------------------------------------");
        }
    }

    public ArrayList<Ve> getDanhSachVe() {
        return danhSachVe;
    }
}
