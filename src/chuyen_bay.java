import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class chuyen_bay {
    private String maChuyenBay;
    private String tenChuyenBay;
    private Date ngayGioKhoiHanh;
    private int soLuongGhe;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập mã chuyến bay
        System.out.print("Nhập mã chuyến bay (VD: VN123): ");
        String maChuyenBay = scanner.nextLine();
        if (!kiemTraMaHopLe(maChuyenBay)) {
            System.out.println("Mã chuyến bay không hợp lệ.");
            return;
        }

        // Nhập tên chuyến bay
        System.out.print("Nhập tên chuyến bay: ");
        String tenChuyenBay = scanner.nextLine();

        // Nhập ngày giờ khởi hành
        System.out.print("Nhập ngày giờ khởi hành (dd-MM-yyyy HH:mm): ");
        Date ngayGioKhoiHanh = null;
        while (true) {
            String ngayGioKhoiHanhStr = scanner.nextLine();
            ngayGioKhoiHanh = parseDate(ngayGioKhoiHanhStr);
            if (ngayGioKhoiHanh != null) {
                break;
            } else {
                System.out.println("Định dạng ngày giờ không hợp lệ. Vui lòng nhập lại (dd-MM-yyyy HH:mm): ");
            }
        }

        // Nhập số lượng ghế
        System.out.print("Nhập số lượng ghế: ");
        int soLuongGhe = scanner.nextInt();

        // Hiển thị thông tin chuyến bay
        System.out.println("\nThông tin chuyến bay:");
        System.out.println("Mã chuyến bay: " + maChuyenBay);
        System.out.println("Tên chuyến bay: " + tenChuyenBay);
        System.out.println("Ngày giờ khởi hành: " + ngayGioKhoiHanh);
        System.out.println("Số lượng ghế: " + soLuongGhe);

        scanner.close();
    }

    // Phương thức kiểm tra mã hợp lệ
    private static boolean kiemTraMaHopLe(String ma) {
        return ma.matches("^[A-Z]{2}\\d{3,4}$");
    }

    // Phương thức parseDate để chuyển chuỗi thành đối tượng Date
    private static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        sdf.setLenient(false); // Không cho phép định dạng sai
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null; // Trả về null nếu định dạng không hợp lệ
        }
    }
}