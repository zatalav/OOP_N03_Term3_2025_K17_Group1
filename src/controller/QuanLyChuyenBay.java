package src.controller;

import src.database.dataQuanLyChuyenBay;
import src.model.ChuyenBay;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuanLyChuyenBay extends manager<ChuyenBay> {

    // Định dạng ngày
    private Date parseDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Lỗi định dạng ngày tháng: " + e.getMessage());
            return null;
        }
    }

    // Nhập 1 chuyến bay
    public ChuyenBay nhap() {
        String maChuyenBay;
        while (true) {
            System.out.print("Nhập mã chuyến bay: ");
            maChuyenBay = sc.nextLine();
            if (kiemTraMaTrung(maChuyenBay)) {
                System.out.println("Mã chuyến bay đã tồn tại, vui lòng nhập lại.");
            } else
                break;
        }

        System.out.print("Nhập tên chuyến bay: ");
        String tenChuyenBay = sc.nextLine();

        Date ngayGioKhoiHanh = null;
        do {
            System.out.println("Nhap ngay gio khoi hanh (dd/MM/yyyy hh:mm): ");
            String ngayGioKhoiHanhStr = sc.nextLine();
            ngayGioKhoiHanh = parseDate(ngayGioKhoiHanhStr);
        } while (ngayGioKhoiHanh == null);

        int soLuongGhe;
        while (true) {
            System.out.print("Nhập số ghế trống: ");
            try {
                soLuongGhe = Integer.parseInt(sc.nextLine());
                if (soLuongGhe >= 0)
                    break;
                else
                    System.out.println("Số ghế phải >= 0.");
            } catch (NumberFormatException e) {
                System.out.println(" Nhập sai định dạng. Vui lòng nhập số nguyên.");
            }
        }

        System.out.print("Nhập điểm khởi hành: ");
        String diemKhoiHanh = sc.nextLine();

        System.out.print("Nhập điểm đến: ");
        String diemDen = sc.nextLine();

        System.out.println("Nhap noi quoc te: ");
        String noiquoc = sc.nextLine();

        return new ChuyenBay(maChuyenBay, tenChuyenBay, ngayGioKhoiHanh, soLuongGhe, diemKhoiHanh, diemDen,noiquoc);
    }

    // Thêm chuyến bay
    public void them() {
        ChuyenBay cb = nhap();      // Nhập chuyến bay từ bàn phím
        ds.add(cb);                 // Thêm vào danh sách tạm thời (RAM)
        // Lưu vào MySQL
        dataQuanLyChuyenBay dao = new dataQuanLyChuyenBay();
        dao.insert(cb);
    }

    // Sửa chuyến bay theo mã
    public void sua(String maChuyenBay){
        edit();
    }

    // Xóa chuyến bay theo mã
    public void xoa(String maChuyenBay){
        delete();
    }

    // Hiển thị danh sách
    public void hienThiThongTin() {
        for (ChuyenBay chuyenBay : ds) {
            System.out.println(chuyenBay.toString());
        }
    }

    // Tìm chuyến bay theo mã
    public ChuyenBay timTheoMa(String ma) {
        for (ChuyenBay cb : ds) {
            if (cb.getMaChuyenBay().equalsIgnoreCase(ma)) {
                return cb;
            }
        }
        return null;
    }
}
