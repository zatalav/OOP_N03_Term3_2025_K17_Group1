package src;

import java.util.Scanner;
import java.util.regex.Pattern;

class MaKhachHang {
    public static boolean kiemTraMaHopLe(String ma) {
        // Mã khách hàng có thể là KH123 hoặc KH00123, KHAB123
        return ma.matches("^KH\\w{3,}$");
    }
}

class nhap_thong_tin_khach_hang {
    public static String nhapHoTen(Scanner scanner) {
        System.out.print("Nhập họ tên khách hàng: ");
        return scanner.nextLine();
    }

    public static String nhapEmail(Scanner scanner) {
        System.out.print("Nhập email: ");
        while (true) {
            String email = scanner.nextLine();
            if (kiemTraEmail(email)) return email;
            System.out.print("Email không hợp lệ. Nhập lại: ");
        }
    }

    public static String nhapSoDienThoai(Scanner scanner) {
        System.out.print("Nhập số điện thoại: ");
        while (true) {
            String sdt = scanner.nextLine();
            if (kiemTraSoDienThoai(sdt)) return sdt;
            System.out.print("SĐT không hợp lệ. Nhập lại: ");
        }
    }

    private static boolean kiemTraEmail(String email) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }

    private static boolean kiemTraSoDienThoai(String sdt) {
        return sdt.matches("^0\\d{9}$"); // ví dụ: 0987654321
    }
}

public class KhachHang {
    private String maKhachHang;
    private String hoTen;
    private String email;
    private String soDienThoai;

    public KhachHang() {}

    public KhachHang(String ma, String ten, String email, String sdt) {
        this.maKhachHang = ma;
        this.hoTen = ten;
        this.email = email;
        this.soDienThoai = sdt;
    }

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập mã khách hàng (VD: KH001): ");
            maKhachHang = scanner.nextLine();
            if (MaKhachHang.kiemTraMaHopLe(maKhachHang)) break;
            System.out.println("Mã khách hàng không hợp lệ. Vui lòng nhập lại.");
        }

        hoTen = nhap_thong_tin_khach_hang.nhapHoTen(scanner);
        email = nhap_thong_tin_khach_hang.nhapEmail(scanner);
        soDienThoai = nhap_thong_tin_khach_hang.nhapSoDienThoai(scanner);
    }

    public void hienThiThongTin() {
        System.out.println("\n=============== THÔNG TIN KHÁCH HÀNG ===============");
        System.out.printf("| %-20s | %-30s |\n", "Mã khách hàng", maKhachHang);
        System.out.printf("| %-20s | %-30s |\n", "Họ tên", hoTen);
        System.out.printf("| %-20s | %-30s |\n", "Email", email);
        System.out.printf("| %-20s | %-30s |\n", "Số điện thoại", soDienThoai);
        System.out.println("====================================================");
    }
}
