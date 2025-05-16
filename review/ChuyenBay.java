
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Lớp hỗ trợ kiểm tra mã chuyến bay
class MaChuyenBay {
    public static boolean kiemTraMaHopLe(String ma) {
        return ma.matches("^[A-Z]{2}\\d{3,4}$");
    }
}

// Lớp hỗ trợ nhập tên chuyến bay
class TenChuyenBay {
    public static String nhapTenChuyenBay(Scanner scanner) {
        System.out.print("Nhập tên chuyến bay: ");
        return scanner.nextLine();
    }
}

// Lớp hỗ trợ nhập số lượng ghế
class SoLuongGhe {
    public static int nhapSoLuongGhe(Scanner scanner) {
        System.out.print("Nhập số lượng ghế: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            scanner.next(); // Bỏ qua giá trị không hợp lệ
        }
        return scanner.nextInt();
    }
}

// Lớp hỗ trợ nhập ngày giờ khởi hành
class NgayGioKhoiHanh {
    public static Date nhapNgayGioKhoiHanh(Scanner scanner) {
        System.out.print("Nhập ngày giờ khởi hành (dd-MM-yyyy HH:mm): ");
        while (true) {
            String ngayGioKhoiHanhStr = scanner.nextLine();
            Date ngayGioKhoiHanh = parseDate(ngayGioKhoiHanhStr);
            if (ngayGioKhoiHanh != null) {
                return ngayGioKhoiHanh;
            } else {
                System.out.println("Định dạng ngày giờ không hợp lệ. Vui lòng nhập lại (dd-MM-yyyy HH:mm): ");
            }
        }
    }

    private static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        sdf.setLenient(false);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }
}

// Lớp chính quản lý chuyến bay
public class ChuyenBay {
    private String maChuyenBay;
    private String tenChuyenBay;
    private Date ngayGioKhoiHanh;
    private int soLuongGhe;
    private String diemKhoiHanh;
    private String diemDen;

    // Constructor
    public ChuyenBay(String maChuyenBay, String tenChuyenBay, Date ngayGioKhoiHanh, int soLuongGhe, String diemKhoiHanh, String diemDen) {
        this.maChuyenBay = maChuyenBay;
        this.tenChuyenBay = tenChuyenBay;
        this.ngayGioKhoiHanh = ngayGioKhoiHanh;
        this.soLuongGhe = soLuongGhe;
        this.diemKhoiHanh = diemKhoiHanh;
        this.diemDen = diemDen;
    }

    // Phương thức hiển thị thông tin chuyến bay
    public void hienThiThongTin() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        System.out.println("\n================= THÔNG TIN CHUYẾN BAY =================");
        System.out.printf("| %-20s | %-30s |\n", "Mã chuyến bay", maChuyenBay);
        System.out.printf("| %-20s | %-30s |\n", "Tên chuyến bay", tenChuyenBay);
        System.out.printf("| %-20s | %-30s |\n", "Ngày giờ khởi hành", sdf.format(ngayGioKhoiHanh));
        System.out.printf("| %-20s | %-30d |\n", "Số lượng ghế", soLuongGhe);
        System.out.printf("| %-20s | %-30s |\n", "Điểm khởi hành", diemKhoiHanh);
        System.out.printf("| %-20s | %-30s |\n", "Điểm đến", diemDen);
        System.out.println("========================================================");
    }

    // Phương thức main để chạy chương trình
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập mã chuyến bay
        String maChuyenBay;
        while (true) {
            System.out.print("Nhập mã chuyến bay (VD: VN123): ");
            maChuyenBay = scanner.nextLine();
            if (MaChuyenBay.kiemTraMaHopLe(maChuyenBay)) {
                break;
            } else {
                System.out.println("Mã chuyến bay không hợp lệ. Vui lòng nhập lại.");
            }
        }

        // Nhập tên chuyến bay
        String tenChuyenBay = TenChuyenBay.nhapTenChuyenBay(scanner);

        // Nhập ngày giờ khởi hành
        Date ngayGioKhoiHanh = NgayGioKhoiHanh.nhapNgayGioKhoiHanh(scanner);

        // Nhập số lượng ghế
        int soLuongGhe;
        while (true) {
            soLuongGhe = SoLuongGhe.nhapSoLuongGhe(scanner);
            if (soLuongGhe > 0) {
                break;
            } else {
                System.out.println("Số lượng ghế phải lớn hơn 0. Vui lòng nhập lại.");
            }
        }
        scanner.nextLine(); // Bỏ qua ký tự xuống dòng sau khi nhập số

        // Nhập điểm khởi hành
        String diemKhoiHanh;
        while (true) {
            System.out.print("Nhập điểm khởi hành: ");
            diemKhoiHanh = scanner.nextLine();
            if (!diemKhoiHanh.isEmpty()) {
                break;
            } else {
                System.out.println("Điểm khởi hành không được để trống. Vui lòng nhập lại.");
            }
        }

        // Nhập điểm đến
        String diemDen;
        while (true) {
            System.out.print("Nhập điểm đến: ");
            diemDen = scanner.nextLine();
            if (!diemDen.isEmpty()) {
                break;
            } else {
                System.out.println("Điểm đến không được để trống. Vui lòng nhập lại.");
            }
        }

        // Tạo đối tượng chuyến bay
        ChuyenBay chuyenBay = new ChuyenBay(maChuyenBay, tenChuyenBay, ngayGioKhoiHanh, soLuongGhe, diemKhoiHanh, diemDen);

        // Hiển thị thông tin chuyến bay
        chuyenBay.hienThiThongTin();

        scanner.close();
    }
}