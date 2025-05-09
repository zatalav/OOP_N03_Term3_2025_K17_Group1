import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_Ve {
    public static void main(String[] args) {
        String maVe = "VE999";
        String tenChuyenBay = "Đà Nẵng - Cần Thơ";
        String ngayGioStr = "09-05-2025 14:30"; 
        String hanhKhach = "Chu Văn An (chuvanan@gmail.com)";
        double giaVe = 1590000;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date ngayGio = sdf.parse(ngayGioStr);

            System.out.println("== THÔNG TIN VÉ ==");
            System.out.println("Mã vé             : " + maVe);
            System.out.println("Hành khách        : " + hanhKhach);
            System.out.println("Chuyến bay        : " + tenChuyenBay + " - " + sdf.format(ngayGio));
            System.out.println("Giá vé            : " + giaVe + " VND");
        } catch (Exception e) {
            System.out.println("Lỗi xử lý ngày giờ.");
        }
    }
}