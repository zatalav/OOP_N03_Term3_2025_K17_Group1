package src.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import src.controller.QuanLyChuyenBay;
import src.controller.qlve.InputHelper;
import src.controller.qlve.TinhGiaVe;
import src.controller.qlve.Validator;

public class Ve {

    private String maVe;
    private Date ngayDatVe;
    private double giaVe;
    private String maChuyenBay;
    private String maKhachHang;

    @Override
    public String getMa() {
        return maVe;
    }

    // ===== Constructor =====
    public Ve() {
    }

    public Ve(String maVe, java.util.Date ngayDatVe, double giaVe, String maChuyenBay, String maKhachHang) {
        this.maVe = maVe;
        this.ngayDatVe = ngayDatVe;
        this.giaVe = giaVe;
        this.maChuyenBay = maChuyenBay;
        this.maKhachHang = maKhachHang;
    }

    // ===== Getters & Setters =====
    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public Date getNgayDatVe() {
        return ngayDatVe;
    }

    public void setNgayDatVe(Date ngayDatVe) {
        this.ngayDatVe = ngayDatVe;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    @Override
    public String toString() {
        return "Ve{" +
                "maVe='" + maVe + '\'' +
                ", ngayDatVe=" + ngayDatVe +
                ", giaVe=" + giaVe +
                ", maChuyenBay='" + maChuyenBay + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                '}';
    }
}
