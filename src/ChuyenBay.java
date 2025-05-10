package src;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class MaChuyenBay {
    public static boolean kiemTraMaHopLe(String ma) {
        return ma.matches("^[A-Z]{2}\\d{3,4}$");
    }
}

class TenChuyenBay {
    public static String nhapTenChuyenBay(Scanner scanner) {
        System.out.print("Nhập tên chuyến bay: ");
        return scanner.nextLine();
    }
}

class SoLuongGhe {
    public static int nhapSoLuongGhe(Scanner scanner) {
        System.out.print("Nhập số lượng ghế: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}

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

public class ChuyenBay {
    private String maChuyenBay;
    private String tenChuyenBay;
    private Date ngayGioKhoiHanh;
    private int soLuongGhe;
    private String diemKhoiHanh;
    private String diemDen;

    public ChuyenBay(String maChuyenBay, String tenChuyenBay, Date ngayGioKhoiHanh, int soLuongGhe, String diemKhoiHanh, String diemDen) {
        this.maChuyenBay = maChuyenBay;
        this.tenChuyenBay = tenChuyenBay;
        this.ngayGioKhoiHanh = ngayGioKhoiHanh;
        this.soLuongGhe = soLuongGhe;
        this.diemKhoiHanh = diemKhoiHanh;
        this.diemDen = diemDen;
    }

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

        String tenChuyenBay = TenChuyenBay.nhapTenChuyenBay(scanner);

        Date ngayGioKhoiHanh = NgayGioKhoiHanh.nhapNgayGioKhoiHanh(scanner);

        int soLuongGhe;
        while (true) {
            soLuongGhe = SoLuongGhe.nhapSoLuongGhe(scanner);
            if (soLuongGhe > 0) {
                break;
            } else {
                System.out.println("Số lượng ghế phải lớn hơn 0. Vui lòng nhập lại.");
            }
        }
        scanner.nextLine(); 
        
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

        ChuyenBay chuyenBay = new ChuyenBay(maChuyenBay, tenChuyenBay, ngayGioKhoiHanh, soLuongGhe, diemKhoiHanh, diemDen);

        chuyenBay.hienThiThongTin();

        scanner.close();
    }
}