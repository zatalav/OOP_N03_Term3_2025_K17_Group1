package src.model;

import java.util.Date;

public class ChuyenBay implements Identifiable {

    private String maChuyenBay;
    private String tenChuyenBay;
    private Date ngayGioKhoiHanh;
    private int soLuongGhe;
    private String diemKhoiHanh;
    private String diemDen;
    private String noiquoc;

    public ChuyenBay() {
    }

    public ChuyenBay(String maChuyenBay, String tenChuyenBay, Date ngayGioKhoiHanh, int soLuongGhe,
            String diemKhoiHanh, String diemDen, String noiquoc) {
        this.maChuyenBay = maChuyenBay;
        this.tenChuyenBay = tenChuyenBay;
        this.ngayGioKhoiHanh = ngayGioKhoiHanh;
        this.soLuongGhe = soLuongGhe;
        this.diemKhoiHanh = diemKhoiHanh;
        this.diemDen = diemDen;
        this.noiquoc = noiquoc;
    }

    @Override
    public String getMa() {
        return maChuyenBay;
    }

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

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
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

    public String toString(){
        return "ChuyenBay{" +
                "maChuyenBay='" + maChuyenBay + '\'' +
                ", tenChuyenBay='" + tenChuyenBay + '\'' +
                ", ngayGioKhoiHanh=" + ngayGioKhoiHanh +
                ", soLuongGhe=" + soLuongGhe +
                ", diemKhoiHanh='" + diemKhoiHanh + '\'' +
                ", diemDen='" + diemDen + '\'' +
                ", noiquoc='" + noiquoc + '\'' +
                '}';
    }
}
