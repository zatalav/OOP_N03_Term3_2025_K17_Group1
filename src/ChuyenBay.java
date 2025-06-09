package src;

import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class ChuyenBay implements Identifiable, Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    @Override
    public String getMa() {
        return maChuyenBay;
    }

    private String maChuyenBay;
    private String tenChuyenBay;
    private Date ngayGioKhoiHanh;
    private int soLuongGhe;
    private String diemKhoiHanh;
    private String diemDen;

    public ChuyenBay() {}

    public ChuyenBay(String maChuyenBay, String tenChuyenBay, Date ngayGioKhoiHanh, int soLuongGhe, String diemKhoiHanh, String diemDen) {
        this.maChuyenBay = maChuyenBay;
        this.tenChuyenBay = tenChuyenBay;
        this.ngayGioKhoiHanh = ngayGioKhoiHanh;
        this.soLuongGhe = soLuongGhe;
        this.diemKhoiHanh = diemKhoiHanh;
        this.diemDen = diemDen;
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

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return String.format(
            "Mã: %-8s | Tên: %-15s | Ngày giờ: %-16s | Ghế trống: %-3d | Điểm đi: %-10s | Điểm đến: %-10s",
            maChuyenBay,
            tenChuyenBay,
            (ngayGioKhoiHanh != null ? sdf.format(ngayGioKhoiHanh) : "N/A"),
            soLuongGhe,
            diemKhoiHanh,
            diemDen
        );
    }

    public void setSoGheTrong(int soGheMoi) {
        this.soLuongGhe = soGheMoi;
    }
}
