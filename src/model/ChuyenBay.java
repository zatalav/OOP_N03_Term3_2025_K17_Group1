package src.model;

import java.util.Date;

public class ChuyenBay implements Identifiable {

    private String maChuyenBay;
    private String tenChuyenBay;
    private Date ngayGioKhoiHanh;
    private int ThoiGianBay;
    private int soLuongGhe;
    private int GheVip;
    private int GheHangNhat;
    private int GheThuong;
    private String diemKhoiHanh;
    private String diemDen;
    private String noiquoc;

    public ChuyenBay() {
    }

    public ChuyenBay(String maChuyenBay, String tenChuyenBay, Date ngayGioKhoiHanh,,int ThoiGianBay, int soLuongGhe, int GheVip,
            int GheHangNhat, int GheThuong, String diemKhoiHanh, String diemDen, String noiquoc) {
        this.maChuyenBay = maChuyenBay;
        this.tenChuyenBay = tenChuyenBay;
        this.ngayGioKhoiHanh = ngayGioKhoiHanh;
        this.ThoiGianBay = ThoiGianBay;
        this.soLuongGhe = soLuongGhe;
        this.GheVip = GheVip;
        this.GheHangNhat = GheHangNhat;
        this.GheThuong = GheThuong;
        this.diemKhoiHanh = diemKhoiHanh;
        this.diemDen = diemDen;
        this.noiquoc = noiquoc;
    }

    @Override
    public String getMa() {
        return maChuyenBay;
    }

    public String getmaChuyenBay() {
        return maChuyenBay;
    }

    public void setmaChuyenBay(String maChuyenBay) {
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

    public int getThoiGianBay(){
        return ThoiGianBay;
    }

    public void setThoiGianBay(int ThoiGianBay){
        this.ThoiGianBay = ThoiGianBay;
    }

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }

    public int getGheVip() {
        return GheVip;
    }

    public void setGheVip(int GheVip) {
        this.GheVip = GheVip;
    }

    public int getGheThuong() {
        return GheThuong;
    }

    public void setGheThuong(int GheThuong) {
        this.GheThuong = GheThuong;
    }

    public int getGheHangNhat() {
        return GheHangNhat;
    }

    public void setGheHangNhat(int GheHangNhat) {
        this.GheHangNhat = GheHangNhat;
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

    public void setSoGheTrong(int soGheMoi) {
        this.soLuongGhe = soGheMoi;
    }

    public String getNoiquoc() {
        return noiquoc;
    }

    public void setNoiquoc(String noiquoc) {
        this.noiquoc = noiquoc;
    }

    public String toString() {
        return "ChuyenBay{" +
                "maChuyenBay='" + maChuyenBay + '\'' +
                ", tenChuyenBay='" + tenChuyenBay + '\'' +
                ", ngayGioKhoiHanh=" + ngayGioKhoiHanh +
                ", soLuongGhe=" + soLuongGhe +
                ", GheVip=" + GheVip +
                ", GheHangNhat=" + GheHangNhat +
                ", GheThuong=" + GheThuong +
                ", diemKhoiHanh='" + diemKhoiHanh + '\'' +
                ", diemDen='" + diemDen + '\'' +
                ", noiquoc='" + noiquoc + '\'' +
                '}';
    }
}
