import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test_Ve {

    public static void hienThiThongTinVe(String maVe, String tenChuyenBay, String ngayGioStr, String hanhKhach,
            double giaVe) {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

            NumberFormat currencyFormat = NumberFormat.getInstance(new Locale("vi", "VN"));

            Date ngayGio = sdf.parse(ngayGioStr);

            System.out.println("=========== THÔNG TIN VÉ ===========");
            System.out.printf("%-20s: %s\n", "Mã vé", maVe);
            System.out.printf("%-20s: %s\n", "Hành khách", hanhKhach);
            System.out.printf("%-20s: %s\n", "Chuyến bay", tenChuyenBay);
            System.out.printf("%-20s: %s\n", "Ngày giờ khởi hành", sdf.format(ngayGio));
            System.out.printf("%-20s: %s VND\n", "Giá vé", currencyFormat.format(giaVe));
            System.out.println("====================================");

        } catch (Exception e) {
            System.out.println("Lỗi xử lý ngày giờ: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String maVe = "VE999";
        String tenChuyenBay = "Đà Nẵng - Cần Thơ";
        String ngayGioStr = "09/05/2025 14:30";
        String hanhKhach = "Chu Văn An (chuvanan@gmail.com)";
        double giaVe = 3_000_000;

        hienThiThongTinVe(maVe, tenChuyenBay, ngayGioStr, hanhKhach, giaVe);
    }
}
