package src.controller;

import src.database.dataQuanLyChuyenBay;
import src.model.ChuyenBay;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class QuanLyChuyenBay extends manager<ChuyenBay> {

    // Định dạng ngày
    Date parseDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Lỗi định dạng ngày tháng: " + e.getMessage());
            return null;
        }
    }

    // Nhập chuyến bay
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

        System.out.print("Nhập tên hãng chuyến bay: ");
        String tenChuyenBay = sc.nextLine();

        Date ngayGioKhoiHanh = null;
        do {
            System.out.println("Nhap ngay gio khoi hanh (dd/MM/yyyy hh:mm): ");
            String ngayGioKhoiHanhStr = sc.nextLine();
            ngayGioKhoiHanh = parseDate(ngayGioKhoiHanhStr);
        } while (ngayGioKhoiHanh == null);

        System.out.println("Nhập số giờ bay: ");
        int ThoiGianBay = Integer.parseInt(sc.nextLine());

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

        String noiquoc;
        while (true) {
            System.out.println("Nhap noi di (I: International(quoc te), D: Domestic(trong nuoc)): ");
            noiquoc = sc.nextLine().trim().toUpperCase();
            if (noiquoc.equals("I") || noiquoc.equals("D")) {
                if (noiquoc.equals("I")) {
                    noiquoc = "Quoc te";
                    break;
                } else if (noiquoc.equals("D")) {
                    noiquoc = "Trong nuoc";
                    break;
                }
            } else {
                System.out.println("Chi duoc nhap I (quoc te) hoac D (trong nuoc). Vui long nhap lai.");
            }
        }

        int GheVip = soLuongGhe / 10;
        int GheHangNhat = 0;
        int GheThuong = 0;

        if (noiquoc.equals("Quoc te")) {
            GheHangNhat = soLuongGhe / 20;
            GheThuong = soLuongGhe - GheVip - GheHangNhat;
        } else {
            GheThuong = soLuongGhe - GheVip;
        }

        return new ChuyenBay(maChuyenBay, tenChuyenBay, ngayGioKhoiHanh, soLuongGhe, GheVip, GheHangNhat, GheThuong,
                diemKhoiHanh, diemDen, noiquoc);
    }

    // Thêm chuyến bay
    public void them() {
        ChuyenBay cb = nhap();
        ds.add(cb);
        dataQuanLyChuyenBay dao = new dataQuanLyChuyenBay();
        dao.insert(cb);
    }

    // Xóa chuyến bay
    public void xoa() {
        ChuyenBay cbxoa = null;
        System.out.println("Nhập chuyến bay: ");
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
            dao.delete(cbxoa);
            System.out.println("Đã xóa chuyến bay có mã: " + maChuyenBay);
        } else {
            System.out.println("Không tìm thấy chuyến bay với mã: " + maChuyenBay);
        }
    }

    // Truy xuất dữ liệu từ SQL sang RAM
    public void loadFromDatabase() {
        ds.clear();
        dataQuanLyChuyenBay dao = new dataQuanLyChuyenBay();
        ArrayList<ChuyenBay> danhSach = dao.selectAll();
        ds.addAll(danhSach);
    }

    // Sửa chuyến bay
    public void sua() {
        ChuyenBay cbsua = null;
        System.out.println("Nhập mã chuyến bay: ");
        String maChuyenBay = sc.nextLine();
        for (ChuyenBay cb : ds) {
            if (cb.getMaChuyenBay().equals(maChuyenBay)) {
                cbsua = cb;
                break;
            }
        }

        if (cbsua != null) {
            System.out.println("Nhập tên hãng mới: ");
            cbsua.setTenChuyenBay(sc.nextLine());

            System.out.println("Nhập ngày giờ khởi hành mới (dd/MM/yyyy hh:mm): ");
            Date ngayGioKhoiHanh = null;
            do {
                String ngayGioKhoiHanhStr = sc.nextLine();
                ngayGioKhoiHanh = parseDate(ngayGioKhoiHanhStr);
            } while (ngayGioKhoiHanh == null);
            cbsua.setNgayGioKhoiHanh(ngayGioKhoiHanh);

            System.out.println("Nhap tong thoi gian bay");
            cbsua.setThoiGianBay(sc.nextInt());

            System.out.println("Nhập số ghế trống mới: ");
            cbsua.setSoLuongGhe(Integer.parseInt(sc.nextLine()));

            System.out.println("Nhập điểm khởi hành mới: ");
            cbsua.setDiemKhoiHanh(sc.nextLine());

            System.out.println("Nhập điểm đến mới: ");
            cbsua.setDiemDen(sc.nextLine());

            String noiquoc;
            while (true) {
                System.out.println("Nhap noi di (I: International(quoc te), D: Domestic(trong nuoc)): ");
                noiquoc = sc.nextLine().trim().toUpperCase();
                if (noiquoc.equals("I") || noiquoc.equals("D")) {
                    if (noiquoc.equals("I")) {
                        noiquoc = "Quoc te";
                        break;
                    } else if (noiquoc.equals("D")) {
                        noiquoc = "Trong nuoc";
                        break;
                    }
                } else {
                    System.out.println("Chi duoc nhap I (quoc te) hoac D (trong nuoc). Vui long nhap lai.");
                }
            }

            int soLuongGhe = cbsua.getSoLuongGhe();
            int GheVip = soLuongGhe / 10;
            int GheHangNhat = 0;
            int GheThuong;

            if (noiquoc.equals("Quoc te")) {
                GheHangNhat = soLuongGhe / 20;
                GheThuong = soLuongGhe - GheVip - GheHangNhat;
            } else {
                GheThuong = soLuongGhe - GheVip;
            }

            cbsua.setGheVip(GheVip);
            cbsua.setGheHangNhat(GheHangNhat);
            cbsua.setGheThuong(GheThuong);

            dataQuanLyChuyenBay dao = new dataQuanLyChuyenBay();
            dao.update(cbsua);
            System.out.println("Đã cập nhật chuyến bay có mã: " + maChuyenBay);
        } else {
            System.out.println("Không tìm thấy chuyến bay với mã: " + maChuyenBay);
        }
    }

    // Tìm kiếm chuyến bay
    public void timkiem() {
        System.out.println("Nhập mã chuyến bay: ");
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

    // Liệt kê tất cả chuyến bay
    public void lietKe() {
        dataQuanLyChuyenBay dao = new dataQuanLyChuyenBay();
        ArrayList<ChuyenBay> danhSach = dao.selectAll();
        if (danhSach.isEmpty()) {
            System.out.println("Không có chuyến bay nào trong hệ thống.");
        } else {
            for (ChuyenBay cb : danhSach) {
                System.out.println(cb);
            }
        }
    }
}
