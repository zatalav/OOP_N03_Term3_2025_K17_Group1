package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ve {
    private String maVe;
    private String tenHanhKhach;
    private Date ngayDatVe;
    private double giaVe;
    private ChuyenBay chuyenBay;
    private double giaGoc;
    private int soLuongGhe;

    public Ve() {
    }

    // ===== Getter & Setter =====
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

    // ===== Nhập thông tin vé =====
    public void nhapThongTin(Scanner scanner, QuanLyChuyenBay qlChuyenBay) {
        // Nhập mã vé hợp lệ
        while (true) {
            System.out.print("Nhập mã vé (VD: VE12345): ");
            maVe = scanner.nextLine();
            if (MaVe.kiemTraMaHopLe(maVe))
                break;
            System.out.println("Mã vé không hợp lệ. Vui lòng nhập lại.");
        }

        // Nhập tên hành khách và ngày đặt
        tenHanhKhach = NhapThongTinVe.nhapTenHanhKhach(scanner);
        ngayDatVe = NhapThongTinVe.nhapNgayDatVe(scanner);

        // Nhập mã chuyến bay liên kết
        while (true) {
            System.out.print("Nhập mã chuyến bay: ");
            String maChuyenBay = scanner.nextLine();
            chuyenBay = qlChuyenBay.timTheoMa(maChuyenBay);
            if (chuyenBay != null)
                break;
            System.out.println("Không tìm thấy chuyến bay. Vui lòng nhập lại.");
        }

        // Nhập giá gốc
        while (true) {
            System.out.print("Nhập giá gốc cho 1 ghế: ");
            try {
                giaGoc = Double.parseDouble(scanner.nextLine());
                if (giaGoc >= 0)
                    break;
                else
                    System.out.println("Giá gốc phải >= 0.");
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng. Vui lòng nhập lại.");
            }
        }

        // Nhập số lượng ghế
        while (true) {
            System.out.print("Nhập số lượng ghế cần đặt: ");
            try {
                soLuongGhe = Integer.parseInt(scanner.nextLine());
                if (soLuongGhe > 0)
                    break;
                else
                    System.out.println("Số lượng ghế phải > 0.");
            } catch (NumberFormatException e) {
                System.out.println("Sai định dạng. Vui lòng nhập số nguyên.");
            }
        }

        // Tính tổng giá
        giaVe = TinhGiaVe.tinhTongGiaVe(giaGoc, soLuongGhe);
    }

    // ===== Hiển thị vé =====
    public void hienThiThongTin() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("\n=================== THÔNG TIN VÉ ===================");
        System.out.printf("| %-20s : %-30s |\n", "Mã vé", maVe);
        System.out.printf("| %-20s : %-30s |\n", "Tên hành khách", tenHanhKhach);
        System.out.printf("| %-20s : %-30s |\n", "Ngày đặt vé", sdf.format(ngayDatVe));
        System.out.printf("| %-20s : %-30.2f |\n", "Giá gốc mỗi ghế", giaGoc);
        System.out.printf("| %-20s : %-30d |\n", "Số lượng ghế", soLuongGhe);
        System.out.printf("| %-20s : %-30.2f |\n", "Tổng giá vé", giaVe);

        if (chuyenBay != null) {
            System.out.println("--------------- THÔNG TIN CHUYẾN BAY ---------------");
            System.out.printf("| %-20s : %-30s |\n", "Tên chuyến bay", chuyenBay.getTenChuyenBay());
            System.out.printf("| %-20s : %-30s |\n", "Khởi hành", chuyenBay.getDiemKhoiHanh());
            System.out.printf("| %-20s : %-30s |\n", "Điểm đến", chuyenBay.getDiemDen());
        } else {
            System.out.println("Không có thông tin chuyến bay.");
        }
        System.out.println("====================================================");
    }

    // ===== Class hỗ trợ kiểm tra mã vé =====
    public static class MaVe {
        public static boolean kiemTraMaHopLe(String ma) {
            return ma.matches("^[A-Z]{2}\\d{5}$");
        }
    }

    // ===== Class hỗ trợ nhập thông tin vé =====
    public static class NhapThongTinVe {
        public static String nhapTenHanhKhach(Scanner scanner) {
            System.out.print("Nhập tên hành khách: ");
            return scanner.nextLine();
        }

        public static Date nhapNgayDatVe(Scanner scanner) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            while (true) {
                System.out.print("Nhập ngày đặt vé (dd/MM/yyyy): ");
                try {
                    return sdf.parse(scanner.nextLine());
                } catch (ParseException e) {
                    System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập lại.");
                }
            }
        }
    }
}
