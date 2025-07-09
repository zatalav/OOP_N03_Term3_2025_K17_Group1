package com.example.servingwebcontent.module;

public class ThongKeDoanhThu {
    private int thang;
    private int nam;
    private double tongTien;

    public ThongKeDoanhThu() {
    }

    public ThongKeDoanhThu(int thang, int nam, double tongTien) {
        this.thang = thang;
        this.nam = nam;
        this.tongTien = tongTien;
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

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
}
