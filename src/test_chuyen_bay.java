import java.text.SimpleDateFormat;
import java.util.Date;

public class test_chuyen_bay {
    public static void main(String[] args) {
        // Dữ liệu mẫu
        String maChuyenBay = "VN123";
        String tenChuyenBay = "Hà Nội - TP.HCM";
        String ngayGioStr = "15-05-2025 08:30";
        int soLuongGhe = 180;

        // In ra kết quả
        System.out.println("Test thành công:");
        System.out.println("Mã chuyến bay: " + maChuyenBay);
        System.out.println("Tên chuyến bay: " + tenChuyenBay);
        System.out.println("Ngày giờ khởi hành: " + new SimpleDateFormat("dd-MM-yyyy HH:mm"));
        System.out.println("Số lượng ghế: " + soLuongGhe);
    }
}