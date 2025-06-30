package src.model;

import java.util.Date;

public class Ve implements Identifiable {
    private String maVe;
    private Date ngayDatVe;
    private int ThoiGianBay;
    private double giaVe;
    private double giaVeVip;
    private double giaVeHangNhat;
    private String loaive;
    private String maChuyenBay;
    private String maKhachHang;


    @Override
    public String getMa() {
        return maVe;
    }

    public Ve() {
    }

    public Ve(String maVe, java.util.Date ngayDatVe,int ThoiGianBay, double giaVe,double giaVeVip, double giaVeHangNhat, String loaive, String maChuyenBay, String maKhachHang) {
        this.maVe = maVe;
        this.ngayDatVe = ngayDatVe;
        this.ThoiGianBay= ThoiGianBay;
        this.giaVe = giaVe;
        this.giaVeVip = giaVeVip;
        this.giaVeHangNhat= giaVeHangNhat;
        this.loaive=loaive;
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

    public int getThoiGianBay(){
        return ThoiGianBay;
    }

    public void setThoiGianBay(int ThoiGianBay){
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

    public String getloaive() {
        return loaive;
    }
    public void setloaive(String loaive) {
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

    @Override
    public String toString() {
        return "Ve{" +
                "maVe='" + maVe + '\'' +
                ", ngayDatVe=" + ngayDatVe +
                ", giaVe=" + giaVe +
                ", giaVeVip=" + giaVeVip +
                ", maChuyenBay='" + maChuyenBay + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                '}';
    }
}
