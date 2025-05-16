package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class MaVe {
    public static boolean kiemTraMaHopLe(String ma) {
        return ma.matches("^[A-Z]{2}\\d{5}$"); 
    }
}

class nhap_thong_tin_ve {
    public static String nhapTenHanhKhach(Scanner scanner) {
        System.out.print("Nhập tên hành khách: ");
        return scanner.nextLine();
    }

    public static Date nhapNgayDatVe(Scanner scanner) {
        System.out.print("Nhập ngày đặt vé (dd-MM-yyyy): ");
        while (true) {
            String ngayStr = scanner.nextLine();
            Date ngay = parseDate(ngayStr);
            if (ngay != null) {
                return ngay;
            } else {
                System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập lại (dd-MM-yyyy): ");
            }
        }
    }

    public static double nhapGiaVe(Scanner scanner) {
        System.out.print("Nhập giá vé: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Vui lòng nhập số hợp lệ.");
            scanner.next(); 
        }
        double gia = scanner.nextDouble();
        scanner.nextLine(); 
        return gia;
    }

    private static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }
}

class Ve {
    private String maVe;
    private String tenHanhKhach;
    private Date ngayDatVe;
    private double giaVe;

    public Ve() {}

    public Ve(String maVe, String tenHanhKhach, Date ngayDatVe, double giaVe) {
        this.maVe = maVe;
        this.tenHanhKhach = tenHanhKhach;
        this.ngayDatVe = ngayDatVe;
        this.giaVe = giaVe;
    }

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập mã vé (VD: VE12345): ");
            maVe = scanner.nextLine();
            if (MaVe.kiemTraMaHopLe(maVe)) break;
            System.out.println("Mã vé không hợp lệ. Vui lòng nhập lại.");
        }

        tenHanhKhach = nhap_thong_tin_ve.nhapTenHanhKhach(scanner);
        ngayDatVe = nhap_thong_tin_ve.nhapNgayDatVe(scanner);
        giaVe = nhap_thong_tin_ve.nhapGiaVe(scanner);
    }

    public void hienThiThongTin() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("\n=================== THÔNG TIN VÉ ===================");
        System.out.printf("| %-20s | %-30s |\n", "Mã vé", maVe);
        System.out.printf("| %-20s | %-30s |\n", "Tên hành khách", tenHanhKhach);
        System.out.printf("| %-20s | %-30s |\n", "Ngày đặt vé", sdf.format(ngayDatVe));
        System.out.printf("| %-20s | %-30.2f |\n", "Giá vé", giaVe);
        System.out.println("====================================================");
    }
}
