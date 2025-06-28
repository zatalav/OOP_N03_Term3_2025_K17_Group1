package com.example.servingwebcontent.module;

import java.time.LocalTime;
import java.util.Date;

public class ChuyenBay {
    private String maChuyenBay;
    private String tenChuyenBay;
    private Date ngayGioKhoiHanh;
    private LocalTime thoiGianBay;
    private double giaVe;
    private double giaVeVip;
    private double giaVeHangNhat;
    private int soLuongGhe;
    private int gheVip;
    private int gheHangNhat;
    private int gheThuong;
    private String diemKhoiHanh;
    private String diemDen;
    private String noiQuoc;

    public ChuyenBay() {
    }

    public ChuyenBay(String maChuyenBay, String tenChuyenBay, Date ngayGioKhoiHanh, LocalTime thoiGianBay,
            int soLuongGhe, int gheVip, int gheHangNhat, int gheThuong,
            String diemKhoiHanh, String diemDen, String noiQuoc) {
        this.maChuyenBay = maChuyenBay;
        this.tenChuyenBay = tenChuyenBay;
        this.ngayGioKhoiHanh = ngayGioKhoiHanh;
        this.thoiGianBay = thoiGianBay;
        this.soLuongGhe = soLuongGhe;
        this.gheVip = gheVip;
        this.gheHangNhat = gheHangNhat;
        this.gheThuong = gheThuong;
        this.diemKhoiHanh = diemKhoiHanh;
        this.diemDen = diemDen;
        this.noiQuoc = noiQuoc;
    }

    // Getter & Setter
    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getTenChuyenBay() {
        return tenChuyenBay;
    }

    public void setTenChuyenBay(String tenChuyenBay) {
        this.tenChuyenBay = tenChuyenBay;
    }

    public Date getNgayGioKhoiHanh() {
        return ngayGioKhoiHanh;
    }

    public void setNgayGioKhoiHanh(Date ngayGioKhoiHanh) {
        this.ngayGioKhoiHanh = ngayGioKhoiHanh;
    }

    public LocalTime getThoiGianBay() {
        return thoiGianBay;
    }

    public void setThoiGianBay(LocalTime thoiGianBay) {
        this.thoiGianBay = thoiGianBay;
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

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }

    public int getGheVip() {
        return gheVip;
    }

    public void setGheVip(int gheVip) {
        this.gheVip = gheVip;
    }

    public int getGheHangNhat() {
        return gheHangNhat;
    }

    public void setGheHangNhat(int gheHangNhat) {
        this.gheHangNhat = gheHangNhat;
    }

    public int getGheThuong() {
        return gheThuong;
    }

    public void setGheThuong(int gheThuong) {
        this.gheThuong = gheThuong;
    }

    public String getDiemKhoiHanh() {
        return diemKhoiHanh;
    }

    public void setDiemKhoiHanh(String diemKhoiHanh) {
        this.diemKhoiHanh = diemKhoiHanh;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getNoiQuoc() {
        return noiQuoc;
    }

    public void setNoiQuoc(String noiQuoc) {
        this.noiQuoc = noiQuoc;
    }
}
