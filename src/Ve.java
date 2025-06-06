package src;

import src.TinhGiaVe;
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

public class Ve {
    private String maVe;
    private String tenHanhKhach;
    private Date ngayDatVe;
    private double giaVe;
    private ChuyenBay chuyenBay;
    private double giaGoc;
    private int soLuongGhe;

    public Ve() {}

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getTenHanhKhach() {
        return tenHanhKhach;
    }

    public void setTenHanhKhach(String tenHanhKhach) {
        this.tenHanhKhach = tenHanhKhach;
    }

    public Date getNgayDatVe() {
        return ngayDatVe;
    }

    public void setNgayDatVe(Date ngayDatVe) {
        this.ngayDatVe = ngayDatVe;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }

    public double getGiaGoc() {
        return giaGoc;
    }

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public ChuyenBay getChuyenBay() {
        return chuyenBay;
    }

    public void setChuyenBay(ChuyenBay chuyenBay) {
        this.chuyenBay = chuyenBay;
    }

    // ✅ Sửa: Thêm Scanner và QuanLyChuyenBay để nhập đúng liên kết
    public void nhapThongTin(Scanner scanner, QuanLyChuyenBay qlChuyenBay) {
        while (true) {
            System.out.print("Nhập mã vé (VD: VE12345): ");
            maVe = scanner.nextLine();
            if (MaVe.kiemTraMaHopLe(maVe)) break;
            System.out.println("Mã vé không hợp lệ. Vui lòng nhập lại.");
        }

        tenHanhKhach = nhap_thong_tin_ve.nhapTenHanhKhach(scanner);
        ngayDatVe = nhap_thong_tin_ve.nhapNgayDatVe(scanner);

        // ✅ Nhập mã chuyến bay và tìm chuyến bay tương ứng
        while (true) {
            System.out.print("Nhập mã chuyến bay: ");
            String maChuyenBay = scanner.nextLine();
            chuyenBay = qlChuyenBay.timTheoMa(maChuyenBay);
            if (chuyenBay != null) break;
            System.out.println("Không tìm thấy chuyến bay. Vui lòng nhập lại.");
        }

        // ✅ Nhập giá gốc
        System.out.print("Nhập giá gốc cho 1 ghế: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Vui lòng nhập số hợp lệ.");
            scanner.next();
        }
        giaGoc = scanner.nextDouble();

        // ✅ Nhập số lượng ghế
        System.out.print("Nhập số lượng ghế cần đặt: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            scanner.next();
        }
        soLuongGhe = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        giaVe = TinhGiaVe.tinhTongGiaVe(giaGoc, soLuongGhe);
    }

    public void hienThiThongTin() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("\n=================== THÔNG TIN VÉ ===================");
        System.out.printf("| %-20s | %-30s |\n", "Mã vé", maVe);
        System.out.printf("| %-20s | %-30s |\n", "Tên hành khách", tenHanhKhach);
        System.out.printf("| %-20s | %-30s |\n", "Ngày đặt vé", sdf.format(ngayDatVe));
        System.out.printf("| %-20s | %-30.2f |\n", "Giá gốc mỗi ghế", giaGoc);
        System.out.printf("| %-20s | %-30d |\n", "Số lượng ghế", soLuongGhe);
        System.out.printf("| %-20s | %-30.2f |\n", "Tổng giá vé", giaVe);

        if (chuyenBay != null) {
            System.out.println("--------------- THÔNG TIN CHUYẾN BAY ---------------");
            System.out.printf("| %-20s | %-30s |\n", "Tên chuyến bay", chuyenBay.getTenChuyenBay());
            System.out.printf("| %-20s | %-30s |\n", "Khởi hành", chuyenBay.getDiemKhoiHanh());
            System.out.printf("| %-20s | %-30s |\n", "Điểm đến", chuyenBay.getDiemDen());
        } else {
            System.out.println("❗ Không có thông tin chuyến bay.");
        }

        System.out.println("====================================================");
    }
}
