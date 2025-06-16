package src.controller;

import src.database.dataQuanLyChuyenBay;
import src.model.ChuyenBay;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class QuanLyChuyenBay extends manager<ChuyenBay> {
    public String regex = "^CB\\d{3}$";

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
        loadFromDatabase();
        String maChuyenBay;
        while (true) {
            System.out.print("Nhập mã chuyến bay: ");
            maChuyenBay = sc.nextLine();
            if(!maChuyenBay.matches("^CB\\d{3}$")){
                System.out.println("Sai định dạng mã(VD: CB001). Nhập lại: ");
            }
            else if (kiemTraMaTrung(maChuyenBay)) {
                System.out.println("Mã chuyến bay đã tồn tại, vui lòng nhập lại.");
            } else
                break;
        }

        System.out.print("Nhập tên hãng chuyến bay: ");
        String tenChuyenBay = sc.nextLine();

        Date ngayGioKhoiHanh = null;
        do {
            System.out.println("Nhập ngày giờ khởi hành (dd/MM/yyyy hh:mm): ");
            String ngayGioKhoiHanhStr = sc.nextLine();
            ngayGioKhoiHanh = parseDate(ngayGioKhoiHanhStr);
        } while (ngayGioKhoiHanh == null);

        int ThoiGianBay = 0;
        while (true) {
            System.out.println("Nhập số giờ bay: ");
            try {
                ThoiGianBay = Integer.parseInt(sc.nextLine());
                if (ThoiGianBay <= 0) {
                    System.out.println("Số giờ bay phải lớn hơn 0, vui lòng nhập lại.");
                }else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ, vui lòng nhập số nguyên.");
            }
        }

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
            System.out.println("Nhập nơi đi (I: International(quốc tế), D: Domestic(trong nước)): ");
            noiquoc = sc.nextLine().trim().toUpperCase();
            if (noiquoc.equals("I") || noiquoc.equals("D")) {
                if (noiquoc.equals("I")) {
                    noiquoc = "Quốc tế";
                    break;
                } else if (noiquoc.equals("D")) {
                    noiquoc = "Trong nước";
                    break;
                }
            } else {
                System.out.println("Chỉ được nhập I (quốc tế) hoặc D (trong nước). Vui lòng nhập lại.");
            }
        }

        int GheVip = soLuongGhe / 10;
        int GheHangNhat = 0;
        int GheThuong = 0;

        if (noiquoc.equals("Quốc tế")) {
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
        loadFromDatabase();
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
        loadFromDatabase();
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

            int ThoiGianBay = 0;
            while (true) {
                System.out.println("Nhập số giờ bay: ");
                try {
                    ThoiGianBay = Integer.parseInt(sc.nextLine());
                    if (ThoiGianBay <= 0) {
                        System.out.println("Số giờ bay phải lớn hơn 0, vui lòng nhập lại.");
                    } else {
                        cbsua.setThoiGianBay(ThoiGianBay);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Dữ liệu không hợp lệ, vui lòng nhập số nguyên.");
                }
            }

            int soLuongGhe = 0;
            while (true) {
                System.out.println("Nhập số ghế trống: ");
                try {
                    soLuongGhe = Integer.parseInt(sc.nextLine());
                    if (soLuongGhe < 0) {
                        System.out.println("Số lượng ghế không được âm, vui lòng nhập lại.");
                    } else {
                        cbsua.setSoLuongGhe(soLuongGhe);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Dữ liệu không hợp lệ, vui lòng nhập số nguyên.");
                }
            }

            System.out.println("Nhập điểm khởi hành mới: ");
            cbsua.setDiemKhoiHanh(sc.nextLine());

            System.out.println("Nhập điểm đến mới: ");
            cbsua.setDiemDen(sc.nextLine());

            String noiquoc;
            while (true) {
                System.out.println("Nhập nơi di (I: International(quốc tế), D: Domestic(trong nước)): ");
                noiquoc = sc.nextLine().trim().toUpperCase();
                if (noiquoc.equals("I") || noiquoc.equals("D")) {
                    if (noiquoc.equals("I")) {
                        noiquoc = "Quốc tế";
                        break;
                    } else if (noiquoc.equals("D")) {
                        noiquoc = "Trong nước";
                        break;
                    }
                } else {
                    System.out.println("Chỉ được nhập I (quốc tế) hoặc D (trong nước). Vui lòng nhập lại.");
                }
            }

            int GheVip = soLuongGhe / 10;
            int GheHangNhat = 0;
            int GheThuong;

            if (noiquoc.equals("Quốc tế")) {
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
        loadFromDatabase();
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
        loadFromDatabase();
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
