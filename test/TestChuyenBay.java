import java.text.SimpleDateFormat;
import java.util.Date;

public class TestChuyenBay {
    public static void main(String[] args) {
        try {
           
            String maChuyenBay = "VN123";
            String tenChuyenBay = "Hà Nội - TP.HCM";
            String diemKhoiHanh = "Hà Nội";
            String diemDen = "TP.HCM";
            int soLuongGhe = 180;

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date ngayGioKhoiHanh = sdf.parse("20-05-2025 07:00");

            ChuyenBay cb = new ChuyenBay(maChuyenBay, tenChuyenBay, ngayGioKhoiHanh, soLuongGhe, diemKhoiHanh, diemDen);

            cb.hienThiThongTin();
        } catch (Exception e) {
            System.out.println("Test thất bại: Có lỗi xảy ra - " + e.getMessage());
        }
    }
}
