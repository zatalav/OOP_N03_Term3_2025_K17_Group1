package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuanLyChuyenBay {
    private List<ChuyenBay> danhSachChuyenBay = new ArrayList<>();

    public List<ChuyenBay> getDanhSachChuyenBay() {
        return danhSachChuyenBay;
    }

    public void addChuyenBay(Scanner scanner) {
        String ma = scanner.nextLine();
        String ten = scanner.nextLine();
        String ngayGioStr = scanner.nextLine();
        int soGhe = Integer.parseInt(scanner.nextLine());
        String diemKH = scanner.nextLine();
        String diemDen = scanner.nextLine();

        Date ngayGio = null;
        try {
            ngayGio = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(ngayGioStr);
        } catch (ParseException e) {
            System.out.println("Sai định dạng ngày giờ!");
        }

        ChuyenBay cb = new ChuyenBay(ma, ten, ngayGio, soGhe, diemKH, diemDen);
        danhSachChuyenBay.add(cb);
        System.out.println("Đã thêm chuyến bay thành công!");
    }

    public void deleteChuyenBay(Scanner scanner) {
        String ma = scanner.nextLine();
        boolean removed = danhSachChuyenBay.removeIf(cb -> cb.getMaChuyenBay().equals(ma));
        if (removed) {
            System.out.println("Đã xóa chuyến bay thành công!");
        } else {
            System.out.println("Không tìm thấy mã chuyến bay này!");
        }
    }

    public void showChuyenBay() {
        if (danhSachChuyenBay.isEmpty()) {
            System.out.println("Danh sách chuyến bay rỗng.");
        } else {
            int i = 1;
            for (ChuyenBay cb : danhSachChuyenBay) {
                System.out.println("Chuyến bay số " + i++ + ":");
                cb.hienThiThongTin();
            }
        }
    }

    // Sửa chuyến bay: chỉ cập nhật thông tin, không thêm mới
    public void editChuyenBay(Scanner scanner) {
        String ma = scanner.nextLine();
        for (ChuyenBay cb : danhSachChuyenBay) {
            if (cb.getMaChuyenBay().equals(ma)) {
                System.out.print("Nhập tên chuyến bay mới: ");
                cb.setTenChuyenBay(scanner.nextLine());

                System.out.print("Nhập ngày giờ khởi hành mới (dd-MM-yyyy HH:mm): ");
                String ngayGioStr = scanner.nextLine();
                try {
                    Date ngayGio = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(ngayGioStr);
                    cb.setNgayGioKhoiHanh(ngayGio);
                } catch (ParseException e) {
                    System.out.println("Sai định dạng ngày giờ! Giữ nguyên cũ.");
                }

                System.out.print("Nhập số lượng ghế mới: ");
                cb.setSoLuongGhe(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập điểm khởi hành mới: ");
                cb.setDiemKhoiHanh(scanner.nextLine());

                System.out.print("Nhập điểm đến mới: ");
                cb.setDiemDen(scanner.nextLine());

                System.out.println("Đã cập nhật chuyến bay thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã chuyến bay này để cập nhật.");
    }
}