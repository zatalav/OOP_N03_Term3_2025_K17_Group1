package com.example.servingwebcontent.module;

import java.time.LocalTime;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Ve {
    private String maVe;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayDatVe;

    private LocalTime ThoiGianBay;
    private double giaVe;
    private double giaVeVip;
    private double giaVeHangNhat;
    private String loaive;
    private String maChuyenBay;
    private String maKhachHang;

    public Ve() {
    }

    public Ve(String maVe, Date ngayDatVe, LocalTime ThoiGianBay, double giaVe, double giaVeVip,
            double giaVeHangNhat, String loaive, String maChuyenBay, String maKhachHang) {
        this.maVe = maVe;
        this.ngayDatVe = ngayDatVe;
        this.ThoiGianBay = ThoiGianBay;
        this.giaVe = giaVe;
        this.giaVeVip = giaVeVip;
        this.giaVeHangNhat = giaVeHangNhat;
        this.loaive = loaive;
        this.maChuyenBay = maChuyenBay;
        this.maKhachHang = maKhachHang;
    }

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

    public LocalTime getThoiGianBay() {
        return ThoiGianBay;
    }

    public void setThoiGianBay(LocalTime ThoiGianBay) {
        this.ThoiGianBay = ThoiGianBay;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }

    public double getGiaVeVip() {
        return giaVeVip;
    }

    public void setGiaVeVip(double giaVeVip) {
        this.giaVeVip = giaVeVip;
    }

    public double getGiaVeHangNhat() {
        return giaVeHangNhat;
    }

    public void setGiaVeHangNhat(double giaVeHangNhat) {
        this.giaVeHangNhat = giaVeHangNhat;
    }

    public String getLoaive() {
        return loaive;
    }

    public void setLoaive(String loaive) {
        this.loaive = loaive;
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
}
