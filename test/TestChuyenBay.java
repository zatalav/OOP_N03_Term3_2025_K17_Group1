import java.text.SimpleDateFormat;
import java.util.Date;

public class TestChuyenBay {
    public static void main(String[] args) {
        try {
            // Tạo dữ liệu mẫu
            String maChuyenBay = "VN123";
            String tenChuyenBay = "Hà Nội - TP.HCM";
            String diemKhoiHanh = "Hà Nội";
            String diemDen = "TP.HCM";
            int soLuongGhe = 180;

            // Chuyển đổi chuỗi thành đối tượng Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date ngayGioKhoiHanh = sdf.parse("20-05-2025 07:00");

            // Tạo đối tượng chuyến bay
            ChuyenBay cb = new ChuyenBay(maChuyenBay, tenChuyenBay, ngayGioKhoiHanh, soLuongGhe, diemKhoiHanh, diemDen);

            // Hiển thị thông tin để kiểm tra
            cb.hienThiThongTin();
        } catch (Exception e) {
            System.out.println("Test thất bại: Có lỗi xảy ra - " + e.getMessage());
        }
    }
}
