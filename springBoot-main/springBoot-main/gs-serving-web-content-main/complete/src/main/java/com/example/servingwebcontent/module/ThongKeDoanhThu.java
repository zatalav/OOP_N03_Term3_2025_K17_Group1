package com.example.servingwebcontent.module;

import java.util.Date;

public class ThongKeDoanhThu {
    private int id;
    private int thang;
    private int nam;
    private String maVe;
    private Date ngayDatVe;
    private double giaVe;
    private double giaVeVip;
    private double giaVeHangNhat;
    private String loaive;

    public ThongKeDoanhThu() {
    }

    public ThongKeDoanhThu(int id, int thang, int nam, String maVe, Date ngayDatVe,
            double giaVe, double giaVeVip, double giaVeHangNhat, String loaive) {
        this.id = id;
        this.thang = thang;
        this.nam = nam;
        this.maVe = maVe;
        this.ngayDatVe = ngayDatVe;
        this.giaVe = giaVe;
        this.giaVeVip = giaVeVip;
        this.giaVeHangNhat = giaVeHangNhat;
        this.loaive = loaive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
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
}
