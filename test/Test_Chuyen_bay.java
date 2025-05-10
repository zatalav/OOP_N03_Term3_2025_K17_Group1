package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_Chuyen_bay {
    public static void main(String[] args) {
        String maChuyenBay = "VN456";
        String tenChuyenBay = "Hà Nội - Nha Trang";
        String diemKhoiHanh = "Hà Nội";
        String diemDen = "Nha Trang";
        String ngayGioStr = "10-05-2025 10:00";
        int soLuongGhe = 120;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date ngayGio = sdf.parse(ngayGioStr);

            System.out.println("== THÔNG TIN CHUYẾN BAY ==");
            System.out.println("Mã chuyến bay      : " + maChuyenBay);
            System.out.println("Tên chuyến bay     : " + tenChuyenBay);
            System.out.println("Điểm khởi hành     : " + diemKhoiHanh);
            System.out.println("Điểm đến           : " + diemDen);
            System.out.println("Thời gian khởi hành: " + sdf.format(ngayGio));
            System.out.println("Số lượng ghế       : " + soLuongGhe);
        } catch (Exception e) {
            System.out.println("Lỗi xử lý ngày giờ.");
        }
    }
}
