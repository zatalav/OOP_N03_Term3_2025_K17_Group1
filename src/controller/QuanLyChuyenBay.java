package src.controller;

import src.database.dataQuanLyChuyenBay;
import src.model.ChuyenBay;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

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
// xoa chuyen bay
    public void xoa(){
        ChuyenBay cbxoa = null;
        System.out.println("Nhap ma chuyen bay: ");
        String maChuyenBay = sc.nextLine();
        for (ChuyenBay cb : ds) {
            if (cb.getMaChuyenBay().equals(maChuyenBay)) {
                cbxoa = cb;
                break;
            }
        }
             if (cbxoa != null) {
                ds.remove(cbxoa);
                dataQuanLyChuyenBay dao = new dataQuanLyChuyenBay();
                dao.delete(cbxoa); // truyền đối tượng ChuyenBay
                System.out.println("Đã xóa chuyến bay có mã: " + maChuyenBay);
                } else {
                    System.out.println("Không tìm thấy chuyến bay với mã: " + maChuyenBay);
                }
        }
         // Thêm dòng này ở đầu file nếu chưa có


public void loadFromDatabase() {
    ds.clear();
    dataQuanLyChuyenBay dao = new dataQuanLyChuyenBay();
    ArrayList<ChuyenBay> danhSach = dao.selectAll();
    ds.addAll(danhSach);
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

    public void sua() {
    ChuyenBay cbsua = null;
    System.out.println("Nhap ma chuyen bay: ");
    String maChuyenBay = sc.nextLine();
    for (ChuyenBay cb : ds) {
        if (cb.getMaChuyenBay().equals(maChuyenBay)) {
            cbsua = cb;
            break;
        }
    }
    if (cbsua != null) {
        // Nhập lại thông tin mới cho chuyến bay (trừ mã)
        System.out.println("Nhap ten hang moi: ");
        cbsua.setTenChuyenBay(sc.nextLine());
        System.out.println("Nhap ngay gio khoi hanh moi (dd/MM/yyyy hh:mm): ");
        Date ngayGioKhoiHanh = null;
        do {
            String ngayGioKhoiHanhStr = sc.nextLine();
            ngayGioKhoiHanh = parseDate(ngayGioKhoiHanhStr);
        } while (ngayGioKhoiHanh == null);
        cbsua.setNgayGioKhoiHanh(ngayGioKhoiHanh);
        System.out.println("Nhap so ghe trong moi: ");
        cbsua.setSoLuongGhe(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap diem khoi hanh moi: ");
        cbsua.setDiemKhoiHanh(sc.nextLine());
        System.out.println("Nhap diem den moi: ");
        cbsua.setDiemDen(sc.nextLine());
        System.out.println("Nhap noi quoc te moi: ");
        cbsua.setNoiquoc(sc.nextLine());

        // Cập nhật vào database
        dataQuanLyChuyenBay dao = new dataQuanLyChuyenBay();
        dao.update(cbsua);
        System.out.println("Đã cập nhật chuyến bay có mã: " + maChuyenBay);
    } else {
        System.out.println("Không tìm thấy chuyến bay với mã: " + maChuyenBay);
    }
}


public void timkiem(){
    System.out.println("Nhap ma chuyen bay: ");
    String maChuyenBay = sc.nextLine();
    dataQuanLyChuyenBay dao = new dataQuanLyChuyenBay();
    ArrayList<ChuyenBay> ketQua = dao.selectByCondition(maChuyenBay);
    if (!ketQua.isEmpty()) {
        for (ChuyenBay cb : ketQua) {
            System.out.println("Chuyến bay tìm thấy: " + cb);
        }
    } else {
        System.out.println("Không tìm thấy chuyến bay với mã: " + maChuyenBay);
    }

}

}
