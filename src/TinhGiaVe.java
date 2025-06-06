package src;

public class TinhGiaVe {
    public static double tinhTongGiaVe(double giaVeGoc, int soLuongGhe) {
        int soGheThuongGia = Math.min(soLuongGhe, 10);
        int soGheThuong = Math.max(0, soLuongGhe - 10);
        return soGheThuongGia * giaVeGoc * 1.2 + soGheThuong * giaVeGoc;
    }
}
