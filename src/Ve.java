package src;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ve {
    private String maVe;
    private String tenHanhKhach;
    private Date ngayDatVe;
    private double giaVe;
    private double giaGoc;
    private int soLuongGhe;
    private ChuyenBay chuyenBay;

    // ===== Constructor =====
    public Ve() {
    }

    // ===== Getters & Setters =====
    public String getMaVe() {
        return maVe;
    }

    public String getTenHanhKhach() {
        return tenHanhKhach;
    }

    public Date getNgayDatVe() {
        return ngayDatVe;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public double getGiaGoc() {
        return giaGoc;
    }

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public ChuyenBay getChuyenBay() {
        return chuyenBay;
    }

    public void setChuyenBay(ChuyenBay chuyenBay) {
        this.chuyenBay = chuyenBay;
    }

    // ===== Nhập thông tin vé =====
    public void nhapThongTin(Scanner sc, QuanLyChuyenBay qlChuyenBay) {
        maVe = Validator.nhapMaVe(sc);
        tenHanhKhach = InputHelper.nhapTen(sc);
        ngayDatVe = InputHelper.nhapNgay(sc);
        chuyenBay = InputHelper.nhapChuyenBay(sc, qlChuyenBay);
        giaGoc = InputHelper.nhapGiaGoc(sc);
        soLuongGhe = InputHelper.nhapSoLuongGhe(sc);
        giaVe = TinhGiaVe.tinhTongGiaVe(giaGoc, soLuongGhe);
    }

    // ===== Hiển thị thông tin =====
    public void hienThiThongTin() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("\n============= THÔNG TIN VÉ =============");
        System.out.printf("Mã vé            : %s\n", maVe);
        System.out.printf("Tên hành khách   : %s\n", tenHanhKhach);
        System.out.printf("Ngày đặt vé      : %s\n", sdf.format(ngayDatVe));
        System.out.printf("Giá gốc/ghế      : %.2f\n", giaGoc);
        System.out.printf("Số lượng ghế     : %d\n", soLuongGhe);
        System.out.printf("Tổng giá vé      : %.2f\n", giaVe);

        if (chuyenBay != null) {
            System.out.println("------ Thông tin chuyến bay ------");
            System.out.printf("Tên chuyến bay   : %s\n", chuyenBay.getTenChuyenBay());
            System.out.printf("Khởi hành        : %s\n", chuyenBay.getDiemKhoiHanh());
            System.out.printf("Điểm đến         : %s\n", chuyenBay.getDiemDen());
        } else {
            System.out.println("Chưa liên kết chuyến bay.");
        }
        System.out.println("===================================");
    }
}
