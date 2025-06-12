package src.controller.qlve;

public class TinhGiaVe {

    public static double tinhTongGiaVe(double giaVeGoc, int soLuongGhe) {
        if (giaVeGoc < 0 || soLuongGhe < 0) {
            throw new IllegalArgumentException("Giá vé và số lượng ghế phải >= 0");
        }

        final int gioiHanGheThuongGia = 10;

        int soGheThuongGia = Math.min(soLuongGhe, gioiHanGheThuongGia);
        int soGheThuong = soLuongGhe - soGheThuongGia;

        double tongGia = (soGheThuongGia * giaVeGoc * 1.2) + // Ghế thương gia
                (soGheThuong * giaVeGoc); // Ghế thường

        return tongGia;
    }
}
