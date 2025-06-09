
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestKhachHang {
    public static void main(String[] args) {
        String maKH = "KH001";
        String hoTen = "Chu Văn An";
        String email = "chuvanan@gmail.com";
        String soDienThoai = "0123456789";
        String ngayDangKyStr = "23/05/2025";

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date ngayDangKy = sdf.parse(ngayDangKyStr);

            System.out.println("== THÔNG TIN KHÁCH HÀNG ==");
            System.out.println("Mã khách hàng     : " + maKH);
            System.out.println("Họ tên            : " + hoTen);
            System.out.println("Email             : " + email);
            System.out.println("Số điện thoại     : " + soDienThoai);
            System.out.println("Ngày đăng ký      : " + sdf.format(ngayDangKy));
        } catch (Exception e) {
            System.out.println(" Lỗi xử lý ngày.");
        }
    }
}
