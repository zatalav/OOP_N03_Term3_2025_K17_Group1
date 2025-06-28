package com.example.servingwebcontent.module;

public class ThongKeDoanhThu {
    private int thang;
    private int nam;
    private double tongDoanhThu;

    public ThongKeDoanhThu() {
    }

    public ThongKeDoanhThu(int thang, int nam, double tongDoanhThu) {
        this.thang = thang;
        this.nam = nam;
        this.tongDoanhThu = tongDoanhThu;
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

    public double getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(double tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }
}
